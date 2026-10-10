package com.google.android.datatransport.runtime.d;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;

/* JADX INFO: compiled from: SchedulingModule.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    static s a(Context context, InterfaceC2220d interfaceC2220d, SchedulerConfig schedulerConfig, com.google.android.datatransport.runtime.e.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new com.google.android.datatransport.runtime.scheduling.jobscheduling.f(context, interfaceC2220d, schedulerConfig) : new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(context, interfaceC2220d, aVar, schedulerConfig);
    }
}
