package com.github.nesterkin.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private static String mText;
    private TextView mTextView;

    public static Intent newIntent(Context context, String text) {
        mText = text;
        return new Intent(context, MainActivity2.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Screen 2");
        mTextView = findViewById(R.id.text_view);
        mTextView.setText(mText);
    }
}