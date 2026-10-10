package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scrapanim.ScrapReceivedAnimDialog;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogScrapAnimBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataRecyclerView f17702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f17703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ScrapReceivedAnimDialog f17704c;

    protected o(Object obj, View view, int i, DataRecyclerView dataRecyclerView, ImageView imageView) {
        super(obj, view, i);
        this.f17702a = dataRecyclerView;
        this.f17703b = imageView;
    }

    public abstract void a(ScrapReceivedAnimDialog scrapReceivedAnimDialog);
}
