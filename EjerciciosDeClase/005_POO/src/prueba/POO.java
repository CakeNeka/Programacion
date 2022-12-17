/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

public class POO {
    public static void main(String[] args){
        
    }
    
    public static int sumSubarraysOfLengthk(int[] arr, int k){
        int sum = 0;
        int curSum = 0;
        
        for (int i = 0; i < k; i++) {
            curSum += arr[i];
        }
        
        sum = curSum;
        
        for (int i = 0; i < arr.length-k; i++) {
            curSum -= arr[i];
            curSum += arr[i+k];
            
            sum += curSum;
        }
        
        return sum;
    }
}
