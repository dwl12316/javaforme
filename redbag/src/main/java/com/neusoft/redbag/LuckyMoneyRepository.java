package com.neusoft.redbag;

import org.springframework.data.jpa.repository.JpaRepository;
//<表,主键>
public interface  LuckyMoneyRepository extends JpaRepository<LuckyMoney,Integer> {
}
