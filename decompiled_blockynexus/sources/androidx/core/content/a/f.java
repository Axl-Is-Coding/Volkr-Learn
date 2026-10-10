package androidx.core.content.a;

import android.graphics.Typeface;
import androidx.core.content.a.h;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Typeface f1055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h.a f1056b;

    f(h.a aVar, Typeface typeface) {
        this.f1056b = aVar;
        this.f1055a = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1056b.a(this.f1055a);
    }
}
