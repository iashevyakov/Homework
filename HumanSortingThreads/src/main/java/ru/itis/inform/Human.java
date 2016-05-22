package ru.itis.inform;

public class Human implements Comparable<Human>{
    private int age;
    private String name;
    private int c;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(Human second) {

        int value = this.age - second.getAge();

        if (value > 0) {
            return 1;
        } else if (value < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public String toString()
    {
        return "Age "+this.age+ " Name" + this.name;
    }

}
