package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends FloatingActionButton.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f13177a;

    e(f fVar) {
        this.f13177a = fVar;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void b(FloatingActionButton floatingActionButton) {
        this.f13177a.f13179b.dispatchAnimationEnd();
    }
}
