package com.lkcoffee.service;

import com.lkcoffee.pojo.dto.DeliveryDTO;
import com.lkcoffee.pojo.entity.Rider;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service
 * @date 2024/5/20 16:13
 */
public interface RiderService {
    Rider getById(Long id);

    void delivery(DeliveryDTO deliveryDTO);
}
