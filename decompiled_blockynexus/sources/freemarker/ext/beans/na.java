package freemarker.ext.beans;

import com.facebook.internal.NativeProtocol;
import com.umeng.analytics.pro.au;
import freemarker.core.lc;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateModelException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SimpleMethodModel.java */
/* JADX INFO: loaded from: classes5.dex */
public final class na extends ma implements lc, freemarker.template.D, freemarker.template.L {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f21621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final C2867m f21622e;

    na(Object obj, Method method, Class[] clsArr, C2867m c2867m) {
        super(method, clsArr);
        this.f21621d = obj;
        this.f21622e = c2867m;
    }

    public Object a(List list) throws TemplateModelException {
        try {
            return this.f21622e.a(this.f21621d, (Method) a(), a(list, this.f21622e));
        } catch (TemplateModelException e2) {
            throw e2;
        } catch (Exception e3) {
            throw xa.a(this.f21621d, a(), e3);
        }
    }

    @Override // freemarker.core.lc
    public Object[] explainTypeError(Class[] clsArr) throws Throwable {
        Method method;
        Class<?> returnType;
        Member memberA = a();
        if ((memberA instanceof Method) && (returnType = (method = (Method) memberA).getReturnType()) != null && returnType != Void.TYPE) {
            Class<?> clsA = f21620c;
            if (clsA == null) {
                clsA = a("java.lang.Void");
                f21620c = clsA;
            }
            if (returnType != clsA) {
                String name = method.getName();
                if (name.startsWith("get") && name.length() > 3 && Character.isUpperCase(name.charAt(3)) && method.getParameterTypes().length == 0) {
                    return new Object[]{"Maybe using obj.something instead of obj.getSomething will yield the desired value."};
                }
                if (name.startsWith(au.ad) && name.length() > 2 && Character.isUpperCase(name.charAt(2)) && method.getParameterTypes().length == 0) {
                    return new Object[]{"Maybe using obj.something instead of obj.isSomething will yield the desired value."};
                }
                Object[] objArr = new Object[3];
                objArr[0] = "Maybe using obj.something(";
                objArr[1] = method.getParameterTypes().length != 0 ? NativeProtocol.WEB_DIALOG_PARAMS : "";
                objArr[2] = ") instead of obj.something will yield the desired value";
                return objArr;
            }
        }
        return null;
    }

    @Override // freemarker.template.L
    public freemarker.template.E get(int i) throws TemplateModelException {
        return (freemarker.template.E) a(Collections.singletonList(new SimpleNumber(new Integer(i))));
    }

    @Override // freemarker.template.L
    public int size() throws TemplateModelException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Getting the number of items or enumerating the items is not supported on this ");
        stringBuffer.append(freemarker.template.utility.a.a((freemarker.template.E) this));
        stringBuffer.append(" value.\n");
        stringBuffer.append("(");
        stringBuffer.append("Hint 1: Maybe you wanted to call this method first and then do something with its return value. ");
        stringBuffer.append("Hint 2: Getting items by intex possibly works, hence it's a \"+sequence\".");
        stringBuffer.append(")");
        throw new TemplateModelException(stringBuffer.toString());
    }

    public String toString() {
        return a().toString();
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
