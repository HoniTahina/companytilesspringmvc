package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {

    private ClientMapper() {
    }

    public static ClientEntity toClientEntity(ClientDto clientDto) {

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId(clientDto.getId());
        clientEntity.setFirstname(clientDto.getFirstname());
        clientEntity.setLastname(clientDto.getLastname());
        clientEntity.setEmail(clientDto.getEmail());
        clientEntity.setPassword(clientDto.getPassword());
        clientEntity.setTel(clientDto.getTel());
        clientEntity.setAddress(clientDto.getAddress());

        return clientEntity;
    }

    public static ClientDto toClientDto(ClientEntity clientEntity) {

        ClientDto clientDto = new ClientDto();

        clientDto.setId(clientEntity.getId());
        clientDto.setFirstname(clientEntity.getFirstname());
        clientDto.setLastname(clientEntity.getLastname());
        clientDto.setEmail(clientEntity.getEmail());
        clientDto.setPassword(clientEntity.getPassword());
        clientDto.setTel(clientEntity.getTel());
        clientDto.setAddress(clientEntity.getAddress());

        return clientDto;
    }

    public static List<ClientDto> toListClientDto(List<ClientEntity> clientEntities) {
        return clientEntities.stream()
                .map(ClientMapper::toClientDto)
                .collect(Collectors.toList());
    }
}
