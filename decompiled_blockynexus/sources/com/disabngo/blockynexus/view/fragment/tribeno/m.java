package com.disabngo.blockynexus.view.fragment.tribeno;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.config.ChatMessageToken;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: TribeNoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f12042a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f12044c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f12043b = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f12045d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f12030a.f();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f12046e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f12029a.h();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f12047f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f12028a.i();
        }
    });

    public m(Context context) {
        this.f12042a = context;
        this.f12044c = new l(context, R.string.tribe_no_recommend);
        initMessenger();
        initData();
    }

    private void initData() {
        if (TribeCenter.newInstance().tribeClanId.get().longValue() == 0) {
            ReportDataAdapter.onEvent(this.f12042a, EventConstant.CLAN_LIST);
        }
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT, Boolean.class, new Action1() { // from class: com.disabngo.blockynexus.view.fragment.tribeno.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f12027a.a((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            Context context = this.f12042a;
            if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
                return;
            }
            ((Activity) this.f12042a).finish();
        }
    }

    public /* synthetic */ void f() {
        Context context = this.f12042a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.f12042a).finish();
    }

    public /* synthetic */ void h() {
        Context context = this.f12042a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ra.h.class, context.getString(R.string.tribe_ranking));
    }

    public /* synthetic */ void i() {
        D.h(this.f12042a);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }
}
