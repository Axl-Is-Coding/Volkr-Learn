package freemarker.ext.beans;

import freemarker.template.InterfaceC2891l;
import java.util.Date;

/* JADX INFO: compiled from: DateModel.java */
/* JADX INFO: loaded from: classes5.dex */
final class A implements freemarker.ext.util.e {
    A() {
    }

    @Override // freemarker.ext.util.e
    public freemarker.template.E a(Object obj, InterfaceC2891l interfaceC2891l) {
        return new B((Date) obj, (C2867m) interfaceC2891l);
    }
}
