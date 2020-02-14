package com.shuayb.capstone.android.crypfolio.DataUtils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.shuayb.capstone.android.crypfolio.MainActivity;
import com.shuayb.capstone.android.crypfolio.POJOs.Crypto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtils {

    private static final String TAG = "JsonUtils";


    //Creates the ArrayList of Crypto data using Gson library and some manual parsing
    public static ArrayList<Crypto> convertJsonToCryptoList(String jsonData) {
        ArrayList<Crypto> cryptos = new ArrayList<Crypto>();

        if (jsonData != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonData);

                //Give Gson our custom adapter so it only pulls the information we want
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Crypto.class, new GsonCustomDeserializer());

                for (int i = 0; i < jsonArray.length(); i++) {
                    Crypto crypto = gsonBuilder.create().fromJson(jsonArray.getJSONObject(i).toString(), Crypto.class);
                    cryptos.add(crypto);
                }

            } catch (JSONException e) {
                Log.e(TAG, "JSON Exception Error!!!!!!!  " + e.getMessage());
                //No half measures!
                cryptos.clear();
                return cryptos;
            }
        }
        return cryptos;
    }

}
