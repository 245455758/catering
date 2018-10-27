package com.trouble.catering.mapper;

import com.trouble.catering.pojo.ShopperDetail;
import com.trouble.catering.pojo.ShopperDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopperDetailMapper {
    int countByExample(ShopperDetailExample example);

    int deleteByExample(ShopperDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopperDetail record);

    int insertSelective(ShopperDetail record);

    List<ShopperDetail> selectByExample(ShopperDetailExample example);

    ShopperDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopperDetail record, @Param("example") ShopperDetailExample example);

    int updateByExample(@Param("record") ShopperDetail record, @Param("example") ShopperDetailExample example);

    int updateByPrimaryKeySelective(ShopperDetail record);

    int updateByPrimaryKey(ShopperDetail record);
}