package com.sandboxol.imchat.ui.fragment.party;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.y;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.ui.fragment.ConversationFragmentEx;
import com.sandboxol.imchat.utils.RongIMLogic;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class PartyChatDialog extends y implements View.OnClickListener, TabLayout.c {
    private PartyFragmentAdapter adapter;
    private ConversationFragmentEx conversationFragment;
    private List<Fragment> fragmentList;
    private boolean isCaptain;
    private boolean isConnectSuccess;
    private DialogInterface.OnDismissListener listener;
    private String mConversationType;
    private String mTargetId;
    private TabLayout tabLayout;
    private View vClose;
    private ViewPager viewPager;

    public PartyChatDialog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterFragment(String str, String str2) {
        if (getContext() == null) {
            dismiss();
            return;
        }
        if (getContext().getApplicationInfo() == null || getContext().getApplicationInfo().packageName == null || RongContext.getInstance() == null) {
            AppToastUtils.showShortNegativeTipToast(getContext(), getContext().getString(R.string.network_connection_failed));
            dismiss();
            return;
        }
        this.conversationFragment = new ConversationFragmentEx();
        Uri uriBuild = Uri.parse("rong://" + getContext().getApplicationInfo().packageName).buildUpon().appendPath("conversation").appendPath(str).appendQueryParameter("targetId", str2).build();
        this.conversationFragment.setUri(uriBuild);
        Log.e("enterFragment", uriBuild.toString());
        this.fragmentList.add(this.conversationFragment);
        initPagerAdapter();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CONNECT_CHAT, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.party.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18772a.g();
            }
        });
        Messenger.getDefault().register(this, ChatMessageToken.TOKEN_CLOSE_PARTY_DIALOG, new Action0() { // from class: com.sandboxol.imchat.ui.fragment.party.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f18771a.closeDialog();
            }
        });
    }

    private void initPagerAdapter() {
        this.adapter = new PartyFragmentAdapter(getChildFragmentManager(), 1, this.fragmentList);
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.addOnPageChangeListener(new ViewPager.e() { // from class: com.sandboxol.imchat.ui.fragment.party.PartyChatDialog.2
            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i) {
                if (PartyChatDialog.this.tabLayout == null || PartyChatDialog.this.tabLayout.getTabAt(i) == null) {
                    return;
                }
                PartyChatDialog.this.tabLayout.getTabAt(i).h();
            }
        });
        if (this.isCaptain) {
            return;
        }
        this.viewPager.setCurrentItem(1);
    }

    private void initPartyDefaultTextFragment() {
        this.fragmentList.add(PartyDefaultTextFragment.newInstance(this.mTargetId));
    }

    public static PartyChatDialog newInstance(DialogInterface.OnDismissListener onDismissListener, Conversation.ConversationType conversationType, String str, boolean z, boolean z2) {
        PartyChatDialog partyChatDialog = new PartyChatDialog(onDismissListener);
        Bundle bundle = new Bundle();
        bundle.putString("mTargetId", str);
        bundle.putString("conversationType", conversationType.getName().toLowerCase());
        bundle.putBoolean("isConnectSuccess", z);
        bundle.putBoolean("isCaptain", z2);
        partyChatDialog.setArguments(bundle);
        return partyChatDialog;
    }

    public void closeDialog() {
        dismissAllowingStateLoss();
    }

    public void confirm() {
        dismissAllowingStateLoss();
    }

    public /* synthetic */ void g() {
        enterFragment(this.mConversationType, this.mTargetId);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.v_close) {
            closeDialog();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.dialog_fragment);
        this.fragmentList = new ArrayList();
        initMessenger();
        RongIMLogic.initSendMessageListener(getContext());
        RongIMLogic.initUserPortraitClick();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setSoftInputMode(3);
        getDialog().getWindow().setGravity(80);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getDialog().getWindow().setSoftInputMode(32);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mTargetId = arguments.getString("mTargetId");
            this.mConversationType = arguments.getString("conversationType");
            this.isConnectSuccess = arguments.getBoolean("isConnectSuccess");
            this.isCaptain = arguments.getBoolean("isCaptain");
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_party_dialog, viewGroup, false);
        this.tabLayout = (TabLayout) viewInflate.findViewById(R.id.tab_sex);
        this.viewPager = (ViewPager) viewInflate.findViewById(R.id.vp_chat);
        this.vClose = viewInflate.findViewById(R.id.v_close);
        this.tabLayout.addOnTabSelectedListener((TabLayout.c) this);
        this.vClose.setOnClickListener(this);
        initPartyDefaultTextFragment();
        if (this.isConnectSuccess) {
            RongIM.getInstance().joinChatRoom(this.mTargetId, -1, new RongIMClient.OperationCallback() { // from class: com.sandboxol.imchat.ui.fragment.party.PartyChatDialog.1
                @Override // io.rong.imlib.RongIMClient.Callback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.Callback
                public void onSuccess() {
                    PartyChatDialog partyChatDialog = PartyChatDialog.this;
                    partyChatDialog.enterFragment(partyChatDialog.mConversationType, PartyChatDialog.this.mTargetId);
                }
            });
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e, android.content.DialogInterface.OnDismissListener
    public void onDismiss(final DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        RongIM.getInstance().quitChatRoom(this.mTargetId, new RongIMClient.OperationCallback() { // from class: com.sandboxol.imchat.ui.fragment.party.PartyChatDialog.3
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                if (PartyChatDialog.this.listener != null) {
                    PartyChatDialog.this.listener.onDismiss(dialogInterface);
                }
            }
        });
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabReselected(TabLayout.f fVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabSelected(TabLayout.f fVar) {
        this.viewPager.setCurrentItem(fVar.c());
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabUnselected(TabLayout.f fVar) {
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0327e
    public void show(AbstractC0336n abstractC0336n, String str) {
        if (abstractC0336n.a(str) == null) {
            super.show(abstractC0336n, str);
        }
    }

    public PartyChatDialog(DialogInterface.OnDismissListener onDismissListener) {
        this();
        this.listener = onDismissListener;
    }
}
