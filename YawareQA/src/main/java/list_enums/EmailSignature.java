package list_enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EmailSignature {
    GMAIL("@gmail.com"),
    UKRNET("@ukr.net"),
    YANDEX("@yandex.uk"),
    LIST("@list.ua"),
    TEST("@test.com");

    private String signature;

    EmailSignature(String signature) {
        this.signature = signature;
    }

    public String getEmailSignature() {
        return signature;
    }

    public static String getRandomEmailSignature() {
        return VALUES.get(RANDOM.nextInt(SIZE)).signature;
    }

    private static final List<EmailSignature> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
}
