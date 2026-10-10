package com.sandboxol.halloween.b;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.counDownView.NormalCountDownView;
import com.sandboxol.halloween.view.fragment.tasks.TasksItemViewModel;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenItemTaskBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class q extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f18632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f18633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f18634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f18635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f18636f;
    public final NormalCountDownView g;
    public final TextView h;
    public final CenterStrokeTextView i;
    public final CenterStrokeTextView j;
    public final TextView k;
    protected TasksItemViewModel l;

    protected q(Object obj, View view, int i, View view2, View view3, View view4, View view5, View view6, ProgressBar progressBar, NormalCountDownView normalCountDownView, TextView textView, CenterStrokeTextView centerStrokeTextView, CenterStrokeTextView centerStrokeTextView2, TextView textView2) {
        super(obj, view, i);
        this.f18631a = view2;
        this.f18632b = view3;
        this.f18633c = view4;
        this.f18634d = view5;
        this.f18635e = view6;
        this.f18636f = progressBar;
        this.g = normalCountDownView;
        this.h = textView;
        this.i = centerStrokeTextView;
        this.j = centerStrokeTextView2;
        this.k = textView2;
    }
}
