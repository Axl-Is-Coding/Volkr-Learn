package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

/* JADX INFO: compiled from: ActivityCompat.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String[] f964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f966c;

    a(String[] strArr, Activity activity, int i) {
        this.f964a = strArr;
        this.f965b = activity;
        this.f966c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.f964a.length];
        PackageManager packageManager = this.f965b.getPackageManager();
        String packageName = this.f965b.getPackageName();
        int length = this.f964a.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.f964a[i], packageName);
        }
        ((ActivityCompat.a) this.f965b).onRequestPermissionsResult(this.f966c, this.f964a, iArr);
    }
}
