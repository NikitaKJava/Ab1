package ab1;

import java.util.NoSuchElementException;

/**
 * Operationen auf Heap-Datenstruktur für ganzzahlige Werte.
 * Der Heap kann intern ein Array mit begrenzter Kapazität verwalten.
 */
public interface Heap
{
    /**
     * Löscht alle Heap-Elemente.
     */
    public void clear();

    /**
     * Füge ein Element in den Heap ein.
     * @throws IndexOutOfBoundsException falls der Schlüssel wegen begrenzter
     *         Kapazität des Heap nicht eingefügt werden kann.
     */
    public void add(int key) throws IndexOutOfBoundsException;

    /**
     * Entferne das maximale Element vom Heap.
     * @return das entfernte maximale Element.
     * @throws NoSuchElementException falls der Heap leer ist.
     */
    public int removeMax() throws NoSuchElementException;

    /**
     * Gib das maximale Element des Heap zurück, ohne es vom Heap zu entfernen.
     * @throws NoSuchElementException falls der Heap leer ist.
     */
    public int max() throws NoSuchElementException;

    /**
     * Gib die Anzahl der im Heap gespeicherten Elemente zurück.
     * @return
     */
    public int size();
}
