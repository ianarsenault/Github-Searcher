package com.githubsearch.githubsearch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParser {
    private static JSONObject jObj = null;
    private static JSONArray jArr;
    private static String json = "";
    private static JSONObject obj = null;


    public JSONParser() {}

    public JSONObject getJSONFromUrl(String url) {

        try {
            URL newUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) newUrl.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                json = stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }


            // try parse the string to a JSON object
            try {
                //jObj = new JSONObject(json);


                // IF ARRAY OF OBJECTS

                Object jsonCheck = new JSONTokener(json).nextValue();
                if (jsonCheck instanceof JSONObject) {
                    obj = new JSONObject(json);
                } else if (jsonCheck instanceof JSONArray) {
                    JSONArray responseObj = new JSONArray(json);
                    for (int i = 0; i < responseObj.length(); i++) {
                        obj = responseObj.getJSONObject(i);
                    }
                }

//                JSONArray responseObj = new JSONArray(json);
//                for (int i = 0; i < responseObj.length(); i++) {
//                    obj = responseObj.getJSONObject(i);
//                }
//
//                // ELSE
//                obj = new JSONObject(json);


            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

            // return JSON String
            return obj;

        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }

    }

}
