package c.t.m.g;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class kc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ String f3277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ int f3278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ int f3279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ String f3280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private /* synthetic */ Map f3281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Map f3282f;
    private /* synthetic */ boolean g;
    private /* synthetic */ int h = 1;

    kc(String str, int i, int i2, String str2, Map map, Map map2, boolean z) {
        this.f3277a = str;
        this.f3278b = i;
        this.f3279c = i2;
        this.f3280d = str2;
        this.f3281e = map;
        this.f3282f = map2;
        this.g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jc.a(this.f3277a, this.f3278b, this.f3279c, this.f3280d, this.f3281e, this.f3282f, this.g, this.h);
    }
}
