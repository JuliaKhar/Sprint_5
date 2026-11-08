package com.example;


import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    Predator predator;

//Корректные значения
    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void hasManeDependsOnSex(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex, predator);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    //НЕкорректные значения
    @ParameterizedTest
    @ValueSource(strings = {"", "оно", "самец", "1"})
    void invalidSexThrowsException(String sex) {
        assertThrows(Exception.class, () -> new Lion(sex, predator));
    }
}
