package freemarker.ext.dom;

import freemarker.core.C2848xb;
import freemarker.template.E;
import freemarker.template.InterfaceC2891l;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jaxen.BaseXPath;
import org.jaxen.FunctionContext;
import org.jaxen.JaxenException;
import org.jaxen.NamespaceContext;
import org.jaxen.Navigator;
import org.jaxen.VariableContext;

/* JADX INFO: compiled from: JaxenXPathSupport.java */
/* JADX INFO: loaded from: classes5.dex */
class k implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C2848xb f21667a = new f(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayList f21668b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NamespaceContext f21669c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final VariableContext f21670d = new h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FunctionContext f21671e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C2848xb f21672f = new C2848xb(1);
    private static final Navigator g = new j();

    k() {
    }

    @Override // freemarker.ext.dom.r
    public E a(Object obj, String str) throws TemplateModelException {
        BaseXPath baseXPath;
        try {
            Map map = (Map) f21667a.b();
            synchronized (map) {
                baseXPath = (BaseXPath) map.get(str);
                if (baseXPath == null) {
                    baseXPath = new BaseXPath(str, g);
                    baseXPath.setNamespaceContext(f21669c);
                    baseXPath.setFunctionContext(f21671e);
                    baseXPath.setVariableContext(f21670d);
                    map.put(str, baseXPath);
                }
            }
            if (obj == null) {
                obj = f21668b;
            }
            List listSelectNodes = baseXPath.selectNodes(obj);
            if (listSelectNodes.size() == 1) {
                return InterfaceC2891l.f21729b.a(listSelectNodes.get(0));
            }
            NodeListModel nodeListModel = new NodeListModel(listSelectNodes, (m) null);
            nodeListModel.xpathSupport = this;
            return nodeListModel;
        } catch (UndeclaredThrowableException e2) {
            Throwable undeclaredThrowable = e2.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof TemplateModelException) {
                throw ((TemplateModelException) undeclaredThrowable);
            }
            throw e2;
        } catch (JaxenException e3) {
            throw new TemplateModelException((Exception) e3);
        }
    }
}
