package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.SharedUtils;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.message.TextMessage;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements RongIM.OnSendMessageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String[] f10552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int[] f10553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long[] f10554d;

    o(Context context, String[] strArr, int[] iArr, long[] jArr) {
        this.f10551a = context;
        this.f10552b = strArr;
        this.f10553c = iArr;
        this.f10554d = jArr;
    }

    @Override // io.rong.imkit.RongIM.OnSendMessageListener
    public Message onSend(Message message) {
        if (SharedUtils.getBoolean(this.f10551a, "first.send.message", true)) {
            ReportDataAdapter.onEvent(this.f10551a, EventConstant.CHAT_MESS_FIRST);
            SharedUtils.putBoolean(this.f10551a, "first.send.message", false);
        }
        if (String.valueOf(32L).equals(message.getTargetId())) {
            MessageContent content = message.getContent();
            if ((content instanceof TextMessage) && !TextUtils.isEmpty(((TextMessage) content).getContent())) {
                N.a(32L);
            }
        }
        int i = A.f10516a[message.getConversationType().ordinal()];
        if (i == 1) {
            SandboxReportManager.onEvent(ReportEvent.USER_CHAT_NUM, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
            ReportDataAdapter.onEvent(this.f10551a, EventConstant.PRIVATE_CLICK_SEND);
        } else if (i == 2) {
            if (message.getTargetId().equals(String.valueOf(TribeCenter.newInstance().tribeClanId.get()))) {
                ReportDataAdapter.onEvent(this.f10551a, EventConstant.CLAN_CLICK_SEND);
                SandboxReportManager.onEvent(ReportEvent.USER_CLAN_CHAT_NUM, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
            } else {
                SandboxReportManager.onEvent(ReportEvent.USER_GROUP_CHAT_NUM, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
                ReportDataAdapter.onEvent(this.f10551a, EventConstant.GROUP_CLICK_SEND);
                MessageContent content2 = message.getContent();
                if (content2 instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) content2;
                    if (N.b(textMessage, this.f10552b, this.f10553c, this.f10554d)) {
                        return null;
                    }
                    if (textMessage.getContent().toLowerCase().contains(this.f10551a.getString(R.string.new_group_at_all))) {
                        boolean zB = com.disabngo.blockynexus.d.y.b().b(Long.valueOf(message.getTargetId()).longValue(), AccountCenter.newInstance().userId.get().longValue());
                        boolean zA = com.disabngo.blockynexus.d.y.b().a(Long.valueOf(message.getTargetId()).longValue(), AccountCenter.newInstance().userId.get().longValue());
                        if (zB || zA) {
                            ((TextMessage) message.getContent()).setMentionedInfo(new MentionedInfo(MentionedInfo.MentionedType.ALL, null, null));
                        }
                    }
                }
            }
        }
        return message;
    }

    @Override // io.rong.imkit.RongIM.OnSendMessageListener
    public boolean onSent(Message message, RongIM.SentMessageErrorCode sentMessageErrorCode) {
        return false;
    }
}
