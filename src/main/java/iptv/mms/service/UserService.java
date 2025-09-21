package iptv.mms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iptv.mms.entity.User;
import iptv.mms.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;

    /**
     * 모든 사용자 조회
     */
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    /**
     * ID로 사용자 조회
     */
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * 이름으로 사용자 검색
     */
    public List<User> getUsersByName(String name) {
        return userMapper.findByName(name);
    }

    /**
     * 새 사용자 생성
     */
    public User createUser(User user) {
        int result = userMapper.insert(user);
        if (result > 0) {
            return user; // ID가 자동으로 설정됨
        }
        return null;
    }

    /**
     * 사용자 정보 수정
     */
    public User updateUser(User user) {
        int result = userMapper.update(user);
        if (result > 0) {
            return userMapper.findById(user.getId());
        }
        return null;
    }

    /**
     * 사용자 삭제
     */
    public boolean deleteUser(Long id) {
        int result = userMapper.deleteById(id);
        return result > 0;
    }

    /**
     * 전체 사용자 수 조회
     */
    public int getUserCount() {
        return userMapper.count();
    }
}
