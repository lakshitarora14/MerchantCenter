package com.bookstore.catalog.service.impl;

import com.bookstore.catalog.entity.Catalog;
import com.bookstore.catalog.repository.CatalogRepository;
import com.bookstore.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogRepository catalogRepository;

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findByProductCode(String prodctCode) {
        return catalogRepository.findById(prodctCode);
    }

    @Override
    public void deleteAll() {
        catalogRepository.deleteAll();
    }

    @Override
    public void delete(String productCode) {
        catalogRepository.deleteById(productCode);
    }

    @Override
    public long count() {
        return catalogRepository.count();
    }

    @Override
    public Catalog insertData(Catalog catalog) {
        return catalogRepository.save(catalog);
    }
}


