package com.team.mapper;

import com.team.pojo.AdPromotion;
import com.team.pojo.AdPromotionExample;
import java.util.List;

public interface AdPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    List<AdPromotion> selectByExample(AdPromotionExample example);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}