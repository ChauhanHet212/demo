package com.example.studentinfo.Models;

public class StudentInfo {
    int id;
    String fullName, course, dob, adTime, gender, languages;

    public StudentInfo(int id, String fullName, String course, String dob, String adTime, String gender, String languages) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.dob = dob;
        this.adTime = adTime;
        this.gender = gender;
        this.languages = languages;
    }

    public StudentInfo(String fullName, String course, String dob, String adTime, String gender, String languages) {
        this.fullName = fullName;
        this.course = course;
        this.dob = dob;
        this.adTime = adTime;
        this.gender = gender;
        this.languages = languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAdTime() {
        return adTime;
    }

    public void setAdTime(String adTime) {
        this.adTime = adTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
