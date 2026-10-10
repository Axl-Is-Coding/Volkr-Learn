package com.sandboxol.imchat.adapter;

import com.sandboxol.imchat.ui.widget.PartyMembersView;

/* JADX INFO: loaded from: classes4.dex */
public class PartyMembersBindingAdapters {
    public static void setPartyConfig(PartyMembersView partyMembersView, int i, int i2, int i3) {
        if (i == 0) {
            i = 1;
        }
        if (i2 == 0) {
            i2 = 4;
        }
        if (i3 == 0) {
            i3 = 4;
        }
        partyMembersView.viewBindingAddView(partyMembersView.getContext(), i, i2, i3);
    }
}
