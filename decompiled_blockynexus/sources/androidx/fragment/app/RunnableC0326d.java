package androidx.fragment.app;

import android.app.Dialog;

/* JADX INFO: renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogFragment.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0326d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogInterfaceOnCancelListenerC0327e f1503a;

    RunnableC0326d(DialogInterfaceOnCancelListenerC0327e dialogInterfaceOnCancelListenerC0327e) {
        this.f1503a = dialogInterfaceOnCancelListenerC0327e;
    }

    @Override // java.lang.Runnable
    public void run() {
        DialogInterfaceOnCancelListenerC0327e dialogInterfaceOnCancelListenerC0327e = this.f1503a;
        Dialog dialog = dialogInterfaceOnCancelListenerC0327e.mDialog;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0327e.onDismiss(dialog);
        }
    }
}
