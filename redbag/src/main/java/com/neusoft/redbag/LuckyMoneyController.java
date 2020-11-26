package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bag")
public class LuckyMoneyController {
    @Autowired
    private LuckyMoneyRepository repository;
    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/list")
    public List<LuckyMoney> list(){
        return repository.findAll();
    }
    /**
     *发红包
     * @param pro
     * @param mon
     * @return
     */
    @PostMapping("/post")
    public LuckyMoney save(@RequestParam(value = "pro") String pro,@RequestParam(value = "mon") BigDecimal mon){
            LuckyMoney luckyMoney = new LuckyMoney();
            luckyMoney.setProducer(pro);
            luckyMoney.setMoney(mon);
            return repository.save(luckyMoney);
    }
    /**
     * 根据id查询红包
     * @return luckMoney
     */
    @GetMapping("/find/{id}")
    public LuckyMoney findById(@PathVariable("id") Integer id){
//        Optional<LuckyMoney> optional = repository.findById(id);
//        if (optional.isPresent()){
//            LuckyMoney luckyMoney = optional.get();
//            return luckyMoney;
//        }
//        return null;
        // 如果有就返回，没有就 返回 orElse里面的内容
        return repository.findById(id).orElse(null);
    }
    /**
     * 收红包
     * @param id
     * @param consumer
     * @return LuckyMoney
     */
    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id") Integer id,@RequestParam("consumer") String consumer){
        Optional<LuckyMoney> optional = repository.findById(id);
        if (optional.isPresent()){
            LuckyMoney luckyMoney = optional.get();
            luckyMoney.setConsumer(consumer);
            return repository.save(luckyMoney);
        }
        return null;
    }
}
