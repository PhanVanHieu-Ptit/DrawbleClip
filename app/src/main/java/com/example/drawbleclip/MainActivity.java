package com.example.drawbleclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    
    ImageView imageViewHinh;
    Button btnClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewHinh = (ImageView) findViewById(R.id.imageView);
        btnClip = (Button) findViewById(R.id.button);

        imageViewHinh.setImageLevel(1000);

        ClipDrawable clipDrawable = (ClipDrawable) imageViewHinh.getDrawable();

        btnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int currentLevel= clipDrawable.getLevel();
                        if (currentLevel>=10000){
                            currentLevel=0;
                        }
                        imageViewHinh.setImageLevel(currentLevel+1000);
                        handler.postDelayed(this,500);
                    }
                },2000);


            }
        });


    }
}