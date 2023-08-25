package com.jobi_jobatch.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "public", name = "t_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq_generator")
    @SequenceGenerator(name = "room_seq_generator", sequenceName = "t_room_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "accessibility")
    private Boolean accessibility;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;
}
