package androidx.core.d;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.d.f;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Callable<f.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f1068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f1070d;

    b(Context context, a aVar, int i, String str) {
        this.f1067a = context;
        this.f1068b = aVar;
        this.f1069c = i;
        this.f1070d = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f.c call() throws Exception {
        f.c cVarA = f.a(this.f1067a, this.f1068b, this.f1069c);
        Typeface typeface = cVarA.f1086a;
        if (typeface != null) {
            f.f1074a.put(this.f1070d, typeface);
        }
        return cVarA;
    }
}
