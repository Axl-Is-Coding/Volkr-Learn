package com.sandboxol.file.g;

import com.sandboxol.file.d.g;
import com.sandboxol.file.entity.VerifyInfo;
import io.reactivex.BackpressureStrategy;
import io.reactivex.x;

/* JADX INFO: compiled from: BlockyVerify.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b {
    @Override // com.sandboxol.file.g.b
    public void a(final com.sandboxol.file.b.c cVar, g gVar) {
        int iA = cVar.a();
        x xVarA = (iA == 1 || iA != 2) ? io.reactivex.android.b.b.a() : io.reactivex.f.b.b();
        if (cVar.b() == null || cVar.b().length == 0) {
            gVar.error(new Throwable("VerifyBuilder.getInfo() == null || VerifyBuilder.getInfo().length == 0"));
        } else {
            io.reactivex.e.a(new io.reactivex.g() { // from class: com.sandboxol.file.g.a
                @Override // io.reactivex.g
                public final void a(io.reactivex.f fVar) throws Exception {
                    d.a(cVar, fVar);
                }
            }, BackpressureStrategy.ERROR).b(io.reactivex.f.b.b()).a(xVarA).a((f.b.c) new c(this, gVar));
        }
    }

    @Override // com.sandboxol.file.g.b
    public void b() {
        if (a() != null) {
            a().cancel();
        }
    }

    static /* synthetic */ void a(com.sandboxol.file.b.c cVar, io.reactivex.f fVar) throws Exception {
        for (VerifyInfo verifyInfo : cVar.b()) {
            fVar.onNext(Boolean.valueOf(com.sandboxol.file.f.b.a(verifyInfo.getCode(), verifyInfo.getFileDir(), verifyInfo.getFileName())));
        }
        fVar.onComplete();
    }
}
