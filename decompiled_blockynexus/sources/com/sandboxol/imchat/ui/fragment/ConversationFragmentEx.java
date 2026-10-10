package com.sandboxol.imchat.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.imchat.SealCSEvaluateInfo;
import com.sandboxol.imchat.adapter.ConversationAdapterEX;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.model.SealCSEvaluateItem;
import com.sandboxol.imchat.ui.widget.BottomEvaluateDialog;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.messager.a.a;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.widget.AutoRefreshListView;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.cs.CustomServiceManager;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ConversationFragmentEx extends ConversationFragment {
    private ConversationAdapterEX adapterEX;
    private BottomEvaluateDialog dialog;
    private AutoRefreshListView listView;
    private List<SealCSEvaluateItem> mEvaluateList;
    private String mTargetId = "";
    private OnShowAnnounceListener onShowAnnounceListener;
    private RongExtension rongExtension;
    private View v_bg;

    public interface OnShowAnnounceListener {
        void onShowAnnounceView(String str, String str2);
    }

    private void initMessenger() {
        MessagerClient.getIns().registerMsg0(ConversationFragmentEx.class, CommonMessageToken.TOKEN_REFRESH_MESSAGE_LIST, new a() { // from class: com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.5
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                ConversationFragmentEx.this.adapterEX.notifyDataSetChanged();
                ConversationFragmentEx.this.listView.setSelection(ConversationFragmentEx.this.adapterEX.getCount() - 1);
            }
        });
    }

    private void initViewClick(View view) {
        this.v_bg = findViewById(view, R.id.v_bg);
        this.v_bg.setOnClickListener(new View.OnClickListener() { // from class: com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((InputMethodManager) ConversationFragmentEx.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 2);
                view2.setVisibility(8);
            }
        });
    }

    private void requestListViewFocus() {
        if (this.rongExtension.isExtensionExpanded()) {
            return;
        }
        this.v_bg.setVisibility(8);
        this.listView.postDelayed(new Runnable() { // from class: com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.4
            @Override // java.lang.Runnable
            public void run() {
                ConversationFragmentEx.this.listView.requestFocusFromTouch();
                ConversationFragmentEx.this.listView.setSelection((ConversationFragmentEx.this.listView.getCount() - ConversationFragmentEx.this.listView.getFooterViewsCount()) - ConversationFragmentEx.this.listView.getHeaderViewsCount());
            }
        }, 100L);
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.fragment.UriFragment
    protected void initFragment(Uri uri) {
        super.initFragment(uri);
        if (uri != null) {
            this.mTargetId = uri.getQueryParameter("targetId");
        }
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RongIMClient.getInstance().setCustomServiceHumanEvaluateListener(new CustomServiceManager.OnHumanEvaluateListener() { // from class: com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.1
            @Override // io.rong.imlib.cs.CustomServiceManager.OnHumanEvaluateListener
            public void onHumanEvaluate(JSONObject jSONObject) {
                SealCSEvaluateInfo sealCSEvaluateInfo = new SealCSEvaluateInfo(jSONObject);
                ConversationFragmentEx.this.mEvaluateList = sealCSEvaluateInfo.getSealCSEvaluateInfoList();
            }
        });
        initMessenger();
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.rongExtension = (RongExtension) viewOnCreateView.findViewById(R.id.rc_extension);
        View viewFindViewById = findViewById(viewOnCreateView, R.id.rc_layout_msg_list);
        this.listView = (AutoRefreshListView) findViewById(viewFindViewById, R.id.rc_list);
        initViewClick(viewFindViewById);
        return viewOnCreateView;
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
        MessagerClient.getIns().unRegisterMsg(ConversationFragmentEx.class);
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.IExtensionClickListener
    public void onEditTextClick(EditText editText) {
        if (this.rongExtension.isExtensionExpanded()) {
            return;
        }
        this.v_bg.setVisibility(0);
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_PARTY_SHRINK_EDIT_TEXT);
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.IExtensionClickListener
    public void onEmoticonToggleClick(View view, ViewGroup viewGroup) {
        requestListViewFocus();
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.fragment.UriFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (getActivity() != null && getActivity().isFinishing()) {
            RongIMClient.getInstance().setCustomServiceHumanEvaluateListener(null);
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.v_bg.getWindowToken(), 2);
    }

    @Override // io.rong.imkit.fragment.ConversationFragment, io.rong.imkit.IExtensionClickListener
    public void onPluginToggleClick(View view, ViewGroup viewGroup) {
        requestListViewFocus();
    }

    @Override // io.rong.imkit.fragment.ConversationFragment
    public void onReadReceiptStateClick(Message message) {
        message.getConversationType();
        Conversation.ConversationType conversationType = Conversation.ConversationType.GROUP;
    }

    @Override // io.rong.imkit.fragment.ConversationFragment
    public MessageListAdapter onResolveAdapter(Context context) {
        this.adapterEX = new ConversationAdapterEX(context);
        return this.adapterEX;
    }

    @Override // io.rong.imkit.fragment.ConversationFragment
    public void onShowAnnounceView(String str, String str2) {
        OnShowAnnounceListener onShowAnnounceListener = this.onShowAnnounceListener;
        if (onShowAnnounceListener != null) {
            onShowAnnounceListener.onShowAnnounceView(str, str2);
        }
    }

    @Override // io.rong.imkit.fragment.ConversationFragment
    public void onShowStarAndTabletDialog(String str) {
        showStartDialog(str);
    }

    @Override // io.rong.imkit.fragment.ConversationFragment
    public void onWarningDialog(String str) {
        if (getUri().getLastPathSegment().equals("chatroom")) {
            return;
        }
        super.onWarningDialog(str);
    }

    public void setOnShowAnnounceBarListener(OnShowAnnounceListener onShowAnnounceListener) {
        this.onShowAnnounceListener = onShowAnnounceListener;
    }

    public void showStartDialog(final String str) {
        BottomEvaluateDialog bottomEvaluateDialog = this.dialog;
        if (bottomEvaluateDialog != null && bottomEvaluateDialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.dialog = new BottomEvaluateDialog(getActivity(), this.mEvaluateList);
        this.dialog.show();
        this.dialog.setEvaluateDialogBehaviorListener(new BottomEvaluateDialog.OnEvaluateDialogBehaviorListener() { // from class: com.sandboxol.imchat.ui.fragment.ConversationFragmentEx.3
            @Override // com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.OnEvaluateDialogBehaviorListener
            public void onCancel() {
                if (ConversationFragmentEx.this.dialog == null || ConversationFragmentEx.this.getActivity() == null) {
                    return;
                }
                ConversationFragmentEx.this.getActivity().finish();
            }

            @Override // com.sandboxol.imchat.ui.widget.BottomEvaluateDialog.OnEvaluateDialogBehaviorListener
            public void onSubmit(int i, String str2, CustomServiceConfig.CSEvaSolveStatus cSEvaSolveStatus, String str3) {
                RongIMClient.getInstance().evaluateCustomService(ConversationFragmentEx.this.mTargetId, i, cSEvaSolveStatus, str2, str3, str, null);
                if (ConversationFragmentEx.this.dialog == null || ConversationFragmentEx.this.getActivity() == null) {
                    return;
                }
                ConversationFragmentEx.this.getActivity().finish();
            }
        });
    }
}
