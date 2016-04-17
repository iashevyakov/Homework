package ru.itis.inform;

public interface Iterator<T> {

    /**
     * Проверить, есть ли слеующий элемент
     * @return true - если есть, false - в противном случае
     */
    boolean hasNext();
    boolean hasPrevious();
    T peakNext();
    T peakPrevious();

    /**
     * Возвращает следующий элемент
     * @return возвращаемый элемент
     */
    T next();

    /**
     * Возвращает предыдущий элемент
     * @return возвращаемый элемент
     */
    T previous();

    /**
     * Вставляет новый элемент между next и previous
     * @param element
     */
    void insert(T element);
}