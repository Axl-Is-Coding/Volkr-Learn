package freemarker.ext.beans;

import freemarker.core._TemplateModelException;
import freemarker.core.fc;
import freemarker.core.hc;
import freemarker.template.InterfaceC2892m;
import freemarker.template.TemplateModelException;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SimpleMethod.java */
/* JADX INFO: loaded from: classes5.dex */
class ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Member f21612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class[] f21613b;

    protected ma(Member member, Class[] clsArr) {
        this.f21612a = member;
        this.f21613b = clsArr;
    }

    Object[] a(List list, C2867m c2867m) throws TemplateModelException {
        List list2 = list == null ? Collections.EMPTY_LIST : list;
        boolean zC = xa.c(this.f21612a);
        int length = this.f21613b.length;
        if (zC) {
            int i = length - 1;
            if (i > list2.size()) {
                Object[] objArr = new Object[7];
                objArr[0] = xa.b(this.f21612a);
                objArr[1] = " takes at least ";
                objArr[2] = new Integer(i);
                objArr[3] = i != 1 ? " arguments" : " argument";
                objArr[4] = ", but ";
                objArr[5] = new Integer(list2.size());
                objArr[6] = " was given.";
                throw new _TemplateModelException(objArr);
            }
        } else if (length != list2.size()) {
            Object[] objArr2 = new Object[7];
            objArr2[0] = xa.b(this.f21612a);
            objArr2[1] = " takes ";
            objArr2[2] = new Integer(length);
            objArr2[3] = length != 1 ? " arguments" : " argument";
            objArr2[4] = ", but ";
            objArr2[5] = new Integer(list2.size());
            objArr2[6] = " was given.";
            throw new _TemplateModelException(objArr2);
        }
        return a(list2, this.f21613b, zC, c2867m);
    }

    private Object[] a(List list, Class[] clsArr, boolean z, C2867m c2867m) throws TemplateModelException {
        Object objA;
        if (list == null) {
            return null;
        }
        int length = clsArr.length;
        int size = list.size();
        Object[] objArr = new Object[length];
        Iterator it = list.iterator();
        int i = z ? length - 1 : length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            Class cls = clsArr[i3];
            freemarker.template.E e2 = (freemarker.template.E) it.next();
            Object objA2 = c2867m.a(e2, cls);
            if (objA2 != InterfaceC2892m.f21731e) {
                if (objA2 == null && cls.isPrimitive()) {
                    throw a(i3, cls);
                }
                objArr[i3] = objA2;
                i3++;
            } else {
                throw a(i3, e2, cls);
            }
        }
        if (z) {
            Class cls2 = clsArr[length - 1];
            Class<?> componentType = cls2.getComponentType();
            if (!it.hasNext()) {
                objArr[i3] = Array.newInstance(componentType, 0);
            } else {
                freemarker.template.E e3 = (freemarker.template.E) it.next();
                int i4 = size - i3;
                if (i4 == 1 && (objA = c2867m.a(e3, cls2)) != InterfaceC2892m.f21731e) {
                    objArr[i3] = objA;
                } else {
                    Object objNewInstance = Array.newInstance(componentType, i4);
                    while (i2 < i4) {
                        freemarker.template.E e4 = (freemarker.template.E) (i2 == 0 ? e3 : it.next());
                        Object objA3 = c2867m.a(e4, componentType);
                        if (objA3 != InterfaceC2892m.f21731e) {
                            if (objA3 == null && componentType.isPrimitive()) {
                                throw a(i3 + i2, componentType);
                            }
                            Array.set(objNewInstance, i2, objA3);
                            i2++;
                        } else {
                            throw a(i3 + i2, e4, componentType);
                        }
                    }
                    objArr[i3] = objNewInstance;
                }
            }
        }
        return objArr;
    }

    private TemplateModelException a(int i, freemarker.template.E e2, Class cls) {
        return new _TemplateModelException(new Object[]{xa.b(this.f21612a), " couldn't be called: Can't convert the ", new hc(new Integer(i + 1)), " argument's value to the target Java type, ", freemarker.template.utility.a.a(cls), ". The type of the actual value was: ", new fc(e2)});
    }

    private TemplateModelException a(int i, Class cls) {
        return new _TemplateModelException(new Object[]{xa.b(this.f21612a), " couldn't be called: The value of the ", new hc(new Integer(i + 1)), " argument was null, but the target Java parameter type (", freemarker.template.utility.a.a(cls), ") is primitive and so can't store null."});
    }

    protected Member a() {
        return this.f21612a;
    }
}
