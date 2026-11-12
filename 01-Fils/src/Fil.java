public class Fil extends Thread {
    private int iteracions;
    private int feinaSimulada;
    private long retard;

    public Fil(String nom, int prioritat, int iteracions, int feinaSimulada, long retard) {
        super(nom);

        this.setPriority(prioritat);

        this.iteracions = iteracions;
        this.feinaSimulada = feinaSimulada;
        this.feinaSimulada = feinaSimulada;
        this.retard = retard;
    }

    @Override 
    public void run() {
        for (int  i = 0; i <= iteracions; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }
}
