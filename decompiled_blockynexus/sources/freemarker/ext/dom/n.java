package freemarker.ext.dom;

import freemarker.core.Environment;
import java.util.HashMap;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: NodeOutputter.java */
/* JADX INFO: loaded from: classes5.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Element f21679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Environment f21680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f21681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f21683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap f21684f = new HashMap();
    private String g;

    n(Node node) {
        if (node instanceof Element) {
            c((Element) node);
        } else if (node instanceof Attr) {
            c(((Attr) node).getOwnerElement());
        } else if (node instanceof Document) {
            c(((Document) node).getDocumentElement());
        }
    }

    private void a(Node node) {
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null && namespaceURI.length() > 0) {
            this.f21684f.put(namespaceURI, this.f21680b.c(namespaceURI));
        } else if (this.f21682d && node.getNodeType() == 1) {
            this.f21684f.put(this.f21681c, "D");
            this.f21683e = true;
        } else if (node.getNodeType() == 2 && this.f21682d && this.f21681c.equals(namespaceURI)) {
            this.f21684f.put(this.f21681c, "D");
            this.f21683e = true;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            a(childNodes.item(i));
        }
    }

    private void b(Node node, StringBuffer stringBuffer) {
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null || namespaceURI.length() == 0) {
            stringBuffer.append(node.getNodeName());
            return;
        }
        String str = (String) this.f21684f.get(namespaceURI);
        if (str == null) {
            stringBuffer.append(node.getNodeName());
            return;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
            stringBuffer.append(':');
        }
        stringBuffer.append(node.getLocalName());
    }

    private void c(Element element) {
        this.f21679a = element;
        this.f21680b = Environment.d();
        this.f21681c = this.f21680b.e();
        String str = this.f21681c;
        this.f21682d = str != null && str.length() > 0;
        this.f21684f.put(null, "");
        this.f21684f.put("", "");
        a((Node) element);
        if (!this.f21683e && this.f21682d) {
            this.f21684f.put(this.f21681c, "");
        }
        a();
    }

    String b(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('<');
        b(element, stringBuffer);
        stringBuffer.append(this.g);
        a(element.getAttributes(), stringBuffer);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    private void a() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f21683e) {
            stringBuffer.append(" xmlns=\"");
            stringBuffer.append(this.f21681c);
            stringBuffer.append("\"");
        }
        for (String str : this.f21684f.keySet()) {
            if (str != null && str.length() != 0) {
                String str2 = (String) this.f21684f.get(str);
                if (str2 == null) {
                    String str3 = str2;
                    int i = 0;
                    while (true) {
                        if (i >= 26) {
                            str2 = str3;
                            break;
                        }
                        String str4 = new String(new char[]{(char) (i + 97)});
                        if (this.f21680b.b(str4) == null) {
                            str2 = str4;
                            break;
                        } else {
                            str3 = null;
                            i++;
                        }
                    }
                    if (str2 != null) {
                        this.f21684f.put(str, str2);
                    } else {
                        throw new RuntimeException("This will almost never happen!");
                    }
                }
                stringBuffer.append(" xmlns");
                if (str2.length() > 0) {
                    stringBuffer.append(":");
                    stringBuffer.append(str2);
                }
                stringBuffer.append("=\"");
                stringBuffer.append(str);
                stringBuffer.append("\"");
            }
        }
        this.g = stringBuffer.toString();
    }

    void a(Node node, StringBuffer stringBuffer) {
        switch (node.getNodeType()) {
            case 1:
                stringBuffer.append('<');
                b(node, stringBuffer);
                if (node == this.f21679a) {
                    stringBuffer.append(this.g);
                }
                a(node.getAttributes(), stringBuffer);
                if (node.getChildNodes().getLength() == 0) {
                    stringBuffer.append(" />");
                } else {
                    stringBuffer.append('>');
                    a(node.getChildNodes(), stringBuffer);
                    stringBuffer.append("</");
                    b(node, stringBuffer);
                    stringBuffer.append('>');
                }
                break;
            case 2:
                if (((Attr) node).getSpecified()) {
                    stringBuffer.append(' ');
                    b(node, stringBuffer);
                    stringBuffer.append("=\"");
                    stringBuffer.append(freemarker.template.utility.h.b(node.getNodeValue()));
                    stringBuffer.append('\"');
                }
                break;
            case 3:
            case 4:
                stringBuffer.append(freemarker.template.utility.h.a(node.getNodeValue()));
                break;
            case 5:
                stringBuffer.append('&');
                stringBuffer.append(node.getNodeName());
                stringBuffer.append(';');
                break;
            case 6:
                a(node.getChildNodes(), stringBuffer);
                break;
            case 7:
                stringBuffer.append("<?");
                stringBuffer.append(node.getNodeName());
                stringBuffer.append(' ');
                stringBuffer.append(node.getNodeValue());
                stringBuffer.append("?>");
                break;
            case 8:
                stringBuffer.append("<!--");
                stringBuffer.append(node.getNodeValue());
                stringBuffer.append("-->");
                break;
            case 9:
                a(node.getChildNodes(), stringBuffer);
                break;
            case 10:
                stringBuffer.append("<!DOCTYPE ");
                stringBuffer.append(node.getNodeName());
                DocumentType documentType = (DocumentType) node;
                if (documentType.getPublicId() != null) {
                    stringBuffer.append(" PUBLIC \"");
                    stringBuffer.append(documentType.getPublicId());
                    stringBuffer.append('\"');
                }
                if (documentType.getSystemId() != null) {
                    stringBuffer.append(" \"");
                    stringBuffer.append(documentType.getSystemId());
                    stringBuffer.append('\"');
                }
                if (documentType.getInternalSubset() != null) {
                    stringBuffer.append(" [");
                    stringBuffer.append(documentType.getInternalSubset());
                    stringBuffer.append(']');
                }
                stringBuffer.append('>');
                break;
        }
    }

    void a(NodeList nodeList, StringBuffer stringBuffer) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            a(nodeList.item(i), stringBuffer);
        }
    }

    void a(NamedNodeMap namedNodeMap, StringBuffer stringBuffer) {
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node nodeItem = namedNodeMap.item(i);
            if (nodeItem.getNodeType() != 2 || (!nodeItem.getNodeName().startsWith("xmlns:") && !nodeItem.getNodeName().equals("xmlns"))) {
                a(nodeItem, stringBuffer);
            }
        }
    }

    String a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("</");
        b(element, stringBuffer);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }
}
