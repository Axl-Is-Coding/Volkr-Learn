package com.sandboxol.vip.b;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: VipFragmentPrivilegeDetailBinding.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f19008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatRadioButton f19009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatRadioButton f19010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatRadioButton f19011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatRadioButton f19012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatRadioButton f19013f;
    public final AppCompatRadioButton g;
    public final AppCompatRadioButton h;
    public final AppCompatRadioButton i;
    public final AppCompatRadioButton j;
    public final AppCompatRadioButton k;
    public final RadioGroup l;
    public final TabLayout m;
    public final ViewPager n;
    protected com.sandboxol.vip.d.b.a.h o;

    protected o(Object obj, View view, int i, Button button, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, AppCompatRadioButton appCompatRadioButton3, AppCompatRadioButton appCompatRadioButton4, AppCompatRadioButton appCompatRadioButton5, AppCompatRadioButton appCompatRadioButton6, AppCompatRadioButton appCompatRadioButton7, AppCompatRadioButton appCompatRadioButton8, AppCompatRadioButton appCompatRadioButton9, AppCompatRadioButton appCompatRadioButton10, RadioGroup radioGroup, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.f19008a = button;
        this.f19009b = appCompatRadioButton;
        this.f19010c = appCompatRadioButton2;
        this.f19011d = appCompatRadioButton3;
        this.f19012e = appCompatRadioButton4;
        this.f19013f = appCompatRadioButton5;
        this.g = appCompatRadioButton6;
        this.h = appCompatRadioButton7;
        this.i = appCompatRadioButton8;
        this.j = appCompatRadioButton9;
        this.k = appCompatRadioButton10;
        this.l = radioGroup;
        this.m = tabLayout;
        this.n = viewPager;
    }

    public abstract void a(com.sandboxol.vip.d.b.a.h hVar);
}
