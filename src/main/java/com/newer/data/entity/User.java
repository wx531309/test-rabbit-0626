package com.newer.data.entity;

import java.io.Serializable;

/**
 * java.lang.IllegalArgumentException: SimpleMessageConverter
 * only supports String, byte[] and Serializable序列化 payloads, received: com.newer.data.entity.User
 * 使用消息服务传递和接收数据，Java类必须序列化
 * 1）、类可以实现序列化接口public class User implements Serializable
 * 2）、类转换JSON格式。
 * @author Administrator
 * @CopyRight(C), 2009-2023,牛耳教育有限公司
 * @FileName: User
 * @projectName test-rabbit-0626
 * @description: TODO
 * @date 2023/6/2614:54
 */
public class User{
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
