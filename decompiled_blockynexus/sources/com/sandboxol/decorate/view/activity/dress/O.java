package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressShopPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class O extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public N f17245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17246b;

    public O(Context context, int i) {
        super(context, Integer.valueOf(i));
        this.f17245a = new N(context, f(), i);
        this.f17246b = i;
    }

    private int f() {
        return R.string.decorate_dress_no_dress;
    }
}
