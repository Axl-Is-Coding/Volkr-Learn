package kotlin;

/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22829f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22825b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f22824a = new d(1, 3, 41);

    /* JADX INFO: compiled from: KotlinVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public d(int i, int i2, int i3) {
        this.f22827d = i;
        this.f22828e = i2;
        this.f22829f = i3;
        this.f22826c = a(this.f22827d, this.f22828e, this.f22829f);
    }

    private final int a(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            obj = null;
        }
        d dVar = (d) obj;
        return dVar != null && this.f22826c == dVar.f22826c;
    }

    public int hashCode() {
        return this.f22826c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22827d);
        sb.append('.');
        sb.append(this.f22828e);
        sb.append('.');
        sb.append(this.f22829f);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        kotlin.jvm.internal.i.b(dVar, "other");
        return this.f22826c - dVar.f22826c;
    }
}
