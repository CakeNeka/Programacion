package patrones.state;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
        Phone phone = new Phone();
        Scanner scan = new Scanner(System.in);
        String input = "";
        while(!input.equals("E")){
            System.out.println("(H)ome  (P)ower  (E)xit");
            input = scan.nextLine();
            if (input.equals("H")){
                System.out.println(phone.clickHome());
            } else if (input.equals("P")){
                System.out.println(phone.clickPower());
            }
            
        }
    }
}
