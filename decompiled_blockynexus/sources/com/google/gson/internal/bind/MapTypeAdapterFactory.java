package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements com.google.gson.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.p f14134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f14135b;

    public MapTypeAdapterFactory(com.google.gson.internal.p pVar, boolean z) {
        this.f14134a = pVar;
        this.f14135b = z;
    }

    @Override // com.google.gson.y
    public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] typeArrB = C$Gson$Types.b(type, C$Gson$Types.e(type));
        return new a(jVar, typeArrB[0], a(jVar, typeArrB[0]), typeArrB[1], jVar.a((TypeToken) TypeToken.get(typeArrB[1])), this.f14134a.a(typeToken));
    }

    private final class a<K, V> extends com.google.gson.x<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.x<K> f14136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.x<V> f14137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.gson.internal.w<? extends Map<K, V>> f14138c;

        public a(com.google.gson.j jVar, Type type, com.google.gson.x<K> xVar, Type type2, com.google.gson.x<V> xVar2, com.google.gson.internal.w<? extends Map<K, V>> wVar) {
            this.f14136a = new C2285m(jVar, xVar, type);
            this.f14137b = new C2285m(jVar, xVar2, type2);
            this.f14138c = wVar;
        }

        @Override // com.google.gson.x
        public Map<K, V> a(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (jsonTokenPeek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> mapA = this.f14138c.a();
            if (jsonTokenPeek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K kA = this.f14136a.a(jsonReader);
                    if (mapA.put(kA, this.f14137b.a(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + kA);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    com.google.gson.internal.s.INSTANCE.promoteNameToValue(jsonReader);
                    K kA2 = this.f14136a.a(jsonReader);
                    if (mapA.put(kA2, this.f14137b.a(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + kA2);
                    }
                }
                jsonReader.endObject();
            }
            return mapA;
        }

        @Override // com.google.gson.x
        public void a(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            if (!MapTypeAdapterFactory.this.f14135b) {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.f14137b.a(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.p pVarA = this.f14136a.a(entry2.getKey());
                arrayList.add(pVarA);
                arrayList2.add(entry2.getValue());
                z |= pVarA.i() || pVarA.k();
            }
            if (z) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.beginArray();
                    com.google.gson.internal.z.a((com.google.gson.p) arrayList.get(i), jsonWriter);
                    this.f14137b.a(jsonWriter, (V) arrayList2.get(i));
                    jsonWriter.endArray();
                    i++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (i < size2) {
                jsonWriter.name(a((com.google.gson.p) arrayList.get(i)));
                this.f14137b.a(jsonWriter, (V) arrayList2.get(i));
                i++;
            }
            jsonWriter.endObject();
        }

        private String a(com.google.gson.p pVar) {
            if (pVar.l()) {
                com.google.gson.t tVarF = pVar.f();
                if (tVarF.s()) {
                    return String.valueOf(tVarF.q());
                }
                if (tVarF.r()) {
                    return Boolean.toString(tVarF.m());
                }
                if (tVarF.t()) {
                    return tVarF.h();
                }
                throw new AssertionError();
            }
            if (pVar.j()) {
                return "null";
            }
            throw new AssertionError();
        }
    }

    private com.google.gson.x<?> a(com.google.gson.j jVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return jVar.a((TypeToken) TypeToken.get(type));
        }
        return T.f14155f;
    }
}
