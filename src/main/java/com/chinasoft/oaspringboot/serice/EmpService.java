package com.chinasoft.oaspringboot.serice;

import com.chinasoft.oaspringboot.entity.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {
    int deleteByPrimaryKey(Integer eid);
    int insert(Emp record);
    Emp selectByPrimaryKey(Integer eid);
    List<Emp> selectAll();
    int updateByPrimaryKey(Emp record);
}
