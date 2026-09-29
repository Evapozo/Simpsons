package es.daw.simpsons.servicio;

import es.daw.simpsons.model.Personaje;
import es.daw.simpsons.repository.PersonajeRepository;

import java.util.List;

/*
aqui vive toda la logica de los strings
el servlet no filtra ni ordena
 */
public class PersonajeServicio {
    //en spring aprenderemos a usar inyeccion de dependencia y no usar new...
    private final PersonajeRepository repository = new PersonajeRepository();

    public List<Personaje> buscar(){
        return repository.findAll();
    }
}
