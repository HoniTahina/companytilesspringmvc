package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IPanierService {
    Optional<List<PanierDto>> findAll();

    boolean save(PanierDto panierDto);

    Optional<PanierDto> findById(long Id);

    boolean update(PanierDto panierDto);
}
