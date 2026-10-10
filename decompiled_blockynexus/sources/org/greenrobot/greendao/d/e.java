package org.greenrobot.greendao.d;

/* JADX INFO: compiled from: DeleteQuery.java */
/* JADX INFO: loaded from: classes5.dex */
public class e<T> extends org.greenrobot.greendao.d.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a<T> f23602f;

    /* JADX INFO: compiled from: DeleteQuery.java */
    private static final class a<T2> extends b<T2, e<T2>> {
        private a(org.greenrobot.greendao.a<T2, ?> aVar, String str, String[] strArr) {
            super(aVar, str, strArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.greenrobot.greendao.d.b
        public e<T2> a() {
            return new e<>(this, this.f23598b, this.f23597a, (String[]) this.f23599c.clone());
        }
    }

    static <T2> e<T2> a(org.greenrobot.greendao.a<T2, ?> aVar, String str, Object[] objArr) {
        return new a(aVar, str, org.greenrobot.greendao.d.a.a(objArr)).b();
    }

    public void b() {
        a();
        org.greenrobot.greendao.b.a database = this.f23592a.getDatabase();
        if (database.b()) {
            this.f23592a.getDatabase().a(this.f23594c, (Object[]) this.f23595d);
            return;
        }
        database.D();
        try {
            this.f23592a.getDatabase().a(this.f23594c, (Object[]) this.f23595d);
            database.E();
        } finally {
            database.F();
        }
    }

    private e(a<T> aVar, org.greenrobot.greendao.a<T, ?> aVar2, String str, String[] strArr) {
        super(aVar2, str, strArr);
        this.f23602f = aVar;
    }
}
