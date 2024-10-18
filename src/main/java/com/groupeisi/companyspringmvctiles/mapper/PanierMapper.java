package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PanierMapper {

    private PanierMapper() {
    }

    public static PanierEntity toPanierEntity(PanierDto panierDto) {

        PanierEntity panierEntity = new PanierEntity();

        panierEntity.setId(panierDto.getId());
        panierEntity.setDate(panierDto.getDate());
        panierEntity.setClient(ClientMapper.toClientEntity(panierDto.getClient()));
        panierEntity.setProducts(ProductMapper.toListProductEntity(panierDto.getProducts()));

        return panierEntity;
    }

    public static PanierDto toPanierDto(PanierEntity panierEntity) {

        PanierDto panierDto = new PanierDto();

        panierDto.setId(panierEntity.getId());
        panierDto.setDate(panierEntity.getDate());
        panierDto.setClient(ClientMapper.toClientDto(panierEntity.getClient()));
        panierDto.setProducts(ProductMapper.toListProductDto(panierEntity.getProducts()));

        return panierDto;
    }

    public static List<PanierDto> toListPanierDto(List<PanierEntity> panierEntities) {
        return panierEntities.stream()
                .map(PanierMapper::toPanierDto)
                .collect(Collectors.toList());
    }
}
