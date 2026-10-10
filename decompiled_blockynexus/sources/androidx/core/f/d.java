package androidx.core.f;

/* JADX INFO: compiled from: Pair.java */
/* JADX INFO: loaded from: classes.dex */
public class d<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f1153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f1154b;

    public d(F f2, S s) {
        this.f1153a = f2;
        this.f1154b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f1153a, this.f1153a) && c.a(dVar.f1154b, this.f1154b);
    }

    public int hashCode() {
        F f2 = this.f1153a;
        int iHashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f1154b;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f1153a) + " " + String.valueOf(this.f1154b) + "}";
    }
}
