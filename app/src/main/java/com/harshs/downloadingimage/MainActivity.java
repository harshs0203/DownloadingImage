package com.harshs.downloadingimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.spec.ECField;
import java.sql.Connection;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView downloadedImg;

public void click(View view){

    Log.i("Button", "Clicked");

    //https://i.ytimg.com/vi/1roy4o4tqQM/maxresdefault.jpg

    DownloadImage image =new DownloadImage();
    Bitmap myBitmap;

    try {

        myBitmap= image.execute("https://i.ytimg.com/vi/1roy4o4tqQM/maxresdefault.jpg").get();

      downloadedImg.setImageBitmap(myBitmap);

    } catch (InterruptedException e) {

        e.printStackTrace();

    } catch (ExecutionException e) {

        e.printStackTrace();

    }


}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadedImg= (ImageView) findViewById(R.id.imageView2);
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);

                HttpURLConnection htppConnection = (HttpURLConnection) url.openConnection();

                htppConnection.connect();

                InputStream input = htppConnection.getInputStream();

                Bitmap bitMap = BitmapFactory.decodeStream(input);

                return bitMap;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
