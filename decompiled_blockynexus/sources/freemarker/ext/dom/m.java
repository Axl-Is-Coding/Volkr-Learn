package freemarker.ext.dom;

import freemarker.core.lc;
import freemarker.template.A;
import freemarker.template.E;
import freemarker.template.I;
import freemarker.template.InterfaceC2880a;
import freemarker.template.L;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateModelException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* JADX INFO: compiled from: NodeModel.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m implements lc, freemarker.ext.util.f, A, I, L, InterfaceC2880a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21673a = d.b.b.d("freemarker.dom");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f21674b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f21675c = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static r f21676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Class f21677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21678f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    final Node i;
    private L j;

    static {
        try {
            e();
        } catch (Exception unused) {
        }
        if (f21677e == null && f21673a.c()) {
            f21673a.f("No XPath support is available.");
        }
    }

    protected m(Node node) {
        this.i = node;
    }

    public static void e() {
        synchronized (f21674b) {
            f21677e = null;
            f21676d = null;
            try {
                h();
            } catch (Exception unused) {
            }
            if (f21677e == null) {
                try {
                    g();
                } catch (Exception unused2) {
                }
            }
            if (f21677e == null) {
                try {
                    f();
                } catch (Exception unused3) {
                }
            }
        }
    }

    public static void f() throws Exception {
        Class.forName("org.jaxen.dom.DOMXPath");
        Class<?> cls = Class.forName("freemarker.ext.dom.k");
        f21676d = (r) cls.newInstance();
        synchronized (f21674b) {
            f21677e = cls;
        }
        if (f21673a.a()) {
            f21673a.b("Using Jaxen classes for XPath support");
        }
    }

    public static void g() throws Exception {
        Class.forName("com.sun.org.apache.xpath.internal.XPath");
        Class<?> cls = Class.forName("freemarker.ext.dom.q");
        synchronized (f21674b) {
            f21677e = cls;
        }
        if (f21673a.a()) {
            f21673a.b("Using Sun's internal Xalan classes for XPath support");
        }
    }

    public static void h() throws Exception {
        Class.forName("org.apache.xpath.XPath");
        Class<?> cls = Class.forName("freemarker.ext.dom.t");
        synchronized (f21674b) {
            f21677e = cls;
        }
        if (f21673a.a()) {
            f21673a.b("Using Xalan classes for XPath support");
        }
    }

    public L a() {
        if (this.j == null) {
            this.j = new NodeListModel(this.i.getChildNodes(), this);
        }
        return this.j;
    }

    public String b() {
        short nodeType = this.i.getNodeType();
        if (nodeType != 2 && nodeType != 1) {
            return null;
        }
        String namespaceURI = this.i.getNamespaceURI();
        if (namespaceURI == null && nodeType == 1) {
            return "";
        }
        if ("".equals(namespaceURI) && nodeType == 2) {
            return null;
        }
        return namespaceURI;
    }

    String c() throws TemplateModelException {
        return getNodeName();
    }

    r d() {
        r rVar;
        Exception e2;
        r rVar2 = f21676d;
        if (rVar2 != null) {
            return rVar2;
        }
        Document ownerDocument = this.i.getOwnerDocument();
        if (ownerDocument == null) {
            ownerDocument = (Document) this.i;
        }
        synchronized (ownerDocument) {
            WeakReference weakReference = (WeakReference) f21675c.get(ownerDocument);
            r rVar3 = weakReference != null ? (r) weakReference.get() : null;
            if (rVar3 == null) {
                try {
                    rVar = (r) f21677e.newInstance();
                } catch (Exception e3) {
                    rVar = rVar3;
                    e2 = e3;
                }
                try {
                    f21675c.put(ownerDocument, new WeakReference(rVar));
                } catch (Exception e4) {
                    e2 = e4;
                    f21673a.a("Error instantiating xpathSupport class", e2);
                }
            } else {
                rVar = rVar3;
            }
        }
        return rVar;
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((m) obj).i.equals(this.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // freemarker.core.lc
    public Object[] explainTypeError(Class[] clsArr) throws Throwable {
        for (Class cls : clsArr) {
            Class cls2 = f21678f;
            Class cls3 = cls2;
            if (cls2 == null) {
                Class clsA = a("freemarker.template.TemplateDateModel");
                f21678f = clsA;
                cls3 = clsA;
            }
            if (!cls3.isAssignableFrom(cls)) {
                Class cls4 = g;
                Class cls5 = cls4;
                if (cls4 == null) {
                    Class clsA2 = a("freemarker.template.TemplateNumberModel");
                    g = clsA2;
                    cls5 = clsA2;
                }
                if (!cls5.isAssignableFrom(cls)) {
                    Class cls6 = h;
                    Class cls7 = cls6;
                    if (cls6 == null) {
                        Class clsA3 = a("freemarker.template.TemplateBooleanModel");
                        h = clsA3;
                        cls7 = clsA3;
                    }
                    if (!cls7.isAssignableFrom(cls)) {
                    }
                }
            }
            return new Object[]{"XML node values are always strings (text), that is, they can't be used as number, date/time/datetime or boolean without explicit conversion (such as someNode?number, someNode?datetime.xs, someNode?date.xs, someNode?time.xs, someNode?boolean)."};
        }
        return null;
    }

    @Override // freemarker.template.L
    public final E get(int i) {
        if (i == 0) {
            return this;
        }
        return null;
    }

    public E get(String str) throws TemplateModelException {
        if (str.startsWith("@@")) {
            if (str.equals("@@text")) {
                return new SimpleScalar(b(this.i));
            }
            if (str.equals("@@namespace")) {
                String namespaceURI = this.i.getNamespaceURI();
                if (namespaceURI == null) {
                    return null;
                }
                return new SimpleScalar(namespaceURI);
            }
            if (str.equals("@@local_name")) {
                String localName = this.i.getLocalName();
                if (localName == null) {
                    localName = getNodeName();
                }
                return new SimpleScalar(localName);
            }
            if (str.equals("@@markup")) {
                StringBuffer stringBuffer = new StringBuffer();
                new n(this.i).a(this.i, stringBuffer);
                return new SimpleScalar(stringBuffer.toString());
            }
            if (str.equals("@@nested_markup")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                new n(this.i).a(this.i.getChildNodes(), stringBuffer2);
                return new SimpleScalar(stringBuffer2.toString());
            }
            if (str.equals("@@qname")) {
                String strC = c();
                if (strC == null) {
                    return null;
                }
                return new SimpleScalar(strC);
            }
        }
        r rVarD = d();
        if (rVarD != null) {
            return rVarD.a(this.i, str);
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Can't try to resolve the XML query key, because no XPath support is available. It's either malformed or an XPath expression: ");
        stringBuffer3.append(str);
        throw new TemplateModelException(stringBuffer3.toString());
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return this.i;
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.i;
    }

    public final int hashCode() {
        return this.i.hashCode();
    }

    @Override // freemarker.template.L
    public final int size() {
        return 1;
    }

    public static m a(Node node) {
        if (node == null) {
            return null;
        }
        switch (node.getNodeType()) {
            case 1:
                return new e((Element) node);
            case 2:
                return new a((Attr) node);
            case 3:
            case 4:
            case 8:
                return new b((CharacterData) node);
            case 5:
            case 6:
            default:
                return null;
            case 7:
                return new o((ProcessingInstruction) node);
            case 9:
                return new c((Document) node);
            case 10:
                return new d((DocumentType) node);
        }
    }

    private static String b(Node node) {
        String string = "";
        if (!(node instanceof Text) && !(node instanceof CDATASection)) {
            if (!(node instanceof Element)) {
                return node instanceof Document ? b(((Document) node).getDocumentElement()) : "";
            }
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(string);
                stringBuffer.append(b(childNodes.item(i)));
                string = stringBuffer.toString();
            }
            return string;
        }
        return ((CharacterData) node).getData();
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
