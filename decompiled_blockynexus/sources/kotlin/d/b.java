package kotlin.d;

import java.util.Iterator;

/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b implements Iterable<Integer>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22830a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22833d;

    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        private a() {
        }

        public final b a(int i, int i2, int i3) {
            return new b(i, i2, i3);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f22831b = i;
        this.f22832c = kotlin.c.c.a(i, i2, i3);
        this.f22833d = i3;
    }

    public final int a() {
        return this.f22833d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f22831b != bVar.f22831b || this.f22832c != bVar.f22832c || this.f22833d != bVar.f22833d) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f22831b;
    }

    public final int getLast() {
        return this.f22832c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f22831b * 31) + this.f22832c) * 31) + this.f22833d;
    }

    public boolean isEmpty() {
        if (this.f22833d > 0) {
            if (this.f22831b > this.f22832c) {
                return true;
            }
        } else if (this.f22831b < this.f22832c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f22833d > 0) {
            sb = new StringBuilder();
            sb.append(this.f22831b);
            sb.append("..");
            sb.append(this.f22832c);
            sb.append(" step ");
            i = this.f22833d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f22831b);
            sb.append(" downTo ");
            sb.append(this.f22832c);
            sb.append(" step ");
            i = -this.f22833d;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new c(this.f22831b, this.f22832c, this.f22833d);
    }
}
