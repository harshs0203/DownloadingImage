package com.harshs.downloadingimage;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

public void click(View view){

    Log.i("Button", "Clicked");

    //https://i.ytimg.com/vi/1roy4o4tqQM/maxresdefault.jpg
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class DownloadImage extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params) {
            return null;
        }
    }

}
