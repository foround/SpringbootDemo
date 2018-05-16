package com.girl.foround.repository;

import com.girl.foround.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/8 0008 19:34
 * <p>
 * 类说明：
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    public List<Girl> findByAge(Integer age);
}
