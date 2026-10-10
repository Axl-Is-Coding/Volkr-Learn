package freemarker.ext.dom;

import freemarker.core.Environment;
import freemarker.template.E;
import freemarker.template.K;
import freemarker.template.L;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: ElementModel.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends m implements K {
    public e(Element element) {
        super(element);
    }

    private Attr b(String str) {
        int iIndexOf;
        Element element = (Element) this.i;
        Attr attributeNode = element.getAttributeNode(str);
        if (attributeNode != null || (iIndexOf = str.indexOf(58)) <= 0) {
            return attributeNode;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strE = strSubstring.equals("D") ? Environment.d().e() : Environment.d().b(strSubstring);
        return strE != null ? element.getAttributeNodeNS(strE, str.substring(iIndexOf + 1)) : attributeNode;
    }

    boolean a(String str, Environment environment) {
        return freemarker.template.utility.h.a(str, getNodeName(), b(), environment);
    }

    @Override // freemarker.ext.dom.m
    String c() {
        String nodeName = getNodeName();
        String strB = b();
        if (strB == null || strB.length() == 0) {
            return nodeName;
        }
        Environment environmentD = Environment.d();
        String strE = environmentD.e();
        String strC = (strE == null || !strE.equals(strB)) ? environmentD.c(strB) : "D";
        if (strC == null) {
            return null;
        }
        if (strC.length() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(strC);
            stringBuffer.append(":");
            strC = stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(strC);
        stringBuffer2.append(nodeName);
        return stringBuffer2.toString();
    }

    @Override // freemarker.ext.dom.m, freemarker.template.A
    public E get(String str) throws TemplateModelException {
        if (str.equals("*")) {
            NodeListModel nodeListModel = new NodeListModel(this);
            L lA = a();
            for (int i = 0; i < lA.size(); i++) {
                m mVar = (m) lA.get(i);
                if (mVar.i.getNodeType() == 1) {
                    nodeListModel.add(mVar);
                }
            }
            return nodeListModel;
        }
        if (str.equals("**")) {
            return new NodeListModel(((Element) this.i).getElementsByTagName("*"), this);
        }
        if (str.startsWith("@")) {
            if (str.equals("@@") || str.equals("@*")) {
                return new NodeListModel(this.i.getAttributes(), this);
            }
            if (str.equals("@@start_tag")) {
                return new SimpleScalar(new n(this.i).b((Element) this.i));
            }
            if (str.equals("@@end_tag")) {
                return new SimpleScalar(new n(this.i).a((Element) this.i));
            }
            if (str.equals("@@attributes_markup")) {
                StringBuffer stringBuffer = new StringBuffer();
                new n(this.i).a(this.i.getAttributes(), stringBuffer);
                return new SimpleScalar(stringBuffer.toString().trim());
            }
            if (freemarker.template.utility.h.d(str.substring(1))) {
                Attr attrB = b(str.substring(1));
                return attrB == null ? new NodeListModel(this) : m.a(attrB);
            }
        }
        if (!freemarker.template.utility.h.d(str)) {
            return super.get(str);
        }
        NodeListModel nodeListModelFilterByName = ((NodeListModel) a()).filterByName(str);
        return nodeListModelFilterByName.size() == 1 ? nodeListModelFilterByName.get(0) : nodeListModelFilterByName;
    }

    @Override // freemarker.template.K
    public String getAsString() throws TemplateModelException {
        NodeList childNodes = this.i.getChildNodes();
        String string = "";
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            short nodeType = nodeItem.getNodeType();
            if (nodeType == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Only elements with no child elements can be processed as text.\nThis element with name \"");
                stringBuffer.append(this.i.getNodeName());
                stringBuffer.append("\" has a child element named: ");
                stringBuffer.append(nodeItem.getNodeName());
                throw new TemplateModelException(stringBuffer.toString());
            }
            if (nodeType == 3 || nodeType == 4) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(string);
                stringBuffer2.append(nodeItem.getNodeValue());
                string = stringBuffer2.toString();
            }
        }
        return string;
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        String localName = this.i.getLocalName();
        return (localName == null || localName.equals("")) ? this.i.getNodeName() : localName;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return false;
    }
}
