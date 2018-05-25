package com.example.dessy.resepmamake;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {

    LinearLayout header, footer;
    Animation uptodown;
    Animation downtoup;

    private static int SPLASHTIMEOUT = 1800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        header= (LinearLayout) findViewById(R.id.headersplash);
        footer= (LinearLayout) findViewById(R.id.footersplash);
        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        header.setAnimation(uptodown);
        downtoup= AnimationUtils.loadAnimation(this,R.anim.downtoup);
        footer.setAnimation(downtoup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(goMain);
                finish();
            }
        }, SPLASHTIMEOUT);

    }
}
