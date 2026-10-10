package io.rong.imkit.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imkit.widget.adapter.SubConversationListAdapter;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class SubConversationListFragment extends ConversationListFragment {
    private SubConversationListAdapter mAdapter;

    @Override // io.rong.imkit.fragment.ConversationListFragment
    public boolean getGatherState(Conversation.ConversationType conversationType) {
        return false;
    }

    @Override // io.rong.imkit.fragment.ConversationListFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // io.rong.imkit.fragment.ConversationListFragment
    public ConversationListAdapter onResolveAdapter(Context context) {
        if (this.mAdapter == null) {
            this.mAdapter = new SubConversationListAdapter(context);
        }
        return this.mAdapter;
    }

    public void setAdapter(SubConversationListAdapter subConversationListAdapter) {
        this.mAdapter = subConversationListAdapter;
    }
}
