package freemarker.ext.beans;

import freemarker.template.TemplateModelException;

/* JADX INFO: compiled from: StaticModels.java */
/* JADX INFO: loaded from: classes5.dex */
class pa extends AbstractC2872s {
    pa(C2867m c2867m) {
        super(c2867m);
    }

    @Override // freemarker.ext.beans.AbstractC2872s
    protected freemarker.template.E a(Class cls) throws TemplateModelException {
        return new oa(cls, b());
    }
}
