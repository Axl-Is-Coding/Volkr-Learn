package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends com.google.gson.x<BigDecimal> {
    u() {
    }

    @Override // com.google.gson.x
    public BigDecimal a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new BigDecimal(jsonReader.nextString());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
        jsonWriter.value(bigDecimal);
    }
}
