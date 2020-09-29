package edu.sjsu.android.techreads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView info = (TextView) findViewById(R.id.companyname_textView);
        info.setText(info.getText().toString());

        TextView version = (TextView) findViewById(R.id.version_textView);
        version.setText(version.getText().toString());

        ImageView logo = (ImageView) findViewById(R.id.logo_imageView);
        logo.setImageResource(R.drawable.logo_techreads);

        mobileNumber = "tel:+1 (669) 123-456";
        TextView mobileButton = (TextView) findViewById(R.id.mobile_textView);
        mobileButton.setText(mobileButton.getText().toString());
        mobileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buttoDialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(mobileNumber));
                startActivity(buttoDialIntent);
            }
        });
    }


}