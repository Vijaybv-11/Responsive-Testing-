package layout;


import lombok.Getter;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinishValidationBuilder {

    @Getter private final Predicate comparingFunction;
    private String notificationMessage;
    private String failedAssertionMessage;

    public FinishValidationBuilder(Predicate comparingFunction, Supplier<String> notificationMessageFunction, Supplier<String> failedAssertionMessageFunction) {
        this.comparingFunction = comparingFunction;
        this.notificationMessage = notificationMessageFunction.get();
        this.failedAssertionMessage = failedAssertionMessageFunction.get();
    }

    public FinishValidationBuilder(Predicate comparingFunction) {

        this.comparingFunction = comparingFunction;
    }

    public void validate() {

        assertTrue(comparingFunction.test(true), failedAssertionMessage);
    }
}
