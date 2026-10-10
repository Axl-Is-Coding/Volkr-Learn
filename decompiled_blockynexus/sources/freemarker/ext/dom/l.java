package freemarker.ext.dom;

import freemarker.template.E;
import freemarker.template.InterfaceC2891l;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: NodeListModel.java */
/* JADX INFO: loaded from: classes5.dex */
final class l implements InterfaceC2891l {
    l() {
    }

    @Override // freemarker.template.InterfaceC2891l
    public E a(Object obj) {
        return obj instanceof m ? (m) obj : m.a((Node) obj);
    }
}
