package com.accenture.tveratc.eetraining.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyMath {
    private static final Logger LOG = LoggerFactory.getLogger(MyMath.class); // получаем логгер

    public static void logSqrt(int number) throws Exception{
        if(number < 0) {
            throw new Exception("Нельзя извлечь корень из числа меньше 0");
        }
        double result =  Math.sqrt(number);
        LOG.info("Корень из {} = {}", number, result);
    }

    public static List<Integer> getNumbers(int max, boolean even) {
        if(max <= 0) {  // логируем исключительную ситуацию и выбрасываем исключение
            LOG.error("Максимальное число должно быть больше 0, ошибочное значение = {}", max);
            throw new IllegalArgumentException("Максимальное число должно быть больше 0");
        }

        List<Integer> numbers = new ArrayList<>(max / 2 + 1);
        for(int i = 0; i <= max; i++) {
            if(even && i % 2 == 0 || !even && i % 2 != 0) {
                numbers.add(i);
                LOG.debug("Найдено число = {}", i);
            }
        }
        return numbers;
    }
}
