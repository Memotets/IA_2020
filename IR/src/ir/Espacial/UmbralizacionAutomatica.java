/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.Espacial;

/**
 *
 * @author memotets89
 */
public class UmbralizacionAutomatica {
    
    public static int metodoOtsu(double[] histograma){
        int Otsu = 125;
        System.out.println();        
        double[] pK = new double[histograma.length];
        double[] mK = new double[histograma.length];
        
        pK[0] = histograma[0];
        
        double max=0;
        for(int i =0; i<histograma.length;i++) max+=histograma[i];//paso 1
        
        for(int x = 1; x<histograma.length ;x++){
            pK[x] = pK[x-1]+histograma[x]/max; //paso 2
            mK[x] = mK[x-1]+ x*histograma[x]/max; //paso 3
        }
        
        double mG = mK[histograma.length-1]; // paso 4
        double sigma = 0; //distancia ideal pico
        double sigmaPrima = 0; //guardar pico
        
        for(int x = 0; x<histograma.length ;x++){
            sigma = Math.pow(mG*pK[x]-mK[x],2)/(pK[x]*(1-pK[x]));//paso 5
            
            if (sigmaPrima < sigma){
                sigmaPrima = sigma; // paso 6
                Otsu=x;//paso 7
                System.out.println(Otsu);
            }
            
        }
        
        System.out.println();
        return Otsu;
    }
    
    
    public static int metodoIterativo(double[] histograma){
    
        int ui = calcularUmbralInicial(histograma);
        int uNuevo=0;
        System.out.println(ui);
        do{
        uNuevo = ui;
        ui = reajustarUmbral(ui,histograma);
        System.out.println(ui);
        }while(uNuevo!=ui);
        
        return ui;
        
    }


    private static int calcularUmbralInicial(double[] histograma) {
        int numPixels = 0;
        int suma = 0;
        for(int x=0;x<histograma.length;x++){
        numPixels+=histograma[x];
        suma+=histograma[x]*x;
        }
        return (int)(suma/numPixels);
    }


    private static int reajustarUmbral(int ui, double[] histograma) {
       int u1,u2;
       int a1=0,a2=0,n1=0,n2=0;
       a1+=histograma[0];
       for(int x=1;x<ui;x++){
        a1+=histograma[x]*x;
        n1+=histograma[x];
       }
       
        for(int y=ui;y<=255;y++){
        a2+=histograma[y]*y;
        n2+=histograma[y];
       }
        if (n1==0 || n2==0) return 0;
        u1 = a1/n1;
        u2 = a2/n2;
       return (int)((u1+u2)/2);
    }
}
