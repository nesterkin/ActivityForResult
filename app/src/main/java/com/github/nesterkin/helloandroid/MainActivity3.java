package com.github.nesterkin.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import static com.github.nesterkin.helloandroid.MainActivity.VALUE;

public class MainActivity3 extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("Screen 3");
        mEditText = findViewById(R.id.edit_text);
        mEditText.setText(getIntent().getStringExtra(VALUE));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(VALUE, mEditText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}