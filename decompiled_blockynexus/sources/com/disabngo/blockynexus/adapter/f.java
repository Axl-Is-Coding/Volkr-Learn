package com.disabngo.blockynexus.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.disabngo.blockynexus.view.fragment.partyhall.q;
import com.disabngo.blockynexus.view.widget.PartyHallHeaderView;

/* JADX INFO: compiled from: PartyHallHeaderViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(PartyHallHeaderView partyHallHeaderView, q qVar) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(partyHallHeaderView.getContext());
        linearLayoutManager.setOrientation(0);
        partyHallHeaderView.setLayoutManager(linearLayoutManager);
        partyHallHeaderView.setAdapter(qVar);
    }
}
