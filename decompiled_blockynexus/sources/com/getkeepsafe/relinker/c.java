package com.getkeepsafe.relinker;

import android.content.Context;
import com.getkeepsafe.relinker.b;

/* JADX INFO: compiled from: ReLinkerInstance.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f12513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.c f12514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ e f12515e;

    c(e eVar, Context context, String str, String str2, b.c cVar) {
        this.f12515e = eVar;
        this.f12511a = context;
        this.f12512b = str;
        this.f12513c = str2;
        this.f12514d = cVar;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.f12515e.c(this.f12511a, this.f12512b, this.f12513c);
            this.f12514d.success();
        } catch (MissingLibraryException e2) {
            this.f12514d.failure(e2);
        } catch (UnsatisfiedLinkError e3) {
            this.f12514d.failure(e3);
        }
    }
}
