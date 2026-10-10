package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.Property;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseMotionStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f13388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f13389c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f13390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.a.h f13391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.android.material.a.h f13392f;

    b(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f13388b = extendedFloatingActionButton;
        this.f13387a = extendedFloatingActionButton.getContext();
        this.f13390d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public final void a(com.google.android.material.a.h hVar) {
        this.f13392f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public final void b(Animator.AnimatorListener animatorListener) {
        this.f13389c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public void d() {
        this.f13390d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public AnimatorSet f() {
        return b(h());
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public final List<Animator.AnimatorListener> g() {
        return this.f13389c;
    }

    public final com.google.android.material.a.h h() {
        com.google.android.material.a.h hVar = this.f13392f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f13391e == null) {
            this.f13391e = com.google.android.material.a.h.a(this.f13387a, e());
        }
        com.google.android.material.a.h hVar2 = this.f13391e;
        androidx.core.f.h.a(hVar2);
        return hVar2;
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public void onAnimationEnd() {
        this.f13390d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public void onAnimationStart(Animator animator) {
        this.f13390d.a(animator);
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public final void a(Animator.AnimatorListener animatorListener) {
        this.f13389c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.q
    public com.google.android.material.a.h b() {
        return this.f13392f;
    }

    AnimatorSet b(com.google.android.material.a.h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.c("opacity")) {
            arrayList.add(hVar.a("opacity", this.f13388b, (Property<ExtendedFloatingActionButton, ?>) View.ALPHA));
        }
        if (hVar.c("scale")) {
            arrayList.add(hVar.a("scale", this.f13388b, (Property<ExtendedFloatingActionButton, ?>) View.SCALE_Y));
            arrayList.add(hVar.a("scale", this.f13388b, (Property<ExtendedFloatingActionButton, ?>) View.SCALE_X));
        }
        if (hVar.c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
            arrayList.add(hVar.a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f13388b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.WIDTH));
        }
        if (hVar.c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            arrayList.add(hVar.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f13388b, (Property<ExtendedFloatingActionButton, ?>) ExtendedFloatingActionButton.HEIGHT));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }
}
