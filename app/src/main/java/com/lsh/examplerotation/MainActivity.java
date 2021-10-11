package com.lsh.examplerotation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int num = 1;
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);

        textView.setText(String.valueOf(num));
        Log.d("MAIN_ACTIVITY", "onCreate");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MAIN_ACTIVITY", "onRestoreInstanceState");

        Bundle b = savedInstanceState.getBundle("key");
        if (b != null) {
            num = b.getInt("num");
            textView.setText(String.valueOf(num));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN_ACTIVITY", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAIN_ACTIVITY", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MAIN_ACTIVITY", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN_ACTIVITY", "onStop");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MAIN_ACTIVITY", "onSaveInstanceState");

        Bundle b = outState.getBundle("key");
        if (b == null) {
            b = new Bundle();
        }
        b.putInt("num", num);
        outState.putBundle("key", b);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN_ACTIVITY", "onDestroy");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            num += 1;
            textView.setText(String.valueOf(num));
        }
    }
}