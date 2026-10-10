package freemarker.ext.beans;

import freemarker.core.ac;
import freemarker.template.TemplateModelException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: freemarker.ext.beans.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClassBasedModelFactory.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractC2872s implements freemarker.template.A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2867m f21629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f21630b = ac.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21631c = ac.a(this.f21630b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f21632d = new HashSet();

    protected AbstractC2872s(C2867m c2867m) {
        this.f21629a = c2867m;
    }

    private freemarker.template.E a(String str) throws TemplateModelException, ClassNotFoundException {
        freemarker.template.E e2;
        if (this.f21631c && (e2 = (freemarker.template.E) this.f21630b.get(str)) != null) {
            return e2;
        }
        Object objH = this.f21629a.h();
        synchronized (objH) {
            freemarker.template.E e3 = (freemarker.template.E) this.f21630b.get(str);
            if (e3 != null) {
                return e3;
            }
            while (e3 == null && this.f21632d.contains(str)) {
                try {
                    objH.wait();
                    e3 = (freemarker.template.E) this.f21630b.get(str);
                } catch (InterruptedException e4) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Class inrospection data lookup aborded: ");
                    stringBuffer.append(e4);
                    throw new RuntimeException(stringBuffer.toString());
                }
            }
            if (e3 != null) {
                return e3;
            }
            this.f21632d.add(str);
            C2874u c2874uB = this.f21629a.b();
            int iA = c2874uB.a();
            try {
                Class clsB = freemarker.template.utility.a.b(str);
                c2874uB.a(clsB);
                freemarker.template.E eA = a(clsB);
                if (eA != null) {
                    synchronized (objH) {
                        if (c2874uB == this.f21629a.b() && iA == c2874uB.a()) {
                            this.f21630b.put(str, eA);
                        }
                    }
                }
                synchronized (objH) {
                    this.f21632d.remove(str);
                    objH.notifyAll();
                }
                return eA;
            } catch (Throwable th) {
                synchronized (objH) {
                    this.f21632d.remove(str);
                    objH.notifyAll();
                    throw th;
                }
            }
        }
    }

    protected abstract freemarker.template.E a(Class cls) throws TemplateModelException;

    void b(Class cls) {
        synchronized (this.f21629a.h()) {
            this.f21630b.remove(cls.getName());
        }
    }

    @Override // freemarker.template.A
    public freemarker.template.E get(String str) throws TemplateModelException {
        try {
            return a(str);
        } catch (Exception e2) {
            if (e2 instanceof TemplateModelException) {
                throw ((TemplateModelException) e2);
            }
            throw new TemplateModelException(e2);
        }
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return false;
    }

    protected C2867m b() {
        return this.f21629a;
    }

    void a() {
        synchronized (this.f21629a.h()) {
            this.f21630b.clear();
        }
    }
}
