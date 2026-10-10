package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: TokenDataService.java */
/* JADX INFO: loaded from: classes2.dex */
class Va implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Wa f14739a;

    Va(Wa wa) {
        this.f14739a = wa;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14739a.a(this.f14739a.c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
