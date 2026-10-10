package freemarker.ext.dom;

import freemarker.template.E;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import java.util.List;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xpath.XPath;
import org.apache.xpath.XPathContext;
import org.apache.xpath.objects.XBoolean;
import org.apache.xpath.objects.XNodeSet;
import org.apache.xpath.objects.XNull;
import org.apache.xpath.objects.XNumber;
import org.apache.xpath.objects.XString;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

/* JADX INFO: compiled from: XalanXPathSupport.java */
/* JADX INFO: loaded from: classes5.dex */
class t implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PrefixResolver f21687a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private XPathContext f21688b = new XPathContext();

    t() {
    }

    @Override // freemarker.ext.dom.r
    public synchronized E a(Object obj, String str) throws TemplateModelException {
        Node nodeNextNode;
        if (!(obj instanceof Node)) {
            if (obj == null) {
                throw new TemplateModelException("Cannot perform an XPath query against an empty node set.");
            }
            if (!a(obj)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Cannot perform an XPath query against a ");
                stringBuffer.append(obj.getClass().getName());
                stringBuffer.append(". Expecting a single org.w3c.dom.Node.");
                throw new TemplateModelException(stringBuffer.toString());
            }
            int size = ((List) obj).size();
            if (size == 0) {
                throw new TemplateModelException("Cannot perform an XPath query against an empty node set.");
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Cannot perform an XPath query against a node set of ");
            stringBuffer2.append(size);
            stringBuffer2.append(" nodes. Expecting a single node.");
            throw new TemplateModelException(stringBuffer2.toString());
        }
        Node node = (Node) obj;
        try {
            XBoolean xBooleanExecute = new XPath(str, (SourceLocator) null, f21687a, 0, (ErrorListener) null).execute(this.f21688b, this.f21688b.getDTMHandleFromNode(node), f21687a);
            if (xBooleanExecute instanceof XNodeSet) {
                NodeListModel nodeListModel = new NodeListModel(node);
                nodeListModel.xpathSupport = this;
                NodeIterator nodeIteratorNodeset = xBooleanExecute.nodeset();
                do {
                    nodeNextNode = nodeIteratorNodeset.nextNode();
                    if (nodeNextNode != null) {
                        nodeListModel.add(nodeNextNode);
                    }
                } while (nodeNextNode != null);
                int size2 = nodeListModel.size();
                NodeListModel nodeListModel2 = nodeListModel;
                if (size2 == 1) {
                    nodeListModel2 = nodeListModel.get(0);
                }
                return nodeListModel2;
            }
            if (xBooleanExecute instanceof XBoolean) {
                return xBooleanExecute.bool() ? freemarker.template.r.f21735d : freemarker.template.r.f21734c;
            }
            if (xBooleanExecute instanceof XNull) {
                return null;
            }
            if (xBooleanExecute instanceof XString) {
                return new SimpleScalar(xBooleanExecute.toString());
            }
            if (xBooleanExecute instanceof XNumber) {
                return new SimpleNumber(new Double(((XNumber) xBooleanExecute).num()));
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Cannot deal with type: ");
            stringBuffer3.append(xBooleanExecute.getClass().getName());
            throw new TemplateModelException(stringBuffer3.toString());
        } catch (TransformerException e2) {
            throw new TemplateModelException((Exception) e2);
        }
    }

    private static boolean a(Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(list.get(i) instanceof Node)) {
                return false;
            }
        }
        return true;
    }
}
