package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Archivos {
    private final String ruta="./Matriz.txt";
    File archivo;
    BufferedReader buffer_lectura;
    
    public Archivos() throws FileNotFoundException {
        this.archivo=new File(ruta);
        this.buffer_lectura=new BufferedReader(new FileReader(this.archivo));
    }
    
    public ArrayList<ArrayList<Integer>> lectura() throws IOException
    {
        ArrayList<ArrayList<Integer>> resultado=new ArrayList<>();
        String linea;
        while((linea=buffer_lectura.readLine())!=null)
        {
            ArrayList<Integer> enteros=new ArrayList<>();
            for(int i=0;i<linea.length();i++)
                if(linea.charAt(i)=='0' || linea.charAt(i)=='1')
                    enteros.add(Integer.parseInt(linea.charAt(i)+""));
            resultado.add(enteros);
        }
        buffer_lectura.close();
        return resultado;
    }
    
    /*Este en un pequeño main que imprime el arreglo por si quieren hacerle 
    cosas raras a la clase archivo en ese main puedan experimentar*/
    
    /*public static void main(String[] args)
    {
        try {
            Archivos arch=new Archivos();
            ArrayList<ArrayList<Integer>> celdas=new ArrayList<>();
            try {
                celdas=arch.lectura();
            } catch (IOException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<celdas.size();i++)
            {
                for(int j=0;j<celdas.get(i).size();j++)
                {
                    System.out.print(celdas.get(i).get(j));
                }
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    
}
