package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.*;
import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;
import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;
import com.groupeisi.companyspringmvctiles.mapper.AccountUserMapper;
import com.groupeisi.companyspringmvctiles.mapper.ClientMapper;
import com.groupeisi.companyspringmvctiles.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ClientService implements IClientService{


    private IClientDao clientDao = new ClientDao();

    @Override
    public Optional<List<ClientDto>> findAll() {

        List<ClientEntity> clientEntities = clientDao.list(new ClientEntity());
        List<ClientDto> clientDtos = ClientMapper.toListClientDto(clientEntities);
        return Optional.of(clientDtos);
    }

    @Override
    public boolean save(ClientDto clientDto) {
        ClientEntity clientEntity = ClientMapper.toClientEntity(clientDto);
        return clientDao.save(clientEntity);
    }

    @Override
    public Optional<ClientDto> findByTel(String tel) {
        Optional<ClientEntity> clientEntity = clientDao.findByTel(tel);
        return clientEntity.map(ClientMapper::toClientDto);
    }

    @Override
    public boolean update(ClientDto clientDto) {
        ClientEntity clientEntity = ClientMapper.toClientEntity(clientDto);
        return clientDao.update(clientEntity);
    }
}
