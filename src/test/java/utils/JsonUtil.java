package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;
    static {
        mapper=new ObjectMapper();
    }

    // 1. method; Json datasini java objesdine cevirir (De-serializasyon)

    public static <T>  T convertJsonToJavaObject(String json,  Class<T> cls){
        T javaResult = null;
        try {
            javaResult= mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return javaResult;
    }


    // 2. method; Java objesini json datasina cevirir (Serializasyon)

}
