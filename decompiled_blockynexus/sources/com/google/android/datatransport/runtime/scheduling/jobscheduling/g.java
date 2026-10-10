package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* JADX INFO: compiled from: JobInfoSchedulerService.java */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JobInfoSchedulerService f12985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JobParameters f12986b;

    private g(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f12985a = jobInfoSchedulerService;
        this.f12986b = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new g(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12985a.jobFinished(this.f12986b, false);
    }
}
