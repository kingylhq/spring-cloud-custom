package com.yh;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * 鸟欲高飞先振翅
 * Created with IntelliJ IDEA.
 * Description:
 *
 * 将此类放在启动类扫描不到的路径下
 *
 * @author: liqian
 * @Date: 2019-03-23
 * @Time: 19:30
 * 人求上进先读书
 */
public class RibbonRuleConfig {

    /**
     *  IRule 是所有规则的标准
     * 1、支持对产品服务提供方高可用集群部署的随机访问
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new com.netflix.loadbalancer.RandomRule();
    }
}
