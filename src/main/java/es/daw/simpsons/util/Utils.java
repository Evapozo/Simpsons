package es.daw.simpsons.util;

public class Utils {

    /**
     * Convierte un texto a un Integer
     * @param nombreCampo nombre del campo
     * @param valor
     * @return un Integer ....
     * @throws Exception
     */
    public static Integer leerEntero(String nombreCampo, String valor) throws Exception{

        // 1. Comprobamos si valor es null y vacío
        if (valor == null || valor.isEmpty()){
            return null;
        }

        // 2. Comprobamos que el texto se puede convertir a un entero
        Integer num;
        try {
            num = Integer.valueOf(valor);  // lanza un NumberFormatException
        }catch (NumberFormatException e){
            // Crear y propagar un excepción checked genérica
            throw new Exception("El campo "+nombreCampo+" debe ser un número entero.");
        }

        // 3. Comprobamos que no admite negativos
        if (num < 0){
            throw new Exception("El campo "+nombreCampo+" debe ser positivo.");
        }

        return num;


    }
}