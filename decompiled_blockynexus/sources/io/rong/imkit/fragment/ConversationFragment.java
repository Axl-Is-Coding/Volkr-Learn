package io.rong.imkit.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractC0336n;
import cn.qqtheme.framework.widget.WheelView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.config.StringConstant;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.DeleteClickActions;
import io.rong.imkit.IExtensionClickListener;
import io.rong.imkit.IPublicServiceMenuClickListener;
import io.rong.imkit.InputMenu;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongKitIntent;
import io.rong.imkit.RongKitReceiver;
import io.rong.imkit.RongMessageItemLongClickActionManager;
import io.rong.imkit.actions.IClickActions;
import io.rong.imkit.actions.OnMoreActionStateListener;
import io.rong.imkit.activity.SelectConversationActivity;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.dialog.BurnHintDialog;
import io.rong.imkit.manager.AudioPlayManager;
import io.rong.imkit.manager.AudioRecordManager;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.manager.SendImageManager;
import io.rong.imkit.manager.SendMediaManager;
import io.rong.imkit.manager.UnReadMessageManager;
import io.rong.imkit.mention.DraftHelper;
import io.rong.imkit.mention.IAddMentionedMemberListener;
import io.rong.imkit.mention.RongMentionManager;
import io.rong.imkit.model.ConversationInfo;
import io.rong.imkit.model.Event;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.plugin.DefaultLocationPlugin;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.location.AMapRealTimeActivity;
import io.rong.imkit.plugin.location.AMapRealTimeActivity2D;
import io.rong.imkit.plugin.location.IRealTimeLocationStateListener;
import io.rong.imkit.plugin.location.IUserInfoProvider;
import io.rong.imkit.plugin.location.LocationManager;
import io.rong.imkit.plugin.location.LocationManager2D;
import io.rong.imkit.recallEdit.RecallEditManager;
import io.rong.imkit.reference.ReferenceView;
import io.rong.imkit.resend.ResendManager;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.KitCommonDefine;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utilities.PromptPopupDialog;
import io.rong.imkit.utils.ForwardManager;
import io.rong.imkit.utils.SystemUtils;
import io.rong.imkit.voiceMessageDownload.AutoDownloadEntry;
import io.rong.imkit.voiceMessageDownload.HQVoiceMsgDownloadManager;
import io.rong.imkit.widget.AutoRefreshListView;
import io.rong.imkit.widget.CSEvaluateDialog;
import io.rong.imkit.widget.ForwardClickActions;
import io.rong.imkit.widget.SingleChoiceDialog;
import io.rong.imkit.widget.adapter.MessageListAdapter;
import io.rong.imkit.widget.provider.EvaluatePlugin;
import io.rong.imkit.widget.provider.MessageItemLongClickAction;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.DestructionTag;
import io.rong.imlib.ICustomServiceListener;
import io.rong.imlib.IMLibExtensionModuleManager;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.destruct.MessageBufferPool;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.model.CSCustomServiceInfo;
import io.rong.imlib.model.CSGroupItem;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.CustomServiceMode;
import io.rong.imlib.model.HardwareResource;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.PublicServiceMenu;
import io.rong.imlib.model.PublicServiceMenuItem;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.ReadReceiptInfo;
import io.rong.imlib.model.UserInfo;
import io.rong.message.CSPullLeaveMessage;
import io.rong.message.DestructionCmdMessage;
import io.rong.message.FileMessage;
import io.rong.message.GIFMessage;
import io.rong.message.HQVoiceMessage;
import io.rong.message.HistoryDividerMessage;
import io.rong.message.ImageMessage;
import io.rong.message.InformationNotificationMessage;
import io.rong.message.LocationMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.PublicServiceCommandMessage;
import io.rong.message.ReadReceiptMessage;
import io.rong.message.RecallNotificationMessage;
import io.rong.message.ReferenceMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.SightMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;
import io.rong.push.RongPushClient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationFragment extends UriFragment implements AbsListView.OnScrollListener, IExtensionClickListener, IUserInfoProvider, CSEvaluateDialog.EvaluateClickListener {
    private static final int DEFAULT_HISTORY_MESSAGE_COUNT = 10;
    private static final int DEFAULT_REMOTE_MESSAGE_COUNT = 10;
    private static final String LIST_STATE = "listState";
    private static final String NEW_MESSAGE_COUNT = "newMessageCount";
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;
    public static final int REQUEST_CODE_FORWARD = 104;
    private static final int REQUEST_CODE_LOCATION_SHARE = 101;
    private static final int REQUEST_CODE_PERMISSION = 103;
    private static final int REQUEST_CS_LEAVEL_MESSAGE = 102;
    private static final int REQUEST_MSG_DOWNLOAD_PERMISSION = 1001;
    public static final int SCROLL_MODE_BOTTOM = 3;
    public static final int SCROLL_MODE_NORMAL = 1;
    public static final int SCROLL_MODE_TOP = 2;
    private static final int SHOW_UNREAD_MESSAGE_COUNT = 10;
    public static final String TAG = "ConversationFragment";
    private static final int TIP_DEFAULT_MESSAGE_COUNT = 1;
    private static final String UN_READ_COUNT = "unReadCount";
    private MessageItemLongClickAction clickAction;
    private MessageItemLongClickAction clickActionReference;
    private View contentView;
    private int conversationUnreadCount;
    private long csEnterTime;
    private Message firstUnreadMessage;
    private long indexMessageTime;
    private boolean isNeedRefresh;
    private IAddMentionedMemberListener mAddMentionedMemberListener;
    private Conversation.ConversationType mConversationType;
    private ConversationInfo mCurrentConversationInfo;
    private CustomServiceConfig mCustomServiceConfig;
    private CSCustomServiceInfo mCustomUserInfo;
    private String mDraft;
    private boolean mEnableMention;
    private CSEvaluateDialog mEvaluateDialg;
    private RongKitReceiver mKitReceiver;
    private int mLastMentionMsgId;
    private float mLastTouchY;
    private AutoRefreshListView mList;
    private MessageListAdapter mListAdapter;
    private Parcelable mListViewState;
    private List<String> mLocationShareParticipants;
    private View mMsgListView;
    private ImageButton mNewMessageBtn;
    private int mNewMessageCount;
    private TextView mNewMessageTextView;
    private LinearLayout mNotificationContainer;
    private float mOffsetLimit;
    protected PublicServiceProfile mPublicServiceProfile;
    private boolean mReadRec;
    private RongExtension mRongExtension;
    private Bundle mSavedInstanceState;
    private boolean mSyncReadStatus;
    private long mSyncReadStatusMsgTime;
    private String mTargetId;
    private int mUnReadCount;
    private TextView mUnreadMsgCountTv;
    private LinearLayout mUnreadMsgLayout;
    private boolean mUpDirection;
    private View mVoiceInputToggle;
    private ImageView mVoiceToggle;
    private OnMoreActionStateListener moreActionStateListener;
    protected ReferenceMessage referenceMessage;
    private ReferenceView referenceView;
    private boolean finishing = false;
    private boolean mHasMoreLocalMessagesUp = true;
    private boolean mHasMoreLocalMessagesDown = true;
    private boolean mCSNeedToQuit = false;
    private boolean mIsInsertNewMsg = true;
    private final int CS_HUMAN_MODE_CUSTOMER_EXPIRE = 0;
    private final int CS_HUMAN_MODE_SEAT_EXPIRE = 1;
    private int lastItemBottomOffset = 0;
    private int lastItemPosition = -1;
    private int lastItemHeight = 0;
    private int lastListHeight = 0;
    private boolean isShowTipMessageCountInBackground = true;
    private Conversation mConversation = null;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: io.rong.imkit.fragment.ConversationFragment.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (ConversationFragment.this.mUnreadMsgLayout == null || ConversationFragment.this.mUnreadMsgLayout.getVisibility() != 0 || ConversationFragment.this.firstUnreadMessage == null || i > ConversationFragment.this.mListAdapter.findPosition(ConversationFragment.this.firstUnreadMessage.getMessageId())) {
                return;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(WheelView.DividerConfig.FILL, 700.0f, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            translateAnimation.setDuration(700L);
            translateAnimation.setFillAfter(true);
            ConversationFragment.this.mUnreadMsgLayout.startAnimation(translateAnimation);
            ConversationFragment.this.mUnreadMsgLayout.setClickable(false);
            ConversationFragment.this.mList.removeCurrentOnScrollListener();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.rong.imkit.fragment.ConversationFragment.8
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            ConversationFragment.this.contentView.getWindowVisibleDisplayFrame(rect);
            int height = ConversationFragment.this.contentView.getRootView().getHeight();
            double d2 = height - rect.bottom;
            double d3 = height;
            Double.isNaN(d3);
            if (d2 > d3 * 0.15d) {
                ConversationFragment.this.contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (ConversationFragment.this.mNewMessageCount <= 0 || ConversationFragment.this.mNewMessageBtn == null) {
                    return;
                }
                ConversationFragment.this.mNewMessageCount = 0;
                ConversationFragment.this.mNewMessageBtn.setVisibility(8);
                ConversationFragment.this.mNewMessageTextView.setVisibility(8);
            }
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener listViewLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.rong.imkit.fragment.ConversationFragment.9
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height;
            if (ConversationFragment.this.mList == null || ConversationFragment.this.lastListHeight == (height = ConversationFragment.this.mList.getHeight())) {
                return;
            }
            if (ConversationFragment.this.lastItemPosition != -1) {
                ConversationFragment.this.mList.setSelectionFromTop(ConversationFragment.this.lastItemPosition, (height - ConversationFragment.this.lastItemHeight) + ConversationFragment.this.lastItemBottomOffset);
            }
            ConversationFragment.this.lastListHeight = height;
        }
    };
    private boolean robotType = true;
    private boolean csEvaluate = true;
    ICustomServiceListener customServiceListener = new ICustomServiceListener() { // from class: io.rong.imkit.fragment.ConversationFragment.24
        @Override // io.rong.imlib.ICustomServiceListener
        public void onError(int i, String str) {
            ConversationFragment conversationFragment = ConversationFragment.this;
            conversationFragment.onCustomServiceWarning(str, false, conversationFragment.robotType);
        }

        @Override // io.rong.imlib.ICustomServiceListener
        public void onModeChanged(CustomServiceMode customServiceMode) {
            if (ConversationFragment.this.mRongExtension == null || !ConversationFragment.this.isActivityExist()) {
                return;
            }
            ConversationFragment.this.mRongExtension.setExtensionBarMode(customServiceMode);
            if (!customServiceMode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN) && !customServiceMode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_HUMAN_FIRST)) {
                if (customServiceMode.equals(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE)) {
                    ConversationFragment.this.csEvaluate = false;
                    return;
                }
                return;
            }
            if (ConversationFragment.this.mCustomServiceConfig != null && ConversationFragment.this.mCustomServiceConfig.userTipTime > 0 && !TextUtils.isEmpty(ConversationFragment.this.mCustomServiceConfig.userTipWord)) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.startTimer(0, conversationFragment.mCustomServiceConfig.userTipTime * 60 * 1000);
            }
            if (ConversationFragment.this.mCustomServiceConfig != null && ConversationFragment.this.mCustomServiceConfig.adminTipTime > 0 && !TextUtils.isEmpty(ConversationFragment.this.mCustomServiceConfig.adminTipWord)) {
                ConversationFragment conversationFragment2 = ConversationFragment.this;
                conversationFragment2.startTimer(1, conversationFragment2.mCustomServiceConfig.adminTipTime * 60 * 1000);
            }
            ConversationFragment.this.robotType = false;
            ConversationFragment.this.csEvaluate = true;
        }

        @Override // io.rong.imlib.ICustomServiceListener
        public void onPullEvaluation(String str) {
            if (ConversationFragment.this.mEvaluateDialg == null) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.onCustomServiceEvaluation(true, str, conversationFragment.robotType, ConversationFragment.this.csEvaluate);
            }
        }

        @Override // io.rong.imlib.ICustomServiceListener
        public void onQuit(String str) {
            RLog.i(ConversationFragment.TAG, "CustomService onQuit.");
            if (ConversationFragment.this.getActivity() == null) {
                return;
            }
            if (ConversationFragment.this.mCustomServiceConfig == null || !ConversationFragment.this.mCustomServiceConfig.evaEntryPoint.equals(CustomServiceConfig.CSEvaEntryPoint.EVA_END) || ConversationFragment.this.robotType) {
                ConversationFragment.this.csQuit(str);
            } else {
                ConversationFragment.this.csQuitEvaluate(str);
            }
        }

        @Override // io.rong.imlib.ICustomServiceListener
        public void onSelectGroup(List<CSGroupItem> list) {
            ConversationFragment.this.onSelectCustomerServiceGroup(list);
        }

        @Override // io.rong.imlib.ICustomServiceListener
        public void onSuccess(CustomServiceConfig customServiceConfig) {
            ConversationFragment.this.mCustomServiceConfig = customServiceConfig;
            if (customServiceConfig.isBlack) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.onCustomServiceWarning(conversationFragment.getString(R.string.rc_blacklist_prompt), false, ConversationFragment.this.robotType);
            }
            if (customServiceConfig.robotSessionNoEva) {
                ConversationFragment.this.csEvaluate = false;
                ConversationFragment.this.mListAdapter.setEvaluateForRobot(true);
            }
            if (ConversationFragment.this.mRongExtension != null) {
                if (customServiceConfig.evaEntryPoint.equals(CustomServiceConfig.CSEvaEntryPoint.EVA_EXTENSION) && ConversationFragment.this.mCustomServiceConfig != null) {
                    ConversationFragment.this.mRongExtension.addPlugin(new EvaluatePlugin(ConversationFragment.this.mCustomServiceConfig.isReportResolveStatus));
                }
                if (customServiceConfig.isDisableLocation) {
                    List<IPluginModule> pluginModules = ConversationFragment.this.mRongExtension.getPluginModules();
                    IPluginModule iPluginModule = null;
                    for (int i = 0; i < pluginModules.size(); i++) {
                        if (pluginModules.get(i) instanceof DefaultLocationPlugin) {
                            iPluginModule = pluginModules.get(i);
                        }
                    }
                    if (iPluginModule != null) {
                        ConversationFragment.this.mRongExtension.removePlugin(iPluginModule);
                    }
                }
            }
            if (!customServiceConfig.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.NONE) || ConversationFragment.this.getActivity() == null) {
                ConversationFragment.this.mCSNeedToQuit = customServiceConfig.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.SUSPEND);
            } else {
                try {
                    ConversationFragment.this.mCSNeedToQuit = ConversationFragment.this.getActivity().getResources().getBoolean(R.bool.rc_stop_custom_service_when_quit);
                } catch (Exception e2) {
                    RLog.e(ConversationFragment.TAG, "customServiceListener onSuccess", e2);
                }
            }
            for (int i2 = 0; i2 < ConversationFragment.this.mListAdapter.getCount(); i2++) {
                UIMessage item = ConversationFragment.this.mListAdapter.getItem(i2);
                if (item.getContent() instanceof CSPullLeaveMessage) {
                    item.setCsConfig(customServiceConfig);
                }
            }
            ConversationFragment.this.mListAdapter.notifyDataSetChanged();
            if (TextUtils.isEmpty(customServiceConfig.announceMsg)) {
                return;
            }
            ConversationFragment.this.onShowAnnounceView(customServiceConfig.announceMsg, customServiceConfig.announceClickUrl);
        }
    };
    private boolean isClickUnread = false;

    /* JADX INFO: renamed from: io.rong.imkit.fragment.ConversationFragment$16, reason: invalid class name */
    class AnonymousClass16 implements IRealTimeLocationStateListener {
        private View mRealTimeBar;
        private TextView mRealTimeText;

        AnonymousClass16() {
        }

        @Override // io.rong.imkit.plugin.location.IRealTimeLocationStateListener
        public void onErrorException() {
            if (ConversationFragment.this.isDetached()) {
                return;
            }
            ConversationFragment.this.hideNotificationView(this.mRealTimeBar);
            if (ConversationFragment.this.mLocationShareParticipants != null) {
                ConversationFragment.this.mLocationShareParticipants.clear();
                ConversationFragment.this.mLocationShareParticipants = null;
            }
        }

        @Override // io.rong.imkit.plugin.location.IRealTimeLocationStateListener
        public void onParticipantChanged(List<String> list) {
            if (ConversationFragment.this.isDetached()) {
                return;
            }
            if (this.mRealTimeBar == null) {
                this.mRealTimeBar = ConversationFragment.this.inflateNotificationView(R.layout.rc_notification_realtime_location);
                this.mRealTimeText = (TextView) this.mRealTimeBar.findViewById(R.id.real_time_location_text);
                this.mRealTimeBar.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.16.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
                        if (!PermissionCheckUtil.checkPermissions(ConversationFragment.this.getContext(), strArr)) {
                            PermissionCheckUtil.requestPermissions(ConversationFragment.this.getActivity(), strArr, 100);
                            return;
                        }
                        if (RongIMClient.getInstance().getRealTimeLocationCurrentState(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId) == RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_INCOMING) {
                            PromptPopupDialog promptPopupDialogNewInstance = PromptPopupDialog.newInstance(ConversationFragment.this.getActivity(), "", ConversationFragment.this.getResources().getString(R.string.rc_real_time_join_notification));
                            promptPopupDialogNewInstance.setPromptButtonClickedListener(new PromptPopupDialog.OnPromptButtonClickedListener() { // from class: io.rong.imkit.fragment.ConversationFragment.16.1.1
                                @Override // io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener
                                public void onPositiveButtonClicked() {
                                    int iJoinLocationSharing = (ConversationFragment.this.getActivity() == null || !ConversationFragment.this.getActivity().getResources().getBoolean(R.bool.rc_location_2D)) ? LocationManager.getInstance().joinLocationSharing() : LocationManager2D.getInstance().joinLocationSharing();
                                    if (iJoinLocationSharing == 0) {
                                        Intent intent = (ConversationFragment.this.getActivity() == null || !ConversationFragment.this.getActivity().getResources().getBoolean(R.bool.rc_location_2D)) ? new Intent(ConversationFragment.this.getActivity(), (Class<?>) AMapRealTimeActivity.class) : new Intent(ConversationFragment.this.getActivity(), (Class<?>) AMapRealTimeActivity2D.class);
                                        if (ConversationFragment.this.mLocationShareParticipants != null) {
                                            intent.putStringArrayListExtra("participants", (ArrayList) ConversationFragment.this.mLocationShareParticipants);
                                        }
                                        ConversationFragment.this.startActivity(intent);
                                        return;
                                    }
                                    if (iJoinLocationSharing == 1) {
                                        Toast.makeText(ConversationFragment.this.getActivity(), R.string.rc_network_exception, 0).show();
                                    } else if (iJoinLocationSharing == 2) {
                                        Toast.makeText(ConversationFragment.this.getActivity(), R.string.rc_location_sharing_exceed_max, 0).show();
                                    }
                                }
                            });
                            promptPopupDialogNewInstance.show();
                        } else {
                            Intent intent = (ConversationFragment.this.getActivity() == null || !ConversationFragment.this.getActivity().getResources().getBoolean(R.bool.rc_location_2D)) ? new Intent(ConversationFragment.this.getActivity(), (Class<?>) AMapRealTimeActivity.class) : new Intent(ConversationFragment.this.getActivity(), (Class<?>) AMapRealTimeActivity2D.class);
                            if (ConversationFragment.this.mLocationShareParticipants != null) {
                                intent.putStringArrayListExtra("participants", (ArrayList) ConversationFragment.this.mLocationShareParticipants);
                            }
                            ConversationFragment.this.startActivity(intent);
                        }
                    }
                });
            }
            ConversationFragment.this.mLocationShareParticipants = list;
            if (list == null) {
                ConversationFragment.this.hideNotificationView(this.mRealTimeBar);
                return;
            }
            if (list.size() == 0) {
                ConversationFragment.this.hideNotificationView(this.mRealTimeBar);
                return;
            }
            if (list.size() == 1 && list.contains(RongIM.getInstance().getCurrentUserId())) {
                this.mRealTimeText.setText(ConversationFragment.this.getResources().getString(R.string.rc_you_are_sharing_location));
            } else if (list.size() != 1 || list.contains(RongIM.getInstance().getCurrentUserId())) {
                this.mRealTimeText.setText(String.format(ConversationFragment.this.getResources().getString(R.string.rc_others_are_sharing_location), Integer.valueOf(list.size())));
            } else {
                this.mRealTimeText.setText(String.format(ConversationFragment.this.getResources().getString(R.string.rc_other_is_sharing_location), ConversationFragment.this.getNameFromCache(list.get(0))));
            }
            ConversationFragment.this.showNotificationView(this.mRealTimeBar);
        }
    }

    /* JADX INFO: renamed from: io.rong.imkit.fragment.ConversationFragment$20, reason: invalid class name */
    class AnonymousClass20 extends RongIMClient.ResultCallback<Conversation> {
        AnonymousClass20() {
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onError(RongIMClient.ErrorCode errorCode) {
        }

        @Override // io.rong.imlib.RongIMClient.ResultCallback
        public void onSuccess(final Conversation conversation) {
            ConversationFragment.this.mConversation = conversation;
            if (conversation == null || !ConversationFragment.this.isActivityExist()) {
                return;
            }
            if (ConversationFragment.this.mSavedInstanceState != null) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.mUnReadCount = conversationFragment.mSavedInstanceState.getInt(ConversationFragment.UN_READ_COUNT);
            } else {
                ConversationFragment.this.mUnReadCount = conversation.getUnreadMessageCount();
            }
            ConversationFragment conversationFragment2 = ConversationFragment.this;
            conversationFragment2.conversationUnreadCount = conversationFragment2.mUnReadCount;
            boolean z = (ConversationFragment.this.getActivity() == null || !ConversationFragment.this.isAdded()) ? false : SharedPreferencesUtils.get(ConversationFragment.this.getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getBoolean(ConversationFragment.this.getSavedReadReceiptStatusName(), false);
            if (ConversationFragment.this.mUnReadCount > 0 || z) {
                boolean z2 = ConversationFragment.this.mConversationType.equals(Conversation.ConversationType.PRIVATE) && RongContext.getInstance().isReadReceiptConversationType(Conversation.ConversationType.PRIVATE);
                boolean z3 = ConversationFragment.this.mConversationType.equals(Conversation.ConversationType.ENCRYPTED) && RongContext.getInstance().isReadReceiptConversationType(Conversation.ConversationType.ENCRYPTED);
                if (ConversationFragment.this.mReadRec && (z2 || z3)) {
                    RongIMClient.getInstance().sendReadReceiptMessage(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, conversation.getSentTime(), new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.20.1
                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onAttached(Message message) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                            RLog.e(ConversationFragment.TAG, "sendReadReceiptMessage errorCode = " + errorCode.getValue());
                            ConversationFragment.this.saveSendReadReceiptStatusToSp(true, conversation.getSentTime());
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onSuccess(Message message) {
                            ConversationFragment.this.removeSendReadReceiptStatusToSp();
                        }
                    });
                }
                if (ConversationFragment.this.mSyncReadStatus && ((!ConversationFragment.this.mReadRec && ConversationFragment.this.mConversationType == Conversation.ConversationType.PRIVATE) || ConversationFragment.this.mConversationType == Conversation.ConversationType.GROUP || ConversationFragment.this.mConversationType == Conversation.ConversationType.DISCUSSION || ConversationFragment.this.mConversationType == Conversation.ConversationType.PUBLIC_SERVICE)) {
                    RongIMClient.getInstance().syncConversationReadStatus(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, conversation.getSentTime(), null);
                }
            }
            if (conversation.getMentionedCount() > 0) {
                ConversationFragment conversationFragment3 = ConversationFragment.this;
                conversationFragment3.getLastMentionedMessageId(conversationFragment3.mConversationType, ConversationFragment.this.mTargetId);
            } else {
                RongIMClient.getInstance().getTheFirstUnreadMessage(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, new RongIMClient.ResultCallback<Message>() { // from class: io.rong.imkit.fragment.ConversationFragment.20.2
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        RongIM.getInstance().clearMessagesUnreadStatus(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, null);
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(Message message) {
                        ConversationFragment.this.firstUnreadMessage = message;
                        if (ConversationFragment.this.mUnReadCount > 10 && ConversationFragment.this.mUnreadMsgLayout != null && ConversationFragment.this.firstUnreadMessage != null) {
                            ConversationFragment.this.showUnreadMsgLayout();
                        }
                        ConversationFragment.this.refreshUnreadUI();
                        RongIM.getInstance().clearMessagesUnreadStatus(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, null);
                    }
                });
            }
            if (ConversationFragment.this.mUnReadCount <= 10 || ConversationFragment.this.mUnreadMsgLayout == null) {
                return;
            }
            if (ConversationFragment.this.mUnReadCount > 99) {
                ConversationFragment.this.mUnreadMsgCountTv.setText(String.format("%s%s", StringConstant.WHEEL_BLOCK_LIMIT, ConversationFragment.this.getActivity().getResources().getString(R.string.rc_new_messages)));
            } else {
                ConversationFragment.this.mUnreadMsgCountTv.setText(String.format("%s%s", Integer.valueOf(ConversationFragment.this.mUnReadCount), ConversationFragment.this.getActivity().getResources().getString(R.string.rc_new_messages)));
            }
            ConversationFragment.this.mUnreadMsgLayout.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.20.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ConversationFragment.this.mUnreadMsgLayout.setClickable(false);
                    ConversationFragment.this.mList.removeOnScrollListener(ConversationFragment.this.mOnScrollListener);
                    TranslateAnimation translateAnimation = new TranslateAnimation(WheelView.DividerConfig.FILL, 500.0f, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
                    translateAnimation.setDuration(500L);
                    ConversationFragment.this.mUnreadMsgLayout.startAnimation(translateAnimation);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: io.rong.imkit.fragment.ConversationFragment.20.3.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (ConversationFragment.this.firstUnreadMessage == null) {
                                RLog.e(ConversationFragment.TAG, "firstUnreadMessage is null");
                                return;
                            }
                            ConversationFragment conversationFragment4 = ConversationFragment.this;
                            conversationFragment4.indexMessageTime = conversationFragment4.firstUnreadMessage.getSentTime();
                            int iFindPosition = ConversationFragment.this.mListAdapter.findPosition(ConversationFragment.this.firstUnreadMessage.getMessageId());
                            if (iFindPosition == 0) {
                                ConversationFragment.this.mList.setSelection(iFindPosition);
                                return;
                            }
                            if (iFindPosition > 0) {
                                ConversationFragment.this.mList.setSelection(iFindPosition - 1);
                                return;
                            }
                            ConversationFragment.this.isClickUnread = true;
                            ConversationFragment.this.mListAdapter.clear();
                            ConversationFragment.this.mIsInsertNewMsg = false;
                            ConversationFragment conversationFragment5 = ConversationFragment.this;
                            conversationFragment5.getHistoryMessage(conversationFragment5.mConversationType, ConversationFragment.this.mTargetId, 10, AutoRefreshListView.Mode.END, 2, ConversationFragment.this.firstUnreadMessage.getMessageId());
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                }
            });
        }
    }

    protected enum LoadMessageDirection {
        DOWN,
        UP
    }

    private void addReferenceLongClickAction() {
        this.clickActionReference = new MessageItemLongClickAction.Builder().titleResId(R.string.rc_reference).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.12
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
            public boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                ConversationFragment conversationFragment = ConversationFragment.this;
                conversationFragment.referenceMessage = conversationFragment.referenceView.setMessageContent(uIMessage);
                ConversationFragment conversationFragment2 = ConversationFragment.this;
                if (conversationFragment2.referenceMessage == null) {
                    return true;
                }
                if (conversationFragment2.mRongExtension != null) {
                    ConversationFragment.this.mRongExtension.collapseExtension();
                }
                if (ConversationFragment.this.mVoiceInputToggle.getVisibility() == 0) {
                    ConversationFragment.this.mVoiceToggle.performClick();
                }
                if (ConversationFragment.this.mList != null) {
                    ConversationFragment.this.mList.setSelection(ConversationFragment.this.mList.getCount());
                }
                ConversationFragment.this.referenceView.getHandler().postDelayed(new Runnable() { // from class: io.rong.imkit.fragment.ConversationFragment.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConversationFragment.this.mRongExtension != null) {
                            ConversationFragment.this.mRongExtension.showSoftInput();
                        }
                        ConversationFragment.this.referenceView.setVisibility(0);
                    }
                }, 200L);
                return true;
            }
        }).showFilter(new MessageItemLongClickAction.Filter() { // from class: io.rong.imkit.fragment.ConversationFragment.11
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.Filter
            public boolean filter(UIMessage uIMessage) {
                return (uIMessage.getMessage().getSentStatus() != Message.SentStatus.FAILED) && (ConversationFragment.this.getContext() != null ? ConversationFragment.this.getContext().getResources().getBoolean(R.bool.rc_enable_reference_message) : false) && ((uIMessage.getContent() instanceof TextMessage) || (uIMessage.getContent() instanceof ImageMessage) || (uIMessage.getContent() instanceof FileMessage) || (uIMessage.getContent() instanceof RichContentMessage) || (uIMessage.getContent() instanceof ReferenceMessage)) && !(uIMessage.getConversationType().equals(Conversation.ConversationType.ENCRYPTED) || uIMessage.getConversationType().equals(Conversation.ConversationType.APP_PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.PUBLIC_SERVICE) || uIMessage.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE)) && (uIMessage.getContent().isDestruct() ^ true) && ((ConversationFragment.this.mRongExtension != null && ConversationFragment.this.mRongExtension.isFireStatus()) ^ true);
            }
        }).build();
        RongMessageItemLongClickActionManager.getInstance().addMessageItemLongClickAction(this.clickActionReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQuit(String str) {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
        CSEvaluateDialog cSEvaluateDialog = this.mEvaluateDialg;
        if (cSEvaluateDialog == null) {
            CustomServiceConfig customServiceConfig = this.mCustomServiceConfig;
            if (customServiceConfig != null) {
                onCustomServiceWarning(str, customServiceConfig.quitSuspendType == CustomServiceConfig.CSQuitSuspendType.NONE, this.robotType);
            }
        } else {
            cSEvaluateDialog.destroy();
        }
        CustomServiceConfig customServiceConfig2 = this.mCustomServiceConfig;
        if (customServiceConfig2 == null || customServiceConfig2.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.NONE)) {
            return;
        }
        RongContext.getInstance().getEventBus().post(new Event.CSTerminateEvent(getActivity(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQuitEvaluate(final String str) {
        if (this.mEvaluateDialg == null) {
            this.mEvaluateDialg = new CSEvaluateDialog(getActivity(), this.mTargetId);
            this.mEvaluateDialg.setClickListener(new CSEvaluateDialog.EvaluateClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.25
                @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
                public void onEvaluateCanceled() {
                    ConversationFragment.this.csQuitEvaluateButtonClick(str);
                }

                @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
                public void onEvaluateSubmit() {
                    ConversationFragment.this.csQuitEvaluateButtonClick(str);
                }
            });
            this.mEvaluateDialg.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: io.rong.imkit.fragment.ConversationFragment.26
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (ConversationFragment.this.mEvaluateDialg != null) {
                        ConversationFragment.this.mEvaluateDialg = null;
                    }
                }
            });
            this.mEvaluateDialg.showStar("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csQuitEvaluateButtonClick(String str) {
        CSEvaluateDialog cSEvaluateDialog = this.mEvaluateDialg;
        if (cSEvaluateDialog != null) {
            cSEvaluateDialog.destroy();
            this.mEvaluateDialg = null;
        }
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
        CSEvaluateDialog cSEvaluateDialog2 = this.mEvaluateDialg;
        if (cSEvaluateDialog2 == null) {
            onCustomServiceWarning(str, false, this.robotType);
        } else {
            cSEvaluateDialog2.destroy();
        }
        CustomServiceConfig customServiceConfig = this.mCustomServiceConfig;
        if (customServiceConfig == null || customServiceConfig.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.NONE)) {
            return;
        }
        RongContext.getInstance().getEventBus().post(new Event.CSTerminateEvent(getActivity(), str));
    }

    private void destroy() {
        RongIM.getInstance().clearMessagesUnreadStatus(this.mConversationType, this.mTargetId, null);
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
        if (this.mConversationType.equals(Conversation.ConversationType.CHATROOM)) {
            SendImageManager.getInstance().cancelSendingImages(this.mConversationType, this.mTargetId);
            SendMediaManager.getInstance().cancelSendingMedia(this.mConversationType, this.mTargetId);
            RongIM.getInstance().quitChatRoom(this.mTargetId, null);
        }
        if (this.mConversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE) && this.mCSNeedToQuit) {
            onStopCustomService(this.mTargetId);
        }
        if (this.mSyncReadStatus && this.mSyncReadStatusMsgTime > 0 && (this.mConversationType.equals(Conversation.ConversationType.DISCUSSION) || this.mConversationType.equals(Conversation.ConversationType.GROUP))) {
            RongIMClient.getInstance().syncConversationReadStatus(this.mConversationType, this.mTargetId, this.mSyncReadStatusMsgTime, null);
        }
        EventBus.getDefault().unregister(this);
        stopAudioThingsDependsOnVoipMode();
        try {
            if (this.mKitReceiver != null && getActivity() != null) {
                getActivity().unregisterReceiver(this.mKitReceiver);
            }
        } catch (Exception e2) {
            RLog.e(TAG, "destroy", e2);
        }
        RongContext.getInstance().unregisterConversationInfo(this.mCurrentConversationInfo);
        if (getActivity() == null || !getActivity().getResources().getBoolean(R.bool.rc_location_2D)) {
            LocationManager.getInstance().quitLocationSharing();
            LocationManager.getInstance().setParticipantChangedListener(null);
            LocationManager.getInstance().setUserInfoProvider(null);
            LocationManager.getInstance().unBindConversation();
        } else {
            LocationManager2D.getInstance().quitLocationSharing();
            LocationManager2D.getInstance().setParticipantChangedListener(null);
            LocationManager2D.getInstance().setUserInfoProvider(null);
            LocationManager2D.getInstance().unBindConversation();
        }
        destroyExtension();
    }

    private void destroyExtension() {
        String string = this.mRongExtension.getInputEditText().getText().toString();
        String strEncode = DraftHelper.encode(string, RongMentionManager.getInstance().getMentionBlockInfo());
        if ((TextUtils.isEmpty(string) && !TextUtils.isEmpty(this.mDraft)) || ((!TextUtils.isEmpty(string) && TextUtils.isEmpty(this.mDraft)) || (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(this.mDraft) && !string.equals(this.mDraft)))) {
            RongIMClient.getInstance().saveTextMessageDraft(this.mConversationType, this.mTargetId, strEncode, null);
            RongContext.getInstance().getEventBus().post(new Event.DraftEvent(this.mConversationType, this.mTargetId, string));
        }
        this.mRongExtension.onDestroy();
        this.mRongExtension = null;
        if (this.mEnableMention) {
            if (this.mConversationType.equals(Conversation.ConversationType.DISCUSSION) || this.mConversationType.equals(Conversation.ConversationType.GROUP)) {
                RongMentionManager.getInstance().destroyInstance(this.mConversationType, this.mTargetId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Message> filterDestructionMessage(Conversation.ConversationType conversationType, String str, List<Message> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Message message : list) {
            if (message.getContent().isDestruct() && message.getReadTime() > 0) {
                if (!message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                    arrayList2.add(message);
                } else if (((System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime()) - message.getReadTime()) / 1000 >= message.getContent().getDestructTime()) {
                    arrayList2.add(message);
                }
            }
            arrayList.add(message);
        }
        if (arrayList2.size() > 0) {
            Message[] messageArr = new Message[arrayList2.size()];
            arrayList2.toArray(messageArr);
            DestructManager.getInstance().deleteMessages(conversationType, str, messageArr);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<UIMessage> filterMessage(List<UIMessage> list) {
        if (this.mListAdapter.getCount() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mListAdapter.getCount(); i++) {
            for (UIMessage uIMessage : list) {
                if (!arrayList.contains(uIMessage) && uIMessage.getMessageId() != this.mListAdapter.getItem(i).getMessageId()) {
                    arrayList.add(uIMessage);
                }
            }
        }
        return arrayList;
    }

    private void forwardMessage(Intent intent) {
        if (intent == null) {
            return;
        }
        ForwardManager.getInstance().forwardMessages(intent.getIntExtra(FirebaseAnalytics.Param.INDEX, 0), intent.getParcelableArrayListExtra("conversations"), intent.getIntegerArrayListExtra("messageIds"), getCheckedMessages());
        resetMoreActionState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLastMentionedMessageId(Conversation.ConversationType conversationType, String str) {
        RongIMClient.getInstance().getUnreadMentionedMessages(conversationType, str, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.42
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RongIM.getInstance().clearMessagesUnreadStatus(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, null);
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                if (list != null && list.size() > 0) {
                    ConversationFragment.this.mLastMentionMsgId = list.get(0).getMessageId();
                    int iFindPosition = ConversationFragment.this.mListAdapter.findPosition(ConversationFragment.this.mLastMentionMsgId);
                    RLog.i(ConversationFragment.TAG, "getLastMentionedMessageId " + ConversationFragment.this.mLastMentionMsgId + " " + iFindPosition);
                    if (ConversationFragment.this.mLastMentionMsgId > 0 && iFindPosition >= 0) {
                        ConversationFragment.this.mList.setSelection(iFindPosition);
                        ConversationFragment.this.mLastMentionMsgId = 0;
                    }
                }
                RongIM.getInstance().clearMessagesUnreadStatus(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, null);
            }
        });
    }

    private View getListViewChildAt(int i) {
        int headerViewsCount = this.mList.getHeaderViewsCount();
        return this.mList.getChildAt((i + headerViewsCount) - this.mList.getFirstVisiblePosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNameFromCache(String str) {
        UserInfo userInfoFromCache = RongContext.getInstance().getUserInfoFromCache(str);
        return userInfoFromCache == null ? str : userInfoFromCache.getName();
    }

    private int getPositionInAdapter(int i) {
        int headerViewsCount = this.mList.getHeaderViewsCount();
        if (i <= 0) {
            return 0;
        }
        return i - headerViewsCount;
    }

    private int getPositionInListView(int i) {
        return i + this.mList.getHeaderViewsCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSavedReadReceiptStatusName() {
        if (TextUtils.isEmpty(this.mTargetId) || this.mConversationType == null) {
            return "";
        }
        return "ReadReceipt" + DeviceUtils.ShortMD5(0, RongIM.getInstance().getCurrentUserId(), this.mTargetId, this.mConversationType.getName()) + "Status";
    }

    private String getSavedReadReceiptTimeName() {
        if (TextUtils.isEmpty(this.mTargetId) || this.mConversationType == null) {
            return "";
        }
        return "ReadReceipt" + DeviceUtils.ShortMD5(0, RongIM.getInstance().getCurrentUserId(), this.mTargetId, this.mConversationType.getName()) + "Time";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAudioPlayEvent(Event.PlayAudioEvent playAudioEvent) {
        RLog.i(TAG, "PlayAudioEvent");
        int firstVisiblePosition = this.mList.getFirstVisiblePosition();
        int lastVisiblePosition = this.mList.getLastVisiblePosition();
        int iFindPosition = this.mListAdapter.findPosition(playAudioEvent.messageId);
        if (!playAudioEvent.continuously || iFindPosition < 0) {
            return;
        }
        while (firstVisiblePosition <= lastVisiblePosition) {
            iFindPosition++;
            firstVisiblePosition++;
            UIMessage item = this.mListAdapter.getItem(iFindPosition);
            if (item != null && ((item.getContent() instanceof VoiceMessage) || (item.getMessage().getContent() instanceof HQVoiceMessage))) {
                if (item.getMessageDirection().equals(Message.MessageDirection.RECEIVE) && !item.getReceivedStatus().isListened() && !item.getContent().isDestruct()) {
                    item.continuePlayAudio = true;
                    this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
                    return;
                }
            }
        }
    }

    private void handleEventAfterAllMessageLoaded(Message message) {
        HQVoiceMsgDownloadManager.getInstance().enqueue(this, new AutoDownloadEntry(message, AutoDownloadEntry.DownloadPriority.HIGH));
        boolean z = false;
        boolean z2 = message.getConversationType().equals(Conversation.ConversationType.PRIVATE) && RongContext.getInstance().isReadReceiptConversationType(Conversation.ConversationType.PRIVATE);
        if (message.getConversationType().equals(Conversation.ConversationType.ENCRYPTED) && RongContext.getInstance().isReadReceiptConversationType(Conversation.ConversationType.ENCRYPTED)) {
            z = true;
        }
        if ((z2 || z) && message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            if (this.mReadRec && !TextUtils.isEmpty(message.getUId())) {
                if (RongIMClient.getInstance().getTopForegroundActivity() == null || !RongIMClient.getInstance().getTopForegroundActivity().equals(getActivity())) {
                    saveSendReadReceiptStatusToSp(true, message.getSentTime());
                } else {
                    RongIMClient.getInstance().sendReadReceiptMessage(message.getConversationType(), message.getTargetId(), message.getSentTime(), new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.34
                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onAttached(Message message2) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onError(Message message2, RongIMClient.ErrorCode errorCode) {
                            RLog.e(ConversationFragment.TAG, "sendReadReceiptMessage errorCode = " + errorCode.getValue());
                            ConversationFragment.this.saveSendReadReceiptStatusToSp(true, message2.getSentTime());
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onSuccess(Message message2) {
                            ConversationFragment.this.removeSendReadReceiptStatusToSp();
                        }
                    });
                }
            }
            if (this.mReadRec || !this.mSyncReadStatus) {
                return;
            }
            RongIMClient.getInstance().syncConversationReadStatus(message.getConversationType(), message.getTargetId(), message.getSentTime(), null);
        }
    }

    private void insertToEditText(String str, EditText editText) {
        int length = str.length();
        int selectionStart = editText.getSelectionStart();
        editText.getEditableText().insert(selectionStart, str);
        editText.setSelection(selectionStart + length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActivityExist() {
        return (getActivity() == null || getActivity().isFinishing()) ? false : true;
    }

    private boolean isSelfSendMessage(Message message) {
        String currentUserId = RongIM.getInstance().getCurrentUserId();
        String senderUserId = message.getSenderUserId();
        return currentUserId != null && senderUserId != null && currentUserId.equals(senderUserId) && this.mTargetId.equals(message.getTargetId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(List<Message> list, boolean z, int i, int i2, LoadMessageDirection loadMessageDirection) {
        if (z) {
            this.mListAdapter.notifyDataSetChanged();
            int i3 = this.mLastMentionMsgId;
            int i4 = 0;
            if (i3 > 0) {
                this.mList.setSelection(this.mListAdapter.findPosition(i3));
                this.mLastMentionMsgId = 0;
            } else if (2 == i) {
                this.mList.setSelection(0);
            } else if (i == 3) {
                if (i2 != -1 || this.mSavedInstanceState == null) {
                    AutoRefreshListView autoRefreshListView = this.mList;
                    autoRefreshListView.setSelection(autoRefreshListView.getCount());
                } else {
                    this.mList.onRestoreInstanceState(this.mListViewState);
                }
            } else if (loadMessageDirection != LoadMessageDirection.DOWN) {
                this.mList.setSelection(list.size() + 1);
            } else if (this.mList.getSelectedItemPosition() <= 0) {
                while (true) {
                    if (i4 >= this.mListAdapter.getCount()) {
                        break;
                    }
                    if (this.mListAdapter.getItem(i4).getSentTime() == this.indexMessageTime) {
                        this.mList.setSelection(i4);
                        break;
                    }
                    i4++;
                }
            } else {
                this.mList.setSelection(this.mListAdapter.getCount() - list.size());
            }
            sendReadReceiptResponseIfNeeded(list);
            if (RongContext.getInstance().getUnreadMessageState() && i2 == -1 && this.mUnReadCount > 10) {
                this.mList.postDelayed(new Runnable() { // from class: io.rong.imkit.fragment.ConversationFragment.39
                    @Override // java.lang.Runnable
                    public void run() {
                        ConversationFragment.this.mList.addOnScrollListener(ConversationFragment.this.mOnScrollListener);
                    }
                }, 100L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void refreshUnreadUI() {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.fragment.ConversationFragment.refreshUnreadUI():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSendReadReceiptStatusToSp() {
        if (getActivity() == null || !isAdded()) {
            return;
        }
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit();
        editorEdit.remove(getSavedReadReceiptStatusName());
        editorEdit.remove(getSavedReadReceiptTimeName());
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveSendReadReceiptStatusToSp(boolean z, long j) {
        if (getActivity() == null || !isAdded()) {
            return;
        }
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).edit();
        editorEdit.putBoolean(getSavedReadReceiptStatusName(), z);
        editorEdit.putLong(getSavedReadReceiptTimeName(), j);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReadReceiptResponseIfNeeded(List<Message> list) {
        if (this.mReadRec) {
            if ((this.mConversationType.equals(Conversation.ConversationType.GROUP) || this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(this.mConversationType)) {
                ArrayList arrayList = new ArrayList();
                for (Message message : list) {
                    ReadReceiptInfo readReceiptInfo = message.getReadReceiptInfo();
                    if (readReceiptInfo != null && readReceiptInfo.isReadReceiptMessage() && !readReceiptInfo.hasRespond()) {
                        arrayList.add(message);
                    }
                }
                if (arrayList.size() > 0) {
                    RongIMClient.getInstance().sendReadReceiptResponse(this.mConversationType, this.mTargetId, arrayList, null);
                }
            }
        }
    }

    private void showNewMessage() {
        int i;
        RongContext rongContext = RongContext.getInstance();
        if (rongContext == null || !rongContext.getNewMessageState() || (i = this.mNewMessageCount) < 0) {
            return;
        }
        if (i == 0) {
            this.mNewMessageBtn.setVisibility(8);
            this.mNewMessageTextView.setVisibility(8);
            return;
        }
        this.mNewMessageBtn.setVisibility(0);
        this.mNewMessageTextView.setVisibility(0);
        TextView textView = this.mNewMessageTextView;
        int i2 = this.mNewMessageCount;
        textView.setText(i2 > 99 ? StringConstant.WHEEL_BLOCK_LIMIT : Integer.toString(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnreadMsgLayout() {
        TranslateAnimation translateAnimation = new TranslateAnimation(300.0f, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        AlphaAnimation alphaAnimation = new AlphaAnimation(WheelView.DividerConfig.FILL, 1.0f);
        translateAnimation.setDuration(1000L);
        alphaAnimation.setDuration(2000L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        LinearLayout linearLayout = this.mUnreadMsgLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
            this.mUnreadMsgLayout.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer(int i, int i2) {
        getHandler().removeMessages(i);
        getHandler().sendEmptyMessageDelayed(i, i2);
    }

    private void stopAudioThingsDependsOnVoipMode() {
        if (!AudioPlayManager.getInstance().isInVOIPMode(getActivity())) {
            AudioPlayManager.getInstance().stopPlay();
        }
        AudioRecordManager.getInstance().destroyRecord();
    }

    private void stopTimer(int i) {
        getHandler().removeMessages(i);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public List<Message> getCheckedMessages() {
        MessageListAdapter messageListAdapter = this.mListAdapter;
        if (messageListAdapter != null) {
            return messageListAdapter.getCheckedMessage();
        }
        return null;
    }

    public Conversation.ConversationType getConversationType() {
        return this.mConversationType;
    }

    public void getHistoryMessage(final Conversation.ConversationType conversationType, final String str, int i, int i2, LoadMessageDirection loadMessageDirection, final IHistoryDataResultCallback<List<Message>> iHistoryDataResultCallback) {
        if (loadMessageDirection == LoadMessageDirection.UP) {
            RongIMClient.getInstance().getHistoryMessages(conversationType, str, i, i2, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.36
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RLog.e(ConversationFragment.TAG, "getHistoryMessages " + errorCode);
                    IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                    if (iHistoryDataResultCallback2 != null) {
                        iHistoryDataResultCallback2.onResult(null);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(List<Message> list) {
                    IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                    if (iHistoryDataResultCallback2 != null) {
                        iHistoryDataResultCallback2.onResult(list);
                    }
                }
            });
        } else {
            RongIMClient.getInstance().getHistoryMessages(conversationType, str, this.indexMessageTime, (this.mListAdapter.getCount() > 0 || this.indexMessageTime != 0 || this.isClickUnread) ? 0 : 10, 10, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.37
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    RLog.e(ConversationFragment.TAG, "getHistoryMessages " + errorCode);
                    IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                    if (iHistoryDataResultCallback2 != null) {
                        iHistoryDataResultCallback2.onResult(null);
                    }
                    ConversationFragment.this.indexMessageTime = 0L;
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(List<Message> list) {
                    IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                    if (iHistoryDataResultCallback2 != null) {
                        iHistoryDataResultCallback2.onResult(ConversationFragment.this.filterDestructionMessage(conversationType, str, list));
                    }
                    if (list == null || list.size() <= 0 || !ConversationFragment.this.mHasMoreLocalMessagesDown) {
                        ConversationFragment.this.indexMessageTime = 0L;
                    } else {
                        ConversationFragment.this.indexMessageTime = list.get(0).getSentTime();
                    }
                }
            });
        }
    }

    public MessageListAdapter getMessageAdapter() {
        return this.mListAdapter;
    }

    public List<IClickActions> getMoreClickActions() {
        ArrayList arrayList = new ArrayList();
        Conversation.ConversationType conversationType = this.mConversationType;
        if ((conversationType == Conversation.ConversationType.GROUP || conversationType == Conversation.ConversationType.PRIVATE) && getContext() != null && getContext().getResources().getBoolean(R.bool.rc_enable_send_combine_message)) {
            arrayList.add(new ForwardClickActions());
        }
        arrayList.add(new DeleteClickActions());
        return arrayList;
    }

    public void getPublicServiceProfile(Conversation.PublicServiceType publicServiceType, String str) {
        RongIM.getInstance().getPublicServiceProfile(publicServiceType, this.mTargetId, new RongIMClient.ResultCallback<PublicServiceProfile>() { // from class: io.rong.imkit.fragment.ConversationFragment.21
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(PublicServiceProfile publicServiceProfile) {
                ConversationFragment.this.updatePublicServiceMenu(publicServiceProfile);
            }
        });
    }

    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, long j, int i, final IHistoryDataResultCallback<List<Message>> iHistoryDataResultCallback) {
        RongIMClient.getInstance().getRemoteHistoryMessages(conversationType, str, j, i, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.40
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RLog.e(ConversationFragment.TAG, "getRemoteHistoryMessages " + errorCode);
                IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                if (iHistoryDataResultCallback2 != null) {
                    iHistoryDataResultCallback2.onResult(null);
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                if (iHistoryDataResultCallback2 != null) {
                    iHistoryDataResultCallback2.onResult(list);
                }
            }
        });
    }

    public Intent getSelectIntentForForward() {
        return new Intent(getActivity(), (Class<?>) SelectConversationActivity.class);
    }

    public String getTargetId() {
        return this.mTargetId;
    }

    @Override // io.rong.imkit.plugin.location.IUserInfoProvider
    public final void getUserInfo(String str, IUserInfoProvider.UserInfoCallback userInfoCallback) {
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str);
        if (userInfo != null) {
            userInfoCallback.onGotUserInfo(userInfo);
        }
    }

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        CustomServiceConfig customServiceConfig;
        CustomServiceConfig customServiceConfig2;
        int i = message.what;
        if (i == 0) {
            if (isActivityExist() && (customServiceConfig = this.mCustomServiceConfig) != null) {
                InformationNotificationMessage informationNotificationMessage = new InformationNotificationMessage(customServiceConfig.userTipWord);
                RongIM rongIM = RongIM.getInstance();
                Conversation.ConversationType conversationType = Conversation.ConversationType.CUSTOMER_SERVICE;
                String str = this.mTargetId;
                rongIM.insertIncomingMessage(conversationType, str, str, null, informationNotificationMessage, System.currentTimeMillis(), null);
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        if (isActivityExist() && (customServiceConfig2 = this.mCustomServiceConfig) != null) {
            InformationNotificationMessage informationNotificationMessage2 = new InformationNotificationMessage(customServiceConfig2.adminTipWord);
            RongIM rongIM2 = RongIM.getInstance();
            Conversation.ConversationType conversationType2 = Conversation.ConversationType.CUSTOMER_SERVICE;
            String str2 = this.mTargetId;
            rongIM2.insertIncomingMessage(conversationType2, str2, str2, null, informationNotificationMessage2, System.currentTimeMillis(), null);
        }
        return true;
    }

    public void hideNotificationView(View view) {
        View viewFindViewById;
        if (view == null || (viewFindViewById = this.mNotificationContainer.findViewById(view.getId())) == null) {
            return;
        }
        this.mNotificationContainer.removeView(viewFindViewById);
        if (this.mNotificationContainer.getChildCount() == 0) {
            this.mNotificationContainer.setVisibility(8);
        }
    }

    protected void hideReferenceView() {
        ReferenceView referenceView = this.referenceView;
        if (referenceView != null) {
            referenceView.clearReference();
        }
        this.referenceMessage = null;
    }

    protected void increaseNewMessageCountIfNeed(Message message) {
        updateNewMessageCountIfNeed(message, true);
    }

    public View inflateNotificationView(int i) {
        return LayoutInflater.from(getActivity()).inflate(i, (ViewGroup) this.mNotificationContainer, false);
    }

    @Override // io.rong.imkit.fragment.UriFragment
    protected void initFragment(Uri uri) {
        Class<?> cls;
        Object locationManager;
        this.indexMessageTime = getActivity().getIntent().getLongExtra("indexMessageTime", 0L);
        RLog.d(TAG, "initFragment : " + uri + ",this=" + this + ", time = " + this.indexMessageTime);
        if (uri != null) {
            this.mConversationType = Conversation.ConversationType.valueOf(uri.getLastPathSegment().toUpperCase(Locale.US));
            this.mTargetId = uri.getQueryParameter("targetId");
            this.mRongExtension.setConversation(this.mConversationType, this.mTargetId);
            RongIMClient.getInstance().getTextMessageDraft(this.mConversationType, this.mTargetId, new RongIMClient.ResultCallback<String>() { // from class: io.rong.imkit.fragment.ConversationFragment.15
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    if (ConversationFragment.this.mRongExtension != null) {
                        ConversationFragment.this.mRongExtension.setExtensionClickListener(ConversationFragment.this);
                    }
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(String str) {
                    DraftHelper draftHelper = new DraftHelper(str);
                    ConversationFragment.this.mDraft = draftHelper.decode();
                    if (ConversationFragment.this.mRongExtension != null) {
                        if (!TextUtils.isEmpty(ConversationFragment.this.mDraft)) {
                            EditText inputEditText = ConversationFragment.this.mRongExtension.getInputEditText();
                            inputEditText.setText(ConversationFragment.this.mDraft);
                            draftHelper.restoreMentionInfo();
                            inputEditText.setSelection(inputEditText.length());
                            inputEditText.requestFocus();
                        }
                        ConversationFragment.this.mRongExtension.setExtensionClickListener(ConversationFragment.this);
                    }
                }
            });
            this.mCurrentConversationInfo = ConversationInfo.obtain(this.mConversationType, this.mTargetId);
            RongContext.getInstance().registerConversationInfo(this.mCurrentConversationInfo);
            this.mNotificationContainer = (LinearLayout) this.mMsgListView.findViewById(R.id.rc_notification_container);
            if (this.mConversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE) && getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getData() != null) {
                this.mCustomUserInfo = (CSCustomServiceInfo) getActivity().getIntent().getParcelableExtra("customServiceInfo");
            }
            boolean z = false;
            try {
                if (getActivity() == null || !getActivity().getResources().getBoolean(R.bool.rc_location_2D)) {
                    cls = Class.forName("io.rong.imkit.plugin.location.LocationManager");
                    locationManager = LocationManager.getInstance();
                } else {
                    cls = Class.forName("io.rong.imkit.plugin.location.LocationManager2D");
                    locationManager = LocationManager2D.getInstance();
                }
                Method method = cls.getMethod("bindConversation", Context.class, Conversation.ConversationType.class, String.class);
                Method method2 = cls.getMethod("setUserInfoProvider", IUserInfoProvider.class);
                Method method3 = cls.getMethod("setParticipantChangedListener", IRealTimeLocationStateListener.class);
                method.invoke(locationManager, getActivity(), this.mConversationType, this.mTargetId);
                method2.invoke(locationManager, this);
                method3.invoke(locationManager, new AnonymousClass16());
            } catch (Exception e2) {
                RLog.e(TAG, "Exception :", e2);
            } catch (Throwable th) {
                RLog.e(TAG, "Throwable :", th);
            }
            if (this.mConversationType.equals(Conversation.ConversationType.CHATROOM)) {
                if (isActivityExist() && getActivity().getIntent().getBooleanExtra("createIfNotExist", true)) {
                    z = true;
                }
                int integer = getResources().getInteger(R.integer.rc_chatroom_first_pull_message_count);
                if (z) {
                    RongIMClient.getInstance().joinChatRoom(this.mTargetId, integer, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.17
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            RLog.e(ConversationFragment.TAG, "joinChatRoom onError : " + errorCode);
                            if (ConversationFragment.this.isActivityExist()) {
                                if (errorCode == RongIMClient.ErrorCode.RC_NET_UNAVAILABLE || errorCode == RongIMClient.ErrorCode.RC_NET_CHANNEL_INVALID) {
                                    ConversationFragment conversationFragment = ConversationFragment.this;
                                    conversationFragment.onWarningDialog(conversationFragment.getString(R.string.rc_notice_network_unavailable));
                                } else {
                                    ConversationFragment conversationFragment2 = ConversationFragment.this;
                                    conversationFragment2.onWarningDialog(conversationFragment2.getString(R.string.rc_join_chatroom_failure));
                                }
                            }
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            RLog.i(ConversationFragment.TAG, "joinChatRoom onSuccess : " + ConversationFragment.this.mTargetId);
                        }
                    });
                } else {
                    RongIMClient.getInstance().joinExistChatRoom(this.mTargetId, integer, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.18
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            RLog.e(ConversationFragment.TAG, "joinExistChatRoom onError : " + errorCode);
                            if (ConversationFragment.this.isActivityExist()) {
                                if (errorCode == RongIMClient.ErrorCode.RC_NET_UNAVAILABLE || errorCode == RongIMClient.ErrorCode.RC_NET_CHANNEL_INVALID) {
                                    ConversationFragment conversationFragment = ConversationFragment.this;
                                    conversationFragment.onWarningDialog(conversationFragment.getString(R.string.rc_notice_network_unavailable));
                                } else {
                                    ConversationFragment conversationFragment2 = ConversationFragment.this;
                                    conversationFragment2.onWarningDialog(conversationFragment2.getString(R.string.rc_join_chatroom_failure));
                                }
                            }
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            RLog.i(ConversationFragment.TAG, "joinExistChatRoom onSuccess : " + ConversationFragment.this.mTargetId);
                        }
                    });
                }
            } else {
                Conversation.ConversationType conversationType = this.mConversationType;
                if (conversationType == Conversation.ConversationType.APP_PUBLIC_SERVICE || conversationType == Conversation.ConversationType.PUBLIC_SERVICE) {
                    PublicServiceCommandMessage publicServiceCommandMessage = new PublicServiceCommandMessage();
                    publicServiceCommandMessage.setCommand(PublicServiceMenu.PublicServiceMenuItemType.Entry.getMessage());
                    RongIMClient.getInstance().sendMessage(Message.obtain(this.mTargetId, this.mConversationType, publicServiceCommandMessage), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.19
                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onAttached(Message message) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
                        public void onSuccess(Message message) {
                        }
                    });
                    getPublicServiceProfile(this.mConversationType == Conversation.ConversationType.PUBLIC_SERVICE ? Conversation.PublicServiceType.PUBLIC_SERVICE : Conversation.PublicServiceType.APP_PUBLIC_SERVICE, this.mTargetId);
                } else if (conversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE)) {
                    onStartCustomService(this.mTargetId);
                } else if (this.mEnableMention && (this.mConversationType.equals(Conversation.ConversationType.DISCUSSION) || this.mConversationType.equals(Conversation.ConversationType.GROUP))) {
                    RongMentionManager.getInstance().createInstance(this.mConversationType, this.mTargetId, this.mRongExtension.getInputEditText());
                    RongMentionManager.getInstance().setAddMentionedMemberListener(this.mAddMentionedMemberListener);
                }
            }
        }
        RongIMClient.getInstance().getConversation(this.mConversationType, this.mTargetId, new AnonymousClass20());
        getHistoryMessage(this.mConversationType, this.mTargetId, 10, this.indexMessageTime > 0 ? AutoRefreshListView.Mode.END : AutoRefreshListView.Mode.START, this.indexMessageTime > 0 ? 1 : 3, -1);
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    public boolean isLocationSharing() {
        return (getContext() == null || !getContext().getResources().getBoolean(R.bool.rc_location_2D)) ? LocationManager.getInstance().isSharing() : LocationManager2D.getInstance().isSharing();
    }

    protected boolean isSendReferenceMsg(String str) {
        ReferenceMessage referenceMessage = this.referenceMessage;
        if (referenceMessage == null) {
            return false;
        }
        ReferenceMessage referenceMessageBuildSendText = referenceMessage.buildSendText(str);
        MentionedInfo mentionedInfoOnSendButtonClick = RongMentionManager.getInstance().onSendButtonClick();
        if (mentionedInfoOnSendButtonClick != null) {
            referenceMessageBuildSendText.setMentionedInfo(mentionedInfoOnSendButtonClick);
        }
        RongIM.getInstance().sendMessage(Message.obtain(getTargetId(), getConversationType(), referenceMessageBuildSendText), null, null, null);
        hideReferenceView();
        this.mRongExtension.collapseExtension();
        return true;
    }

    protected void messageSelectedCountDidExceed() {
        Toast.makeText(getActivity(), R.string.rc_exceeded_max_limit_100, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 104) {
            forwardMessage(intent);
        } else if (i != 102) {
            this.mRongExtension.onActivityPluginResult(i, i2, intent);
        } else if (getActivity() != null) {
            getActivity().finish();
        }
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        hideReferenceView();
        RongExtension rongExtension = this.mRongExtension;
        if (rongExtension != null && rongExtension.isExtensionExpanded()) {
            this.mRongExtension.collapseExtension();
            return true;
        }
        if (this.mCustomServiceConfig != null && Conversation.ConversationType.CUSTOMER_SERVICE.equals(this.mConversationType) && CustomServiceConfig.CSQuitSuspendType.NONE.equals(this.mCustomServiceConfig.quitSuspendType)) {
            return onCustomServiceEvaluation(false, "", this.robotType, this.csEvaluate);
        }
        RongExtension rongExtension2 = this.mRongExtension;
        if (rongExtension2 == null || !rongExtension2.isMoreActionShown()) {
            return false;
        }
        resetMoreActionState();
        return true;
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSavedInstanceState = bundle;
        if (bundle != null) {
            this.mNewMessageCount = bundle.getInt(NEW_MESSAGE_COUNT);
            this.mListViewState = bundle.getParcelable(LIST_STATE);
        }
        RLog.i(TAG, "onCreate");
        InternalModuleManager.getInstance().onLoaded();
        try {
            if (getActivity() != null) {
                this.mEnableMention = getActivity().getResources().getBoolean(R.bool.rc_enable_mentioned_message);
            }
        } catch (Resources.NotFoundException unused) {
            RLog.e(TAG, "rc_enable_mentioned_message not found in rc_config.xml");
        }
        try {
            this.mReadRec = getResources().getBoolean(R.bool.rc_read_receipt);
            this.mSyncReadStatus = getResources().getBoolean(R.bool.rc_enable_sync_read_status);
        } catch (Resources.NotFoundException e2) {
            RLog.e(TAG, "onCreate rc_read_receipt not found in rc_config.xml", e2);
        }
        this.mKitReceiver = new RongKitReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        try {
            if (getActivity() != null) {
                getActivity().registerReceiver(this.mKitReceiver, intentFilter);
            }
        } catch (Exception e3) {
            RLog.e(TAG, "onCreate", e3);
        }
        this.mAddMentionedMemberListener = new IAddMentionedMemberListener() { // from class: io.rong.imkit.fragment.ConversationFragment.2
            @Override // io.rong.imkit.mention.IAddMentionedMemberListener
            public boolean onAddMentionedMember(UserInfo userInfo, int i) {
                RLog.i("onAddMentionedMember", "from=" + i);
                if (i != 0 || ConversationFragment.this.mRongExtension == null) {
                    return false;
                }
                ConversationFragment.this.mRongExtension.showSoftInput();
                return false;
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.contentView = layoutInflater.inflate(R.layout.rc_fr_conversation, viewGroup, false);
        this.mRongExtension = (RongExtension) this.contentView.findViewById(R.id.rc_extension);
        this.mRongExtension.setFragment(this);
        this.mVoiceInputToggle = this.mRongExtension.findViewById(R.id.rc_audio_input_toggle);
        this.mVoiceToggle = (ImageView) this.mRongExtension.findViewById(R.id.rc_voice_toggle);
        this.referenceView = (ReferenceView) this.contentView.findViewById(R.id.rc_reference);
        this.referenceView.setCancelListener(new ReferenceView.CancelListener() { // from class: io.rong.imkit.fragment.ConversationFragment.3
            @Override // io.rong.imkit.reference.ReferenceView.CancelListener
            public void cancelClick() {
                ConversationFragment.this.hideReferenceView();
            }
        });
        this.mOffsetLimit = getActivity().getResources().getDisplayMetrics().density * 70.0f;
        this.mMsgListView = findViewById(this.contentView, R.id.rc_layout_msg_list);
        this.mList = (AutoRefreshListView) findViewById(this.mMsgListView, R.id.rc_list);
        this.mList.requestDisallowInterceptTouchEvent(true);
        this.mList.setMode(AutoRefreshListView.Mode.BOTH);
        this.mListAdapter = onResolveAdapter(getActivity());
        this.mListAdapter.setMaxMessageSelectedCount(getResources().getInteger(R.integer.rc_max_message_selected_count));
        this.mList.setAdapter((ListAdapter) this.mListAdapter);
        this.mList.setOnRefreshListener(new AutoRefreshListView.OnRefreshListener() { // from class: io.rong.imkit.fragment.ConversationFragment.4
            @Override // io.rong.imkit.widget.AutoRefreshListView.OnRefreshListener
            public void onRefreshFromEnd() {
                if (!ConversationFragment.this.mHasMoreLocalMessagesDown || ConversationFragment.this.indexMessageTime <= 0) {
                    ConversationFragment.this.mList.onRefreshComplete(0, 0, false);
                } else {
                    ConversationFragment conversationFragment = ConversationFragment.this;
                    conversationFragment.getHistoryMessage(conversationFragment.mConversationType, ConversationFragment.this.mTargetId, 10, AutoRefreshListView.Mode.END, 1, -1);
                }
            }

            @Override // io.rong.imkit.widget.AutoRefreshListView.OnRefreshListener
            public void onRefreshFromStart() {
                if (ConversationFragment.this.mHasMoreLocalMessagesUp) {
                    ConversationFragment conversationFragment = ConversationFragment.this;
                    conversationFragment.getHistoryMessage(conversationFragment.mConversationType, ConversationFragment.this.mTargetId, 10, AutoRefreshListView.Mode.START, 1, -1);
                } else {
                    ConversationFragment conversationFragment2 = ConversationFragment.this;
                    conversationFragment2.getRemoteHistoryMessages(conversationFragment2.mConversationType, ConversationFragment.this.mTargetId, 10);
                }
            }
        });
        this.mList.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.fragment.ConversationFragment.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 2 || (ConversationFragment.this.mList.getCount() - ConversationFragment.this.mList.getHeaderViewsCount()) - ConversationFragment.this.mList.getFooterViewsCount() != 0) {
                    if (motionEvent.getAction() != 0 || ConversationFragment.this.mRongExtension == null) {
                        return false;
                    }
                    ConversationFragment.this.mRongExtension.collapseExtension();
                    return false;
                }
                if (ConversationFragment.this.mHasMoreLocalMessagesUp) {
                    ConversationFragment conversationFragment = ConversationFragment.this;
                    conversationFragment.getHistoryMessage(conversationFragment.mConversationType, ConversationFragment.this.mTargetId, 10, AutoRefreshListView.Mode.START, 1, -1);
                    return true;
                }
                if (ConversationFragment.this.mList.getRefreshState() == AutoRefreshListView.State.REFRESHING) {
                    return true;
                }
                ConversationFragment conversationFragment2 = ConversationFragment.this;
                conversationFragment2.getRemoteHistoryMessages(conversationFragment2.mConversationType, ConversationFragment.this.mTargetId, 10);
                return true;
            }
        });
        RongContext rongContext = RongContext.getInstance();
        if (rongContext != null && rongContext.getNewMessageState()) {
            this.mNewMessageTextView = (TextView) findViewById(this.contentView, R.id.rc_new_message_number);
            this.mNewMessageBtn = (ImageButton) findViewById(this.contentView, R.id.rc_new_message_count);
            this.mNewMessageBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ConversationFragment.this.mList.setSelection(ConversationFragment.this.mList.getCount());
                    ConversationFragment.this.mNewMessageBtn.setVisibility(8);
                    ConversationFragment.this.mNewMessageTextView.setVisibility(8);
                    ConversationFragment.this.mNewMessageCount = 0;
                    ConversationFragment.this.mIsInsertNewMsg = true;
                    ConversationFragment.this.mListAdapter.clear();
                    AutoRefreshListView.Mode mode = AutoRefreshListView.Mode.START;
                    ConversationFragment conversationFragment = ConversationFragment.this;
                    conversationFragment.getHistoryMessage(conversationFragment.mConversationType, ConversationFragment.this.mTargetId, 10, mode, 3, -1);
                }
            });
        }
        if (rongContext != null && rongContext.getUnreadMessageState()) {
            this.mUnreadMsgLayout = (LinearLayout) findViewById(this.mMsgListView, R.id.rc_unread_message_layout);
            this.mUnreadMsgCountTv = (TextView) findViewById(this.mMsgListView, R.id.rc_unread_message_count);
        }
        this.mList.addOnScrollListener(this);
        this.mListAdapter.setOnItemHandlerListener(new MessageListAdapter.OnItemHandlerListener() { // from class: io.rong.imkit.fragment.ConversationFragment.7
            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.OnItemHandlerListener
            public void onMessageClick(int i, Message message, View view) {
                if (ConversationFragment.this.mRongExtension != null) {
                    ConversationFragment.this.mRongExtension.collapseExtension();
                }
            }

            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.OnItemHandlerListener
            public void onReadReceiptStateClick(Message message) {
                ConversationFragment.this.onReadReceiptStateClick(message);
            }

            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.OnItemHandlerListener
            public boolean onWarningViewClick(int i, final Message message, View view) {
                RongIMClient.getInstance().deleteMessages(new int[]{message.getMessageId()}, new RongIMClient.ResultCallback<Boolean>() { // from class: io.rong.imkit.fragment.ConversationFragment.7.1
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(Boolean bool) {
                        if (!bool.booleanValue() || message == null) {
                            return;
                        }
                        ResendManager.getInstance().removeResendMessage(message.getMessageId());
                        int iFindPosition = ConversationFragment.this.mListAdapter.findPosition(message.getMessageId());
                        if (iFindPosition >= 0) {
                            ConversationFragment.this.mListAdapter.remove(iFindPosition);
                        }
                        message.setMessageId(0);
                        ConversationFragment.this.onResendItemClick(message);
                    }
                });
                return true;
            }
        });
        showNewMessage();
        this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        this.mList.getViewTreeObserver().addOnGlobalLayoutListener(this.listViewLayoutListener);
        return this.contentView;
    }

    public boolean onCustomServiceEvaluation(boolean z, String str, boolean z2, boolean z3) {
        if (getActivity() == null) {
            return false;
        }
        if (isActivityExist()) {
            if (z3) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int integer = 60;
                try {
                    integer = getActivity().getResources().getInteger(R.integer.rc_custom_service_evaluation_interval);
                } catch (Resources.NotFoundException e2) {
                    RLog.e(TAG, "onCustomServiceEvaluation", e2);
                }
                if (jCurrentTimeMillis - this.csEnterTime < integer * 1000 && !z) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                    if (inputMethodManager != null && inputMethodManager.isActive() && getActivity().getCurrentFocus() != null && getActivity().getCurrentFocus().getWindowToken() != null) {
                        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
                    }
                    AbstractC0336n childFragmentManager = getChildFragmentManager();
                    if (childFragmentManager.c() > 0) {
                        childFragmentManager.f();
                    } else {
                        getActivity().finish();
                    }
                    return false;
                }
                this.mEvaluateDialg = new CSEvaluateDialog(getActivity(), this.mTargetId);
                this.mEvaluateDialg.setClickListener(this);
                this.mEvaluateDialg.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: io.rong.imkit.fragment.ConversationFragment.30
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        if (ConversationFragment.this.mEvaluateDialg != null) {
                            ConversationFragment.this.mEvaluateDialg = null;
                        }
                    }
                });
                CustomServiceConfig customServiceConfig = this.mCustomServiceConfig;
                if (customServiceConfig != null && customServiceConfig.evaluateType.equals(CustomServiceConfig.CSEvaType.EVA_UNIFIED)) {
                    this.mEvaluateDialg.showStarMessage(this.mCustomServiceConfig.isReportResolveStatus);
                } else if (z2) {
                    this.mEvaluateDialg.showRobot(true);
                } else {
                    onShowStarAndTabletDialog(str);
                }
            } else {
                AbstractC0336n childFragmentManager2 = getChildFragmentManager();
                if (childFragmentManager2.c() > 0) {
                    childFragmentManager2.f();
                } else {
                    getActivity().finish();
                }
            }
        }
        return true;
    }

    public void onCustomServiceWarning(String str, final boolean z, final boolean z2) {
        if (!isActivityExist()) {
            RLog.w(TAG, "Activity has finished");
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        if (window == null) {
            return;
        }
        window.setContentView(R.layout.rc_cs_alert_warning);
        ((TextView) window.findViewById(R.id.rc_cs_msg)).setText(str);
        window.findViewById(R.id.rc_btn_ok).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                alertDialogCreate.dismiss();
                boolean z3 = z;
                if (z3) {
                    ConversationFragment.this.onCustomServiceEvaluation(false, "", z2, z3);
                    return;
                }
                AbstractC0336n childFragmentManager = ConversationFragment.this.getChildFragmentManager();
                if (childFragmentManager.c() > 0) {
                    childFragmentManager.f();
                } else if (ConversationFragment.this.getActivity() != null) {
                    ConversationFragment.this.getActivity().finish();
                }
            }
        });
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mAddMentionedMemberListener = null;
        RongMentionManager.getInstance().setAddMentionedMemberListener(null);
        RongMessageItemLongClickActionManager.getInstance().removeMessageItemLongClickAction(this.clickAction);
        RongMessageItemLongClickActionManager.getInstance().removeMessageItemLongClickAction(this.clickActionReference);
        if (!this.finishing) {
            destroy();
        }
        AutoRefreshListView autoRefreshListView = this.mList;
        if (autoRefreshListView != null) {
            autoRefreshListView.getViewTreeObserver().removeOnGlobalLayoutListener(this.listViewLayoutListener);
        }
        View view = this.contentView;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        }
        RecallEditManager.getInstance().cancelCountDownInConversation(this.mConversationType.getName() + this.mTargetId);
        super.onDestroy();
    }

    public void onEditTextClick(EditText editText) {
    }

    public void onEmoticonToggleClick(View view, ViewGroup viewGroup) {
    }

    @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
    public final void onEvaluateCanceled() {
        CSEvaluateDialog cSEvaluateDialog = this.mEvaluateDialg;
        if (cSEvaluateDialog != null) {
            cSEvaluateDialog.destroy();
            this.mEvaluateDialg = null;
        }
        CustomServiceConfig customServiceConfig = this.mCustomServiceConfig;
        if (customServiceConfig == null || !customServiceConfig.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.NONE) || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    @Override // io.rong.imkit.widget.CSEvaluateDialog.EvaluateClickListener
    public final void onEvaluateSubmit() {
        CSEvaluateDialog cSEvaluateDialog = this.mEvaluateDialg;
        if (cSEvaluateDialog != null) {
            cSEvaluateDialog.destroy();
            this.mEvaluateDialg = null;
        }
        CustomServiceConfig customServiceConfig = this.mCustomServiceConfig;
        if (customServiceConfig == null || !customServiceConfig.quitSuspendType.equals(CustomServiceConfig.CSQuitSuspendType.NONE) || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    public void onEventBackgroundThread(final Event.PlayAudioEvent playAudioEvent) {
        getHandler().post(new Runnable() { // from class: io.rong.imkit.fragment.ConversationFragment.35
            @Override // java.lang.Runnable
            public void run() {
                ConversationFragment.this.handleAudioPlayEvent(playAudioEvent);
            }
        });
    }

    public void onEventMainThread(Event.ReadReceiptRequestEvent readReceiptRequestEvent) {
        RLog.d(TAG, "ReadReceiptRequestEvent");
        if ((this.mConversationType.equals(Conversation.ConversationType.GROUP) || this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(readReceiptRequestEvent.getConversationType()) && readReceiptRequestEvent.getConversationType().equals(this.mConversationType) && readReceiptRequestEvent.getTargetId().equals(this.mTargetId)) {
            for (int i = 0; i < this.mListAdapter.getCount(); i++) {
                if (this.mListAdapter.getItem(i).getUId().equals(readReceiptRequestEvent.getMessageUId())) {
                    final UIMessage item = this.mListAdapter.getItem(i);
                    ReadReceiptInfo readReceiptInfo = item.getReadReceiptInfo();
                    if (readReceiptInfo == null) {
                        readReceiptInfo = new ReadReceiptInfo();
                        item.setReadReceiptInfo(readReceiptInfo);
                    }
                    if (readReceiptInfo.isReadReceiptMessage() && readReceiptInfo.hasRespond()) {
                        return;
                    }
                    readReceiptInfo.setIsReadReceiptMessage(true);
                    readReceiptInfo.setHasRespond(false);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.mListAdapter.getItem(i).getMessage());
                    RongIMClient.getInstance().sendReadReceiptResponse(readReceiptRequestEvent.getConversationType(), readReceiptRequestEvent.getTargetId(), arrayList, new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.32
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            RLog.e(ConversationFragment.TAG, "sendReadReceiptResponse failed, errorCode = " + errorCode);
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            item.getReadReceiptInfo().setHasRespond(true);
                        }
                    });
                    return;
                }
            }
        }
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onExtensionCollapsed() {
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onExtensionExpanded(int i) {
        if (this.mRongExtension.getTriggerMode() != 2) {
            return;
        }
        if (this.indexMessageTime > 0) {
            this.mListAdapter.clear();
            if (this.firstUnreadMessage == null) {
                this.indexMessageTime = 0L;
            }
            this.conversationUnreadCount = this.mUnReadCount;
            getHistoryMessage(this.mConversationType, this.mTargetId, 10, AutoRefreshListView.Mode.START, 1, -1);
            return;
        }
        AutoRefreshListView autoRefreshListView = this.mList;
        autoRefreshListView.setSelection(autoRefreshListView.getCount());
        if (this.mNewMessageCount > 0) {
            this.mNewMessageCount = 0;
            ImageButton imageButton = this.mNewMessageBtn;
            if (imageButton != null) {
                imageButton.setVisibility(8);
                this.mNewMessageTextView.setVisibility(8);
            }
        }
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onImageResult(LinkedHashMap<String, Integer> linkedHashMap, boolean z) {
        boolean zIsFireStatus = this.mRongExtension.isFireStatus();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            int iIntValue = entry.getValue().intValue();
            String key = entry.getKey();
            if (iIntValue == 1) {
                SendImageManager.getInstance().sendImages(this.mConversationType, this.mTargetId, Collections.singletonList(Uri.parse(key)), z, zIsFireStatus, 30L);
                if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
                    RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:ImgMsg");
                }
            } else if (iIntValue == 3) {
                SendMediaManager.getInstance().sendMedia(this.mConversationType, this.mTargetId, Collections.singletonList(Uri.parse(key)), z, zIsFireStatus, 10L);
                if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
                    RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:SightMsg");
                }
            }
        }
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        EditText editText = (EditText) view;
        RongMentionManager.getInstance().onDeleteClick(this.mConversationType, this.mTargetId, editText, editText.getSelectionStart());
        return false;
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onLocationResult(double d2, double d3, String str, Uri uri) {
        RongIM.getInstance().sendLocationMessage(Message.obtain(this.mTargetId, this.mConversationType, LocationMessage.obtain(d2, d3, str, uri)), null, null, null);
        if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
            RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:LBSMsg");
        }
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onMenuClick(int i, int i2) {
        PublicServiceProfile publicServiceProfile;
        IPublicServiceMenuClickListener publicServiceMenuClickListener;
        if (getActivity() == null || (publicServiceProfile = this.mPublicServiceProfile) == null) {
            return;
        }
        PublicServiceMenuItem publicServiceMenuItem = publicServiceProfile.getMenu().getMenuItems().get(i);
        if (i2 >= 0) {
            publicServiceMenuItem = publicServiceMenuItem.getSubMenuItems().get(i2);
        }
        if (publicServiceMenuItem.getType().equals(PublicServiceMenu.PublicServiceMenuItemType.View) && ((publicServiceMenuClickListener = RongContext.getInstance().getPublicServiceMenuClickListener()) == null || !publicServiceMenuClickListener.onClick(this.mConversationType, this.mTargetId, publicServiceMenuItem))) {
            Intent intent = new Intent(RongKitIntent.RONG_INTENT_ACTION_WEBVIEW);
            intent.setPackage(getActivity().getPackageName());
            intent.addFlags(268435456);
            intent.putExtra("url", publicServiceMenuItem.getUrl());
            getActivity().startActivity(intent);
        }
        RongIMClient.getInstance().sendMessage(this.mConversationType, this.mTargetId, PublicServiceCommandMessage.obtain(publicServiceMenuItem), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imkit.fragment.ConversationFragment.31
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(Message message) {
            }
        });
    }

    @Override // io.rong.imkit.fragment.UriFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (getActivity() != null) {
            this.finishing = getActivity().isFinishing();
        }
        if (this.finishing) {
            destroy();
        } else {
            stopAudioThingsDependsOnVoipMode();
        }
        if (this.mList != null) {
            this.isShowTipMessageCountInBackground = !r0.isLastItemVisible(1);
        }
        super.onPause();
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onPhrasesClicked(String str, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            RLog.e(TAG, "text content must not be null");
            return;
        }
        RongIM.getInstance().sendMessage(Message.obtain(this.mTargetId, this.mConversationType, TextMessage.obtain(str)), null, null, null);
        this.mRongExtension.collapseExtension();
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onPluginClicked(IPluginModule iPluginModule, int i) {
    }

    public void onPluginToggleClick(View view, ViewGroup viewGroup) {
        hideReferenceView();
    }

    public void onReadReceiptStateClick(Message message) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                this.mRongExtension.showRequestPermissionFailedAlter(getResources().getString(R.string.rc_permission_grant_needed));
                return;
            } else {
                HQVoiceMsgDownloadManager.getInstance().resumeDownloadService();
                return;
            }
        }
        if (i != 100 || iArr.length <= 0 || iArr[0] == 0) {
            this.mRongExtension.onRequestPermissionResult(i, strArr, iArr);
        } else {
            this.mRongExtension.showRequestPermissionFailedAlter(getResources().getString(R.string.rc_permission_grant_needed));
        }
    }

    public void onResendItemClick(Message message) {
        if (message.getContent() instanceof ImageMessage) {
            ImageMessage imageMessage = (ImageMessage) message.getContent();
            if (imageMessage.getRemoteUri() == null || imageMessage.getRemoteUri().toString().startsWith(LibStorageUtils.FILE)) {
                RongIM.getInstance().sendImageMessage(message, (String) null, (String) null, (RongIMClient.SendImageMessageCallback) null);
                return;
            } else {
                RongIM.getInstance().sendMessage(message, null, null, null);
                return;
            }
        }
        if (message.getContent() instanceof LocationMessage) {
            RongIM.getInstance().sendLocationMessage(message, null, null, null);
            return;
        }
        if (message.getContent() instanceof ReferenceMessage) {
            RongIM.getInstance().sendMessage(message, null, null, null);
            return;
        }
        if (!(message.getContent() instanceof MediaMessageContent)) {
            RongIM.getInstance().sendMessage(message, null, null, null);
        } else if (((MediaMessageContent) message.getContent()).getMediaUrl() != null) {
            RongIM.getInstance().sendMessage(message, null, null, null);
        } else {
            RongIM.getInstance().sendMediaMessage(message, (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
        }
    }

    public MessageListAdapter onResolveAdapter(Context context) {
        return new MessageListAdapter(context);
    }

    @Override // io.rong.imkit.fragment.UriFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MessageListAdapter messageListAdapter;
        if (!getActivity().isFinishing() && this.mRongExtension != null) {
            RLog.d(TAG, "onResume when back from other activity.");
            this.mRongExtension.resetEditTextLayoutDrawnStatus();
            long j = SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0).getLong(getSavedReadReceiptTimeName(), 0L);
            if (j > 0) {
                RongIMClient.getInstance().sendReadReceiptMessage(this.mConversationType, this.mTargetId, j, null);
            }
        }
        if (getResources().getBoolean(R.bool.rc_wipe_out_notification_message)) {
            RongPushClient.clearAllNotifications(getActivity());
        }
        if (this.isNeedRefresh && (messageListAdapter = this.mListAdapter) != null) {
            this.isNeedRefresh = false;
            messageListAdapter.notifyDataSetChanged();
        }
        super.onResume();
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(UN_READ_COUNT, this.mUnReadCount);
        bundle.putInt(NEW_MESSAGE_COUNT, this.mNewMessageCount);
        bundle.putParcelable(LIST_STATE, this.mList.onSaveInstanceState());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int childCount;
        AutoRefreshListView autoRefreshListView = this.mList;
        if (autoRefreshListView == null || autoRefreshListView.getHeight() != this.lastListHeight || (childCount = this.mList.getChildCount()) == 0) {
            return;
        }
        View childAt = this.mList.getChildAt(childCount - 1);
        this.lastItemBottomOffset = childAt.getBottom() - this.lastListHeight;
        this.lastItemHeight = childAt.getHeight();
        this.lastItemPosition = (i + i2) - 1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            RongExtension rongExtension = this.mRongExtension;
            if (rongExtension != null) {
                rongExtension.collapseExtension();
                return;
            }
            return;
        }
        if (i == 0) {
            int lastVisiblePosition = this.mList.getLastVisiblePosition();
            if (this.mNewMessageBtn == null || lastVisiblePosition != this.mList.getCount() - 1) {
                return;
            }
            this.mNewMessageCount = 0;
            this.mNewMessageBtn.setVisibility(8);
            this.mNewMessageTextView.setVisibility(8);
        }
    }

    public void onSelectCustomerServiceGroup(final List<CSGroupItem> list) {
        if (!isActivityExist()) {
            RLog.w(TAG, "onSelectCustomerServiceGroup Activity has finished");
            return;
        }
        if (getActivity() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOnline()) {
                arrayList.add(list.get(i).getName());
            }
        }
        if (arrayList.size() == 0) {
            RongIMClient.getInstance().selectCustomServiceGroup(this.mTargetId, null);
            return;
        }
        final SingleChoiceDialog singleChoiceDialog = new SingleChoiceDialog(getActivity(), arrayList);
        singleChoiceDialog.setTitle(getActivity().getResources().getString(R.string.rc_cs_select_group));
        singleChoiceDialog.setOnOKButtonListener(new DialogInterface.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.22
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                RongIMClient.getInstance().selectCustomServiceGroup(ConversationFragment.this.mTargetId, ((CSGroupItem) list.get(singleChoiceDialog.getSelectItem())).getId());
            }
        });
        singleChoiceDialog.setOnCancelButtonListener(new DialogInterface.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.23
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                RongIMClient.getInstance().selectCustomServiceGroup(ConversationFragment.this.mTargetId, null);
            }
        });
        singleChoiceDialog.show();
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onSendToggleClick(View view, String str) {
        long jRound;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            RLog.e(TAG, "text content must not be null");
            return;
        }
        if (isSendReferenceMsg(str)) {
            return;
        }
        TextMessage textMessageObtain = TextMessage.obtain(str);
        if (this.mRongExtension.isFireStatus()) {
            int length = str.length();
            if (length <= 20) {
                jRound = 10;
            } else {
                double d2 = length - 20;
                Double.isNaN(d2);
                jRound = Math.round((d2 * 0.5d) + 10.0d);
            }
            textMessageObtain.setDestructTime(jRound);
        }
        MentionedInfo mentionedInfoOnSendButtonClick = RongMentionManager.getInstance().onSendButtonClick();
        if (mentionedInfoOnSendButtonClick != null) {
            textMessageObtain.setMentionedInfo(mentionedInfoOnSendButtonClick);
        }
        RongIM.getInstance().sendMessage(Message.obtain(this.mTargetId, this.mConversationType, textMessageObtain), this.mRongExtension.isFireStatus() ? getContext().getString(R.string.rc_message_content_burn) : null, null, null);
    }

    public void onShowAnnounceView(String str, String str2) {
    }

    public void onShowStarAndTabletDialog(String str) {
        this.mEvaluateDialg.showStar(str);
    }

    public void onStartCustomService(String str) {
        this.csEnterTime = System.currentTimeMillis();
        this.mRongExtension.setExtensionBarMode(CustomServiceMode.CUSTOM_SERVICE_MODE_NO_SERVICE);
        RongIMClient.getInstance().startCustomService(str, this.customServiceListener, this.mCustomUserInfo);
    }

    public void onStopCustomService(String str) {
        RongIMClient.getInstance().stopCustomService(str);
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onSwitchToggleClick(View view, ViewGroup viewGroup) {
        if (this.robotType) {
            RongIMClient.getInstance().switchToHumanMode(this.mTargetId);
        }
        if (this.mVoiceInputToggle.getVisibility() != 0) {
            hideReferenceView();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i3 == 0) {
            i += i2;
            i3 = -i2;
        }
        int i4 = i;
        int i5 = i3;
        if (this.mConversationType.equals(Conversation.ConversationType.GROUP) || this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) {
            RongMentionManager.getInstance().onTextEdit(this.mConversationType, this.mTargetId, i4, i5, charSequence.toString());
        } else {
            if (!this.mConversationType.equals(Conversation.ConversationType.PRIVATE) || i5 == 0) {
                return;
            }
            RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:TxtMsg");
        }
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        addReferenceLongClickAction();
        if (showMoreClickItem()) {
            this.clickAction = new MessageItemLongClickAction.Builder().title(getResources().getString(R.string.rc_dialog_item_message_more)).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.10
                @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
                public boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                    ConversationFragment.this.hideReferenceView();
                    ConversationFragment.this.setMoreActionState(uIMessage);
                    return true;
                }
            }).build();
            RongMessageItemLongClickActionManager.getInstance().addMessageItemLongClickAction(this.clickAction);
        }
    }

    @Override // io.rong.imkit.IExtensionClickListener
    public void onVoiceInputToggleTouch(View view, MotionEvent motionEvent) {
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        if (getActivity() == null) {
            return;
        }
        if (!PermissionCheckUtil.checkPermissions(getActivity(), strArr) && motionEvent.getAction() == 0) {
            PermissionCheckUtil.requestPermissions(this, strArr, 100);
            return;
        }
        if (motionEvent.getAction() == 0) {
            if (AudioPlayManager.getInstance().isPlaying()) {
                AudioPlayManager.getInstance().stopPlay();
            }
            if (IMLibExtensionModuleManager.getInstance().onRequestHardwareResource(HardwareResource.ResourceType.VIDEO) || IMLibExtensionModuleManager.getInstance().onRequestHardwareResource(HardwareResource.ResourceType.AUDIO)) {
                Toast.makeText(getActivity(), getActivity().getString(R.string.rc_voip_occupying), 0).show();
                return;
            }
            AudioRecordManager.getInstance().startRecord(view.getRootView(), this.mConversationType, this.mTargetId, this.mRongExtension.isFireStatus(), this.mRongExtension.isFireStatus() ? 10L : 0L);
            this.mLastTouchY = motionEvent.getY();
            this.mUpDirection = false;
            ((Button) view).setText(R.string.rc_audio_input_hover);
        } else if (motionEvent.getAction() == 2) {
            if (this.mLastTouchY - motionEvent.getY() > this.mOffsetLimit && !this.mUpDirection) {
                AudioRecordManager.getInstance().willCancelRecord();
                this.mUpDirection = true;
                ((Button) view).setText(R.string.rc_audio_input);
            } else if (motionEvent.getY() - this.mLastTouchY > (-this.mOffsetLimit) && this.mUpDirection) {
                AudioRecordManager.getInstance().continueRecord();
                this.mUpDirection = false;
                ((Button) view).setText(R.string.rc_audio_input_hover);
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            AudioRecordManager.getInstance().stopRecord();
            ((Button) view).setText(R.string.rc_audio_input);
        }
        if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
            RongIMClient.getInstance().sendTypingStatus(this.mConversationType, this.mTargetId, "RC:VcMsg");
        }
    }

    public void onWarningDialog(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        Window window = alertDialogCreate.getWindow();
        if (window == null) {
            return;
        }
        window.setContentView(R.layout.rc_cs_alert_warning);
        ((TextView) window.findViewById(R.id.rc_cs_msg)).setText(str);
        window.findViewById(R.id.rc_btn_ok).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.ConversationFragment.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                alertDialogCreate.dismiss();
                AbstractC0336n childFragmentManager = ConversationFragment.this.getChildFragmentManager();
                if (childFragmentManager.c() > 0) {
                    childFragmentManager.f();
                } else if (ConversationFragment.this.getActivity() != null) {
                    ConversationFragment.this.getActivity().finish();
                }
            }
        });
    }

    public void resetMoreActionState() {
        this.mRongExtension.hideMoreActionLayout();
        this.mListAdapter.setShowCheckbox(false);
        this.mListAdapter.notifyDataSetChanged();
        OnMoreActionStateListener onMoreActionStateListener = this.moreActionStateListener;
        if (onMoreActionStateListener != null) {
            onMoreActionStateListener.onHiddenMoreActionLayout();
        }
    }

    public void setMaxMessageSelectedCount(int i) {
        MessageListAdapter messageListAdapter = this.mListAdapter;
        if (messageListAdapter != null) {
            messageListAdapter.setMaxMessageSelectedCount(i);
        }
    }

    public void setMoreActionState(UIMessage uIMessage) {
        for (int i = 0; i < this.mListAdapter.getCount(); i++) {
            this.mListAdapter.getItem(i).setChecked(false);
        }
        this.mListAdapter.setMessageCheckedChanged(new MessageListAdapter.OnMessageCheckedChanged() { // from class: io.rong.imkit.fragment.ConversationFragment.13
            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.OnMessageCheckedChanged
            public void onCheckedEnable(boolean z) {
                if (ConversationFragment.this.mRongExtension != null) {
                    ConversationFragment.this.mRongExtension.setMoreActionEnable(z);
                }
            }
        });
        this.mListAdapter.setSelectedCountDidExceed(new MessageListAdapter.OnSelectedCountDidExceed() { // from class: io.rong.imkit.fragment.ConversationFragment.14
            @Override // io.rong.imkit.widget.adapter.MessageListAdapter.OnSelectedCountDidExceed
            public void onSelectedCountDidExceed() {
                ConversationFragment.this.messageSelectedCountDidExceed();
            }
        });
        this.mRongExtension.showMoreActionLayout(getMoreClickActions());
        this.mListAdapter.setShowCheckbox(true);
        uIMessage.setChecked(true);
        this.mListAdapter.notifyDataSetChanged();
        OnMoreActionStateListener onMoreActionStateListener = this.moreActionStateListener;
        if (onMoreActionStateListener != null) {
            onMoreActionStateListener.onShownMoreActionLayout();
        }
    }

    public void setMoreActionStateListener(OnMoreActionStateListener onMoreActionStateListener) {
        this.moreActionStateListener = onMoreActionStateListener;
    }

    public boolean shouldUpdateMessage(Message message, int i) {
        return true;
    }

    public boolean showAboveIsHistoryMessage() {
        return true;
    }

    public boolean showMoreClickItem() {
        return false;
    }

    public void showNotificationView(View view) {
        if (view != null && this.mNotificationContainer.findViewById(view.getId()) == null) {
            this.mNotificationContainer.addView(view);
            this.mNotificationContainer.setVisibility(0);
        }
    }

    public void showQuitLocationSharingDialog(final Activity activity) {
        PromptPopupDialog.newInstance(activity, getString(R.string.rc_ext_warning), getString(R.string.rc_real_time_exit_notification), getString(R.string.rc_action_bar_ok)).setPromptButtonClickedListener(new PromptPopupDialog.OnPromptButtonClickedListener() { // from class: io.rong.imkit.fragment.ConversationFragment.27
            @Override // io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener
            public void onPositiveButtonClicked() {
                activity.finish();
            }
        }).show();
    }

    protected void updateNewMessageCountIfNeed(Message message, boolean z) {
        if (this.mNewMessageBtn == null || getContext() == null) {
            return;
        }
        if (SystemUtils.isInBackground(getContext())) {
            if (!this.isShowTipMessageCountInBackground) {
                return;
            }
        } else if (this.mList.isLastItemVisible(1) && this.mIsInsertNewMsg) {
            return;
        }
        if (message == null || message.getMessageDirection() == Message.MessageDirection.SEND || message.getConversationType() == Conversation.ConversationType.CHATROOM || message.getConversationType() == Conversation.ConversationType.CUSTOMER_SERVICE || message.getConversationType() == Conversation.ConversationType.APP_PUBLIC_SERVICE || message.getConversationType() == Conversation.ConversationType.PUBLIC_SERVICE) {
            return;
        }
        if (z) {
            this.mNewMessageCount++;
        } else {
            this.mNewMessageCount--;
        }
        showNewMessage();
    }

    protected void updatePublicServiceMenu(PublicServiceProfile publicServiceProfile) {
        if (publicServiceProfile == null) {
            RLog.e(TAG, "updatePublicServiceMenu publicServiceProfile is null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        PublicServiceMenu menu = publicServiceProfile.getMenu();
        List<PublicServiceMenuItem> menuItems = menu != null ? menu.getMenuItems() : null;
        if (menuItems == null || this.mRongExtension == null) {
            return;
        }
        this.mPublicServiceProfile = publicServiceProfile;
        for (PublicServiceMenuItem publicServiceMenuItem : menuItems) {
            InputMenu inputMenu = new InputMenu();
            inputMenu.title = publicServiceMenuItem.getName();
            inputMenu.subMenuList = new ArrayList();
            Iterator<PublicServiceMenuItem> it = publicServiceMenuItem.getSubMenuItems().iterator();
            while (it.hasNext()) {
                inputMenu.subMenuList.add(it.next().getName());
            }
            arrayList.add(inputMenu);
        }
        this.mRongExtension.setInputMenu(arrayList, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRemoteHistoryMessages(Conversation.ConversationType conversationType, String str, int i) {
        this.mList.onRefreshStart(AutoRefreshListView.Mode.START);
        if (conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            i = getResources().getInteger(R.integer.rc_chatroom_first_pull_message_count);
            if (i == 0) {
                i = 10;
            } else if (i == -1) {
                this.mList.onRefreshComplete(0, 0, false);
                return;
            }
        }
        final int i2 = i;
        getRemoteHistoryMessages(conversationType, str, this.mListAdapter.getCount() == 0 ? 0L : this.mListAdapter.getItem(0).getSentTime(), i2, new IHistoryDataResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.41
            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onError() {
                ConversationFragment.this.mList.onRefreshComplete(0, i2, false);
            }

            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onResult(List<Message> list) {
                StringBuilder sb = new StringBuilder();
                sb.append("getRemoteHistoryMessages ");
                sb.append(list == null ? 0 : list.size());
                RLog.i(ConversationFragment.TAG, sb.toString());
                if (list == null || list.size() <= 0) {
                    ConversationFragment.this.mList.onRefreshComplete(0, i2, false);
                    return;
                }
                Message message = ConversationFragment.this.mListAdapter.getCount() == 0 ? list.get(0) : null;
                ArrayList arrayList = new ArrayList();
                for (Message message2 : list) {
                    HQVoiceMsgDownloadManager.getInstance().enqueue(ConversationFragment.this, new AutoDownloadEntry(message2, AutoDownloadEntry.DownloadPriority.HIGH));
                    if (message2.getMessageId() > 0) {
                        UIMessage uIMessageObtain = UIMessage.obtain(message2);
                        if (message2.getContent() instanceof CSPullLeaveMessage) {
                            uIMessageObtain.setCsConfig(ConversationFragment.this.mCustomServiceConfig);
                        }
                        if (message2.getContent() != null && message2.getContent().getUserInfo() != null) {
                            uIMessageObtain.setUserInfo(message2.getContent().getUserInfo());
                        }
                        arrayList.add(uIMessageObtain);
                    }
                }
                List<UIMessage> listFilterMessage = ConversationFragment.this.filterMessage(arrayList);
                if (listFilterMessage == null || listFilterMessage.size() <= 0) {
                    ConversationFragment.this.mList.onRefreshComplete(0, i2, false);
                    return;
                }
                for (UIMessage uIMessage : listFilterMessage) {
                    uIMessage.setSentStatus(Message.SentStatus.READ);
                    ConversationFragment.this.mListAdapter.add(uIMessage, 0);
                }
                ConversationFragment.this.mListAdapter.notifyDataSetChanged();
                ConversationFragment.this.mList.setSelection(list.size() + 1);
                ConversationFragment.this.sendReadReceiptResponseIfNeeded(list);
                ConversationFragment.this.mList.onRefreshComplete(list.size(), i2, false);
                if (message != null) {
                    RongContext.getInstance().getEventBus().post(message);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHistoryMessage(Conversation.ConversationType conversationType, String str, int i, AutoRefreshListView.Mode mode, final int i2, int i3) {
        int i4;
        int i5;
        int messageId;
        this.mList.onRefreshStart(mode);
        if (conversationType.equals(Conversation.ConversationType.CHATROOM)) {
            int integer = getResources().getInteger(R.integer.rc_chatroom_first_pull_message_count);
            if (integer == 0) {
                integer = 10;
            } else if (integer == -1) {
                this.mList.onRefreshComplete(0, 0, false);
                return;
            }
            i4 = integer;
        } else {
            i4 = i;
        }
        if (i3 >= 0) {
            i5 = i3;
        } else if (this.mListAdapter.getCount() == 0) {
            i5 = -1;
        } else {
            if (this.mListAdapter.getItem(0).getMessage().getContent() instanceof HistoryDividerMessage) {
                messageId = this.firstUnreadMessage.getMessageId();
            } else {
                messageId = this.mListAdapter.getItem(0).getMessageId();
            }
            i5 = messageId;
        }
        final LoadMessageDirection loadMessageDirection = mode == AutoRefreshListView.Mode.START ? LoadMessageDirection.UP : LoadMessageDirection.DOWN;
        final int i6 = i4;
        final int i7 = i5;
        getHistoryMessage(conversationType, str, i5, i4, loadMessageDirection, new IHistoryDataResultCallback<List<Message>>() { // from class: io.rong.imkit.fragment.ConversationFragment.38
            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onError() {
                AutoRefreshListView autoRefreshListView = ConversationFragment.this.mList;
                int i8 = i6;
                autoRefreshListView.onRefreshComplete(i8, i8, false);
            }

            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onResult(List<Message> list) {
                DestructionTag destructionTag;
                if (ConversationFragment.this.mConversation == null && list != null && list.size() > 0) {
                    RongIMClient.getInstance().sendReadReceiptMessage(ConversationFragment.this.mConversationType, ConversationFragment.this.mTargetId, System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime(), null);
                }
                int size = list == null ? 0 : list.size();
                RLog.i(ConversationFragment.TAG, "getHistoryMessage " + size);
                if (loadMessageDirection == LoadMessageDirection.DOWN) {
                    ConversationFragment.this.mList.onRefreshComplete(size > 1 ? size : 0, size, false);
                    ConversationFragment.this.mHasMoreLocalMessagesDown = size > 1;
                    ConversationFragment.this.mIsInsertNewMsg = size < 11;
                } else {
                    ConversationFragment.this.mList.onRefreshComplete(size, i6, false);
                    ConversationFragment.this.mHasMoreLocalMessagesUp = size == i6;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                int count = loadMessageDirection == LoadMessageDirection.DOWN ? ConversationFragment.this.mListAdapter.getCount() : 0;
                DestructionCmdMessage destructionCmdMessage = new DestructionCmdMessage();
                boolean z = false;
                for (Message message : list) {
                    HQVoiceMsgDownloadManager.getInstance().enqueue(ConversationFragment.this, new AutoDownloadEntry(message, AutoDownloadEntry.DownloadPriority.HIGH));
                    if (message.getMessageDirection() == Message.MessageDirection.RECEIVE && message.getContent().isDestruct() && !TextUtils.isEmpty(message.getUId()) && message.getReadTime() <= 0 && (destructionTag = (DestructionTag) message.getContent().getClass().getAnnotation(DestructionTag.class)) != null && destructionTag.destructionFlag() == 1) {
                        destructionCmdMessage.getBurnMessageUIds().add(message.getUId());
                        long jCurrentTimeMillis = System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime();
                        RongIMClient.getInstance().setMessageReadTime(message.getMessageId(), jCurrentTimeMillis, null);
                        message.setReadTime(jCurrentTimeMillis);
                    }
                    boolean z2 = false;
                    for (int i8 = 0; i8 < ConversationFragment.this.mListAdapter.getCount(); i8++) {
                        z2 = ConversationFragment.this.mListAdapter.getItem(i8).getMessageId() == message.getMessageId();
                        if (z2) {
                            break;
                        }
                    }
                    if (!z2) {
                        UIMessage uIMessageObtain = UIMessage.obtain(message);
                        if (message.getContent() != null && message.getContent().getUserInfo() != null) {
                            uIMessageObtain.setUserInfo(message.getContent().getUserInfo());
                        }
                        if (message.getContent() instanceof CSPullLeaveMessage) {
                            uIMessageObtain.setCsConfig(ConversationFragment.this.mCustomServiceConfig);
                        }
                        ConversationFragment.this.mListAdapter.add(uIMessageObtain, count);
                        z = true;
                    }
                }
                if (ConversationFragment.this.firstUnreadMessage != null) {
                    ConversationFragment.this.refreshUnreadUI();
                }
                ConversationFragment.this.refreshUI(list, z, i2, i7, loadMessageDirection);
                if (destructionCmdMessage.getBurnMessageUIds().size() > 0) {
                    MessageBufferPool.getInstance().putMessageInBuffer(Message.obtain(ConversationFragment.this.mTargetId, ConversationFragment.this.mConversationType, destructionCmdMessage));
                }
            }
        });
    }

    public void onEventMainThread(Event.ReadReceiptResponseEvent readReceiptResponseEvent) {
        RLog.d(TAG, "ReadReceiptResponseEvent");
        if ((this.mConversationType.equals(Conversation.ConversationType.GROUP) || this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) && RongContext.getInstance().isReadReceiptConversationType(readReceiptResponseEvent.getConversationType()) && readReceiptResponseEvent.getConversationType().equals(this.mConversationType) && readReceiptResponseEvent.getTargetId().equals(this.mTargetId)) {
            for (int i = 0; i < this.mListAdapter.getCount(); i++) {
                if (this.mListAdapter.getItem(i).getUId().equals(readReceiptResponseEvent.getMessageUId())) {
                    UIMessage item = this.mListAdapter.getItem(i);
                    ReadReceiptInfo readReceiptInfo = item.getReadReceiptInfo();
                    if (readReceiptInfo == null) {
                        readReceiptInfo = new ReadReceiptInfo();
                        readReceiptInfo.setIsReadReceiptMessage(true);
                        item.setReadReceiptInfo(readReceiptInfo);
                    }
                    readReceiptInfo.setRespondUserIdList(readReceiptResponseEvent.getResponseUserIdList());
                    int firstVisiblePosition = this.mList.getFirstVisiblePosition();
                    int lastVisiblePosition = this.mList.getLastVisiblePosition();
                    int positionInListView = getPositionInListView(i);
                    if (positionInListView < firstVisiblePosition || positionInListView > lastVisiblePosition) {
                        return;
                    }
                    this.mListAdapter.getView(i, getListViewChildAt(i), this.mList);
                    return;
                }
            }
        }
    }

    public void onEventMainThread(Event.MessageDeleteEvent messageDeleteEvent) {
        RLog.d(TAG, "MessageDeleteEvent");
        if (messageDeleteEvent.getMessageIds() != null) {
            Iterator<Integer> it = messageDeleteEvent.getMessageIds().iterator();
            while (it.hasNext()) {
                int iFindPosition = this.mListAdapter.findPosition(it.next().intValue());
                if (iFindPosition >= 0) {
                    UIMessage item = this.mListAdapter.getItem(iFindPosition);
                    if ((item.getContent() instanceof VoiceMessage) && AudioPlayManager.getInstance().isPlaying() && ((VoiceMessage) item.getContent()).getUri().equals(AudioPlayManager.getInstance().getPlayingUri())) {
                        AudioPlayManager.getInstance().stopPlay();
                    }
                    if ((item.getContent() instanceof HQVoiceMessage) && AudioPlayManager.getInstance().isPlaying() && ((HQVoiceMessage) item.getContent()).getLocalPath().equals(AudioPlayManager.getInstance().getPlayingUri())) {
                        AudioPlayManager.getInstance().stopPlay();
                    }
                    this.mListAdapter.remove(iFindPosition);
                }
            }
            this.mListAdapter.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(Event.PublicServiceFollowableEvent publicServiceFollowableEvent) {
        RLog.d(TAG, "PublicServiceFollowableEvent");
        if (publicServiceFollowableEvent == null || publicServiceFollowableEvent.isFollow() || getActivity() == null) {
            return;
        }
        getActivity().finish();
    }

    public void onEventMainThread(Event.MessagesClearEvent messagesClearEvent) {
        RLog.d(TAG, "MessagesClearEvent");
        if (messagesClearEvent.getTargetId().equals(this.mTargetId) && messagesClearEvent.getType().equals(this.mConversationType)) {
            this.mListAdapter.clear();
            this.mListAdapter.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(Event.MessageRecallEvent messageRecallEvent) {
        RLog.d(TAG, "MessageRecallEvent");
        if (messageRecallEvent.isRecallSuccess()) {
            RecallNotificationMessage recallNotificationMessage = messageRecallEvent.getRecallNotificationMessage();
            int iFindPosition = this.mListAdapter.findPosition(messageRecallEvent.getMessageId());
            if (iFindPosition != -1) {
                UIMessage item = this.mListAdapter.getItem(iFindPosition);
                if ((item.getMessage().getContent() instanceof VoiceMessage) || (item.getMessage().getContent() instanceof HQVoiceMessage)) {
                    AudioPlayManager.getInstance().stopPlay();
                }
                if (item.getMessage().getContent() instanceof FileMessage) {
                    RongIM.getInstance().cancelDownloadMediaMessage(item.getMessage(), null);
                }
                this.mListAdapter.getItem(iFindPosition).setContent(recallNotificationMessage);
                int firstVisiblePosition = this.mList.getFirstVisiblePosition();
                int lastVisiblePosition = this.mList.getLastVisiblePosition();
                int positionInListView = getPositionInListView(iFindPosition);
                if (positionInListView >= firstVisiblePosition && positionInListView <= lastVisiblePosition) {
                    this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
                }
            }
            if (this.referenceMessage == null) {
                return;
            }
            hideReferenceView();
            return;
        }
        Toast.makeText(getActivity(), R.string.rc_recall_failed, 0).show();
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        RLog.d(TAG, "RemoteMessageRecallEvent");
        int iFindPosition = this.mListAdapter.findPosition(remoteMessageRecallEvent.getMessageId());
        int firstVisiblePosition = this.mList.getFirstVisiblePosition();
        int lastVisiblePosition = this.mList.getLastVisiblePosition();
        if (iFindPosition >= 0) {
            updateNewMessageCountIfNeed(this.mListAdapter.getItem(iFindPosition).getMessage(), false);
            if (remoteMessageRecallEvent.getRecallNotificationMessage() == null) {
                this.mListAdapter.remove(iFindPosition);
                this.mListAdapter.notifyDataSetChanged();
                return;
            }
            UIMessage item = this.mListAdapter.getItem(iFindPosition);
            MessageContent content = item.getMessage().getContent();
            if (!(content instanceof VoiceMessage) && !(content instanceof HQVoiceMessage)) {
                if ((content instanceof FileMessage) || (content instanceof GIFMessage) || (content instanceof SightMessage)) {
                    RongIM.getInstance().cancelDownloadMediaMessage(item.getMessage(), null);
                }
            } else {
                AudioPlayManager.getInstance().stopPlay();
            }
            item.setContent(remoteMessageRecallEvent.getRecallNotificationMessage());
            int positionInListView = getPositionInListView(iFindPosition);
            if (positionInListView >= firstVisiblePosition && positionInListView <= lastVisiblePosition) {
                this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
            }
            if (this.referenceMessage == null) {
                return;
            }
            hideReferenceView();
        }
    }

    public void onEventMainThread(Message message) {
        CustomServiceConfig customServiceConfig;
        RLog.d(TAG, "Event message : " + message.getMessageId() + ", " + message.getObjectName() + ", " + message.getSentStatus());
        if (this.mTargetId.equals(message.getTargetId()) && this.mConversationType.equals(message.getConversationType()) && message.getMessageId() > 0) {
            int iFindPosition = this.mListAdapter.findPosition(message.getMessageId());
            if (iFindPosition >= 0) {
                if (message.getSentStatus().equals(Message.SentStatus.FAILED)) {
                    message.setSentTime(message.getSentTime() - RongIMClient.getInstance().getDeltaTime());
                }
                this.mListAdapter.getItem(iFindPosition).setMessage(message);
                this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
            } else {
                UIMessage uIMessageObtain = UIMessage.obtain(message);
                if (message.getContent() instanceof CSPullLeaveMessage) {
                    uIMessageObtain.setCsConfig(this.mCustomServiceConfig);
                }
                long sentTime = uIMessageObtain.getSentTime();
                if ((uIMessageObtain.getMessageDirection() == Message.MessageDirection.SEND && uIMessageObtain.getSentStatus() == Message.SentStatus.SENDING) || (uIMessageObtain.getContent() instanceof RealTimeLocationStartMessage)) {
                    sentTime = uIMessageObtain.getSentTime() - RongIMClient.getInstance().getDeltaTime();
                    uIMessageObtain.setSentTime(sentTime);
                }
                int positionBySendTime = this.mListAdapter.getPositionBySendTime(sentTime);
                if (this.mIsInsertNewMsg) {
                    this.mListAdapter.add(uIMessageObtain, positionBySendTime);
                    this.mListAdapter.notifyDataSetChanged();
                }
            }
            MessageTag messageTag = (MessageTag) message.getContent().getClass().getAnnotation(MessageTag.class);
            if (this.mNewMessageCount <= 0 && ((messageTag != null && messageTag.flag() == 3) || this.mList.getLastVisiblePosition() == (this.mList.getCount() - this.mList.getHeaderViewsCount()) - 1 || isSelfSendMessage(message))) {
                this.mList.setTranscriptMode(2);
                this.mList.post(new Runnable() { // from class: io.rong.imkit.fragment.ConversationFragment.33
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConversationFragment.this.getActivity() == null || ConversationFragment.this.mList == null) {
                            return;
                        }
                        ConversationFragment.this.mList.setSelection(ConversationFragment.this.mList.getCount());
                    }
                });
                this.mList.setTranscriptMode(0);
            }
            if (!this.mConversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE) || message.getMessageDirection() != Message.MessageDirection.SEND || this.robotType || (customServiceConfig = this.mCustomServiceConfig) == null || customServiceConfig.userTipTime <= 0 || TextUtils.isEmpty(customServiceConfig.userTipWord)) {
                return;
            }
            startTimer(0, this.mCustomServiceConfig.userTipTime * 60 * 1000);
        }
    }

    public void onEventMainThread(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        RLog.d(TAG, "ConnectionStatus, " + connectionStatus.toString());
        if (getActivity() == null || !isAdded()) {
            return;
        }
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(getContext(), KitCommonDefine.RONG_KIT_SP_CONFIG, 0);
        boolean z = sharedPreferences.getBoolean(getSavedReadReceiptStatusName(), false);
        long j = sharedPreferences.getLong(getSavedReadReceiptTimeName(), 0L);
        if (connectionStatus.equals(RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED) && z) {
            RongIMClient.getInstance().sendReadReceiptMessage(this.mConversationType, this.mTargetId, j, null);
            removeSendReadReceiptStatusToSp();
        }
    }

    public void onEventMainThread(Event.MessageSentStatusUpdateEvent messageSentStatusUpdateEvent) {
        Message message = messageSentStatusUpdateEvent.getMessage();
        if (message != null && !message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            RLog.d(TAG, "MessageSentStatusEvent event : " + messageSentStatusUpdateEvent.getMessage().getMessageId() + ", " + messageSentStatusUpdateEvent.getSentStatus());
            int iFindPosition = this.mListAdapter.findPosition((long) message.getMessageId());
            if (iFindPosition >= 0) {
                this.mListAdapter.getItem(iFindPosition).setSentStatus(messageSentStatusUpdateEvent.getSentStatus());
                this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
                return;
            }
            return;
        }
        RLog.e(TAG, "MessageSentStatusUpdateEvent message is null or direction is RECEIVE");
    }

    public void onEventMainThread(Event.FileMessageEvent fileMessageEvent) {
        int iFindPosition;
        Message message = fileMessageEvent.getMessage();
        RLog.d(TAG, "FileMessageEvent message : " + message.getMessageId() + ", " + message.getObjectName() + ", " + message.getSentStatus());
        if (this.mTargetId.equals(message.getTargetId()) && this.mConversationType.equals(message.getConversationType()) && message.getMessageId() > 0 && (message.getContent() instanceof MediaMessageContent) && (iFindPosition = this.mListAdapter.findPosition(message.getMessageId())) >= 0) {
            UIMessage item = this.mListAdapter.getItem(iFindPosition);
            item.setMessage(message);
            item.setProgress(fileMessageEvent.getProgress());
            if (message.getContent() instanceof FileMessage) {
                ((FileMessage) message.getContent()).progress = fileMessageEvent.getProgress();
            }
            this.mListAdapter.getItem(iFindPosition).setMessage(message);
            int firstVisiblePosition = this.mList.getFirstVisiblePosition();
            int lastVisiblePosition = this.mList.getLastVisiblePosition();
            if (iFindPosition < firstVisiblePosition || iFindPosition > lastVisiblePosition) {
                return;
            }
            this.mListAdapter.getView(iFindPosition, getListViewChildAt(iFindPosition), this.mList);
        }
    }

    public void onEventMainThread(GroupUserInfo groupUserInfo) {
        RLog.d(TAG, "GroupUserInfoEvent " + groupUserInfo.getGroupId() + " " + groupUserInfo.getUserId() + " " + groupUserInfo.getNickname());
        if (groupUserInfo.getNickname() == null || groupUserInfo.getGroupId() == null) {
            return;
        }
        int count = this.mListAdapter.getCount();
        int firstVisiblePosition = this.mList.getFirstVisiblePosition();
        int lastVisiblePosition = this.mList.getLastVisiblePosition();
        for (int i = 0; i < count; i++) {
            UIMessage item = this.mListAdapter.getItem(i);
            if (item.getSenderUserId().equals(groupUserInfo.getUserId())) {
                item.setNickName(true);
                UserInfo userInfo = item.getUserInfo();
                if (userInfo != null) {
                    userInfo.setName(groupUserInfo.getNickname());
                    item.setUserInfo(userInfo);
                }
                int positionInListView = getPositionInListView(i);
                if (positionInListView >= firstVisiblePosition && positionInListView <= lastVisiblePosition) {
                    this.mListAdapter.getView(i, getListViewChildAt(i), this.mList);
                }
            }
        }
    }

    public void onEventMainThread(Event.OnMessageSendErrorEvent onMessageSendErrorEvent) {
        onEventMainThread(onMessageSendErrorEvent.getMessage());
    }

    public void onEventMainThread(Event.MessageLeftEvent messageLeftEvent) {
        UIMessage item;
        int count = this.mListAdapter.getCount();
        if (messageLeftEvent.left != 0 || count < 1 || (item = this.mListAdapter.getItem(count - 1)) == null || item.getMessage() == null) {
            return;
        }
        handleEventAfterAllMessageLoaded(item.getMessage());
    }

    public void onEventMainThread(Event.OnReceiveMessageEvent onReceiveMessageEvent) {
        CustomServiceConfig customServiceConfig;
        Message message = onReceiveMessageEvent.getMessage();
        RLog.i(TAG, "OnReceiveMessageEvent, " + message.getMessageId() + ", " + message.getObjectName() + ", " + message.getReceivedStatus().toString());
        Conversation.ConversationType conversationType = message.getConversationType();
        String targetId = message.getTargetId();
        if (this.mConversationType.equals(conversationType) && this.mTargetId.equals(targetId) && shouldUpdateMessage(message, onReceiveMessageEvent.getLeft())) {
            if (onReceiveMessageEvent.getLeft() == 0 && !onReceiveMessageEvent.hasPackage()) {
                handleEventAfterAllMessageLoaded(message);
            }
            if (this.mSyncReadStatus) {
                this.mSyncReadStatusMsgTime = message.getSentTime();
            }
            if (message.getMessageId() > 0) {
                if (!SystemUtils.isInBackground(getActivity())) {
                    message.getReceivedStatus().setRead();
                    RongIMClient.getInstance().setMessageReceivedStatus(message.getMessageId(), message.getReceivedStatus(), null);
                    if (message.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                        UnReadMessageManager.getInstance().onMessageReceivedStatusChanged();
                    }
                }
                if (this.mConversationType.equals(Conversation.ConversationType.CUSTOMER_SERVICE) && !this.robotType && (customServiceConfig = this.mCustomServiceConfig) != null && customServiceConfig.adminTipTime > 0 && !TextUtils.isEmpty(customServiceConfig.adminTipWord)) {
                    startTimer(1, this.mCustomServiceConfig.adminTipTime * 60 * 1000);
                }
            }
            RLog.d(TAG, "mList.getCount(): " + this.mList.getCount() + " getLastVisiblePosition:" + this.mList.getLastVisiblePosition());
            increaseNewMessageCountIfNeed(message);
            onEventMainThread(onReceiveMessageEvent.getMessage());
        }
    }

    public void onEventMainThread(Event.changeDestructionReadTimeEvent changedestructionreadtimeevent) {
        Message message = changedestructionreadtimeevent.message;
        if (message != null && this.mConversationType == Conversation.ConversationType.PRIVATE && message.getContent().isDestruct()) {
            this.mListAdapter.getItem(this.mListAdapter.findPosition(message.getMessageId())).getMessage().setReadTime(message.getReadTime());
            this.mListAdapter.notifyDataSetChanged();
        }
    }

    public void onEventMainThread(Event.OnReceiveMessageProgressEvent onReceiveMessageProgressEvent) {
        if (this.mList != null) {
            if (SystemUtils.isInBackground(getContext()) && (onReceiveMessageProgressEvent.getProgress() >= 100 || onReceiveMessageProgressEvent.getProgress() < 0)) {
                this.isNeedRefresh = true;
            } else {
                this.isNeedRefresh = false;
            }
            int lastVisiblePosition = this.mList.getLastVisiblePosition();
            for (int firstVisiblePosition = this.mList.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                int positionInAdapter = getPositionInAdapter(firstVisiblePosition);
                UIMessage item = this.mListAdapter.getItem(positionInAdapter);
                if (item != null && item.getMessageId() == onReceiveMessageProgressEvent.getMessage().getMessageId() && (onReceiveMessageProgressEvent.getProgress() != item.getProgress() || onReceiveMessageProgressEvent.getProgress() == 100)) {
                    item.setProgress(onReceiveMessageProgressEvent.getProgress());
                    if (isResumed()) {
                        this.mListAdapter.getView(positionInAdapter, getListViewChildAt(positionInAdapter), this.mList);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void onEventMainThread(Event.ConnectEvent connectEvent) {
        RLog.i(TAG, "ConnectEvent : " + connectEvent.getConnectStatus());
        if (this.mListAdapter.getCount() == 0) {
            getHistoryMessage(this.mConversationType, this.mTargetId, 10, this.indexMessageTime > 0 ? AutoRefreshListView.Mode.END : AutoRefreshListView.Mode.START, this.indexMessageTime > 0 ? 1 : 3, -1);
        }
    }

    public void onEventMainThread(UserInfo userInfo) {
        RLog.i(TAG, "userInfo " + userInfo.getUserId());
        int firstVisiblePosition = this.mList.getFirstVisiblePosition();
        int lastVisiblePosition = this.mList.getLastVisiblePosition();
        for (int i = 0; i < this.mListAdapter.getCount(); i++) {
            UIMessage item = this.mListAdapter.getItem(i);
            if (userInfo.getUserId().equals(item.getSenderUserId()) && !item.isNickName()) {
                if (item.getConversationType().equals(Conversation.ConversationType.CUSTOMER_SERVICE) && item.getMessage() != null && item.getMessage().getContent() != null && item.getMessage().getContent().getUserInfo() != null) {
                    item.setUserInfo(item.getMessage().getContent().getUserInfo());
                } else {
                    item.setUserInfo(userInfo);
                }
                int positionInListView = getPositionInListView(i);
                if (positionInListView >= firstVisiblePosition && positionInListView <= lastVisiblePosition) {
                    this.mListAdapter.getView(i, getListViewChildAt(i), this.mList);
                }
            }
        }
    }

    public void onEventMainThread(PublicServiceProfile publicServiceProfile) {
        RLog.i(TAG, "publicServiceProfile");
        if (publicServiceProfile != null && this.mConversationType.equals(publicServiceProfile.getConversationType()) && this.mTargetId.equals(publicServiceProfile.getTargetId())) {
            int lastVisiblePosition = this.mList.getLastVisiblePosition();
            for (int firstVisiblePosition = this.mList.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                int positionInAdapter = getPositionInAdapter(firstVisiblePosition);
                UIMessage item = this.mListAdapter.getItem(positionInAdapter);
                if (item != null && (TextUtils.isEmpty(item.getTargetId()) || publicServiceProfile.getTargetId().equals(item.getTargetId()))) {
                    this.mListAdapter.getView(positionInAdapter, getListViewChildAt(positionInAdapter), this.mList);
                }
            }
            updatePublicServiceMenu(publicServiceProfile);
        }
    }

    public void onEventMainThread(Event.ReadReceiptEvent readReceiptEvent) {
        RLog.i(TAG, "ReadReceiptEvent");
        if (RongContext.getInstance().isReadReceiptConversationType(readReceiptEvent.getMessage().getConversationType()) && this.mTargetId.equals(readReceiptEvent.getMessage().getTargetId()) && this.mConversationType.equals(readReceiptEvent.getMessage().getConversationType()) && readReceiptEvent.getMessage().getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            long lastMessageSendTime = ((ReadReceiptMessage) readReceiptEvent.getMessage().getContent()).getLastMessageSendTime();
            for (int count = this.mListAdapter.getCount() - 1; count >= 0; count--) {
                UIMessage item = this.mListAdapter.getItem(count);
                if (item.getMessageDirection().equals(Message.MessageDirection.SEND) && item.getSentStatus() == Message.SentStatus.SENT && lastMessageSendTime >= item.getSentTime()) {
                    item.setSentStatus(Message.SentStatus.READ);
                    int firstVisiblePosition = this.mList.getFirstVisiblePosition();
                    int lastVisiblePosition = this.mList.getLastVisiblePosition();
                    int positionInListView = getPositionInListView(count);
                    if (positionInListView >= firstVisiblePosition && positionInListView <= lastVisiblePosition) {
                        this.mListAdapter.getView(count, getListViewChildAt(count), this.mList);
                    }
                }
            }
        }
    }

    public void onEventMainThread(Event.ShowDurnDialogEvent showDurnDialogEvent) {
        new BurnHintDialog().show(getFragmentManager());
    }

    public void onEventMainThread(Event.RecallMessageEditClickEvent recallMessageEditClickEvent) {
        Message message = recallMessageEditClickEvent.getMessage();
        if (message != null && message.getConversationType() == this.mConversationType && this.mTargetId.equals(message.getTargetId())) {
            MessageContent content = message.getContent();
            if (content instanceof RecallNotificationMessage) {
                String recallContent = ((RecallNotificationMessage) content).getRecallContent();
                if (TextUtils.isEmpty(recallContent)) {
                    return;
                }
                insertToEditText(recallContent, this.mRongExtension.getInputEditText());
                this.mRongExtension.showSoftInput();
            }
        }
    }
}
