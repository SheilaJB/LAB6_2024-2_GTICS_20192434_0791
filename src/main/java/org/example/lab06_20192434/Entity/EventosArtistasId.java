package org.example.lab06_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EventosArtistasId implements Serializable {

    @Column(name = "eventoId")
    private Integer eventoId;

    @Column(name = "artistaId")
    private Integer artistaId;


}
