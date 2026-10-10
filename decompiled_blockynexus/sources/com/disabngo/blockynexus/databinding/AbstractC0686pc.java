package com.disabngo.blockynexus.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapReceiveBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0686pc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f8681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrapLevelImageView f8683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f8684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f8685f;
    protected com.disabngo.blockynexus.view.dialog.Fa g;

    protected AbstractC0686pc(Object obj, View view, int i, View view2, View view3, ImageView imageView, ScrapLevelImageView scrapLevelImageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f8680a = view2;
        this.f8681b = view3;
        this.f8682c = imageView;
        this.f8683d = scrapLevelImageView;
        this.f8684e = textView;
        this.f8685f = textView2;
    }

    public abstract void a(com.disabngo.blockynexus.view.dialog.Fa fa);
}
