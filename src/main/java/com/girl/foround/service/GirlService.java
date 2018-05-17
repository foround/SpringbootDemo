package com.girl.foround.service;

import com.girl.foround.domain.Girl;
import com.girl.foround.domain.GirlAge;
import com.girl.foround.exception.GirlException;
import com.girl.foround.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/17 0017 21:07
 * <p>
 * 类说明：
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public void addTwoGirl(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("B");
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("C");
        girlRepository.save(girlB);

    }

    public GirlAge getGirlAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(100,"小学生呐");
        }else if(age >= 10 && age < 16 ){
            throw new GirlException(100,"初中生呐");
        }else{
            GirlAge girlAge = new GirlAge(age);
            return girlAge;
        }
    }
}
