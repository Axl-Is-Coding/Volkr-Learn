package com.sandboxol.halloween.b;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenDialogRulerBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f18596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f18597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CenterStrokeTextView f18598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Guideline f18599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f18600f;
    protected com.sandboxol.halloween.view.dialog.n g;

    protected e(Object obj, View view, int i, View view2, View view3, View view4, CenterStrokeTextView centerStrokeTextView, Guideline guideline, TextView textView) {
        super(obj, view, i);
        this.f18595a = view2;
        this.f18596b = view3;
        this.f18597c = view4;
        this.f18598d = centerStrokeTextView;
        this.f18599e = guideline;
        this.f18600f = textView;
    }

    public abstract void a(com.sandboxol.halloween.view.dialog.n nVar);
}
