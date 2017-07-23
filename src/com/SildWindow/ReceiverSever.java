package com.SildWindow;

import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverSever {
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8866);
			Socket sendSocket = serverSocket.accept();
			DateRec dateRec = new DateRec("date", sendSocket);
			dateRec.start();
		} catch (Exception e) {
			System.out.println("建立连接失败"+e);
		}
	}
	
}
