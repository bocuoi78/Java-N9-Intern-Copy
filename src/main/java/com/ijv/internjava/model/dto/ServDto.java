package com.ijv.internjava.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServDto implements Serializable {
    private Long id;
    private String name;
    private int service_time;
    private Long price;
    private String description;
}
