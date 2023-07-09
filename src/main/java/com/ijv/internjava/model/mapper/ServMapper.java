package com.ijv.internjava.model.mapper;

import com.ijv.internjava.model.dto.ServDto;
import com.ijv.internjava.model.entity.Serv;

public class ServMapper {
    private static ServMapper INSTANCE;

    public static ServMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ServMapper();
        }
        return INSTANCE;
    }

    public Serv toEntity(ServDto servDto) {
        Serv serv = new Serv();
        serv.setName(servDto.getName());
        serv.setService_time(servDto.getService_time());
        serv.setPrice(servDto.getPrice());
        serv.setDescription(servDto.getDescription());
        return serv;
    }

    public ServDto toDto(Serv serv) {
        ServDto servDto = new ServDto();
        servDto.setName(serv.getName());
        servDto.setService_time(serv.getService_time());
        servDto.setPrice(serv.getPrice());
        servDto.setDescription(serv.getDescription());
        return servDto;
    }
}
