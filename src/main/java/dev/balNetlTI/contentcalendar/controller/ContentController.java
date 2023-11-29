package dev.balNetlTI.contentcalendar.controller;

import dev.balNetlTI.contentcalendar.Repository.ContentCollectionRepository;
import dev.balNetlTI.contentcalendar.model.Content;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//en el controlador es la coneccion con el front se esta mandando a llamar la logica de negocio
//que esta en repository, en repository es donde van las operaciones de negocio
@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    //controller que nos trae registros
    @GetMapping("")
    public List<Content> findAll(){
        return  repository.findAll();
    }

    //controller que nos trae un solo registro , se le pone una condicion que si no encuentra dicho id se regresa un error http 400
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }
}
