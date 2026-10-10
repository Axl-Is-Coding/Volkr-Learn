package com.sandbox.login.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: renamed from: com.sandbox.login.c.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginActivityRoleMakeBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2444l extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialCardView f15655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.sandbox.login.view.activity.makerole.b f15656b;

    protected AbstractC2444l(Object obj, View view, int i, MaterialCardView materialCardView) {
        super(obj, view, i);
        this.f15655a = materialCardView;
    }

    public abstract void a(com.sandbox.login.view.activity.makerole.b bVar);
}
