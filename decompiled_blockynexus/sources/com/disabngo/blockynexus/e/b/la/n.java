package com.disabngo.blockynexus.e.b.la;

import android.app.Activity;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.adapter.TribeCreateLabelsAdapter;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.Gf;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.view.dialog.TribeCreateDialog;
import com.disabngo.blockynexus.view.widget.LabelsView;
import com.localapi.Tribe;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeCreateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9923b;
    private l g;
    public TribeCreateLabelsAdapter j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f9924c = new ObservableField<>(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f9925d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9926e = new ObservableField<>("");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9927f = new ObservableField<>("");
    private List<String> h = new ArrayList();
    public ObservableField<String> i = new ObservableField<>("0/300");
    public ReplyCommand<String> k = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.la.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9902a.a((String) obj);
        }
    });
    public ReplyCommand<String> l = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.la.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9903a.b((String) obj);
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.la.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9899a.f();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.la.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f9905a.h();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.la.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9900a.i();
        }
    });
    public LabelsView.a p = new LabelsView.a() { // from class: com.disabngo.blockynexus.e.b.la.f
        @Override // com.disabngo.blockynexus.view.widget.LabelsView.a
        public final void a() {
            this.f9904a.j();
        }
    };

    public n(Activity activity, h hVar, Gf gf, boolean z) {
        this.f9922a = activity;
        this.f9923b = z;
        this.j = new TribeCreateLabelsAdapter(activity, this.h);
        this.g = new l(activity, hVar, this.f9924c);
        a(hVar, z);
    }

    public /* synthetic */ void f() {
        l lVar = this.g;
        if (lVar != null) {
            lVar.a();
        }
    }

    public /* synthetic */ void h() {
        if (this.g != null) {
            if (A.b(this.f9926e.get())) {
                AppToastUtils.showShortNegativeTipToast(this.f9922a, R.string.has_illegal_character);
                return;
            }
            if (this.f9926e.get().contains(" ") || this.f9926e.get().contains(UMCustomLogInfoBuilder.LINE_SEP)) {
                AppToastUtils.showShortNegativeTipToast(this.f9922a, R.string.has_new_illegal_character);
                return;
            }
            if (AccountCenter.newInstance().golds.get().longValue() >= Tribe.CREATE_FEE_GOLDS) {
                this.g.a(this.h, this.f9926e.get(), this.f9927f.get(), 2);
            } else {
                new TribeCreateDialog(this.f9922a).setTitleText(R.string.tip).setDetailText(this.f9922a.getString(R.string.tribe_sure_pay_60_diamond)).a(this.f9922a.getString(R.string.tribe_sure_pay_60_diamond_end)).a(new TribeCreateDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.la.c
                    @Override // com.disabngo.blockynexus.view.dialog.TribeCreateDialog.OnTwoButtonDialogClickListener
                    public final void onClick() {
                        this.f9901a.k();
                    }
                }).show();
            }
            ReportDataAdapter.onEvent(this.f9922a, EventConstant.CLAN_BUILD_CLICK_INSIDE);
        }
    }

    public /* synthetic */ void i() {
        l lVar = this.g;
        if (lVar != null) {
            lVar.a(this.h, this.f9926e.get(), this.f9927f.get(), this.f9925d.get(), TribeCenter.newInstance().tribeClanId.get());
            ReportDataAdapter.onEvent(this.f9922a, EventConstant.CLAN_MORE_EDIT_DATA_CLICK);
        }
    }

    public /* synthetic */ void j() {
        new EditTextDialog(this.f9922a).c(this.f9922a.getString(R.string.tribe_create_add_label)).b(this.f9922a.getString(R.string.tribe_create_add_label)).a(8).a(new m(this)).show();
    }

    public /* synthetic */ void k() {
        this.g.a(this.h, this.f9926e.get(), this.f9927f.get(), 1);
    }

    public /* synthetic */ void a(String str) {
        this.f9926e.set(str);
    }

    public /* synthetic */ void b(String str) {
        this.f9927f.set(str);
        this.i.set(this.f9922a.getString(R.string.tribe_create_introduction_count, new Object[]{Integer.valueOf(String.valueOf(str).length())}));
    }

    private void a(h hVar, boolean z) {
        Bundle arguments;
        if (z || (arguments = hVar.getArguments()) == null) {
            return;
        }
        try {
            this.f9925d.set(arguments.getString("tribe.ico.url"));
            this.f9926e.set(arguments.getString("tribe.name"));
            this.h.addAll(arguments.getStringArrayList("tribe.labels"));
            this.f9927f.set(arguments.getString("tribe.introduction"));
            this.j.setData(this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
