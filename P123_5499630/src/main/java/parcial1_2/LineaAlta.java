
package parcial1_2;
import parcial1_2.Celular_1;
import parcial1_2.Navegable;
/**
 *
 * @author EMG73
 */
public class LineaAlta extends Celular_1 {
    private String frecuencia;
    public LineaAlta(String numero, String marca, String tecnologia, int costoMin, String frecuencia) {
        super(numero, marca, tecnologia, costoMin);
        this.frecuencia = frecuencia;
    }

    @Override
    public int calcularCostoLlamada() {//metodo que puede ser polimorfico
        return minutos * 150; // Costo por minuto en LineaAlta: 150 Gs
    }

    @Override
    public String navegar(String link) {//metodo puede ser polimorfico
        return "Navegando en LineaAlta a la URL: " + link;
    }
    
}
