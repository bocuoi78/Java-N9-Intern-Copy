package com.ijv.internjava.model.service.Impl;

import com.ijv.internjava.model.dto.ServDto;
import com.ijv.internjava.model.entity.Serv;
import com.ijv.internjava.model.mapper.ServMapper;
import com.ijv.internjava.model.repository.ServRepository;
import com.ijv.internjava.model.service.ServService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Throwable.class)
public class ServServiceImpl implements ServService {
    @Autowired
    private ServRepository servRepository;
    @Override
    public List<ServDto> findAll() {
        return servRepository.findAll().stream()
                .map(serv -> ServMapper.getInstance().toDto(serv))
                .collect(Collectors.toList());
    }

    @Override
    public ServDto detail(Long id) {
        Serv serv = servRepository.findById(id).get();
        return ServMapper.getInstance().toDto(serv);
    }

    @Override
    public ServDto create(ServDto servDto) {
        Serv serv = new Serv();
        serv.setName(servDto.getName());
        serv.setPrice(servDto.getPrice());
        serv.setService_time(servDto.getService_time());
        serv.setDescription(servDto.getDescription());
        return ServMapper.getInstance().toDto(servRepository.save(serv));
    }

    @Override
    public ServDto edit(ServDto servDto, Long id) {
        Serv savedServ = servRepository.findById(id).get();
        savedServ.setName(servDto.getName());
        savedServ.setPrice(servDto.getPrice());
        savedServ.setService_time(servDto.getService_time());
        savedServ.setDescription(servDto.getDescription());
        return ServMapper.getInstance().toDto(servRepository.save(savedServ));
    }

    @Override
    public void delete(long id) {
        Serv serv = servRepository.findById(id).get();
        servRepository.delete(serv);
    }
}
