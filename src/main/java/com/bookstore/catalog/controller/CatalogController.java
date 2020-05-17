package com.bookstore.catalog.controller;

import com.bookstore.catalog.dto.CatalogDTO;
import com.bookstore.catalog.entity.Catalog;
import com.bookstore.catalog.service.CatalogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CatalogDTO>> addProduct(){
        List<Catalog> catalogList = catalogService.findAll();
        List<CatalogDTO> catalogDTOList = new ArrayList<>();
        for(Catalog catalog:catalogList){
            CatalogDTO catalogDTO = new CatalogDTO();
            BeanUtils.copyProperties(catalog,catalogDTO);
            catalogDTOList.add(catalogDTO);
        }
        return new ResponseEntity<List<CatalogDTO>>(catalogDTOList,HttpStatus.OK);
    }
    @GetMapping( value = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(catalogService.count(), HttpStatus.OK);
    }

    @GetMapping( value = "/getProduct/{productCode}")
    public ResponseEntity<?> getProduct(@PathVariable("productCode") String productCode) {
        Optional<Catalog> catalog = catalogService.findByProductCode(productCode);
        CatalogDTO catalogDTO = new CatalogDTO();

        if (catalog.isPresent()) {
            BeanUtils.copyProperties(catalog.get(), catalogDTO);
            return new ResponseEntity<CatalogDTO>(catalogDTO, HttpStatus.OK);
        }

        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    @DeleteMapping( value = "/delete/{productCode}")
    public ResponseEntity<Boolean> delete(@PathVariable("productCode") String productCode) {
        catalogService.delete(productCode);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity<Boolean> deleteAll() {
        catalogService.deleteAll();
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody CatalogDTO catalogDTO){
        Catalog catalog = new Catalog();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        catalogDTO.setDateAdded(now);
        String productCode = UUID.randomUUID().toString();
        catalogDTO.setProductCode(productCode);
        BeanUtils.copyProperties(catalogDTO,catalog);
        Catalog catalogCreated = catalogService.insertData(catalog);
        return new ResponseEntity<>(catalogCreated.getProductCode(),HttpStatus.OK);
    }

    //give product code in the json in this API
    @PostMapping("/update")
    public ResponseEntity<String> updateProductDetails(@RequestBody CatalogDTO catalogDTO){
        Catalog catalog = new Catalog();
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        catalogDTO.setDateAdded(now);
        BeanUtils.copyProperties(catalogDTO,catalog);
        Catalog catalogCreated = catalogService.insertData(catalog);
        return new ResponseEntity<>(catalogCreated.getProductCode(),HttpStatus.OK);
    }


}
