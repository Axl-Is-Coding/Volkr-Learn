package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.NestRadioGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentCreatePartyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Cd extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PageRecyclerView f7343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputEditText f7344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextInputLayout f7345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f7346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f7347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f7348f;
    public final AppCompatRadioButton g;
    public final AppCompatRadioButton h;
    public final NestRadioGroup i;
    public final RelativeLayout j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final View o;
    public final View p;
    protected com.disabngo.blockynexus.e.b.S.v q;

    protected Cd(Object obj, View view, int i, PageRecyclerView pageRecyclerView, TextInputEditText textInputEditText, TextInputLayout textInputLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, NestRadioGroup nestRadioGroup, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, View view3) {
        super(obj, view, i);
        this.f7343a = pageRecyclerView;
        this.f7344b = textInputEditText;
        this.f7345c = textInputLayout;
        this.f7346d = imageView;
        this.f7347e = imageView2;
        this.f7348f = linearLayout;
        this.g = appCompatRadioButton;
        this.h = appCompatRadioButton2;
        this.i = nestRadioGroup;
        this.j = relativeLayout;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = view2;
        this.p = view3;
    }

    public abstract void a(com.disabngo.blockynexus.e.b.S.v vVar);
}
