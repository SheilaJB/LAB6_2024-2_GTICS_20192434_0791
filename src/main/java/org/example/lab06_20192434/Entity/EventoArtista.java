package org.example.lab06_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "eventos_artistas")
public class EventoArtista {

    @EmbeddedId
    private EventosArtistasId id;

    @MapsId("eventoId")
    @ManyToOne
    @JoinColumn(name = "eventoId")
    private Eventos eventoId;

    @MapsId("artistaId")
    @ManyToOne
    @JoinColumn(name = "artistaId")
    private Artistas artistaId;



}
