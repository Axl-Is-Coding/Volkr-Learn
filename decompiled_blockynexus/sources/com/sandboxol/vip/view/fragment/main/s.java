package com.sandboxol.vip.view.fragment.main;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.SubscribeInfo;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.center.web.VipApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.vip.R;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: PrivilegeCenterViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class s extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f19110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.sandboxol.vip.b.m f19111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f19112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f19113d = new l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f19114e = new ObservableField<>(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Integer> f19115f = new ObservableField<>(0);
    public ObservableField<String> g = new ObservableField<>("");
    public ObservableField<String> h = new ObservableField<>("");
    public ObservableField<String> i = new ObservableField<>("");
    public ObservableField<String> j = new ObservableField<>("");
    public ObservableField<Boolean> k = new ObservableField<>(false);
    public ObservableField<Boolean> l = new ObservableField<>(false);
    public ObservableField<Boolean> m = new ObservableField<>(false);
    public ObservableField<Boolean> n = new ObservableField<>(false);
    public ObservableField<Boolean> o = new ObservableField<>(false);
    public ObservableField<Boolean> p = new ObservableField<>(false);
    public ObservableField<Boolean> q = new ObservableField<>(false);
    public ObservableList<q> r = new ObservableArrayList();
    public me.tatarka.bindingcollectionadapter2.g<q> s = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.sandboxol.vip.view.fragment.main.i
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f19096a.a(gVar, i, (q) obj);
        }
    });
    public ReplyCommand<Integer> t = new ReplyCommand<>(new Action1() { // from class: com.sandboxol.vip.view.fragment.main.j
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f19097a.d(((Integer) obj).intValue());
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f19090a.h();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f19092a.i();
        }
    });
    public ReplyCommand w = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f19094a.j();
        }
    });
    public ReplyCommand x = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f19093a.k();
        }
    });
    public ReplyCommand y = new ReplyCommand(new Action0() { // from class: com.sandboxol.vip.view.fragment.main.h
        @Override // rx.functions.Action0
        public final void call() {
            this.f19095a.E();
        }
    });

    public s(Context context, com.sandboxol.vip.b.m mVar) {
        this.f19110a = context;
        this.f19111b = mVar;
        m();
        this.f19112c = new m(context, this.f19114e, this.q);
        p();
        initData();
        initMessenger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        new com.sandboxol.vip.d.a.e(this.f19110a).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        new com.sandboxol.vip.d.a.a.j(this.f19110a, l(), this.f19114e.get().intValue(), false).show();
        ReportDataAdapter.onEvent(this.f19110a, EventConstant.CLICK_VIP, String.valueOf(this.f19114e.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        List<Integer> vipList = AppInfoCenter.newInstance().getAppConfig().getVipList();
        if (vipList == null || vipList.size() <= 0 || i >= vipList.size()) {
            return;
        }
        this.f19114e.set(vipList.get(i));
        this.k.set(Boolean.valueOf(l()));
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.more.privilege.list");
    }

    private void initData() {
        VipApi.getSubscribeInfo(this.f19110a, new r(this));
        new p().a(this.f19110a, this.p);
        ReportDataAdapter.onEvent(this.f19110a, EventConstant.VIPPAGE_TIMES);
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, "token.refresh.vip.info", new Action0() { // from class: com.sandboxol.vip.view.fragment.main.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f19091a.f();
            }
        });
    }

    private boolean l() {
        return this.f19114e.get().intValue() == 2 ? this.m.get().booleanValue() : this.f19114e.get().intValue() == 3 ? this.n.get().booleanValue() : this.f19114e.get().intValue() == 4 ? this.o.get().booleanValue() : this.l.get().booleanValue();
    }

    private void m() {
        List<Integer> vipList = AppInfoCenter.newInstance().getAppConfig().getVipList();
        if (vipList == null || vipList.size() <= 0) {
            return;
        }
        this.q.set(true);
        for (int i = 0; i < vipList.size(); i++) {
            if (i == 0) {
                this.f19114e.set(vipList.get(i));
            }
            int iIntValue = vipList.get(i).intValue();
            if (iIntValue == 1) {
                this.r.add(new q(this.f19110a, vipList.get(i), this.l, this.g, this.q, this.p));
            } else if (iIntValue == 2) {
                this.r.add(new q(this.f19110a, vipList.get(i), this.m, this.h, this.q, this.p));
            } else if (iIntValue == 3) {
                this.r.add(new q(this.f19110a, vipList.get(i), this.n, this.i, this.q, this.p));
            } else if (iIntValue == 4) {
                this.r.add(new q(this.f19110a, vipList.get(i), this.o, this.j, this.q, this.p));
            }
        }
    }

    private void p() {
        String string = this.f19110a.getString(R.string.vip_subscribe_open_readme_privacy_policy_rule);
        String string2 = this.f19110a.getString(R.string.vip_subscribe_open_readme_privacy_policy);
        String string3 = this.f19110a.getString(R.string.vip_subscribe_open_readme_rule);
        try {
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || string.length() <= string2.length() + string3.length()) {
                return;
            }
            int iIndexOf = string.indexOf(string2);
            int iIndexOf2 = string.indexOf(string2) + string2.length();
            int iIndexOf3 = string.indexOf(string3);
            int iIndexOf4 = string.indexOf(string3) + string3.length();
            SpannableString spannableString = new SpannableString(string);
            if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf2 > iIndexOf) {
                spannableString.setSpan(new ClickableSpan() { // from class: com.sandboxol.vip.view.fragment.main.PrivilegeCenterViewModel$2
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        this.f19086a.u();
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setUnderlineText(false);
                    }
                }, iIndexOf, iIndexOf2, 17);
            }
            if (iIndexOf3 >= 0 && iIndexOf4 >= 0 && iIndexOf4 > iIndexOf3) {
                spannableString.setSpan(new ClickableSpan() { // from class: com.sandboxol.vip.view.fragment.main.PrivilegeCenterViewModel$3
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        this.f19087a.D();
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setUnderlineText(false);
                    }
                }, iIndexOf3, iIndexOf4, 17);
            }
            this.f19111b.f19007f.setMovementMethod(LinkMovementMethod.getInstance());
            this.f19111b.f19007f.setText(spannableString);
            this.f19111b.f19007f.setGravity(17);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        LoginManager.showProtocolDialog(this.f19110a);
    }

    public /* synthetic */ void f() {
        b(VipDataManager.getInstance().getVipSubInfo());
        a(VipDataManager.getInstance().getVipSubInfo());
    }

    public /* synthetic */ void h() {
        c(1);
    }

    public /* synthetic */ void i() {
        c(2);
    }

    public /* synthetic */ void j() {
        c(3);
    }

    public /* synthetic */ void k() {
        c(4);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        Messenger.getDefault().unregister(this);
        super.onDestroy();
    }

    private void c(int i) {
        if (this.q.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putInt("vip.type", this.f19114e.get().intValue());
            bundle.putBoolean("is.subscribed", l());
            bundle.putString("privilege.title", b(i));
            Context context = this.f19110a;
            TemplateUtils.startTemplate(context, com.sandboxol.vip.d.b.a.f.class, context.getString(R.string.vip_privilege_detail_title), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VipSubInfo vipSubInfo) {
        if (vipSubInfo == null || vipSubInfo.getPlayerInfo() == null) {
            return;
        }
        this.f19115f.set(Integer.valueOf(vipSubInfo.getPlayerInfo().getVip()));
        this.g.set(vipSubInfo.getPlayerInfo().getVip1ExpiredAtStr());
        this.h.set(vipSubInfo.getPlayerInfo().getVip2ExpiredAtStr());
        this.i.set(vipSubInfo.getPlayerInfo().getVip3ExpiredAtStr());
        this.j.set(vipSubInfo.getPlayerInfo().getVip4ExpiredAtStr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VipSubInfo vipSubInfo) {
        if (vipSubInfo != null && vipSubInfo.getSubInfo() != null && vipSubInfo.getSubInfo().size() != 0) {
            for (SubscribeInfo subscribeInfo : vipSubInfo.getSubInfo()) {
                if (subscribeInfo != null) {
                    int vipType = subscribeInfo.getVipType();
                    if (vipType == 1) {
                        this.l.set(Boolean.valueOf(subscribeInfo.isSubscribe()));
                    } else if (vipType == 2) {
                        this.m.set(Boolean.valueOf(subscribeInfo.isSubscribe()));
                    } else if (vipType == 3) {
                        this.n.set(Boolean.valueOf(subscribeInfo.isSubscribe()));
                    } else if (vipType == 4) {
                        this.o.set(Boolean.valueOf(subscribeInfo.isSubscribe()));
                    }
                }
            }
            this.k.set(Boolean.valueOf(l()));
            return;
        }
        this.l.set(false);
        this.m.set(false);
        this.n.set(false);
        this.o.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, q qVar) {
        gVar.a(com.sandboxol.vip.a.f18956f, R.layout.vip_content_page_vip_type);
    }

    private String b(int i) {
        if (i == 1) {
            return BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_1);
        }
        if (i == 2) {
            return BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_2);
        }
        if (i == 3) {
            return BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_3);
        }
        if (i != 4) {
            return BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_1);
        }
        return BaseApplication.getContext().getString(R.string.vip_privilege_list_item_title_9);
    }
}
