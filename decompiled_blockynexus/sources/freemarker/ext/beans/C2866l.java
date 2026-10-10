package freemarker.ext.beans;

import freemarker.template.InterfaceC2891l;
import java.util.Enumeration;

/* JADX INFO: renamed from: freemarker.ext.beans.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2866l implements freemarker.ext.util.e {
    C2866l() {
    }

    @Override // freemarker.ext.util.e
    public freemarker.template.E a(Object obj, InterfaceC2891l interfaceC2891l) {
        return new E((Enumeration) obj, (C2867m) interfaceC2891l);
    }
}
