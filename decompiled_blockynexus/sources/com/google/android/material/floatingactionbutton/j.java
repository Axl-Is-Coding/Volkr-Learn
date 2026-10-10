package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

/* JADX INFO: compiled from: FloatingActionButton.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements FloatingActionButtonImpl.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FloatingActionButton.a f13406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FloatingActionButton f13407b;

    j(FloatingActionButton floatingActionButton, FloatingActionButton.a aVar) {
        this.f13407b = floatingActionButton;
        this.f13406a = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.e
    public void a() {
        this.f13406a.b(this.f13407b);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.e
    public void b() {
        this.f13406a.a(this.f13407b);
    }
}
