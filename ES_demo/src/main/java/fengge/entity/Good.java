package fengge.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Feng, Ge 2020-10-20 17:12
 */
@Data
public class Good {

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private String price;

    @ApiModelProperty("商品图片")
    private String img;

}
