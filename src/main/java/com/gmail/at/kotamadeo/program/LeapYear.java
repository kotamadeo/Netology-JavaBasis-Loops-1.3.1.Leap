package com.gmail.at.kotamadeo.program;

public class LeapYear {
    private int year;
    private int days;

    public int getDays() {
        return days;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            this.year = year;
            days = 366;
            return true;
        } else if (year % 100 == 0) {
            this.year = year;
            days = 365;
        } else if (year % 4 == 0) {
            this.year = year;
            days = 366;
            return true;
        } else {
            this.year = year;
            days = 365;
        }
        return false;
    }
}
