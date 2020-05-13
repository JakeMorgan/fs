package com.accenture.tveratc.eetraining;

import com.accenture.tveratc.eetraining.math.MyMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoggingSample {
    private static final Logger LOG = LoggerFactory.getLogger(LoggingSample.class); // получаем логгер

    public static void testSimpleLogging() {
        LOG.info("Начало метода");
        int num = 9;
        LOG.debug("Корень из {} = {}", num, Math.sqrt(num));
        String numStr = "abc";
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            LOG.error("Ошибка конвертации в цисло", e);
        }
    }

    public static void main(String[] args) {
        LOG.debug("Начало работы программы");
        testSimpleLogging();
        try {
            MyMath.logSqrt(16);
            MyMath.logSqrt(-8);
        } catch (Exception e) {
            LOG.error("Ошибка вычисления корня" , e); // логируем исключение
        }

        int maxNumber = 10;
        List<Integer> numbers = MyMath.getNumbers(maxNumber, true);
        LOG.info("Четные числа от 0 до {}: {}", maxNumber, numbers);
        MyMath.getNumbers(-2, false);
    }
}
