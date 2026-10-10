package org.greenrobot.greendao.d;

import java.util.List;

/* JADX INFO: compiled from: Query.java */
/* JADX INFO: loaded from: classes5.dex */
public class h<T> extends c<T> {
    private final a<T> h;

    /* JADX INFO: compiled from: Query.java */
    private static final class a<T2> extends b<T2, h<T2>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f23609e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f23610f;

        a(org.greenrobot.greendao.a<T2, ?> aVar, String str, String[] strArr, int i, int i2) {
            super(aVar, str, strArr);
            this.f23609e = i;
            this.f23610f = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.greenrobot.greendao.d.b
        public h<T2> a() {
            return new h<>(this, this.f23598b, this.f23597a, (String[]) this.f23599c.clone(), this.f23609e, this.f23610f);
        }
    }

    public static <T2> h<T2> a(org.greenrobot.greendao.a<T2, ?> aVar, String str, Object[] objArr) {
        return a(aVar, str, objArr, -1, -1);
    }

    public h<T> b() {
        return (h) this.h.a(this);
    }

    public List<T> c() {
        a();
        return this.f23593b.a(this.f23592a.getDatabase().a(this.f23594c, this.f23595d));
    }

    public T d() {
        a();
        return this.f23593b.b(this.f23592a.getDatabase().a(this.f23594c, this.f23595d));
    }

    private h(a<T> aVar, org.greenrobot.greendao.a<T, ?> aVar2, String str, String[] strArr, int i, int i2) {
        super(aVar2, str, strArr, i, i2);
        this.h = aVar;
    }

    static <T2> h<T2> a(org.greenrobot.greendao.a<T2, ?> aVar, String str, Object[] objArr, int i, int i2) {
        return new a(aVar, str, org.greenrobot.greendao.d.a.a(objArr), i, i2).b();
    }
}
