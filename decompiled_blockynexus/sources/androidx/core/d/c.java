package androidx.core.d;

import android.os.Handler;
import androidx.core.content.a.h;
import androidx.core.d.f;
import androidx.core.d.k;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
class c implements k.a<f.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h.a f1071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f1072b;

    c(h.a aVar, Handler handler) {
        this.f1071a = aVar;
        this.f1072b = handler;
    }

    @Override // androidx.core.d.k.a
    public void a(f.c cVar) {
        if (cVar == null) {
            this.f1071a.a(1, this.f1072b);
            return;
        }
        int i = cVar.f1087b;
        if (i == 0) {
            this.f1071a.a(cVar.f1086a, this.f1072b);
        } else {
            this.f1071a.a(i, this.f1072b);
        }
    }
}
