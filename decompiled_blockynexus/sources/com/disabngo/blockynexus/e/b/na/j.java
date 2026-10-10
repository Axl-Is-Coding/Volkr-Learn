package com.disabngo.blockynexus.e.b.na;

import android.app.Activity;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeInviteFriendViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9982b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f9986f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9983c = new ObservableField<>(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableArrayList<String> f9984d = new ObservableArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f9985e = new e();
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.na.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9971a.f();
        }
    });

    public j(Activity activity, boolean z) {
        this.f9981a = activity;
        this.f9982b = z;
        this.f9986f = new g(activity, R.string.chat_friend_is_empty, this.f9984d, this.f9983c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f9984d.size() == 0) {
            AppToastUtils.showShortNegativeTipToast(this.f9981a, R.string.update_info_please_choose);
        } else if (this.f9984d.size() > 20) {
            AppToastUtils.showShortNegativeTipToast(this.f9981a, R.string.tribe_invite_failure);
        } else {
            new EditTextDialog(this.f9981a).c(this.f9981a.getString(R.string.tribe_invite_friend)).b(this.f9981a.getString(R.string.tribe_invite_friend_msg)).a(new h(this)).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Activity activity = this.f9981a;
        ObservableArrayList<String> observableArrayList = this.f9984d;
        TribeApi.inviteFriend(activity, (String[]) observableArrayList.toArray(new String[observableArrayList.size()]), str, new i(this));
    }
}
