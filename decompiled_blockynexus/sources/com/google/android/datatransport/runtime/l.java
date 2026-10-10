package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: EventInternal.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: compiled from: EventInternal.java */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(k kVar);

        public abstract a a(Integer num);

        public abstract a a(String str);

        public final a a(String str, String str2) {
            b().put(str, str2);
            return this;
        }

        protected abstract a a(Map<String, String> map);

        public abstract l a();

        public abstract a b(long j);

        protected abstract Map<String, String> b();

        public final a a(String str, long j) {
            b().put(str, String.valueOf(j));
            return this;
        }

        public final a a(String str, int i) {
            b().put(str, String.valueOf(i));
            return this;
        }
    }

    public final String a(String str) {
        String str2 = b().get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = b().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    protected abstract Map<String, String> b();

    public final long c(String str) {
        String str2 = b().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public abstract Integer c();

    public abstract k d();

    public abstract long e();

    public final Map<String, String> f() {
        return Collections.unmodifiableMap(b());
    }

    public abstract String g();

    public abstract long h();

    public a i() {
        b.a aVar = new b.a();
        aVar.a(g());
        aVar.a(c());
        aVar.a(d());
        aVar.a(e());
        aVar.b(h());
        aVar.a(new HashMap(b()));
        return aVar;
    }

    public static a a() {
        b.a aVar = new b.a();
        aVar.a(new HashMap());
        return aVar;
    }
}
