package freemarker.ext.util;

import freemarker.template.E;
import freemarker.template.F;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f21702a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f21703b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReferenceQueue f21704c = null;

    /* JADX INFO: compiled from: ModelCache.java */
    private static final class a extends SoftReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f21705a;

        a(E e2, Object obj, ReferenceQueue referenceQueue) {
            super(e2, referenceQueue);
            this.f21705a = obj;
        }

        E a() {
            return (E) get();
        }
    }

    protected d() {
    }

    private final E d(Object obj) {
        a aVar;
        synchronized (this.f21703b) {
            aVar = (a) this.f21703b.get(obj);
        }
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    protected abstract E a(Object obj);

    public synchronized void a(boolean z) {
        this.f21702a = z;
        if (z) {
            this.f21703b = new IdentityHashMap();
            this.f21704c = new ReferenceQueue();
        } else {
            this.f21703b = null;
            this.f21704c = null;
        }
    }

    public E b(Object obj) {
        if (obj instanceof E) {
            return (E) obj;
        }
        if (obj instanceof F) {
            return ((F) obj).a();
        }
        if (!this.f21702a || !c(obj)) {
            return a(obj);
        }
        E eD = d(obj);
        if (eD != null) {
            return eD;
        }
        E eA = a(obj);
        a(eA, obj);
        return eA;
    }

    protected abstract boolean c(Object obj);

    public void a() {
        Map map = this.f21703b;
        if (map != null) {
            synchronized (map) {
                this.f21703b.clear();
            }
        }
    }

    private final void a(E e2, Object obj) {
        synchronized (this.f21703b) {
            while (true) {
                a aVar = (a) this.f21704c.poll();
                if (aVar == null) {
                    this.f21703b.put(obj, new a(e2, obj, this.f21704c));
                } else {
                    this.f21703b.remove(aVar.f21705a);
                }
            }
        }
    }
}
