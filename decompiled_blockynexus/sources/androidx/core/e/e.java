package androidx.core.e;

import java.util.Locale;

/* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.core.e.d f1138a = new C0012e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final androidx.core.e.d f1139b = new C0012e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.core.e.d f1140c = new C0012e(b.f1146a, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final androidx.core.e.d f1141d = new C0012e(b.f1146a, true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.core.e.d f1142e = new C0012e(a.f1144a, false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final androidx.core.e.d f1143f = f.f1149b;

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f1144a = new a(true);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1145b;

        private a(boolean z) {
            this.f1145b = z;
        }

        @Override // androidx.core.e.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int iA = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i++;
                    } else if (!this.f1145b) {
                        return 1;
                    }
                } else if (this.f1145b) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f1145b ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f1146a = new b();

        private b() {
        }

        @Override // androidx.core.e.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iB = 2;
            while (i < i3 && iB == 2) {
                iB = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iB;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static abstract class d implements androidx.core.e.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f1147a;

        d(c cVar) {
            this.f1147a = cVar;
        }

        private boolean a(CharSequence charSequence, int i, int i2) {
            int iA = this.f1147a.a(charSequence, i, i2);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        protected abstract boolean a();

        @Override // androidx.core.e.d
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f1147a == null ? a() : a(charSequence, i, i2);
        }
    }

    /* JADX INFO: renamed from: androidx.core.e.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class C0012e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f1148b;

        C0012e(c cVar, boolean z) {
            super(cVar);
            this.f1148b = z;
        }

        @Override // androidx.core.e.e.d
        protected boolean a() {
            return this.f1148b;
        }
    }

    /* JADX INFO: compiled from: TextDirectionHeuristicsCompat.java */
    private static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final f f1149b = new f();

        f() {
            super(null);
        }

        @Override // androidx.core.e.e.d
        protected boolean a() {
            return androidx.core.e.f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
