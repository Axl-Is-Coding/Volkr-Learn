package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* JADX INFO: compiled from: AlarmManagerSchedulerBroadcastReceiver.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f12973a = new b();

    private b() {
    }

    public static Runnable a() {
        return f12973a;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}
