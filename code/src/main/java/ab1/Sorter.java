package ab1;

/**
 * Interface für Sortieralgorithmen, die auf ganzen Zahlen operieren.
 */
public interface Sorter
{
    /**
     * Sortiert das gegebene Array in aufsteigender Reihenfolge (in-place, dh an Ort und Stelle).
     */
    public void sort(int[] array);
}
