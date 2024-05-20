package com.lkcoffee.service.impl;

import com.lkcoffee.exception.NotHealthyException;
import com.lkcoffee.exception.NotWorkException;
import com.lkcoffee.mapper.OrderMapper;
import com.lkcoffee.mapper.RiderMapper;
import com.lkcoffee.pojo.dto.DeliveryDTO;
import com.lkcoffee.pojo.entity.Order;
import com.lkcoffee.pojo.entity.Rider;
import com.lkcoffee.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service.impl
 * @date 2024/5/20 16:13
 */
@Service
public class RiderServiceImpl implements RiderService {
    @Autowired
    private RiderMapper riderMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Rider getById(Long id) {
        Rider rider = riderMapper.getById(id);
        return rider;
    }

    @Override
    public void delivery(DeliveryDTO deliveryDTO) {
        Long riderId = deliveryDTO.getRiderId(); //获取骑手Id
        Long orderId = deliveryDTO.getOrderId(); //获取订单Id
        Rider rider = riderMapper.getById(riderId); //获取当前骑手
        if(rider.getStatus()!=1){
            throw new NotWorkException("骑手休息中");
        }else if (rider.getIsHealthy()!=1){
            throw new NotHealthyException("骑手不健康");
        }else{
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime createTime = rider.getCreateTime();
            Duration between = Duration.between(createTime, now);
            long day = between.toDays();
            if (day>=30){
                throw new NotHealthyException("骑手健康证过期");
            }
        }
        //查询当前骑手已接到的订单，如果长度大于等于3，抛出异常
        List<Order> orderList = orderMapper.getByRiderId(riderId);
//        if (orderList.size()>=3){
//            throw new NotTakeMoreException("不能接更多订单");
//        }

        //骑手没有任何异常，开始订单配送流程
        Order order = orderMapper.getById(orderId);
        Long status = order.getStatus();
        Order build = Order.builder().orderId(orderId).build();

        if(status==0){
            //当前订单为待接单状态，修改为待配送状态并添加骑手ID和当前时间
            build.setRiderId(riderId);
            build.setTakeTime(LocalDateTime.now());
            build.setStatus(status+1);
            orderMapper.update(build);
        }else if(status==1){
            //订单当前为待配送状态，如果接单时间和当前时间超过30分钟则超时，否则修改为配送中状态
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime takeTime = orderMapper.getById(orderId).getTakeTime();
            long l = Duration.between(takeTime, now).toMinutes();
            if (l>30){
                build.setStatus(4L);
            }else{
                build.setStatus(status+1);
            }
            orderMapper.update(build);
        }else if (status==2){
            //订单当前为配送中状态，如果接单时间和当前时间超过30分钟则超时，否则修改为已完成状态
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime takeTime = orderMapper.getById(orderId).getTakeTime();
            long l = Duration.between(takeTime, now).toMinutes();
            if (l>30){
                build.setStatus(4L);
            }else{
                build.setStatus(status+1);
            }
            orderMapper.update(build);
        }
    }
}
