package com.example.class6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button b1;
    ImageButton ib1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= findViewById(R.id.editText);
        b1= findViewById(R.id.button);
        ib1 = findViewById(R.id.speaker);

        t1=new TextToSpeech(getApplicationContext(), status1 -> {
            if(status1 != TextToSpeech.ERROR) {
                t1.setLanguage(Locale.CANADA_FRENCH);
            }
        });

        b1.setOnClickListener(task1 -> {
            String toSpeak = ed1.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        });

        ib1.setOnClickListener(task1 -> {
            String toSpeak = ed1.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

            startActivity(new Intent(MainActivity.this, CardActivity.class));
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}