package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsPredatorFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(predatorFood);
        assertEquals(predatorFood, cat.getFood());
        verify(feline).eatMeat();

    }

}
