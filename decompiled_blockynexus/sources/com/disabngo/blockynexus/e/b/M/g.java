package com.disabngo.blockynexus.e.b.M;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: IncomeViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f9355c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9357e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Double> f9358f = new ObservableField<>(Double.valueOf(0.0d));
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.M.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9347a.f();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f9356d = new c();

    public g(Context context) {
        this.f9353a = context;
        this.f9355c = new f(context, this.f9358f, R.string.no_data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ReportDataAdapter.onEvent(this.f9353a, EventConstant.STAR_CLICK_BALANCE_SHARECODE);
        if (AccountCenter.newInstance().starCodeUserDisable.get().intValue() != 0) {
            AppToastUtils.showShortNegativeTipToast(this.f9353a, R.string.income_shared_freeze);
            return;
        }
        this.f9354b = AccountCenter.newInstance().starCode.get();
        if (TextUtils.isEmpty(this.f9354b)) {
            return;
        }
        c cVar = this.f9356d;
        Context context = this.f9353a;
        if (cVar.a(context, context.getString(R.string.income_tv_paste_tip, this.f9354b))) {
            ReportDataAdapter.onEvent(this.f9353a, EventConstant.STAR_CLICK_BALANCE_SHARECODE_SUC);
            AppToastUtils.showShortPositiveTipToast(this.f9353a, R.string.income_tv_copy_tip);
        }
    }
}
