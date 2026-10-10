package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.gson.internal.bind.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class C2290s extends com.google.gson.x<Character> {
    C2290s() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public Character a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String strNextString = jsonReader.nextString();
        if (strNextString.length() == 1) {
            return Character.valueOf(strNextString.charAt(0));
        }
        throw new JsonSyntaxException("Expecting character, got: " + strNextString);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Character ch) throws IOException {
        jsonWriter.value(ch == null ? null : String.valueOf(ch));
    }
}
