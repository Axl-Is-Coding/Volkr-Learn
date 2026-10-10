package d.a.a;

import freemarker.template.E;
import freemarker.template.G;
import freemarker.template.L;
import freemarker.template.TemplateModelException;
import freemarker.template.s;
import org.python.core.PyException;
import org.python.core.PyObject;

/* JADX INFO: compiled from: JythonSequenceModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class j extends d implements L, s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final freemarker.ext.util.e f21426e = new h();

    public j(PyObject pyObject, m mVar) {
        super(pyObject, mVar);
    }

    @Override // freemarker.template.L
    public E get(int i) throws TemplateModelException {
        try {
            return this.f21420d.a(this.f21419c.__finditem__(i));
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    @Override // freemarker.template.s
    public G iterator() {
        return new i(this);
    }

    @Override // freemarker.template.L
    public int size() throws TemplateModelException {
        try {
            return this.f21419c.__len__();
        } catch (PyException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }
}
