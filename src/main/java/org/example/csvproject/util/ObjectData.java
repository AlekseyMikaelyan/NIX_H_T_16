package org.example.csvproject.util;

import org.example.csvproject.util.annotations.CsvAnnotation;

public class ObjectData {

    @CsvAnnotation("name")
    private String name;

    @CsvAnnotation("age")
    private int age;

    @CsvAnnotation("gender")
    private Gender gender;

    @CsvAnnotation("occupation")
    private String occupation;

    public enum Gender {
        MALE,
        FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "ObjectData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
