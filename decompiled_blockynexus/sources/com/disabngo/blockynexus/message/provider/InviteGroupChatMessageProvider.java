package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.sandboxol.imchat.adapter.NineGridImageViewAdapter;
import com.sandboxol.imchat.message.entity.InviteGroupChatMesssage;
import com.sandboxol.imchat.widget.NineGirdImageView;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ProviderTag(messageContent = InviteGroupChatMesssage.class)
public class InviteGroupChatMessageProvider extends IContainerItemProvider.MessageProvider<InviteGroupChatMesssage> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnClickListener f10421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    NineGridImageViewAdapter<String> f10422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Long, List<String>> f10423c = new HashMap();

    public interface OnClickListener {
        void onClick(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f10424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        NineGirdImageView<String> f10425b;

        public a(View view) {
            this.f10424a = (TextView) view.findViewById(R.id.tv_groupName);
            this.f10425b = (NineGirdImageView) view.findViewById(R.id.ivNineGird);
            InviteGroupChatMessageProvider.this.f10422b = new d(this, InviteGroupChatMessageProvider.this);
            this.f10425b.setAdapter(InviteGroupChatMessageProvider.this.f10422b);
        }
    }

    public InviteGroupChatMessageProvider(OnClickListener onClickListener) {
        this.f10421a = onClickListener;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindView(View view, int i, InviteGroupChatMesssage inviteGroupChatMesssage, UIMessage uIMessage) {
        a aVar = (a) view.getTag();
        if (inviteGroupChatMesssage == null) {
            return;
        }
        aVar.f10424a.setText(inviteGroupChatMesssage.getMsg());
        aVar.f10425b.setVisibility(0);
        if (this.f10423c.keySet().contains(Long.valueOf(inviteGroupChatMesssage.getGroupId()))) {
            aVar.f10425b.setImagesData(this.f10423c.get(Long.valueOf(inviteGroupChatMesssage.getGroupId())));
        } else {
            y.b().a(inviteGroupChatMesssage.getGroupId(), aVar.f10425b, this.f10423c);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onItemClick(View view, int i, InviteGroupChatMesssage inviteGroupChatMesssage, UIMessage uIMessage) {
        OnClickListener onClickListener = this.f10421a;
        if (onClickListener != null) {
            onClickListener.onClick(inviteGroupChatMesssage.getGroupId());
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_invite_groupchat_card, (ViewGroup) null);
        viewInflate.setTag(new a(viewInflate));
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Spannable getContentSummary(InviteGroupChatMesssage inviteGroupChatMesssage) {
        return new SpannableString(TextUtils.isEmpty(inviteGroupChatMesssage.getMsg()) ? "" : inviteGroupChatMesssage.getMsg());
    }
}
