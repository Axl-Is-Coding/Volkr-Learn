package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressShopSuitPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class Z extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Y f17269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17270b;

    public Z(Context context, int i, int i2) {
        super(context, Integer.valueOf(i));
        this.f17269a = new Y(context, f(), i, i2);
        this.f17270b = i;
    }

    private int f() {
        return R.string.decorate_dress_no_dress;
    }
}
