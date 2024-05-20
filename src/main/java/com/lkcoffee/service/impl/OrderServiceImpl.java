package com.lkcoffee.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkcoffee.mapper.OrderMapper;
import com.lkcoffee.pojo.dto.OrderPageQueryDTO;
import com.lkcoffee.pojo.entity.Order;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service.impl
 * @date 2024/5/20 16:14
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public PageResult pageSearch(OrderPageQueryDTO orderPageQueryDTO) {
        PageHelper.startPage(orderPageQueryDTO.getPage(), orderPageQueryDTO.getPageSize());
        Page<Order> pagequery = orderMapper.pageQuery();
        long total = pagequery.getTotal();
        List<Order> result = pagequery.getResult();

        return new PageResult(total, result);
    }

    @Override
    public Order getById(Long id) {
        return orderMapper.getById(id);
    }
}
