package com.chinasoft.oaspringboot.serice.sericeimpl;

import com.chinasoft.oaspringboot.Mapper.EmpMapper;
import com.chinasoft.oaspringboot.entity.Emp;
import com.chinasoft.oaspringboot.serice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int deleteByPrimaryKey(Integer eid) {
        return empMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public int insert(Emp record) {
        return 0;
    }

    @Override
    public Emp selectByPrimaryKey(Integer eid) {
        return null;
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return 0;
    }
}
