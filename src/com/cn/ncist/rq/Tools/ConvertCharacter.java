package com.cn.ncist.rq.Tools;

public class ConvertCharacter {
	public static String Convert(String s){
        String result = null;
        byte[] temp ;

        try{
            temp = s.getBytes("iso-8859-1");
            result =  new String(temp,"utf-8");
        } catch (Exception e) {
			e.printStackTrace() ;
		}
        return result;
    }
}
