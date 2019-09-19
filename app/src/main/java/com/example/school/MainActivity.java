package com.example.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {
  // private Button btn;
  private Locale myLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setLocale("mr");
         //{
        final String num1=getString(R.string.string_principalNo_school1);
        TextView textView1=findViewById(R.id.id_principal_school1);
        String text1=getString(R.string.string_principal_school1);
        SpannableString ss1=new SpannableString(text1);
        ClickableSpan telephone1=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+num1));
                startActivity(intent);
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss1.setSpan(telephone1,53,63, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView1.setText(ss1);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
        //}
    }


}

