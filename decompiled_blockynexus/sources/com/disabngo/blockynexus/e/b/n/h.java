package com.disabngo.blockynexus.e.b.n;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.ChangeNicknameDialog;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChangeNameViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<ModifyNameFreeResponse> f9966c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9967d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9968e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<String> f9969f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.n.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9956a.a((String) obj);
        }
    });

    public h(Context context) {
        this.f9964a = context;
        new f().a(context, this.f9966c, this.f9967d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (TextUtils.isEmpty(this.f9965b)) {
            AppToastUtils.showShortPositiveTipToast(this.f9964a, R.string.account_nick_name_empty);
        } else if (this.f9965b.length() < 6) {
            AppToastUtils.showShortPositiveTipToast(this.f9964a, R.string.account_nickname_less_6);
        } else {
            new f(this.f9965b).loadData(this.f9964a, new g(this));
        }
    }

    public void f() {
        if (this.f9966c.get() == null) {
            return;
        }
        new ChangeNicknameDialog(this.f9964a, this.f9966c.get()).a(new ChangeNicknameDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.n.c
            @Override // com.disabngo.blockynexus.view.dialog.ChangeNicknameDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9957a.h();
            }
        }).show();
    }

    public /* synthetic */ void a(String str) {
        this.f9965b = str;
    }
}
