package com.example.week6inclass;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Repository_LiveData {
    private MutableLiveData<String> demoString = new MutableLiveData();

    public MutableLiveData<String> getDemoString() {

        new NewFetchData().execute();
        MutableLiveData<String> updateString = demoString;
        return updateString;
    }

    private void setStringData() {
        demoString.postValue("Hey Man, Nice Shot, I came from repository");
    }

    class NewFetchData extends AsyncTask {
        String data = "";
        String singleParsed = "";
        String dataParsed = "";

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                URL url = new URL("https://api.jsonbin.io/v3/b/6039e3ec9342196a6a6913a1");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";

                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }

                JSONObject input = new JSONObject(data);
                String payload = input.getString("record");
                JSONArray JA = new JSONArray(payload);
                for (int i = 0; i < JA.length(); i++) {
                    JSONObject JO = (JSONObject) JA.get(i);
                    singleParsed = "Name: " + JO.get("name") + "\n"
                            + "Country: " + JO.get("country") + "\n"
                            + "Phone Number: " + JO.get("phone") + "\n";

                    dataParsed = dataParsed + singleParsed;
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            demoString.postValue(dataParsed);
        }
    }
}
