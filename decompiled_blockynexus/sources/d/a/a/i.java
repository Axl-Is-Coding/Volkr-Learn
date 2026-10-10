package d.a.a;

import freemarker.template.E;
import freemarker.template.G;
import freemarker.template.TemplateModelException;

/* JADX INFO: compiled from: JythonSequenceModel.java */
/* JADX INFO: loaded from: classes5.dex */
class i implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21424a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ j f21425b;

    i(j jVar) {
        this.f21425b = jVar;
    }

    @Override // freemarker.template.G
    public boolean hasNext() throws TemplateModelException {
        return this.f21424a < this.f21425b.size();
    }

    @Override // freemarker.template.G
    public E next() throws TemplateModelException {
        j jVar = this.f21425b;
        int i = this.f21424a;
        this.f21424a = i + 1;
        return jVar.get(i);
    }
}
