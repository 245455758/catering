package com.trouble.catering.mapper;

import com.trouble.catering.pojo.UserDetail;
import com.trouble.catering.pojo.UserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDetailMapper {
    int countByExample(UserDetailExample example);

    int deleteByExample(UserDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExample(UserDetailExample example);

    UserDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailExample example);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}