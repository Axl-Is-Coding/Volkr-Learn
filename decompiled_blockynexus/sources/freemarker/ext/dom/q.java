package freemarker.ext.dom;

import com.sun.org.apache.xml.internal.utils.PrefixResolver;
import com.sun.org.apache.xpath.internal.XPath;
import com.sun.org.apache.xpath.internal.XPathContext;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import com.sun.org.apache.xpath.internal.objects.XNull;
import com.sun.org.apache.xpath.internal.objects.XNumber;
import com.sun.org.apache.xpath.internal.objects.XString;
import freemarker.template.E;
import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import java.util.List;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

/* JADX INFO: compiled from: SunInternalXalanXPathSupport.java */
/* JADX INFO: loaded from: classes5.dex */
class q implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PrefixResolver f21685a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private XPathContext f21686b = new XPathContext();

    q() {
    }

    @Override // freemarker.ext.dom.r
    public synchronized E a(Object obj, String str) throws TemplateModelException {
        Node nodeNextNode;
        if (!(obj instanceof Node)) {
            if (obj == null) {
                throw new TemplateModelException("Cannot perform an XPath query against an empty node set.(Note that there is no such restriction if you configure FreeMarker to use Jaxen instead of Xalan.)");
            }
            if (!a(obj)) {
                throw new TemplateModelException("Cannot perform an XPath query against a " + obj.getClass().getName() + ". Expecting a single org.w3c.dom.Node.");
            }
            int size = ((List) obj).size();
            if (size == 0) {
                throw new TemplateModelException("Cannot perform an XPath query against an empty node set.(Note that there is no such restriction if you configure FreeMarker to use Jaxen instead of Xalan.)");
            }
            throw new TemplateModelException("Cannot perform an XPath query against a node set of " + size + " nodes. Expecting a single node.(Note that there is no such restriction if you configure FreeMarker to use Jaxen instead of Xalan.)");
        }
        Node node = (Node) obj;
        try {
            XBoolean xBooleanExecute = new XPath(str, (SourceLocator) null, f21685a, 0, (ErrorListener) null).execute(this.f21686b, this.f21686b.getDTMHandleFromNode(node), f21685a);
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
            throw new TemplateModelException("Cannot deal with type: " + xBooleanExecute.getClass().getName());
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
