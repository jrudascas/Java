/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testFunctionalProgramming;

/**
 *
 * @author jrudascas
 */
public class Empleado extends Persona{
    private int sueldoBruto;
    
    public Empleado(int edad, String nombre, int sueldoBruto) {        
        super(edad, nombre);
        this.sueldoBruto = sueldoBruto;
    }
    
}
