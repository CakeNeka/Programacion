/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chincho.merinde;

public class Main {
    public static void main(String[] args) {
        new MainWindow();
    }
    
    public static void gameOver(String loser) {
        System.out.println(loser + " Perdió");
        System.exit(0);
    }
}
