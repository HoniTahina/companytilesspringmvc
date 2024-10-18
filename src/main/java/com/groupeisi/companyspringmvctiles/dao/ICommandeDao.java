package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.CommandeEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.Optional;


public interface ICommandeDao extends Repository<CommandeEntity> {

    Optional<CommandeEntity> findById(long id);

    boolean update(CommandeEntity commandeEntity);
}
