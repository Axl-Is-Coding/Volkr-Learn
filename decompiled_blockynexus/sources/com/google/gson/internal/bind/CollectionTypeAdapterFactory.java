package com.google.gson.internal.bind;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements com.google.gson.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.p f14125a;

    public CollectionTypeAdapterFactory(com.google.gson.internal.p pVar) {
        this.f14125a = pVar;
    }

    @Override // com.google.gson.y
    public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeA = C$Gson$Types.a(type, (Class<?>) rawType);
        return new a(jVar, typeA, jVar.a((TypeToken) TypeToken.get(typeA)), this.f14125a.a(typeToken));
    }

    private static final class a<E> extends com.google.gson.x<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.x<E> f14126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.internal.w<? extends Collection<E>> f14127b;

        public a(com.google.gson.j jVar, Type type, com.google.gson.x<E> xVar, com.google.gson.internal.w<? extends Collection<E>> wVar) {
            this.f14126a = new C2285m(jVar, xVar, type);
            this.f14127b = wVar;
        }

        @Override // com.google.gson.x
        public Collection<E> a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> collectionA = this.f14127b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collectionA.add(this.f14126a.a(jsonReader));
            }
            jsonReader.endArray();
            return collectionA;
        }

        @Override // com.google.gson.x
        public void a(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f14126a.a(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
    }
}
