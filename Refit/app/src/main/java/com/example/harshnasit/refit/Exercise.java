package com.example.harshnasit.refit;

import java.util.ArrayList;

public class Exercise {

    private String name;
    private ArrayList<String> bodyParts;
    private ArrayList<String> equipments;
    private String instructions;


    public Exercise(String name){
        this.name = name;
        this.instructions = "";
        this.bodyParts = new ArrayList<>();
        this.equipments = new ArrayList<>();

    }

    public void addEquipment(String equipment){
        equipments.add(equipment);
    }

    public void addBodyPart(String part){
        bodyParts.add(part);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
