package com.bumptech.glide.load.a;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LazyHeaders.java */
/* JADX INFO: loaded from: classes.dex */
public final class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, List<o>> f4277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Map<String, String> f4278b;

    /* JADX INFO: compiled from: LazyHeaders.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f4279a = b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<String, List<o>> f4280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4281c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, List<o>> f4282d = f4280b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4283e = true;

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(f4279a)) {
                map.put(AbstractSpiCall.HEADER_USER_AGENT, Collections.singletonList(new b(f4279a)));
            }
            f4280b = Collections.unmodifiableMap(map);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public p a() {
            this.f4281c = true;
            return new p(this.f4282d);
        }
    }

    /* JADX INFO: compiled from: LazyHeaders.java */
    static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4284a;

        b(String str) {
            this.f4284a = str;
        }

        @Override // com.bumptech.glide.load.a.o
        public String a() {
            return this.f4284a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4284a.equals(((b) obj).f4284a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4284a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f4284a + "'}";
        }
    }

    p(Map<String, List<o>> map) {
        this.f4277a = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<o>> entry : this.f4277a.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    @Override // com.bumptech.glide.load.a.n
    public Map<String, String> a() {
        if (this.f4278b == null) {
            synchronized (this) {
                if (this.f4278b == null) {
                    this.f4278b = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f4278b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f4277a.equals(((p) obj).f4277a);
        }
        return false;
    }

    public int hashCode() {
        return this.f4277a.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4277a + '}';
    }

    private String a(List<o> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = list.get(i).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
