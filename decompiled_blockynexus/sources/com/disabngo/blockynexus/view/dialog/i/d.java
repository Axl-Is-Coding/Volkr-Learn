package com.disabngo.blockynexus.view.dialog.i;

import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: SignInViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class d extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f11603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f11604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f11605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f11607f;
    public ObservableField<Integer> g;
    public ReplyCommand h;
    public ReplyCommand i;
    public ReplyCommand j;

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
