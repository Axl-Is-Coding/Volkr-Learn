package freemarker.ext.dom;

import freemarker.template.E;
import freemarker.template.TemplateModelException;
import org.w3c.dom.DocumentType;

/* JADX INFO: compiled from: DocumentTypeModel.java */
/* JADX INFO: loaded from: classes5.dex */
class d extends m {
    public d(DocumentType documentType) {
        super(documentType);
    }

    @Override // freemarker.ext.dom.m, freemarker.template.A
    public E get(String str) throws TemplateModelException {
        throw new TemplateModelException("accessing properties of a DTD is not currently supported");
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@document_type$");
        stringBuffer.append(((DocumentType) this.i).getNodeName());
        return stringBuffer.toString();
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return true;
    }
}
