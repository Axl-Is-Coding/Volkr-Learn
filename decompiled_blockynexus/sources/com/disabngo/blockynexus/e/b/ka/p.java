package com.disabngo.blockynexus.e.b.ka;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.Sa;
import com.disabngo.blockynexus.view.dialog.TribeContributionDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.listener.OnViewClickListener;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeContributionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9879a;
    public j i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Integer> f9880b = new ObservableField<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Integer> f9881c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Integer> f9882d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f9883e = new ObservableField<>("");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9884f = new ObservableField<>("");
    public ObservableField<String> g = new ObservableField<>("");
    public ObservableField<String> h = new ObservableField<>("");
    public k j = new k();
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ka.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9871a.f();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ka.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9873a.h();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ka.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9872a.i();
        }
    });

    public p(Context context) {
        this.f9879a = context;
        this.i = new j(context, R.string.tribe_contribution_no_history);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        TribeApi.donationInfo(this.f9879a, new n(this));
    }

    public /* synthetic */ void f() {
        Context context = this.f9879a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ua.j.class, context.getString(R.string.tribe_task_title));
    }

    public /* synthetic */ void h() {
        new TribeContributionDialog(this.f9879a).a(2).b(this.g.get()).a(new l(this)).show();
    }

    public /* synthetic */ void i() {
        new TribeContributionDialog(this.f9879a).a(1).b(this.h.get()).a(new m(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        TribeApi.donationResponse(this.f9879a, i, i2, new o(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, OnViewClickListener onViewClickListener) {
        Sa sa = new Sa(this.f9879a);
        sa.a(i, i2);
        sa.a(onViewClickListener);
        sa.show();
    }
}
