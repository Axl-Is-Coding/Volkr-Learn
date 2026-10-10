package com.sandboxol.imchat.ui.fragment.party;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.C0363m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.adapter.QuickChatAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class PartyDefaultTextFragment extends Fragment {
    private RecyclerView recyclerView;
    private String targetId;

    public PartyDefaultTextFragment() {
    }

    public static PartyDefaultTextFragment newInstance(String str) {
        return new PartyDefaultTextFragment(str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_party_default_text, viewGroup, false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rv_default_text);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.addItemDecoration(new C0363m(getContext(), 1));
        this.recyclerView.setAdapter(new QuickChatAdapter(getContext(), this.targetId, QuickChatAdapter.TYPE_QUICK_CHAT_PAGE));
        return viewInflate;
    }

    public PartyDefaultTextFragment(String str) {
        this();
        this.targetId = str;
    }
}
