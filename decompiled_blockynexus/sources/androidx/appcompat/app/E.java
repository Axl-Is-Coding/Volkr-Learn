package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.core.view.H;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: WindowDecorActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class E extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WindowDecorActionBar f253a;

    E(WindowDecorActionBar windowDecorActionBar) {
        this.f253a = windowDecorActionBar;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        View view2;
        WindowDecorActionBar windowDecorActionBar = this.f253a;
        if (windowDecorActionBar.x && (view2 = windowDecorActionBar.k) != null) {
            view2.setTranslationY(WheelView.DividerConfig.FILL);
            this.f253a.h.setTranslationY(WheelView.DividerConfig.FILL);
        }
        this.f253a.h.setVisibility(8);
        this.f253a.h.setTransitioning(false);
        WindowDecorActionBar windowDecorActionBar2 = this.f253a;
        windowDecorActionBar2.C = null;
        windowDecorActionBar2.m();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f253a.g;
        if (actionBarOverlayLayout != null) {
            ViewCompat.H(actionBarOverlayLayout);
        }
    }
}
