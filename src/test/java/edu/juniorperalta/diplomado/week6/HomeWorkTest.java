package edu.juniorperalta.diplomado.week6;

import com.github.javafaker.Faker;
import edu.juniorperalta.diplomado.model.week3.FrequencyType;
import edu.juniorperalta.diplomado.model.week3.LoanType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertNull;

/**
 * @author aluis on 5/2/2022.
 */
class HomeWorkTest {

    private static final boolean REQUIRED_FIELD = true;
    private static final boolean NO_REQUIRED_FIELD = false;

    private static final boolean COPY_FROM_DEFAULT = true;
    private static final boolean NO_COPY_FROM_DEFAULT = false;

    private final HomeWork homeWork = new HomeWork();
    private static final Faker faker = new Faker();

    @ParameterizedTest
    @MethodSource("edu.juniorperalta.diplomado.week6.HomeWorkTest#provideRandomNames")
    void fullNameFormTest(String name) {
        assertEquals("", homeWork.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, "", name, ""));
        assertEquals("", homeWork.formValidation(NO_REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, name, "", ""));
    }

    @ParameterizedTest
    @EnumSource(LoanType.class)
    void loanTypeFormTest(LoanType loanType) {
        assertEquals(loanType, homeWork.formValidation(REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, loanType, "", null));
    }

    @ParameterizedTest
    @MethodSource("edu.juniorperalta.diplomado.week6.HomeWorkTest#provideRandomBigDecimals")
    void capitalFormTest(BigDecimal capital) {
        assertEquals(capital, homeWork.formValidation(REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, capital, null, BigDecimal.ZERO));
    }

    @ParameterizedTest
    @EnumSource(FrequencyType.class)
    void frequencyTypeFormTest(FrequencyType frequencyType) {
        assertEquals(frequencyType.MONTHLY, homeWork.formValidation(REQUIRED_FIELD, NO_COPY_FROM_DEFAULT, frequencyType.MONTHLY, frequencyType, null));
    }

    @ParameterizedTest
    @MethodSource("edu.juniorperalta.diplomado.week6.HomeWorkTest#provideRandomIntegers")
    void quotesFormTest(Integer quotes) {
        assertEquals(quotes, homeWork.formValidation(REQUIRED_FIELD, COPY_FROM_DEFAULT, quotes, 12, null));
        assertNull(null, homeWork.formValidation(REQUIRED_FIELD, COPY_FROM_DEFAULT, null, 12, null));
    }

    @ParameterizedTest
    @MethodSource("edu.juniorperalta.diplomado.week6.HomeWorkTest#provideRandomBigDecimals")
    void interestFormTest(BigDecimal interest) {
        BigDecimal defaultValue = new BigDecimal("8.5");
        assertEquals(defaultValue, homeWork.formValidation(NO_REQUIRED_FIELD, COPY_FROM_DEFAULT, interest, defaultValue, BigDecimal.ZERO));
        assertNull(homeWork.formValidation(NO_REQUIRED_FIELD, COPY_FROM_DEFAULT, interest, null, BigDecimal.ZERO));
    }

    @Test
    void startDateTest() {
        assertNull(homeWork.formValidation(REQUIRED_FIELD, COPY_FROM_DEFAULT, null, LocalDate.now(), null));
    }

    static Stream<Arguments> provideRandomNames() {
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(faker.name().fullName()));
    }

    static Stream<Arguments> provideRandomBigDecimals() {
        SecureRandom secureRandom = new SecureRandom();
        return IntStream.range(0, 20).mapToObj(value -> {
            if (value % 2 == 0) {
                return Arguments.of(new BigDecimal(secureRandom.nextInt()));
            }
            return Arguments.of(new BigDecimal(secureRandom.nextDouble() + ""));
        });
    }

    static Stream<Arguments> provideRandomIntegers() {
        SecureRandom secureRandom = new SecureRandom();
        return IntStream.range(0, 20).mapToObj(value -> Arguments.of(secureRandom.nextInt()));
    }
}