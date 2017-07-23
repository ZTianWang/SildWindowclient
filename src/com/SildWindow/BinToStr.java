package com.SildWindow;

public class BinToStr {

	//将二进制字符串转换成Unicode字符串
	public String BinstrToStr(String binStr) {
        String[] tempStr=StrToStrArray(binStr);
        char[] tempChar=new char[tempStr.length];
        for(int i=1;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        String dateStr = String.valueOf(tempChar);
        System.out.println(dateStr);
        return dateStr;
    }
    
    //将二进制字符串转换为char
    private char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;   
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }   
        return (char)sum;
    }
    
  //将初始二进制字符串转换成字符串数组，以空格相隔
    private String[] StrToStrArray(String str) {
        return str.split(" ");
    }
    
  //将二进制字符串转换成int数组
    private int[] BinstrToIntArray(String binStr) {       
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];   
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	BinToStr a = new BinToStr();
    	a.BinstrToStr("2110011100111010");
	}
    
}
