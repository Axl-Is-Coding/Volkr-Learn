package com.disabngo.blockynexus.e.b.W.a;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.K;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.RankInfoResponse;
import rx.functions.Action0;

/* JADX INFO: compiled from: ActiveRankPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9492a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f9496e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableList<RankInfoResponse> f9493b = new ObservableArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<RankInfoResponse> f9494c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.W.c f9495d = new com.disabngo.blockynexus.e.b.W.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9497f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.a.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9469a.a();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.a.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9468a.b();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.a.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9467a.c();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.a.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9470a.d();
        }
    });

    public o(Context context, int i, int i2) {
        this.f9492a = context;
        this.f9496e = new n(context, R.string.no_data, this.f9493b, this.f9494c, i, i2);
    }

    public /* synthetic */ void a() {
        if (this.f9493b.size() > 0) {
            a(this.f9493b.get(0).getId(), this.f9493b.get(0).getRankType());
        }
    }

    public /* synthetic */ void b() {
        if (this.f9493b.size() > 1) {
            a(this.f9493b.get(1).getId(), this.f9493b.get(1).getRankType());
        }
    }

    public /* synthetic */ void c() {
        if (this.f9493b.size() > 2) {
            a(this.f9493b.get(2).getId(), this.f9493b.get(2).getRankType());
        }
    }

    public /* synthetic */ void d() {
        if (this.f9494c.get().getId() != -1) {
            a(this.f9494c.get().getId(), this.f9494c.get().getRankType());
        }
    }

    private void a(long j, String str) {
        if ("clan".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putLong("tribe.clan.id", j);
            Context context = this.f9492a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
            return;
        }
        K.a(this.f9492a, null, new FriendActivityIntentInfo(j, j == AccountCenter.newInstance().userId.get().longValue() ? 4 : 2));
    }
}
