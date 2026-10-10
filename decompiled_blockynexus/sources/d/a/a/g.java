package d.a.a;

import freemarker.template.J;
import freemarker.template.TemplateModelException;
import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyObject;

/* JADX INFO: compiled from: JythonNumberModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class g extends d implements J {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final freemarker.ext.util.e f21422e = new f();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21423f;

    public g(PyObject pyObject, m mVar) {
        super(pyObject, mVar);
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    @Override // freemarker.template.J
    public Number getAsNumber() throws Throwable {
        Class clsA;
        try {
            PyObject pyObject = this.f21419c;
            if (f21423f == null) {
                clsA = a("java.lang.Number");
                f21423f = clsA;
            } else {
                clsA = f21423f;
            }
            Object obj__tojava__ = pyObject.__tojava__(clsA);
            if (obj__tojava__ != null && obj__tojava__ != Py.NoConversion) {
                return (Number) obj__tojava__;
            }
            return new Double(this.f21419c.__float__().getValue());
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }
}
