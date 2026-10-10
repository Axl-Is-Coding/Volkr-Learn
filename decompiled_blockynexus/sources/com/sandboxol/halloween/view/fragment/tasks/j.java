package com.sandboxol.halloween.view.fragment.tasks;

import android.content.Context;
import com.sandboxol.center.view.widget.counDownView.CountDownManager;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: TasksViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f18750b;

    public j(Context context) {
        this.f18749a = context;
        this.f18750b = new f(context, R.string.halloween_no_task);
        new i(this, 500L, 1000L).start();
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        CountDownManager.getInstance().unRegisterAll();
    }
}
