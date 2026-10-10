package com.sandboxol.imchat.ui.fragment.party;

import androidx.fragment.app.A;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PartyFragmentAdapter extends A {
    private List<Fragment> fragments;

    public PartyFragmentAdapter(AbstractC0336n abstractC0336n, int i, List<Fragment> list) {
        super(abstractC0336n, i);
        this.fragments = list;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.A
    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }
}
