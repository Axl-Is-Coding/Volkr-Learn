package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class G extends com.google.gson.x<Locale> {
    G() {
    }

    @Override // com.google.gson.x
    public Locale a(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (strNextToken2 == null && strNextToken3 == null) {
            return new Locale(strNextToken);
        }
        if (strNextToken3 == null) {
            return new Locale(strNextToken, strNextToken2);
        }
        return new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Locale locale) throws IOException {
        jsonWriter.value(locale == null ? null : locale.toString());
    }
}
