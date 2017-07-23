package test.ref_valor;

import java.util.ArrayList;
import java.util.List;

public class Index {
    
    public static void main(String[] args){
        List<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Carro("STR986", "Rojo", 2010, "Nissan"));
        listaCarros.add(new Carro("GAR526", "Verde", 2015, "Nissan"));
        listaCarros.add(new Carro("KMF830", "Azul", 2014, "Nissan"));
        
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Jorge", "Rudas", 12345678));
        listaEmpleados.add(new Empleado("Ana Maria", "Castro", 525235523));
        listaEmpleados.add(new Empleado("Emiliano", "Zuluaga", 262623686));
        
        Concesionario nissan = new Concesionario(listaCarros, listaEmpleados);
    }    
}
