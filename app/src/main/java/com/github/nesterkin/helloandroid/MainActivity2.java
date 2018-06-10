package com.github.nesterkin.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.github.nesterkin.helloandroid.MainActivity.VALUE;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTextView;

    public static Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, MainActivity2.class);
        intent.putExtra(VALUE, text);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Screen 2");
        mTextView = findViewById(R.id.text_view);
        mTextView.setText(getIntent().getStringExtra(VALUE));
    }
}