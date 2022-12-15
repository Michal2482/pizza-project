package com.example.pizzaproject.service;


import com.example.pizzaproject.config.StorageProperties;
import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.exceptions.StorageException;
import com.example.pizzaproject.exceptions.StorageFileNotFoundException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.AdvertRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final CompanyRepository companyRepository;

    private final Path rootLocation;

    public AdvertService(AdvertRepository advertRepository, CompanyRepository companyRepository, StorageProperties properties) {
        this.advertRepository = advertRepository;
        this.companyRepository = companyRepository;
        this.rootLocation = Paths.get(properties.getLocation());
    }

    public void addAdvert(Advert advert, String prefix, String fileName) {
        advert.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(() -> new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID + prefix)));
        advert.setPhotoAdvert(fileName);
        advertRepository.save(advert);
    }

    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return destinationFile.toString();
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    public List<Advert> getAdverts(String prefix) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(() -> new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID + prefix));
        return advertRepository.findAllByCompanyId(companyInDatabase.getId());
    }


    public Advert getAdvert(Long id) {
        return advertRepository.findById(id).orElse(null);
    }

    public void deleteAdvert(Long id) {
        advertRepository.deleteById(id);
    }


    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResourceByAdvId(Long id) {
        String filename = advertRepository.findById(id).map(Advert::getPhotoAdvert).orElseThrow();
        return loadAsResource(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Transactional
    public void editAdvert(Advert editedAdvert, String prefix, MultipartFile file) {
        Advert storedAdvert = advertRepository
                .findById(editedAdvert.getId())
                .orElseThrow(() -> new RuntimeException("cannot modify not existing element"));

        String path = Optional.ofNullable(file).map(
                x -> {
                    store(file);
                    return file.getOriginalFilename();
                }
        ).orElseGet(storedAdvert::getPhotoAdvert);
        storedAdvert.setDescriptionProductAdvert(editedAdvert.getDescriptionProductAdvert());
        storedAdvert.setProductAdvertName(editedAdvert.getProductAdvertName());
        storedAdvert.setSlogan(editedAdvert.getSlogan());
        storedAdvert.setPhotoAdvert(path);
    }
}


