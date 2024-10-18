package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Optional<List<ClientDto>> findAll();

    boolean save(ClientDto clientDto);

    Optional<ClientDto> findByTel(String tel);

    boolean update(ClientDto clientDto);
}
