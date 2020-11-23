package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface AdminDao {
    public List<Admin> listAdmin();
    public Admin getAdminByNameAndPassword(String adminName,String password);
}
