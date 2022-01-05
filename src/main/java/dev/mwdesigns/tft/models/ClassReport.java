package dev.mwdesigns.tft.models;

public class ClassReport {

    String name;
    Double grade;

    public ClassReport(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
