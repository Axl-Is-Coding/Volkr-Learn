package com.sandboxol.file.c;

import com.sandboxol.file.entity.DownloadConfig;
import com.sandboxol.file.entity.DownloadInfo;
import io.reactivex.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import zlc.season.rxdownload3.RxDownload;
import zlc.season.rxdownload3.core.Mission;
import zlc.season.rxdownload3.core.Status;

/* JADX INFO: compiled from: Rxdownload3.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Status> f17570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Status> f17571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.sandboxol.file.b.a f17572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f17574f;
    private long g;
    private int h;
    private int i;

    static /* synthetic */ int h(f fVar) {
        int i = fVar.h;
        fVar.h = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.sandboxol.file.b.a aVar = this.f17572d;
        if (aVar == null || aVar.e() == null) {
            return;
        }
        for (DownloadInfo downloadInfo : this.f17572d.e()) {
            if (downloadInfo != null && !"".equals(downloadInfo.getUrl())) {
                RxDownload.f23659b.a(downloadInfo.getUrl(), false).c();
            }
        }
    }

    @Override // com.sandboxol.file.c.a
    public void c() {
        if (b() != null) {
            b().cancel();
            d();
        }
    }

    @Override // com.sandboxol.file.c.a
    public void a(com.sandboxol.file.b.a aVar, com.sandboxol.file.d.c cVar) {
        x xVarA;
        this.f17572d = aVar;
        this.f17570b = new HashMap();
        this.f17571c = new HashMap();
        aVar.a(DownloadConfig.newInstance());
        int iA = aVar.a();
        if (iA == 1 || iA != 2) {
            xVarA = io.reactivex.android.b.b.a();
        } else {
            xVarA = io.reactivex.f.b.b();
        }
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : aVar.e()) {
            if (downloadInfo.getSaveName().isEmpty()) {
                downloadInfo.setSaveName(com.sandboxol.file.f.b.b(downloadInfo.getUrl()));
            }
            arrayList.add(RxDownload.f23659b.a(new Mission(downloadInfo.getUrl(), downloadInfo.getSaveName(), downloadInfo.getSavePath(), downloadInfo.getRangeFlag(), downloadInfo.getUrl()), false));
        }
        this.i = 0;
        io.reactivex.e.c(arrayList).b(io.reactivex.f.b.b()).a(xVarA).a((f.b.c) new e(this, arrayList, cVar, aVar));
        for (DownloadInfo downloadInfo2 : aVar.e()) {
            RxDownload.f23659b.a(downloadInfo2.getUrl()).c();
        }
    }

    @Override // com.sandboxol.file.c.a
    public void a(com.sandboxol.file.b.a aVar) {
        if (aVar == null || aVar.e() == null) {
            return;
        }
        for (DownloadInfo downloadInfo : aVar.e()) {
            if (downloadInfo != null && !"".equals(downloadInfo.getUrl())) {
                RxDownload.f23659b.a(downloadInfo.getUrl(), true).c();
            }
        }
    }

    @Override // com.sandboxol.file.c.a
    public void a() {
        RxDownload.f23659b.a(true).c();
    }
}
