package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
//   @JoinColumn(name = "employer_id")

    private List<Job> jobs = new ArrayList<Job>();

    @NotBlank(message = "Location cannot be blank")
    @Size(min = 1, max = 100, message = "Location must be between 1 and 100 characters")
    public String location;

        //No arg constructor - CT
        public Employer() {
        }

        // This initializes the id, name, and location fields. CT
        public Employer(String name, String location) {
            super();
            setName(name);  // This setter is to ensure validation - CT
            this.location = location;
        }
    public java.util.List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(java.util.List<Job> jobs) {
        this.jobs = jobs;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



