package com.sandboxol.file.c;

import android.util.Log;
import com.sandboxol.file.entity.Progress;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: compiled from: Rxdownload4.java */
/* JADX INFO: loaded from: classes3.dex */
class g implements f.b.c<zlc.season.rxdownload4.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Progress f17575a = new Progress();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.d.c f17576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f17577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.a f17578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ h f17579e;

    g(h hVar, com.sandboxol.file.d.c cVar, List list, com.sandboxol.file.b.a aVar) {
        this.f17579e = hVar;
        this.f17576b = cVar;
        this.f17577c = list;
        this.f17578d = aVar;
    }

    @Override // f.b.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(zlc.season.rxdownload4.a.a aVar) {
        if (this.f17579e.l) {
            this.f17579e.l = false;
            this.f17576b.onSubscribe(null);
        }
        this.f17579e.f17580b.put(aVar.b(), aVar);
        long jA = 0;
        long jC = 0;
        for (zlc.season.rxdownload4.a.a aVar2 : this.f17579e.f17580b.values()) {
            jC += aVar2.c();
            jA += aVar2.a();
        }
        this.f17575a.setUrl(aVar.b());
        this.f17575a.setSize(Long.valueOf(jA), Long.valueOf(jC));
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.f17579e.f17581c;
        this.f17575a.setDownloadTime(j);
        double d2 = jA - this.f17579e.f17582d;
        double d3 = j;
        double d4 = d3 == 0.0d ? 1.0d : d3;
        Double.isNaN(d2);
        double dDoubleValue = new BigDecimal(d2 / d4).setScale(2, 4).doubleValue();
        this.f17575a.setDownloadRate(dDoubleValue);
        int i = (int) ((100 * jA) / jC);
        if (this.f17579e.j != i) {
            this.f17579e.j = i;
            this.f17576b.onNext(this.f17575a);
        }
        if (jA == jC) {
            this.f17576b.onNext(this.f17575a);
        }
        if (this.f17579e.f17580b.size() == this.f17577c.size()) {
            if (!this.f17579e.h) {
                this.f17579e.h = true;
                this.f17579e.f17582d = jA;
            }
            h hVar = this.f17579e;
            double d5 = jA - hVar.f17582d;
            double d6 = d3 == 0.0d ? 1.0d : d3;
            Double.isNaN(d5);
            hVar.i = d5 / d6;
            this.f17579e.i = new BigDecimal(this.f17579e.i).setScale(2, 4).doubleValue();
            if (this.f17579e.i > this.f17579e.f17583e) {
                h hVar2 = this.f17579e;
                hVar2.f17583e = hVar2.i;
                this.f17579e.f17584f = jCurrentTimeMillis;
            }
            if (this.f17579e.i < this.f17578d.b().getAllowedRate() && this.f17579e.f17583e / this.f17579e.i > this.f17578d.b().getRateMultiple() && jCurrentTimeMillis - this.f17579e.f17584f <= this.f17578d.b().getSlowPeriod() && this.f17579e.g < this.f17578d.b().getReconnectCount()) {
                h.k(this.f17579e);
                this.f17579e.b().cancel();
                Log.d("testDownload", this.f17579e.g + "");
                this.f17579e.a(this.f17578d, this.f17576b);
            }
        }
        Log.d(this.f17575a.getUrl().substring(this.f17575a.getUrl().lastIndexOf("/") + 1) + " Progress", this.f17575a.percentStr() + " , startDownloadSize : " + this.f17579e.f17582d + " , downloadSize : " + jA + " , time : " + j + " , rate : " + this.f17579e.i + " , averageRate : " + dDoubleValue);
    }

    @Override // f.b.c
    public void onComplete() {
        if (this.f17579e.l) {
            this.f17579e.l = false;
            this.f17576b.onSubscribe(null);
        }
        this.f17579e.b().cancel();
        this.f17576b.onComplete(this.f17575a);
        Log.d("testDownload onComplete", "onComplete");
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        if (this.f17579e.l) {
            this.f17579e.l = false;
            this.f17576b.onSubscribe(th);
        }
        this.f17579e.b().cancel();
        this.f17576b.onError(th);
        Log.d("testDownload", (th == null || th.getMessage() == null) ? "onError" : th.getMessage());
    }

    @Override // f.b.c
    public void onSubscribe(f.b.d dVar) {
        this.f17579e.a(dVar);
        dVar.request(Long.MAX_VALUE);
        Log.d("testDownload", "onSubscribe");
        this.f17579e.l = true;
    }
}
