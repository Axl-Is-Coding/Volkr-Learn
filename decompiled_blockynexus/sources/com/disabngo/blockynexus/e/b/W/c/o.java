package com.disabngo.blockynexus.e.b.W.c;

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

/* JADX INFO: compiled from: GdiamondRankPageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9567a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f9571e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableList<RankInfoResponse> f9568b = new ObservableArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<RankInfoResponse> f9569c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.disabngo.blockynexus.e.b.W.c f9570d = new com.disabngo.blockynexus.e.b.W.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9572f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.c.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9542a.a();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.c.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9545a.b();
        }
    });
    public ReplyCommand h = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.c.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9543a.c();
        }
    });
    public ReplyCommand i = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.W.c.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9544a.d();
        }
    });

    public o(Context context, int i, int i2) {
        this.f9567a = context;
        this.f9571e = new n(context, R.string.no_data, this.f9568b, this.f9569c, i, i2);
    }

    public /* synthetic */ void a() {
        if (this.f9568b.size() > 0) {
            a(this.f9568b.get(0).getId(), this.f9568b.get(0).getRankType());
        }
    }

    public /* synthetic */ void b() {
        if (this.f9568b.size() > 1) {
            a(this.f9568b.get(1).getId(), this.f9568b.get(1).getRankType());
        }
    }

    public /* synthetic */ void c() {
        if (this.f9568b.size() > 2) {
            a(this.f9568b.get(2).getId(), this.f9568b.get(2).getRankType());
        }
    }

    public /* synthetic */ void d() {
        if (this.f9569c.get().getId() != -1) {
            a(this.f9569c.get().getId(), this.f9569c.get().getRankType());
        }
    }

    private void a(long j, String str) {
        if ("clan".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putLong("tribe.clan.id", j);
            Context context = this.f9567a;
            TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
            return;
        }
        K.a(this.f9567a, null, new FriendActivityIntentInfo(j, j == AccountCenter.newInstance().userId.get().longValue() ? 4 : 2));
    }
}
