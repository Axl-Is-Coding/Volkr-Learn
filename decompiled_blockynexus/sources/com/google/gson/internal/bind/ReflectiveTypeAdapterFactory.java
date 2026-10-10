package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements com.google.gson.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.p f14140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.d f14141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Excluder f14142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f14143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.gson.internal.a.b f14144e = com.google.gson.internal.a.b.a();

    static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f14147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f14148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f14149c;

        protected b(String str, boolean z, boolean z2) {
            this.f14147a = str;
            this.f14148b = z;
            this.f14149c = z2;
        }

        abstract void a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        abstract void a(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        abstract boolean a(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.p pVar, com.google.gson.d dVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f14140a = pVar;
        this.f14141b = dVar;
        this.f14142c = excluder;
        this.f14143d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f14142c);
    }

    static boolean a(Field field, boolean z, Excluder excluder) {
        return (excluder.a(field.getType(), z) || excluder.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f14141b.translateName(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static final class a<T> extends com.google.gson.x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.internal.w<T> f14145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, b> f14146b;

        a(com.google.gson.internal.w<T> wVar, Map<String, b> map) {
            this.f14145a = wVar;
            this.f14146b = map;
        }

        @Override // com.google.gson.x
        public T a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T tA = this.f14145a.a();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    b bVar = this.f14146b.get(jsonReader.nextName());
                    if (bVar == null || !bVar.f14149c) {
                        jsonReader.skipValue();
                    } else {
                        bVar.a(jsonReader, tA);
                    }
                }
                jsonReader.endObject();
                return tA;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.x
        public void a(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (b bVar : this.f14146b.values()) {
                    if (bVar.a(t)) {
                        jsonWriter.name(bVar.f14147a);
                        bVar.a(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    @Override // com.google.gson.y
    public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new a(this.f14140a.a(typeToken), a(jVar, (TypeToken<?>) typeToken, (Class<?>) rawType));
        }
        return null;
    }

    private b a(com.google.gson.j jVar, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        boolean zA = com.google.gson.internal.y.a((Type) typeToken.getRawType());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        com.google.gson.x<?> xVarA = bVar != null ? this.f14143d.a(this.f14140a, jVar, typeToken, bVar) : null;
        boolean z3 = xVarA != null;
        if (xVarA == null) {
            xVarA = jVar.a((TypeToken) typeToken);
        }
        return new C2281i(this, str, z, z2, field, z3, xVarA, jVar, typeToken, zA);
    }

    private Map<String, b> a(com.google.gson.j jVar, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean zA = a(field, true);
                boolean zA2 = a(field, z);
                if (zA || zA2) {
                    this.f14144e.a(field);
                    Type typeA = C$Gson$Types.a(typeToken2.getType(), rawType, field.getGenericType());
                    List<String> listA = a(field);
                    int size = listA.size();
                    b bVar = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = listA.get(i2);
                        boolean z2 = i2 != 0 ? false : zA;
                        b bVar2 = bVar;
                        int i3 = i2;
                        int i4 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str, a(jVar, field, str, TypeToken.get(typeA), z2, zA2)) : bVar2;
                        i2 = i3 + 1;
                        zA = z2;
                        listA = list;
                        size = i4;
                        field = field2;
                    }
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + bVar3.f14147a);
                    }
                }
                i++;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.a(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return linkedHashMap;
    }
}
