package com.bookstore.catalog.repository;

import com.bookstore.catalog.entity.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog,String> {
}
