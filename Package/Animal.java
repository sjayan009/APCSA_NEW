package Package;

import javax.swing.*;
import java.awt.*;

public class Animal extends JPanel
{
    private String genus;

    private int age;

    private Color color;
    private double desirability; //dependent on Color

    private int size;

    private double hunger; /* 0 to 1 -- 0 means 0 hunger. 1 means high hunger */
    private double thirst; /* 0 to 1 -- 0 means 0 thirst. 1 means high thirst*/
    private double reproductionUrge; /* 0 to 1 -- means 0 urge to make babies. 1 means opposite */

    public Animal()
    {
        this.genus = "___";
        this.desirability = 50;
        this.age = 2;
        this.color = Color.LIGHT_GRAY;
        this.size = 2;

        this.hunger = 0.5;
        this.thirst = 0.7;
        this.reproductionUrge = 0.1;
    }

    public Animal(String str, double des, int age, Color color, double hunger, double thirst, double reproductiveUrge)
    {
        this.genus = str;

        this.age = age;

        this.color = color;
        this.desirability = des;

        this.hunger = hunger;
        this.thirst = thirst;
        this.reproductionUrge = reproductiveUrge;
    }

    // Getter and setter for genus
    public String getGenus() {
            return genus;
    }
    
    public void setGenus(String genus) {
        this.genus = genus;
    }
    
    // Getter and setter for desirability
    public double getDesirability() {
        return desirability;
    }
    
    public void setDesirability(double desirability) {
        this.desirability = desirability;
    }
    
    // Getter and setter for age
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    // Getter and setter for color
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getSizeOfAnimal()
    {
        return this.size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    // Getter and setter for hunger
    public double getHunger() {
        return hunger;
    }
    
    public void setHunger(double hunger) {
        this.hunger = hunger;
    }
    
    // Getter and setter for thirst
    public double getThirst() {
        return thirst;
    }
    
    public void setThirst(double thirst) {
        this.thirst = thirst;
    }
    
    // Getter and setter for reproductionUrge
    public double getReproductionUrge() {
        return reproductionUrge;
    }
    
    public void setReproductionUrge(double reproductionUrge) {
        this.reproductionUrge = reproductionUrge;
    } 
}
