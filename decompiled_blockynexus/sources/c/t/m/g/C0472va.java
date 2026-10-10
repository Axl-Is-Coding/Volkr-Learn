package c.t.m.g;

import java.io.File;

/* JADX INFO: renamed from: c.t.m.g.va, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0472va implements La {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ File f3427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ RunnableC0475wa f3428b;

    C0472va(RunnableC0475wa runnableC0475wa, File file) {
        this.f3428b = runnableC0475wa;
        this.f3427a = file;
    }

    @Override // c.t.m.g.La
    public final void a(String str) {
        this.f3427a.delete();
        "upload suc & del:".concat(String.valueOf(str));
    }

    @Override // c.t.m.g.La
    public final void b(String str) {
        "upload failed:".concat(String.valueOf(str));
    }
}
