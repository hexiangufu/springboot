package com.kang.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kang.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author kk
 * @since 2017-08-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}