package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.imchat.message.entity.ScrapAskHelpMessage;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: ScrapAskHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ProviderTag(messageContent = ScrapAskHelpMessage.class)
public class k extends IContainerItemProvider.MessageProvider<ScrapAskHelpMessage> {

    /* JADX INFO: compiled from: ScrapAskHelpProvider.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f10475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f10476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f10477c;

        public a(View view) {
            this.f10475a = (TextView) view.findViewById(R.id.tv_ask_tips);
            this.f10476b = (TextView) view.findViewById(R.id.tv_ask_tips_2);
            this.f10477c = (TextView) view.findViewById(R.id.tv_info_tips);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindView(View view, int i, ScrapAskHelpMessage scrapAskHelpMessage, UIMessage uIMessage) {
        a aVar = (a) view.getTag();
        if (scrapAskHelpMessage != null && uIMessage.getConversationType() == Conversation.ConversationType.PRIVATE) {
            if (uIMessage.getSenderUserId().equals(String.valueOf(AccountCenter.newInstance().userId.get()))) {
                aVar.f10475a.setVisibility(8);
                aVar.f10476b.setVisibility(0);
                aVar.f10476b.setBackground(androidx.core.content.b.c(view.getContext(), R.drawable.rc_ic_bubble_right));
                aVar.f10476b.setText(view.getContext().getString(R.string.scrap_help_template, scrapAskHelpMessage.getScrapName()));
                aVar.f10477c.setVisibility(8);
                return;
            }
            aVar.f10475a.setVisibility(0);
            aVar.f10476b.setVisibility(8);
            aVar.f10475a.setBackground(androidx.core.content.b.c(view.getContext(), R.drawable.rc_ic_bubble_left));
            aVar.f10475a.setText(view.getContext().getString(R.string.scrap_help_template, scrapAskHelpMessage.getScrapName()));
            aVar.f10477c.setVisibility(0);
            a(aVar.f10477c, scrapAskHelpMessage);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onItemClick(View view, int i, ScrapAskHelpMessage scrapAskHelpMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_ask_help_scrap, (ViewGroup) null);
        viewInflate.setTag(new a(viewInflate));
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Spannable getContentSummary(ScrapAskHelpMessage scrapAskHelpMessage) {
        String string;
        string = "";
        if (scrapAskHelpMessage != null) {
            string = BaseApplication.getContext().getString(R.string.scrap_ask_help_summery_2, scrapAskHelpMessage.getUserId() != AccountCenter.newInstance().userId.get().longValue() ? scrapAskHelpMessage.getUserName() : "", scrapAskHelpMessage.getScrapName());
        }
        return new SpannableString(string);
    }

    private void a(TextView textView, ScrapAskHelpMessage scrapAskHelpMessage) {
        ScrapApi.getScrapNum(textView.getContext(), scrapAskHelpMessage.getScrapId(), new j(this, textView, scrapAskHelpMessage));
    }
}
