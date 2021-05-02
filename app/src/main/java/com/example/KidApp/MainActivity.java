package com.example.KidApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    public static int bestPoint;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Animals bird = new Animals("bird", R.raw.bird);
        ImageView img= (ImageView) findViewById(R.id.image);
        img.setImageResource(bird.image);*/


        //we read the file to initiliaze bestpoint at the starting of the app
        try {
            FileInputStream fis = openFileInput("score");
            Scanner scanner = new Scanner(fis);
             bestPoint = scanner.nextInt();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //we add the created animals to arraylist to pick them randomly
        SystemClass.animalList.add(SystemClass.ant);
        SystemClass.animalList.add(SystemClass.bear);
        SystemClass.animalList.add(SystemClass.bee);
        SystemClass.animalList.add(SystemClass.bird);
        SystemClass.animalList.add(SystemClass.butterfly);
        SystemClass.animalList.add(SystemClass.camel);
        SystemClass.animalList.add(SystemClass.cat);
        SystemClass.animalList.add(SystemClass.chick);
        SystemClass.animalList.add(SystemClass.cow);
        SystemClass.animalList.add(SystemClass.dolphin);
        SystemClass.animalList.add(SystemClass.donkey);
        SystemClass.animalList.add(SystemClass.elephant);
        SystemClass.animalList.add(SystemClass.fish);
        SystemClass.animalList.add(SystemClass.giraffe);
        SystemClass.animalList.add(SystemClass.horse);
        SystemClass.animalList.add(SystemClass.lamb);
        SystemClass.animalList.add(SystemClass.lion);
        SystemClass.animalList.add(SystemClass.monkey);
        SystemClass.animalList.add(SystemClass.penguin);
        SystemClass.animalList.add(SystemClass.rabbit);

        TextView best = (TextView) findViewById(R.id.Mbest);
        best.setText("Best Score: "+String.valueOf(bestPoint));
    }

    int point=0;

    public void startgame(View v)
    {
        Intent intent = new Intent(this, Level1.class);
        intent.putExtra("point",point);
        startActivity(intent);
        finish();
    }

    public void reset(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("point",point);
        startActivity(intent);
        //we change the content of the score file to reset the best score
        try {
            FileOutputStream fos = openFileOutput("score", Context.MODE_PRIVATE);
            int num =0;
            fos.write(String.valueOf(num).getBytes());
            fos.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        finish();

    }




}