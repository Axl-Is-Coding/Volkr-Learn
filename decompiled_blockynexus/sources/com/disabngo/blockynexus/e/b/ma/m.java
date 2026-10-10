package com.disabngo.blockynexus.e.b.ma;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.adapter.TribeDetailLabelsAdapter;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.config.ChatMessageToken;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f9949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9952d;
    public TribeDetailLabelsAdapter g;
    public g j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f9953e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<TribeDetail> f9954f = new ObservableField<>();
    public ObservableField<String> h = new ObservableField<>("");
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ma.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9936a.m();
        }
    });
    public com.disabngo.blockynexus.e.b.X.a k = new com.disabngo.blockynexus.e.b.X.a();

    public m(Activity activity, long j, String str, int i) {
        this.f9949a = activity;
        this.f9952d = j;
        this.f9950b = str;
        this.f9951c = i;
        this.g = new TribeDetailLabelsAdapter(activity, this.f9953e);
        this.j = new g(activity, R.string.no_data, 0, i);
        b(activity);
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.ma.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9937a.a((Boolean) obj);
            }
        });
    }

    private void j() {
        TribeApi.dissolveTribe(this.f9949a, this.f9952d, new k(this));
    }

    private void k() {
        TribeApi.exitTribe(this.f9949a, this.f9952d, new l(this));
    }

    private void l() {
        new EditTextDialog(this.f9949a).c(this.f9949a.getString(R.string.tribe_request_join)).a(new j(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Activity activity;
        int i;
        Activity activity2;
        int i2;
        if (TribeCenter.newInstance().tribeClanId.get().longValue() != this.f9952d) {
            l();
            return;
        }
        TwoButtonDialog twoButtonDialog = new TwoButtonDialog(this.f9949a);
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20) {
            activity = this.f9949a;
            i = R.string.tribe_dissolve;
        } else {
            activity = this.f9949a;
            i = R.string.tribe_exit;
        }
        TwoButtonDialog titleText = twoButtonDialog.setTitleText(activity.getString(i));
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20) {
            activity2 = this.f9949a;
            i2 = R.string.tribe_sure_dissolve;
        } else {
            activity2 = this.f9949a;
            i2 = R.string.tribe_sure_exit;
        }
        titleText.setDetailText(activity2.getString(i2)).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ma.b
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9935a.i();
            }
        }).show();
    }

    public String f() {
        return TribeCenter.newInstance().tribeClanId.get().longValue() == this.f9952d ? (TribeCenter.newInstance().tribeRole.get().intValue() == 0 || TribeCenter.newInstance().tribeRole.get().intValue() == 10) ? this.f9949a.getString(R.string.tribe_exit) : TribeCenter.newInstance().tribeRole.get().intValue() == 20 ? this.f9949a.getString(R.string.tribe_dissolve) : this.f9949a.getString(R.string.tribe_detail_join) : this.f9949a.getString(R.string.tribe_detail_join);
    }

    public boolean h() {
        return TribeCenter.newInstance().tribeClanId.get().longValue() == 0 || TribeCenter.newInstance().tribeClanId.get().longValue() == this.f9952d;
    }

    public /* synthetic */ void i() {
        y.b().b(false);
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20) {
            j();
        } else {
            k();
        }
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    private void b(Context context) {
        TribeApi.tribeDetail(context, this.f9952d, new h(this, context));
    }

    public /* synthetic */ void a(Boolean bool) {
        Activity activity;
        if (!bool.booleanValue() || (activity = this.f9949a) == null || activity.isFinishing()) {
            return;
        }
        this.f9949a.finish();
    }
}
