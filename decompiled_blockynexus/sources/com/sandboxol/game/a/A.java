package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.BedWarScreenshotShareDialog;

/* JADX INFO: compiled from: DialogScreenshotShareForBedWarBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f17632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f17633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f17634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f17635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatEditText f17636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f17637f;
    public final ImageView g;
    public final View h;
    protected BedWarScreenshotShareDialog i;

    protected A(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, ImageView imageView, View view2) {
        super(obj, view, i);
        this.f17632a = constraintLayout;
        this.f17633b = constraintLayout2;
        this.f17634c = constraintLayout3;
        this.f17635d = constraintLayout4;
        this.f17636e = appCompatEditText;
        this.f17637f = appCompatImageView;
        this.g = imageView;
        this.h = view2;
    }
}
