package com.yinnan.learnboot.controllers;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yinnan
 * Date: 2018/10/8
 * Time: 14:07
 * Email:yinnan@huli.com
 *
 * @author yinnan
 * @since 1.0-SNAPSHOT
 */
@ServerEndpoint(value = "/webSocketServer/{userName}")
@Component
public class WebSocketController {

    private static final Set<WebSocketController> CONNECTIONS = new CopyOnWriteArraySet<>();

    private String nickname;
    private Session session;

    private static String getDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @OnOpen
    public void start(@PathParam("userName") String userName, Session session) {
        this.nickname = userName;
        this.session = session;
        CONNECTIONS.add(this);
        String message = String.format("* %s %s", nickname, "加入聊天！");
        broadcast(message);
    }

    @OnClose
    public void end() {
        CONNECTIONS.remove(this);
        String message = String.format("* %s %s", nickname, "退出聊天！");
        broadcast(message);
    }

    @OnMessage
    public void pushMsg(String message) {
        broadcast("【" + this.nickname + "】" + getDatetime(new Date()) + " : " + message);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {

    }

    private static void broadcast(String msg) {
        // 广播形式发送消息
        for (WebSocketController client : CONNECTIONS) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                CONNECTIONS.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
                String message = String.format("* %s %s", client.nickname, "断开连接");
                broadcast(message);
            }
        }
    }
}