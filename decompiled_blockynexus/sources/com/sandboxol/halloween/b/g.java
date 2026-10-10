package com.sandboxol.halloween.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.view.dialog.HalloweenTipsDialog;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenDialogTipsBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f18602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f18603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CenterStrokeTextView f18604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected HalloweenTipsDialog f18605e;

    protected g(Object obj, View view, int i, View view2, View view3, TextView textView, CenterStrokeTextView centerStrokeTextView) {
        super(obj, view, i);
        this.f18601a = view2;
        this.f18602b = view3;
        this.f18603c = textView;
        this.f18604d = centerStrokeTextView;
    }

    public abstract void a(HalloweenTipsDialog halloweenTipsDialog);
}
