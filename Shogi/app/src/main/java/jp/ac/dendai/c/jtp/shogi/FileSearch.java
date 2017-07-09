package jp.ac.dendai.c.jtp.shogi;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.text.SpannableStringBuilder;

import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.EditText;

import android.widget.GridLayout;

import android.widget.LinearLayout;

import android.widget.TextView;


import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;



public class FileSearch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        TextView textview = new TextView(this);
        textview.setText("Please input FileName");
        linearLayout.addView(textview, new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        final EditText editText = new EditText(this);
        editText.setWidth(200);
        linearLayout.addView(editText, new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        Button button = new Button(this);
        button.setText("Search and Output");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder)editText.getText();
                Intent intent = new Intent(FileSearch.this,MainActivity.class);
                intent.putExtra("fileName", spannableStringBuilder.toString());
                startActivity(intent);
            }
        });
        linearLayout.addView(button, new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));

    }
}
