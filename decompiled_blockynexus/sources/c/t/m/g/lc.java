package c.t.m.g;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class lc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ int f3292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ int f3293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ String f3294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private /* synthetic */ Map f3295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Map f3296f;
    private /* synthetic */ boolean g;

    lc(String str, int i, int i2, String str2, Map map, Map map2, boolean z) {
        this.f3291a = str;
        this.f3292b = i;
        this.f3293c = i2;
        this.f3294d = str2;
        this.f3295e = map;
        this.f3296f = map2;
        this.g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jc.a(this.f3291a, this.f3292b, this.f3293c, this.f3294d, this.f3295e, this.f3296f, this.g, 0);
    }
}
