package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressShopRecommendPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class V extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U f17258a;

    public V(Context context, int i) {
        super(context, Integer.valueOf(i));
        this.f17258a = new U(context, f(), i);
    }

    private int f() {
        return R.string.decorate_dress_no_dress;
    }
}
