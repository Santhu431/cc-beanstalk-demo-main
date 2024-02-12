package com.cumuluscycles.contacts.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "contact")
@Data
public class Contact {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contact_name", nullable = false)
    private String name;

    @Column(name = "contact_email", nullable = false)
    private String email;

    @Column(name = "contact_cell")
    private String cell;
}
