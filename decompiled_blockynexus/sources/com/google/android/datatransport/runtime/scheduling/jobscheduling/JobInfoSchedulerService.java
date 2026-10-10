package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.q;
import com.google.android.datatransport.runtime.u;

/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        u.a(getApplicationContext());
        q.a aVarA = com.google.android.datatransport.runtime.q.a();
        aVarA.a(string);
        aVarA.a(com.google.android.datatransport.runtime.f.a.a(i));
        if (string2 != null) {
            aVarA.a(Base64.decode(string2, 0));
        }
        u.a().b().a(aVarA.a(), i2, g.a(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
