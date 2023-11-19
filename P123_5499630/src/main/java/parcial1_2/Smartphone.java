
package parcial1_2;
import parcial1_2.Celular_1;
import parcial1_2.Navegable;
/**
 *
 * @author EMG73
 */
public class Smartphone extends Celular_1{
    private String sisOperativo;
    /*con la propiedad privada String sisOperativo, 
    y los métodos públicos String enviarMensaje(numero, msg) y recibirMensaje(numero, msg). */
    public Smartphone(String numero, String marca, String tecnologia, int costoMin, String sisOperativo) {
        super(numero, marca, tecnologia, costoMin);
        this.sisOperativo = sisOperativo;
    }

    public String enviarMensaje(String numero, String msg) {
        return "Enviando mensaje a " + numero + ": " + msg;
    }

    public String recibirMensaje(String numero, String msg) {
        return "Recibiendo mensaje de " + numero + ": " + msg;
    }

    @Override
    public int calcularCostoLlamada() {//este puede ser polimorfico
        return minutos * 200; // Costo por minuto en Smartphone: 200 Gs
    }

    @Override
    public String navegar(String link) {//metodo ouede polimorfico
        return "Navegando en Smartphone a la URL: " + link;
    }
    
    
}
