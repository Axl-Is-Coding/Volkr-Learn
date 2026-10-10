package com.sandboxol.halloween.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.view.dialog.HalloweenTipsDialog;
import rx.functions.Action0;

/* JADX INFO: compiled from: HalloweenCurrencyDialog.java */
/* JADX INFO: loaded from: classes4.dex */
public class m extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f18697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.sandboxol.halloween.b.a f18698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f18699f;
    public ObservableField<Integer> g;
    public ReplyCommand h;
    public ReplyCommand i;
    public ReplyCommand j;
    public ReplyCommand k;
    public ReplyCommand l;
    public ReplyCommand m;

    /* JADX INFO: compiled from: HalloweenCurrencyDialog.java */
    public interface a {
        void a(int i);
    }

    public m(Context context, int i, int i2, a aVar) {
        super(context);
        this.f18699f = new ObservableField<>(false);
        this.g = new ObservableField<>(0);
        this.h = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18685a.d();
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f18690a.f();
            }
        });
        this.j = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18684a.e();
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18686a.c();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f18691a.dismiss();
            }
        });
        this.m = new ReplyCommand(new Action0() { // from class: com.sandboxol.halloween.view.dialog.f
            @Override // rx.functions.Action0
            public final void call() {
                this.f18687a.g();
            }
        });
        this.f18694a = i;
        this.f18695b = i2;
        this.f18697d = aVar;
        this.f18699f.set(Boolean.valueOf(i == 0));
        initView();
    }

    private void initView() {
        this.f18698e = (com.sandboxol.halloween.b.a) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.halloween_dialog_currency, (ViewGroup) null, false);
        this.f18698e.a(this);
        setContentView(this.f18698e.getRoot());
        this.f18698e.g.setMax(this.f18694a);
        this.f18698e.g.setOnSeekChangeListener(new k(this));
        this.g.set(Integer.valueOf(this.f18695b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (g() || this.f18698e.g.getProgress() <= 0 || this.f18696c) {
            return;
        }
        if (AccountCenter.newInstance().gDiamonds.get().longValue() < this.g.get().intValue()) {
            Context context = this.context;
            new HalloweenTipsDialog(context, context.getString(R.string.halloween_tips), this.context.getString(R.string.halloween_gcube_not_enough), this.context.getString(R.string.halloween_sure), new HalloweenTipsDialog.OnClickListener() { // from class: com.sandboxol.halloween.view.dialog.g
                @Override // com.sandboxol.halloween.view.dialog.HalloweenTipsDialog.OnClickListener
                public final void onClick() {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_RECHARGE);
                }
            }).show();
        } else {
            Context context2 = this.context;
            new HalloweenTipsDialog(context2, context2.getString(R.string.halloween_tips), this.context.getString(R.string.halloween_exchange_tips), this.context.getString(R.string.halloween_sure), new HalloweenTipsDialog.OnClickListener() { // from class: com.sandboxol.halloween.view.dialog.h
                @Override // com.sandboxol.halloween.view.dialog.HalloweenTipsDialog.OnClickListener
                public final void onClick() {
                    this.f18689a.b();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int progress;
        if (!g() && (progress = this.f18698e.g.getProgress() + 1) <= this.f18694a) {
            this.f18698e.g.setProgress(progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (g()) {
            return;
        }
        this.f18698e.g.setProgress(this.f18694a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int progress;
        if (!g() && this.f18698e.g.getProgress() - 1 >= 0) {
            this.f18698e.g.setProgress(progress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!this.f18699f.get().booleanValue()) {
            return false;
        }
        AppToastUtils.showShortNegativeTipToast(this.context, R.string.halloween_limited_tips);
        return true;
    }

    public /* synthetic */ void b() {
        this.f18696c = true;
        com.sandboxol.halloween.web.g.a(this.context, this.f18698e.g.getProgress(), (OnResponseListener<Integer>) new l(this));
    }
}
