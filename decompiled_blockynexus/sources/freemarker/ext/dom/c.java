package freemarker.ext.dom;

import freemarker.core.Environment;
import freemarker.template.A;
import freemarker.template.E;
import freemarker.template.TemplateModelException;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: DocumentModel.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends m implements A {
    private e k;

    c(Document document) {
        super(document);
    }

    @Override // freemarker.ext.dom.m, freemarker.template.A
    public E get(String str) throws TemplateModelException {
        if (str.equals("*")) {
            return i();
        }
        if (str.equals("**")) {
            return new NodeListModel(((Document) this.i).getElementsByTagName("*"), this);
        }
        if (!freemarker.template.utility.h.d(str)) {
            return super.get(str);
        }
        e eVar = (e) m.a(((Document) this.i).getDocumentElement());
        return eVar.a(str, Environment.d()) ? eVar : new NodeListModel(this);
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        return "@document";
    }

    e i() {
        if (this.k == null) {
            this.k = (e) m.a(((Document) this.i).getDocumentElement());
        }
        return this.k;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return false;
    }
}
