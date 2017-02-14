package com.teresazl.dao;

import com.teresazl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by teresa on 2017/2/5.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 按照年龄查询
    public List<Girl> findByAge(Integer age);

}
