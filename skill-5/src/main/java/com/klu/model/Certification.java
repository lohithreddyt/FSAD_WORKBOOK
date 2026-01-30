package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String course;
    private String dateOfCompletion;

    public Certification() {
        this.id = 301;
        this.course = "Spring Core";
        this.dateOfCompletion = "25-Jan-2026";
    }

    @Override
    public String toString() {
        return "Course [id=" + id +
               ", course=" + course +
               ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
