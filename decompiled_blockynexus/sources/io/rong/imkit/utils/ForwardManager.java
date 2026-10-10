package io.rong.imkit.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.message.CombineMessage;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.MessageTag;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ImageMessage;
import io.rong.message.LocationMessage;
import io.rong.message.MediaMessageContent;
import io.rong.message.ReferenceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class ForwardManager {
    private static final int SUMMARY_MAX_SIZE = 4;
    private static final String TAG = "ForwardManager";
    private static final int TIME_DELAY = 400;
    private ExecutorService executor;

    private static class SingletonHolder {
        static ForwardManager sInstance = new ForwardManager();

        private SingletonHolder() {
        }
    }

    private static boolean allowForward(Message message, int i) {
        boolean zAllowForwardForCombine = false;
        if (message == null) {
            RLog.d(TAG, "Forwarding is not allowed, message is null");
            return false;
        }
        if (message.getSentStatus() == Message.SentStatus.SENDING || message.getSentStatus() == Message.SentStatus.FAILED || message.getSentStatus() == Message.SentStatus.CANCELED) {
            RLog.d(TAG, "Forwarding is not allowed, status:" + message.getSentStatus());
            return false;
        }
        MessageContent content = message.getContent();
        if (content == null) {
            RLog.d(TAG, "Forwarding is not allowed, message:" + message);
            return false;
        }
        if (content.isDestruct()) {
            RLog.d(TAG, "Destruct message not allow forward");
            return false;
        }
        MessageTag messageTag = (MessageTag) content.getClass().getAnnotation(MessageTag.class);
        if (messageTag == null) {
            RLog.d(TAG, "Forwarding is not allowed, tag is null");
            return false;
        }
        String strValue = messageTag.value();
        if (i == 0) {
            zAllowForwardForCombine = allowForwardForStep(strValue);
        } else if (i == 1) {
            zAllowForwardForCombine = allowForwardForCombine(strValue);
        }
        RLog.d(TAG, "Forwarding allowed:" + zAllowForwardForCombine + ", type:" + messageTag.value());
        return zAllowForwardForCombine;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean allowForwardForCombine(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utils.ForwardManager.allowForwardForCombine(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean allowForwardForStep(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utils.ForwardManager.allowForwardForStep(java.lang.String):boolean");
    }

    public static List<Message> filterMessagesList(Context context, List<Message> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            RLog.e(TAG, "filterMessagesList context is null");
            return arrayList;
        }
        for (Message message : list) {
            if (!allowForward(message, i)) {
                String string = context.getString(R.string.rc_combine_unsupported);
                if (i == 0) {
                    string = context.getString(R.string.rc_combine_unsupported_step);
                }
                new AlertDialog.Builder(context).setMessage(string).setPositiveButton(context.getString(R.string.rc_dialog_ok), (DialogInterface.OnClickListener) null).show();
                arrayList.clear();
                return arrayList;
            }
            arrayList.add(message);
        }
        Collections.sort(arrayList, new Comparator<Message>() { // from class: io.rong.imkit.utils.ForwardManager.1
            @Override // java.util.Comparator
            public int compare(Message message2, Message message3) {
                return (int) (message2.getSentTime() - message3.getSentTime());
            }
        });
        return arrayList;
    }

    public static void forwardMessage(Activity activity, ArrayList<Conversation> arrayList) {
        Intent intent = new Intent();
        intent.putExtra(FirebaseAnalytics.Param.INDEX, activity.getIntent().getIntExtra(FirebaseAnalytics.Param.INDEX, 0));
        intent.putIntegerArrayListExtra("messageIds", activity.getIntent().getIntegerArrayListExtra("messageIds"));
        intent.putParcelableArrayListExtra("conversations", arrayList);
        activity.setResult(-1, intent);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardMessageByCombine(List<Conversation> list, List<Message> list2) {
        Uri urlFromMessageList = CombineMessageUtils.getInstance().getUrlFromMessageList(list2);
        Conversation.ConversationType conversationType = list2.get(0).getConversationType();
        CombineMessage combineMessageObtain = CombineMessage.obtain(urlFromMessageList);
        combineMessageObtain.setConversationType(conversationType);
        combineMessageObtain.setNameList(getNameList(list2, conversationType));
        combineMessageObtain.setTitle(getTitle(combineMessageObtain));
        combineMessageObtain.setSummaryList(getSummaryList(list2));
        for (int i = 0; i < list.size(); i++) {
            Conversation conversation = list.get(i);
            RongIM.getInstance().sendMediaMessage(Message.obtain(conversation.getTargetId(), conversation.getConversationType(), combineMessageObtain), (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
            try {
                Thread.sleep(400L);
            } catch (InterruptedException e2) {
                RLog.e(TAG, "forwardMessageByStep e:" + e2.toString());
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardMessageByStep(List<Conversation> list, List<Message> list2) {
        for (Conversation conversation : list) {
            Iterator<Message> it = list2.iterator();
            while (it.hasNext()) {
                startForwardMessageByStep(conversation.getTargetId(), conversation.getConversationType(), it.next());
                try {
                    Thread.sleep(400L);
                } catch (InterruptedException e2) {
                    RLog.e(TAG, "forwardMessageByStep e:" + e2.toString());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private ExecutorService getExecutor() {
        if (this.executor == null) {
            this.executor = Executors.newSingleThreadExecutor();
        }
        return this.executor;
    }

    public static ForwardManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private List<String> getNameList(List<Message> list, Conversation.ConversationType conversationType) {
        ArrayList arrayList = new ArrayList();
        if (!Conversation.ConversationType.GROUP.equals(conversationType)) {
            Iterator<Message> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message next = it.next();
                if (arrayList.size() == 2) {
                    return arrayList;
                }
                UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(next.getSenderUserId());
                if (userInfo == null) {
                    RLog.d(TAG, "getNameList name is null, msg:" + next);
                    break;
                }
                String name = userInfo.getName();
                if (!TextUtils.isEmpty(name) && !arrayList.contains(name)) {
                    arrayList.add(name);
                }
            }
        } else {
            Group groupInfo = RongUserInfoManager.getInstance().getGroupInfo(list.get(0).getTargetId());
            if (groupInfo != null) {
                String name2 = groupInfo.getName();
                if (!TextUtils.isEmpty(name2) && !arrayList.contains(name2)) {
                    arrayList.add(name2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<String> getSummaryList(List<Message> list) {
        GroupUserInfo groupUserInfo;
        ArrayList arrayList = new ArrayList();
        Conversation.ConversationType conversationType = list.get(0).getConversationType();
        for (int i = 0; i < list.size() && i < 4; i++) {
            Message message = list.get(i);
            MessageContent content = message.getContent();
            UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(message.getSenderUserId());
            String string = "";
            String nickname = (!conversationType.equals(Conversation.ConversationType.GROUP) || (groupUserInfo = RongUserInfoManager.getInstance().getGroupUserInfo(message.getTargetId(), message.getSenderUserId())) == null) ? "" : groupUserInfo.getNickname();
            if (TextUtils.isEmpty(nickname) && userInfo != null) {
                nickname = userInfo.getName();
            }
            MessageTag messageTag = (MessageTag) content.getClass().getAnnotation(MessageTag.class);
            String strValue = messageTag != null ? messageTag.value() : null;
            Context applicationContext = RongIM.getInstance().getApplicationContext();
            if (applicationContext != null) {
                string = "RC:CardMsg".equals(strValue) ? applicationContext.getString(R.string.rc_message_content_card) : "RC:StkMsg".equals(strValue) ? applicationContext.getString(R.string.rc_message_content_sticker) : ("RC:VCSummary".equals(strValue) || "RC:VSTMsg".equals(strValue)) ? applicationContext.getString(R.string.rc_message_content_vst) : "RCJrmf:RpMsg".equals(strValue) ? applicationContext.getString(R.string.rc_message_content_rp) : RongContext.getInstance().getMessageTemplate(content.getClass()).getContentSummary(RongIM.getInstance().getApplicationContext(), content).toString();
            }
            arrayList.add(nickname + " : " + string);
        }
        return arrayList;
    }

    private String getTitle(CombineMessage combineMessage) {
        List<String> nameList;
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        String string = applicationContext.getString(R.string.rc_combine_chat_history);
        if (Conversation.ConversationType.GROUP.equals(combineMessage.getConversationType())) {
            return applicationContext.getString(R.string.rc_combine_group_chat);
        }
        if (!Conversation.ConversationType.PRIVATE.equals(combineMessage.getConversationType()) || (nameList = combineMessage.getNameList()) == null) {
            return string;
        }
        if (nameList.size() == 1) {
            return String.format(applicationContext.getString(R.string.rc_combine_the_group_chat_of), nameList.get(0));
        }
        if (nameList.size() != 2) {
            return string;
        }
        return String.format(applicationContext.getString(R.string.rc_combine_the_group_chat_of), nameList.get(0) + " " + applicationContext.getString(R.string.rc_combine_and) + " " + nameList.get(1));
    }

    private void startForwardMessageByStep(String str, Conversation.ConversationType conversationType, Message message) {
        MessageContent content = message.getContent();
        content.setUserInfo(null);
        content.setMentionedInfo(null);
        Message messageObtain = Message.obtain(str, conversationType, content);
        if (content instanceof ImageMessage) {
            ImageMessage imageMessage = (ImageMessage) content;
            if (imageMessage.getRemoteUri() == null || imageMessage.getRemoteUri().toString().startsWith(LibStorageUtils.FILE)) {
                RongIM.getInstance().sendImageMessage(messageObtain, (String) null, (String) null, (RongIMClient.SendImageMessageCallback) null);
                return;
            } else {
                RongIM.getInstance().sendMessage(messageObtain, null, null, null);
                return;
            }
        }
        if (content instanceof LocationMessage) {
            RongIM.getInstance().sendLocationMessage(messageObtain, null, null, null);
            return;
        }
        if (content instanceof ReferenceMessage) {
            RongIM.getInstance().sendMessage(messageObtain, null, null, null);
            return;
        }
        if (!(content instanceof MediaMessageContent)) {
            RongIM.getInstance().sendMessage(messageObtain, null, null, null);
        } else if (((MediaMessageContent) content).getMediaUrl() != null) {
            RongIM.getInstance().sendMessage(messageObtain, null, null, null);
        } else {
            RongIM.getInstance().sendMediaMessage(messageObtain, (String) null, (String) null, (IRongCallback.ISendMediaMessageCallback) null);
        }
    }

    public void forwardMessages(int i, List<Conversation> list, List<Integer> list2, List<Message> list3) {
        ArrayList arrayList = new ArrayList();
        for (Message message : list3) {
            if (list2.contains(Integer.valueOf(message.getMessageId()))) {
                arrayList.add(message);
            }
        }
        forwardMessages(i, list, arrayList);
    }

    private ForwardManager() {
        this.executor = getExecutor();
    }

    private void forwardMessages(final int i, final List<Conversation> list, final List<Message> list2) {
        getExecutor().execute(new Runnable() { // from class: io.rong.imkit.utils.ForwardManager.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if (i2 == 0) {
                    ForwardManager.this.forwardMessageByStep(list, list2);
                } else if (i2 == 1) {
                    ForwardManager.this.forwardMessageByCombine(list, list2);
                }
            }
        });
    }
}
