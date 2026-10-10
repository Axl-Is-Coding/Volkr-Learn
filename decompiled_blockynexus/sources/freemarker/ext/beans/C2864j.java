package freemarker.ext.beans;

import freemarker.template.InterfaceC2891l;

/* JADX INFO: renamed from: freemarker.ext.beans.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
class C2864j implements freemarker.ext.util.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ C2867m f21598a;

    C2864j(C2867m c2867m) {
        this.f21598a = c2867m;
    }

    @Override // freemarker.ext.util.e
    public freemarker.template.E a(Object obj, InterfaceC2891l interfaceC2891l) {
        return ((Boolean) obj).booleanValue() ? this.f21598a.R : this.f21598a.Q;
    }
}
