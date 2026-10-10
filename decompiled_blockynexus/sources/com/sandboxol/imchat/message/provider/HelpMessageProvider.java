package com.sandboxol.imchat.message.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.message.entity.HelpMessage;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;

/* JADX INFO: loaded from: classes4.dex */
@ProviderTag(centerInHorizontal = true, messageContent = HelpMessage.class, showPortrait = false, showProgress = false)
public class HelpMessageProvider extends IContainerItemProvider.MessageProvider<HelpMessage> {
    private onClickListener listener;

    private class ViewHolder {
        public RelativeLayout rlParent;

        public ViewHolder(View view) {
            this.rlParent = (RelativeLayout) view.findViewById(R.id.rlParent);
        }
    }

    public interface onClickListener {
        void onClick();
    }

    public HelpMessageProvider(onClickListener onclicklistener) {
        this.listener = onclicklistener;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, HelpMessage helpMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_help, (ViewGroup) null);
        viewInflate.setTag(new ViewHolder(viewInflate));
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(HelpMessage helpMessage) {
        return new SpannableString(BaseApplication.getContext().getString(R.string.help_read));
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, HelpMessage helpMessage, UIMessage uIMessage) {
        onClickListener onclicklistener = this.listener;
        if (onclicklistener != null) {
            onclicklistener.onClick();
        }
    }
}
