package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.ScrapBoxDialog;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: compiled from: DialogScrapBoxBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends ViewDataBinding {
    protected ScrapBoxDialog A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Guideline f17714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Guideline f17715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Guideline f17716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Guideline f17717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Guideline f17718e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScrapLevelImageView f17719f;
    public final ScrapLevelImageView g;
    public final ScrapLevelImageView h;
    public final ScrapLevelImageView i;
    public final ScrapLevelImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;
    public final ImageView o;
    public final ProgressBar p;
    public final ProgressBar q;
    public final ProgressBar r;
    public final ProgressBar s;
    public final ProgressBar t;
    public final ProgressBar u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final View z;

    protected s(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ScrapLevelImageView scrapLevelImageView, ScrapLevelImageView scrapLevelImageView2, ScrapLevelImageView scrapLevelImageView3, ScrapLevelImageView scrapLevelImageView4, ScrapLevelImageView scrapLevelImageView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, ProgressBar progressBar5, ProgressBar progressBar6, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.f17714a = guideline;
        this.f17715b = guideline2;
        this.f17716c = guideline3;
        this.f17717d = guideline4;
        this.f17718e = guideline5;
        this.f17719f = scrapLevelImageView;
        this.g = scrapLevelImageView2;
        this.h = scrapLevelImageView3;
        this.i = scrapLevelImageView4;
        this.j = scrapLevelImageView5;
        this.k = imageView;
        this.l = imageView2;
        this.m = imageView3;
        this.n = imageView4;
        this.o = imageView5;
        this.p = progressBar;
        this.q = progressBar2;
        this.r = progressBar3;
        this.s = progressBar4;
        this.t = progressBar5;
        this.u = progressBar6;
        this.v = textView;
        this.w = textView2;
        this.x = textView3;
        this.y = textView4;
        this.z = view2;
    }

    public abstract void a(ScrapBoxDialog scrapBoxDialog);
}
