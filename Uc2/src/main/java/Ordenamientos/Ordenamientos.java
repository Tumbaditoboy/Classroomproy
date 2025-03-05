/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ordenamientos;

/**
 *
 * @author dzlan
 */
public class Ordenamientos {
    /**
     * Ordena de menor a mayor elementos de un arreglo utilizando el método burbuja
     * @param arreglo el arreglo con los elementos a ordenar
     */
    public static void burbuja(int[] arreglo){
    // Bucle exterior: realiza pasadas sobre el arreglo
    //Primer indice no necesita ser comparado
    for(int i = 1; i < arreglo.length; i++){ //1 + n + 1 + n  =  2n + 2
      // Bucle interior: compara elementos adyacentes
        for (int j = 0; j < arreglo.length - i; j++ ){ //1 + n + 1 + n + 1 = 2n + 3
       // Compara si el elemento actual es mayor que el siguiente
            if (arreglo[j] > arreglo[j + 1]){ // 1 
          // Se guarda el valor en la variable auxiliar
                int auxiliar = arreglo[j];   // 1 
         // Se asigna el valor de arreglo[j+1] a arreglo[j]
                arreglo[j] = arreglo[j+1];    // 1
        // Se asigna el valor de auxiliar (el antiguo arreglo[j]) a arreglo[j+1]
                arreglo[j+1] = auxiliar;    // 1
                 }
             }  //O(n2)
         }        
     }
    
}
