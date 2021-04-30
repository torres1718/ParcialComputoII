package com.example.parcialcomputoii.remote;

import com.example.parcialcomputoii.interfarces.ClienteAPI;

public class CLIENTEUtils {

    public CLIENTEUtils(){
    }
    public static final String API_URL="http://192.168.1.18/";
    public static ClienteAPI getClientAPI(){
        return RetrofitClient.getClient(API_URL).create(ClienteAPI.class);
    }

}
