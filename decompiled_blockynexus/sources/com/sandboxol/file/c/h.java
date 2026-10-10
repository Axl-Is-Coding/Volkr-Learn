package com.sandboxol.file.c;

import android.content.SharedPreferences;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.file.entity.DownloadConfig;
import com.sandboxol.file.entity.DownloadInfo;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.reactivex.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Rxdownload4.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, zlc.season.rxdownload4.a.a> f17580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f17583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17584f;
    private int g;
    private boolean h;
    private double i;
    private int j;
    private final double k = 1.5d;
    private boolean l;

    static /* synthetic */ int k(h hVar) {
        int i = hVar.g;
        hVar.g = i + 1;
        return i;
    }

    @Override // com.sandboxol.file.c.a
    public void c() {
        if (b() != null) {
            b().cancel();
        }
    }

    @Override // com.sandboxol.file.c.a
    public void a(com.sandboxol.file.b.a aVar, com.sandboxol.file.d.c cVar) {
        x xVarA;
        io.reactivex.e eVarA;
        long j;
        this.f17580b = new HashMap();
        this.f17581c = System.currentTimeMillis();
        this.f17584f = this.f17581c;
        this.f17583e = 0.0d;
        this.f17582d = 0L;
        this.h = false;
        this.i = 0.0d;
        aVar.a(DownloadConfig.newInstance());
        int iA = aVar.a();
        if (iA == 1 || iA != 2) {
            xVarA = io.reactivex.android.b.b.a();
        } else {
            xVarA = io.reactivex.f.b.b();
        }
        ArrayList arrayList = new ArrayList();
        if (aVar.e() != null && aVar.e().length != 0) {
            long size = 0;
            for (DownloadInfo downloadInfo : aVar.e()) {
                size += downloadInfo.getSize();
            }
            double d2 = size;
            Double.isNaN(d2);
            if (d2 * 1.5d > CommonHelper.getLessMemorySize()) {
                cVar.onError(new Throwable("no space left on device"));
                return;
            }
            int i = this.g;
            if (i > 0) {
                com.sandboxol.file.f.a.a(i, aVar.e());
            }
            for (DownloadInfo downloadInfo2 : aVar.e()) {
                if (downloadInfo2.getSaveName().isEmpty()) {
                    downloadInfo2.setSaveName(com.sandboxol.file.f.b.b(downloadInfo2.getUrl()));
                }
                zlc.season.rxdownload4.a.a.a aVar2 = new zlc.season.rxdownload4.a.a.a(downloadInfo2.getUrl(), downloadInfo2.getSaveName(), downloadInfo2.getSaveName(), downloadInfo2.getSavePath());
                if (downloadInfo2.getSize() != 0) {
                    double size2 = downloadInfo2.getSize();
                    Double.isNaN(size2);
                    j = 4609434218613702656L;
                    if (size2 * 1.5d > CommonHelper.getLessMemorySize()) {
                        cVar.onError(new Throwable("no space left on device"));
                        return;
                    }
                    arrayList.add(zlc.season.rxdownload4.a.b.a(aVar2, zlc.season.rxdownload4.a.b.b(), 5, (downloadInfo2.getSize() + 5) / 5));
                } else {
                    j = 4609434218613702656L;
                    arrayList.add(zlc.season.rxdownload4.a.b.a(aVar2));
                }
            }
            if (aVar.f() == 2) {
                eVarA = io.reactivex.e.c(arrayList);
            } else {
                eVarA = io.reactivex.e.a((Iterable) arrayList);
            }
            this.j = 0;
            eVarA.b(io.reactivex.f.b.b()).a(xVarA).a((f.b.c) new g(this, cVar, arrayList, aVar));
            return;
        }
        cVar.onError(new Throwable("DownloadBuilder.getInfo() == null || DownloadBuilder.getInfo().length == 0"));
    }

    @Override // com.sandboxol.file.c.a
    public void a(com.sandboxol.file.b.a aVar) {
        if (aVar == null || aVar.e() == null) {
            return;
        }
        for (DownloadInfo downloadInfo : aVar.e()) {
            if (downloadInfo != null && !"".equals(downloadInfo.getUrl())) {
                zlc.season.rxdownload4.a.b.a(downloadInfo.getUrl());
            }
        }
    }

    @Override // com.sandboxol.file.c.a
    public void a() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("rxdownload_simple_storage", 0);
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null) {
            Iterator<?> it = all.values().iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().toString().split(UMCustomLogInfoBuilder.LINE_SEP);
                if (strArrSplit.length >= 2) {
                    String str = strArrSplit[1];
                    String str2 = strArrSplit[2];
                    if (!com.sandboxol.file.f.b.a(str2 + "/" + str)) {
                        com.sandboxol.file.f.b.a(str2 + "/" + str + ".download");
                        com.sandboxol.file.f.b.a(str2 + "/" + str + ".tmp");
                    }
                }
            }
            sharedPreferences.edit().clear().apply();
        }
    }
}
