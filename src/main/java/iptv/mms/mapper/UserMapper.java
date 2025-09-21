package iptv.mms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import iptv.mms.entity.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	
	User findById(@Param("id") Long id);
	
	List<User> findByName(@Param("name") String name);
	
    int insert(User user);
    
    int update(User user);
    
    int deleteById(@Param("id") Long id);
    
    int count();
}
