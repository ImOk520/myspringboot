package com.feng.consumer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Feng, Ge 2020-11-04 13:56
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarVO {
    private Integer id;
    private String brand;
}
