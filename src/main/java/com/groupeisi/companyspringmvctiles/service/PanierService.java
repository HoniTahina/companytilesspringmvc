package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.CommandeDao;
import com.groupeisi.companyspringmvctiles.dao.ICommandeDao;
import com.groupeisi.companyspringmvctiles.dao.IPanierDao;
import com.groupeisi.companyspringmvctiles.dao.PanierDao;
import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;
import com.groupeisi.companyspringmvctiles.mapper.ClientMapper;
import com.groupeisi.companyspringmvctiles.mapper.PanierMapper;

import java.util.List;
import java.util.Optional;

public class PanierService implements IPanierService{

    private IPanierDao panierDao = new PanierDao();

    @Override
    public Optional<List<PanierDto>> findAll() {
        List<PanierEntity> panierEntities = panierDao.list(new PanierEntity());
        List<PanierDto> panierDtos = PanierMapper.toListPanierDto(panierEntities);
        return Optional.of(panierDtos);
    }

    @Override
    public boolean save(PanierDto panierDto) {
        PanierEntity panierEntity = PanierMapper.toPanierEntity(panierDto);
        return panierDao.save(panierEntity);
    }

    @Override
    public Optional<PanierDto> findById(long Id) {
        Optional<PanierEntity> panierEntity = panierDao.findById(Id);
        return panierEntity.map(PanierMapper::toPanierDto);
    }

    @Override
    public boolean update(PanierDto panierDto) {
        PanierEntity panierEntity = PanierMapper.toPanierEntity(panierDto);
        return panierDao.update(panierEntity);
    }
}
