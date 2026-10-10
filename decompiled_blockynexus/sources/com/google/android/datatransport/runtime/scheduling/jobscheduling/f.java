package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2220d f12983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SchedulerConfig f12984c;

    public f(Context context, InterfaceC2220d interfaceC2220d, SchedulerConfig schedulerConfig) {
        this.f12982a = context;
        this.f12983b = interfaceC2220d;
        this.f12984c = schedulerConfig;
    }

    int a(com.google.android.datatransport.runtime.q qVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f12982a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(qVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(com.google.android.datatransport.runtime.f.a.a(qVar.d())).array());
        if (qVar.c() != null) {
            adler32.update(qVar.c());
        }
        return (int) adler32.getValue();
    }

    private boolean a(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public void a(com.google.android.datatransport.runtime.q qVar, int i) {
        ComponentName componentName = new ComponentName(this.f12982a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f12982a.getSystemService("jobscheduler");
        int iA = a(qVar);
        if (a(jobScheduler, iA, i)) {
            com.google.android.datatransport.runtime.b.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", qVar);
            return;
        }
        long jA = this.f12983b.a(qVar);
        SchedulerConfig schedulerConfig = this.f12984c;
        JobInfo.Builder builder = new JobInfo.Builder(iA, componentName);
        schedulerConfig.a(builder, qVar.d(), jA, i);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", qVar.b());
        persistableBundle.putInt("priority", com.google.android.datatransport.runtime.f.a.a(qVar.d()));
        if (qVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(qVar.c(), 0));
        }
        builder.setExtras(persistableBundle);
        com.google.android.datatransport.runtime.b.a.a("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", qVar, Integer.valueOf(iA), Long.valueOf(this.f12984c.a(qVar.d(), jA, i)), Long.valueOf(jA), Integer.valueOf(i));
        jobScheduler.schedule(builder.build());
    }
}
