package com.example.tickets2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data // pour generer automatiquement getters, setters, equals(), hashCode() et toString()
@AllArgsConstructor
@NoArgsConstructor
@Builder //pour la création d'objets

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;


    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY) //à la demande,( reduire la charge sur la base)les événements ne sont chargés de manière paresseuse que lorsque cela est nécessaire.
    private List<Event> eventList = new ArrayList<>();
}
