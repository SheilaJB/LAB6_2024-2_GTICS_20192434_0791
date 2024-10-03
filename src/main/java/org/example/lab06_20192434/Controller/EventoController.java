package org.example.lab06_20192434.Controller;

import org.example.lab06_20192434.Entity.Eventos;
import org.example.lab06_20192434.Repository.EventoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    //Listar Eventos
    @GetMapping("/listarEvento")
    public String listarEventos(Model model) {

        List<Eventos> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        return "Eventos/listaEventos";
    }

    //Guardar cambios
    @PostMapping("/save")
    public String save(@ModelAttribute("eventos") Eventos eventos, RedirectAttributes attr) {
        eventoRepository.save(eventos);
        attr.addFlashAttribute("msg", "Evento guardado com éxito!");
        return "redirect:/eventos/listarEvento";
    }

    @GetMapping("new")
    public String newEvento(Model model) {
        List<Eventos> eventos = eventoRepository.findAll();
        model.addAttribute("eventos", eventos);
        return "/Eventos/formEventoNew";
    }

    @GetMapping("/edit")
    public String editEvento(Model model, @RequestParam("id") int id){

        Optional<Eventos> evento = eventoRepository.findById(id);
        if(evento.isPresent()) {
            model.addAttribute("eventos", evento.get());
            return "Eventos/formEventosEdit";
        }else {
            return "redirect:/eventos/listarEvento";
        }
    }

    @GetMapping("/delete")
    public String deleteEvento(Model model, @RequestParam("id") int id, RedirectAttributes attr) {
        Optional<Eventos> evento = eventoRepository.findById(id);
        if(evento.isPresent()) {
            eventoRepository.deleteById(id);
        }
        attr.addFlashAttribute("msg", "Evento removido com éxito!");
        return "redirect:/eventos/listarEvento";

    }

}
