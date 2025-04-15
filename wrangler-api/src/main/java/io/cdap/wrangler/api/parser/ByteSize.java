package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;

public class ByteSize implements Token {

    static Object parse(String kb) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private final String value;
    private final long bytes;

    public ByteSize(String value) {
        this.value = value.toUpperCase();
        this.bytes = parseBytes(value);
    }

    private long parseBytes(String value) {
        double number = Double.parseDouble(value.replaceAll("[^0-9.]", ""));
        if (value.endsWith("PB")) return (long) (number * Math.pow(1024, 5));
        if (value.endsWith("TB")) return (long) (number * Math.pow(1024, 4));
        if (value.endsWith("GB")) return (long) (number * Math.pow(1024, 3));
        if (value.endsWith("MB")) return (long) (number * Math.pow(1024, 2));
        if (value.endsWith("KB")) return (long) (number * 1024);
        return (long) number;
    }

    public long getBytes() {
        return bytes;
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
