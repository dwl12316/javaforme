package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    /**
     *
     * @param pageNum 页的开始数
     * @param pageSize 页大小
     * @return
     */
    @GetMapping("/page")
    public Page<User> pageQuery(@RequestParam(value = "pageNum",required = false,defaultValue = "0") Integer pageNum,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        PageRequest of = PageRequest.of(pageNum, pageSize);
        return repository.findAll(of);
    }

//    /**
//     * 添加用户
//     * @param name
//     * @param password
//     * @param email
//     * @return
//     */

    /**
     * 添加新用
     * @param user 新用户
     * @return
     */
    @PostMapping("/post")
//    public User save(@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email){
//        User user=new User();
//        user.setUsername(name);
//        user.setPassword(password);
//        user.setEmail(email);
//        return repository.save(user);
//    }
    public User save(@RequestBody User user){
     return repository.save(user);
    }
    /**
     * 查找用户
     * @param id 用户ID
     * @return
     */
    @GetMapping("/find/{id}")
    public User findbyId(@PathVariable("id") String id){
        Optional<User> optional=repository.findById(id);
        //创建对象的简写
        return optional.orElseGet(User::new);
    }

    /**
     * 删除用户
     * @param id 用户ID
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * 更新用户
     * @param id 用户ID
     * @param user 更改后的用户
     * @return
     */
    @PutMapping("/update/{if}")
    public User update(@PathVariable("id") String id,@RequestBody User user){
        user.setId(id);
        return repository.save(user);
    }
}
