package com.feng.consumer.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -3245478690496182643L;
    private Integer id;
    private String brand;
}