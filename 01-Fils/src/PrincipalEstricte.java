public class PrincipalEstricte {

    public static void main(String[] args) {
        new Fil("Juan", Thread.NORM_PRIORITY, 9, 0, 10, "Termina").start();
        new Fil("Pepe", Thread.NORM_PRIORITY, 9, 0, 10, "Termina").start();

        System.out.println("Termina thread main");
    }
}