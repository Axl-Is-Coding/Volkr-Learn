package freemarker.template;

import freemarker.ext.beans.AbstractC2868n;
import freemarker.ext.beans.C2867m;
import java.lang.reflect.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

/* JADX INFO: renamed from: freemarker.template.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultObjectWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2887h extends C2867m {
    static final C2887h ba = new C2887h();
    private static final Class ca;
    private static final InterfaceC2891l da;
    private boolean ea;
    private boolean fa;

    static {
        Class<?> cls;
        InterfaceC2891l interfaceC2891l = null;
        try {
            cls = Class.forName("org.python.core.PyObject");
            interfaceC2891l = (InterfaceC2891l) Class.forName("d.a.a.m").getField("INSTANCE").get(null);
        } catch (Throwable th) {
            if (!(th instanceof ClassNotFoundException)) {
                try {
                    d.b.b.d("freemarker.template.DefaultObjectWrapper").a("Failed to init Jython support, so it was disabled.", th);
                } catch (Throwable unused) {
                }
            }
            cls = null;
        }
        ca = cls;
        da = interfaceC2891l;
    }

    public C2887h() {
        this(C2881b.H);
    }

    protected static Version b(Version version) {
        N.a(version);
        Version versionB = C2867m.b(version);
        return (version.intValue() < N.f21718e || versionB.intValue() >= N.f21718e) ? versionB : C2881b.F;
    }

    @Override // freemarker.ext.beans.C2867m, freemarker.template.InterfaceC2891l
    public E a(Object obj) throws TemplateModelException {
        if (obj == null) {
            return super.a((Object) null);
        }
        if (obj instanceof E) {
            return (E) obj;
        }
        if (obj instanceof String) {
            return new SimpleScalar((String) obj);
        }
        if (obj instanceof Number) {
            return new SimpleNumber((Number) obj);
        }
        if (obj instanceof Date) {
            return obj instanceof java.sql.Date ? new C2893n((java.sql.Date) obj) : obj instanceof Time ? new C2893n((Time) obj) : obj instanceof Timestamp ? new C2893n((Timestamp) obj) : new C2893n((Date) obj, c());
        }
        if (obj.getClass().isArray()) {
            if (this.ea) {
                return DefaultArrayAdapter.adapt(obj, this);
            }
            obj = d(obj);
        }
        return obj instanceof Collection ? this.ea ? obj instanceof List ? DefaultListAdapter.adapt((List) obj, this) : this.fa ? new SimpleSequence((Collection) obj, this) : DefaultNonListCollectionAdapter.adapt((Collection) obj, this) : new SimpleSequence((Collection) obj, this) : obj instanceof Map ? this.ea ? DefaultMapAdapter.adapt((Map) obj, this) : new SimpleHash((Map) obj, this) : obj instanceof Boolean ? obj.equals(Boolean.TRUE) ? r.f21735d : r.f21734c : obj instanceof Iterator ? this.ea ? DefaultIteratorAdapter.adapt((Iterator) obj, this) : new SimpleCollection((Iterator) obj, this) : e(obj);
    }

    protected Object d(Object obj) {
        int length = Array.getLength(obj);
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(Array.get(obj, i));
        }
        return arrayList;
    }

    protected E e(Object obj) throws TemplateModelException {
        return obj instanceof Node ? f(obj) : (da == null || !ca.isInstance(obj)) ? super.a(obj) : da.a(obj);
    }

    public E f(Object obj) {
        return freemarker.ext.dom.m.a((Node) obj);
    }

    @Override // freemarker.ext.beans.C2867m
    protected String m() {
        int iIndexOf;
        String strM = super.m();
        if (strM.startsWith("simpleMapWrapper") && (iIndexOf = strM.indexOf(44)) != -1) {
            strM = strM.substring(iIndexOf + 1).trim();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useAdaptersForContainers=");
        stringBuffer.append(this.ea);
        stringBuffer.append(", forceLegacyNonListCollections=");
        stringBuffer.append(this.fa);
        stringBuffer.append(", ");
        stringBuffer.append(strM);
        return stringBuffer.toString();
    }

    public C2887h(Version version) {
        this((AbstractC2889j) new C2885f(version), false);
    }

    protected C2887h(AbstractC2868n abstractC2868n, boolean z) {
        super(abstractC2868n, z, false);
        AbstractC2889j c2886g = abstractC2868n instanceof AbstractC2889j ? (AbstractC2889j) abstractC2868n : new C2886g(this, abstractC2868n.c());
        this.ea = c2886g.j();
        this.fa = c2886g.i();
        a(z);
    }

    protected C2887h(AbstractC2889j abstractC2889j, boolean z) {
        this((AbstractC2868n) abstractC2889j, z);
    }
}
