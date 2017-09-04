/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica;

import Logica.Celda;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import Logica.Archivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;
/**
 *
 * @author ale
 */
public class Practica1IA extends JFrame{
    //private static final int n=15;//columnas
    //private static final int m=15;//filas
    public Practica1IA()
    {
        //Se definen las propiedades básicas de la ventana
        setSize(300,300);//tamaño
        setTitle("Practica 1");//Titulo de la ventana
        setVisible(true);//Visibilidad
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Cuando la ventana se cierra la aplicación se detiene
        setResizable(false);//No se le puede cambiar el tamaño a la ventana
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //Obtener matriz del archivo
        
        /*En está seccion se obtiene la matriz de 1 y 0  del archivo de texto y
        genera una matriz dinámica de 1 y 0, con esa matriz dinámica podemos 
        crear una matriz estática para guardar objetos de tipo celda*/
        
        //Declaramos una instancia de la clase que lee el archivo de texto
        Archivos archivo=new Archivos();
        //Crear la matriz dinamica para los enteros que se van a leer del fichero
        ArrayList<ArrayList<Integer>> celdas=new ArrayList<>();
        /*Se llama al método que guarda la matriz dinámica creada de la 
        lectura del archivo*/
        celdas=archivo.lectura();
        /*Se obtienen alto y ancho para evitar volver a crear una matriz 
        dinamica y en su lugar crear una matriz estática de objetos celda*/
        int n=celdas.size();
        int m=celdas.get(0).size();
        //Matiz estática donde se van a guardar los objetos de tipo celda
        Celda[][] mat_cel=new Celda[n][m];
        
        //Interfaz Gráfica
        
        /*En está sección se define el laberinto pero de forma gráfica, 
        con la matriz estática de objetos celda creamos la parte visual del
        laberinto*/
        
        //Se define el panel donde se va a montar toda la IU
        JPanel laberinto=new JPanel();
        //Se define un administrador de diseño en forma de tabla de tamaño nxm
        GridLayout tablero = new GridLayout(n,m);
        //Se añade el administrador de diseño al panel 
        laberinto.setLayout(tablero);
        /*Creamos un array de paneles, que basicamente cada panelva a ser la IG
         de cada celda y se acomoda en forma de matriz*/
        JPanel tablero_panel[][]=new JPanel[n][m];
        JTextField text_tablero[][]=new JTextField[n][m];
        
        //Se crea la matriz de objetos Celda
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                mat_cel[i][j]=new Celda(celdas.get(i).get(j),false,false,false,false);
        
        //Se crea visualmente el laberinto
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
            {
                //Se crea una instancia de la interfaz grafica de cada celda
                tablero_panel[i][j]=new JPanel();
                //Se define un borde para cada celda
                tablero_panel[i][j].setBorder(new EtchedBorder());
                text_tablero[i][j]= new JTextField(1);
                tablero_panel[i][j].add(text_tablero[i][j]);
                text_tablero[i][j].setText(Integer.toString(mat_cel[i][j].getWall()));
                /*En estos if se define si es muro o camino y se pinta con el 
                color correspondiente 
                1->camino->blanco
                0->muro  ->gris*/
                if(mat_cel[i][j].getWall()==1)
                    tablero_panel[i][j].setBackground(Color.WHITE);//camino
                else
                    tablero_panel[i][j].setBackground(Color.GRAY);//muro
                /*Al panel se le añade la IU de la celda y la misma funcion la 
                acomoda*/
                laberinto.add(tablero_panel[i][j]);
            }
        
        //Crear Ventana
        Practica1IA ventana= new Practica1IA();
        //En la ventana desplegar el panel laberinto
        ventana.setContentPane(laberinto);
    }
}
