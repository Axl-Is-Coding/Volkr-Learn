package com.disabngo.blockynexus.e.b.j;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.CashApplyInfo;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: CashApplyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9851a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f9853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f9854d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.j.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9843a.f();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<String> f9855e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.h
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9849a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand<String> f9856f = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9845a.b((String) obj);
        }
    });
    public ReplyCommand<String> g = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.g
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9848a.c((String) obj);
        }
    });
    public ReplyCommand<String> h = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9846a.d((String) obj);
        }
    });
    public ReplyCommand<String> i = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9844a.e((String) obj);
        }
    });
    public ReplyCommand<String> j = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9842a.f((String) obj);
        }
    });
    public ReplyCommand<String> k = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.j.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9847a.g((String) obj);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CashApplyInfo f9852b = new CashApplyInfo();

    public k(Context context, double d2) {
        this.f9851a = context;
        this.f9853c = d2;
    }

    public /* synthetic */ void c(String str) {
        this.f9852b.setEmail(str);
    }

    public /* synthetic */ void d(String str) {
        this.f9852b.setCity(str);
    }

    public /* synthetic */ void e(String str) {
        this.f9852b.setCountry(str);
    }

    public /* synthetic */ void f(String str) {
        this.f9852b.setBankAccount(str);
    }

    public /* synthetic */ void g(String str) {
        this.f9852b.setBankName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CashApplyInfo cashApplyInfo = this.f9852b;
        if (cashApplyInfo == null || this.f9853c == 0.0d || TextUtils.isEmpty(cashApplyInfo.getFirstName()) || TextUtils.isEmpty(this.f9852b.getLastName()) || TextUtils.isEmpty(this.f9852b.getEmail()) || TextUtils.isEmpty(this.f9852b.getCity()) || TextUtils.isEmpty(this.f9852b.getCountry()) || TextUtils.isEmpty(this.f9852b.getBankName()) || TextUtils.isEmpty(this.f9852b.getBankAccount())) {
            AppToastUtils.showLongNegativeTipToast(this.f9851a, R.string.input_et_not_empty);
            return;
        }
        this.f9852b.setMoney(this.f9853c);
        UserApi.putCashApply(this.f9851a, this.f9852b, new j(this));
        ReportDataAdapter.onEvent(this.f9851a, EventConstant.STAR_CLICK_CASHOUTAPPLY_COT, this.f9853c + "");
    }

    public /* synthetic */ void a(String str) {
        this.f9852b.setFirstName(str);
    }

    public /* synthetic */ void b(String str) {
        this.f9852b.setLastName(str);
    }
}
