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
public class f_polinomial {
    
    
    public void f_p(){
        Scanner l = new Scanner(System.in);
        int n = 0;
        System.out.println("ingrese tamaño");
        n=l.nextInt();
        
       
        Double y []=new Double[n];
        
        int equis []=new int[n];
        
        float sumatori_x = 0;
        float sumatoria_y=0;
        float sumatori_x2 = 0;
        float sumatori_x3 = 0;
        float sumatori_x4 = 0;
        float sumatori_x5 = 0;
        float sumatori_x6 = 0;
        float sumatori_xy = 0;
        float sumatori_x2y = 0;
        float sumatori_x3y = 0;
   
        
        
        int x2 []=new int[n];
        int x3 []=new int[n];
        int x4 []=new int[n];
        int x5 []=new int[n];
        int x6 []=new int[n];
        Double xy []=new Double[n];
       Double x2y []=new Double[n];
       Double x3y []=new Double[n];
       
        for (int i = 0; i < equis.length; i++) {
            System.out.println("ingrese x(i)"); 
          equis[i]=l.nextInt();//x
       
            x2[i]=equis[i]*equis[i];//x al cuadrado
                 x3[i]=equis[i]*equis[i]*equis[i];//x al cubo
                  x4[i]=equis[i]*equis[i]*equis[i]*equis[i];//x a la cuarta
                  x5[i]=equis[i]*equis[i]*equis[i]*equis[i]*equis[i];//x a la quita
                  x6[i]=equis[i]*equis[i]*equis[i]*equis[i]*equis[i]*equis[i];//x a la sexta
                  sumatori_x=sumatori_x+  equis[i];
                  sumatori_x2=sumatori_x2+x2[i];
                  sumatori_x3=sumatori_x3+x3[i];
                  sumatori_x4= sumatori_x4 + x4[i];  
                  sumatori_x5= sumatori_x5 + x5[i];  
                  sumatori_x6= sumatori_x6 + x6[i];  
                          
        }
      

         
         System.out.println("**");
        for (int i = 0; i < n; i++) {
            
            System.out.println("ingrese valores de y(i)");
            y[i]=l.nextDouble();
            sumatoria_y= (float) (sumatoria_y+y[i]);
        }
        
        //
        for (int i = 0; i < xy.length; i++) {
            xy[i]=(equis[i]*y[i]);
            sumatori_xy=(float) (sumatori_xy+xy[i]);
        }
       
          System.out.println("----------------------");
        
        
        //
        for (int i = 0; i < x2y.length; i++) {
           x2y[i]=x2[i]*y[i];
            sumatori_x2y=(float) (sumatori_x2y+ x2y[i]);
        }
        System.out.println("-------------------------");
        
        
         for (int i = 0; i < x3y.length; i++) {
           x3y[i]=x3[i]*y[i];
            sumatori_x3y=(float) (sumatori_x3y+ x3y[i]);
        }
 
        System.out.println("|"+padRight("x",15)
                    +padRight("y",15)+padRight("x^2",15)+padRight("x^3",15)+padRight("x^4",15)+
                    padRight("x^5",15)+padRight("x^6",15)+padRight("xy",15)+
                    padRight("x^2y",15)+padRight("x^3y",15)+"|");
        for (int i = 0; i < equis.length; i++) {
            System.out.println("|"+padRight(equis[i],15)
                    +padRight(y[i],15)+padRight(x2[i],15)+padRight(x3[i],15)+padRight(x4[i],15)+
                    padRight(x5[i],15)+padRight(x6[i],15)+padRight(xy[i],15)+
                    padRight(x2y[i],15)+padRight(x3y[i],15)+"|");
            
        }
        System.out.println("Σ "+padRight(sumatori_x,14)
                    +padRight(sumatoria_y,15)+padRight(sumatori_x2,15)+
                padRight(sumatori_x3,15)+  padRight(sumatori_x4,15)+
                    padRight(sumatori_x5,15)+padRight(sumatori_x6,15)+
                padRight(sumatori_xy,15)+padRight(sumatori_x2y,15)+
                padRight(sumatori_x3y,15));

         float cramer[][]=new float[4][5];
        
        cramer[0][0]=n;
        cramer[0][1]= sumatori_x;
        cramer[0][2]=sumatori_x2;
        cramer[0][3]=sumatori_x3;
        
        cramer[1][0]=sumatori_x;
        cramer[1][1]=sumatori_x2;
        cramer[1][2]=sumatori_x3;
        cramer[1][3]=sumatori_x4;
        
        cramer[2][0]=sumatori_x2;
        cramer[2][1]=sumatori_x3;
        cramer[2][2]=sumatori_x4;
        cramer[2][3]=sumatori_x5;
        
        cramer[3][0]=sumatori_x3;
        cramer[3][1]=sumatori_x4;
        cramer[3][2]=sumatori_x5;
        cramer[3][3]=sumatori_x6;
        
        cramer[0][4]=sumatoria_y;
        cramer[1][4]=sumatori_xy;
        cramer[2][4]=sumatori_x2y;
        cramer[3][4]=sumatori_x3y;
        System.out.println(" ");
        
        System.out.println("Matriz para Guauss");
        for (int i = 0; i < cramer.length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("|"+padRight(cramer[i][j],10)+"|");
                
            }
            System.out.println("");
        }

        gausas(cramer,n);

        
    }

     
      static void muestramatriz(float matriz[][], int var) {
        for (int x = 0; x < var; x++) {
            for (int y = 0; y < (var + 1); y++) {
                System.out.print(" " + matriz[x][y] + " |");
            }
            System.out.println("");
        }

    }

    static void pivote(float matriz[][], int piv, int var) {
        float temp = 0;
        temp = matriz[piv][piv];
        for (int y = 0; y < (var + 1); y++) {

            matriz[piv][y] = matriz[piv][y] / temp;
        }
    }

    static void hacerceros(float matriz[][], int piv, int var) {
        for (int x = 0; x < var; x++) {
            if (x != piv) {
                float c = matriz[x][piv];
                for (int z = 0; z < (var + 1); z++) {
                    matriz[x][z] = ((-1 * c) * matriz[piv][z]) + matriz[x][z];
                }
            }
        }
    }

  public static void  gausas(float cramer[][],int n) {
        
        int var = 4, piv = 0;
        float matriz[][]= new float[var][var+1];
        
        
        
        for (int x = 0; x < var ; x++) {
            for (int y = 0; y < (var+1); y++) {
               
                matriz[x][y] = cramer[x][y];
            }

        }

        for (int a = 0; a < var; a++) {
            pivote(matriz, piv, var);

            System.out.println("\tRenglon " + (a + 1) + " entre el pivote");
            muestramatriz(matriz, var);

            System.out.println("");

            System.out.println("\tHaciendo ceros");
            hacerceros(matriz, piv, var);

            muestramatriz(matriz, var);
            System.out.println("");
            piv++;
        }
        for (int x = 0; x < var; x++) {
            System.out.println("La variable X" + (x + 1) + " es: " + matriz[x][var]);
        }

    }
  
     public static String padRight(Float s, int n) {
     return String.format("%-" + n + "s", s);  
     
}
      public static String padRight(int s, int n) {
     return String.format("%-" + n + "s", s);  
}
        public static String padRight(double s, int n) {
     return String.format("%-" + n + "s", s);  
}
           public static String padRight(String s, int n) {
     return String.format("%-" + n + "s", s);  
}
}
