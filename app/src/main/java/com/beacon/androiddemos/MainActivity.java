package com.beacon.androiddemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.beacon.newsreader.NewsReaderActivity;
import com.beacon.newsreader.TestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupExamples();
    }

    protected void setupExamples() {
        Button btn = (Button)findViewById(R.id.show_news_reader_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                //Intent intent = new Intent("com.beacon.newsreader.NewsDetailActivity");
                //Intent intent = new Intent("com.beacon.newsreader.NewsReaderActivity");
                startActivity(intent);
            }
        });
    }
}
