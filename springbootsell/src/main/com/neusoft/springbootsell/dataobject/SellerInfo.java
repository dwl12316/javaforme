package src.main.com.neusoft.springbootsell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class SellerInfo {
    @Id
    @GeneratedValue
    private String id;
    private String username;
    private String password;
    private String openid;
    private Date createTime;
    private Date updateTime;
}
