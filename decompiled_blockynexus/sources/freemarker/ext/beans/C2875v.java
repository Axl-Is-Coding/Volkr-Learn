package freemarker.ext.beans;

import freemarker.template.Version;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: freemarker.ext.beans.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClassIntrospectorBuilder.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2875v implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f21651a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReferenceQueue f21652b = new ReferenceQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21654d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f21655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Q f21656f;
    private S g;

    C2875v(Version version) {
        this.f21653c = C2867m.a(version);
    }

    private static void g() {
        while (true) {
            Reference referencePoll = f21652b.poll();
            if (referencePoll == null) {
                return;
            }
            synchronized (f21651a) {
                Iterator it = f21651a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next() == referencePoll) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public void a(Q q) {
        this.f21656f = q;
    }

    public boolean b() {
        return this.f21655e;
    }

    C2874u build() {
        C2874u c2874u;
        if (this.f21656f != null || this.g != null) {
            return new C2874u(this, new Object(), true, false);
        }
        synchronized (f21651a) {
            Reference reference = (Reference) f21651a.get(this);
            c2874u = reference != null ? (C2874u) reference.get() : null;
            if (c2874u == null) {
                C2875v c2875v = (C2875v) clone();
                C2874u c2874u2 = new C2874u(c2875v, new Object(), true, true);
                f21651a.put(c2875v, new WeakReference(c2874u2, f21652b));
                c2874u = c2874u2;
            }
        }
        g();
        return c2874u;
    }

    public int c() {
        return this.f21654d;
    }

    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("Failed to clone ClassIntrospectorBuilder", e2);
        }
    }

    public Q d() {
        return this.f21656f;
    }

    public S e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2875v.class != obj.getClass()) {
            return false;
        }
        C2875v c2875v = (C2875v) obj;
        return this.f21653c == c2875v.f21653c && this.f21655e == c2875v.f21655e && this.f21654d == c2875v.f21654d && this.f21656f == c2875v.f21656f && this.g == c2875v.g;
    }

    public boolean f() {
        return this.f21653c;
    }

    public int hashCode() {
        return (((((((((this.f21653c ? 1231 : 1237) + 31) * 31) + (this.f21655e ? 1231 : 1237)) * 31) + this.f21654d) * 31) + System.identityHashCode(this.f21656f)) * 31) + System.identityHashCode(this.g);
    }
}
