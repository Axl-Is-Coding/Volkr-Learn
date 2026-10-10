package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogPartyFriendInfoBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0531bc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f8188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f8189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f8190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatRadioButton f8191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RelativeLayout f8192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8193f;
    public final TextView g;
    protected com.disabngo.blockynexus.view.dialog.partyfriend.j h;

    protected AbstractC0531bc(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8188a = linearLayout;
        this.f8189b = linearLayout2;
        this.f8190c = appCompatRadioButton;
        this.f8191d = appCompatRadioButton2;
        this.f8192e = relativeLayout;
        this.f8193f = textView;
        this.g = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.partyfriend.j jVar);
}
