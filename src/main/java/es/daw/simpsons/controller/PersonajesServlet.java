package es.daw.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import es.daw.simpsons.model.Personaje;
import es.daw.simpsons.servicio.PersonajeServicio;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {

    //con spring aprenderemos a inyectar los servicios en los controladores @Autowired!! y no usaremos new!!

    private final PersonajeServicio servicio = new PersonajeServicio();

    public void init(ServletConfig config) throws ServletException {
        super.init(config);


    }

    private static final Logger LOGGER = Logger.getLogger(PersonajesServlet.class.getName());
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //1.LEER PARÁMETROS DEL REQUEST


        String lugar = request.getParameter("lugar");
        System.out.println("lugar: " + lugar);

        String ordenarPor = request.getParameter("ordenarPor");
        System.out.println("ordenarPor: " + ordenarPor);
        //boolean descendente = request.getParameter("descendente") != null ?
                //Boolean.parseBoolean(request.getParameter("descendente")) : false;
        boolean descendente = request.getParameter("descendente") != null; //si no se marca viajará un nulo
        System.out.println("descendente: " + descendente);

        //PENDIENTE!!!!deberiamos convertirlos a un entero
        String edadMax = request.getParameter("edadMax");
        System.out.println("edadMax: " + edadMax);
        //int edadMaxInt = Integer.parseInt(edadMax);
        try {
            Integer edadMaxInteger = Integer.valueOf(request.getParameter("edadMax"));
            System.out.println("edadMax: " + edadMaxInteger);
        }catch (NumberFormatException e){
            LOGGER.severe(e.getMessage());
        }

        String limite = request.getParameter("limite");

        //2.TRATAR LOS PARÁMETROS, CONVERSIONES Y VALIDACIONES

        //3.LÓGICA. NECESITO OBTENER LOS PERSONAJES DE LOS SIMPSON
        List<Personaje> personajes = servicio.buscar();


        //4.PASAR A LA VISTA LO QUE NECESITE

        request.setAttribute("personajes", personajes);

        //5.REENVIAR A LA VISTA (plantilla jsp)
        request.getRequestDispatcher("/personajes.jsp").forward(request, response);



    }

}