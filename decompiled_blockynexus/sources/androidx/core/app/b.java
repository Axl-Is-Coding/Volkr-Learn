package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.q;

/* JADX INFO: compiled from: ActivityCompat.java */
/* JADX INFO: loaded from: classes.dex */
class b implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ActivityCompat.d f968b;

    b(ActivityCompat.d dVar, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f968b = dVar;
        this.f967a = onSharedElementsReadyListener;
    }
}
