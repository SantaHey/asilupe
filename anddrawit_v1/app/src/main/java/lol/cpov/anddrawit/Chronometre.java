package lol.cpov.anddrawit;

public final class Chronometre {

    private long start;

    private Chronometre() {
        start = System.nanoTime();
    }

    public static Chronometre start() {
        return new Chronometre();
    }

    public int elapsed() {
        return (int) (System.nanoTime() - start);
    }

}
