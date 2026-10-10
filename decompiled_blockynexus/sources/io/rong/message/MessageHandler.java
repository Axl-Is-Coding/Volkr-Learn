package io.rong.message;

import android.content.Context;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes.dex */
public abstract class MessageHandler<T extends MessageContent> {
    private Context context;
    protected IHandleMessageListener mHandleMessageListener;

    public MessageHandler(Context context) {
        this.context = context;
    }

    public abstract void decodeMessage(Message message, T t);

    public abstract void encodeMessage(Message message);

    public Context getContext() {
        return this.context;
    }

    public void setHandleMessageListener(IHandleMessageListener iHandleMessageListener) {
        this.mHandleMessageListener = iHandleMessageListener;
    }
}
