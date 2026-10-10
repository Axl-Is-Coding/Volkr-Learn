package freemarker.ext.beans;

import freemarker.core.BugException;
import freemarker.template.InterfaceC2892m;
import freemarker.template.TemplateModelException;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OverloadedVarArgsMethods.java */
/* JADX INFO: loaded from: classes5.dex */
class da extends ca {
    da(boolean z) {
        super(z);
    }

    @Override // freemarker.ext.beans.ca
    Class[] a(AbstractC2871q abstractC2871q) {
        Class[] clsArr = (Class[]) abstractC2871q.b().clone();
        int length = clsArr.length - 1;
        Class<?> componentType = clsArr[length].getComponentType();
        if (componentType == null) {
            throw new BugException("Only varargs methods should be handled here");
        }
        clsArr[length] = componentType;
        return clsArr;
    }

    @Override // freemarker.ext.beans.ca
    void a(Class[] clsArr, int[] iArr) {
        Class[] clsArr2;
        int length = clsArr.length;
        Class[][] clsArrB = b();
        int i = length - 1;
        int i2 = i;
        while (true) {
            if (i2 < 0) {
                break;
            }
            Class[] clsArr3 = clsArrB[i2];
            if (clsArr3 != null) {
                a(length, clsArr3, a(i2));
                break;
            }
            i2--;
        }
        int i3 = length + 1;
        if (i3 < clsArrB.length && (clsArr2 = clsArrB[i3]) != null) {
            a(length, clsArr2, a(i3));
        }
        while (i3 < clsArrB.length) {
            a(i3, clsArr, iArr);
            i3++;
        }
        if (length > 0) {
            a(i, clsArr, iArr);
        }
    }

    private void a(int i, Class[] clsArr, int[] iArr) {
        Class[] clsArr2 = b()[i];
        if (clsArr2 == null) {
            return;
        }
        int length = clsArr2.length;
        int length2 = clsArr.length;
        int iMin = Math.min(length2, length);
        for (int i2 = 0; i2 < iMin; i2++) {
            clsArr2[i2] = a(clsArr2[i2], clsArr[i2]);
        }
        if (length > length2) {
            Class cls = clsArr[length2 - 1];
            while (length2 < length) {
                clsArr2[length2] = a(clsArr2[length2], cls);
                length2++;
            }
        }
        if (this.t) {
            a(i, iArr);
        }
    }

    @Override // freemarker.ext.beans.ca
    O a(List list, C2867m c2867m) throws Throwable {
        List list2 = list == null ? Collections.EMPTY_LIST : list;
        int size = list2.size();
        Class[][] clsArrB = b();
        Object[] objArr = new Object[size];
        int iMin = Math.min(size + 1, clsArrB.length - 1);
        int[] iArrA = null;
        loop0: while (iMin >= 0) {
            Class[] clsArr = clsArrB[iMin];
            if (clsArr != null) {
                iArrA = a(iMin);
                if (iArrA == ca.f21575a) {
                    iArrA = null;
                }
                Iterator it = list2.iterator();
                int i = 0;
                while (i < size) {
                    int i2 = i < iMin ? i : iMin - 1;
                    Object objA = c2867m.a((freemarker.template.E) it.next(), clsArr[i2], iArrA != null ? iArrA[i2] : 0);
                    if (objA == InterfaceC2892m.f21731e) {
                        break;
                    }
                    objArr[i] = objA;
                    i++;
                }
                break loop0;
            }
            if (iMin == 0) {
                return D.f21536a;
            }
            iMin--;
        }
        N nA = a(objArr, true);
        if (nA instanceof AbstractC2871q) {
            AbstractC2871q abstractC2871q = (AbstractC2871q) nA;
            Object objA2 = a(objArr, list2, abstractC2871q, c2867m);
            if (objA2 instanceof Object[]) {
                Object[] objArr2 = (Object[]) objA2;
                if (!this.t) {
                    C2867m.a(abstractC2871q.b(), objArr2);
                } else if (iArrA != null) {
                    a(objArr2, abstractC2871q.b(), iArrA);
                }
                return new P(abstractC2871q, objArr2);
            }
            return D.a(((Integer) objA2).intValue());
        }
        return D.a((C) nA, objArr);
    }

    private Object a(Object[] objArr, List list, AbstractC2871q abstractC2871q, C2867m c2867m) throws TemplateModelException {
        Class[] clsArrB = abstractC2871q.b();
        int length = clsArrB.length;
        int i = length - 1;
        Class<?> componentType = clsArrB[i].getComponentType();
        int length2 = objArr.length;
        if (objArr.length != length) {
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            Object objNewInstance = Array.newInstance(componentType, length2 - i);
            for (int i2 = i; i2 < length2; i2++) {
                Object objA = c2867m.a((freemarker.template.E) list.get(i2), componentType);
                if (objA == InterfaceC2892m.f21731e) {
                    return new Integer(i2 + 1);
                }
                Array.set(objNewInstance, i2 - i, objA);
            }
            objArr2[i] = objNewInstance;
            return objArr2;
        }
        Object objA2 = c2867m.a((freemarker.template.E) list.get(i), componentType);
        if (objA2 == InterfaceC2892m.f21731e) {
            return new Integer(i + 1);
        }
        Object objNewInstance2 = Array.newInstance(componentType, 1);
        Array.set(objNewInstance2, 0, objA2);
        objArr[i] = objNewInstance2;
        return objArr;
    }
}
