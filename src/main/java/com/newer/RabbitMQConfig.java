package com.newer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 * 1、实现消息队列数据的JSON转换。
 * @author Administrator
 * @CopyRight(C), 2009-2023,牛耳教育有限公司
 * @FileName: RabbitMQConfig
 * @projectName test-rabbit-0626
 * @description: TODO
 * @date 2023/6/2615:00
 */
@Configuration
public class RabbitMQConfig {


    /**
     * 使用基于配置类的方式定制消息中间件
     * 实例化交换器Exchange、
     * 实例化消息对了Queue
     * 绑定交换器和队列。
     * @return
     */
    // 1、定义fanout类型的交换器
    @Bean
    public Exchange fanout_exchange(){
        return ExchangeBuilder.fanoutExchange("fanout_exchange").build();
    }
    // 2、定义两个不同名称的消息队列
    @Bean
    public Queue fanout_queue_email(){
        return new Queue("fanout_queue_email");
    }
    @Bean
    public Queue fanout_queue_sms(){
        return new Queue("fanout_queue_sms");
    }
    // 3、将两个不同名称的消息队列与交换器进行绑定
    @Bean
    public Binding bindingEmail(){
        return BindingBuilder.bind(fanout_queue_email()).to(fanout_exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingSms(){
        return BindingBuilder.bind(fanout_queue_sms()).to(fanout_exchange()).with("").noargs();
    }

    /**
     * 定制JSON格式的消息转换器
     * @return
     */
    //Jackson2JsonMessageConverter implemens MessageConverter
    //Message消息Converter转换器
    //implements Converter
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
