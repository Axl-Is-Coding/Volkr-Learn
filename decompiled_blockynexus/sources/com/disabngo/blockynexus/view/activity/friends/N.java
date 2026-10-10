package com.disabngo.blockynexus.view.activity.friends;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.greendao.entity.UserGameCareerInfo;

/* JADX INFO: compiled from: FriendMatchViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class N extends ListItemViewModel<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserGameCareerInfo f10659a;

    public N(Context context, int i, UserGameCareerInfo userGameCareerInfo) {
        super(context, Integer.valueOf(i));
        this.f10659a = userGameCareerInfo == null ? new UserGameCareerInfo() : userGameCareerInfo;
    }
}
