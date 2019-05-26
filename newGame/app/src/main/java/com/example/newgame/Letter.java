package com.example.newgame;

import java.util.ArrayList;
import java.util.List;

public class Letter {

    private String Name;
    private List<Float> ListOfPoints;
    private Integer PointsNumber;
    public static ArrayList<String> ListOfLetters;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public int getPointsNumber() {
        return PointsNumber;
    }

    public void setPointsNumber() {
        this.PointsNumber = ListOfPoints.size();
    }
    public List<Float> getListOfPoints() {
        return ListOfPoints;
    }

    public Letter()
    {
        ListOfLetters = new ArrayList<>();
        if(MainActivity.numberOfBoard == 3) {
            ListOfLetters.add("1literaa");
            ListOfLetters.add("2literab");
            ListOfLetters.add("3literac");
            ListOfLetters.add("4literad");
            ListOfLetters.add("5literae");
            ListOfLetters.add("6literaf");
            ListOfLetters.add("7literag");
            ListOfLetters.add("8literah");
            ListOfLetters.add("9literai");
            ListOfLetters.add("10literaj");
            ListOfLetters.add("11literak");
            ListOfLetters.add("12literal");
            ListOfLetters.add("13literam");
            ListOfLetters.add("14literan");
            ListOfLetters.add("15literao");
            ListOfLetters.add("16literap");
            ListOfLetters.add("17literar");
            ListOfLetters.add("18literas");
            ListOfLetters.add("19literat");
            ListOfLetters.add("20literau");
            ListOfLetters.add("21literaw");
            ListOfLetters.add("22literay");
            ListOfLetters.add("23literaz");
        }
        else if (MainActivity.numberOfBoard == 1)
        {
            ListOfLetters.add("1trojkat");
            ListOfLetters.add("2kwadrat");
            ListOfLetters.add("3kolo");
        }
        else if (MainActivity.numberOfBoard == 2)
        {
            ListOfLetters.add("1cyfra1");
            ListOfLetters.add("2cyfra2");
            ListOfLetters.add("3cyfra3");
            ListOfLetters.add("4cyfra4");
            ListOfLetters.add("5cyfra5");
            ListOfLetters.add("6cyfra6");
            ListOfLetters.add("7cyfra7");
            ListOfLetters.add("8cyfra8");
            ListOfLetters.add("9cyfra9");
        }

    }

    public Letter(String name, List<Float> listOfPoints)
    {
        this.Name = name;
        this.ListOfPoints = listOfPoints;
        this.PointsNumber = listOfPoints.size();
    }







}
