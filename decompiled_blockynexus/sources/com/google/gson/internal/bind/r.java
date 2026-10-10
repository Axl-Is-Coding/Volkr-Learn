package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends com.google.gson.x<Number> {
    r() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Number a(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        int i = K.f14133a[jsonTokenPeek.ordinal()];
        if (i == 1 || i == 3) {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
        if (i == 4) {
            jsonReader.nextNull();
            return null;
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenPeek);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
