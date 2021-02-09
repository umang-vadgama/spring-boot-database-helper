package com.swt.database.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DeptRepository extends CrudRepository<Dept,String> {

    public List<Dept> findAll();

    public Dept findByBranchCode(BigDecimal branchId);

}
