package com.disabngo.blockynexus.view.activity.newsearch;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;
import java.util.Map;
import rx.functions.Action0;

/* JADX INFO: compiled from: SearchNewRecommendItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends ListItemViewModel<RecommendFriendEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ReplyCommand f11027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand f11028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f11029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f11030f;
    public ObservableField<String> g;
    public ObservableField<String> h;

    public p(Context context, RecommendFriendEntity recommendFriendEntity, Map<String, String> map, int i, boolean z) {
        super(context, recommendFriendEntity);
        this.f11027c = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.j
            @Override // rx.functions.Action0
            public final void call() {
                this.f11010a.f();
            }
        });
        this.f11028d = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.view.activity.newsearch.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f11011a.h();
            }
        });
        this.f11029e = new ObservableField<>(false);
        this.f11030f = new ObservableField<>("");
        this.g = new ObservableField<>("");
        this.h = new ObservableField<>("");
        this.f11026b = i;
        this.f11025a = z;
        if (map != null && map.size() != 0) {
            this.h.set(map.get(recommendFriendEntity.getLanguage()));
        }
        if (recommendFriendEntity != null && recommendFriendEntity.getLikeGames() != null && recommendFriendEntity.getLikeGames().size() != 0) {
            int size = recommendFriendEntity.getLikeGames().size();
            for (int i2 = 0; i2 < size; i2++) {
                if (recommendFriendEntity.getLikeGames().get(i2) != null && recommendFriendEntity.getLikeGames().get(i2).getGameTitleByLanguage() != null) {
                    if (TextUtils.isEmpty(this.f11030f.get())) {
                        this.f11030f.set(recommendFriendEntity.getLikeGames().get(i2).getGameTitleByLanguage());
                    } else {
                        this.f11030f.set(this.f11030f.get() + "/" + recommendFriendEntity.getLikeGames().get(i2).getGameTitleByLanguage());
                    }
                }
            }
        }
        if (recommendFriendEntity == null || recommendFriendEntity.getTogetherGames() == null || recommendFriendEntity.getTogetherGames().size() == 0) {
            return;
        }
        int size2 = recommendFriendEntity.getTogetherGames().size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (recommendFriendEntity.getTogetherGames().get(i3) != null && recommendFriendEntity.getTogetherGames().get(i3).getGameTitleByLanguage() != null) {
                if (TextUtils.isEmpty(this.g.get())) {
                    this.g.set(context.getString(R.string.app_search_friend_play_together) + recommendFriendEntity.getTogetherGames().get(i3).getGameTitleByLanguage());
                } else {
                    this.g.set(this.g.get() + "/" + recommendFriendEntity.getTogetherGames().get(i3).getGameTitleByLanguage());
                }
            }
        }
    }

    private void a(Context context, int i) {
        if (i == 4) {
            ReportDataAdapter.onEvent(context, EventConstant.CLICK_ADD_FRIEND, "Search Page");
        } else if (i == 5) {
            ReportDataAdapter.onEvent(context, EventConstant.ADD_FILTER_FRI, "Search Page");
        } else {
            if (i != 6) {
                return;
            }
            ReportDataAdapter.onEvent(context, EventConstant.CHAT_SEARCH_ADD_FRIEND, "Search Page");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        if (this.f11029e.get().booleanValue()) {
            return;
        }
        new n().a(this.context, ((RecommendFriendEntity) this.item).getUserId(), this.f11029e, false, this.f11026b);
        a(this.context, this.f11026b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h() {
        if (this.f11025a) {
            J.a(this.context, (Friend) null, new FriendActivityIntentInfo(((RecommendFriendEntity) this.item).getUserId(), 2), this.f11026b);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.common.base.viewmodel.ListItemViewModel
    public RecommendFriendEntity getItem() {
        return (RecommendFriendEntity) super.getItem();
    }
}
