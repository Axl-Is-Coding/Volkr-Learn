package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentReportBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ze extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f8092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f8093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f8094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f8095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.disabngo.blockynexus.e.b.Z.f f8096f;

    protected Ze(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView) {
        super(obj, view, i);
        this.f8091a = constraintLayout;
        this.f8092b = constraintLayout2;
        this.f8093c = constraintLayout3;
        this.f8094d = constraintLayout4;
        this.f8095e = textView;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.Z.f fVar);
}
