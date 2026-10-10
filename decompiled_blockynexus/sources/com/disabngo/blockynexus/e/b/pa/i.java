package com.disabngo.blockynexus.e.b.pa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.TribeMessage;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Friend;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeMessageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ListItemViewModel<TribeMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f10057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<Boolean> f10058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f10059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f10060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f10061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f10062f;

    public i(Context context, TribeMessage tribeMessage) {
        super(context, tribeMessage);
        this.f10057a = new ObservableField<>(l());
        this.f10058b = new ObservableField<>(Boolean.valueOf(m()));
        this.f10059c = new ObservableField<>(true);
        this.f10060d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.pa.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f10050a.p();
            }
        });
        this.f10061e = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.pa.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f10051a.f();
            }
        });
        this.f10062f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.pa.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f10052a.h();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D() {
        this.f10059c.set(false);
        TribeApi.rejectJoinTribe(this.context, ((TribeMessage) this.item).getId(), new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        this.f10058b.set(true);
        this.f10059c.set(true);
        this.f10057a.set(this.context.getString(R.string.refuse_add_friend));
    }

    private boolean m() {
        int status = getItem().getStatus();
        if (status != 0) {
            return status == 1 || status == 2 || status == 3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void p() {
        J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((TribeMessage) this.item).getUserId(), 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u() {
        this.f10059c.set(false);
        y.b().b(true);
        TribeApi.agreeJoinTribe(this.context, ((TribeMessage) this.item).getId(), new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f10059c.set(true);
        this.f10058b.set(true);
        this.f10057a.set(this.context.getString(R.string.agree_add_friend));
    }

    private String l() {
        int status = getItem().getStatus();
        return status != 0 ? status != 1 ? status != 2 ? status != 3 ? "" : this.context.getString(R.string.tribe_joined) : this.context.getString(R.string.refuse_add_friend) : this.context.getString(R.string.agree_add_friend) : "";
    }

    public /* synthetic */ void f() {
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20 || TribeCenter.newInstance().tribeRole.get().intValue() == 10) {
            j();
        } else {
            D();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public TribeMessage getItem() {
        return (TribeMessage) super.getItem();
    }

    public /* synthetic */ void h() {
        if (TribeCenter.newInstance().tribeRole.get().intValue() == 20 || TribeCenter.newInstance().tribeRole.get().intValue() == 10) {
            i();
        } else {
            u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f10059c.set(false);
        TribeApi.agreeJoin(this.context, ((TribeMessage) this.item).getUserId(), new f(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        this.f10059c.set(false);
        TribeApi.rejectJoin(this.context, ((TribeMessage) this.item).getUserId(), new e(this));
    }
}
