package com.disabngo.blockynexus.message.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.y.C0953d;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.RoundedCornersTransform;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.SizeUtil;
import com.sandboxol.common.utils.ToastUtils;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.config.ChatSharedConstant;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.imchat.utils.DialogUtils;
import com.sandboxol.imchat.web.ChatGameApi;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.Message;

/* JADX INFO: compiled from: InviteTeamMessageProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ProviderTag(messageContent = InviteTeamMessage.class)
public class h extends IContainerItemProvider.MessageProvider<InviteTeamMessage> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10464f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10459a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f10460b = 1000;
    private C0953d g = new g(this);

    /* JADX INFO: compiled from: InviteTeamMessageProvider.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f10465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImageView f10466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f10467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ImageView f10468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ImageView f10469e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ImageView f10470f;
        TextView g;
        TextView h;
        RelativeLayout i;

        public a(View view) {
            this.f10465a = (ImageView) view.findViewById(R.id.ivLeftPoint);
            this.f10466b = (ImageView) view.findViewById(R.id.ivRightPoint);
            this.f10467c = (ImageView) view.findViewById(R.id.ivBgImg);
            this.f10468d = (ImageView) view.findViewById(R.id.ivBg);
            this.f10469e = (ImageView) view.findViewById(R.id.ivGoto);
            this.f10470f = (ImageView) view.findViewById(R.id.ivKickOut);
            this.g = (TextView) view.findViewById(R.id.tvCaptain);
            this.h = (TextView) view.findViewById(R.id.tvGame);
            this.i = (RelativeLayout) view.findViewById(R.id.rlNotExit);
        }
    }

    public h(long j, String str, String str2, String str3) {
        this.f10461c = j;
        this.f10462d = str;
        this.f10463e = str2;
        this.f10464f = str3;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_chat_invite_team, (ViewGroup) null);
        viewInflate.setTag(new a(viewInflate));
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    @SuppressLint({"CheckResult"})
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onItemClick(View view, int i, InviteTeamMessage inviteTeamMessage, UIMessage uIMessage) {
        Context context;
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND || (context = view.getContext()) == null) {
            return;
        }
        if (inviteTeamMessage.getGameVersion() != EngineEnv.getEngineVersion(inviteTeamMessage.getIsNewEngine(), inviteTeamMessage.getIsUgc())) {
            ToastUtils.showShortToast(context, R.string.party_version_different);
        } else if (SharedUtils.getLong(view.getContext(), ChatSharedConstant.SERVER_TIME) - uIMessage.getSentTime() > 1800000) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.imchat_party_not_exit);
            return;
        } else {
            DialogUtils.newsInstant().showLoadingDialog(context);
            ChatGameApi.getPartyAuth(context, this.f10461c, inviteTeamMessage.getPsid(), inviteTeamMessage.getIsNewEngine() == 1, new f(this, context, inviteTeamMessage, uIMessage));
        }
        Messenger.getDefault().send(inviteTeamMessage.getGameType(), ChatMessageToken.TOKEN_CHAT_CLICK_TO_ENTER_ROOM);
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindView(View view, int i, InviteTeamMessage inviteTeamMessage, UIMessage uIMessage) {
        a aVar = (a) view.getTag();
        if (uIMessage == null) {
            return;
        }
        aVar.f10469e.setVisibility(uIMessage.getMessageDirection() == Message.MessageDirection.SEND ? 8 : 0);
        TextView textView = aVar.g;
        Context context = view.getContext();
        Object[] objArr = new Object[1];
        objArr[0] = inviteTeamMessage.getCaptainName() == null ? "" : inviteTeamMessage.getCaptainName();
        textView.setText(context.getString(R.string.party_host_name, objArr));
        aVar.h.setText(inviteTeamMessage.getGameName() != null ? inviteTeamMessage.getGameName() : "");
        RoundedCornersTransform roundedCornersTransform = new RoundedCornersTransform(view.getContext(), SizeUtil.dp2px(view.getContext(), 4.0f));
        roundedCornersTransform.setNeedCorner(true, true, true, true);
        com.bumptech.glide.request.f fVarTransform = new com.bumptech.glide.request.f().transform(roundedCornersTransform);
        try {
            com.bumptech.glide.c.c(view.getContext()).mo53load(Integer.valueOf(R.drawable.bg_invite_friend_chat)).apply((com.bumptech.glide.request.a<?>) fVarTransform).into(aVar.f10468d);
            if (!TextUtils.isEmpty(inviteTeamMessage.getPicUrl())) {
                com.bumptech.glide.c.c(view.getContext()).mo55load(inviteTeamMessage.getPicUrl()).apply((com.bumptech.glide.request.a<?>) fVarTransform).into(aVar.f10467c);
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        if (uIMessage.getMessageDirection() == Message.MessageDirection.SEND) {
            aVar.f10465a.setVisibility(8);
            aVar.f10466b.setVisibility(0);
        } else {
            aVar.f10465a.setVisibility(0);
            aVar.f10466b.setVisibility(8);
        }
        if (SharedUtils.getBoolean(view.getContext(), ChatSharedConstant.ENTER_GAME_CHAT_MESSAGE_ID + uIMessage.getMessage().getUId())) {
            aVar.f10470f.setVisibility(0);
        }
        if (SharedUtils.getBoolean(view.getContext(), ChatSharedConstant.ENTER_GAME_CHAT_CLOSE + uIMessage.getMessage().getUId())) {
            aVar.f10470f.setVisibility(0);
        }
        if (SharedUtils.getBoolean(view.getContext(), ChatSharedConstant.ENTER_GAME_START + uIMessage.getMessage().getUId())) {
            aVar.f10470f.setVisibility(0);
            if (SharedUtils.getLong(view.getContext(), ChatSharedConstant.SERVER_TIME) - uIMessage.getSentTime() > 1800000) {
                aVar.i.setVisibility(0);
            }
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Spannable getContentSummary(InviteTeamMessage inviteTeamMessage) {
        return new SpannableString(BaseApplication.getContext().getString(R.string.invite_join_team));
    }
}
