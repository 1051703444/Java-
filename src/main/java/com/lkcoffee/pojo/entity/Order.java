package com.lkcoffee.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.pojo.entity
 * @date 2024/5/20 16:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Long status; //0 待接单 1 待配送 2 配送中 3 已完成 4 配送超时
    private Long riderId;
    private LocalDateTime takeTime;
}
