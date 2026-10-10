package freemarker.ext.beans;

import freemarker.ext.beans.aa;

/* JADX INFO: compiled from: OverloadedMethods.java */
/* JADX INFO: loaded from: classes5.dex */
class Y extends aa.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ aa f21559e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Y(aa aaVar, Object[] objArr) {
        super(objArr);
        this.f21559e = aaVar;
    }

    @Override // freemarker.ext.beans.aa.a
    String b(Object obj) {
        return (String) obj;
    }
}
