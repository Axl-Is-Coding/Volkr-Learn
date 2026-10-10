package io.rong.message;

import android.content.Context;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;

/* JADX INFO: loaded from: classes5.dex */
public class ReferenceMessageHandler extends MessageHandler<ReferenceMessage> {
    public ReferenceMessageHandler(Context context) {
        super(context);
    }

    @Override // io.rong.message.MessageHandler
    public void encodeMessage(Message message) throws Throwable {
        if (message.getContent() instanceof ReferenceMessage) {
            ReferenceMessage referenceMessage = (ReferenceMessage) message.getContent();
            if (referenceMessage.getReferenceContent() == null || !(referenceMessage.getReferenceContent() instanceof ImageMessage)) {
                return;
            }
            new ImageMessageHandler(getContext()).encodeMessage(message);
        }
    }

    @Override // io.rong.message.MessageHandler
    public void decodeMessage(Message message, ReferenceMessage referenceMessage) throws Throwable {
        if (message == null || referenceMessage == null || referenceMessage.getReferenceContent() == null) {
            return;
        }
        MessageContent referenceContent = referenceMessage.getReferenceContent();
        if (referenceContent instanceof ImageMessage) {
            new ImageMessageHandler(getContext()).decodeMessage(message, (ImageMessage) referenceContent);
        }
    }
}
