package com.lkcoffee.controller;

import com.lkcoffee.pojo.dto.OrderPageQueryDTO;
import com.lkcoffee.pojo.entity.Order;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.controller
 * @date 2024/5/20 16:08
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 骑手上班后订单列表页查询
     * @param orderPageQueryDTO
     * @author create by ChenZhixiong on
     */
    @GetMapping("/page")
    public Result<PageResult> pageSearch(OrderPageQueryDTO orderPageQueryDTO){
        PageResult pageResult = orderService.pageSearch(orderPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 通过Id查询订单
     * @param id
     * @author create by ChenZhixiong on
     */

    @GetMapping("/{id}")
    public Result<Order> getById(@PathVariable Long id){
        Order byId = orderService.getById(id);
        return Result.success(byId);
    }

}
