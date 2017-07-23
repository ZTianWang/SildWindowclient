package com.SildWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateRec extends Thread{

private Socket socket;
	
	public  DateRec(String name,Socket socket) {
		super(name);
		this.socket = socket;
	}
	
	public void run() {
		try {
			boolean dateIsRec = true;
			String dateLine = "";
			String binStr,dateStr ;
			StringBuffer dateBuffer ;
			int dateID;
			BufferedReader dateReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int i = 0;
			Chack chack = new Chack();
			BinToStr binToStr = new BinToStr();
			Thread.sleep(2000);
			while (dateIsRec) {
				dateLine = dateReader.readLine();
				dateBuffer = new StringBuffer(dateLine);
				binStr = chack.ZeroBitInput(dateBuffer);
				dateID = chack.getDateID(dateBuffer);
				dateStr = binToStr.BinstrToStr(binStr);
				if ((binStr != "") && (dateID == i)) {
					System.out.println("receive--"+dateStr+"--"+dateLine+"--"+dateID);
					this.Response(i);
				}else {
					System.out.println(dateID+"--"+i);
					System.out.println("giving up");
				}
				i++;
				if (i==8) {
					i = 0;
				}
//				if(("Date"+i).equals(dateLine)){
//					System.out.println("receive--"+dateLine);
//					this.Response(i);
//					i++;
//					if (i==8) {
//						i = 0;
//					}
//				}else {
//					System.out.println("giving up");
//				}
//				if (dateLine.equals(null)) {
//					dateIsRec = false;
//				}
				Thread.sleep(1000);
			}
//			dateReader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void Response(int i){
		try {
			PrintWriter os = new PrintWriter(socket.getOutputStream());
					os.println("ack"+i);
					os.flush();
					System.out.println("send--ack:" + i);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
