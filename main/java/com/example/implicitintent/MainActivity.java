package com.example.implicitintent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText et;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et);
        Button sendMail = (Button)findViewById(R.id.sendMail);
        Button openBrowser = (Button)findViewById(R.id.openBrowser);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String[] array =
                        {"nagarjuna.mandalapu@vitap.ac.in","nagarjunamandalapu1432@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL,array);
                i.putExtra(Intent.EXTRA_SUBJECT,"This is a testing mail.");
                String msg = et.getText().toString();
                i.putExtra(Intent.EXTRA_TEXT,msg);
                if(i.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(i);
                }
            }
        });
        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent();
                j.setAction(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://wwww.google.com"));
                if(j.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(j);
                }
            }
        });
    }
}