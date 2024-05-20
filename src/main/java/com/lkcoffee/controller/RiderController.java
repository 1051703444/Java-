package com.lkcoffee.controller;

import com.lkcoffee.pojo.dto.DeliveryDTO;
import com.lkcoffee.pojo.entity.Rider;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.controller
 * @date 2024/5/20 16:10
 */
@RestController
@RequestMapping("/rider")
public class RiderController {
    @Autowired
    private RiderService riderService;

    /**
     * 通过Id查询骑手
     * @param id
     * @author create by ChenZhixiong on
     */

    @GetMapping("/{id}")
    public Result<Rider> getById(@PathVariable Long id){
        Rider rider = riderService.getById(id);
        return Result.success(rider);
    }

    /**
     * 订单配送流程
     * @param deliveryDTO
     * @author create by ChenZhixiong on
     */

    @PutMapping("/delivery")
    public Result delivery(@RequestBody DeliveryDTO deliveryDTO){
        riderService.delivery(deliveryDTO);
        return Result.success();
    }

}
