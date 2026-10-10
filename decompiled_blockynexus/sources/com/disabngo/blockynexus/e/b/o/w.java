package com.disabngo.blockynexus.e.b.o;

import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.utils.TemplateUtils;
import io.rong.imkit.RongExtension;
import io.rong.imlib.model.Conversation;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChatViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements Action1<RongExtension> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f10020a;

    w(x xVar) {
        this.f10020a = xVar;
    }

    @Override // rx.functions.Action1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(RongExtension rongExtension) {
        boolean z = rongExtension.getConversationType() == Conversation.ConversationType.PRIVATE;
        String targetId = rongExtension.getTargetId();
        Bundle bundle = new Bundle();
        bundle.putBoolean(StringConstant.TYPE_GROUP_CARD, true);
        bundle.putBoolean(StringConstant.TYPE_GROUP_CARD_PRIVATE_FLAG, z);
        bundle.putString("targetId", targetId);
        if (this.f10020a.f10023c == null || this.f10020a.f10023c.getContext() == null) {
            return;
        }
        TemplateUtils.startTemplate(this.f10020a.f10023c.getContext(), com.disabngo.blockynexus.e.b.B.c.class, this.f10020a.f10021a.getString(R.string.my_group), bundle);
    }
}
