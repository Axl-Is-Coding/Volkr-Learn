package com.disabngo.blockynexus.e.b.S;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import androidx.fragment.app.FragmentActivity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Cd;
import com.google.android.material.textfield.TextInputEditText;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.PartyCreateGameConfig;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RxPermissions2;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import com.tendcloud.tenddata.ab;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: PartyCreateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class v extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Cd f9443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t f9444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f9445d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f9447f;
    private PartyCreateGameConfig g;
    private List<AllGameIdInfo> h;
    private int i;
    private int j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f9446e = new n();
    private int k = 0;
    public ObservableField<String> l = new ObservableField<>("");
    public ObservableField<String> m = new ObservableField<>("");
    public ObservableField<Boolean> n = new ObservableField<>();
    public ObservableField<Boolean> o = new ObservableField<>(false);
    public ObservableField<Boolean> p = new ObservableField<>(false);
    public ObservableField<AllGameIdInfo> q = new ObservableField<>();
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.S.i
        @Override // rx.functions.Action0
        public final void call() {
            this.f9417a.i();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.S.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9412a.k();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.S.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f9416a.j();
        }
    });
    public ReplyCommand<String> u = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.S.f
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9414a.a((String) obj);
        }
    });
    public ObservableField<Integer> v = new ObservableField<>(Integer.valueOf(R.id.rb_public_game));
    public ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> w = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.S.j
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9418a.a((RadioGroupBindingAdapters.CheckedDataWrapper) obj);
        }
    });

    public v(Context context, Cd cd, List<AllGameIdInfo> list) {
        this.f9442a = context;
        this.h = list;
        this.f9443b = cd;
        initData();
        initMessenger();
    }

    private void b(String str) {
        this.o.set(true);
        this.f9444c.a(this.f9442a, str, new OnDataListener() { // from class: com.disabngo.blockynexus.e.b.S.b
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                this.f9410a.a((PartyCreateGameConfig) obj);
            }
        });
    }

    private void h() {
        if (TextUtils.isEmpty(this.l.get())) {
            AppToastUtils.showShortNegativeTipToast(this.f9442a, R.string.dialog_recharge_input_et_not_empty);
            return;
        }
        SandboxReportManager.onEvent(ReportEvent.USER_RANKS_NUM, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
        if (AccountCenter.newInstance().vip.get().intValue() < 1 && this.i == 2) {
            new TwoTextButtonDialog(this.f9442a).setDetailText(this.f9442a.getString(R.string.party_create_party_room_buy_vip)).setRightButtonText(R.string.vip_pay_title).setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.S.c
                @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9411a.f();
                }
            }).show();
            return;
        }
        if (this.f9444c == null || this.g == null || this.o.get().booleanValue()) {
            this.p.set(true);
            DialogUtils.newsInstant().showLoadingDialog(this.f9442a);
            return;
        }
        this.f9444c.a(this.f9442a, this.f9443b.f7344b.getText().toString().trim(), this.f9447f, this.m.get(), this.k, this.g.getMemberMax(), this.g.getTeamNum(), this.i, this.j, this.n);
        if (this.i == 2) {
            ReportDataAdapter.onEvent(this.f9442a, EventConstant.PRIVATE_PARTY_TIME);
        } else {
            ReportDataAdapter.onEvent(this.f9442a, EventConstant.PUBLIC_PARTY_TIME);
        }
        this.p.set(false);
        DialogUtils.newsInstant().hideLoadingDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f9443b.f7348f.setVisibility(8);
        PageRecyclerView pageRecyclerView = this.f9443b.f7343a;
        pageRecyclerView.startAnimation(new com.disabngo.blockynexus.a.a(pageRecyclerView, com.sandboxol.decorate.b.a.f16973a));
    }

    private void initData() {
        this.f9444c = new t();
        if (this.h.size() > 0) {
            this.f9445d = new o(this.f9442a, R.string.no_data, this.h, this.q);
        }
        this.l.set(this.f9442a.getString(R.string.party_create_party_room_name, AccountCenter.newInstance().nickName.get()));
        List<AllGameIdInfo> list = this.h;
        if (list != null && list.size() > 0 && this.h.get(0) != null && this.h.get(0).getGameId() != null) {
            AllGameIdInfo allGameIdInfo = this.h.get(0);
            this.m.set(allGameIdInfo.getGameName());
            this.f9447f = allGameIdInfo.getGameId();
            this.i = 1;
            this.j = allGameIdInfo.getIsNewEngine();
            b(this.h.get(0).getGameId());
        }
        b(R.id.rb_public_game);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.PARTY_CHOOSE_GAME, AllGameIdInfo.class, new Action1() { // from class: com.disabngo.blockynexus.e.b.S.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f9415a.a((AllGameIdInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.l.set("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void k() {
        new RxPermissions2((FragmentActivity) this.f9442a).request("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE").subscribe(new io.reactivex.b.g() { // from class: com.disabngo.blockynexus.e.b.S.e
            @Override // io.reactivex.b.g
            public final void accept(Object obj) throws Exception {
                this.f9413a.a((Boolean) obj);
            }
        }, new u(this));
        ReportDataAdapter.onEvent(this.f9442a, EventConstant.CLICK_PARTY_BUILD);
        com.apkfuns.logutils.c.a(ab.u).d("onEvent being called! eventEvent: 点击确定创建");
    }

    public /* synthetic */ void a(String str) {
        this.l.set(str);
    }

    public /* synthetic */ void f() {
        VipManager.enterVipFragment(this.f9442a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        this.f9444c.a();
    }

    public /* synthetic */ void a(RadioGroupBindingAdapters.CheckedDataWrapper checkedDataWrapper) {
        b(checkedDataWrapper.getCheckedId());
    }

    private void b(int i) {
        PartyCreateGameConfig partyCreateGameConfig = this.g;
        if (partyCreateGameConfig == null) {
            return;
        }
        switch (i) {
            case R.id.rb_private_game /* 2131297343 */:
                this.i = 2;
                this.k = partyCreateGameConfig.getMemberMax();
                break;
            case R.id.rb_public_game /* 2131297344 */:
                this.i = 1;
                this.k = 4;
                break;
        }
        this.v.set(Integer.valueOf(i));
        if (this.q.get() == null || this.q.get().getGameId() == null) {
            return;
        }
        this.m.set(this.q.get().getGameName());
        this.f9447f = this.q.get().getGameId();
        this.j = this.q.get().getIsNewEngine();
    }

    public /* synthetic */ void a(AllGameIdInfo allGameIdInfo) {
        if (this.q.get() == null || this.q.get().getGameId() == null || this.q.get().getGameName() == null) {
            return;
        }
        this.q.set(allGameIdInfo);
        this.m.set(this.q.get().getGameName());
        this.f9447f = this.q.get().getGameId();
        this.j = this.q.get().getIsNewEngine();
        b(this.q.get().getGameId());
    }

    public /* synthetic */ void a(PartyCreateGameConfig partyCreateGameConfig) {
        this.o.set(false);
        if (1 == partyCreateGameConfig.getPartyStatus()) {
            this.g = partyCreateGameConfig;
            if (this.v.get().intValue() == R.id.rb_private_game) {
                this.k = partyCreateGameConfig.getMemberMax();
            } else {
                this.k = 4;
            }
            if (this.p.get().booleanValue()) {
                h();
            }
        } else {
            this.k = 0;
            AppToastUtils.showShortNegativeTipToast(this.f9442a, R.string.party_create_select_game_close);
        }
        TextInputEditText textInputEditText = this.f9443b.f7344b;
        textInputEditText.setSelection(textInputEditText.getText().length());
    }

    public /* synthetic */ void a(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            h();
        }
    }
}
