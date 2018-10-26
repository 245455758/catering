package com.trouble.catering.mapper;

import com.trouble.catering.pojo.User;
import com.trouble.catering.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    
    int validateUser(int id);
    
    int undoValidateUser(int id);

    List<User> selectByExample(UserExample example);
    
    List<User> selectAllShoppers();
    
    List<User> selectAllUncheckedShoppers();

    User selectByPrimaryKey(Integer id);
    
    String selectPasswordById(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}