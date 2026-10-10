package com.disabngo.blockynexus.e.b.Y;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.databinding.Xe;
import com.disabngo.blockynexus.utils.logic.N;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.imchat.config.ChatStringConstant;
import rx.functions.Action0;

/* JADX INFO: compiled from: ReminderViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Xe f9599b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f9601d = new ObservableField<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9602e = new ObservableField<>(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f9603f = new ObservableField<>();
    public ObservableField<Boolean> g = new ObservableField<>();
    public ObservableField<Boolean> h = new ObservableField<>();
    public ObservableField<Boolean> i = new ObservableField<>();
    public ReplyCommand j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Y.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9586a.f();
        }
    });
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Y.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9585a.k();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Y.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9587a.i();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Y.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9588a.h();
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.Y.e
        @Override // rx.functions.Action0
        public final void call() {
            this.f9589a.j();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i f9600c = new i();

    public l(Context context, Xe xe) {
        this.f9598a = context;
        this.f9599b = xe;
        this.f9601d.set(Boolean.valueOf(SharedUtils.getBoolean(context, StringConstant.IS_NEWS_REMINDER, true)));
        this.f9603f.set(Boolean.valueOf(SharedUtils.getBoolean(context, "is_sound", true)));
        this.g.set(Boolean.valueOf(SharedUtils.getBoolean(context, "is_shake", true)));
        this.h.set(Boolean.valueOf(SharedUtils.getBoolean(context, ChatStringConstant.IS_RECEIVER_PARTY_INVITE, true)));
        this.i.set(Boolean.valueOf(SharedUtils.getBoolean(context, ChatStringConstant.IS_SHOW_FRIEND_IN_GAME, true)));
        this.f9600c.a(context, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!N.h()) {
            this.f9599b.f8031a.setChecked(this.f9601d.get().booleanValue());
            return;
        }
        if (this.f9602e.get().booleanValue()) {
            this.f9602e.set(false);
            if (this.f9601d.get().booleanValue()) {
                N.a("00:00:00", 1439, new j(this));
            } else {
                N.a(new k(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.h.set(Boolean.valueOf(!r0.get().booleanValue()));
        SharedUtils.putBoolean(this.f9598a, ChatStringConstant.IS_RECEIVER_PARTY_INVITE, this.h.get().booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.g.set(Boolean.valueOf(!r0.get().booleanValue()));
        SharedUtils.putBoolean(this.f9598a, "is_shake", this.g.get().booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.i.set(Boolean.valueOf(!r0.get().booleanValue()));
        this.f9600c.b(this.f9598a, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f9603f.set(Boolean.valueOf(!r0.get().booleanValue()));
        SharedUtils.putBoolean(this.f9598a, "is_sound", this.f9603f.get().booleanValue());
    }
}
