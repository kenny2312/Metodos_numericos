/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kenny
 */
public class punto_fijo {

    
    ArrayList<Punto_fijoClass> lista = new ArrayList<Punto_fijoClass>();
    Scanner t = new Scanner(System.in);
    public punto_fijo() {
        
        
        
        
    }
    
    
    public void puntoF(){
         float x0=0;
         float x1=0; //esto es f(x)
         float fx1 = 0;//esto contiene g(x)
         float er=0;
         
         float to=0;
         float euler=(float) Math.E;
         int niteraciones=0;
        System.out.println("ingrese f(x)");  //ingresa el resutado de la funcion
        x0=t.nextFloat();
         System.out.println("ingrese nuemeros de iteraciones");
        niteraciones=t.nextInt();
        System.out.println("ingrese tolerancia");//usa coma eje  0,0001
          to=t.nextFloat();
          
        
        int i=niteraciones;
          do{
               Punto_fijoClass pf = new Punto_fijoClass ();
               
              x0=x1;
              pf.setX0(x0);
              x1=(float) Math.pow(euler,-x0);// si quieres otra ecuacion modifca aqui
              pf.setX1(x1);
              fx1=(float) (Math.pow(Math.E,-x1)-x1);//aca tambien
              pf.setFx1(fx1);
              er=Math.abs(((x1-x0)/x1));
              pf.setEr(er);
              x0=x1;
              
             
              lista.add(pf);
              
              --i;
          }while(i!=0);
          
          
          mostrar();
    }

 

    public void mostrar(){
     System.out.println(" "); 
         System.err.println("-->"+padRight("x0",19)+"|"+padRight("x1",19)
           +"|"+padRight("f(x)",19)+"|"+padRight("error relativo",19));
        for(Punto_fijoClass a : lista){
            
   System.out.println("-->"+padRight(a.getX0(),19)+"|"+padRight(a.getX1(),19)
           +"|"+padRight(a.getFx1(),19)+"|"+padRight(a.getEr(),19));
    
        }
        
    }
    
    public static String padRight(Double s, int n) {
     return String.format("%-" + n + "s", s);  
}
     public static String padRight(String  s, int n) {
     return String.format("%-" + n + "s", s);  
}
    public static String padRight(Float s, int n) {
     return String.format("%-" + n + "s", s);  
}

public static String padLeft(String s, int n) {
    return String.format("%" + n + "s", s);  
}
    
}
