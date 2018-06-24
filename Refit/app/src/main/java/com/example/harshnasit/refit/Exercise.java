package com.example.harshnasit.refit;

import java.util.ArrayList;

public class Exercise {

    private String name;
    private ArrayList<String> bodyParts;
    private ArrayList<String> equipments;
    private String instructions;


    /**
     * Public constructor for exercise
     * @param name name of exercise
     */
    public Exercise(String name){
        this.name = name;
        this.instructions = "";
        this.bodyParts = new ArrayList<>();
        this.equipments = new ArrayList<>();

    }

    /**
     * Returns a clone of this exercise
     * @return clone of this exercise
     */
    public Exercise clone(){
        try {
            return (Exercise) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
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
