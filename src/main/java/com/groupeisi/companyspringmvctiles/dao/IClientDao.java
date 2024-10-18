package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.Optional;


public interface IClientDao extends Repository<ClientEntity> {

    Optional<ClientEntity> findByTel(String tel);

    boolean update(ClientEntity clientEntity);
}
