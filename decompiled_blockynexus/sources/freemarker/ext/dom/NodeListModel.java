package freemarker.ext.dom;

import freemarker.core.Environment;
import freemarker.core.lc;
import freemarker.template.A;
import freemarker.template.E;
import freemarker.template.InterfaceC2891l;
import freemarker.template.K;
import freemarker.template.L;
import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateModelException;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes5.dex */
class NodeListModel extends SimpleSequence implements lc, A {
    static /* synthetic */ Class class$freemarker$template$TemplateBooleanModel;
    static /* synthetic */ Class class$freemarker$template$TemplateDateModel;
    static /* synthetic */ Class class$freemarker$template$TemplateNodeModel;
    static /* synthetic */ Class class$freemarker$template$TemplateNumberModel;
    static /* synthetic */ Class class$freemarker$template$TemplateScalarModel;
    private static InterfaceC2891l nodeWrapper = new l();
    m contextNode;
    r xpathSupport;

    NodeListModel(Node node) {
        this(m.a(node));
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private Object[] newTypeErrorExplanation(String str) {
        Object[] objArr = new Object[6];
        objArr[0] = "This XML query result can't be used as ";
        objArr[1] = str;
        objArr[2] = " because for that it had to contain exactly 1 XML node, but it contains ";
        objArr[3] = new Integer(size());
        objArr[4] = " nodes. That is, the constructing XML query has found ";
        objArr[5] = isEmpty() ? "no matches." : "multiple matches.";
        return objArr;
    }

    private List rawNodeList() throws TemplateModelException {
        int size = size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((m) get(i)).i);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // freemarker.core.lc
    public Object[] explainTypeError(Class[] clsArr) throws Throwable {
        for (Class cls : clsArr) {
            Class cls2 = class$freemarker$template$TemplateScalarModel;
            Class cls3 = cls2;
            if (cls2 == null) {
                Class clsClass$ = class$("freemarker.template.TemplateScalarModel");
                class$freemarker$template$TemplateScalarModel = clsClass$;
                cls3 = clsClass$;
            }
            if (!cls3.isAssignableFrom(cls)) {
                Class cls4 = class$freemarker$template$TemplateDateModel;
                Class cls5 = cls4;
                if (cls4 == null) {
                    Class clsClass$2 = class$("freemarker.template.TemplateDateModel");
                    class$freemarker$template$TemplateDateModel = clsClass$2;
                    cls5 = clsClass$2;
                }
                if (!cls5.isAssignableFrom(cls)) {
                    Class cls6 = class$freemarker$template$TemplateNumberModel;
                    Class cls7 = cls6;
                    if (cls6 == null) {
                        Class clsClass$3 = class$("freemarker.template.TemplateNumberModel");
                        class$freemarker$template$TemplateNumberModel = clsClass$3;
                        cls7 = clsClass$3;
                    }
                    if (!cls7.isAssignableFrom(cls)) {
                        Class cls8 = class$freemarker$template$TemplateBooleanModel;
                        Class cls9 = cls8;
                        if (cls8 == null) {
                            Class clsClass$4 = class$("freemarker.template.TemplateBooleanModel");
                            class$freemarker$template$TemplateBooleanModel = clsClass$4;
                            cls9 = clsClass$4;
                        }
                        if (!cls9.isAssignableFrom(cls)) {
                            Class cls10 = class$freemarker$template$TemplateNodeModel;
                            Class cls11 = cls10;
                            if (cls10 == null) {
                                Class clsClass$5 = class$("freemarker.template.TemplateNodeModel");
                                class$freemarker$template$TemplateNodeModel = clsClass$5;
                                cls11 = clsClass$5;
                            }
                            if (cls11.isAssignableFrom(cls)) {
                                return newTypeErrorExplanation("node");
                            }
                        }
                    }
                }
            }
            return newTypeErrorExplanation("string");
        }
        return null;
    }

    NodeListModel filterByName(String str) throws TemplateModelException {
        NodeListModel nodeListModel = new NodeListModel(this.contextNode);
        int size = size();
        if (size == 0) {
            return nodeListModel;
        }
        Environment environmentD = Environment.d();
        for (int i = 0; i < size; i++) {
            m mVar = (m) get(i);
            if ((mVar instanceof e) && ((e) mVar).a(str, environmentD)) {
                nodeListModel.add(mVar);
            }
        }
        return nodeListModel;
    }

    @Override // freemarker.template.A
    public E get(String str) throws TemplateModelException {
        L l;
        if (size() == 1) {
            return ((m) get(0)).get(str);
        }
        if (str.startsWith("@@") && (str.equals("@@markup") || str.equals("@@nested_markup") || str.equals("@@text"))) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size(); i++) {
                stringBuffer.append(((K) ((m) get(i)).get(str)).getAsString());
            }
            return new SimpleScalar(stringBuffer.toString());
        }
        if (freemarker.template.utility.h.d(str) || ((str.startsWith("@") && freemarker.template.utility.h.d(str.substring(1))) || str.equals("*") || str.equals("**") || str.equals("@@") || str.equals("@*"))) {
            NodeListModel nodeListModel = new NodeListModel(this.contextNode);
            for (int i2 = 0; i2 < size(); i2++) {
                m mVar = (m) get(i2);
                if ((mVar instanceof e) && (l = (L) ((e) mVar).get(str)) != null) {
                    int size = l.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        nodeListModel.add(l.get(i3));
                    }
                }
            }
            return nodeListModel.size() == 1 ? nodeListModel.get(0) : nodeListModel;
        }
        r xPathSupport = getXPathSupport();
        if (xPathSupport != null) {
            return xPathSupport.a(size() == 0 ? null : rawNodeList(), str);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Key: '");
        stringBuffer2.append(str);
        stringBuffer2.append("' is not legal for a node sequence (");
        stringBuffer2.append(NodeListModel.class.getName());
        stringBuffer2.append("). This node sequence contains ");
        stringBuffer2.append(size());
        stringBuffer2.append(" node(s). ");
        stringBuffer2.append("Some keys are valid only for node sequences of size 1. ");
        stringBuffer2.append("If you use Xalan (instead of Jaxen), XPath expression keys work only with ");
        stringBuffer2.append("node lists of size 1.");
        throw new TemplateModelException(stringBuffer2.toString());
    }

    r getXPathSupport() throws TemplateModelException {
        if (this.xpathSupport == null) {
            m mVar = this.contextNode;
            if (mVar != null) {
                this.xpathSupport = mVar.d();
            } else if (size() > 0) {
                this.xpathSupport = ((m) get(0)).d();
            }
        }
        return this.xpathSupport;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return size() == 0;
    }

    NodeListModel(m mVar) {
        super(nodeWrapper);
        this.contextNode = mVar;
    }

    NodeListModel(NodeList nodeList, m mVar) {
        super(nodeWrapper);
        for (int i = 0; i < nodeList.getLength(); i++) {
            this.list.add(nodeList.item(i));
        }
        this.contextNode = mVar;
    }

    NodeListModel(NamedNodeMap namedNodeMap, m mVar) {
        super(nodeWrapper);
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            this.list.add(namedNodeMap.item(i));
        }
        this.contextNode = mVar;
    }

    NodeListModel(List list, m mVar) {
        super(list, nodeWrapper);
        this.contextNode = mVar;
    }
}
