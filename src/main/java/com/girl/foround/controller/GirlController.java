package com.girl.foround.controller;

import com.girl.foround.domain.Girl;
import com.girl.foround.properties.GirlProperties;
import com.girl.foround.repository.GirlRepository;
import com.girl.foround.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/8 0008 19:36
 * <p>
 * 类说明：
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    @Autowired
    private GirlProperties girlProperties;
    /**
     * 返回字符串
     */
    @RequestMapping(value = "/getDefaultContent",method = RequestMethod.GET)
    public String getDefaultContent(){
        return "age:" + girlProperties.getAge() + " | cupSize:" + girlProperties.getCupSize();
    }
    /**
     * 查询女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }
    /**
     * 根据id查找一个女生
     */
    @GetMapping(value = "girls/{id}")
    public Girl getGirlById(@PathVariable Integer id){
        Girl girl = girlRepository.findOne(id);
        if( girl == null){
            throw new IllegalArgumentException("The Girl Not Found");
        }else{
            return girl;
        }

    }
    /**
     * 添加一个女生
     */
    @PostMapping(value = "girls")
    public String girlAdd (@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
            girlRepository.save(girl);
            return "Add Success";

        }
    }
    /**
     * 根据id查女生
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable Integer age){
        return girlRepository.findByAge(age);
    }
    /**
     * 更新
     */
    @PutMapping("/girls/{id}")
    public Girl UpdateGirlList(
            @PathVariable Integer id,
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age
    ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return girl;
    }
    /**
     * 删除
     */
    @DeleteMapping("/girls/{id}")
    public String DeleteGirl(
            @PathVariable Integer id
    ){
        girlRepository.delete(id);
        return "Delete Success";
    }
    /**
     * 添加两个女生
     */
    @PostMapping("/girls/addTwo")
    @Transactional
    public void AddTwoGirl(){
        girlService.InsertTwoGirl();
    }
}
