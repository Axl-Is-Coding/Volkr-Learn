package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.dialog.BottomDialog;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.FeedBackManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.greendao.entity.Friend;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.UIConversation;
import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class I implements RongIM.ConversationListBehaviorListener {
    I() {
    }

    public /* synthetic */ void a(UIConversation uIConversation, Context context, BottomDialog bottomDialog) {
        try {
            long j = Long.parseLong(uIConversation.getConversationTargetId());
            FriendApi.addToBlacklist(context, j, new G(this, uIConversation, j, context));
        } catch (NumberFormatException unused) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.add_blacklist_fail);
        }
    }

    public /* synthetic */ void b(UIConversation uIConversation, Context context, BottomDialog bottomDialog) {
        RongIM.getInstance().removeConversation(uIConversation.getConversationType(), uIConversation.getConversationTargetId(), new H(this, context));
        bottomDialog.cancel();
    }

    @Override // io.rong.imkit.RongIM.ConversationListBehaviorListener
    public boolean onConversationClick(Context context, View view, UIConversation uIConversation) {
        if (String.valueOf(32L).equals(uIConversation.getConversationTargetId())) {
            FeedBackManager.openFeedbackActivity();
            N.f();
            ReportDataAdapter.onEvent(context, EventConstant.CHAT_ENTER_CHAT_PAGE);
            SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ENTER_CHAT_PAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
            return true;
        }
        if (ConversationClickStateHolder.getInstance().getState() != 1) {
            return true;
        }
        ConversationClickStateHolder.getInstance().setState(0);
        if (uIConversation.getConversationType() != Conversation.ConversationType.GROUP || uIConversation.getConversationTargetId().equals(String.valueOf(com.disabngo.blockynexus.d.y.b().e()))) {
            ReportDataAdapter.onEvent(context, EventConstant.CHAT_ENTER_CHAT_PAGE);
            SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ENTER_CHAT_PAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
            return false;
        }
        N.a(context, uIConversation.getConversationTargetId(), uIConversation.getUIConversationTitle() == null ? uIConversation.getConversationTargetId() : TextEllipsizeUtil.ellipsizeString(20, uIConversation.getUIConversationTitle(), TextEllipsizeUtil.SignLib.END_POINT), false, com.disabngo.blockynexus.d.y.b().f(Long.valueOf(uIConversation.getConversationTargetId()).longValue()));
        ReportDataAdapter.onEvent(context, EventConstant.CHAT_ENTER_CHAT_PAGE);
        SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ENTER_CHAT_PAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
        return true;
    }

    @Override // io.rong.imkit.RongIM.ConversationListBehaviorListener
    public boolean onConversationLongClick(final Context context, View view, final UIConversation uIConversation) {
        BottomDialog bottomDialog = new BottomDialog(context);
        if (uIConversation.getConversationType().equals(Conversation.ConversationType.PRIVATE)) {
            bottomDialog.a(context.getString(R.string.item_add_blacklist), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.g
                @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
                public final void onClick(BottomDialog bottomDialog2) {
                    this.f10542a.a(uIConversation, context, bottomDialog2);
                }
            });
        }
        bottomDialog.a(context.getString(R.string.delete_chat), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.f
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog2) {
                this.f10539a.b(uIConversation, context, bottomDialog2);
            }
        }).a(context.getString(R.string.group_info_avoidance), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.e
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog2) {
                I.a(uIConversation, bottomDialog2);
            }
        }).a(context.getString(R.string.cancel), new BottomDialog.OnClickListener() { // from class: com.disabngo.blockynexus.utils.logic.a
            @Override // com.disabngo.blockynexus.view.dialog.BottomDialog.OnClickListener
            public final void onClick(BottomDialog bottomDialog2) {
                bottomDialog2.cancel();
            }
        }).show();
        return true;
    }

    @Override // io.rong.imkit.RongIM.ConversationListBehaviorListener
    public boolean onConversationPortraitClick(Context context, Conversation.ConversationType conversationType, String str) {
        int i = A.f10516a[conversationType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (str.equals(String.valueOf(TribeCenter.newInstance().tribeClanId.get()))) {
                    Bundle bundle = new Bundle();
                    bundle.putLong("tribe.clan.id", Long.valueOf(str).longValue());
                    TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.ma.e.class, context.getString(R.string.tribe_detail), bundle);
                } else {
                    com.disabngo.blockynexus.d.y.b().j(Long.valueOf(str).longValue());
                    N.a(context, str, TextUtils.isEmpty(com.disabngo.blockynexus.d.y.b().c(Long.valueOf(str).longValue())) ? str : TextEllipsizeUtil.ellipsizeString(20, com.disabngo.blockynexus.d.y.b().c(Long.valueOf(str).longValue()), TextEllipsizeUtil.SignLib.END_POINT), false, com.disabngo.blockynexus.d.y.b().f(Long.valueOf(str).longValue()));
                    ReportDataAdapter.onEvent(context, EventConstant.CHAT_ENTER_CHAT_PAGE);
                    SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ENTER_CHAT_PAGE, ReportEventType.NEW_USER_BEHAVIOR, "app");
                }
            }
        } else if (!str.equals(String.valueOf(32L)) && !str.equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
            Long lValueOf = 0L;
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            com.disabngo.blockynexus.e.b.x.J.a(context, (Friend) null, new FriendActivityIntentInfo(lValueOf.longValue(), 2));
        }
        return true;
    }

    @Override // io.rong.imkit.RongIM.ConversationListBehaviorListener
    public boolean onConversationPortraitLongClick(Context context, Conversation.ConversationType conversationType, String str) {
        return true;
    }

    static /* synthetic */ void a(UIConversation uIConversation, BottomDialog bottomDialog) {
        if (uIConversation.getNotificationStatus() == Conversation.ConversationNotificationStatus.DO_NOT_DISTURB) {
            N.a(uIConversation.getConversationType(), uIConversation.getConversationTargetId(), false);
        } else {
            N.a(uIConversation.getConversationType(), uIConversation.getConversationTargetId(), true);
        }
        bottomDialog.cancel();
    }
}
