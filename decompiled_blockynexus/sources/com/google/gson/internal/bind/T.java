package com.google.gson.internal.bind;

import com.google.gson.internal.bind.T;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: TypeAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
public final class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.x<Class> f14150a = new x().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.gson.y f14151b = a(Class.class, f14150a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.gson.x<BitSet> f14152c = new I().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.gson.y f14153d = a(BitSet.class, f14152c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f14154e = new L();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f14155f = new M();
    public static final com.google.gson.y g = a(Boolean.TYPE, Boolean.class, f14154e);
    public static final com.google.gson.x<Number> h = new N();
    public static final com.google.gson.y i = a(Byte.TYPE, Byte.class, h);
    public static final com.google.gson.x<Number> j = new O();
    public static final com.google.gson.y k = a(Short.TYPE, Short.class, j);
    public static final com.google.gson.x<Number> l = new P();
    public static final com.google.gson.y m = a(Integer.TYPE, Integer.class, l);
    public static final com.google.gson.x<AtomicInteger> n = new Q().a();
    public static final com.google.gson.y o = a(AtomicInteger.class, n);
    public static final com.google.gson.x<AtomicBoolean> p = new S().a();
    public static final com.google.gson.y q = a(AtomicBoolean.class, p);
    public static final com.google.gson.x<AtomicIntegerArray> r = new C2286n().a();
    public static final com.google.gson.y s = a(AtomicIntegerArray.class, r);
    public static final com.google.gson.x<Number> t = new C2287o();
    public static final com.google.gson.x<Number> u = new C2288p();
    public static final com.google.gson.x<Number> v = new C2289q();
    public static final com.google.gson.x<Number> w = new r();
    public static final com.google.gson.y x = a(Number.class, w);
    public static final com.google.gson.x<Character> y = new C2290s();
    public static final com.google.gson.y z = a(Character.TYPE, Character.class, y);
    public static final com.google.gson.x<String> A = new C2291t();
    public static final com.google.gson.x<BigDecimal> B = new u();
    public static final com.google.gson.x<BigInteger> C = new v();
    public static final com.google.gson.y D = a(String.class, A);
    public static final com.google.gson.x<StringBuilder> E = new w();
    public static final com.google.gson.y F = a(StringBuilder.class, E);
    public static final com.google.gson.x<StringBuffer> G = new y();
    public static final com.google.gson.y H = a(StringBuffer.class, G);
    public static final com.google.gson.x<URL> I = new z();
    public static final com.google.gson.y J = a(URL.class, I);
    public static final com.google.gson.x<URI> K = new A();
    public static final com.google.gson.y L = a(URI.class, K);
    public static final com.google.gson.x<InetAddress> M = new B();
    public static final com.google.gson.y N = b(InetAddress.class, M);
    public static final com.google.gson.x<UUID> O = new C();
    public static final com.google.gson.y P = a(UUID.class, O);
    public static final com.google.gson.x<Currency> Q = new D().a();
    public static final com.google.gson.y R = a(Currency.class, Q);
    public static final com.google.gson.y S = new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$26
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new E(this, jVar.a((Class) Date.class));
        }
    };
    public static final com.google.gson.x<Calendar> T = new F();
    public static final com.google.gson.y U = b(Calendar.class, GregorianCalendar.class, T);
    public static final com.google.gson.x<Locale> V = new G();
    public static final com.google.gson.y W = a(Locale.class, V);
    public static final com.google.gson.x<com.google.gson.p> X = new H();
    public static final com.google.gson.y Y = b(com.google.gson.p.class, X);
    public static final com.google.gson.y Z = new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$30
        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new T.a(rawType);
        }
    };

    public static <TT> com.google.gson.y a(final TypeToken<TT> typeToken, final com.google.gson.x<TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$31
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return xVar;
                }
                return null;
            }
        };
    }

    public static <TT> com.google.gson.y b(final Class<TT> cls, final Class<? extends TT> cls2, final com.google.gson.x<? super TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$34
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TypeAdapters.java */
    static final class a<T extends Enum<T>> extends com.google.gson.x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f14156a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<T, String> f14157b = new HashMap();

        public a(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    com.google.gson.a.c cVar = (com.google.gson.a.c) cls.getField(strName).getAnnotation(com.google.gson.a.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f14156a.put(str, t);
                        }
                    }
                    this.f14156a.put(strName, t);
                    this.f14157b.put(t, strName);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.x
        public T a(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return this.f14156a.get(jsonReader.nextString());
        }

        @Override // com.google.gson.x
        public void a(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(t == null ? null : this.f14157b.get(t));
        }
    }

    public static <TT> com.google.gson.y a(final Class<TT> cls, final com.google.gson.x<TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$32
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == cls) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <T1> com.google.gson.y b(Class<T1> cls, com.google.gson.x<T1> xVar) {
        return new TypeAdapters$35(cls, xVar);
    }

    public static <TT> com.google.gson.y a(final Class<TT> cls, final Class<TT> cls2, final com.google.gson.x<? super TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters$33
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }
}
