package com.SildWindow;

import java.io.PrintWriter;
import java.net.Socket;

public class AckSend extends Thread{
	
	private Socket socket;
		
		public AckSend(String name,Socket socket){
			super(name);
			this.socket = socket;
		}
		
		public void run(){
			boolean ackBegainSend = true;
			String ackIsSend = "right";
			try {
				PrintWriter os = new PrintWriter(socket.getOutputStream());
//				BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				int i=0;
				Thread.sleep(2000);
				while (ackBegainSend)	
				{
					if (ackIsSend == "right") {
						Thread.sleep(1000);
						os.println("ack"+i);
						os.flush();
						System.out.println("ack:" + i);
						i++;
					}
					if (ackIsSend == "wrong") {
						i = 2;
						Thread.sleep(1000);
						os.println("nak"+i);
						os.flush();
						System.out.println("nak:" + i);
						ackIsSend = "right";
					}
					if (i == 10) {
						ackBegainSend = false;
					}
				}
//				System.out.println("Server:" + is.readLine());
				os.close();
	//			socket.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
}
