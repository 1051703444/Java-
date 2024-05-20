package com.lkcoffee.mapper;

import com.lkcoffee.pojo.entity.Rider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.mapper
 * @date 2024/5/20 16:15
 */
@Mapper
public interface RiderMapper {
    @Select("select * from rider where rider_id=#{id}")
    Rider getById(Long id);
}
