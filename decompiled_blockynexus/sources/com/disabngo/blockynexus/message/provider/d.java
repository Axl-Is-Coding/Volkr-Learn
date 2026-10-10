package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.message.provider.InviteGroupChatMessageProvider;
import com.sandboxol.imchat.adapter.NineGridImageViewAdapter;

/* JADX INFO: compiled from: InviteGroupChatMessageProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends NineGridImageViewAdapter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InviteGroupChatMessageProvider f10450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InviteGroupChatMessageProvider.a f10451b;

    d(InviteGroupChatMessageProvider.a aVar, InviteGroupChatMessageProvider inviteGroupChatMessageProvider) {
        this.f10451b = aVar;
        this.f10450a = inviteGroupChatMessageProvider;
    }

    @Override // com.sandboxol.imchat.adapter.NineGridImageViewAdapter
    public void onDisplayImage(Context context, ImageView imageView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.bumptech.glide.c.c(context).mo53load(Integer.valueOf(R.mipmap.ic_head_default)).into(imageView);
            } else {
                com.bumptech.glide.c.c(context).mo55load(str).into(imageView);
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }
}
