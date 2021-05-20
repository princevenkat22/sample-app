package com.m2p.sampleapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request_tb")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double inp1;
    private double inp2;
    private char operator;
    private Double output;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date ason;
}
