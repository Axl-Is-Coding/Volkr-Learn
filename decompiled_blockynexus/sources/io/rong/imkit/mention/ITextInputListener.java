package io.rong.imkit.mention;

import android.widget.EditText;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MentionedInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface ITextInputListener {
    void onDeleteClick(Conversation.ConversationType conversationType, String str, EditText editText, int i);

    MentionedInfo onSendButtonClick();

    void onTextEdit(Conversation.ConversationType conversationType, String str, int i, int i2, String str2);
}
