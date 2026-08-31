package com.example.ecom.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue()
    private Integer id;

    private String orderId;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @Column(unique = true)
    private String Name;
    private String Email;
    private String status;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate orderdate;
    

    @PrePersist
    public void genrateId(){
        if (orderId == null || orderId.isEmpty()){
            orderId = "OD"+UUID.randomUUID()
            .toString()
            .replace("-","")
            .substring(0,9)
            .toUpperCase();

        }
    }
}
