package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

// Проверка на 0 и положительные значения
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 100})
    void getKittensWithArgumentsReturnsKittensCount(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

//Добавила проверку на передачу отрицательных значений, сейчас в реализации кода этой проверки валидации нет, поэтому с минусом должен отработать так же, как и с плюсом
//Позднее можно будет тест переписать на assertThrows, если добавится реализация в коде
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void getKittensWithNegativeCountReturnsItAsIs(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
