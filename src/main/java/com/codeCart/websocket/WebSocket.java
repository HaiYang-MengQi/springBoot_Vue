//package com.codeCart.websocket;
//import jakarta.websocket.*;
//import jakarta.websocket.server.PathParam;
//import jakarta.websocket.server.ServerEndpoint;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.server.standard.SpringConfigurator;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * WebSocket类是一个用于处理WebSocket通信的类。
// */
//@ServerEndpoint(value = "/websocket")
//@Component
//public class WebSocket {
//    /**
//     * 当WebSocket连接打开时调用的方法。
//     *
//     * @param session WebSocket会话对象
//     */
//    private static final Map<Integer,Session> sessions = new HashMap<>();
//    @OnOpen
//    public void onOpen(Session session) {
//        try{
//            sessions.put(,session);
//            session.setMaxIdleTimeout(1000*60*60*24);
//            broadcastOnlineUser();
//        }catch (Exception e){
//            try {
//                session.close();
//            }catch (Exception x){
//                System.out.println("连接未正常关闭!"+x.getMessage());
//            }
//            System.out.println("session创建失败原因"+e.getMessage());
//        }
//    }
//
//    /**
//     * 当WebSocket连接关闭时调用的方法。
//     *
//     * @param session WebSocket会话对象
//     */
//    @OnClose
//    public void onClose(Session session) {
//        sessions.remove();
//        broadcastOnlineUser();
//    }
//
//    /**
//     * 当接收到WebSocket消息时调用的方法。
//     *
//     * @param message WebSocket消息
//     * @param session WebSocket会话对象
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        try {
//            receivingSession.getBasicRemote().sendText(message);
//        } catch (Exception e) {
//            try {
//                session.getBasicRemote().sendText("你要发送的用户不存在!");
//            } catch (Exception ex) {
//                System.out.println("告知用户发送失败!"+ex.getMessage());
//            }
//        }
//    }
//
//
//    /**
//     * 当WebSocket发生错误时调用的方法。
//     *
//     * @param session WebSocket会话对象
//     * @param error   WebSocket错误对象
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//        System.out.println("websocket error:" + error.getMessage());
//    }
//    public void broadcastOnlineUser() {
//        System.out.println("系统广播:当前在线用户数"+sessions.size());
//    }
//
//
//}
