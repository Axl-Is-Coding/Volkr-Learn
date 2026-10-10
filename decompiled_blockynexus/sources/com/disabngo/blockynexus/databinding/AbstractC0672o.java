package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.TabRadioButton;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityMainBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0672o extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f8637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f8638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TabRadioButton f8639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TabRadioButton f8640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TabRadioButton f8641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabRadioButton f8642f;
    public final TabRadioButton g;
    public final RadioGroup h;
    public final RelativeLayout i;
    public final RelativeLayout j;
    protected com.disabngo.blockynexus.view.activity.main.nc k;

    protected AbstractC0672o(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, TabRadioButton tabRadioButton, TabRadioButton tabRadioButton2, TabRadioButton tabRadioButton3, TabRadioButton tabRadioButton4, TabRadioButton tabRadioButton5, RadioGroup radioGroup, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.f8637a = frameLayout;
        this.f8638b = imageView;
        this.f8639c = tabRadioButton;
        this.f8640d = tabRadioButton2;
        this.f8641e = tabRadioButton3;
        this.f8642f = tabRadioButton4;
        this.g = tabRadioButton5;
        this.h = radioGroup;
        this.i = relativeLayout;
        this.j = relativeLayout2;
    }

    public abstract void a(com.disabngo.blockynexus.view.activity.main.nc ncVar);
}
