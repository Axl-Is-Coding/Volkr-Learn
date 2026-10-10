package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: compiled from: ScrollingTabContainerView.java */
/* JADX INFO: loaded from: classes.dex */
class P implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScrollingTabContainerView f570b;

    P(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f570b = scrollingTabContainerView;
        this.f569a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f570b.smoothScrollTo(this.f569a.getLeft() - ((this.f570b.getWidth() - this.f569a.getWidth()) / 2), 0);
        this.f570b.mTabSelector = null;
    }
}
