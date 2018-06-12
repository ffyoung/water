package com.bfs.mapper;

import com.bfs.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-06-08
 */
public interface UserMapper {


        @Select("select * from t_user")
        List<User> getAll();

        @Select("select * from t_user where username = #{username} and password = #{password}")
        User loginSure(User user);


    /**
     * @Select("SELECT * FROM users")
     @Results({
     @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
     @Result(property = "nickName", column = "nick_name")
     })
     List<UserEntity> getAll();

     @Select("SELECT * FROM users WHERE id = #{id}")
     @Results({
     @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
     @Result(property = "nickName", column = "nick_name")
     })
     UserEntity getOne(Long id);

     @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
     void insert(UserEntity user);

     @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
     void update(UserEntity user);

     @Delete("DELETE FROM users WHERE id =#{id}")
     void delete(Long id);
     */





}
