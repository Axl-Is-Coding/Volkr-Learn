package com.google.gson.internal.bind;

import com.google.gson.JsonParseException;
import com.google.gson.internal.C2271a;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends com.google.gson.x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.v<T> f14158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.o<T> f14159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.google.gson.j f14160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TypeToken<T> f14161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.gson.y f14162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TreeTypeAdapter<T>.a f14163f = new a();
    private com.google.gson.x<T> g;

    private static final class SingleTypeFactory implements com.google.gson.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeToken<?> f14164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f14166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.google.gson.v<?> f14167d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.google.gson.o<?> f14168e;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            this.f14167d = obj instanceof com.google.gson.v ? (com.google.gson.v) obj : null;
            this.f14168e = obj instanceof com.google.gson.o ? (com.google.gson.o) obj : null;
            C2271a.a((this.f14167d == null && this.f14168e == null) ? false : true);
            this.f14164a = typeToken;
            this.f14165b = z;
            this.f14166c = cls;
        }

        @Override // com.google.gson.y
        public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
            TypeToken<?> typeToken2 = this.f14164a;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.f14165b && this.f14164a.getType() == typeToken.getRawType()) : this.f14166c.isAssignableFrom(typeToken.getRawType())) {
                return new TreeTypeAdapter(this.f14167d, this.f14168e, jVar, typeToken, this);
            }
            return null;
        }
    }

    private final class a implements com.google.gson.n, com.google.gson.u {
        private a() {
        }

        @Override // com.google.gson.n
        public <R> R a(com.google.gson.p pVar, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f14160c.a(pVar, type);
        }
    }

    public TreeTypeAdapter(com.google.gson.v<T> vVar, com.google.gson.o<T> oVar, com.google.gson.j jVar, TypeToken<T> typeToken, com.google.gson.y yVar) {
        this.f14158a = vVar;
        this.f14159b = oVar;
        this.f14160c = jVar;
        this.f14161d = typeToken;
        this.f14162e = yVar;
    }

    private com.google.gson.x<T> b() {
        com.google.gson.x<T> xVar = this.g;
        if (xVar != null) {
            return xVar;
        }
        com.google.gson.x<T> xVarA = this.f14160c.a(this.f14162e, this.f14161d);
        this.g = xVarA;
        return xVarA;
    }

    @Override // com.google.gson.x
    public T a(JsonReader jsonReader) throws IOException {
        if (this.f14159b == null) {
            return b().a(jsonReader);
        }
        com.google.gson.p pVarA = com.google.gson.internal.z.a(jsonReader);
        if (pVarA.j()) {
            return null;
        }
        return this.f14159b.a(pVarA, this.f14161d.getType(), this.f14163f);
    }

    @Override // com.google.gson.x
    public void a(JsonWriter jsonWriter, T t) throws IOException {
        com.google.gson.v<T> vVar = this.f14158a;
        if (vVar == null) {
            b().a(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            com.google.gson.internal.z.a(vVar.a(t, this.f14161d.getType(), this.f14163f), jsonWriter);
        }
    }

    public static com.google.gson.y a(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }
}
