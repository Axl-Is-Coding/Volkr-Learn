package c.t.m.g;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3114f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: TL */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3115a = 3;

        static {
            int[] iArr = {1, 2, 3, 4, 5};
        }
    }

    public cp(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f3109a = i;
        this.f3110b = i2;
        this.f3111c = i3;
        this.f3112d = i4;
        this.f3113e = i5;
        this.f3114f = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && cp.class == obj.getClass()) {
            cp cpVar = (cp) obj;
            if (this.f3109a == cpVar.f3109a && this.f3110b == cpVar.f3110b && this.f3111c == cpVar.f3111c && this.f3112d == cpVar.f3112d) {
                return true;
            }
        }
        return false;
    }
}
