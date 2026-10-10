package androidx.databinding;

import android.os.Build;

/* JADX INFO: compiled from: ViewDataBinding.java */
/* JADX INFO: loaded from: classes.dex */
class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewDataBinding f1365a;

    q(ViewDataBinding viewDataBinding) {
        this.f1365a = viewDataBinding;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            this.f1365a.mPendingRebind = false;
        }
        ViewDataBinding.processReferenceQueue();
        if (Build.VERSION.SDK_INT < 19 || this.f1365a.mRoot.isAttachedToWindow()) {
            this.f1365a.executePendingBindings();
        } else {
            this.f1365a.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
            this.f1365a.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
        }
    }
}
