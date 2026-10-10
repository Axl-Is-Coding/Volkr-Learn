package c.t.m.g;

/* JADX INFO: renamed from: c.t.m.g.sa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0463sa implements La {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ RunnableC0466ta f3389a;

    C0463sa(RunnableC0466ta runnableC0466ta) {
        this.f3389a = runnableC0466ta;
    }

    @Override // c.t.m.g.La
    public final void a(String str) {
        this.f3389a.f3399a.delete();
        StringBuilder sb = new StringBuilder("upload ");
        sb.append(this.f3389a.f3399a.getName());
        sb.append(" succeed, then delete.");
    }

    @Override // c.t.m.g.La
    public final void b(String str) {
        "upload error,".concat(String.valueOf(str));
    }
}
