package androidx.databinding;

import android.view.Choreographer;

/* JADX INFO: compiled from: ViewDataBinding.java */
/* JADX INFO: loaded from: classes.dex */
class r implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewDataBinding f1366a;

    r(ViewDataBinding viewDataBinding) {
        this.f1366a = viewDataBinding;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.f1366a.mRebindRunnable.run();
    }
}
