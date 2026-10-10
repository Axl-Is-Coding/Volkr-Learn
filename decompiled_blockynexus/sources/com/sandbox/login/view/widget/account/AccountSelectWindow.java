package com.sandbox.login.view.widget.account;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.view.activity.login.D;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSelectWindow extends PopupWindow {
    private Context context;
    private Action0 dismissCommand;
    private D loginViewModel;

    public AccountSelectWindow(Context context, final D d2, Action0 action0) {
        this.context = context;
        this.dismissCommand = action0;
        this.loginViewModel = d2;
        initView();
        Messenger.getDefault().register(this, "token.click.account.item", UserRecord.class, new Action1() { // from class: com.sandbox.login.view.widget.account.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16004a.a(d2, (UserRecord) obj);
            }
        });
    }

    private void initView() {
        ViewDataBinding viewDataBindingA = androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.login_account_list_layout, (ViewGroup) null, false);
        viewDataBindingA.setVariable(com.sandbox.login.g.f15905b, new g(this.context));
        setContentView(viewDataBindingA.getRoot());
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
    }

    public /* synthetic */ void a(D d2, UserRecord userRecord) {
        if (userRecord.getID().longValue() != -1) {
            d2.a(userRecord);
        }
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        Action0 action0 = this.dismissCommand;
        if (action0 != null) {
            action0.call();
        }
        Messenger.getDefault().unregister(this);
    }
}
