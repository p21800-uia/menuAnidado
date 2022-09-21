package uia.com.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Nodo {
    private  String id="";
    private  int opcion=-1;
    String titulo="";
    String subTitulo="";
    String[] opciones;
    String  seleccion="";
    String subSeleccion="";
    HashMap<Integer, Nodo> menu = null;

    public Nodo() {
    }

    public Nodo(String titulo, String subTitulo, String[] opciones, String seleccion, String subSeleccion) {
        this.id = titulo;
        this.titulo = "Menú "+titulo;
        this.subTitulo = subTitulo;
        this.opciones = opciones;
        this.seleccion = seleccion;
        this.subSeleccion = subSeleccion;
        this.menu = new HashMap<Integer, Nodo>();

        if(opciones != null) {
            for (int i = 1; i < this.opciones.length; i++) {
                Nodo newNodo = new Nodo(opciones[i], subTitulo, null, seleccion, subSeleccion);
                menu.put(i, newNodo);
            }
        }
    }

    public Nodo(HashMap<Integer, Nodo> menu) {
        this.menu = menu;
    }



    public void despliega() {

        System.out.println("\n\n\n");
        System.out.println("\t\t"+"\t"+"Menú de "+titulo+"\n\n");

        for(int i=0; i<this.opciones.length;  i++)
        {

            System.out.println("\t\t"+i+"\t"+this.opciones[i]);
        }

        System.out.println("\n\n\n\t\t"+"\t"+subTitulo);

    }


    public void pregunta() {

        despliega();

        Scanner q = new Scanner(System.in);
        //this.menu.get(opcion).seleccion();
        while((opcion=q.nextInt()) != 0)
        {

            if(opcion != 0)
            {
                menu.get(opcion).pregunta();
                despliega();
            }
            else
                return;
        }

    }

    public HashMap<Integer, Nodo> getMenu(String contactos)
    {
        if(menu != null) {
            for (int i = 0; i < this.menu.size(); i++)
            {
                if(this.menu.get(i).menu == null) {
                    Nodo newNodo = new Nodo(opciones[1], subTitulo, null, seleccion, subSeleccion);
                    menu.put(i + 1, newNodo);
                }
            }
        }
        return menu;
    }

    public void setMenu(HashMap<Integer, Nodo> menu) {
        this.menu = menu;
    }


    public void setMenu(String opcionIn, String nomMenu, String s, String[] opcionesMenu, String s1, String s2)
    {
        if(this.opciones != null) {
            for (int i = 1; i < this.opciones.length; i++)
            {
                if(opcionIn.contentEquals(this.opciones[i])) {
                    if(this.menu.containsKey(i))
                    {
                        if(this.menu.get(i).menu != null)
                        {
                            this.menu.get(i).setOpciones(opcionesMenu);
                            if(opcionesMenu != null) {
                                for (int j = 1; j < opcionesMenu.length; j++) {
                                    Nodo newNodo = new Nodo(opcionesMenu[j], s, null, s1, s2);
                                    this.menu.get(i).menu.put(j, newNodo);
                                }
                            }
                        }
                        else
                        {
                            this.menu.get(i).menu = new HashMap<Integer, Nodo>();
                            this.menu.get(i).setOpciones(opcionesMenu);
                            if(opcionesMenu != null) {
                                for (int j = 1; j < opcionesMenu.length; j++) {
                                    Nodo newNodo = new Nodo(opcionesMenu[j], s, null, s1, s2);
                                    this.menu.get(i).menu.put(j, newNodo);
                                }
                            }
                        }
                        break;
                    }
                    else
                    {
                        Nodo newNodo = new Nodo(nomMenu, subTitulo, opciones, s1, s2);
                        this.menu.put(i, newNodo);
                    }
                }
            }
        }
        else {
            if (this.menu != null)
            {
                this.setOpciones(opcionesMenu);
                if (opcionesMenu != null) {
                    for (int j = 1; j < opcionesMenu.length; j++) {
                        Nodo newNodo = new Nodo(opcionesMenu[j], s, null, s1, s2);
                        this.menu.put(j, newNodo);
                    }
                }
            }
        }
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public Nodo getNodoMenu(String menuIn)
    {
        if(opciones != null) {
            for (int i = 1; i < this.opciones.length; i++)
            {
                if(menuIn.contentEquals(this.opciones[i]))
                {
                    if(this.menu.containsKey(i)) {
                        return this.menu.get(i);
                    }
                }
            }
        }
        return null;
    }
}
