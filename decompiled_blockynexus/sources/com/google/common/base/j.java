package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: compiled from: MoreObjects.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: compiled from: MoreObjects.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private C0131a f13751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0131a f13752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13753d;

        /* JADX INFO: renamed from: com.google.common.base.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MoreObjects.java */
        private static final class C0131a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f13754a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f13755b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            C0131a f13756c;

            private C0131a() {
            }
        }

        private a b(Object obj) {
            a().f13755b = obj;
            return this;
        }

        public a a(String str, Object obj) {
            b(str, obj);
            return this;
        }

        public String toString() {
            boolean z = this.f13753d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f13750a);
            sb.append('{');
            String str = "";
            for (C0131a c0131a = this.f13751b.f13756c; c0131a != null; c0131a = c0131a.f13756c) {
                Object obj = c0131a.f13755b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = c0131a.f13754a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append(strDeepToString.substring(1, strDeepToString.length() - 1));
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private a(String str) {
            this.f13751b = new C0131a();
            this.f13752c = this.f13751b;
            this.f13753d = false;
            m.a(str);
            this.f13750a = str;
        }

        public a a(String str, boolean z) {
            b(str, String.valueOf(z));
            return this;
        }

        private a b(String str, Object obj) {
            C0131a c0131aA = a();
            c0131aA.f13755b = obj;
            m.a(str);
            c0131aA.f13754a = str;
            return this;
        }

        public a a(String str, int i) {
            b(str, String.valueOf(i));
            return this;
        }

        public a a(Object obj) {
            b(obj);
            return this;
        }

        private C0131a a() {
            C0131a c0131a = new C0131a();
            this.f13752c.f13756c = c0131a;
            this.f13752c = c0131a;
            return c0131a;
        }
    }

    public static <T> T a(T t, T t2) {
        if (t != null) {
            return t;
        }
        m.a(t2);
        return t2;
    }

    public static a a(Object obj) {
        return new a(obj.getClass().getSimpleName());
    }
}
