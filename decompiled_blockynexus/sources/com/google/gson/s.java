package com.google.gson;

import com.google.gson.internal.z;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: compiled from: JsonParser.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public p a(String str) throws JsonSyntaxException {
        return a(new StringReader(str));
    }

    public p a(Reader reader) throws JsonSyntaxException, JsonIOException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            p pVarA = a(jsonReader);
            if (!pVarA.j() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return pVarA;
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public p a(JsonReader jsonReader) throws JsonSyntaxException, JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return z.a(jsonReader);
            } catch (OutOfMemoryError e2) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            } catch (StackOverflowError e3) {
                throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e3);
            }
        } finally {
            jsonReader.setLenient(zIsLenient);
        }
    }
}
