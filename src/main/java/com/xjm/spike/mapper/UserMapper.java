package com.xjm.spike.mapper;


import com.xjm.spike.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper  {

//    @Select("   select nickname as username,`password`,'admin' as role,'true' as accountNonExpired ,\n" +
//            "        'true' as accountNonLocked,'true' as credentialsNonExpired,'true' as enabled from user where nickname = #{username}")
    UserInfo getUserByname(String username);
}
