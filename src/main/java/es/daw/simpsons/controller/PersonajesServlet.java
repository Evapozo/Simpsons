package es.daw.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //1.LEER PARÁMETROS DEL REQUEST
        String lugar = request.getParameter("lugar");
        String ordenarPor = request.getParameter("ordenarPor");
        boolean descendente = request.getParameter("descendente") != null ?
                Boolean.parseBoolean(request.getParameter("descendente")) : false;

        //PENDIENTE!!!!deberiamos convertirlos a un entero
        String edadMax = request.getParameter("edadMax");
        String limite = request.getParameter("limite");

        //2.Tratar los parámetros, conversiones y validaciones



        //3.LÓGICA. NECESITO OBTENER LOS PERSONAJES DE LOS SIMPSON
        List<Personaje> personajes = servicio.buscar();


        //4.Pasar a la vista todo lo que necesite

        request.setAttribute("personajes", personajes);

        //5.Reenviar a la vista (plantilla jsp)
        request.getRequestDispatcher("/personajes.jsp").forward(request, response);



    }

}