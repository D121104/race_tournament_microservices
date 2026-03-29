package com.tkkt.utils;

public class TimeConverterUtil {
    public static Long parseToMilliseconds(String timeString) {
        if (timeString == null || timeString.trim().isEmpty()) {
            return null;
        }

        try {
            long totalMilliseconds = 0;

            String[] parts = timeString.split("\\.");
            long milliseconds = Long.parseLong(parts[1]);
            totalMilliseconds += milliseconds;

            String[] timeParts = parts[0].split(":");

            if (timeParts.length == 3) {
                long hours = Long.parseLong(timeParts[0]);
                long minutes = Long.parseLong(timeParts[1]);
                long seconds = Long.parseLong(timeParts[2]);
                totalMilliseconds += (hours * 3600000) + (minutes * 60000) + (seconds * 1000);
            } else if (timeParts.length == 2) {
                long minutes = Long.parseLong(timeParts[0]);
                long seconds = Long.parseLong(timeParts[1]);

                totalMilliseconds += (minutes * 60000) + (seconds * 1000);
            }

            return totalMilliseconds;

        } catch (Exception e) {
            throw new IllegalArgumentException("Không thể parse thời gian: " + timeString);
        }
    }
}
