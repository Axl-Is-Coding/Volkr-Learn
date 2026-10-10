package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.DisScrollRecylerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameGuessDataListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0646lg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisScrollRecylerView f8556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8557b;

    protected AbstractC0646lg(Object obj, View view, int i, DisScrollRecylerView disScrollRecylerView) {
        super(obj, view, i);
        this.f8556a = disScrollRecylerView;
    }
}
