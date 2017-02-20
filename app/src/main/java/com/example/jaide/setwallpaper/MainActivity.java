package com.example.jaide.setwallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer mytimer;
    int interval=10000;
    Drawable drawable;
    WallpaperManager myWallpaperManager;
    int prev=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonSetWallpaper = (Button) findViewById(R.id.button);
        ImageView imagePreview = (ImageView) findViewById(R.id.imageView);
        imagePreview.setImageResource(R.drawable.five);

        mytimer=new Timer();
        myWallpaperManager=WallpaperManager.getInstance(MainActivity.this);

        buttonSetWallpaper.setOnClickListener(new Button.OnClickListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                /*myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());*/
                try {
                    myWallpaperManager.setResource(R.drawable.one);
                    mytimer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            if(prev==1){
                                //drawable = getResources().getDrawable(R.drawable.two);
                                try {
                                    myWallpaperManager.setResource(R.drawable.two);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                prev=2;
                            }
                            else if(prev==2){
                                try {
                                    myWallpaperManager.setResource(R.drawable.three);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                prev=3;
                            }
                            else{
                                try {
                                    myWallpaperManager.setResource(R.drawable.four);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                prev=1;
                            }


                           /* Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();

                            try {
                                myWallpaperManager.setBitmap(wallpaper);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }*/

                        }
                    }, 100, interval);


                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
}
