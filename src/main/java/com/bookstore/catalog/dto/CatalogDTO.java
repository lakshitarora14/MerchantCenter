package com.bookstore.catalog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CatalogDTO {
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
