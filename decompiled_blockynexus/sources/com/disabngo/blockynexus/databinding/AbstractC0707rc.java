package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.ScrapReceivedAnimDialog;
import com.opensource.svgaplayer.SVGAImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapReceivedAnimBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0707rc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f8755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SVGAImageView f8756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ScrapReceivedAnimDialog f8757c;

    protected AbstractC0707rc(Object obj, View view, int i, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.f8755a = constraintLayout;
        this.f8756b = sVGAImageView;
    }

    public abstract void a(ScrapReceivedAnimDialog scrapReceivedAnimDialog);
}
