package ab1;

/**
 * Sortierte Liste von ganzen Zahlen.
 * Das Objekt, das dieses Interface implementiert, verwaltet intern
 * eine Liste von Schlüsseln (ganzen Zahlen), die nach jedem Methodenaufruf
 * stets in aufsteigender Reihenfolge sortiert ist. Ein Schlüssel darf
 * nicht mehrmals in der Liste vorkommen.
 */
public interface SortedList
{
    /**
     * Löscht alle Listenelemente.
     */
    public void clear();

    /**
     * Fügt einen Schlüssel in die sortierte Liste ein.
     * @throws IllegalArgumentException
     *         wenn der Schlüssel bereits in der Liste vorkommt.
     */
    public void insert(int key) throws IllegalArgumentException;

    /**
     * Entfernt einen Schlüssel aus der Liste.
     * @return <code>true</code>, wenn der Schlüssel entfernt wurde;
     *         <code>false</code>, wenn der Schlüssel nicht in der Liste vorkommt.
     */
    public boolean remove(int key);

    /**
     * Gibt die Anzahl der Listenelemente zurück.
     */
    public int getLength();

    /**
     * Gibt die sortierte Liste als (frisch erzeugtes) Array zurück.
     */
    public int[] toArray();
}
