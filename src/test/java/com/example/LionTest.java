package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Predator predator;

    @Test
    void getKittensReturnsOne() throws Exception{
        Lion lion = new Lion("Самка", predator);
        assertEquals(1, lion.getKittens());
    }


    @Test
    void getFoodReturnsPredatorFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(predatorFood);
        assertEquals(predatorFood, lion.getFood());
        verify(predator).eatMeat();
    }

}
