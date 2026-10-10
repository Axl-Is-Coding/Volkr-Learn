package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressSuitPageViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class pa extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oa f17452a;

    public pa(Context context, int i) {
        super(context, Integer.valueOf(i));
        this.f17452a = new oa(context, R.string.decorate_dress_no_dress, i);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
