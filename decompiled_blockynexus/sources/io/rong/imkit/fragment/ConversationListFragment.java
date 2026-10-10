package io.rong.imkit.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.UIConversation;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.voiceMessageDownload.AutoDownloadEntry;
import io.rong.imkit.voiceMessageDownload.HQVoiceMsgDownloadManager;
import io.rong.imkit.widget.RongSwipeRefreshLayout;
import io.rong.imkit.widget.adapter.ConversationListAdapter;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.ConversationStatus;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ReadReceiptMessage;
import io.rong.push.RongPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationListFragment extends UriFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, RongSwipeRefreshLayout.OnFlushListener, RongSwipeRefreshLayout.OnLoadListener, ConversationListAdapter.OnPortraitItemClick {
    private static final int REQUEST_MSG_DOWNLOAD_PERMISSION = 1001;
    public static final String TAG = "ConversationListFragment";
    private boolean enableAutomaticDownloadMsg;
    private ImageView headerNetWorkImage;
    private TextView headerNetWorkText;
    private View headerNetWorkView;
    private ConversationListAdapter mAdapter;
    private List<ConversationConfig> mConversationsConfig;
    private ListView mList;
    private RongSwipeRefreshLayout mRefreshLayout;
    private ConversationListFragment mThis;
    private View netWorkBar;
    private boolean isShowWithoutConnected = false;
    private int leftOfflineMsg = 0;
    private long timestamp = 0;
    private int pageSize = 100;
    private ArrayList<Message> cacheEventList = new ArrayList<>();

    private class ConversationConfig {
        Conversation.ConversationType conversationType;
        boolean isGathered;

        private ConversationConfig() {
        }
    }

    private void buildMultiDialog(final UIConversation uIConversation) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        String[] strArr = new String[2];
        if (uIConversation.isTop()) {
            strArr[0] = context.getString(R.string.rc_conversation_list_dialog_cancel_top);
        } else {
            strArr[0] = context.getString(R.string.rc_conversation_list_dialog_set_top);
        }
        strArr[1] = context.getString(R.string.rc_conversation_list_dialog_remove);
        OptionsPopupDialog.newInstance(getActivity(), strArr).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.fragment.ConversationListFragment.15
            @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
            public void onOptionsItemClicked(int i) {
                if (i == 0) {
                    RongIM.getInstance().setConversationToTop(uIConversation.getConversationType(), uIConversation.getConversationTargetId(), true ^ uIConversation.isTop(), new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.fragment.ConversationListFragment.15.1
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Boolean bool) {
                            if (uIConversation.isTop()) {
                                AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                                Toast.makeText(context, ConversationListFragment.this.getString(R.string.rc_conversation_list_popup_cancel_top), 0).show();
                            } else {
                                AnonymousClass15 anonymousClass152 = AnonymousClass15.this;
                                Toast.makeText(context, ConversationListFragment.this.getString(R.string.rc_conversation_list_dialog_set_top), 0).show();
                            }
                        }
                    });
                } else if (i == 1) {
                    RongIM.getInstance().removeConversation(uIConversation.getConversationType(), uIConversation.getConversationTargetId(), null);
                }
            }
        }).show();
    }

    private void buildSingleDialog(final UIConversation uIConversation) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        OptionsPopupDialog.newInstance(getActivity(), new String[]{context.getString(R.string.rc_conversation_list_dialog_remove)}).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.fragment.ConversationListFragment.16
            @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
            public void onOptionsItemClicked(int i) {
                RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.16.1
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(List<Conversation> list) {
                        if (list == null || list.size() <= 0) {
                            return;
                        }
                        for (Conversation conversation : list) {
                            RongIM.getInstance().removeConversation(conversation.getConversationType(), conversation.getTargetId(), null);
                        }
                    }
                }, uIConversation.getConversationType());
                ConversationListFragment.this.mAdapter.remove(ConversationListFragment.this.mAdapter.findGatheredItem(uIConversation.getConversationType()));
                ConversationListFragment.this.mAdapter.notifyDataSetChanged();
            }
        }).show();
    }

    private Conversation.ConversationType[] getConfigConversationTypes() {
        Conversation.ConversationType[] conversationTypeArr = new Conversation.ConversationType[this.mConversationsConfig.size()];
        for (int i = 0; i < this.mConversationsConfig.size(); i++) {
            conversationTypeArr[i] = this.mConversationsConfig.get(i).conversationType;
        }
        return conversationTypeArr;
    }

    private void getConversationList(Conversation.ConversationType[] conversationTypeArr, final boolean z) {
        getConversationList(conversationTypeArr, new IHistoryDataResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.1
            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onError() {
                RLog.e(ConversationListFragment.TAG, "getConversationList Error");
                ConversationListFragment conversationListFragment = ConversationListFragment.this;
                conversationListFragment.onFinishLoadConversationList(conversationListFragment.leftOfflineMsg);
                ConversationListFragment.this.isShowWithoutConnected = true;
                ConversationListFragment.this.mRefreshLayout.setLoadMoreFinish(false);
            }

            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onResult(List<Conversation> list) {
                if (list == null || list.size() <= 0) {
                    ConversationListFragment.this.isShowWithoutConnected = true;
                } else {
                    ConversationListFragment.this.makeUiConversationList(list);
                    RLog.d(ConversationListFragment.TAG, "getConversationList : listSize = " + list.size());
                    ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                    ConversationListFragment.this.onUnreadCountChanged();
                    ConversationListFragment conversationListFragment = ConversationListFragment.this;
                    conversationListFragment.updateConversationReadReceipt(conversationListFragment.cacheEventList);
                }
                ConversationListFragment conversationListFragment2 = ConversationListFragment.this;
                conversationListFragment2.onFinishLoadConversationList(conversationListFragment2.leftOfflineMsg);
                if (!z) {
                    ConversationListFragment.this.mRefreshLayout.setRefreshing(false);
                    return;
                }
                if (list == null) {
                    ConversationListFragment.this.mRefreshLayout.setLoadMoreFinish(false);
                    return;
                }
                if (list.size() > 0 && list.size() <= ConversationListFragment.this.pageSize) {
                    ConversationListFragment.this.mRefreshLayout.setLoadMoreFinish(false);
                } else if (list.size() != 0) {
                    ConversationListFragment.this.mRefreshLayout.setLoadMoreFinish(false);
                } else {
                    ConversationListFragment.this.mRefreshLayout.setLoadMoreFinish(false);
                    ConversationListFragment.this.mRefreshLayout.setCanLoading(false);
                }
            }
        }, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPosition(UIConversation uIConversation) {
        int count = this.mAdapter.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            if (!uIConversation.isTop()) {
                if (!this.mAdapter.getItem(i2).isTop() && this.mAdapter.getItem(i2).getUIConversationTime() <= uIConversation.getUIConversationTime()) {
                    break;
                }
                i++;
            } else {
                if (!this.mAdapter.getItem(i2).isTop() || this.mAdapter.getItem(i2).getUIConversationTime() <= uIConversation.getUIConversationTime()) {
                    break;
                }
                i++;
            }
        }
        return i;
    }

    private void inflateHeaderView() {
        List<View> listOnAddHeaderView = onAddHeaderView();
        if (listOnAddHeaderView == null || listOnAddHeaderView.size() <= 0) {
            return;
        }
        Iterator<View> it = listOnAddHeaderView.iterator();
        while (it.hasNext()) {
            this.mList.addHeaderView(it.next());
        }
    }

    private boolean isConfigured(Conversation.ConversationType conversationType) {
        for (int i = 0; i < this.mConversationsConfig.size(); i++) {
            if (conversationType.equals(this.mConversationsConfig.get(i).conversationType)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UIConversation makeUIConversation(List<Conversation> list) {
        Conversation conversation = list.get(0);
        int unreadMessageCount = 0;
        boolean z = false;
        for (Conversation conversation2 : list) {
            if (!conversation.isTop() ? conversation2.isTop() || conversation2.getSentTime() > conversation.getSentTime() : conversation2.isTop() && conversation2.getSentTime() > conversation.getSentTime()) {
                conversation = conversation2;
            }
            if (conversation2.getMentionedCount() > 0) {
                z = true;
            }
            unreadMessageCount += conversation2.getUnreadMessageCount();
        }
        UIConversation uIConversationObtain = UIConversation.obtain(getActivity(), conversation, getGatherState(conversation.getConversationType()));
        uIConversationObtain.setUnReadMessageCount(unreadMessageCount);
        uIConversationObtain.setTop(false);
        uIConversationObtain.setMentionedFlag(z);
        return uIConversationObtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeUiConversationList(List<Conversation> list) {
        for (Conversation conversation : list) {
            Conversation.ConversationType conversationType = conversation.getConversationType();
            String targetId = conversation.getTargetId();
            if (getGatherState(conversationType)) {
                int iFindGatheredItem = this.mAdapter.findGatheredItem(conversationType);
                if (iFindGatheredItem >= 0) {
                    this.mAdapter.getItem(iFindGatheredItem).updateConversation(getContext(), conversation, true);
                } else {
                    UIConversation uIConversationObtain = UIConversation.obtain((Context) getActivity(), conversation, true);
                    onUIConversationCreated(uIConversationObtain);
                    this.mAdapter.add(uIConversationObtain);
                }
            } else {
                int iFindPosition = this.mAdapter.findPosition(conversationType, targetId);
                if (iFindPosition < 0) {
                    UIConversation uIConversationObtain2 = UIConversation.obtain((Context) getActivity(), conversation, false);
                    onUIConversationCreated(uIConversationObtain2);
                    this.mAdapter.add(uIConversationObtain2, getPosition(uIConversationObtain2));
                } else {
                    UIConversation item = this.mAdapter.getItem(iFindPosition);
                    if (item.getUIConversationTime() <= conversation.getSentTime()) {
                        this.mAdapter.remove(iFindPosition);
                        item.updateConversation(getContext(), conversation, false);
                        this.mAdapter.add(item, getPosition(item));
                    } else {
                        item.setUnReadMessageCount(conversation.getUnreadMessageCount());
                    }
                }
            }
        }
    }

    private void removeConversation(final Conversation.ConversationType conversationType, String str) {
        if (getGatherState(conversationType)) {
            if (this.mAdapter.findGatheredItem(conversationType) >= 0) {
                RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.14
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(List<Conversation> list) {
                        int iFindGatheredItem;
                        if (ConversationListFragment.this.getActivity() == null || ConversationListFragment.this.getActivity().isFinishing() || (iFindGatheredItem = ConversationListFragment.this.mAdapter.findGatheredItem(conversationType)) < 0) {
                            return;
                        }
                        ConversationListFragment.this.mAdapter.remove(iFindGatheredItem);
                        if (list != null && list.size() > 0) {
                            UIConversation uIConversationMakeUIConversation = ConversationListFragment.this.makeUIConversation(list);
                            ConversationListFragment.this.mAdapter.add(uIConversationMakeUIConversation, ConversationListFragment.this.getPosition(uIConversationMakeUIConversation));
                        }
                        ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        ConversationListFragment.this.onUnreadCountChanged();
                    }
                }, conversationType);
            }
        } else {
            int iFindPosition = this.mAdapter.findPosition(conversationType, str);
            if (iFindPosition >= 0) {
                this.mAdapter.remove(iFindPosition);
                this.mAdapter.notifyDataSetChanged();
                onUnreadCountChanged();
            }
        }
    }

    private boolean selectNextUnReadItem(int i, int i2) {
        while (true) {
            if (i >= i2) {
                i = -1;
                break;
            }
            UIConversation item = this.mAdapter.getItem(i);
            if (item == null || item.getUnReadMessageCount() > 0) {
                break;
            }
            i++;
        }
        if (i < 0 || i >= i2) {
            return false;
        }
        ListView listView = this.mList;
        listView.setSelection(i + listView.getHeaderViewsCount());
        return true;
    }

    private void setNotificationBarVisibility(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        View view;
        if (!getResources().getBoolean(R.bool.rc_is_show_warning_notification)) {
            RLog.e(TAG, "rc_is_show_warning_notification is disabled.");
            return;
        }
        final String string = null;
        if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.NETWORK_UNAVAILABLE)) {
            string = getResources().getString(R.string.rc_notice_network_unavailable);
        } else if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.KICKED_OFFLINE_BY_OTHER_CLIENT)) {
            string = getResources().getString(R.string.rc_notice_tick);
        } else if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
            this.headerNetWorkView.setVisibility(8);
        } else if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
            string = getResources().getString(R.string.rc_notice_disconnect);
        } else if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING) || connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND)) {
            string = getResources().getString(R.string.rc_notice_connecting);
        }
        if (string == null || (view = this.headerNetWorkView) == null) {
            return;
        }
        if (view.getVisibility() == 8) {
            getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.fragment.ConversationListFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    if (RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED)) {
                        return;
                    }
                    ConversationListFragment.this.headerNetWorkView.setVisibility(0);
                    ConversationListFragment.this.headerNetWorkText.setText(string);
                    if (RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING) || RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND)) {
                        ConversationListFragment.this.headerNetWorkImage.setImageResource(R.drawable.rc_notification_connecting_animated);
                    } else {
                        ConversationListFragment.this.headerNetWorkImage.setImageResource(R.drawable.rc_notification_network_available);
                    }
                }
            }, 4000L);
            return;
        }
        this.headerNetWorkText.setText(string);
        if (RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTING) || RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.SUSPEND)) {
            this.headerNetWorkImage.setImageResource(R.drawable.rc_notification_connecting_animated);
        } else {
            this.headerNetWorkImage.setImageResource(R.drawable.rc_notification_network_available);
        }
    }

    private void syncUnreadCount() {
        if (this.mAdapter.getCount() > 0) {
            for (int i = 0; i < this.mAdapter.getCount(); i++) {
                final UIConversation item = this.mAdapter.getItem(i);
                Conversation.ConversationType conversationType = item.getConversationType();
                String conversationTargetId = item.getConversationTargetId();
                if (getGatherState(conversationType)) {
                    this.mAdapter.findGatheredItem(conversationType);
                    RongIMClient.getInstance().getUnreadCount(new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.fragment.ConversationListFragment.4
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Integer num) {
                            item.setUnReadMessageCount(num.intValue());
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                            ConversationListFragment.this.onUnreadCountChanged();
                        }
                    }, conversationType);
                } else {
                    this.mAdapter.findPosition(conversationType, conversationTargetId);
                    RongIMClient.getInstance().getUnreadCount(conversationType, conversationTargetId, new RongIMClient.ResultCallback<Integer>() { // from class: io.rong.imkit.fragment.ConversationListFragment.5
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Integer num) {
                            item.setUnReadMessageCount(num.intValue());
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                            ConversationListFragment.this.onUnreadCountChanged();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConversationReadReceipt(ArrayList<Message> arrayList) {
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            Conversation.ConversationType conversationType = next.getConversationType();
            int iFindPosition = this.mAdapter.findPosition(conversationType, next.getTargetId());
            if (!getGatherState(conversationType) && iFindPosition >= 0) {
                UIConversation item = this.mAdapter.getItem(iFindPosition);
                ReadReceiptMessage readReceiptMessage = (ReadReceiptMessage) next.getContent();
                if (readReceiptMessage.getLastMessageSendTime() >= item.getSyncReadReceiptTime() && item.getConversationSenderId().equals(RongIMClient.getInstance().getCurrentUserId())) {
                    item.setSentStatus(Message.SentStatus.READ);
                    item.setSyncReadReceiptTime(readReceiptMessage.getLastMessageSendTime());
                    ConversationListAdapter conversationListAdapter = this.mAdapter;
                    ListView listView = this.mList;
                    conversationListAdapter.getView(iFindPosition, listView.getChildAt((iFindPosition - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                    it.remove();
                } else if (readReceiptMessage.getLastMessageSendTime() < item.getUIConversationTime()) {
                    RLog.d(TAG, "remove cache event. id:" + next.getTargetId());
                    it.remove();
                }
            }
        }
    }

    public void focusUnreadItem() {
        ListView listView = this.mList;
        if (listView == null || this.mAdapter == null) {
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int lastVisiblePosition = this.mList.getLastVisiblePosition();
        int count = this.mAdapter.getCount();
        int iMax = Math.max(0, firstVisiblePosition - this.mList.getHeaderViewsCount());
        int i = count - 1;
        int iMin = Math.min(i, lastVisiblePosition - this.mList.getHeaderViewsCount());
        if ((iMin - iMax) + 1 < count) {
            if (selectNextUnReadItem(iMin < i ? iMax + 1 : 0, count)) {
                return;
            }
            selectNextUnReadItem(0, count);
        }
    }

    public boolean getGatherState(Conversation.ConversationType conversationType) {
        for (ConversationConfig conversationConfig : this.mConversationsConfig) {
            if (conversationConfig.conversationType.equals(conversationType)) {
                return conversationConfig.isGathered;
            }
        }
        return false;
    }

    @Override // io.rong.imkit.fragment.UriFragment
    protected void initFragment(Uri uri) {
        RLog.d(TAG, "initFragment " + uri);
        if (this.mConversationsConfig == null) {
            this.mConversationsConfig = new ArrayList();
        }
        Conversation.ConversationType[] conversationTypeArr = {Conversation.ConversationType.PRIVATE, Conversation.ConversationType.GROUP, Conversation.ConversationType.DISCUSSION, Conversation.ConversationType.SYSTEM, Conversation.ConversationType.CUSTOMER_SERVICE, Conversation.ConversationType.CHATROOM, Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE, Conversation.ConversationType.ENCRYPTED};
        this.timestamp = 0L;
        this.isShowWithoutConnected = false;
        this.leftOfflineMsg = 0;
        this.mConversationsConfig.clear();
        int length = conversationTypeArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Conversation.ConversationType conversationType = conversationTypeArr[i];
            if (uri.getQueryParameter(conversationType.getName()) != null) {
                ConversationConfig conversationConfig = new ConversationConfig();
                conversationConfig.conversationType = conversationType;
                conversationConfig.isGathered = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(uri.getQueryParameter(conversationType.getName()));
                this.mConversationsConfig.add(conversationConfig);
            }
            i++;
        }
        if (this.mConversationsConfig.size() == 0) {
            String queryParameter = uri.getQueryParameter("type");
            int length2 = conversationTypeArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                Conversation.ConversationType conversationType2 = conversationTypeArr[i2];
                if (conversationType2.getName().equals(queryParameter)) {
                    ConversationConfig conversationConfig2 = new ConversationConfig();
                    conversationConfig2.conversationType = conversationType2;
                    conversationConfig2.isGathered = false;
                    this.mConversationsConfig.add(conversationConfig2);
                    break;
                }
                i2++;
            }
        }
        this.mAdapter.clear();
        if (!RongIMClient.getInstance().getCurrentConnectionStatus().equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.UNCONNECTED)) {
            getConversationList(getConfigConversationTypes(), false);
        } else {
            RLog.d(TAG, "RongCloud haven't been connected yet, so the conversation list display blank !!!");
            this.isShowWithoutConnected = true;
        }
    }

    protected List<View> onAddHeaderView() {
        return new ArrayList();
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mThis = this;
        this.mConversationsConfig = new ArrayList();
        EventBus.getDefault().register(this);
        InternalModuleManager.getInstance().onLoaded();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_conversationlist, viewGroup, false);
        View viewFindViewById = findViewById(viewInflate, R.id.rc_conversation_list_empty_layout);
        TextView textView = (TextView) findViewById(viewInflate, R.id.rc_empty_tv);
        if (getActivity() != null) {
            textView.setText(getActivity().getResources().getString(R.string.rc_conversation_list_empty_prompt));
        }
        this.mList = (ListView) findViewById(viewInflate, R.id.rc_list);
        this.mRefreshLayout = (RongSwipeRefreshLayout) findViewById(viewInflate, R.id.rc_refresh);
        this.mList.setEmptyView(viewFindViewById);
        inflateHeaderView();
        this.mList.setOnItemClickListener(this);
        this.mList.setOnItemLongClickListener(this);
        if (this.mAdapter == null) {
            this.mAdapter = onResolveAdapter(getActivity());
        }
        this.mAdapter.setOnPortraitItemClick(this);
        this.mRefreshLayout.setCanRefresh(false);
        this.mRefreshLayout.setCanLoading(true);
        this.mRefreshLayout.setOnLoadListener(this);
        this.mRefreshLayout.setOnFlushListener(this);
        this.mList.setAdapter((ListAdapter) this.mAdapter);
        if (getContext() != null) {
            this.enableAutomaticDownloadMsg = getContext().getResources().getBoolean(R.bool.rc_enable_automatic_download_voice_msg);
        }
        this.headerNetWorkView = findViewById(viewInflate, R.id.rc_status_bar);
        this.headerNetWorkImage = (ImageView) findViewById(viewInflate, R.id.rc_status_bar_image);
        this.headerNetWorkText = (TextView) findViewById(viewInflate, R.id.rc_status_bar_text);
        return viewInflate;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this.mThis);
        this.cacheEventList.clear();
        super.onDestroy();
    }

    public void onEventMainThread(Event.SyncReadStatusEvent syncReadStatusEvent) {
        Conversation.ConversationType conversationType = syncReadStatusEvent.getConversationType();
        String targetId = syncReadStatusEvent.getTargetId();
        RLog.d(TAG, "SyncReadStatusEvent " + conversationType + " " + targetId);
        int iFindGatheredItem = getGatherState(conversationType) ? this.mAdapter.findGatheredItem(conversationType) : this.mAdapter.findPosition(conversationType, targetId);
        if (iFindGatheredItem >= 0) {
            this.mAdapter.getItem(iFindGatheredItem).clearUnRead(conversationType, targetId);
            this.mAdapter.notifyDataSetChanged();
        }
        onUnreadCountChanged();
    }

    public void onFinishLoadConversationList(int i) {
    }

    @Override // io.rong.imkit.widget.RongSwipeRefreshLayout.OnFlushListener
    public void onFlush() {
        getConversationList(getConfigConversationTypes(), false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount;
        Long l = (Long) view.getTag(R.id.rc_debounceClick_last_timestamp);
        long jUptimeMillis = SystemClock.uptimeMillis();
        view.setTag(R.id.rc_debounceClick_last_timestamp, Long.valueOf(jUptimeMillis));
        if ((l == null || Math.abs(jUptimeMillis - l.longValue()) > 1000) && (headerViewsCount = i - this.mList.getHeaderViewsCount()) >= 0 && headerViewsCount < this.mAdapter.getCount()) {
            UIConversation item = this.mAdapter.getItem(headerViewsCount);
            Conversation.ConversationType conversationType = item.getConversationType();
            if (getGatherState(conversationType)) {
                RongIM.getInstance().startSubConversationList(getActivity(), conversationType);
            } else if (RongContext.getInstance().getConversationListBehaviorListener() == null || !RongContext.getInstance().getConversationListBehaviorListener().onConversationClick(getActivity(), view, item)) {
                item.setUnReadMessageCount(0);
                RongIM.getInstance().startConversation(getActivity(), conversationType, item.getConversationTargetId(), item.getUIConversationTitle());
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.mList.getHeaderViewsCount();
        if (headerViewsCount < 0 || headerViewsCount >= this.mAdapter.getCount()) {
            return false;
        }
        UIConversation item = this.mAdapter.getItem(headerViewsCount);
        if (RongContext.getInstance().getConversationListBehaviorListener() != null && RongContext.getInstance().getConversationListBehaviorListener().onConversationLongClick(getActivity(), view, item)) {
            return true;
        }
        if (getGatherState(item.getConversationType())) {
            buildSingleDialog(item);
            return true;
        }
        buildMultiDialog(item);
        return true;
    }

    @Override // io.rong.imkit.widget.RongSwipeRefreshLayout.OnLoadListener
    public void onLoad() {
        getConversationList(getConfigConversationTypes(), true);
    }

    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter.OnPortraitItemClick
    public void onPortraitItemClick(View view, UIConversation uIConversation) {
        Conversation.ConversationType conversationType = uIConversation.getConversationType();
        if (getGatherState(conversationType)) {
            RongIM.getInstance().startSubConversationList(getActivity(), conversationType);
        } else if (RongContext.getInstance().getConversationListBehaviorListener() == null || !RongContext.getInstance().getConversationListBehaviorListener().onConversationPortraitClick(getActivity(), conversationType, uIConversation.getConversationTargetId())) {
            uIConversation.setUnReadMessageCount(0);
            RongIM.getInstance().startConversation(getActivity(), conversationType, uIConversation.getConversationTargetId(), uIConversation.getUIConversationTitle());
        }
    }

    @Override // io.rong.imkit.widget.adapter.ConversationListAdapter.OnPortraitItemClick
    public boolean onPortraitItemLongClick(View view, UIConversation uIConversation) {
        Conversation.ConversationType conversationType = uIConversation.getConversationType();
        if (RongContext.getInstance().getConversationListBehaviorListener() != null && RongContext.getInstance().getConversationListBehaviorListener().onConversationPortraitLongClick(getActivity(), conversationType, uIConversation.getConversationTargetId())) {
            return true;
        }
        if (getGatherState(conversationType)) {
            buildSingleDialog(uIConversation);
            return true;
        }
        buildMultiDialog(uIConversation);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1001 && iArr.length > 0 && iArr[0] == 0) {
            HQVoiceMsgDownloadManager.getInstance().resumeDownloadService();
        }
    }

    public ConversationListAdapter onResolveAdapter(Context context) {
        this.mAdapter = new ConversationListAdapter(context);
        return this.mAdapter;
    }

    @Override // io.rong.imkit.fragment.UriFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RLog.d(TAG, "onResume " + RongIM.getInstance().getCurrentConnectionStatus());
        if (getResources().getBoolean(R.bool.rc_wipe_out_notification_message)) {
            RongPushClient.clearAllNotifications(getActivity());
        }
        setNotificationBarVisibility(RongIM.getInstance().getCurrentConnectionStatus());
    }

    public void onUIConversationCreated(UIConversation uIConversation) {
    }

    public void onUnreadCountChanged() {
    }

    @Deprecated
    public void setAdapter(ConversationListAdapter conversationListAdapter) {
        this.mAdapter = conversationListAdapter;
        ListView listView = this.mList;
        if (listView != null) {
            listView.setAdapter((ListAdapter) conversationListAdapter);
        }
    }

    public boolean shouldFilterConversation(Conversation.ConversationType conversationType, String str) {
        return false;
    }

    public boolean shouldUpdateConversation(Message message, int i) {
        return true;
    }

    public void updateListItem(UIConversation uIConversation) {
        int iFindPosition = this.mAdapter.findPosition(uIConversation.getConversationType(), uIConversation.getConversationTargetId());
        if (iFindPosition >= 0) {
            ConversationListAdapter conversationListAdapter = this.mAdapter;
            ListView listView = this.mList;
            conversationListAdapter.getView(iFindPosition, listView.getChildAt((iFindPosition - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
        }
    }

    public void getConversationList(Conversation.ConversationType[] conversationTypeArr, final IHistoryDataResultCallback<List<Conversation>> iHistoryDataResultCallback, boolean z) {
        RongIMClient.getInstance().getConversationListByPage(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.2
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                if (iHistoryDataResultCallback2 != null) {
                    iHistoryDataResultCallback2.onError();
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Conversation> list) {
                if (ConversationListFragment.this.getActivity() == null || ConversationListFragment.this.getActivity().isFinishing() || iHistoryDataResultCallback == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    ConversationListFragment.this.timestamp = list.get(list.size() - 1).getSentTime();
                    for (Conversation conversation : list) {
                        if (!ConversationListFragment.this.shouldFilterConversation(conversation.getConversationType(), conversation.getTargetId())) {
                            arrayList.add(conversation);
                        }
                    }
                }
                iHistoryDataResultCallback.onResult(arrayList);
            }
        }, z ? this.timestamp : 0L, this.pageSize, conversationTypeArr);
    }

    public void onEventMainThread(Event.ReadReceiptEvent readReceiptEvent) {
        Conversation.ConversationType conversationType = readReceiptEvent.getMessage().getConversationType();
        int iFindPosition = this.mAdapter.findPosition(conversationType, readReceiptEvent.getMessage().getTargetId());
        boolean gatherState = getGatherState(conversationType);
        RLog.d(TAG, "ReadReceiptEvent. targetId:" + readReceiptEvent.getMessage().getTargetId() + ";originalIndex:" + iFindPosition);
        if (gatherState) {
            return;
        }
        if (iFindPosition >= 0) {
            UIConversation item = this.mAdapter.getItem(iFindPosition);
            if (((ReadReceiptMessage) readReceiptEvent.getMessage().getContent()).getLastMessageSendTime() >= item.getSyncReadReceiptTime() && item.getConversationSenderId().equals(RongIMClient.getInstance().getCurrentUserId())) {
                item.setSentStatus(Message.SentStatus.READ);
                item.setSyncReadReceiptTime(readReceiptEvent.getMessage().getSentTime());
                ConversationListAdapter conversationListAdapter = this.mAdapter;
                ListView listView = this.mList;
                conversationListAdapter.getView(iFindPosition, listView.getChildAt((iFindPosition - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                return;
            }
        }
        this.cacheEventList.add(readReceiptEvent.getMessage());
    }

    public void onEventMainThread(Event.AudioListenedEvent audioListenedEvent) {
        Message message = audioListenedEvent.getMessage();
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        RLog.d(TAG, "Message: " + message.getObjectName() + " " + conversationType + " " + message.getSentStatus());
        if (isConfigured(conversationType)) {
            boolean gatherState = getGatherState(conversationType);
            int iFindGatheredItem = gatherState ? this.mAdapter.findGatheredItem(conversationType) : this.mAdapter.findPosition(conversationType, targetId);
            if (iFindGatheredItem >= 0) {
                UIConversation item = this.mAdapter.getItem(iFindGatheredItem);
                if (message.getMessageId() == item.getLatestMessageId()) {
                    item.updateConversation(getContext(), message, gatherState);
                    ConversationListAdapter conversationListAdapter = this.mAdapter;
                    ListView listView = this.mList;
                    conversationListAdapter.getView(iFindGatheredItem, listView.getChildAt((iFindGatheredItem - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                }
            }
        }
    }

    public void onEventMainThread(Event.OnReceiveMessageEvent onReceiveMessageEvent) {
        int iFindPosition;
        UIConversation uIConversationObtain;
        if (onReceiveMessageEvent.isOffline()) {
            if (onReceiveMessageEvent.getLeft() == 0) {
                getConversationList(getConfigConversationTypes(), false);
                return;
            }
            return;
        }
        this.leftOfflineMsg = onReceiveMessageEvent.getLeft();
        Message message = onReceiveMessageEvent.getMessage();
        String targetId = message.getTargetId();
        Conversation.ConversationType conversationType = message.getConversationType();
        if (shouldFilterConversation(conversationType, targetId)) {
            return;
        }
        if (onReceiveMessageEvent.getLeft() == 0 && !onReceiveMessageEvent.hasPackage() && this.enableAutomaticDownloadMsg) {
            HQVoiceMsgDownloadManager.getInstance().enqueue(this, new AutoDownloadEntry(message, AutoDownloadEntry.DownloadPriority.NORMAL));
        }
        RLog.d(TAG, "OnReceiveMessageEvent: " + message.getObjectName() + " " + onReceiveMessageEvent.getLeft() + " " + conversationType + " " + targetId);
        if (isConfigured(message.getConversationType()) && shouldUpdateConversation(onReceiveMessageEvent.getMessage(), onReceiveMessageEvent.getLeft())) {
            if (message.getMessageId() > 0) {
                boolean gatherState = getGatherState(conversationType);
                if (gatherState) {
                    iFindPosition = this.mAdapter.findGatheredItem(conversationType);
                } else {
                    iFindPosition = this.mAdapter.findPosition(conversationType, targetId);
                }
                if (iFindPosition < 0) {
                    uIConversationObtain = UIConversation.obtain(getActivity(), message, gatherState);
                    onUIConversationCreated(uIConversationObtain);
                    this.mAdapter.add(uIConversationObtain, getPosition(uIConversationObtain));
                    this.mAdapter.notifyDataSetChanged();
                } else {
                    UIConversation item = this.mAdapter.getItem(iFindPosition);
                    if (onReceiveMessageEvent.getMessage().getSentTime() > item.getUIConversationTime()) {
                        item.updateConversation(getContext(), message, gatherState);
                        this.mAdapter.remove(iFindPosition);
                        this.mAdapter.add(item, getPosition(item));
                        this.mAdapter.notifyDataSetChanged();
                    } else {
                        RLog.i(TAG, "ignore update message " + onReceiveMessageEvent.getMessage().getObjectName());
                    }
                    uIConversationObtain = item;
                }
                RLog.i(TAG, "conversation unread count : " + uIConversationObtain.getUnReadMessageCount() + " " + conversationType + " " + targetId);
            }
            if (onReceiveMessageEvent.getLeft() == 0) {
                syncUnreadCount();
            }
            updateConversationReadReceipt(this.cacheEventList);
        }
    }

    public void onEventMainThread(Event.MessageLeftEvent messageLeftEvent) {
        if (messageLeftEvent.left == 0) {
            syncUnreadCount();
            RLog.d(TAG, "reload list by left event ");
            getConversationList(getConfigConversationTypes(), false);
        }
    }

    public void onEventMainThread(Event.MessageRecallEvent messageRecallEvent) {
        RLog.d(TAG, "MessageRecallEvent");
        int count = this.mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            UIConversation item = this.mAdapter.getItem(i);
            if (messageRecallEvent.getMessageId() == item.getLatestMessageId()) {
                boolean conversationGatherState = this.mAdapter.getItem(i).getConversationGatherState();
                final String conversationTargetId = this.mAdapter.getItem(i).getConversationTargetId();
                if (conversationGatherState) {
                    RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.6
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(List<Conversation> list) {
                            if (ConversationListFragment.this.getActivity() == null || ConversationListFragment.this.getActivity().isFinishing() || list == null || list.size() <= 0) {
                                return;
                            }
                            UIConversation uIConversationMakeUIConversation = ConversationListFragment.this.makeUIConversation(list);
                            int iFindPosition = ConversationListFragment.this.mAdapter.findPosition(uIConversationMakeUIConversation.getConversationType(), conversationTargetId);
                            if (iFindPosition >= 0) {
                                uIConversationMakeUIConversation.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition).getExtra());
                                ConversationListFragment.this.mAdapter.remove(iFindPosition);
                            }
                            ConversationListFragment.this.mAdapter.add(uIConversationMakeUIConversation, ConversationListFragment.this.getPosition(uIConversationMakeUIConversation));
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        }
                    }, item.getConversationType());
                    return;
                } else {
                    RongIM.getInstance().getConversation(item.getConversationType(), item.getConversationTargetId(), new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.ConversationListFragment.7
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Conversation conversation) {
                            if (conversation != null) {
                                UIConversation uIConversationObtain = UIConversation.obtain((Context) ConversationListFragment.this.getActivity(), conversation, false);
                                int iFindPosition = ConversationListFragment.this.mAdapter.findPosition(conversation.getConversationType(), conversation.getTargetId());
                                if (iFindPosition >= 0) {
                                    uIConversationObtain.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition).getExtra());
                                    ConversationListFragment.this.mAdapter.remove(iFindPosition);
                                }
                                ConversationListFragment.this.mAdapter.add(uIConversationObtain, ConversationListFragment.this.getPosition(uIConversationObtain));
                                ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                    return;
                }
            }
        }
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        RLog.d(TAG, "RemoteMessageRecallEvent");
        Conversation.ConversationType conversationType = remoteMessageRecallEvent.getConversationType();
        final String targetId = remoteMessageRecallEvent.getTargetId();
        int iFindPosition = this.mAdapter.findPosition(conversationType, targetId);
        if (iFindPosition == -1) {
            RLog.d(TAG, "ConversationListFragment UI unprepared!");
            return;
        }
        UIConversation item = this.mAdapter.getItem(iFindPosition);
        if (item.getConversationGatherState()) {
            RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.8
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(List<Conversation> list) {
                    if (ConversationListFragment.this.getActivity() == null || ConversationListFragment.this.getActivity().isFinishing() || list == null || list.size() <= 0) {
                        return;
                    }
                    UIConversation uIConversationMakeUIConversation = ConversationListFragment.this.makeUIConversation(list);
                    int iFindPosition2 = ConversationListFragment.this.mAdapter.findPosition(uIConversationMakeUIConversation.getConversationType(), targetId);
                    if (iFindPosition2 >= 0) {
                        uIConversationMakeUIConversation.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition2).getExtra());
                        ConversationListFragment.this.mAdapter.remove(iFindPosition2);
                    }
                    ConversationListFragment.this.mAdapter.add(uIConversationMakeUIConversation, ConversationListFragment.this.getPosition(uIConversationMakeUIConversation));
                    ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                    ConversationListFragment.this.onUnreadCountChanged();
                }
            }, this.mAdapter.getItem(iFindPosition).getConversationType());
        } else {
            RongIM.getInstance().getConversation(item.getConversationType(), item.getConversationTargetId(), new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.ConversationListFragment.9
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Conversation conversation) {
                    if (conversation != null) {
                        UIConversation uIConversationObtain = UIConversation.obtain((Context) ConversationListFragment.this.getActivity(), conversation, false);
                        int iFindPosition2 = ConversationListFragment.this.mAdapter.findPosition(conversation.getConversationType(), conversation.getTargetId());
                        if (iFindPosition2 >= 0) {
                            uIConversationObtain.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition2).getExtra());
                            ConversationListFragment.this.mAdapter.remove(iFindPosition2);
                        }
                        ConversationListFragment.this.mAdapter.add(uIConversationObtain, ConversationListFragment.this.getPosition(uIConversationObtain));
                        ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        ConversationListFragment.this.onUnreadCountChanged();
                    }
                }
            });
        }
    }

    public void onEventMainThread(Message message) {
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        RLog.d(TAG, "Message: " + message.getObjectName() + " " + message.getMessageId() + " " + conversationType + " " + message.getSentStatus());
        if (shouldFilterConversation(conversationType, targetId)) {
            return;
        }
        boolean gatherState = getGatherState(conversationType);
        if (!isConfigured(conversationType) || message.getMessageId() <= 0) {
            return;
        }
        int iFindGatheredItem = gatherState ? this.mAdapter.findGatheredItem(conversationType) : this.mAdapter.findPosition(conversationType, targetId);
        if (iFindGatheredItem < 0) {
            UIConversation uIConversationObtain = UIConversation.obtain(getActivity(), message, gatherState);
            onUIConversationCreated(uIConversationObtain);
            this.mAdapter.add(uIConversationObtain, getPosition(uIConversationObtain));
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        UIConversation item = this.mAdapter.getItem(iFindGatheredItem);
        long uIConversationTime = item.getUIConversationTime();
        if (item.getLatestMessageId() == message.getMessageId() && item.getSentStatus() == Message.SentStatus.SENDING && message.getSentStatus() == Message.SentStatus.SENT && message.getMessageDirection() == Message.MessageDirection.SEND) {
            uIConversationTime -= RongIMClient.getInstance().getDeltaTime();
        }
        if (uIConversationTime <= message.getSentTime() || item.getLatestMessageId() < 0) {
            this.mAdapter.remove(iFindGatheredItem);
            item.updateConversation(getContext(), message, gatherState);
            int position = getPosition(item);
            this.mAdapter.add(item, position);
            if (iFindGatheredItem == position) {
                ConversationListAdapter conversationListAdapter = this.mAdapter;
                ListView listView = this.mList;
                conversationListAdapter.getView(position, listView.getChildAt((position - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                return;
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(Event.MessageSentStatusUpdateEvent messageSentStatusUpdateEvent) {
        Message message = messageSentStatusUpdateEvent.getMessage();
        if (message != null && !message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            Conversation.ConversationType conversationType = message.getConversationType();
            String targetId = message.getTargetId();
            RLog.d(TAG, "MessageSentStatusUpdateEvent: " + messageSentStatusUpdateEvent.getMessage().getTargetId() + " " + conversationType + " " + messageSentStatusUpdateEvent.getSentStatus());
            boolean gatherState = getGatherState(conversationType);
            if (!gatherState && isConfigured(conversationType) && message.getMessageId() > 0) {
                int iFindPosition = this.mAdapter.findPosition(conversationType, targetId);
                UIConversation item = this.mAdapter.getItem(iFindPosition);
                if (message.getMessageId() == item.getLatestMessageId()) {
                    this.mAdapter.remove(iFindPosition);
                    item.updateConversation(getContext(), message, gatherState);
                    int position = getPosition(item);
                    this.mAdapter.add(item, position);
                    if (iFindPosition == position) {
                        ConversationListAdapter conversationListAdapter = this.mAdapter;
                        ListView listView = this.mList;
                        conversationListAdapter.getView(position, listView.getChildAt((position - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                        return;
                    }
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        RLog.e(TAG, "MessageSentStatusUpdateEvent message is null or direction is RECEIVE");
    }

    public void onEventMainThread(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        RLog.d(TAG, "ConnectionStatus, " + connectionStatus.toString());
        setNotificationBarVisibility(connectionStatus);
        if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED) && this.isShowWithoutConnected) {
            getConversationList(getConfigConversationTypes(), false);
            this.isShowWithoutConnected = false;
        }
    }

    public void onEventMainThread(Event.ConnectEvent connectEvent) {
        RLog.d(TAG, "ConnectEvent :" + RongIMClient.getInstance().getCurrentConnectionStatus());
        if (this.isShowWithoutConnected) {
            getConversationList(getConfigConversationTypes(), false);
            this.isShowWithoutConnected = false;
        }
    }

    public void onEventMainThread(final Event.CreateDiscussionEvent createDiscussionEvent) {
        RLog.d(TAG, "createDiscussionEvent");
        final String discussionId = createDiscussionEvent.getDiscussionId();
        if (isConfigured(Conversation.ConversationType.DISCUSSION)) {
            RongIMClient.getInstance().getConversation(Conversation.ConversationType.DISCUSSION, discussionId, new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.ConversationListFragment.10
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Conversation conversation) {
                    if (conversation != null) {
                        int iFindGatheredItem = ConversationListFragment.this.getGatherState(Conversation.ConversationType.DISCUSSION) ? ConversationListFragment.this.mAdapter.findGatheredItem(Conversation.ConversationType.DISCUSSION) : ConversationListFragment.this.mAdapter.findPosition(Conversation.ConversationType.DISCUSSION, discussionId);
                        conversation.setConversationTitle(createDiscussionEvent.getDiscussionName());
                        if (iFindGatheredItem >= 0) {
                            ConversationListFragment.this.mAdapter.getItem(iFindGatheredItem).updateConversation(ConversationListFragment.this.getContext(), conversation, ConversationListFragment.this.getGatherState(Conversation.ConversationType.DISCUSSION));
                            ConversationListFragment.this.mAdapter.getView(iFindGatheredItem, ConversationListFragment.this.mList.getChildAt((iFindGatheredItem - ConversationListFragment.this.mList.getFirstVisiblePosition()) + ConversationListFragment.this.mList.getHeaderViewsCount()), ConversationListFragment.this.mList);
                        } else {
                            UIConversation uIConversationObtain = UIConversation.obtain(ConversationListFragment.this.getActivity(), conversation, ConversationListFragment.this.getGatherState(Conversation.ConversationType.DISCUSSION));
                            ConversationListFragment.this.onUIConversationCreated(uIConversationObtain);
                            ConversationListFragment.this.mAdapter.add(uIConversationObtain, ConversationListFragment.this.getPosition(uIConversationObtain));
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            });
        }
    }

    public void onEventMainThread(Event.DraftEvent draftEvent) {
        final Conversation.ConversationType conversationType = draftEvent.getConversationType();
        final String targetId = draftEvent.getTargetId();
        RLog.i(TAG, "Draft : " + conversationType);
        RongIMClient.getInstance().getConversation(draftEvent.getConversationType(), draftEvent.getTargetId(), new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.ConversationListFragment.11
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(Conversation conversation) {
                int iFindPosition = ConversationListFragment.this.mAdapter.findPosition(conversationType, targetId);
                if (iFindPosition < 0 || ConversationListFragment.this.getGatherState(conversationType)) {
                    return;
                }
                ConversationListFragment.this.mAdapter.remove(iFindPosition);
                UIConversation uIConversationObtain = UIConversation.obtain((Context) ConversationListFragment.this.getActivity(), conversation, false);
                int position = ConversationListFragment.this.getPosition(uIConversationObtain);
                ConversationListFragment.this.mAdapter.add(uIConversationObtain, position);
                if (position == iFindPosition) {
                    ConversationListFragment.this.mAdapter.getView(position, ConversationListFragment.this.mList.getChildAt((position - ConversationListFragment.this.mList.getFirstVisiblePosition()) + ConversationListFragment.this.mList.getHeaderViewsCount()), ConversationListFragment.this.mList);
                } else {
                    ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void onEventMainThread(Group group) {
        RLog.d(TAG, "Group: " + group.getName() + " " + group.getId());
        int count = this.mAdapter.getCount();
        if (group.getName() == null) {
            return;
        }
        for (int i = 0; i < count; i++) {
            this.mAdapter.getItem(i).updateConversation(getContext(), group);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void onEventMainThread(Discussion discussion) {
        int iFindPosition;
        RLog.d(TAG, "Discussion: " + discussion.getName() + " " + discussion.getId());
        if (isConfigured(Conversation.ConversationType.DISCUSSION)) {
            if (getGatherState(Conversation.ConversationType.DISCUSSION)) {
                iFindPosition = this.mAdapter.findGatheredItem(Conversation.ConversationType.DISCUSSION);
            } else {
                iFindPosition = this.mAdapter.findPosition(Conversation.ConversationType.DISCUSSION, discussion.getId());
            }
            if (iFindPosition >= 0) {
                for (int i = 0; i <= iFindPosition; i++) {
                    this.mAdapter.getItem(i).updateConversation(getContext(), discussion);
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onEventMainThread(GroupUserInfo groupUserInfo) {
        RLog.d(TAG, "GroupUserInfo " + groupUserInfo.getGroupId() + " " + groupUserInfo.getUserId() + " " + groupUserInfo.getNickname());
        if (groupUserInfo.getNickname() == null || groupUserInfo.getGroupId() == null) {
            return;
        }
        int count = this.mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            UIConversation item = this.mAdapter.getItem(i);
            if (!getGatherState(Conversation.ConversationType.GROUP) && item.getConversationTargetId().equals(groupUserInfo.getGroupId()) && item.getConversationSenderId().equals(groupUserInfo.getUserId())) {
                item.updateConversation(getContext(), groupUserInfo);
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void onEventMainThread(UserInfo userInfo) {
        RLog.i(TAG, "UserInfo " + userInfo.getUserId() + " " + userInfo.getName());
        int count = this.mAdapter.getCount();
        for (int i = 0; i < count && userInfo.getName() != null; i++) {
            UIConversation item = this.mAdapter.getItem(i);
            if (item.hasNickname(userInfo.getUserId())) {
                RLog.i(TAG, "has nick name");
            } else {
                item.updateConversation(getContext(), userInfo);
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void onEventMainThread(PublicServiceProfile publicServiceProfile) {
        RLog.d(TAG, "PublicServiceProfile");
        int count = this.mAdapter.getCount();
        boolean gatherState = getGatherState(publicServiceProfile.getConversationType());
        for (int i = 0; i < count; i++) {
            UIConversation item = this.mAdapter.getItem(i);
            if (item.getConversationType().equals(publicServiceProfile.getConversationType()) && item.getConversationTargetId().equals(publicServiceProfile.getTargetId()) && !gatherState) {
                item.setUIConversationTitle(publicServiceProfile.getName());
                item.setIconUrl(publicServiceProfile.getPortraitUri());
                ConversationListAdapter conversationListAdapter = this.mAdapter;
                ListView listView = this.mList;
                conversationListAdapter.getView(i, listView.getChildAt((i - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                return;
            }
        }
    }

    public void onEventMainThread(Event.PublicServiceFollowableEvent publicServiceFollowableEvent) {
        int iFindPosition;
        RLog.d(TAG, "PublicServiceFollowableEvent");
        if (publicServiceFollowableEvent.isFollow() || (iFindPosition = this.mAdapter.findPosition(publicServiceFollowableEvent.getConversationType(), publicServiceFollowableEvent.getTargetId())) < 0) {
            return;
        }
        this.mAdapter.remove(iFindPosition);
        this.mAdapter.notifyDataSetChanged();
    }

    public void onEventMainThread(Event.ConversationUnreadEvent conversationUnreadEvent) {
        RLog.d(TAG, "ConversationUnreadEvent");
        Conversation.ConversationType type = conversationUnreadEvent.getType();
        String targetId = conversationUnreadEvent.getTargetId();
        int iFindGatheredItem = getGatherState(type) ? this.mAdapter.findGatheredItem(type) : this.mAdapter.findPosition(type, targetId);
        if (iFindGatheredItem >= 0) {
            this.mAdapter.getItem(iFindGatheredItem).clearUnRead(type, targetId);
            this.mAdapter.notifyDataSetChanged();
        }
        onUnreadCountChanged();
    }

    public void onEventMainThread(Event.ConversationTopEvent conversationTopEvent) {
        RLog.d(TAG, "ConversationTopEvent");
        Conversation.ConversationType conversationType = conversationTopEvent.getConversationType();
        int iFindPosition = this.mAdapter.findPosition(conversationType, conversationTopEvent.getTargetId());
        if (iFindPosition < 0 || getGatherState(conversationType)) {
            return;
        }
        UIConversation item = this.mAdapter.getItem(iFindPosition);
        if (item.isTop() != conversationTopEvent.isTop()) {
            item.setTop(!item.isTop());
            this.mAdapter.remove(iFindPosition);
            int position = getPosition(item);
            this.mAdapter.add(item, position);
            if (position == iFindPosition) {
                ConversationListAdapter conversationListAdapter = this.mAdapter;
                ListView listView = this.mList;
                conversationListAdapter.getView(position, listView.getChildAt((position - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
                return;
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(Event.ConversationRemoveEvent conversationRemoveEvent) {
        RLog.d(TAG, "ConversationRemoveEvent");
        removeConversation(conversationRemoveEvent.getType(), conversationRemoveEvent.getTargetId());
    }

    public void onEventMainThread(Event.ClearConversationEvent clearConversationEvent) {
        RLog.d(TAG, "ClearConversationEvent");
        List<Conversation.ConversationType> types = clearConversationEvent.getTypes();
        for (int count = this.mAdapter.getCount() - 1; count >= 0; count--) {
            if (types.indexOf(this.mAdapter.getItem(count).getConversationType()) >= 0) {
                this.mAdapter.remove(count);
            }
        }
        this.mAdapter.notifyDataSetChanged();
        onUnreadCountChanged();
    }

    public void onEventMainThread(Event.MessageDeleteEvent messageDeleteEvent) {
        RLog.d(TAG, "MessageDeleteEvent");
        int count = this.mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            if (messageDeleteEvent.getMessageIds().contains(Integer.valueOf(this.mAdapter.getItem(i).getLatestMessageId()))) {
                boolean conversationGatherState = this.mAdapter.getItem(i).getConversationGatherState();
                final String conversationTargetId = this.mAdapter.getItem(i).getConversationTargetId();
                if (conversationGatherState) {
                    RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.fragment.ConversationListFragment.12
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(List<Conversation> list) {
                            if (ConversationListFragment.this.getActivity() == null || ConversationListFragment.this.getActivity().isFinishing() || list == null || list.size() == 0) {
                                return;
                            }
                            UIConversation uIConversationMakeUIConversation = ConversationListFragment.this.makeUIConversation(list);
                            int iFindPosition = ConversationListFragment.this.mAdapter.findPosition(uIConversationMakeUIConversation.getConversationType(), conversationTargetId);
                            if (iFindPosition >= 0) {
                                uIConversationMakeUIConversation.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition).getExtra());
                                ConversationListFragment.this.mAdapter.remove(iFindPosition);
                            }
                            ConversationListFragment.this.mAdapter.add(uIConversationMakeUIConversation, ConversationListFragment.this.getPosition(uIConversationMakeUIConversation));
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        }
                    }, this.mAdapter.getItem(i).getConversationType());
                    return;
                } else {
                    RongIM.getInstance().getConversation(this.mAdapter.getItem(i).getConversationType(), this.mAdapter.getItem(i).getConversationTargetId(), new RongIMClient.ResultCallback<Conversation>() { // from class: io.rong.imkit.fragment.ConversationListFragment.13
                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.ResultCallback
                        public void onSuccess(Conversation conversation) {
                            if (conversation == null) {
                                RLog.d(ConversationListFragment.TAG, "onEventMainThread getConversation : onSuccess, conversation = null");
                                return;
                            }
                            UIConversation uIConversationObtain = UIConversation.obtain((Context) ConversationListFragment.this.getActivity(), conversation, false);
                            int iFindPosition = ConversationListFragment.this.mAdapter.findPosition(conversation.getConversationType(), conversation.getTargetId());
                            if (iFindPosition >= 0) {
                                uIConversationObtain.setExtra(ConversationListFragment.this.mAdapter.getItem(iFindPosition).getExtra());
                                ConversationListFragment.this.mAdapter.remove(iFindPosition);
                            }
                            ConversationListFragment.this.mAdapter.add(uIConversationObtain, ConversationListFragment.this.getPosition(uIConversationObtain));
                            ConversationListFragment.this.mAdapter.notifyDataSetChanged();
                        }
                    });
                    return;
                }
            }
        }
    }

    public void onEventMainThread(Event.ConversationNotificationEvent conversationNotificationEvent) {
        int iFindPosition = this.mAdapter.findPosition(conversationNotificationEvent.getConversationType(), conversationNotificationEvent.getTargetId());
        if (iFindPosition >= 0) {
            UIConversation item = this.mAdapter.getItem(iFindPosition);
            if (!item.getNotificationStatus().equals(conversationNotificationEvent.getStatus())) {
                item.setNotificationStatus(conversationNotificationEvent.getStatus());
                ConversationListAdapter conversationListAdapter = this.mAdapter;
                ListView listView = this.mList;
                conversationListAdapter.getView(iFindPosition, listView.getChildAt((iFindPosition - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
            }
            onUnreadCountChanged();
        }
    }

    public void onEventMainThread(Event.MessagesClearEvent messagesClearEvent) {
        RLog.d(TAG, "MessagesClearEvent");
        Conversation.ConversationType type = messagesClearEvent.getType();
        int iFindGatheredItem = getGatherState(type) ? this.mAdapter.findGatheredItem(type) : this.mAdapter.findPosition(type, messagesClearEvent.getTargetId());
        if (iFindGatheredItem >= 0) {
            this.mAdapter.getItem(iFindGatheredItem).clearLastMessage();
            ConversationListAdapter conversationListAdapter = this.mAdapter;
            ListView listView = this.mList;
            conversationListAdapter.getView(iFindGatheredItem, listView.getChildAt((iFindGatheredItem - listView.getFirstVisiblePosition()) + this.mList.getHeaderViewsCount()), this.mList);
        }
    }

    public void onEventMainThread(Event.OnMessageSendErrorEvent onMessageSendErrorEvent) {
        Message message = onMessageSendErrorEvent.getMessage();
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        if (isConfigured(conversationType)) {
            boolean gatherState = getGatherState(conversationType);
            int iFindGatheredItem = gatherState ? this.mAdapter.findGatheredItem(conversationType) : this.mAdapter.findPosition(conversationType, targetId);
            if (iFindGatheredItem >= 0) {
                UIConversation item = this.mAdapter.getItem(iFindGatheredItem);
                message.setSentStatus(Message.SentStatus.FAILED);
                item.updateConversation(getContext(), message, gatherState);
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onEventMainThread(Event.QuitDiscussionEvent quitDiscussionEvent) {
        RLog.d(TAG, "QuitDiscussionEvent");
        removeConversation(Conversation.ConversationType.DISCUSSION, quitDiscussionEvent.getDiscussionId());
    }

    public void onEventMainThread(Event.QuitGroupEvent quitGroupEvent) {
        RLog.d(TAG, "QuitGroupEvent");
        removeConversation(Conversation.ConversationType.GROUP, quitGroupEvent.getGroupId());
    }

    public void onEventMainThread(ConversationStatus[] conversationStatusArr) {
        RLog.i(TAG, "onEventMainThread conversationStatus " + conversationStatusArr.length);
        if (conversationStatusArr.length == 1) {
            String targetId = conversationStatusArr[0].getTargetId();
            Conversation.ConversationType conversationType = conversationStatusArr[0].getConversationType();
            int iFindPosition = this.mAdapter.findPosition(conversationType, targetId);
            if (getGatherState(conversationType)) {
                return;
            }
            if (iFindPosition >= 0) {
                UIConversation item = this.mAdapter.getItem(iFindPosition);
                item.setNotificationStatus(conversationStatusArr[0].getNotifyStatus());
                onEventMainThread(new Event.ConversationTopEvent(conversationType, targetId, conversationStatusArr[0].isTop()));
                updateListItem(item);
                return;
            }
            getConversationList(getConfigConversationTypes(), false);
            return;
        }
        getConversationList(getConfigConversationTypes(), false);
    }
}
