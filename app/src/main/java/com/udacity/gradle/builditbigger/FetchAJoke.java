package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


//Step 3: Setup GCE

public class FetchAJoke extends AsyncTask<Void, Void, String> {
    private static MyApi myApi = null;

    @Override
    //run on local server comment out to run on google app engine an see comment below
    protected String doInBackground(Void... voids) {
        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setApplicationName("backend")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // uncomment to run on google app engine
            //   MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
            //          .setRootUrl("https://pongosjokes.appspot.com/_ah/api/");

            myApi = builder.build();
        }
        String joke = null;
        try {
            joke = myApi.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joke;
    }
}
