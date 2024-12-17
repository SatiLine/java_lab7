package org.example.taskone;

import java.util.Random;

public final class EvenNumbers extends java.lang.Thread { //наследует класс Thread,
                                                          //что позволяет ему выполнять код в отдельном потоке.
    @Override
    public void run() { // Метод run() переопределяется из класса Thread.
                        //Этот метод содержит код, который будет выполняться в новом потоке. 
        new Random() // создаем новый экземпляр класса
            .ints(-1000, 1001) // метод генерирует бесконечный поток случайных целых чисел
            .filter(number -> number % 2 == 0) // оставляет только четные числа
            .limit(5) 
            .forEach(System.out::println); // метод применяется к оставшимся элементам потока 
                                           //и выводит каждое четное число на консоль
    }
}

