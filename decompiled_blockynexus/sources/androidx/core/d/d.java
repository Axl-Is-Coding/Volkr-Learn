package androidx.core.d;

import androidx.core.d.f;
import androidx.core.d.k;
import java.util.ArrayList;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
class d implements k.a<f.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1073a;

    d(String str) {
        this.f1073a = str;
    }

    @Override // androidx.core.d.k.a
    public void a(f.c cVar) {
        synchronized (f.f1076c) {
            ArrayList<k.a<f.c>> arrayList = f.f1077d.get(this.f1073a);
            if (arrayList == null) {
                return;
            }
            f.f1077d.remove(this.f1073a);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).a(cVar);
            }
        }
    }
}
