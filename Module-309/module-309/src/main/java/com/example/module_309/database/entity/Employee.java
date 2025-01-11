package com.example.module_309.database.entity;


import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    // the @ID annotation tells hibernate that this is the primary key for this entity
    @Id
    // this tells hibernate that the database will auto increment the new ID for a new record in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this defines the database column
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Customer> customers;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "office_id")
    private int officeId;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private Integer vacationHours;
    @Column(name = "profile_image_url")
    private String profileImageUrl;

    public Employee() {

    }

    public Employee(int id, String lastname, String firstname, int officeId, String extension, String email, int reportsTo, String jobTitle, int vacationHours, String profileImageUrl) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.officeId = officeId;
        this.extension = extension;
        this.email = email;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
        this.vacationHours = vacationHours;
        this.profileImageUrl = profileImageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getVacationHours() {
        return vacationHours;
    }

    public void setVacationHours(Integer vacationHours) {
        this.vacationHours = vacationHours;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }


    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", officeId=" + officeId +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                ", vacationHours=" + vacationHours +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                '}';
    }


}
