package com.google.gson.internal.bind;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Currency;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends com.google.gson.x<Currency> {
    D() {
    }

    @Override // com.google.gson.x
    public Currency a(JsonReader jsonReader) throws IOException {
        return Currency.getInstance(jsonReader.nextString());
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Currency currency) throws IOException {
        jsonWriter.value(currency.getCurrencyCode());
    }
}
