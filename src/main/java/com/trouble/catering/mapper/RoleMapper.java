package com.trouble.catering.mapper;

import com.trouble.catering.pojo.Role;
import com.trouble.catering.pojo.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);
    
    int add(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    List<Role> selectAllIdAndDesc();
    
    Role selectByPrimaryKey(Integer id);
    
    String selectRightsById(Integer id);

    List<Role> selectAllRoles();
    
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}