package com.lq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 * 注：
 * spring cloud Finchley.RELEASE这个版本需要
 * 重写configure方法，把csrf劫持关闭
 *
 * 如果是pring cloud Edgware或之前的版本就不需要这个类骚操作
 *
 * @author: liqian
 * @Date: 2019-03-17
 * @Time: 14:42
 * 人求上进先读书
 */
@Configuration
@EnableWebSecurity
public class EurekaSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}
