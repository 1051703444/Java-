package com.lkcoffee.service;

import com.lkcoffee.pojo.dto.OrderPageQueryDTO;
import com.lkcoffee.pojo.entity.Order;
import com.lkcoffee.result.PageResult;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service
 * @date 2024/5/20 16:13
 */
public interface OrderService {
    PageResult pageSearch(OrderPageQueryDTO orderPageQueryDTO);

    Order getById(Long id);
}
