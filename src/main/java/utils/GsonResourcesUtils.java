package utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonResourcesUtils {


    public static <T> T convertJSONToPOJO(String JSON, Type type){
        return getGson().fromJson(JSON, type);
    }

    public static String convertToJSON(Object object){
        return getGson().toJson(object);
    }

    private static Gson getGson(){
        return new Gson();
    }
}
