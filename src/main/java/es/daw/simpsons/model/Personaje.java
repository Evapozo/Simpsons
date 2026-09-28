package es.daw.simpsons.model;

/**
 * getters, setters, equals, hasCode, tString...
 * @param nombre
 * @param apellido
 * @param edad
 * @param ocupacion
 * @param lugar
 * @param principal
 * @return
 */
public record Personaje (
        String nombre,
        String apellido,
        int edad,
        String ocupacion,
        String lugar,
        boolean principal

){

    public String nombreCompleto() {

        return apellido.isBlank() ? nombre : nombre + " " + apellido;
    }

    public boolean esMenor(){

        return edad < 18;
    }

}
