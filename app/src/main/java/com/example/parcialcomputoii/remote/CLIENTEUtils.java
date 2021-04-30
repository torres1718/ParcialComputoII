package com.example.parcialcomputoii.remote;

public class CLIENTEUtils {

    public CLIENTEUtils(){
    }
    public static final String API_URL="http://192.168.1.19/";
    public static CLIENTEUtils getClientAPI(){
        return RetrofitClient.getClient(API_URL).create(CLIENTEUtils.class);
    }

}
