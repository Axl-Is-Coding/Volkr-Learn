package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: NavigationView.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NavigationView f13577a;

    b(NavigationView navigationView) {
        this.f13577a = navigationView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        NavigationView navigationView = this.f13577a;
        navigationView.getLocationOnScreen(navigationView.tmpLocation);
        boolean z = this.f13577a.tmpLocation[1] == 0;
        this.f13577a.presenter.b(z);
        this.f13577a.setDrawTopInsetForeground(z);
        Context context = this.f13577a.getContext();
        if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Activity activity = (Activity) context;
        this.f13577a.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == this.f13577a.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
    }
}
