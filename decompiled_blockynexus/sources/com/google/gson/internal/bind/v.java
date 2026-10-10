package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends com.google.gson.x<BigInteger> {
    v() {
    }

    @Override // com.google.gson.x
    public BigInteger a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new BigInteger(jsonReader.nextString());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
        jsonWriter.value(bigInteger);
    }
}
