package com.example.dessy.resepmamake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailResepMinuman extends AppCompatActivity {

    private TextView tv_title;
    private ImageView im_Thumbnail;
    private TextView tv_penjelasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep_minuman);

        tv_title = (TextView) findViewById(R.id.tv_judul);
        im_Thumbnail = (ImageView) findViewById(R.id.im_gambar);
        tv_penjelasan = (TextView) findViewById(R.id.tv_penjelasan);

        // Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Penjelasan = intent.getExtras().getString("Penjelasan");
        int image = intent.getExtras().getInt("Thumbnail");

        // Setting values

        getSupportActionBar().setTitle(Title);
        tv_title.setText(Title);
        tv_penjelasan.setText(Penjelasan);
        im_Thumbnail.setImageResource(image);


    }
}
