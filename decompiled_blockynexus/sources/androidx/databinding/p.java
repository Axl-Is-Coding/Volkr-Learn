package androidx.databinding;

import android.annotation.TargetApi;
import android.view.View;

/* JADX INFO: compiled from: ViewDataBinding.java */
/* JADX INFO: loaded from: classes.dex */
class p implements View.OnAttachStateChangeListener {
    p() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @TargetApi(19)
    public void onViewAttachedToWindow(View view) {
        ViewDataBinding.getBinding(view).mRebindRunnable.run();
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
