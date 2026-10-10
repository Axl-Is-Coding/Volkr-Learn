package com.sandboxol.imchat.ui.fragment.conversationlist;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.c;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.adapter.BMConversationListAdapter;
import com.sandboxol.imchat.adapter.NineGridImageViewAdapter;
import com.sandboxol.imchat.config.ChatMessageToken;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class BMConversationListFragment extends ConversationListFragment {
    private BMConversationListAdapter BMAdapter;
    private NineGridImageViewAdapter<String> adapter;

    private void iniMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_REFRESH_GROUP_PIC, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.conversationlist.BMConversationListFragment.2
            @Override // rx.functions.Action0
            public void call() {
                BMConversationListFragment.this.BMAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // io.rong.imkit.fragment.ConversationListFragment, io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        iniMessenger();
    }

    @Override // io.rong.imkit.fragment.ConversationListFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // io.rong.imkit.fragment.ConversationListFragment
    public ConversationListAdapter onResolveAdapter(Context context) {
        this.adapter = new NineGridImageViewAdapter<String>() { // from class: com.sandboxol.imchat.ui.fragment.conversationlist.BMConversationListFragment.1
            @Override // com.sandboxol.imchat.adapter.NineGridImageViewAdapter
            public void onDisplayImage(Context context2, ImageView imageView, String str) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        c.c(context2).mo53load(Integer.valueOf(R.mipmap.ic_head_default)).into(imageView);
                    } else {
                        c.c(context2).mo55load(str).into(imageView);
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
            }
        };
        this.BMAdapter = new BMConversationListAdapter(context, this.adapter);
        return this.BMAdapter;
    }
}
