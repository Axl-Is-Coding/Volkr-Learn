package freemarker.ext.beans;

import freemarker.template.InterfaceC2892m;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OverloadedFixArgsMethods.java */
/* JADX INFO: loaded from: classes5.dex */
class W extends ca {
    W(boolean z) {
        super(z);
    }

    @Override // freemarker.ext.beans.ca
    void a(Class[] clsArr, int[] iArr) {
    }

    @Override // freemarker.ext.beans.ca
    Class[] a(AbstractC2871q abstractC2871q) {
        return abstractC2871q.b();
    }

    @Override // freemarker.ext.beans.ca
    O a(List list, C2867m c2867m) throws Throwable {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        int size = list.size();
        Class[][] clsArrB = b();
        if (clsArrB.length <= size) {
            return D.f21536a;
        }
        Class[] clsArr = clsArrB[size];
        if (clsArr == null) {
            return D.f21536a;
        }
        Object[] objArr = new Object[size];
        int[] iArrA = a(size);
        if (iArrA == ca.f21575a) {
            iArrA = null;
        }
        Iterator it = list.iterator();
        for (int i = 0; i < size; i++) {
            Object objA = c2867m.a((freemarker.template.E) it.next(), clsArr[i], iArrA != null ? iArrA[i] : 0);
            if (objA == InterfaceC2892m.f21731e) {
                return D.a(i + 1);
            }
            objArr[i] = objA;
        }
        N nA = a(objArr, false);
        if (!(nA instanceof AbstractC2871q)) {
            return D.a((C) nA, objArr);
        }
        AbstractC2871q abstractC2871q = (AbstractC2871q) nA;
        if (!this.t) {
            C2867m.a(abstractC2871q.b(), objArr);
        } else if (iArrA != null) {
            a(objArr, abstractC2871q.b(), iArrA);
        }
        return new P(abstractC2871q, objArr);
    }
}
