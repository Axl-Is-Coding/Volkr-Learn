package androidx.media;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class VolumeProviderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f1696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f1697e;

    public static abstract class a {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    public final int a() {
        return this.f1695c;
    }

    public void a(int i) {
    }

    public final int b() {
        return this.f1694b;
    }

    public void b(int i) {
    }

    public final int c() {
        return this.f1693a;
    }

    public Object d() {
        if (this.f1697e == null && Build.VERSION.SDK_INT >= 21) {
            this.f1697e = E.a(this.f1693a, this.f1694b, this.f1695c, new C(this));
        }
        return this.f1697e;
    }

    public void setCallback(a aVar) {
        this.f1696d = aVar;
    }
}
