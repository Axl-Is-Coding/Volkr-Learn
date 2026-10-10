package com.sandboxol.game.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.scrapanim.ScrapAnimItemViewModel;
import com.sandboxol.center.view.widget.ScrapLevelImageView;

/* JADX INFO: compiled from: ItemScrapAnimBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class G extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrapLevelImageView f17650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ScrapAnimItemViewModel f17651b;

    protected G(Object obj, View view, int i, ScrapLevelImageView scrapLevelImageView) {
        super(obj, view, i);
        this.f17650a = scrapLevelImageView;
    }
}
