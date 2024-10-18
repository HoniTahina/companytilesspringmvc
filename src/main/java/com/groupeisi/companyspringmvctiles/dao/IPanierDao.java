package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.PanierEntity;

import java.util.Optional;


public interface IPanierDao extends Repository<PanierEntity> {

    Optional<PanierEntity> findById(long id);

    boolean update(PanierEntity panierEntity);
}
