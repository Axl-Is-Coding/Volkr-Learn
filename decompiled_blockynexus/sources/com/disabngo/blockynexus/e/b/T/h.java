package com.disabngo.blockynexus.e.b.T;

import android.content.Context;
import android.view.View;
import com.disabngo.blockynexus.e.b.f.C0845f;
import com.disabngo.blockynexus.view.dialog.Va;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PhoneBindForm;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: PhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9456c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.T.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9448a.f();
        }
    });

    public h(Context context) {
        this.f9454a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        new Va(this.f9454a, new com.disabngo.blockynexus.interfaces.b() { // from class: com.disabngo.blockynexus.e.b.T.d
            @Override // com.disabngo.blockynexus.interfaces.b
            public final void a(String str) {
                this.f9451a.a(str);
            }
        }, new View.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.T.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9450a.a(view);
            }
        }, null, new View.OnClickListener() { // from class: com.disabngo.blockynexus.e.b.T.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9449a.b(view);
            }
        }).show();
    }

    private void h() {
        new C0845f().a(this.f9454a, AccountCenter.newInstance().telephone.get(), StringConstant.UNBIND_PHONE, new f(this));
    }

    private void i() {
        PhoneBindForm phoneBindForm = new PhoneBindForm();
        phoneBindForm.setPhone(AccountCenter.newInstance().telephone.get());
        phoneBindForm.setVerifyCode(this.f9455b);
        new C0845f().a(this.f9454a, phoneBindForm, StringConstant.UNBIND_PHONE, new g(this));
    }

    public /* synthetic */ void b(View view) {
        i();
    }

    public /* synthetic */ void a(String str) {
        this.f9455b = str;
    }

    public /* synthetic */ void a(View view) {
        h();
    }
}
