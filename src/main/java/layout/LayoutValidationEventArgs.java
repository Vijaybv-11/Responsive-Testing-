package layout;

import lombok.Getter;

public class LayoutValidationEventArgs {
    @Getter private final String message;

    public LayoutValidationEventArgs(String message) {
        this.message = message;
    }
}
