package jdk.net;

import cn.hutool.core.lang.Console;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

/**
 *
 */
public class TCPClientNet {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            // 接收服务端消息
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String s = dataInputStream.readUTF();
            Console.log(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
