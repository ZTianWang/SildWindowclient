package com.SildWindow;

public class BinToStr {

	//���������ַ���ת����Unicode�ַ���
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
    
    //���������ַ���ת��Ϊchar
    private char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;   
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }   
        return (char)sum;
    }
    
  //����ʼ�������ַ���ת�����ַ������飬�Կո����
    private String[] StrToStrArray(String str) {
        return str.split(" ");
    }
    
  //���������ַ���ת����int����
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
