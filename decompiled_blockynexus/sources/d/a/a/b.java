package d.a.a;

import freemarker.template.B;
import freemarker.template.TemplateModelException;
import freemarker.template.s;
import org.python.core.PyException;
import org.python.core.PyObject;

/* JADX INFO: compiled from: JythonHashModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends d implements B {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final freemarker.ext.util.e f21416e = new a();

    public b(PyObject pyObject, m mVar) {
        super(pyObject, mVar);
    }

    @Override // freemarker.template.B
    public s keys() throws TemplateModelException {
        try {
            PyObject pyObject__findattr__ = this.f21419c.__findattr__("keys");
            if (pyObject__findattr__ == null) {
                pyObject__findattr__ = this.f21419c.__findattr__("keySet");
            }
            if (pyObject__findattr__ != null) {
                return (s) this.f21420d.a(pyObject__findattr__.__call__());
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("'?keys' is not supported as there is no 'keys' nor 'keySet' attribute on an instance of ");
            stringBuffer.append(l.f21427a.a(this.f21419c));
            throw new TemplateModelException(stringBuffer.toString());
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    @Override // freemarker.template.B
    public int size() throws TemplateModelException {
        try {
            return this.f21419c.__len__();
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }
}
