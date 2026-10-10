package com.disabngo.blockynexus.e.b.i;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.j.i;
import com.disabngo.blockynexus.e.b.k.C0861a;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import java.util.ArrayList;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: CashViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VideoStarConfig f9820b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f9824f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9821c = new ObservableField<>(Integer.valueOf(R.id.rb_item_1));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9822d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Double> f9823e = new ObservableField<>(Double.valueOf(0.0d));
    public f g = new f();
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.i.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9816a.f();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.i.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9817a.h();
        }
    });
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> j = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.i.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9815a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public h(Context context, VideoStarConfig videoStarConfig) {
        this.f9819a = context;
        this.f9820b = videoStarConfig;
        this.f9824f = new g(context, videoStarConfig.getAnswering());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (AccountCenter.newInstance().starCodeUserDisable.get().intValue() != 0) {
            AppToastUtils.showShortNegativeTipToast(this.f9819a, R.string.cash_out_freeze);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble(StringConstant.CASH_AMOUNT, this.f9823e.get().doubleValue());
        Context context = this.f9819a;
        TemplateUtils.startTemplate(context, i.class, context.getString(R.string.fragment_cash_apply_tv_title), bundle);
        ReportDataAdapter.onEvent(this.f9819a, EventConstant.STAR_CLICK_CODECASHOUT_COT, this.f9823e + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Bundle bundle = new Bundle();
        VideoStarConfig videoStarConfig = this.f9820b;
        if (videoStarConfig != null && videoStarConfig.getIntroduce() != null) {
            bundle.putParcelableArrayList(StringConstant.STAR_CONFIG, (ArrayList) this.f9820b.getIntroduce());
        }
        Context context = this.f9819a;
        TemplateUtils.startTemplate(context, C0861a.class, context.getString(R.string.description), bundle);
        ReportDataAdapter.onEvent(this.f9819a, EventConstant.STAR_CLICK_CODECASHOUT_QMARK);
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        this.f9821c.set(Integer.valueOf(checkedDataWrapper.getCheckedId()));
        if (checkedDataWrapper.getCheckedId() == R.id.rb_item_1) {
            this.f9823e.set(Double.valueOf(100.0d));
        } else if (checkedDataWrapper.getCheckedId() == R.id.rb_item_2) {
            this.f9823e.set(Double.valueOf(500.0d));
        } else if (checkedDataWrapper.getCheckedId() == R.id.rb_item_3) {
            this.f9823e.set(Double.valueOf(1000.0d));
        }
    }
}
