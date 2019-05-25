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
        ListOfLetters.add("1literaa");
        ListOfLetters.add("2literab");
        ListOfLetters.add("3literac");
        ListOfLetters.add("4literad");
        ListOfLetters.add("5literae");
        ListOfLetters.add("6literaf");
    }

    public Letter(String name, List<Float> listOfPoints)
    {
        this.Name = name;
        this.ListOfPoints = listOfPoints;
        this.PointsNumber = listOfPoints.size();
    }







}
