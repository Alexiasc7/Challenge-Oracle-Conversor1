package coversor.alura.operaciones;

import java.util.ArrayList;
import java.util.List;

public class HistoialConversor {

    private List<Operacion> operaciones;

    public HistoialConversor() {
        this.operaciones = new ArrayList<Operacion>();
    }

    public void guardar(Operacion operacion) {
        this.operaciones.add(operacion);

    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

}