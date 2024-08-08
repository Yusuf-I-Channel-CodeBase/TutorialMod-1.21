package io.github.realyusufismail.utils;

public class TutorialModUtils {
    private TutorialModUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final int TICKS_PER_SECOND = 20;
    private static final int TICKS_PER_MINUTE = TICKS_PER_SECOND * 60;

    public static int getTimeInTicks(int time, TimeUnit unit) {
        return switch (unit) {
            case MINUTES -> time * TICKS_PER_MINUTE;
            case SECONDS -> time * TICKS_PER_SECOND;
        };
    }

    public enum TimeUnit {
        MINUTES,
        SECONDS
    }
}
