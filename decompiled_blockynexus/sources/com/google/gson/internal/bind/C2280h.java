package com.google.gson.internal.bind;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.google.gson.internal.bind.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObjectTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2280h extends com.google.gson.x<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.y f14195a = new com.google.gson.y() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter$1
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new C2280h(jVar);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.j f14196b;

    C2280h(com.google.gson.j jVar) {
        this.f14196b = jVar;
    }

    @Override // com.google.gson.x
    public Object a(JsonReader jsonReader) throws IOException {
        switch (C2279g.f14194a[jsonReader.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(a(jsonReader));
                }
                jsonReader.endArray();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    linkedTreeMap.put(jsonReader.nextName(), a(jsonReader));
                }
                jsonReader.endObject();
                return linkedTreeMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        com.google.gson.x xVarA = this.f14196b.a((Class) obj.getClass());
        if (xVarA instanceof C2280h) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            xVarA.a(jsonWriter, obj);
        }
    }
}
