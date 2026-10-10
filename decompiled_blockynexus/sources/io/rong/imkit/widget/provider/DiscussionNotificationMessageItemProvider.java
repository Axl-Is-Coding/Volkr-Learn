package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utils.MessageProviderUserInfoHelper;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.UserInfo;
import io.rong.message.DiscussionNotificationMessage;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = DiscussionNotificationMessage.class, showPortrait = false, showSummaryWithName = false)
public class DiscussionNotificationMessageItemProvider extends IContainerItemProvider.MessageProvider<DiscussionNotificationMessage> {
    private static final int DISCUSSION_ADD_MEMBER = 1;
    private static final int DISCUSSION_EXIT = 2;
    private static final int DISCUSSION_MEMBER_INVITE = 5;
    private static final int DISCUSSION_REMOVE = 4;
    private static final int DISCUSSION_RENAME = 3;
    private static final String TAG = "DiscussionNotificationMessageItemProvider";

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    public DiscussionNotificationMessageItemProvider() {
        RongContext.getInstance().getEventBus().register(this);
    }

    private String getWrapContent(Context context, DiscussionNotificationMessage discussionNotificationMessage) {
        int length;
        String string = "";
        if (discussionNotificationMessage == null) {
            return "";
        }
        String[] strArrSplit = null;
        String extension = discussionNotificationMessage.getExtension();
        String operator = discussionNotificationMessage.getOperator();
        if (TextUtils.isEmpty(extension)) {
            length = 0;
        } else {
            strArrSplit = extension.contains(",") ? extension.split(",") : new String[]{extension};
            length = strArrSplit.length;
        }
        String currentUserId = RongIM.getInstance().getCurrentUserId();
        if (TextUtils.isEmpty(currentUserId)) {
            return "";
        }
        int type = discussionNotificationMessage.getType();
        if (type != 1) {
            if (type == 2) {
                UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(operator);
                if (userInfo != null) {
                    string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_exit), userInfo.getName());
                } else {
                    MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                }
            } else if (type != 3) {
                if (type != 4) {
                    if (type == 5) {
                        if (!currentUserId.equals(operator)) {
                            UserInfo userInfo2 = RongUserInfoManager.getInstance().getUserInfo(operator);
                            if (userInfo2 == null) {
                                MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                            } else if ("1".equals(extension)) {
                                string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_is_open_invite_close), userInfo2.getName());
                            } else if ("0".equals(extension)) {
                                string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_is_open_invite_open), userInfo2.getName());
                            }
                        } else if ("1".equals(extension)) {
                            string = context.getResources().getString(R.string.rc_discussion_nt_msg_for_you_is_open_invite_close);
                        } else if ("0".equals(extension)) {
                            string = context.getResources().getString(R.string.rc_discussion_nt_msg_for_you_is_open_invite_open);
                        }
                    }
                } else {
                    if (strArrSplit == null) {
                        return "";
                    }
                    String str = strArrSplit[0];
                    if (currentUserId.equals(operator)) {
                        UserInfo userInfo3 = RongUserInfoManager.getInstance().getUserInfo(str);
                        if (userInfo3 != null) {
                            string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_who_removed), userInfo3.getName(), context.getResources().getString(R.string.rc_discussion_nt_msg_for_you));
                        } else {
                            MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                        }
                    } else if (currentUserId.equals(str)) {
                        UserInfo userInfo4 = RongUserInfoManager.getInstance().getUserInfo(operator);
                        if (userInfo4 != null) {
                            string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_removed), userInfo4.getName());
                        } else {
                            MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                        }
                    } else {
                        UserInfo userInfo5 = RongUserInfoManager.getInstance().getUserInfo(str);
                        UserInfo userInfo6 = RongUserInfoManager.getInstance().getUserInfo(operator);
                        if (userInfo5 == null || userInfo6 == null) {
                            if (userInfo6 == null) {
                                MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                            }
                            if (userInfo5 == null) {
                                MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, str);
                            }
                        } else {
                            string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_who_removed), userInfo5.getName(), userInfo6.getName());
                        }
                    }
                }
            } else if (currentUserId.equals(operator)) {
                string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_you_rename), extension);
            } else {
                UserInfo userInfo7 = RongUserInfoManager.getInstance().getUserInfo(operator);
                if (userInfo7 != null) {
                    string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_rename), userInfo7.getName(), extension);
                } else {
                    MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                }
            }
        } else if (strArrSplit != null) {
            if (currentUserId.equals(operator)) {
                if (length == 1) {
                    String str2 = strArrSplit[0];
                    UserInfo userInfo8 = RongUserInfoManager.getInstance().getUserInfo(str2);
                    if (userInfo8 != null) {
                        string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_you_added), userInfo8.getName());
                    } else {
                        MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, str2);
                    }
                } else {
                    string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_you_add), Integer.valueOf(length));
                }
            } else if (length == 1) {
                String str3 = strArrSplit[0];
                UserInfo userInfo9 = RongUserInfoManager.getInstance().getUserInfo(str3);
                UserInfo userInfo10 = RongUserInfoManager.getInstance().getUserInfo(operator);
                if (userInfo9 == null || userInfo10 == null) {
                    if (userInfo9 == null) {
                        MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, str3);
                    }
                    if (userInfo10 == null) {
                        MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                    }
                } else {
                    string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_added), userInfo10.getName(), userInfo9.getName());
                }
            } else {
                UserInfo userInfo11 = RongUserInfoManager.getInstance().getUserInfo(operator);
                if (userInfo11 != null) {
                    string = String.format(context.getResources().getString(R.string.rc_discussion_nt_msg_for_add), userInfo11.getName(), Integer.valueOf(length));
                } else {
                    MessageProviderUserInfoHelper.getInstance().registerMessageUserInfo(discussionNotificationMessage, operator);
                }
            }
        }
        RLog.i(TAG, "content return " + string);
        return string;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(DiscussionNotificationMessage discussionNotificationMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_discussion_notification_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.contentTextView = (TextView) viewInflate.findViewById(R.id.rc_msg);
        viewHolder.contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    public void onEventMainThread(UserInfo userInfo) {
        if (userInfo.getName() != null && MessageProviderUserInfoHelper.getInstance().isCacheUserId(userInfo.getUserId())) {
            MessageProviderUserInfoHelper.getInstance().notifyMessageUpdate(userInfo.getUserId());
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, DiscussionNotificationMessage discussionNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, DiscussionNotificationMessage discussionNotificationMessage, UIMessage uIMessage) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        Spannable contentSummary = getContentSummary(view.getContext(), discussionNotificationMessage);
        if (contentSummary == null || contentSummary.length() <= 0) {
            viewHolder.contentTextView.setVisibility(8);
        } else {
            viewHolder.contentTextView.setVisibility(0);
            viewHolder.contentTextView.setText(contentSummary);
        }
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(Context context, DiscussionNotificationMessage discussionNotificationMessage) {
        if (discussionNotificationMessage == null) {
            RLog.e(TAG, "getContentSummary DiscussionNotificationMessage is null;");
            return new SpannableString("");
        }
        RLog.i(TAG, "getContentSummary call getContentSummary()  method ");
        return new SpannableString(getWrapContent(context, discussionNotificationMessage));
    }
}
