package com.google.gson.internal;

import com.google.gson.stream.JsonReader;
import java.io.IOException;

/* JADX INFO: compiled from: JsonReaderInternalAccess.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s {
    public static s INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader) throws IOException;
}
