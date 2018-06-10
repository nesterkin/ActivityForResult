package com.github.nesterkin.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String VALUE = "value";
    private static final int REQUEST_CODE = 123;

    private EditText mEditText;
    private Button mFirstButton;
    private Button mSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews() {
        mEditText = findViewById(R.id.edit_text);
        mFirstButton = findViewById(R.id.first_button);
        mSecondButton = findViewById(R.id.second_button);
    }

    private void initListeners() {
        mFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(VALUE, mEditText.getText().toString());
                startActivity(MainActivity2.newIntent(getApplicationContext(), mEditText.getText().toString()));
            }
        });

        mSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                intent.putExtra(VALUE, mEditText.getText().toString());
                startActivityForResult(MainActivity3.newIntent(getApplicationContext(), mEditText.getText().toString()), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                mEditText.setText(data.getStringExtra(VALUE));
            }
        }
    }
}