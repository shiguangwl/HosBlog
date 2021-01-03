package com.xxhoz.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxhoz.pojo.ResPojo;


public  class ResJsonUtils {
    //创建一个jackson的对象映射器，用来解析数据
    private static ObjectMapper mapper = new ObjectMapper();

    public static String Tojson(Object obj) throws JsonProcessingException {
        ResPojo respojo = new ResPojo(200,"",obj);
        String str = mapper.writeValueAsString(respojo);
        return str;
    }
    public static String Tojson(int errCode,String message,Object obj) throws JsonProcessingException {
        ResPojo respojo = new ResPojo(errCode,message,obj);
        String str = mapper.writeValueAsString(respojo);
        return str;
    }
}
