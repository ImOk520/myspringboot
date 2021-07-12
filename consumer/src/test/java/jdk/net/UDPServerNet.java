package jdk.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 */
public class UDPServerNet {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(6666);
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, container.length);
            datagramSocket.receive(packet);
            byte[] data = packet.getData();
            DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
            dis.readUTF();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
