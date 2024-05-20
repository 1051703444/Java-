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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rider {
    private Long riderId;
    private String name;
    private Long status; //0 休息中 1 上班中
    private Long isHealthy;// 0 不健康 1 健康
    private LocalDateTime createTime; //健康证更新时间
}
