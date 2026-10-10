package io.rong.message;

import android.content.Context;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes.dex */
public class DefaultMessageHandler extends MessageHandler<MessageContent> {
    public DefaultMessageHandler(Context context) {
        super(context);
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, MessageContent messageContent) {
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) {
    }
}
