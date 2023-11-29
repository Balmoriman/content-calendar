package dev.balNetlTI.contentcalendar.Repository;
import  dev.balNetlTI.contentcalendar.model.Content;
import dev.balNetlTI.contentcalendar.model.Status;
import dev.balNetlTI.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    //para traer  el contenido
    public List<Content> findAll() {
        return content;
    }

    //para traer solo un registro
    public Optional<Content> findById(Integer id){
        return content.stream().filter( d -> d.id().equals(id)).findFirst();
    }

    // se ejecuta despues de la injeccion de dependencias
    @PostConstruct
    private void init() {
        //simulamos que tenemos datos y los insertamos a la lista de content
        Content c = new Content(
                 1,
                 "mi primer post de blog",
                 "primer post de blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                 null,
                 "");

        content.add(c);

    }
}
