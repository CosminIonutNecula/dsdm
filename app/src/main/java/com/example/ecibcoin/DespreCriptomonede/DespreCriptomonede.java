package com.example.ecibcoin.DespreCriptomonede;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ecibcoin.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DespreCriptomonede extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despre_criptomonede);

        textView=findViewById(R.id.despreCriptomonede);
        textView.setMovementMethod(new ScrollingMovementMethod());

        String date;
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = this.getResources().openRawResource(R.raw.desprecriptomonede);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        if(inputStream != null)
        {
            try {
                while((date = bufferedReader.readLine())!=null) {
                    stringBuffer.append(date).append("\n").append("\t");
                }
                textView.setText(stringBuffer);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}