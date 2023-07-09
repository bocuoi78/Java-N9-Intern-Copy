package com.ijv.internjava.model.service;

import com.ijv.internjava.model.dto.ServDto;

import java.util.List;

public interface ServService {
    List<ServDto> findAll();
    ServDto detail(Long id);
    ServDto create(ServDto servDto);
    ServDto edit(ServDto servDto, Long id);
    void delete(long id);
}
