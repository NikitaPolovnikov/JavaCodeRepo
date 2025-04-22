package org.example;

<<<<<<< Updated upstream
public interface Filter {
    Object apply (Object o);
=======
public interface Filter<T> {
    T apply (T object);
>>>>>>> Stashed changes
}
