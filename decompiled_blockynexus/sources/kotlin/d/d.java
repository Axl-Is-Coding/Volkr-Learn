package kotlin.d;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends b implements kotlin.d.a<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22839f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d f22838e = new d(1, 0);

    /* JADX INFO: compiled from: Ranges.kt */
    public static final class a {
        private a() {
        }

        public final d a() {
            return d.f22838e;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public d(int i, int i2) {
        super(i, i2, 1);
    }

    public Integer e() {
        return Integer.valueOf(getLast());
    }

    @Override // kotlin.d.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (getFirst() != dVar.getFirst() || getLast() != dVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(getFirst());
    }

    @Override // kotlin.d.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.d.b
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.d.b
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
