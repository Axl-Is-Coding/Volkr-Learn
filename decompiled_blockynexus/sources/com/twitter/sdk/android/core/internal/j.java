package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.l;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SessionMonitor.java */
/* JADX INFO: loaded from: classes5.dex */
public class j<T extends com.twitter.sdk.android.core.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f20174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f20175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.twitter.sdk.android.core.m<T> f20176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExecutorService f20177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f20178e;

    public j(com.twitter.sdk.android.core.m<T> mVar, ExecutorService executorService, k<T> kVar) {
        this(mVar, new l(), executorService, new a(), kVar);
    }

    public void a(e eVar) {
        eVar.a(new i(this));
    }

    protected void b() {
        Iterator<T> it = this.f20176c.a().values().iterator();
        while (it.hasNext()) {
            this.f20178e.a(it.next());
        }
        this.f20174a.b(this.f20175b.a());
    }

    j(com.twitter.sdk.android.core.m<T> mVar, l lVar, ExecutorService executorService, a aVar, k kVar) {
        this.f20175b = lVar;
        this.f20176c = mVar;
        this.f20177d = executorService;
        this.f20174a = aVar;
        this.f20178e = kVar;
    }

    public void a() {
        if (this.f20176c.b() != null && this.f20174a.a(this.f20175b.a())) {
            this.f20177d.submit(new Runnable() { // from class: com.twitter.sdk.android.core.internal.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20150a.b();
                }
            });
        }
    }

    /* JADX INFO: compiled from: SessionMonitor.java */
    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f20180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Calendar f20181c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        public synchronized boolean a(long j) {
            boolean z = j - this.f20180b > 21600000;
            boolean z2 = !a(j, this.f20180b);
            if (this.f20179a || !(z || z2)) {
                return false;
            }
            this.f20179a = true;
            return true;
        }

        public synchronized void b(long j) {
            this.f20179a = false;
            this.f20180b = j;
        }

        private boolean a(long j, long j2) {
            this.f20181c.setTimeInMillis(j);
            int i = this.f20181c.get(6);
            int i2 = this.f20181c.get(1);
            this.f20181c.setTimeInMillis(j2);
            return i == this.f20181c.get(6) && i2 == this.f20181c.get(1);
        }
    }
}
