package com.lkcoffee.mapper;

import com.github.pagehelper.Page;
import com.lkcoffee.pojo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.mapper
 * @date 2024/5/20 16:14
 */
@Mapper
public interface OrderMapper {

    Page<Order> pageQuery();

    @Select("select * from `order` where rider_id=#{id}")
    List<Order> getByRiderId(Long id);

    @Select("select * from `order` where order_id=#{id}")
    Order getById(Long id);

    void update(Order order);
}
