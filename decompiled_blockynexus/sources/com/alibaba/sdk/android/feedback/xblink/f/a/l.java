package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.os.Handler;
import android.os.Looper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ k f3812c;

    l(k kVar, String str, String str2) {
        this.f3812c = kVar;
        this.f3810a = str;
        this.f3811b = str2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        Runnable nVar;
        byte[] bArrA = new com.alibaba.sdk.android.feedback.util.a.b(this.f3810a).a();
        Handler handler = new Handler(Looper.getMainLooper());
        if (bArrA != null) {
            this.f3812c.a(com.alibaba.sdk.android.feedback.util.j.f3723b, this.f3811b, bArrA);
            if (this.f3812c.f3808e == null) {
                this.f3812c.f3808e = new com.alibaba.sdk.android.feedback.util.a();
            }
            if (this.f3812c.f3808e.b()) {
                this.f3812c.f3808e.a();
            }
            this.f3812c.f3808e.a(new File(com.alibaba.sdk.android.feedback.util.j.f3723b + File.separator + this.f3811b).getAbsolutePath(), this.f3812c.f3809f);
            nVar = new m(this);
        } else {
            nVar = new n(this);
        }
        handler.post(nVar);
    }
}
