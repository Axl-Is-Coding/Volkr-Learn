package com.sandboxol.game.a;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scraplist.ScrapListDialog;

/* JADX INFO: compiled from: DialogScrapListBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f17727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f17728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ScrapListDialog f17729d;

    protected w(Object obj, View view, int i, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f17726a = textView;
        this.f17727b = textView2;
        this.f17728c = view2;
    }

    public abstract void a(ScrapListDialog scrapListDialog);
}
