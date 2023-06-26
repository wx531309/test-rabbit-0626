package com.newer.service;

import com.newer.data.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @RabbitListener通过监听器注解
 * 获取指定消息队列的值。
 * * @author Administrator
 * @CopyRight(C), 2009-2023,牛耳教育有限公司
 * @FileName: RabbitMQService
 * @projectName test-rabbit-0626
 * @description: TODO
 * @date 2023/6/2615:08
 */
@Service
public class RabbitMQService {

    /**
     *  **使用基于注解的方式实现消息服务
     * 1.1、Publish/Subscribe工作模式接收，处理邮件业务
     * @param user
     */
    @RabbitListener(bindings =
    @QueueBinding(value =@Queue("fanout_queue_email"),
            exchange =@Exchange(value = "fanout_exchange",type = "fanout")))
    public void psubConsumerEmailAno(User user) {
        System.out.println("邮件业务接收到消息： "+user);
    }
    /**
     * 1.2、Publish/Subscribe工作模式接收，处理短信业务
     * @param user
     */
    @RabbitListener(bindings =@QueueBinding(value =@Queue("fanout_queue_sms"),
            exchange =@Exchange(value = "fanout_exchange",type = "fanout")))
    public void psubConsumerSmsAno(User user) {
        System.out.println("短信业务接收到消息： "+user);
    }


    /**
     * Publish/Subscribe工作模式接收，处理邮件业务
     * 语法：
     * @RabbitListener(queues="队列名字")
     * public void 方法名字(Message：代表监听器获取队列存放数据)
     * Message.getBody()返回消息体（队列存放的数据）
     *
     * @param message
     */

//    @RabbitListener(queues = "fanout_queue_email")
//    public void psubConsumerEmail(Message message) {
//        byte[] body = message.getBody();
//        String s = new String(body);
//        System.out.println("邮件业务接收到消息： "+s);
//
//    }
//
//    /**
//     * Publish/Subscribe工作模式接收，处理短信业务
//     * @param message
//     */
//    @RabbitListener(queues = "fanout_queue_sms")
//    public void psubConsumerSms(Message message) {
//        byte[] body = message.getBody();
//        String s = new String(body);
//        System.out.println("短信业务接收到消息： "+s);
//    }
}
