package com.example.android.jokelibrary;

import java.util.Random;

//Step 1: Create a Java library

public class JokeClass {
    //returns a random joke from the list of 5
    public static String pickAJoke() {
        Random rand = new Random();
        int n = rand.nextInt(5);
        String joke1 = "Q: What do you call a fake noodle? \n A: An Impasta";
        String joke2 = "Q: What do you call an alligator in a vest? \n A: An Investigator";
        String joke3 = "Q: What do you call a pile of kittens? \n A: A meowntain";
        String joke4 = "Q: What do you call a baby monkey? \n A: A Chimp off the old block";
        String joke5 = "Q: Did you hear about the hungry clock? \n A: It went back four seconds";
        String jokes[] = {joke1, joke2, joke3, joke4, joke5};
        return jokes[n];
    }

}
