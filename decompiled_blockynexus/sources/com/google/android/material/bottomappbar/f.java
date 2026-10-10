package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends FloatingActionButton.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13179b;

    f(BottomAppBar bottomAppBar, int i) {
        this.f13179b = bottomAppBar;
        this.f13178a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f13179b.getFabTranslationX(this.f13178a));
        floatingActionButton.show(new e(this));
    }
}
