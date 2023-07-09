package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.dto.ServDto;
import com.ijv.internjava.model.service.ServService;
import com.ijv.internjava.utils.CommonConstants;
import com.ijv.internjava.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServController {
    @Autowired
    private ServService servService;

    @Autowired
    private MessageUtils messageUtils;

    @GetMapping
    public List<ServDto> findAll() {
        return servService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServDto> detail(@PathVariable(name = "id") Long id) {
        ServDto servDtoResponse = servService.detail(id);
        return ResponseEntity.ok().body(servDtoResponse);
    }

    @PostMapping
    public ResponseEntity<ServDto> create(@RequestBody ServDto servDtoRequest) {
        ServDto servDtoResponse = servService.create(servDtoRequest);
        return new ResponseEntity<ServDto>(servDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServDto> edit(@PathVariable Long id, @RequestBody ServDto servDtoRequest) {
        ServDto servDtoResponse = servService.edit(servDtoRequest, id);
        return ResponseEntity.ok().body(servDtoResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        servService.delete(id);
//        ApiResponseDto apiResponseDto = new ApiResponseDto(Boolean.TRUE, "Post deleted successfully", HttpStatus.OK);
//        return new ResponseEntity<ApiResponseDto>(apiResponseDto, HttpStatus.OK);
    }
}
