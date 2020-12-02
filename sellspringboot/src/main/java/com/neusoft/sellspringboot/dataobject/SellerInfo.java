package com.neusoft.sellspringboot.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@DynamicUpdate
@Entity
public class SellerInfo {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")//指定主键为UUID增长
    private String id;
    private String username;
    private String password;
    private String openid;
    private Date createTime;
    private Date updateTime;

    public SellerInfo() {
    }
}
