package com.sandbox.login.f.a.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import rx.functions.Action0;

/* JADX INFO: compiled from: AccountRecordItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ListItemViewModel<UserRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f15862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Boolean> f15863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f15864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f15865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f15866e;

    public m(Context context, ObservableField<String> observableField, UserRecord userRecord) {
        super(context, userRecord);
        this.f15863b = new ObservableField<>(false);
        this.f15864c = new ObservableField<>("");
        this.f15865d = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.e.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f15846a.h();
            }
        });
        this.f15866e = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.e.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f15847a.f();
            }
        });
        this.f15862a = observableField;
        this.f15863b.addOnPropertyChangedCallback(new i(this, context));
        a(userRecord);
    }

    private void a(UserRecord userRecord) {
        StringBuilder sb = new StringBuilder();
        if (userRecord != null) {
            if (!TextUtils.isEmpty(userRecord.getAccount())) {
                sb.append(this.context.getString(R.string.login_user_name_pre));
                sb.append(userRecord.getAccount());
                sb.append("   ");
            }
            if (!TextUtils.isEmpty(userRecord.getUserId())) {
                sb.append(this.context.getString(R.string.login_id_pre));
                sb.append(userRecord.getUserId());
            }
        }
        this.f15864c.set(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        T t = this.item;
        if (t == 0 || ((UserRecord) t).getUid() == null || ((UserRecord) this.item).getUid().equals(String.valueOf(AccountCenter.newInstance().userId.get())) || ((UserRecord) this.item).getUid().equals(AccountCenter.newInstance().account.get())) {
            return;
        }
        this.f15863b.set(true);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_HISTORY_ID);
        if (TextUtils.isEmpty(((UserRecord) this.item).getPassword()) && !((UserRecord) this.item).getHasPassword()) {
            com.sandbox.login.web.b.c(this.context, new j(this));
            return;
        }
        LoginRegisterAccountForm loginRegisterAccountForm = new LoginRegisterAccountForm();
        loginRegisterAccountForm.setUid(((UserRecord) this.item).getUid());
        loginRegisterAccountForm.setPassword(((UserRecord) this.item).getPassword());
        new y().a(this.context, loginRegisterAccountForm, new l(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f() {
        new q().a(this.context, (UserRecord) this.item, false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public UserRecord getItem() {
        return (UserRecord) super.getItem();
    }
}
