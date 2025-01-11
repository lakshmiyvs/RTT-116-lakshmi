package com.example.module_309.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_rep_employee_id")
    @ToString.Exclude
    private Employee employee;

    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private Integer salesRepEmployeeId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastname;

    @Column(name = "contact_firstname")
    private String contactFirstname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;


    @Column(name = "credit_limit", columnDefinition = "Decimal")
    private Double creditLimit;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Order> orders;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", employee=" + employee +
                ", salesRepEmployeeId=" + salesRepEmployeeId +
                ", customerName='" + customerName + '\'' +
                ", contactLastname='" + contactLastname + '\'' +
                ", contactFirstname='" + contactFirstname + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", creditLimit=" + creditLimit +
                ", orders=" + orders +
                '}';
    }
}
