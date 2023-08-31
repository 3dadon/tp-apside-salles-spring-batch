package com.jobi_jobatch.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "public", name = "t_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq_generator")
    @SequenceGenerator(name = "booking_seq_generator", sequenceName = "t_booking_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "debutDate")
    private Date debutDate;

    @Column(name = "endDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
