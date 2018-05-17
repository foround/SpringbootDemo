package com.girl.foround.controller;

import com.girl.foround.domain.GirlAge;
import com.girl.foround.domain.Girl;
import com.girl.foround.domain.Result;
import com.girl.foround.exception.GirlException;
import com.girl.foround.properties.GirlProperties;
import com.girl.foround.repository.GirlRepository;
import com.girl.foround.service.GirlService;
import com.girl.foround.utils.ResultUtil;
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
    private GirlProperties girlProperties;
    @Autowired
    private GirlService girlService;
    /**
     * 返回字符串
     */
    @RequestMapping(value = "/getDefaultContent",method = RequestMethod.GET)
    public Result getDefaultContent(){
        String msg = "age:" + girlProperties.getAge() + " | cupSize:" + girlProperties.getCupSize();
        return ResultUtil.success(msg);
    }
    /**
     * 查询女生列表
     */
    @GetMapping(value = "/girls")
    public Result getGirlList(){
        List<Girl> girlList = girlRepository.findAll();
        return ResultUtil.success(girlList);
    }
    /**
     * 根据id查找一个女生
     */
    @GetMapping(value = "girls/{id}")
    public Result getGirlById(@PathVariable Integer id){
        Girl girl = girlRepository.findOne(id);
        if( girl == null){
            return ResultUtil.fail(101,"The Girl Not Found");
        }else {
            return ResultUtil.success(girl);
        }
    }
    /**
     * 添加一个女生
     */
    @PostMapping(value = "girls")
    public Result girlAdd (@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(102,bindingResult.getFieldError().getDefaultMessage());
        }else{
            girl.setCupSize(girl.getCupSize());
            girl.setAge(girl.getAge());
            girlRepository.save(girl);
            return ResultUtil.success();

        }
    }
    /**
     * 根据年龄查女生
     */
    @GetMapping("/girls/age/{age}")
    public Result findGirlByAge(@PathVariable Integer age){
        List<Girl> girlList = girlRepository.findByAge(age);
        return ResultUtil.success(girlList);
    }
    /**
     * 根据id查女生年龄
     */
    @GetMapping("/girls/getAge/{id}")
    public Result findGirlAgeById(@PathVariable Integer id) throws GirlException{
        GirlAge girlAge = girlService.getGirlAge(id);
        return ResultUtil.success(girlAge);
    }
    /**
     * 更新
     */
    @PutMapping("/girls/{id}")
    public Result UpdateGirlList(
            @PathVariable Integer id,
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age
    ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
        return ResultUtil.success(girl);
    }
    /**
     * 删除
     */
    @DeleteMapping("/girls/{id}")
    public Result DeleteGirl(
            @PathVariable Integer id
    ){
        girlRepository.delete(id);
        return ResultUtil.success();
    }
    /**
     * 添加两个女生
     */
    @PostMapping("/girls/addTwo")
    @Transactional
    public Result AddTwoGirl(){
        girlService.addTwoGirl();
        return ResultUtil.success();
    }
}
