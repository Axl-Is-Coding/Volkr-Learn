package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatorSet f13701b;

    public ExpandableTransformationBehavior() {
    }

    protected abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f13701b != null;
        if (z3) {
            this.f13701b.cancel();
        }
        this.f13701b = b(view, view2, z, z3);
        this.f13701b.addListener(new b(this));
        this.f13701b.start();
        if (!z2) {
            this.f13701b.end();
        }
        return true;
    }
}
