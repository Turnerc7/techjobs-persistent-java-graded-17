package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job extends AbstractEntity {


    private String title = "";
    @Id
    @GeneratedValue
//    private int id;
    //    private String title;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "employer_id")// Foreign key column.
    private Employer employer;

//    @ManyToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Skill> skills = new ArrayList<>();



//    public Job(Skill skill) {
//        this.skill = new ArrayList<>();
//    }
//    @ManyToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
//private List<Skill> skills = new ArrayList<>();


    public Job(Skill skill, Employer employer, List<Skill> skills) {
        this.skill = skill;
        this.employer = employer;

    }

    public Job() {

    }
    public List<Skill> getSkills(List<Skill> skills) {
        return skills;
    }
//        public List<Skill> getSkills(List<Skill> skills) {
//        return skills;
//    }
    public List<Skill> getSkills() {
        return this.skills;
    }

    //    public Job(String anEmployer, String someSkills) {
//        super();
//        this.employer = new Employer(anEmployer, null); // Provided a nullable location for quick instantiation
//        this.skills = someSkills;
//    }
    public Job(String title, Skill skill, Employer employer) {
        this.skill = skill;
        this.title = title;
        this.employer = employer;
    }

    // Getters and setters.
    public String getName() {
        return super.getName(); // This should refer to the name in AbstractEntity
    }

    public void setName(String name) {
        super.setName(name); // This should refer to the name in AbstractEntity
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setSkills(List<Skill> skills) {
        if (skills == null) {
            throw new IllegalArgumentException("Skills set cannot be null");
        }
        this.skills = skills;
    }
}