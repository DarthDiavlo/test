package org.example;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String serverName = "91.224.87.134";
        int serverPort = 4040; // Замените на фактический порт сервера

        for(int i=0;i<100000;i++){
            Thread sendThread = new Thread(() -> {
                try {
                    // Создаем сокет для отправки UDP-пакета
                    DatagramSocket clientSocket = new DatagramSocket();

                    // Преобразуем IP-адрес сервера в InetAddress
                    InetAddress IPAddress = InetAddress.getByName(serverName);

                    // Создаем буфер для данных, которые мы хотим отправить
                    byte[] sendData = "Привет".getBytes();

                    // Создаем UDP-пакет
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, serverPort);

                    // Отправляем UDP-пакет
                    clientSocket.send(sendPacket);

                    // Закрываем сокет
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Запускаем поток
            sendThread.start();

        }

    }


}
