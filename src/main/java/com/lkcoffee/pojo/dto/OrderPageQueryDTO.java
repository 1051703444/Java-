package com.lkcoffee.pojo.dto;

import lombok.Data;


/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.pojo.dto
 * @date 2024/5/20 16:29
 */
@Data
public class OrderPageQueryDTO {
    private Integer page;
    private Integer pageSize;
}
