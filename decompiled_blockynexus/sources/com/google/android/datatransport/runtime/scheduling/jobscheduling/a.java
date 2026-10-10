package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;

/* JADX INFO: compiled from: AlarmManagerScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2220d f12969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlarmManager f12970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SchedulerConfig f12971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12972e;

    public a(Context context, InterfaceC2220d interfaceC2220d, com.google.android.datatransport.runtime.e.a aVar, SchedulerConfig schedulerConfig) {
        this(context, interfaceC2220d, (AlarmManager) context.getSystemService("alarm"), aVar, schedulerConfig);
    }

    boolean a(Intent intent) {
        return PendingIntent.getBroadcast(this.f12968a, 0, intent, 536870912) != null;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public void a(com.google.android.datatransport.runtime.q qVar, int i) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", qVar.b());
        builder.appendQueryParameter("priority", String.valueOf(com.google.android.datatransport.runtime.f.a.a(qVar.d())));
        if (qVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(qVar.c(), 0));
        }
        Intent intent = new Intent(this.f12968a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (a(intent)) {
            com.google.android.datatransport.runtime.b.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", qVar);
            return;
        }
        long jA = this.f12969b.a(qVar);
        long jA2 = this.f12971d.a(qVar.d(), jA, i);
        com.google.android.datatransport.runtime.b.a.a("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", qVar, Long.valueOf(jA2), Long.valueOf(jA), Integer.valueOf(i));
        this.f12970c.set(3, this.f12972e.getTime() + jA2, PendingIntent.getBroadcast(this.f12968a, 0, intent, 0));
    }

    a(Context context, InterfaceC2220d interfaceC2220d, AlarmManager alarmManager, com.google.android.datatransport.runtime.e.a aVar, SchedulerConfig schedulerConfig) {
        this.f12968a = context;
        this.f12969b = interfaceC2220d;
        this.f12970c = alarmManager;
        this.f12972e = aVar;
        this.f12971d = schedulerConfig;
    }
}
