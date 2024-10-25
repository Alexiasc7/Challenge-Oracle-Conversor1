package coversor.alura.operaciones;
import java.time.LocalDateTime;

public class Operacion {

    private static int idContador = 0;
    private int id;
    private double valorConvertido;
    private double resultado;
    private String codMonedaBase;
    private String codMonedaDestino;
    private String fechaHoraActual;

    public Operacion(double valorConvertido, double resultado, String codMonedaBase, String codMonedaDestino,
                     String fechaHoraActual) {
        this.id = ++idContador;
        this.valorConvertido = valorConvertido;
        this.resultado = resultado;
        this.codMonedaBase = codMonedaBase;
        this.codMonedaDestino = codMonedaDestino;
        this.fechaHoraActual = fechaHoraActual;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public double getResultado() {
        return resultado;
    }

    public String getCodMonedaBase() {
        return codMonedaBase;
    }

    public String getCodMonedaDestino() {
        return codMonedaDestino;
    }

    @Override
    public String toString() {
        return "Operacion: " + "Id: " + id + ", valor convertido:" + valorConvertido + ", resultado:" + resultado
                + ", moneda base:" + codMonedaBase + ", moneda destino:" + codMonedaDestino + ", fecha y hora:"
                + fechaHoraActual + "\n";
    }

}
