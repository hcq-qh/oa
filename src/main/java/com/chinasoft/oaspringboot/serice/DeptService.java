package com.chinasoft.oaspringboot.serice;

import com.chinasoft.oaspringboot.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    int deleteByPrimaryKey(Integer did);
    int insert(Dept record);
    Dept selectByPrimaryKey(Integer did);
    List<Dept> selectAll();
    int updateByPrimaryKey(Dept record);
}
