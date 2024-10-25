package coversor.alura.operaciones;

public class ConversorMoneda {
    private double resultado;

    public double convertir(double conversion_rate, double valorAConvertir) {
        this.resultado = conversion_rate * valorAConvertir;
        return Math.floor(resultado * 100) / 100;
    }
}


