public class PrincipalIguals {
    public static void main(String[] args) {
        new Fil("Pepe", Thread.MAX_PRIORITY, 9, 1000, 0, "Acaba").start();
        new Fil("Juan", Thread.MAX_PRIORITY, 9, 1000, 0, "Acaba").start();

        System.out.println("Acaba thread main");
    }
}