package com.sandboxol.gamedetail.c.a.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.FriendManager;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.AuthorInfo;
import com.sandboxol.greendao.entity.BannerPic;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameWarmUpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: GameDetailIntroduceTopItemViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends ListItemViewModel<BannerPic> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GameWarmUpResponse f18069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Game f18070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<AuthorInfo> f18072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f18073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f18074f;
    public ObservableField<String> g;
    public ObservableField<String> h;
    public ObservableField<Boolean> i;
    public ObservableField<Boolean> j;
    public ReplyCommand k;
    public ReplyCommand l;
    public ReplyCommand m;

    public m(Context context, BannerPic bannerPic, Game game) {
        super(context, bannerPic);
        this.f18072d = new ArrayList();
        this.f18073e = new ObservableField<>(false);
        this.f18074f = new ObservableField<>(false);
        this.g = new ObservableField<>("");
        this.h = new ObservableField<>("");
        this.i = new ObservableField<>(false);
        this.j = new ObservableField<>(false);
        this.k = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.b.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18053a.i();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.b.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18055a.h();
            }
        });
        this.m = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.c.a.b.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18056a.f();
            }
        });
        this.f18070b = game;
        this.f18069a = game.getWarmUpResponse();
        GameWarmUpResponse gameWarmUpResponse = this.f18069a;
        if (gameWarmUpResponse != null && gameWarmUpResponse.getAuthorInfo() != null) {
            try {
                this.f18074f.set(Boolean.valueOf(this.f18069a.getAuthorInfo().getIsAddFriend() == 1));
                P.newInstance().a(this.f18069a.getAuthorInfo().getUserId(), new l(this, context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f18069a.getAuthorInfo().getIsTeam() == 2) {
                a(this.f18069a.getAuthorInfo().getTeamId(), false, this.f18069a.getAuthorInfo().getIsAddFriend() == 1);
                this.f18074f.set(true);
            }
        }
        new k().a(context, game, this.h, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f18069a.getAuthorInfo() != null) {
            if (this.f18069a.getAuthorInfo().getIsTeam() != 2) {
                FriendManager.addFriend(this.context, this.f18069a.getAuthorInfo().getUserId(), this.f18073e, true, this.g);
                return;
            }
            List<AuthorInfo> list = this.f18072d;
            if (list == null) {
                a(this.f18069a.getAuthorInfo().getTeamId(), true, this.f18069a.getAuthorInfo().getIsAddFriend() == 1);
            } else {
                new com.sandboxol.gamedetail.view.dialog.a.d(this.context, list, this.f18069a.getAuthorInfo().getIsAddFriend() == 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.j.set(true);
        Observable.timer(500L, TimeUnit.MILLISECONDS).subscribe(new Action1() { // from class: com.sandboxol.gamedetail.c.a.b.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f18054a.a((Long) obj);
            }
        });
        SharedUtils.putBoolean(BaseApplication.getContext(), "game.update.sp.name", "game.update.content.open" + this.f18070b.getGameId() + AccountCenter.newInstance().userId.get(), false);
    }

    public /* synthetic */ void f() {
        if (this.f18069a.getAuthorInfo().getIsTeam() == 2 || !this.f18074f.get().booleanValue()) {
            return;
        }
        FriendManager.getFriendDataAndEnterFriendInfo(this.context, null, this.f18069a.getAuthorInfo().getUserId());
    }

    private void a(long j, boolean z, boolean z2) {
        new k().a(this.context, j, this.f18072d, z, z2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public BannerPic getItem() {
        return (BannerPic) super.getItem();
    }

    public /* synthetic */ void a(Long l) {
        this.j.set(false);
        this.i.set(false);
    }
}
