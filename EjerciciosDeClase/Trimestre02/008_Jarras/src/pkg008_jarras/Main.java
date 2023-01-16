package pkg008_jarras;

public class Main {
    
    public static void main(String[] args) {
        EjemploUsoJarras2();
    }

    public static void EjemploUsoJarras1() {
        Jarra jarraA = new Jarra(7);
        Jarra jarraB = new Jarra(4);
        
        jarraA.llena();
        System.out.println("Jarra A\n" + jarraA + "Jarra B\n" +jarraB);
        
        jarraB.llenaDesde(jarraA);
        System.out.println("Jarra A\n" + jarraA + "Jarra B\n" +jarraB);
        
        jarraB.vacia();
        System.out.println("Jarra A\n" + jarraA + "Jarra B\n" +jarraB);
        
        jarraB.llenaDesde(jarraA);
        System.out.println("Jarra A\n" + jarraA + "Jarra B\n" +jarraB);
    }
    
    public static void EjemploUsoJarras2() {
        Jarra jarraA = new Jarra(5);
        Jarra jarraB = new Jarra(7);
        
        // A=0 B=0
        jarraA.llena();             
        jarraB.llenaDesde(jarraA);
        
        // A=0 B=5
        jarraA.llena();
        jarraB.llenaDesde(jarraA);
        
        // A=3 B=7
        jarraB.vacia();
        jarraB.llenaDesde(jarraA);
        
        // A=0 B=3
        jarraA.llena();
        jarraB.llenaDesde(jarraA);
        
        // A=1 B=7
        System.out.println("Jarra A\n" + jarraA + "Jarra B\n" +jarraB);
       
    
    }

}
