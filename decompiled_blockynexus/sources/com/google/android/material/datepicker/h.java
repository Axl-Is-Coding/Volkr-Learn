package com.google.android.material.datepicker;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13315b;

    h(MaterialCalendar materialCalendar, int i) {
        this.f13315b = materialCalendar;
        this.f13314a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13315b.m.smoothScrollToPosition(this.f13314a);
    }
}
