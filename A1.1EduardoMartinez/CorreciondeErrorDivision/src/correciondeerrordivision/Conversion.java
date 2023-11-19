
package correciondeerrordivision;

/*
El siguiente programa no está produciendo la salida adecuada
 */
public class Conversion {

    public static int division(int x, int y){//cambio double por int para que no me den ceros
        return x/y;
    }
    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int c = division(a,b);//int en vez de double
        System.out.printf("La division de %d entre %d es %d\n",a,b,c);// d en lugar de f
    }
    
}
