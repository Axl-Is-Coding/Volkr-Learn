package freemarker.ext.dom;

import freemarker.core.Environment;
import freemarker.template.K;
import org.w3c.dom.Attr;

/* JADX INFO: compiled from: AttributeNodeModel.java */
/* JADX INFO: loaded from: classes5.dex */
class a extends m implements K {
    public a(Attr attr) {
        super(attr);
    }

    @Override // freemarker.ext.dom.m
    String c() {
        String namespaceURI = this.i.getNamespaceURI();
        if (namespaceURI == null || namespaceURI.equals("")) {
            return this.i.getNodeName();
        }
        Environment environmentD = Environment.d();
        String strC = namespaceURI.equals(environmentD.e()) ? "D" : environmentD.c(namespaceURI);
        if (strC == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strC);
        stringBuffer.append(":");
        stringBuffer.append(this.i.getLocalName());
        return stringBuffer.toString();
    }

    @Override // freemarker.template.K
    public String getAsString() {
        return ((Attr) this.i).getValue();
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        String localName = this.i.getLocalName();
        return (localName == null || localName.equals("")) ? this.i.getNodeName() : localName;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return true;
    }
}
