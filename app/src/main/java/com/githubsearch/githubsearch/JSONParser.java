package com.githubsearch.githubsearch;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParser {
    private static String json = "";
    private static JSONObject obj = null;
    private static JSONArray objArr = null;


    public JSONParser() {
    }

    public JSONObject getJSONFromUrl(String url) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL newUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) newUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            int statusCode = urlConnection.getResponseCode();

            if (statusCode != 200) {
                return null;
            }

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                json = stringBuilder.toString();
            } catch (FileNotFoundException e) {
                Log.e("NO FILE: ", e.toString());

            } finally {
                urlConnection.disconnect();
            }

            // try parse the string to a JSON object
            try {
                //jObj = new JSONObject(json);
                Object jsonCheck = new JSONTokener(json).nextValue();
                if (jsonCheck instanceof JSONObject) {
                    obj = new JSONObject(json);
                } else if (jsonCheck instanceof JSONArray) {
                    JSONArray responseObj = new JSONArray(json);
                    for (int i = 0; i < responseObj.length(); i++) {
                        obj = responseObj.getJSONObject(i);
                    }
                } else {
                    obj = null;
                }


            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

            // return JSON Object
            return obj;

        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }

    }


    public JSONArray getJSONArrayFromUrl(String url) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL newUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) newUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            int statusCode = urlConnection.getResponseCode();

            if (statusCode != 200) {
                return null;
            }

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                json = stringBuilder.toString();
            } catch (FileNotFoundException e) {
                Log.e("NO FILE: ", e.toString());

            } finally {
                urlConnection.disconnect();
            }

            // try parse the string to a JSON object
            try {
                //jObj = new JSONObject(json);
                Object jsonCheck = new JSONTokener(json).nextValue();
                if (jsonCheck instanceof JSONArray) {
                    objArr = new JSONArray(json);
                } else {
                    objArr = null;
                }


            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data " + e.toString());
            }

            // return JSON Object
            return objArr;

        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }

    }

//    public JSONObject getJSONFromUrl(String url) {
//
//        try {
//            URL newUrl = new URL(url);
//            HttpURLConnection urlConnection = (HttpURLConnection) newUrl.openConnection();
//            try {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                StringBuilder stringBuilder = new StringBuilder();
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(line).append("\n");
//                }
//                bufferedReader.close();
//                json = stringBuilder.toString();
//            }
//            finally{
//                urlConnection.disconnect();
//            }
//
//            // try parse the string to a JSON object
//            try {
//                //jObj = new JSONObject(json);
//                Object jsonCheck = new JSONTokener(json).nextValue();
//                if (jsonCheck instanceof JSONObject) {
//                    obj = new JSONObject(json);
//                } else if (jsonCheck instanceof JSONArray) {
//                    JSONArray responseObj = new JSONArray(json);
//                    for (int i = 0; i < responseObj.length(); i++) {
//                        obj = responseObj.getJSONObject(i);
//                    }
//                }
//
//
//            } catch (JSONException e) {
//                Log.e("JSON Parser", "Error parsing data " + e.toString());
//            }
//
//            // return JSON String
//            return obj;
//
//        }
//        catch(Exception e) {
//            Log.e("ERROR", e.getMessage(), e);
//            return null;
//        }
//
//    }

}
