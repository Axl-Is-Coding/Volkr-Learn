package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: SearchRecommendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends ListItemViewModel<RecommendFriendEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplyCommand f11096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f11098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f11099e;

    public r(Context context, RecommendFriendEntity recommendFriendEntity, boolean z) {
        super(context, recommendFriendEntity);
        this.f11096b = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.g
            @Override // rx.functions.Action0
            public final void call() {
                this.f11068a.f();
            }
        });
        this.f11097c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.searchfriend.h
            @Override // rx.functions.Action0
            public final void call() {
                this.f11069a.h();
            }
        });
        this.f11098d = new ObservableField<>(false);
        this.f11099e = new ObservableField<>("");
        this.f11095a = z;
        List<String> gameId = recommendFriendEntity.getGameId();
        if (gameId == null || gameId.size() <= 0) {
            return;
        }
        int size = gameId.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                this.f11099e.set(this.f11099e.get() + gameId.get(i));
            } else {
                this.f11099e.set(this.f11099e.get() + gameId.get(i) + UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        new l().a(this.context, ((RecommendFriendEntity) this.item).getUserId(), this.f11098d, false);
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_ADD_FRIEND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (this.f11095a) {
            J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((RecommendFriendEntity) this.item).getUserId(), 2));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public RecommendFriendEntity getItem() {
        return (RecommendFriendEntity) super.getItem();
    }
}
