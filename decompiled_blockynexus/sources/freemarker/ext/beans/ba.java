package freemarker.ext.beans;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateModelException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: OverloadedMethodsModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class ba implements freemarker.template.D, freemarker.template.L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f21572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final aa f21573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2867m f21574c;

    ba(Object obj, aa aaVar, C2867m c2867m) {
        this.f21572a = obj;
        this.f21573b = aaVar;
        this.f21574c = c2867m;
    }

    public Object a(List list) throws TemplateModelException {
        P pA = this.f21573b.a(list, this.f21574c);
        try {
            return pA.a(this.f21574c, this.f21572a);
        } catch (Exception e2) {
            if (e2 instanceof TemplateModelException) {
                throw ((TemplateModelException) e2);
            }
            throw xa.a(this.f21572a, pA.a(), e2);
        }
    }

    @Override // freemarker.template.L
    public freemarker.template.E get(int i) throws TemplateModelException {
        return (freemarker.template.E) a(Collections.singletonList(new SimpleNumber(new Integer(i))));
    }

    @Override // freemarker.template.L
    public int size() throws TemplateModelException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?size is unsupported for ");
        stringBuffer.append(ba.class.getName());
        throw new TemplateModelException(stringBuffer.toString());
    }
}
