package com.disabngo.blockynexus.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.disabngo.blockynexus.view.fragment.main.S;
import com.disabngo.blockynexus.view.widget.FollowFriendRecyclerView;

/* JADX INFO: compiled from: FollowFriendRecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(FollowFriendRecyclerView followFriendRecyclerView, S s) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(followFriendRecyclerView.getContext());
        linearLayoutManager.setOrientation(0);
        followFriendRecyclerView.setLayoutManager(linearLayoutManager);
        followFriendRecyclerView.setAdapter(s);
    }
}
