package com.girl.foround.service;

import com.girl.foround.domain.Girl;
import com.girl.foround.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 郑旭 790573267@qq.com
 * @version 0.0.1 创建时间: 2018/5/9 0009 16:01
 * <p>
 * 类说明：
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlReposity;

    public void InsertTwoGirl(){
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(23);
        girlReposity.save(girlA);
        Girl girlB = new Girl();
        girlA.setCupSize("CC");
        girlA.setAge(25);
        girlReposity.save(girlB);
    }
}
