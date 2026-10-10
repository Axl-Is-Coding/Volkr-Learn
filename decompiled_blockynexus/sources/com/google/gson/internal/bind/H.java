package com.google.gson.internal.bind;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends com.google.gson.x<com.google.gson.p> {
    H() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.x
    public com.google.gson.p a(JsonReader jsonReader) throws IOException {
        switch (K.f14133a[jsonReader.peek().ordinal()]) {
            case 1:
                return new com.google.gson.t((Number) new LazilyParsedNumber(jsonReader.nextString()));
            case 2:
                return new com.google.gson.t(Boolean.valueOf(jsonReader.nextBoolean()));
            case 3:
                return new com.google.gson.t(jsonReader.nextString());
            case 4:
                jsonReader.nextNull();
                return com.google.gson.q.f14259a;
            case 5:
                com.google.gson.m mVar = new com.google.gson.m();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    mVar.a(a(jsonReader));
                }
                jsonReader.endArray();
                return mVar;
            case 6:
                com.google.gson.r rVar = new com.google.gson.r();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    rVar.a(jsonReader.nextName(), a(jsonReader));
                }
                jsonReader.endObject();
                return rVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, com.google.gson.p pVar) throws IOException {
        if (pVar != null && !pVar.j()) {
            if (pVar.l()) {
                com.google.gson.t tVarF = pVar.f();
                if (tVarF.s()) {
                    jsonWriter.value(tVarF.q());
                    return;
                } else if (tVarF.r()) {
                    jsonWriter.value(tVarF.m());
                    return;
                } else {
                    jsonWriter.value(tVarF.h());
                    return;
                }
            }
            if (pVar.i()) {
                jsonWriter.beginArray();
                Iterator<com.google.gson.p> it = pVar.c().iterator();
                while (it.hasNext()) {
                    a(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (pVar.k()) {
                jsonWriter.beginObject();
                for (Map.Entry<String, com.google.gson.p> entry : pVar.e().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    a(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + pVar.getClass());
        }
        jsonWriter.nullValue();
    }
}
