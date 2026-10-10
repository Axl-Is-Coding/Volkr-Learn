package androidx.appcompat.widget;

import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionBarOverlayLayout.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0292e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f641a;

    RunnableC0292e(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f641a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f641a.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f641a;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(WheelView.DividerConfig.FILL).setListener(this.f641a.mTopAnimatorListener);
    }
}
