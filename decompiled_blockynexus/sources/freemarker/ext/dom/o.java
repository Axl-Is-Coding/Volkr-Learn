package freemarker.ext.dom;

import freemarker.template.K;
import org.w3c.dom.ProcessingInstruction;

/* JADX INFO: compiled from: PINodeModel.java */
/* JADX INFO: loaded from: classes5.dex */
class o extends m implements K {
    public o(ProcessingInstruction processingInstruction) {
        super(processingInstruction);
    }

    @Override // freemarker.template.K
    public String getAsString() {
        return ((ProcessingInstruction) this.i).getData();
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@pi$");
        stringBuffer.append(((ProcessingInstruction) this.i).getTarget());
        return stringBuffer.toString();
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return true;
    }
}
