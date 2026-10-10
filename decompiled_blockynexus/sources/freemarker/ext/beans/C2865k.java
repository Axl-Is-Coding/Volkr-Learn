package freemarker.ext.beans;

import freemarker.template.InterfaceC2891l;
import java.util.Iterator;

/* JADX INFO: renamed from: freemarker.ext.beans.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2865k implements freemarker.ext.util.e {
    C2865k() {
    }

    @Override // freemarker.ext.util.e
    public freemarker.template.E a(Object obj, InterfaceC2891l interfaceC2891l) {
        return new J((Iterator) obj, (C2867m) interfaceC2891l);
    }
}
