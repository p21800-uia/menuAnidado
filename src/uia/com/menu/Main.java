package uia.com.menu;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception
    {
        System.out.println("Hola, iniciando prueba de concepto de menu, buena suerte");

        String[] opcionesMenuMain ={"Salir", "Contactos", "Eventos", "Recordatorios"};
        String[] opcionesMenuContactos ={"Salir", "Nuevo", "Modificar", "Borrar"};
        NodoMenu menuPrincipal = new NodoMenu("Principal", "Introduzca la opción deseada ?:",  opcionesMenuMain, "", "");
        menuPrincipal.setMenu("Contactos", "Contactos", "Introduzca la opción deseada ?:",  opcionesMenuContactos, "", "");
        String[] opcionesMenuNuevoContacto ={"Salir", "Nombre", "Telefono"};
        menuPrincipal.getNodoMenu("Contactos").getNodoMenu("Nuevo").setMenu("Nuevo", "Nuevo", "Introduzca la opción deseada ?:",  opcionesMenuNuevoContacto, "", "");
        menuPrincipal.pregunta();

    }
}
