package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.tc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRequestBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0729tc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f8822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f8824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Button f8825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f8826f;
    public final ScrapLevelImageView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    protected com.disabngo.blockynexus.view.dialog.g.e l;

    protected AbstractC0729tc(Object obj, View view, int i, View view2, View view3, View view4, Button button, Button button2, ImageView imageView, ScrapLevelImageView scrapLevelImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f8821a = view2;
        this.f8822b = view3;
        this.f8823c = view4;
        this.f8824d = button;
        this.f8825e = button2;
        this.f8826f = imageView;
        this.g = scrapLevelImageView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = textView4;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.g.e eVar);
}
