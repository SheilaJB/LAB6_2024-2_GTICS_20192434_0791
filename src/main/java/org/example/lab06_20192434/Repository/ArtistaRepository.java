package org.example.lab06_20192434.Repository;


import org.example.lab06_20192434.Entity.Artistas;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artistas, Integer> {

}
