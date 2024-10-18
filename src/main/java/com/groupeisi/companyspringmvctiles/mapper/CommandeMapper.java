package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.CommandeDto;
import com.groupeisi.companyspringmvctiles.entities.CommandeEntity;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CommandeMapper {

    private CommandeMapper() {
    }

    public static CommandeEntity toCommandeEntity(CommandeDto commandeDto) {

        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(commandeDto.getId());
        commandeEntity.setDate(commandeDto.getDate());
        commandeEntity.setPanier(PanierMapper.toPanierEntity(commandeDto.getPanier()));
        return commandeEntity;
    }

    public static CommandeDto toCommandeDto(CommandeEntity commandeEntity) {

        CommandeDto commandeDto = new CommandeDto();

        commandeDto.setId(commandeEntity.getId());
        commandeDto.setDate(commandeEntity.getDate());
        commandeDto.setPanier(PanierMapper.toPanierDto(commandeEntity.getPanier()));

        return commandeDto;
    }

    public static List<CommandeDto> toListCommandeDto(List<CommandeEntity> commandeEntities) {
        return commandeEntities.stream()
                .map(CommandeMapper::toCommandeDto)
                .collect(Collectors.toList());
    }
}
