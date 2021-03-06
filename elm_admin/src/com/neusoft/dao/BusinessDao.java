package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
   public List<Business> listBusiness(String businessName,String businessAddress);

   public  int saveBusiness(String businessName);

   public int removeBusiness(int businessId);

   public int updateBusiness(Business business);

   public Business getBusinessId(int businessid);

   public Business getBusinessIdAndBusinessPassword(String businessId,String password);

   public int updateBusinessPassword(Integer businessId,String newPassword);
}
