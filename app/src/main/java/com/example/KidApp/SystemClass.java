package com.example.KidApp;

import android.app.Application;

import com.example.KidApp.R;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class SystemClass extends Application {
    public static ArrayList<Animals> collectedAnimals = new ArrayList<>();


    static Animals ant = new Animals("ant", R.raw.ant);
    static Animals bear = new Animals("bear", R.raw.bear);
    static Animals bee = new Animals("bee", R.raw.bee);
    static Animals bird = new Animals("bird", R.raw.bird);
    static Animals butterfly = new Animals("butterfly", R.raw.butterfly);
    static Animals camel = new Animals("camel", R.raw.camel);
    static Animals cat = new Animals("cat", R.raw.cat);
    static Animals chick = new Animals("chick", R.raw.chick);
    static Animals cow = new Animals("cow", R.raw.cow);
    static Animals dolphin = new Animals("dolphin", R.raw.dolphin);
    static Animals donkey = new Animals("donkey", R.raw.donkey);
    static Animals elephant = new Animals("elephant", R.raw.elephant);
    static Animals fish = new Animals("fish", R.raw.fish);
    static Animals giraffe = new Animals("giraffe", R.raw.giraffe);
    static Animals horse = new Animals("horse", R.raw.horse);
    static Animals lamb = new Animals("lamb", R.raw.lamb);
    static Animals lion = new Animals("lion", R.raw.lion);
    static Animals monkey = new Animals("monkey", R.raw.monkey);
    static Animals penguin = new Animals("penguin", R.raw.penguin);
    static Animals rabbit = new Animals("rabbit", R.raw.rabbit);



    static ArrayList<Animals> animalList = new ArrayList<Animals>();


    //Bu metodda bütün hayvanların bulunduğu listedeki tüm hayvanları farklı bir listeye alıyoruz ve içlerinden rastgele seçilenleri seçip ekrana göndereceğiz.
    public static ArrayList<Animals> animal_collector(int number)
    {
        Random rand = new Random();
        int upperbound=0;
        ArrayList<Animals> collectedAnimals = new ArrayList<Animals>();
        collectedAnimals.clear();
        ArrayList<Animals> allAnimals = new ArrayList<Animals>();
        allAnimals.clear();
        for(int i=0;i<animalList.size();i++)
        {
            allAnimals.add(animalList.get(i));
        }

       for(int i =0;i<number;i++)
       {
           upperbound = allAnimals.size();
           //generate random values from 0-24
           int int_random = rand.nextInt(upperbound);

           collectedAnimals.add(allAnimals.get(int_random));
           allAnimals.remove(int_random);
       }
       return collectedAnimals;
    }

    //Rastgele seçilen hayvanlardan 1 tanesini seçiyoruz ve kullanıcının bu hayvanı işaretlemesi gerekiyor.
    public static Animals animal_selector(ArrayList<Animals> List)
    {
        Random rand = new Random();
        int upperbound= List.size();
        int int_random=rand.nextInt(upperbound);

        return List.get(int_random);
    }


}

