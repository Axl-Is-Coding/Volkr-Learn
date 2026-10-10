package d.a.a;

import freemarker.template.A;
import freemarker.template.D;
import freemarker.template.E;
import freemarker.template.InterfaceC2880a;
import freemarker.template.K;
import freemarker.template.TemplateModelException;
import freemarker.template.r;
import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;

/* JADX INFO: compiled from: JythonModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements freemarker.ext.util.f, A, D, K, InterfaceC2880a, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final freemarker.ext.util.e f21417a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final PyObject f21419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final m f21420d;

    public d(PyObject pyObject, m mVar) {
        this.f21419c = pyObject;
        this.f21420d = mVar;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    @Override // freemarker.template.A
    public E get(String str) throws TemplateModelException {
        PyObject pyObject__finditem__;
        if (str != null) {
            str = str.intern();
        }
        try {
            if (this.f21420d.a()) {
                pyObject__finditem__ = this.f21419c.__findattr__(str);
                if (pyObject__finditem__ == null) {
                    pyObject__finditem__ = this.f21419c.__finditem__(str);
                }
            } else {
                pyObject__finditem__ = this.f21419c.__finditem__(str);
                if (pyObject__finditem__ == null) {
                    pyObject__finditem__ = this.f21419c.__findattr__(str);
                }
            }
            return this.f21420d.a(pyObject__finditem__);
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) throws Throwable {
        PyObject pyObject = this.f21419c;
        if (pyObject == null) {
            return null;
        }
        Object obj__tojava__ = pyObject.__tojava__(cls);
        if (obj__tojava__ != Py.NoConversion) {
            return obj__tojava__;
        }
        PyObject pyObject2 = this.f21419c;
        Class clsA = f21418b;
        if (clsA == null) {
            clsA = a("java.lang.Object");
            f21418b = clsA;
        }
        return pyObject2.__tojava__(clsA);
    }

    @Override // freemarker.template.r
    public boolean getAsBoolean() throws TemplateModelException {
        try {
            return this.f21419c.__nonzero__();
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    @Override // freemarker.template.K
    public String getAsString() throws TemplateModelException {
        try {
            return this.f21419c.toString();
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() throws Throwable {
        PyObject pyObject = this.f21419c;
        if (pyObject == null) {
            return null;
        }
        Class clsA = f21418b;
        if (clsA == null) {
            clsA = a("java.lang.Object");
            f21418b = clsA;
        }
        return pyObject.__tojava__(clsA);
    }

    @Override // freemarker.template.A
    public boolean isEmpty() throws TemplateModelException {
        try {
            return this.f21419c.__len__() == 0;
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }
}
