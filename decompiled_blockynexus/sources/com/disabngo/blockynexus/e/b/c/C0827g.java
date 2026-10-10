package com.disabngo.blockynexus.e.b.c;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.c.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0827g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0826f f9680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0824d f9681c = new C0824d();

    public C0827g(Activity activity) {
        this.f9679a = activity;
        this.f9680b = new C0826f(activity, R.string.no_data);
        initView();
        initMessenger();
    }

    private void initView() {
    }

    protected void initMessenger() {
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
