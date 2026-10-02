package es.daw.simpsons.servicio;

import es.daw.simpsons.model.Personaje;
import es.daw.simpsons.repository.PersonajeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Aquí vive TODA la lógica de los streams
 * El servlet no filtra ni ordena
 */
public class PersonajeServicio {

    // En Spring aprenderemos a usar inyección de dependencia y no usar new...
    private final PersonajeRepository repositorio = new PersonajeRepository();

    /**
     *
     * @param lugar
     * @param edadMax
     * @param ordernaPor
     * @param descendente
     * @param limite
     * @return
     */
    public List<Personaje> buscar(String lugar,
                                  Integer edadMax,
                                  String ordernaPor, // pendiente
                                  boolean descendente, // pendiente
                                  Integer limite
    ) {

        return repositorio.findAll().stream()
                .filter( p -> lugar == null || lugar.isBlank() || p.lugar().equalsIgnoreCase(lugar))
                .filter(p -> edadMax == null || p.edad() <= edadMax)
                .sorted( (p1, p2) -> p1.nombre().compareTo(p2.nombre()))
                .limit(limite == null? Integer.MAX_VALUE : limite)
                .toList();
    }

    /**
     *
     * @return
     */
    public List<String> lugaresDisponibles(){
        // FORMA 1: funcional
        return repositorio.findAll().stream()
                //.map(p -> p.lugar())
                .map(Personaje::lugar)
                .distinct()
                .sorted()
                .toList();
        //.collect(Collectors.toList());
        // FORMA 2: IMPERATIVO

        // FORMA 3: convierto a Set (conjunto no repetido..)

    }


}