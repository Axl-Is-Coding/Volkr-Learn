package com.sandboxol.file.e;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.file.entity.UnzipInfo;
import io.reactivex.BackpressureStrategy;
import io.reactivex.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BlockyUnzip.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Progress> f17604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f17605c = 2.5d;

    @Override // com.sandboxol.file.e.d
    public void b() {
        if (a() != null) {
            a().cancel();
        }
    }

    @Override // com.sandboxol.file.e.d
    public void a(final com.sandboxol.file.b.b bVar, com.sandboxol.file.d.e eVar) {
        this.f17604b = new HashMap();
        int iA = bVar.a();
        x xVarA = (iA == 1 || iA != 2) ? io.reactivex.android.b.b.a() : io.reactivex.f.b.b();
        if (bVar.b() == null || bVar.b().length == 0) {
            eVar.error(new Throwable("UnzipBuilder.getInfo() == null || UnzipBuilder.getInfo().length == 0"));
        } else {
            io.reactivex.e.a(new io.reactivex.g() { // from class: com.sandboxol.file.e.a
                @Override // io.reactivex.g
                public final void a(io.reactivex.f fVar) throws Exception {
                    this.f17585a.a(bVar, fVar);
                }
            }, BackpressureStrategy.LATEST).b(io.reactivex.f.b.b()).a(xVarA).a((f.b.c) new e(this, bVar, eVar));
        }
    }

    public /* synthetic */ void a(com.sandboxol.file.b.b bVar, io.reactivex.f fVar) throws Exception {
        for (UnzipInfo unzipInfo : bVar.b()) {
            double fileSize = unzipInfo.getFileSize();
            Double.isNaN(fileSize);
            if (fileSize * 2.5d > CommonHelper.getLessMemorySize()) {
                fVar.onError(new Exception("failed no memory", new Throwable("MemorySize is " + CommonHelper.getLessMemorySize())));
            }
            new j(BaseApplication.getContext(), unzipInfo.getFromDir(), unzipInfo.getToDir() != null ? unzipInfo.getToDir() : unzipInfo.getBaseDir() + unzipInfo.getResultDir(), unzipInfo.getZipName(), unzipInfo.isCheckMd5(), new f(this, fVar, unzipInfo)).a();
        }
        fVar.onComplete();
    }
}
