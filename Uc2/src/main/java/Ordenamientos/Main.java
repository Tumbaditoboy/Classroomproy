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
 /**       
    int [] arreglo = {7, 10, 24, 9, 3, 14, 6, 4, 2};
    Ordenamientos.burbuja(arreglo);
    System.out.println("Ordenamiento burbuja");
    for (int a : arreglo){
        System.out.print(a + ", "); // "," para separar números de más de 1 digito
    }
    System.out.println(" ");
    
    **/ 
 /**
    int [] arregloselec = {10, 4, 24, 3, 8, 12};
    Ordenamientos.seleccion(arregloselec);
    System.out.println("Ordenamiento selección");
    for (int a : arregloselec){
        System.out.print(a + ", "); // "," para separar números de más de 1 digito
    }
    System.out.println(" ");
    }
    **/
 
    int [] arregloselec = {7, 10, 24, 9, 3, 12, 2};
    Ordenamientos.insertionSort(arregloselec);
    for (int a : arregloselec){
        System.out.print(a + ", "); // "," para separar números de más de 1 digito
    }
    System.out.println(" ");   
    }
}

