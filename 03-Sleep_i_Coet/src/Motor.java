import java.util.Random;

public class Motor extends Thread {
    private int id;
    private volatile int potenciaActual = 0;
    private volatile int potenciaObjectiu = 0;
    private volatile boolean haRebutOrdre = false;
    private Random random = new Random();

    public Motor(int id) {
        this.id = id;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        this.haRebutOrdre = true;
    }

    @Override
    public void run() {
        boolean enFerRes = false;

        while (true) {
            try {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    enFerRes = false;
                    System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n",
                            id, potenciaObjectiu, potenciaActual);
                    Thread.sleep(1000 + random.nextInt(1001)); 

                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    enFerRes = false;
                    System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n",
                            id, potenciaObjectiu, potenciaActual);
                    Thread.sleep(1000 + random.nextInt(1001));
                } else {
                    if (haRebutOrdre && !enFerRes) {
                        System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n",
                                id, potenciaObjectiu, potenciaActual);
                        enFerRes = true;
                    }

                    if (haRebutOrdre && potenciaObjectiu == 0) {
                        break;
                    }

                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
