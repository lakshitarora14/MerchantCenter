package com.bookstore.catalog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = Catalog.COLLECTION_NAME)
public class Catalog {
    public static final String COLLECTION_NAME="catalog";

    @Id
    private String productCode;
    private String productName;
    private String productDescription;
    private String category;
    private String genre;
    private String year;
    private String noOfPages;
    private String merchantName;
    private Date dateAdded;
    private String stockSize;

}
