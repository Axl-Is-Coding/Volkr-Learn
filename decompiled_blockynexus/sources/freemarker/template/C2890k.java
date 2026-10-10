package freemarker.template;

import java.util.ArrayList;

/* JADX INFO: renamed from: freemarker.template.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GeneralPurposeNothing.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2890k implements B, D, K, L, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final E f21726a = new C2890k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final s f21727b = new SimpleCollection(new ArrayList(0));

    private C2890k() {
    }

    static E a() {
        return f21726a;
    }

    @Override // freemarker.template.L
    public E get(int i) throws TemplateModelException {
        throw new TemplateModelException("Empty list");
    }

    @Override // freemarker.template.A
    public E get(String str) {
        return null;
    }

    @Override // freemarker.template.r
    public boolean getAsBoolean() {
        return false;
    }

    @Override // freemarker.template.K
    public String getAsString() {
        return "";
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return true;
    }

    @Override // freemarker.template.B
    public s keys() {
        return f21727b;
    }

    @Override // freemarker.template.B
    public int size() {
        return 0;
    }
}
