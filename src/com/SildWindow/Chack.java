package com.SildWindow;

public class Chack {

	public String ZeroBitInput(StringBuffer zeroBitStr){
//		this.str=str;
//		StringBuffer strb=new StringBuffer(str);
//		char[] b=new char[zeroBitStr.length()];
		char[] c = zeroBitStr.toString().toCharArray();
		int count=0;
		boolean right = true;
		String string;
		for(int i=1;i<c.length;i++){
//			c[i]=zeroBitStr.charAt(i);
//			System.out.println(c[0]);
		    if(c[i]=='1'){
		    	count++;
		    	if(count==5){
		    		if (c[i+1]=='1') {
		    			right = false;
//		    			System.out.println("aaa"+i+count);
		    			break;
					}else {
						zeroBitStr.deleteCharAt(i+1);
					}
//		    		System.out.println(strb);
		    	}
		    	else if (count == 5) {
				}
		    }
		    else{
		    	count=0;
		    }
		}
		if (right == true) {
			string = zeroBitStr.toString();
		}else {
			string = "";
		}
		return string;
	}
	
	public int getDateID(StringBuffer zeroBitStr) {
		char[] b = zeroBitStr.toString().toCharArray();
		int q = b.length;
		String dateIDStr = zeroBitStr.delete(1, q).toString();
		int dateID = Integer.parseInt(dateIDStr);
		return dateID;
	}
//	public static void main(String[] args) {
//		Chack chack = new Chack();
//		StringBuffer sb = new StringBuffer("1110111111010011");
//		String aString = chack.ZeroBitInput(sb);
//		System.out.println(aString);
//	}
	
}
