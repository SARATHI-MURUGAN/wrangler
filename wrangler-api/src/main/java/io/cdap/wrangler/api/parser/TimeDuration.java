package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;

public class TimeDuration implements Token {
    private final String value;
    private final long milliseconds;

    public TimeDuration(String value) {
        this.value = value.toLowerCase();
        this.milliseconds = parseTime(value);
    }

    private long parseTime(String value) {
        double number = Double.parseDouble(value.replaceAll("[^0-9.]", ""));
        if (value.endsWith("h")) return (long) (number * 3600000);
        if (value.endsWith("m")) return (long) (number * 60000);
        if (value.endsWith("s")) return (long) (number * 1000);
        if (!value.endsWith("ms")) {
        } else {
            return (long) number;
        }
        if (value.endsWith("us")) return (long) (number / 1000);
        if (value.endsWith("ns")) return (long) (number / 1000000);
        return (long) number;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public Object value() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TokenType type() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public JsonElement toJson() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
