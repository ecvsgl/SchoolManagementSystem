package edu.sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    // class fields - variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;

    private String studentBirthDate;

    private String studentAdress;

    private String studentGender;

    @ManyToMany (mappedBy = "studentList")
    private List<Course> courseList= new ArrayList<>();

    // Constructors full & empty

    public Student(String studentName, String studentBirthDate, String studentAdress, String studentGender) {
        this.studentName = studentName;
        this.studentBirthDate = studentBirthDate;
        this.studentAdress = studentAdress;
        this.studentGender = studentGender;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(String studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentBirthDate='" + studentBirthDate + '\'' +
                ", studentAdress='" + studentAdress + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", courseList=" + courseList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentName.equals(student.studentName) && studentBirthDate.equals(student.studentBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, studentBirthDate);
    }
}
