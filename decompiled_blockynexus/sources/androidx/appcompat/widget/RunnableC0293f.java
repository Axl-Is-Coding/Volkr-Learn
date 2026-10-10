package androidx.appcompat.widget;

/* JADX INFO: renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionBarOverlayLayout.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0293f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f642a;

    RunnableC0293f(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f642a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f642a.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f642a;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-this.f642a.mActionBarTop.getHeight()).setListener(this.f642a.mTopAnimatorListener);
    }
}
