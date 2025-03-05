/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamientos;

/**
 *
 * @author dzlan
 */
public class Main {
    
    public static void main(String[] args) {
        
    int [] arreglo = {7, 10, 24, 9, 3, 14, 6, 4, 2};
    Ordenamientos.burbuja(arreglo);
    for (int a : arreglo){
        System.out.print(a + ", "); // "," para separar números de más de 1 digito
    }
    
    }
    
}

