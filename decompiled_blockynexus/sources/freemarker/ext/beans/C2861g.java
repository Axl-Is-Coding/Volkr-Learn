package freemarker.ext.beans;

import freemarker.core.ac;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: freemarker.ext.beans.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansModelCache.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2861g extends freemarker.ext.util.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f21593e = ac.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f21594f = ac.a(this.f21593e);
    private final Set g = new HashSet();
    private final C2867m h;

    C2861g(C2867m c2867m) {
        this.h = c2867m;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    @Override // freemarker.ext.util.d
    protected boolean c(Object obj) throws Throwable {
        Class<?> cls = obj.getClass();
        Class<?> clsA = f21592d;
        if (clsA == null) {
            clsA = a("java.lang.Boolean");
            f21592d = clsA;
        }
        return cls != clsA;
    }

    @Override // freemarker.ext.util.d
    protected freemarker.template.E a(Object obj) {
        Class<?> cls = obj.getClass();
        freemarker.ext.util.e eVarA = this.f21594f ? (freemarker.ext.util.e) this.f21593e.get(cls) : null;
        if (eVarA == null) {
            synchronized (this.f21593e) {
                eVarA = (freemarker.ext.util.e) this.f21593e.get(cls);
                if (eVarA == null) {
                    String name = cls.getName();
                    if (!this.g.add(name)) {
                        this.f21593e.clear();
                        this.g.clear();
                        this.g.add(name);
                    }
                    eVarA = this.h.a((Class) cls);
                    this.f21593e.put(cls, eVarA);
                }
            }
        }
        return eVarA.a(obj, this.h);
    }
}
