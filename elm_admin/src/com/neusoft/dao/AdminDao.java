package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface AdminDao {
    public List<Admin> listAdmin();
    public  int saveAdmin(String adminName);

    public int removeBusiness(int adminId);

    public int updateBusiness(Admin admin);

    public Business getBusinessId(int adminid);

    public Admin getAdminByNameAndPassword(String adminName,String password);
}
