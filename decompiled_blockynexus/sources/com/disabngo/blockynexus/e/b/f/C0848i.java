package com.disabngo.blockynexus.e.b.f;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.PhoneBindForm;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.f.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindPhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0848i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9759a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f9761c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.f.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9756a.h();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9762d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.f.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9755a.f();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<String> f9763e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.f.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9753a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<String> f9764f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.f.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9754a.b((String) obj);
        }
    });
    public ObservableField<Boolean> g = new ObservableField<>(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PhoneBindForm f9760b = new PhoneBindForm();

    public C0848i(Context context) {
        this.f9759a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        new C0845f().a(this.f9759a, this.f9760b, StringConstant.BIND_PHONE, new C0847h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f9760b.getPhone() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9759a, R.string.bind_phone_phone_hint);
        } else {
            this.g.set(true);
            new C0845f().a(this.f9759a, this.f9760b.getPhone(), StringConstant.BIND_PHONE, new C0846g(this));
        }
    }

    public /* synthetic */ void a(String str) {
        this.f9760b.setPhone(str);
    }

    public /* synthetic */ void b(String str) {
        this.f9760b.setVerifyCode(str);
    }
}
