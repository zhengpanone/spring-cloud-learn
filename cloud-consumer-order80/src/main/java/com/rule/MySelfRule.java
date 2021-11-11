package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * MySelfRule
 *
 * @author zhengpanone
 * @since 2021-11-04
 */
@Configuration
public class MySelfRule {

    public IRule myRule() {
        System.out.println("随机");
        //定义为随机
        return new RandomRule();
    }
}
