package test.ref_valor;

import java.util.List;

public class Concesionario {
    List<Carro> stock;
    List<Empleado> empleados;

    public Concesionario(List<Carro> stock, List<Empleado> empleados) {
        this.stock = stock;
        this.empleados = empleados;
    }
}
