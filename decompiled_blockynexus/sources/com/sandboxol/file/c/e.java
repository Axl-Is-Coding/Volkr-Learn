package com.sandboxol.file.c;

import android.util.Log;
import com.sandboxol.file.entity.Progress;
import java.math.BigDecimal;
import java.util.List;
import zlc.season.rxdownload3.core.Failed;
import zlc.season.rxdownload3.core.Status;
import zlc.season.rxdownload3.core.Succeed;

/* JADX INFO: compiled from: Rxdownload3.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements f.b.c<Status> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Progress f17565a = new Progress();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f17566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.d.c f17567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.a f17568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ f f17569e;

    e(f fVar, List list, com.sandboxol.file.d.c cVar, com.sandboxol.file.b.a aVar) {
        this.f17569e = fVar;
        this.f17566b = list;
        this.f17567c = cVar;
        this.f17568d = aVar;
    }

    @Override // f.b.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Status status) {
        if (status instanceof Failed) {
            onError(((Failed) status).e());
            return;
        }
        if (status instanceof Succeed) {
            this.f17569e.f17571c.put(status.c(), status);
            Log.d("Rxdownload3", "----Succeed----");
            if (this.f17566b.size() == this.f17569e.f17571c.size()) {
                Log.d("Rxdownload3", "----Succeed----" + this.f17569e.f17571c.size());
                onComplete();
                return;
            }
            return;
        }
        this.f17569e.f17570b.put(status.c(), status);
        long jB = 0;
        long jD = 0;
        for (Status status2 : this.f17569e.f17570b.values()) {
            jD += status2.d();
            jB += status2.b();
        }
        this.f17565a.setSize(Long.valueOf(jB), Long.valueOf(jD));
        this.f17565a.setUrl(status.c());
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.f17569e.f17573e;
        this.f17565a.setDownloadTime(j);
        double d2 = jB;
        double downloadTime = ((double) this.f17565a.getDownloadTime()) == 0.0d ? 1.0d : this.f17565a.getDownloadTime();
        Double.isNaN(d2);
        double dDoubleValue = new BigDecimal(d2 / downloadTime).setScale(2, 4).doubleValue();
        this.f17565a.setDownloadRate(dDoubleValue);
        int i = (int) ((100 * jB) / jD);
        if (this.f17569e.i != i) {
            this.f17569e.i = i;
            this.f17567c.onNext(this.f17565a);
        }
        if (j > this.f17568d.b().getStartCountingTime() && dDoubleValue > this.f17569e.f17574f) {
            this.f17569e.f17574f = dDoubleValue;
            this.f17569e.g = jCurrentTimeMillis;
        }
        if (this.f17569e.f17574f / dDoubleValue > this.f17568d.b().getRateMultiple() && jCurrentTimeMillis - this.f17569e.g <= this.f17568d.b().getSlowPeriod() && this.f17569e.h < this.f17568d.b().getReconnectCount()) {
            f.h(this.f17569e);
            this.f17569e.b().cancel();
            Log.d("testDownload recount", this.f17569e.h + "");
            this.f17569e.a(this.f17568d, this.f17567c);
        }
        Log.d("testDownload recount", " , size : " + jB + " , time : " + j + " , rate : " + dDoubleValue);
    }

    @Override // f.b.c
    public void onComplete() {
        this.f17569e.b().cancel();
        this.f17567c.onComplete(this.f17565a);
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        this.f17569e.d();
        this.f17569e.b().cancel();
        this.f17567c.onError(th);
    }

    @Override // f.b.c
    public void onSubscribe(f.b.d dVar) {
        this.f17569e.a(dVar);
        dVar.request(Long.MAX_VALUE);
        this.f17569e.f17573e = System.currentTimeMillis();
    }
}
