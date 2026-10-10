package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class ja extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ia f17434a;

    public ja(Context context, int i) {
        super(context, Integer.valueOf(i));
        this.f17434a = new ia(context, b(i), i);
    }

    private int b(int i) {
        return i == 0 ? R.string.decorate_dress_me_no_dress : (i == 6 || i == 7) ? R.string.decorate_coming_soon : R.string.decorate_dress_no_dress;
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }
}
