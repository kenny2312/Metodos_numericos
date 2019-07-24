/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class Metodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner tecl = new Scanner(System.in);
        punto_fijo n= new punto_fijo();
        f_polinomial f= new f_polinomial();
      gaus_jordan gj= new gaus_jordan();
        
          int x = 0;
        do{
            System.out.println("//////////////////////////");
            System.out.println("/////METODOS NUMERICOS////");
            System.out.println("1.metodo de punto fijo");
            System.out.println("2.metodo de gauss jordan");
            System.out.println("3. funcion polinomial de 3 grado");
            System.out.println("4.salir");
            System.out.println("---------->");
            x=tecl.nextInt();
            switch (x) {
                case 1:
                    n.puntoF();
                    break;
                case 2:
                  gj.gaus_j();
                    break;
                case 3:
                     f.f_p();
                    break;
            }
            
        }while(x<=4);
        
        
    }
    
}
