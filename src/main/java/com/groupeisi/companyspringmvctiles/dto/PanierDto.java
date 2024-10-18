package com.groupeisi.companyspringmvctiles.dto;

import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class PanierDto {
    private long id;
    private Date date;
    private ClientDto client;
    private List<ProductDto> products;

    public PanierDto(long id, Date date, ClientDto client, List<ProductDto> products) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
    }
    public PanierDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
