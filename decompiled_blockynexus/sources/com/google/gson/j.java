package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.C2273a;
import com.google.gson.internal.bind.C2274b;
import com.google.gson.internal.bind.C2276d;
import com.google.gson.internal.bind.C2278f;
import com.google.gson.internal.bind.C2280h;
import com.google.gson.internal.bind.C2282j;
import com.google.gson.internal.bind.C2283k;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.T;
import com.google.gson.internal.z;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TypeToken<?> f14245a = TypeToken.get(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Map<TypeToken<?>, a<?>>> f14246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<TypeToken<?>, x<?>> f14247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.internal.p f14248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f14249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<y> f14250f;
    final Excluder g;
    final d h;
    final Map<Type, l<?>> i;
    final boolean j;
    final boolean k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final LongSerializationPolicy t;
    final List<y> u;
    final List<y> v;

    public j() {
        this(Excluder.f14102a, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private x<Number> a(boolean z) {
        return z ? T.v : new e(this);
    }

    private x<Number> b(boolean z) {
        return z ? T.u : new f(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.j + ",factories:" + this.f14250f + ",instanceCreators:" + this.f14248d + "}";
    }

    /* JADX INFO: compiled from: Gson.java */
    /* JADX INFO: loaded from: classes2.dex */
    static class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f14251a;

        a() {
        }

        public void a(x<T> xVar) {
            if (this.f14251a != null) {
                throw new AssertionError();
            }
            this.f14251a = xVar;
        }

        @Override // com.google.gson.x
        public T a(JsonReader jsonReader) throws IOException {
            x<T> xVar = this.f14251a;
            if (xVar != null) {
                return xVar.a(jsonReader);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.x
        public void a(JsonWriter jsonWriter, T t) throws IOException {
            x<T> xVar = this.f14251a;
            if (xVar != null) {
                xVar.a(jsonWriter, t);
                return;
            }
            throw new IllegalStateException();
        }
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static x<AtomicLongArray> b(x<Number> xVar) {
        return new i(xVar).a();
    }

    private static x<Number> a(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return T.t;
        }
        return new g();
    }

    public p b(Object obj) {
        if (obj == null) {
            return q.f14259a;
        }
        return b(obj, obj.getClass());
    }

    j(Excluder excluder, d dVar, Map<Type, l<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, String str, int i, int i2, List<y> list, List<y> list2, List<y> list3) {
        this.f14246b = new ThreadLocal<>();
        this.f14247c = new ConcurrentHashMap();
        this.g = excluder;
        this.h = dVar;
        this.i = map;
        this.f14248d = new com.google.gson.internal.p(map);
        this.j = z;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
        this.t = longSerializationPolicy;
        this.q = str;
        this.r = i;
        this.s = i2;
        this.u = list;
        this.v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(T.Y);
        arrayList.add(C2280h.f14195a);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(T.D);
        arrayList.add(T.m);
        arrayList.add(T.g);
        arrayList.add(T.i);
        arrayList.add(T.k);
        x<Number> xVarA = a(longSerializationPolicy);
        arrayList.add(T.a(Long.TYPE, Long.class, xVarA));
        arrayList.add(T.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(T.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(T.x);
        arrayList.add(T.o);
        arrayList.add(T.q);
        arrayList.add(T.a(AtomicLong.class, a(xVarA)));
        arrayList.add(T.a(AtomicLongArray.class, b(xVarA)));
        arrayList.add(T.s);
        arrayList.add(T.z);
        arrayList.add(T.F);
        arrayList.add(T.H);
        arrayList.add(T.a(BigDecimal.class, T.B));
        arrayList.add(T.a(BigInteger.class, T.C));
        arrayList.add(T.J);
        arrayList.add(T.L);
        arrayList.add(T.P);
        arrayList.add(T.R);
        arrayList.add(T.W);
        arrayList.add(T.N);
        arrayList.add(T.f14153d);
        arrayList.add(C2274b.f14186a);
        arrayList.add(T.U);
        arrayList.add(C2283k.f14202a);
        arrayList.add(C2282j.f14200a);
        arrayList.add(T.S);
        arrayList.add(C2273a.f14182a);
        arrayList.add(T.f14151b);
        arrayList.add(new CollectionTypeAdapterFactory(this.f14248d));
        arrayList.add(new MapTypeAdapterFactory(this.f14248d, z2));
        this.f14249e = new JsonAdapterAnnotationTypeAdapterFactory(this.f14248d);
        arrayList.add(this.f14249e);
        arrayList.add(T.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f14248d, dVar, excluder, this.f14249e));
        this.f14250f = Collections.unmodifiableList(arrayList);
    }

    public p b(Object obj, Type type) {
        C2278f c2278f = new C2278f();
        a(obj, type, c2278f);
        return c2278f.b();
    }

    private static x<AtomicLong> a(x<Number> xVar) {
        return new h(xVar).a();
    }

    public <T> x<T> a(TypeToken<T> typeToken) {
        x<T> xVar = (x) this.f14247c.get(typeToken == null ? f14245a : typeToken);
        if (xVar != null) {
            return xVar;
        }
        Map<TypeToken<?>, a<?>> map = this.f14246b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f14246b.set(map);
            z = true;
        }
        a<?> aVar = map.get(typeToken);
        if (aVar != null) {
            return aVar;
        }
        try {
            a<?> aVar2 = new a<>();
            map.put(typeToken, aVar2);
            Iterator<y> it = this.f14250f.iterator();
            while (it.hasNext()) {
                x<T> xVarA = it.next().a(this, typeToken);
                if (xVarA != null) {
                    aVar2.a((x<?>) xVarA);
                    this.f14247c.put(typeToken, xVarA);
                    return xVarA;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + typeToken);
        } finally {
            map.remove(typeToken);
            if (z) {
                this.f14246b.remove();
            }
        }
    }

    public <T> x<T> a(y yVar, TypeToken<T> typeToken) {
        if (!this.f14250f.contains(yVar)) {
            yVar = this.f14249e;
        }
        boolean z = false;
        for (y yVar2 : this.f14250f) {
            if (z) {
                x<T> xVarA = yVar2.a(this, typeToken);
                if (xVarA != null) {
                    return xVarA;
                }
            } else if (yVar2 == yVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public <T> x<T> a(Class<T> cls) {
        return a((TypeToken) TypeToken.get((Class) cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((p) q.f14259a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            a(obj, type, a(z.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public void a(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        x xVarA = a((TypeToken) TypeToken.get(type));
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.m);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.j);
        try {
            try {
                xVarA.a(jsonWriter, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public String a(p pVar) {
        StringWriter stringWriter = new StringWriter();
        a(pVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(p pVar, Appendable appendable) throws JsonIOException {
        try {
            a(pVar, a(z.a(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public JsonWriter a(Writer writer) throws IOException {
        if (this.l) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.n) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.j);
        return jsonWriter;
    }

    public JsonReader a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.o);
        return jsonReader;
    }

    public void a(p pVar, JsonWriter jsonWriter) throws JsonIOException {
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.m);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.j);
        try {
            try {
                z.a(pVar, jsonWriter);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage(), e3);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public <T> T a(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.internal.y.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderA = a(reader);
        T t = (T) a(jsonReaderA, type);
        a(t, jsonReaderA);
        return t;
    }

    private static void a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public <T> T a(JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        boolean z = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    T tA = a((TypeToken) TypeToken.get(type)).a(jsonReader);
                    jsonReader.setLenient(zIsLenient);
                    return tA;
                } catch (IOException e2) {
                    throw new JsonSyntaxException(e2);
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (z) {
                    jsonReader.setLenient(zIsLenient);
                    return null;
                }
                throw new JsonSyntaxException(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e5.getMessage(), e5);
            }
        } catch (Throwable th) {
            jsonReader.setLenient(zIsLenient);
            throw th;
        }
    }

    public <T> T a(p pVar, Class<T> cls) throws JsonSyntaxException {
        return (T) com.google.gson.internal.y.a((Class) cls).cast(a(pVar, (Type) cls));
    }

    public <T> T a(p pVar, Type type) throws JsonSyntaxException {
        if (pVar == null) {
            return null;
        }
        return (T) a((JsonReader) new C2276d(pVar), type);
    }
}
