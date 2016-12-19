package com.example.chekwon.projectt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView nearBy = (TextView)findViewById(R.id.nearby);

        nearBy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent nearbyIntent = new Intent(MainActivity.this,NearbyActivity.class);
                Toast.makeText(view.getContext(),"What's near?", Toast.LENGTH_SHORT).show();
                startActivity(nearbyIntent);
            }
        });

        TextView category = (TextView)findViewById(R.id.category);

        category.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent categoryIntent = new Intent(MainActivity.this,CategoryActivity.class);
                Toast.makeText(view.getContext(),"What should we eat?", Toast.LENGTH_SHORT).show();
                startActivity(categoryIntent);
            }
        });

        TextView nameSearch = (TextView)findViewById(R.id.name);
        nameSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent searchIntent = new Intent(MainActivity.this,NameActivity.class);
                Toast.makeText(view.getContext(),"What's that truck's name?", Toast.LENGTH_SHORT).show();
                startActivity(searchIntent);
            }
        });

        TextView follow = (TextView)findViewById(R.id.follow);
        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent followIntent = new Intent(MainActivity.this,FollowingActivity.class);
                Toast.makeText(view.getContext(),"What am I following?", Toast.LENGTH_SHORT).show();
                startActivity(followIntent);
            }
        });

        TextView setting = (TextView)findViewById(R.id.settings);
        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent settingIntent = new Intent(MainActivity.this,SettingActivity.class);
                Toast.makeText(view.getContext(),"Change Settings", Toast.LENGTH_SHORT).show();
                startActivity(settingIntent);
            }
        });
    }
}