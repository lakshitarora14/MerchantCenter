package com.bookstore.catalog.service;

import com.bookstore.catalog.entity.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogService {
    List<Catalog> findAll();

    Optional<Catalog> findByProductCode(String prodctCode);

    void deleteAll();

    void delete(String productCode);

    long count();

    Catalog insertData(Catalog catalog);
}
