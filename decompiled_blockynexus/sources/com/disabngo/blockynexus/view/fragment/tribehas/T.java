package com.disabngo.blockynexus.view.fragment.tribehas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.disabngo.blockynexus.view.dialog.OneButtonNoticeDialog;
import com.disabngo.blockynexus.view.dialog.Ta;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.ChatMessageToken;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeHasViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class T extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11991a;
    public L j;
    private Q k;
    private BottomDialog l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f11992b = new ObservableField<>("");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f11993c = new ObservableField<>("");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f11994d = new ObservableField<>("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Integer> f11995e = new ObservableField<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f11996f = new ObservableField<>("");
    public ObservableField<List<String>> g = new ObservableField<>(new ArrayList());
    public ObservableField<String> h = new ObservableField<>("");
    public C0935C i = new C0935C();
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.q
        @Override // rx.functions.Action0
        public final void call() {
            this.f12014a.j();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.t
        @Override // rx.functions.Action0
        public final void call() {
            this.f12017a.k();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.A
        @Override // rx.functions.Action0
        public final void call() {
            this.f11966a.l();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.w
        @Override // rx.functions.Action0
        public final void call() {
            this.f12020a.m();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.v
        @Override // rx.functions.Action0
        public final void call() {
            this.f12019a.p();
        }
    });
    public ReplyCommand r = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.r
        @Override // rx.functions.Action0
        public final void call() {
            this.f12015a.u();
        }
    });
    public ReplyCommand s = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.B
        @Override // rx.functions.Action0
        public final void call() {
            this.f11967a.D();
        }
    });
    public ReplyCommand t = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.p
        @Override // rx.functions.Action0
        public final void call() {
            this.f12013a.E();
        }
    });
    public ReplyCommand u = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.z
        @Override // rx.functions.Action0
        public final void call() {
            this.f12023a.F();
        }
    });
    public ReplyCommand v = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.E
        @Override // rx.functions.Action0
        public final void call() {
            this.f11970a.G();
        }
    });

    public T(Context context) {
        this.f11991a = context;
        this.j = new L(context, R.string.tribe_member_exist, false);
        this.k = new Q(context, this.f11992b, this.f11993c, this.f11994d, this.f11995e, this.f11996f, this.g, this.h);
        initMessenger();
        initData();
    }

    private void H() {
        this.l = new BottomDialog(this.f11991a);
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20) {
            this.l.a(this.f11991a.getString(R.string.tribe_setting), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.x
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog) {
                    this.f12021a.a(bottomDialog);
                }
            });
        }
        this.l.a(this.f11991a.getString(R.string.tribe_data_edit), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.s
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f12016a.b(bottomDialog);
            }
        }).a(this.f11991a.getString(R.string.tribe_member_manage), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.u
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog) {
                this.f12018a.c(bottomDialog);
            }
        }).a(this.f11991a.getString(R.string.cancel), C1169a.f11997a);
        this.l.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (AccountCenter.newInstance().login.get().booleanValue() && TribeCenter.newInstance().tribeClanId.get().longValue() != 0 && TribeCenter.newInstance().tribeRole.get().intValue() == 20 && SharedUtils.getBoolean(this.f11991a, StringConstant.IS_TRIBE_SETTING_GUIDE, true)) {
            new Ta(this.f11991a, false).show();
            SharedUtils.putBoolean(this.f11991a, StringConstant.IS_TRIBE_SETTING_GUIDE, false);
        }
    }

    private void initData() {
        Q q = this.k;
        if (q != null) {
            q.a();
        }
        I();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_OPEN_TRIBE_SETTING_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.C
            @Override // rx.functions.Action0
            public final void call() {
                this.f11968a.f();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CLOSE_TRIBE_SETTING_DIALOG, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.D
            @Override // rx.functions.Action0
            public final void call() {
                this.f11969a.h();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT, Boolean.class, new S(this));
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_TRIBE_EXIT_OR_KICK, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.y
            @Override // rx.functions.Action0
            public final void call() {
                this.f12022a.i();
            }
        });
        Messenger.getDefault().register(this, MessageToken.TOKEN_CREATE_TRIBE_SUCCESS, new Action0() { // from class: com.disabngo.blockynexus.view.fragment.tribehas.o
            @Override // rx.functions.Action0
            public final void call() {
                this.f12012a.I();
            }
        });
    }

    public /* synthetic */ void D() {
        com.disabngo.blockynexus.c.a.b(this.f11991a);
    }

    public /* synthetic */ void E() {
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ra.h.class, context.getString(R.string.tribe_ranking));
    }

    public /* synthetic */ void F() {
        if (TribeCenter.newInstance().tribeRole.get().intValue() != 20 && TribeCenter.newInstance().tribeRole.get().intValue() != 1) {
            new OneButtonNoticeDialog(this.f11991a).a(this.f11991a.getString(R.string.tribe_notice_title)).setButtonText(this.f11991a.getString(R.string.close)).setDetailText(TextUtils.isEmpty(SharedUtils.getString(this.f11991a, "tribe.notice.content")) ? "" : SharedUtils.getString(this.f11991a, "tribe.notice.content")).show();
        } else {
            Context context = this.f11991a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.qa.b.class, context.getString(R.string.tribe_notice_title), this.f11991a.getString(R.string.finish));
        }
    }

    public /* synthetic */ void G() {
        com.disabngo.blockynexus.utils.logic.N.l();
        com.disabngo.blockynexus.utils.logic.N.c(this.f11991a);
        ReportDataAdapter.onEvent(this.f11991a, EventConstant.CLAN_ENTER_CHAT);
    }

    public /* synthetic */ void c(BottomDialog bottomDialog) {
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.oa.a.class, context.getString(R.string.tribe_member_manage), R.mipmap.ic_add_friend);
        bottomDialog.cancel();
    }

    public /* synthetic */ void f() {
        H();
        new Ta(this.f11991a, true).show();
    }

    public /* synthetic */ void h() {
        BottomDialog bottomDialog = this.l;
        if (bottomDialog == null || !bottomDialog.isShowing()) {
            return;
        }
        this.l.dismiss();
    }

    public /* synthetic */ void i() {
        Context context = this.f11991a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.f11991a).finish();
    }

    public /* synthetic */ void j() {
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, F.class, context.getString(R.string.description));
    }

    public /* synthetic */ void k() {
        Context context = this.f11991a;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        ((Activity) this.f11991a).finish();
    }

    public /* synthetic */ void l() {
        H();
        ReportDataAdapter.onEvent(this.f11991a, EventConstant.CLAN_MORE_CLICK);
    }

    public /* synthetic */ void m() {
        Bundle bundle = new Bundle();
        bundle.putLong("tribe.clan.id", TribeCenter.newInstance().tribeClanId.get().longValue());
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
        this.k.b();
    }

    public /* synthetic */ void p() {
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ka.h.class, context.getString(R.string.tribe_donate), R.mipmap.ic_big_question_mark);
    }

    public /* synthetic */ void u() {
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ua.j.class, context.getString(R.string.tribe_task_title), R.mipmap.ic_big_question_mark);
    }

    public /* synthetic */ void a(BottomDialog bottomDialog) {
        ReportDataAdapter.onEvent(this.f11991a, EventConstant.CLAN_SETUP_TIME);
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.sa.b.class, context.getString(R.string.tribe_setting));
        bottomDialog.cancel();
    }

    public /* synthetic */ void b(BottomDialog bottomDialog) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("tribe.is.create", false);
        bundle.putString("tribe.ico.url", this.f11992b.get());
        bundle.putString("tribe.name", this.f11993c.get());
        bundle.putString("tribe.introduction", this.f11996f.get());
        bundle.putStringArrayList("tribe.labels", (ArrayList) this.g.get());
        Context context = this.f11991a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.la.h.class, context.getString(R.string.tribe_edit_data), bundle);
        bottomDialog.cancel();
    }
}
