package io.rong.imkit;

import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.PublicServiceMenuItem;

/* JADX INFO: loaded from: classes5.dex */
public interface IPublicServiceMenuClickListener {
    boolean onClick(Conversation.ConversationType conversationType, String str, PublicServiceMenuItem publicServiceMenuItem);
}
