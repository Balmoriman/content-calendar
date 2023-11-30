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
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    //para traer  el contenido
    public List<Content> findAll() {
        return contentList;
    }

    //para traer solo un registro
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(d -> d.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id())); // esto es inmemory
        contentList.add(content);

    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(d -> d.id().equals(id)).count() == 1;
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

        contentList.add(c);

    }

    public void deleterecord(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
