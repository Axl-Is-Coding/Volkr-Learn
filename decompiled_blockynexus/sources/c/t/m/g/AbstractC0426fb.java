package c.t.m.g;

import android.os.Bundle;

/* JADX INFO: renamed from: c.t.m.g.fb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0426fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3198c = true;

    public AbstractC0426fb(String str, String str2) {
        this.f3196a = str;
        this.f3197b = str2;
    }

    public void a() {
    }

    public final boolean a(Bundle bundle) {
        if (this.f3198c) {
            return b(bundle);
        }
        return false;
    }

    protected abstract boolean b(Bundle bundle);

    public String toString() {
        return "[name=" + this.f3196a + ",desc=" + this.f3197b + ",enabled=" + this.f3198c + "]";
    }
}
