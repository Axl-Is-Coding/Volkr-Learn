package d.a.a;

import freemarker.template.E;
import freemarker.template.InterfaceC2891l;

/* JADX INFO: compiled from: JythonWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
public class m implements InterfaceC2891l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class f21430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f21431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final freemarker.ext.util.d f21433d = new e(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f21434e = true;

    static {
        Class clsA = f21432c;
        if (clsA == null) {
            clsA = a("org.python.core.PyObject");
            f21432c = clsA;
        }
        f21430a = clsA;
        f21431b = new m();
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    boolean a() {
        return this.f21434e;
    }

    @Override // freemarker.template.InterfaceC2891l
    public E a(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.f21433d.b(obj);
    }
}
