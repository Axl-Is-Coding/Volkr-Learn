package freemarker.ext.beans;

import freemarker.core.CollectionAndSequence;
import freemarker.core._TemplateModelException;
import freemarker.core.fc;
import freemarker.core.gc;
import freemarker.template.InterfaceC2880a;
import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateModelException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: freemarker.ext.beans.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeanModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2860f implements freemarker.ext.util.f, freemarker.template.B, freemarker.template.H, InterfaceC2880a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21584a = d.b.b.d("freemarker.beans");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final freemarker.template.E f21585b = new SimpleScalar("UNKNOWN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final freemarker.ext.util.e f21586c = new C2859e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object f21587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final C2867m f21588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap f21589f;

    public C2860f(Object obj, C2867m c2867m) {
        this(obj, c2867m, true);
    }

    private void a(String str, Map map) {
        d.b.b bVar = f21584a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Key ");
        stringBuffer.append(freemarker.template.utility.h.f(str));
        stringBuffer.append(" was not found on instance of ");
        stringBuffer.append(this.f21587d.getClass().getName());
        stringBuffer.append(". Introspection information for ");
        stringBuffer.append("the class is: ");
        stringBuffer.append(map);
        bVar.b(stringBuffer.toString());
    }

    @Override // freemarker.template.A
    public freemarker.template.E get(String str) throws TemplateModelException {
        freemarker.template.E eA;
        Class<?> cls = this.f21587d.getClass();
        Map mapA = this.f21588e.b().a((Class) cls);
        try {
            if (this.f21588e.j()) {
                Object obj = mapA.get(str);
                eA = obj != null ? a(obj, mapA) : a(mapA, cls, str);
            } else {
                freemarker.template.E eA2 = a(mapA, cls, str);
                freemarker.template.E eA3 = this.f21588e.a((Object) null);
                if (eA2 != eA3 && eA2 != f21585b) {
                    return eA2;
                }
                Object obj2 = mapA.get(str);
                if (obj2 != null) {
                    freemarker.template.E eA4 = a(obj2, mapA);
                    eA = (eA4 == f21585b && eA2 == eA3) ? eA3 : eA4;
                } else {
                    eA = null;
                }
            }
            if (eA != f21585b) {
                return eA;
            }
            if (!this.f21588e.k()) {
                if (f21584a.a()) {
                    a(str, mapA);
                }
                return this.f21588e.a((Object) null);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No such bean property: ");
            stringBuffer.append(str);
            throw new InvalidPropertyException(stringBuffer.toString());
        } catch (TemplateModelException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new _TemplateModelException(e3, new Object[]{"An error has occurred when reading existing sub-variable ", new gc(str), "; see cause exception! The type of the containing value was: ", new fc(this)});
        }
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return this.f21587d;
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.f21587d;
    }

    public boolean isEmpty() {
        Object obj = this.f21587d;
        return obj instanceof String ? ((String) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj == null || Boolean.FALSE.equals(obj);
    }

    @Override // freemarker.template.B
    public freemarker.template.s keys() {
        return new CollectionAndSequence(new SimpleSequence(a(), this.f21588e));
    }

    public int size() {
        return this.f21588e.b().b(this.f21587d.getClass());
    }

    public String toString() {
        return this.f21587d.toString();
    }

    C2860f(Object obj, C2867m c2867m, boolean z) {
        this.f21587d = obj;
        this.f21588e = c2867m;
        if (!z || obj == null) {
            return;
        }
        c2867m.b().a((Class) obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private freemarker.template.E a(java.lang.Object r5, java.util.Map r6) throws java.lang.IllegalAccessException, freemarker.template.TemplateModelException, java.lang.reflect.InvocationTargetException {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.HashMap r0 = r4.f21589f     // Catch: java.lang.Throwable -> L98
            r1 = 0
            if (r0 == 0) goto Lf
            java.util.HashMap r0 = r4.f21589f     // Catch: java.lang.Throwable -> L98
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Throwable -> L98
            freemarker.template.E r0 = (freemarker.template.E) r0     // Catch: java.lang.Throwable -> L98
            goto L10
        Lf:
            r0 = r1
        L10:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L14
            return r0
        L14:
            freemarker.template.E r2 = freemarker.ext.beans.C2860f.f21585b
            boolean r3 = r5 instanceof java.beans.IndexedPropertyDescriptor
            if (r3 == 0) goto L31
            r0 = r5
            java.beans.IndexedPropertyDescriptor r0 = (java.beans.IndexedPropertyDescriptor) r0
            java.lang.reflect.Method r0 = r0.getIndexedReadMethod()
            freemarker.ext.beans.na r1 = new freemarker.ext.beans.na
            java.lang.Object r2 = r4.f21587d
            java.lang.Class[] r6 = freemarker.ext.beans.C2874u.a(r6, r0)
            freemarker.ext.beans.m r3 = r4.f21588e
            r1.<init>(r2, r0, r6, r3)
        L2e:
            r0 = r1
        L2f:
            r2 = r0
            goto L7f
        L31:
            boolean r3 = r5 instanceof java.beans.PropertyDescriptor
            if (r3 == 0) goto L45
            r6 = r5
            java.beans.PropertyDescriptor r6 = (java.beans.PropertyDescriptor) r6
            freemarker.ext.beans.m r2 = r4.f21588e
            java.lang.Object r3 = r4.f21587d
            java.lang.reflect.Method r6 = r6.getReadMethod()
            freemarker.template.E r2 = r2.a(r3, r6, r1)
            goto L7f
        L45:
            boolean r1 = r5 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L59
            freemarker.ext.beans.m r6 = r4.f21588e
            r1 = r5
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1
            java.lang.Object r2 = r4.f21587d
            java.lang.Object r1 = r1.get(r2)
            freemarker.template.E r2 = r6.a(r1)
            goto L7f
        L59:
            boolean r1 = r5 instanceof java.lang.reflect.Method
            if (r1 == 0) goto L6e
            r0 = r5
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            freemarker.ext.beans.na r1 = new freemarker.ext.beans.na
            java.lang.Object r2 = r4.f21587d
            java.lang.Class[] r6 = freemarker.ext.beans.C2874u.a(r6, r0)
            freemarker.ext.beans.m r3 = r4.f21588e
            r1.<init>(r2, r0, r6, r3)
            goto L2e
        L6e:
            boolean r6 = r5 instanceof freemarker.ext.beans.aa
            if (r6 == 0) goto L7f
            freemarker.ext.beans.ba r0 = new freemarker.ext.beans.ba
            java.lang.Object r6 = r4.f21587d
            r1 = r5
            freemarker.ext.beans.aa r1 = (freemarker.ext.beans.aa) r1
            freemarker.ext.beans.m r2 = r4.f21588e
            r0.<init>(r6, r1, r2)
            goto L2f
        L7f:
            if (r0 == 0) goto L97
            monitor-enter(r4)
            java.util.HashMap r6 = r4.f21589f     // Catch: java.lang.Throwable -> L94
            if (r6 != 0) goto L8d
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L94
            r6.<init>()     // Catch: java.lang.Throwable -> L94
            r4.f21589f = r6     // Catch: java.lang.Throwable -> L94
        L8d:
            java.util.HashMap r6 = r4.f21589f     // Catch: java.lang.Throwable -> L94
            r6.put(r5, r0)     // Catch: java.lang.Throwable -> L94
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L94
            goto L97
        L94:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L94
            throw r5
        L97:
            return r2
        L98:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L98
            goto L9c
        L9b:
            throw r5
        L9c:
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.C2860f.a(java.lang.Object, java.util.Map):freemarker.template.E");
    }

    protected freemarker.template.E a(Map map, Class cls, String str) throws IllegalAccessException, TemplateModelException, InvocationTargetException {
        Method method = (Method) map.get(C2874u.f21646f);
        return method == null ? f21585b : this.f21588e.a(this.f21587d, method, new Object[]{str});
    }

    protected freemarker.template.E a(Object obj) throws TemplateModelException {
        return this.f21588e.g().a(obj);
    }

    protected Set a() {
        return this.f21588e.b().c(this.f21587d.getClass());
    }
}
