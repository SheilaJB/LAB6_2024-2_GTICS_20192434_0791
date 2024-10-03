package org.example.lab06_20192434.Controller;

import org.example.lab06_20192434.Entity.Artistas;
import org.example.lab06_20192434.Repository.ArtistaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.module.FindException;
import java.util.List;

@Controller
@RequestMapping("/artistas")
public class ArtistaController {


    final ArtistaRepository artistaRepository;

    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }


    @GetMapping("/listarArtista")
    public String listarArtista(Model model) {
        List<Artistas> artistas = artistaRepository.findAll();
        model.addAttribute("artistas", artistas);
        return "Artista/listaArtistas";

    }
}
