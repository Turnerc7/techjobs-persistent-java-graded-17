package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Skill name cannot be blank")

    @Size(min = 1, max = 100, message = "Skill name must be between 1 and 100 characters")
    private String name;

   @Size(max = 500, message = "Description must be 500 characters or less")
    private String description;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)

//@JoinColumn(name = "skill_id")

    private List<Job> jobs = new ArrayList<>();

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
// no arg constructor
    public Skill() {
    }

    // This initializes the name and description fields. CT
    public Skill(String name, String description) {
        super();
        setName(name);  // This setter is to ensure validation - CT
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}







