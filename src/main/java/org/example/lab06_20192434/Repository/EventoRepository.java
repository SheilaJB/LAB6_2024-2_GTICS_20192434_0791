package org.example.lab06_20192434.Repository;

import org.example.lab06_20192434.Entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Eventos, Integer> {



}
