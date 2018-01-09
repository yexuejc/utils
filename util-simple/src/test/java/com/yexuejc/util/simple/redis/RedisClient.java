package com.yexuejc.util.simple.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * redis RESP传输协议：
 * <p>
 * RESP协议每段数据 分隔 \r\n
 * <p>
 * 数组 
 * $ 多行字符串
 * + 单行信息
 * - 错误信息
 * : 整型数字
 */
public class RedisClient {
    Socket socket;
    private OutputStream writer;
    private InputStream reader;

    //TCP
    public RedisClient(String host, int port) throws IOException {
        socket = new Socket(host, port);

        writer = socket.getOutputStream();

        reader = socket.getInputStream();
    }

    /**
     * redis set实现
     *
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) throws IOException {
        //RESP协议每段数据用 \r\n 分割
        //*3\r\n    代表这个请求由几个参数组成
        //$3\r\n    第一参数长度3
        //SET\r\n   第一个参数值
        //$5\r\n    第二个参数长度
        //hello\r\n 第二个参数值
        //$5\r\n    第三个参数长度
        //redis\r\n 第三个参数值
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        //中文长度 getBytes
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");
        command.append("$").append(value.getBytes().length).append("\r\n");
        command.append(value).append("\r\n");
        return exeCommand(command);
    }

    /**
     * redis 获取值->get hello
     *
     * @param key
     * @return
     */
    public String get(String key) throws IOException {
        //RESP协议每段数据用 \r\n 分割
        //*3\r\n    代表这个请求由几个参数组成
        //$3\r\n    第一参数长度3
        //SET\r\n   第一个参数值
        //$5\r\n    第二个参数长度
        //hello\r\n 第二个参数值
        //$5\r\n    第三个参数长度
        //redis\r\n 第三个参数值
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("GET").append("\r\n");
        //中文长度 getBytes
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");
        return exeCommand(command);
    }

    /**
     * redis 长度
     *
     * @return
     * @throws IOException
     */
    public String dbsize() throws IOException {
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$6").append("\r\n");
        command.append("dbsize").append("\r\n");
        return exeCommand(command);
    }

    public String exeCommand(StringBuffer command) throws IOException {
        //发送报文
        writer.write(command.toString().getBytes());
        //接收响应
        byte[] result = new byte[1024];
        reader.read(result);
        return new String(result);
    }
}
