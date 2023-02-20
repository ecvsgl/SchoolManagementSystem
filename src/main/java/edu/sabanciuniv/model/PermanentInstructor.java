package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor {

    private double fixedSalary;

    public PermanentInstructor(String instructorName, String instructorAddress, String instructorPhone, double fixedSalary) {
        super(instructorName, instructorAddress, instructorPhone);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(){}

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double hourlySalary) {
        this.fixedSalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}' + super.toString();
    }
}
