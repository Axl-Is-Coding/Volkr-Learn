package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.ScrapOutlineViewReturnHelper;
import com.sandboxol.center.utils.ScrapStatusHelper;
import com.sandboxol.center.view.widget.ScrapLevelImageView;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.P;
import com.sandboxol.imchat.message.entity.ScrapHelpMessage;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ProviderTag(messageContent = ScrapHelpMessage.class)
public class ScrapHelpProvider extends IContainerItemProvider.MessageProvider<ScrapHelpMessage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnClickListener f10429a;

    /* JADX INFO: renamed from: com.disabngo.blockynexus.message.provider.ScrapHelpProvider$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScrapHelpMessage f10430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f10432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ UIMessage f10433d;

        AnonymousClass1(ScrapHelpMessage scrapHelpMessage, View view, a aVar, UIMessage uIMessage) {
            this.f10430a = scrapHelpMessage;
            this.f10431b = view;
            this.f10432c = aVar;
            this.f10433d = uIMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScrapApi.receiveScrap(view.getContext(), this.f10430a.getSenderId(), this.f10430a.getScrapId(), this.f10430a.getUuid(), new m(this, view));
        }
    }

    public interface OnClickListener {
        void onClick(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f10437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f10438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f10439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TextView f10440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f10441e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ImageView f10442f;
        View g;
        RelativeLayout h;
        ScrapLevelImageView i;
        View j;

        public a(View view) {
            this.f10437a = (TextView) view.findViewById(R.id.tv_scrap_name);
            this.f10438b = (TextView) view.findViewById(R.id.tv_scrap_tips);
            this.f10439c = (TextView) view.findViewById(R.id.tv_scrap_tips_2);
            this.f10440d = (TextView) view.findViewById(R.id.tv_status_unlock);
            this.f10441e = (TextView) view.findViewById(R.id.tv_expired);
            this.f10442f = (ImageView) view.findViewById(R.id.iv_scrap_tag);
            this.g = view.findViewById(R.id.bg_scrap_shadow);
            this.h = (RelativeLayout) view.findViewById(R.id.parent_layout);
            this.i = (ScrapLevelImageView) view.findViewById(R.id.sl_image_view);
            this.j = view.findViewById(R.id.v_blank);
        }
    }

    public ScrapHelpProvider(OnClickListener onClickListener) {
        this.f10429a = onClickListener;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onItemClick(View view, int i, ScrapHelpMessage scrapHelpMessage, UIMessage uIMessage) {
        OnClickListener onClickListener = this.f10429a;
        if (onClickListener != null) {
            onClickListener.onClick(scrapHelpMessage.getScrapId());
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_help_scrap_card, (ViewGroup) null);
        viewInflate.setTag(new a(viewInflate));
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindView(View view, int i, ScrapHelpMessage scrapHelpMessage, UIMessage uIMessage) {
        a aVar = (a) view.getTag();
        if (scrapHelpMessage == null) {
            ReportDataAdapter.onEvent(BaseApplication.getContext(), "rong_fail_for_scrap_help_provider_1");
            return;
        }
        aVar.i.setPic(scrapHelpMessage.getScrapUrl());
        aVar.i.setIvLevel(scrapHelpMessage.getScrapNum());
        aVar.i.setType(scrapHelpMessage.getScrapLevel());
        aVar.f10437a.setText(scrapHelpMessage.getScrapName());
        aVar.f10437a.setTextColor(ScrapOutlineViewReturnHelper.getInsideBgColor(scrapHelpMessage.getScrapLevel()));
        if (scrapHelpMessage.getSenderId() == AccountCenter.newInstance().userId.get().longValue()) {
            aVar.j.setVisibility(0);
        } else {
            aVar.j.setVisibility(8);
        }
        a(view, aVar, scrapHelpMessage, uIMessage);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Spannable getContentSummary(ScrapHelpMessage scrapHelpMessage) {
        String string;
        string = "";
        if (scrapHelpMessage != null) {
            string = BaseApplication.getContext().getString(R.string.scrap_ask_help_summery, scrapHelpMessage.getSenderId() != AccountCenter.newInstance().userId.get().longValue() ? scrapHelpMessage.getSenderName() : "", scrapHelpMessage.getScrapName());
        }
        return new SpannableString(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, a aVar, ScrapHelpMessage scrapHelpMessage, UIMessage uIMessage) {
        int cacheStatus = ScrapStatusHelper.getInstance().getCacheStatus(scrapHelpMessage.getUuid());
        boolean z = true;
        if (cacheStatus != 1) {
            if (cacheStatus != 2) {
                aVar.g.setVisibility(8);
                aVar.f10442f.setVisibility(8);
                aVar.f10441e.setVisibility(8);
                aVar.f10440d.setVisibility(0);
                aVar.f10438b.setVisibility(8);
                aVar.f10439c.setVisibility(8);
                if (SharedUtils.getLong(BaseApplication.getContext(), scrapHelpMessage.getUuid(), 0L) == 0) {
                    SharedUtils.putLong(BaseApplication.getContext(), scrapHelpMessage.getUuid(), uIMessage.getReceivedTime());
                }
                if (scrapHelpMessage.getSenderId() != AccountCenter.newInstance().userId.get().longValue()) {
                    aVar.h.setOnClickListener(new AnonymousClass1(scrapHelpMessage, view, aVar, uIMessage));
                    return;
                } else {
                    aVar.h.setOnClickListener(null);
                    return;
                }
            }
            aVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.message.provider.ScrapHelpProvider.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_SCRAP_MAIN);
                }
            });
            aVar.g.setVisibility(0);
            aVar.f10442f.setVisibility(8);
            aVar.f10441e.setVisibility(0);
            aVar.f10440d.setVisibility(8);
            if (scrapHelpMessage.getSenderId() == AccountCenter.newInstance().userId.get().longValue()) {
                aVar.f10439c.setVisibility(0);
                aVar.f10438b.setVisibility(8);
                aVar.f10439c.setText(R.string.scrap_status_expired_tips_2);
                return;
            } else {
                aVar.f10439c.setVisibility(8);
                aVar.f10438b.setVisibility(0);
                aVar.f10438b.setText(R.string.scrap_status_expired_tips_2);
                return;
            }
        }
        aVar.g.setVisibility(0);
        aVar.f10442f.setVisibility(0);
        aVar.f10441e.setVisibility(8);
        aVar.f10440d.setVisibility(8);
        aVar.h.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.message.provider.ScrapHelpProvider.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_OPEN_SCRAP_MAIN);
            }
        });
        if (scrapHelpMessage.getSenderId() == AccountCenter.newInstance().userId.get().longValue()) {
            aVar.f10438b.setVisibility(8);
            aVar.f10439c.setVisibility(0);
            if (uIMessage.getConversationType() == Conversation.ConversationType.PRIVATE) {
                try {
                    long jLongValue = Long.valueOf(uIMessage.getTargetId()).longValue();
                    P.newInstance().a(jLongValue, new n(this, aVar, view, jLongValue));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (uIMessage.getConversationType() == Conversation.ConversationType.GROUP) {
                try {
                    GroupInfo groupInfoB = y.b().b(Long.valueOf(uIMessage.getTargetId()).longValue());
                    if (groupInfoB == null || groupInfoB.getGroupMembers() == null) {
                        return;
                    }
                    Iterator<GroupMember> it = groupInfoB.getGroupMembers().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        GroupMember next = it.next();
                        if (next.getUserId() == ScrapStatusHelper.getInstance().getRId(scrapHelpMessage.getUuid())) {
                            TextView textView = aVar.f10439c;
                            Context context = view.getContext();
                            Object[] objArr = new Object[1];
                            objArr[0] = next.getUserName() == null ? Long.valueOf(next.getUserId()) : next.getUserName();
                            textView.setText(context.getString(R.string.scrap_status_received_tips, objArr));
                        }
                    }
                    if (z) {
                        return;
                    }
                    aVar.f10439c.setText(view.getContext().getString(R.string.scrap_status_received_tips_2));
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            return;
        }
        aVar.f10438b.setVisibility(0);
        aVar.f10438b.setText(R.string.scrap_status_received_tips_2);
        aVar.f10439c.setVisibility(8);
    }
}
