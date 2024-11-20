package org.example.database.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;


    @Column(name = "order_date", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "required_date", columnDefinition = "DATE")
    private Date requiredDate;

    @Column(name = "shipped_date", columnDefinition = "DATE")
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderDetail> orderdetails;
}
