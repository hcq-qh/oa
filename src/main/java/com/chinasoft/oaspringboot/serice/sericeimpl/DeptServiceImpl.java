package com.chinasoft.oaspringboot.serice.sericeimpl;

import com.chinasoft.oaspringboot.Mapper.DeptMapper;
import com.chinasoft.oaspringboot.entity.Dept;
import com.chinasoft.oaspringboot.serice.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return 0;
    }

    @Override
    public int insert(Dept record) {
        return 0;
    }

    @Override
    public Dept selectByPrimaryKey(Integer did) {
        return null;
    }

    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return 0;
    }
}
