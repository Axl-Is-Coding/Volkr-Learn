package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: DrawerLayout.java */
/* JADX INFO: loaded from: classes.dex */
class a implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DrawerLayout f1381a;

    a(DrawerLayout drawerLayout) {
        this.f1381a = drawerLayout;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
