package layout;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LayoutPreciseValidationBuilder {
    private double actualDistance;
    private String notificationMessage;
    private String failedAssertionMessage;

    public LayoutPreciseValidationBuilder(Supplier<Double> calculateActualDistanceFunction, Supplier<String> notificationMessageFunction, Supplier<String> failedAssertionMessageFunction) {
        if (calculateActualDistanceFunction != null)
            actualDistance = calculateActualDistanceFunction.get();
        notificationMessage = notificationMessageFunction.get();
        failedAssertionMessage = failedAssertionMessageFunction.get();
    }

    public LayoutPreciseValidationBuilder(double actualDistance) {
        this.actualDistance = actualDistance;
    }

    public FinishValidationBuilder equal(int expected) {
        return new FinishValidationBuilder((r) -> actualDistance == expected,
                () -> buildNotificationValidationMessage(ComparingOperators.EQUAL, expected),
                () -> buildFailedValidationMessage(ComparingOperators.EQUAL, expected));
    }

    public FinishValidationBuilder lessThan(int expected) {
        return new FinishValidationBuilder((r) -> actualDistance < expected,
                () -> buildNotificationValidationMessage(ComparingOperators.LESS_THAN, expected),
                () -> buildFailedValidationMessage(ComparingOperators.LESS_THAN, expected));
    }

    public FinishValidationBuilder lessThanOrEqual(int expected) {
        return new FinishValidationBuilder((r) -> actualDistance <= expected,
                () -> buildNotificationValidationMessage(ComparingOperators.LESS_THAN_EQUAL, expected),
                () -> buildFailedValidationMessage(ComparingOperators.LESS_THAN_EQUAL, expected));
    }

    public FinishValidationBuilder greaterThan(int expected) {
        return new FinishValidationBuilder((r) -> actualDistance > expected,
                () -> buildNotificationValidationMessage(ComparingOperators.GREATER_THAN, expected),
                () -> buildFailedValidationMessage(ComparingOperators.GREATER_THAN, expected));
    }

    public FinishValidationBuilder greaterThanOrEqual(int expected) {
        return new FinishValidationBuilder((r) -> actualDistance >= expected,
                () -> buildNotificationValidationMessage(ComparingOperators.GREATER_THAN_EQUAL, expected),
                () -> buildFailedValidationMessage(ComparingOperators.GREATER_THAN_EQUAL, expected));
    }

    private String buildNotificationValidationMessage(ComparingOperators comparingMessage, int expected) {
        return String.format("%s%s %d px", notificationMessage, comparingMessage, expected);
    }

    private String buildFailedValidationMessage(ComparingOperators comparingMessage, int expected) {
        return String.format("%s%s %d px", failedAssertionMessage, comparingMessage, expected);
    }

    public void validate() {
        assertTrue(actualDistance > 0, failedAssertionMessage);
    }
}
