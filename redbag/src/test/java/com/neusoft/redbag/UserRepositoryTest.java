package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Test
    public void save(){
        User user = new User();
        user.setUsername("aa");
        user.setPassword("fff");
        repository.save(user);
    }
    @Test
    public void delete(){
        repository.deleteById("8a04af9775fe87100175fe8717800000");
    }
}
