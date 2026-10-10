package freemarker.ext.beans;

import com.alibaba.android.arouter.utils.Consts;
import freemarker.core._TemplateModelException;
import freemarker.core.ec;
import freemarker.core.kc;
import freemarker.template.TemplateModelException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: OverloadedMethods.java */
/* JADX INFO: loaded from: classes5.dex */
final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ca f21561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ca f21562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21563c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: OverloadedMethods.java */
    abstract class a extends ec {
        public a(Object[] objArr) {
            super(objArr);
        }

        @Override // freemarker.core.ec
        protected String a(Object obj) {
            Object[] objArr = (Object[]) obj;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < objArr.length; i++) {
                if (i != 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(b(objArr[i]));
            }
            return stringBuffer.toString();
        }

        abstract String b(Object obj);
    }

    aa(boolean z) {
        this.f21563c = z;
        this.f21561a = new W(z);
    }

    void a(Method method) throws Throwable {
        a(new fa(method, method.getParameterTypes()));
    }

    void a(Constructor constructor) throws Throwable {
        a(new fa(constructor, constructor.getParameterTypes()));
    }

    private void a(fa faVar) throws Throwable {
        this.f21561a.a(faVar);
        if (faVar.e()) {
            if (this.f21562b == null) {
                this.f21562b = new da(this.f21563c);
            }
            this.f21562b.a(faVar);
        }
    }

    P a(List list, C2867m c2867m) throws TemplateModelException {
        O oA;
        O oA2 = this.f21561a.a(list, c2867m);
        if (oA2 instanceof P) {
            return (P) oA2;
        }
        ca caVar = this.f21562b;
        if (caVar != null) {
            oA = caVar.a(list, c2867m);
            if (oA instanceof P) {
                return (P) oA;
            }
        } else {
            oA = null;
        }
        kc kcVar = new kc(new Object[]{a((D) oA2, (D) oA, list), "\nThe matching overload was searched among these members:\n", a()});
        if (!this.f21563c) {
            kcVar.a("You seem to use BeansWrapper with incompatibleImprovements set below 2.3.21. If you think this error is unfounded, enabling 2.3.21 fixes may helps. See version history for more.");
        }
        throw new _TemplateModelException(kcVar);
    }

    private Object[] a(D d2, D d3, List list) {
        if (d3 != null) {
            if (d2 != null && !d2.c()) {
                return new Object[]{"When trying to call the non-varargs overloads:\n", a(d2, list), "\nWhen trying to call the varargs overloads:\n", a(d3, (List) null)};
            }
            return a(d3, list);
        }
        return a(d2, list);
    }

    private Object[] a(D d2, List list) {
        Object[] objArrB = d2.b();
        Object[] objArr = new Object[3];
        objArr[0] = d2.a();
        String str = "";
        objArr[1] = list != null ? new Object[]{"\nThe FTL type of the argument values were: ", a(list), Consts.DOT} : "";
        Object obj = str;
        if (objArrB != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a(objArrB));
            stringBuffer.append(Consts.DOT);
            obj = new Object[]{"\nThe Java type of the argument values were: ", stringBuffer.toString()};
        }
        objArr[2] = obj;
        return objArr;
    }

    private ec a() {
        return new X(this, null);
    }

    private ec a(List list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = freemarker.template.utility.a.a((freemarker.template.E) list.get(i));
        }
        return new Y(this, strArr);
    }

    private Object a(Object[] objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj != null ? obj.getClass() : null;
        }
        return new Z(this, clsArr);
    }
}
