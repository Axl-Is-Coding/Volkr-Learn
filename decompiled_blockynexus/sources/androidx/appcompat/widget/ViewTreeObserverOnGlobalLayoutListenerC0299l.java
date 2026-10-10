package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.core.view.AbstractC0314b;

/* JADX INFO: renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityChooserView.java */
/* JADX INFO: loaded from: classes.dex */
class ViewTreeObserverOnGlobalLayoutListenerC0299l implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f667a;

    ViewTreeObserverOnGlobalLayoutListenerC0299l(ActivityChooserView activityChooserView) {
        this.f667a = activityChooserView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f667a.isShowingPopup()) {
            if (!this.f667a.isShown()) {
                this.f667a.getListPopupWindow().dismiss();
                return;
            }
            this.f667a.getListPopupWindow().show();
            AbstractC0314b abstractC0314b = this.f667a.mProvider;
            if (abstractC0314b != null) {
                abstractC0314b.a(true);
            }
        }
    }
}
