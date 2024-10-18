package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.*;
import com.groupeisi.companyspringmvctiles.dto.AccountUserDto;
import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.CommandeDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.entities.AccountUserEntity;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.CommandeEntity;
import com.groupeisi.companyspringmvctiles.mapper.AccountUserMapper;
import com.groupeisi.companyspringmvctiles.mapper.ClientMapper;
import com.groupeisi.companyspringmvctiles.mapper.CommandeMapper;

import java.util.List;
import java.util.Optional;

public class CommandeService implements ICommandeService{


    private ICommandeDao commandeDao = new CommandeDao();

    @Override
    public Optional<List<CommandeDto>> findAll() {
        List<CommandeEntity> commandeEntities = commandeDao.list(new CommandeEntity());
        List<CommandeDto> commandeDtos = CommandeMapper.toListCommandeDto(commandeEntities);
        return Optional.of(commandeDtos);
    }

    @Override
    public boolean save(CommandeDto commandeDto) {
        CommandeEntity commandeEntity = CommandeMapper.toCommandeEntity(commandeDto);
        return commandeDao.save(commandeEntity);
    }

    @Override
    public Optional<CommandeDto> findById(long Id) {
        Optional<CommandeEntity> commandeEntity = commandeDao.findById(Id);
        return commandeEntity.map(CommandeMapper::toCommandeDto);
    }

    @Override
    public boolean update(CommandeDto commandeDto) {
        CommandeEntity commandeEntity = CommandeMapper.toCommandeEntity(commandeDto);
        return commandeDao.update(commandeEntity);
    }
}
