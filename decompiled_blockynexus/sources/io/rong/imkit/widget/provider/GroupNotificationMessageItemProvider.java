package io.rong.imkit.widget.provider;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.GroupNotificationMessageData;
import io.rong.imkit.model.ProviderTag;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.provider.IContainerItemProvider;
import io.rong.imlib.model.UserInfo;
import io.rong.message.GroupNotificationMessage;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@ProviderTag(centerInHorizontal = true, messageContent = GroupNotificationMessage.class, showPortrait = false, showProgress = false, showSummaryWithName = false)
public class GroupNotificationMessageItemProvider extends IContainerItemProvider.MessageProvider<GroupNotificationMessage> {
    private static final String TAG = "GroupNotificationMessageItemProvider";

    private static class ViewHolder {
        TextView contentTextView;

        private ViewHolder() {
        }
    }

    private GroupNotificationMessageData jsonToBean(String str) {
        GroupNotificationMessageData groupNotificationMessageData = new GroupNotificationMessageData();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("operatorNickname")) {
                groupNotificationMessageData.setOperatorNickname(jSONObject.getString("operatorNickname"));
            }
            if (jSONObject.has("targetGroupName")) {
                groupNotificationMessageData.setTargetGroupName(jSONObject.getString("targetGroupName"));
            }
            if (jSONObject.has("timestamp")) {
                groupNotificationMessageData.setTimestamp(jSONObject.getLong("timestamp"));
            }
            if (jSONObject.has("targetUserIds")) {
                JSONArray jSONArray = jSONObject.getJSONArray("targetUserIds");
                for (int i = 0; i < jSONArray.length(); i++) {
                    groupNotificationMessageData.getTargetUserIds().add(jSONArray.getString(i));
                }
            }
            if (jSONObject.has("targetUserDisplayNames")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("targetUserDisplayNames");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    groupNotificationMessageData.getTargetUserDisplayNames().add(jSONArray2.getString(i2));
                }
            }
            if (jSONObject.has("oldCreatorId")) {
                groupNotificationMessageData.setOldCreatorId(jSONObject.getString("oldCreatorId"));
            }
            if (jSONObject.has("oldCreatorName")) {
                groupNotificationMessageData.setOldCreatorName(jSONObject.getString("oldCreatorName"));
            }
            if (jSONObject.has("newCreatorId")) {
                groupNotificationMessageData.setNewCreatorId(jSONObject.getString("newCreatorId"));
            }
            if (jSONObject.has("newCreatorName")) {
                groupNotificationMessageData.setNewCreatorName(jSONObject.getString("newCreatorName"));
            }
        } catch (Exception e2) {
            RLog.e(TAG, "jsonToBean", e2);
        }
        return groupNotificationMessageData;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public Spannable getContentSummary(GroupNotificationMessage groupNotificationMessage) {
        return null;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider
    public View newView(Context context, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_item_group_information_notification_message, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.contentTextView = (TextView) viewInflate.findViewById(R.id.rc_msg);
        viewHolder.contentTextView.setMovementMethod(LinkMovementMethod.getInstance());
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemClick(View view, int i, GroupNotificationMessage groupNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void onItemLongClick(View view, int i, GroupNotificationMessage groupNotificationMessage, UIMessage uIMessage) {
    }

    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    public void bindView(View view, int i, GroupNotificationMessage groupNotificationMessage, UIMessage uIMessage) {
        UserInfo userInfo;
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (groupNotificationMessage == null || uIMessage == null) {
            return;
        }
        try {
            if (groupNotificationMessage.getData() == null) {
                return;
            }
            try {
                GroupNotificationMessageData groupNotificationMessageDataJsonToBean = jsonToBean(groupNotificationMessage.getData());
                String operation = groupNotificationMessage.getOperation();
                String operatorNickname = groupNotificationMessageDataJsonToBean.getOperatorNickname();
                String operatorUserId = groupNotificationMessage.getOperatorUserId();
                String currentUserId = RongIM.getInstance().getCurrentUserId();
                if (operatorNickname == null && (userInfo = RongUserInfoManager.getInstance().getUserInfo(operatorUserId)) != null && (operatorNickname = userInfo.getName()) == null) {
                    operatorNickname = groupNotificationMessage.getOperatorUserId();
                }
                List<String> targetUserDisplayNames = groupNotificationMessageDataJsonToBean.getTargetUserDisplayNames();
                List<String> targetUserIds = groupNotificationMessageDataJsonToBean.getTargetUserIds();
                String strSubstring = null;
                String str = (targetUserIds == null || targetUserIds.size() != 1) ? null : targetUserIds.get(0);
                if (targetUserDisplayNames != null) {
                    if (targetUserDisplayNames.size() == 1) {
                        strSubstring = targetUserDisplayNames.get(0);
                    } else if (targetUserIds != null && targetUserIds.size() > 1) {
                        StringBuilder sb = new StringBuilder();
                        Iterator<String> it = targetUserDisplayNames.iterator();
                        while (it.hasNext()) {
                            sb.append(it.next());
                            sb.append(view.getContext().getString(R.string.rc_item_divided_string));
                        }
                        String string = sb.toString();
                        strSubstring = string.substring(0, string.length() - 1);
                    }
                }
                if (TextUtils.isEmpty(operation)) {
                    return;
                }
                if (operation.equals(GroupNotificationMessage.GROUP_OPERATION_ADD)) {
                    if (!operatorUserId.equals(str)) {
                        viewHolder.contentTextView.setText(!groupNotificationMessage.getOperatorUserId().equals(RongIM.getInstance().getCurrentUserId()) ? view.getContext().getString(R.string.rc_item_invitation, operatorNickname, strSubstring) : view.getContext().getString(R.string.rc_item_you_invitation, strSubstring));
                        return;
                    }
                    viewHolder.contentTextView.setText(strSubstring + view.getContext().getString(R.string.rc_item_join_group));
                    return;
                }
                if (operation.equals(GroupNotificationMessage.GROUP_OPERATION_KICKED)) {
                    if (targetUserIds != null) {
                        Iterator<String> it2 = targetUserIds.iterator();
                        while (it2.hasNext()) {
                            if (currentUserId.equals(it2.next())) {
                                viewHolder.contentTextView.setText(view.getContext().getString(R.string.rc_item_you_remove_self, operatorNickname));
                            } else {
                                viewHolder.contentTextView.setText(!operatorUserId.equals(currentUserId) ? view.getContext().getString(R.string.rc_item_remove_group_member, operatorNickname, strSubstring) : view.getContext().getString(R.string.rc_item_you_remove_group_member, strSubstring));
                            }
                        }
                        return;
                    }
                    return;
                }
                if (operation.equals(GroupNotificationMessage.GROUP_OPERATION_CREATE)) {
                    new GroupNotificationMessageData();
                    try {
                        jsonToBean(groupNotificationMessage.getData());
                        viewHolder.contentTextView.setText(!operatorUserId.equals(currentUserId) ? view.getContext().getString(R.string.rc_item_created_group, operatorNickname) : view.getContext().getString(R.string.rc_item_you_created_group));
                        return;
                    } catch (Exception e2) {
                        RLog.e(TAG, "bindView", e2);
                        return;
                    }
                }
                if (operation.equals(GroupNotificationMessage.GROUP_OPERATION_DISMISS)) {
                    viewHolder.contentTextView.setText(operatorNickname + view.getContext().getString(R.string.rc_item_dismiss_groups));
                    return;
                }
                if (!operation.equals(GroupNotificationMessage.GROUP_OPERATION_QUIT)) {
                    if (operation.equals(GroupNotificationMessage.GROUP_OPERATION_RENAME)) {
                        viewHolder.contentTextView.setText(!operatorUserId.equals(currentUserId) ? view.getContext().getString(R.string.rc_item_change_group_name, operatorNickname, groupNotificationMessageDataJsonToBean.getTargetGroupName()) : view.getContext().getString(R.string.rc_item_you_change_group_name, groupNotificationMessageDataJsonToBean.getTargetGroupName()));
                    }
                } else {
                    viewHolder.contentTextView.setText(operatorNickname + view.getContext().getString(R.string.rc_item_quit_groups));
                }
            } catch (Exception e3) {
                RLog.e(TAG, "bindView", e3);
            }
        } catch (Exception e4) {
            RLog.e(TAG, "bindView", e4);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
    @Override // io.rong.imkit.widget.provider.IContainerItemProvider.MessageProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.text.Spannable getContentSummary(android.content.Context r17, io.rong.message.GroupNotificationMessage r18) {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.widget.provider.GroupNotificationMessageItemProvider.getContentSummary(android.content.Context, io.rong.message.GroupNotificationMessage):android.text.Spannable");
    }
}
