package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.ScreenshotShareDialog;

/* JADX INFO: compiled from: DialogScreenshotShareBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f17732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f17733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatEditText f17734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f17735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f17736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f17737f;
    protected ScreenshotShareDialog g;

    protected y(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatEditText appCompatEditText, AppCompatImageView appCompatImageView, ImageView imageView, View view2) {
        super(obj, view, i);
        this.f17732a = constraintLayout;
        this.f17733b = constraintLayout2;
        this.f17734c = appCompatEditText;
        this.f17735d = appCompatImageView;
        this.f17736e = imageView;
        this.f17737f = view2;
    }
}
