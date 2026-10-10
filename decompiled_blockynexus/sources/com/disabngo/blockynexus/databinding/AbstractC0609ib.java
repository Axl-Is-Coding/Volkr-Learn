package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.videotag.VideoTagPopupWindowDialog;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ib, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppVideoTagBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0609ib extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f8439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f8440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataRecyclerView f8441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f8442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f8443f;
    public final AppCompatTextView g;
    public final View h;
    protected VideoTagPopupWindowDialog i;

    protected AbstractC0609ib(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, DataRecyclerView dataRecyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view2) {
        super(obj, view, i);
        this.f8438a = constraintLayout;
        this.f8439b = constraintLayout2;
        this.f8440c = linearLayout;
        this.f8441d = dataRecyclerView;
        this.f8442e = appCompatTextView;
        this.f8443f = appCompatTextView2;
        this.g = appCompatTextView3;
        this.h = view2;
    }

    public abstract void a(VideoTagPopupWindowDialog videoTagPopupWindowDialog);
}
