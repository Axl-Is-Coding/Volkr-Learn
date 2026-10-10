package io.rong.imkit.mention;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import io.rong.common.RLog;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.MentionedInfo;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public class RongMentionManager implements ITextInputListener {
    private static String TAG = "RongMentionManager";
    private IAddMentionedMemberListener mAddMentionedMemberListener;
    private RongIM.IGroupMembersProvider mGroupMembersProvider;
    private IMentionedInputListener mMentionedInputListener;
    private Stack<MentionInstance> stack;

    private static class SingletonHolder {
        static RongMentionManager sInstance = new RongMentionManager();

        private SingletonHolder() {
        }
    }

    private void addMentionedMember(UserInfo userInfo, int i) {
        StringBuilder sb;
        if (this.stack.size() > 0) {
            MentionInstance mentionInstancePeek = this.stack.peek();
            EditText editText = mentionInstancePeek.inputEditText;
            if (userInfo == null || editText == null) {
                return;
            }
            if (i == 0) {
                sb = new StringBuilder();
                sb.append("@");
            } else {
                sb = new StringBuilder();
            }
            sb.append(userInfo.getName());
            sb.append(" ");
            String string = sb.toString();
            int length = string.length();
            int selectionStart = editText.getSelectionStart();
            MentionBlock brokenMentionedBlock = getBrokenMentionedBlock(selectionStart, mentionInstancePeek.mentionBlocks);
            if (brokenMentionedBlock != null) {
                mentionInstancePeek.mentionBlocks.remove(brokenMentionedBlock);
            }
            MentionBlock mentionBlock = new MentionBlock();
            mentionBlock.userId = userInfo.getUserId();
            mentionBlock.offset = false;
            mentionBlock.name = userInfo.getName();
            if (i == 1) {
                mentionBlock.start = selectionStart - 1;
            } else {
                mentionBlock.start = selectionStart;
            }
            int i2 = length + selectionStart;
            mentionBlock.end = i2;
            mentionInstancePeek.mentionBlocks.add(mentionBlock);
            editText.getEditableText().insert(selectionStart, string);
            editText.setSelection(i2);
            IAddMentionedMemberListener iAddMentionedMemberListener = this.mAddMentionedMemberListener;
            if (iAddMentionedMemberListener != null) {
                iAddMentionedMemberListener.onAddMentionedMember(userInfo, i);
            }
            mentionBlock.offset = true;
        }
    }

    private MentionBlock getBrokenMentionedBlock(int i, List<MentionBlock> list) {
        for (MentionBlock mentionBlock : list) {
            if (mentionBlock.offset && i < mentionBlock.end && i > mentionBlock.start) {
                return mentionBlock;
            }
        }
        return null;
    }

    private MentionBlock getDeleteMentionedBlock(int i, List<MentionBlock> list) {
        for (MentionBlock mentionBlock : list) {
            if (i == mentionBlock.end) {
                return mentionBlock;
            }
        }
        return null;
    }

    public static RongMentionManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private void offsetMentionedBlocks(int i, int i2, List<MentionBlock> list) {
        for (MentionBlock mentionBlock : list) {
            int i3 = mentionBlock.start;
            if (i <= i3 && mentionBlock.offset) {
                mentionBlock.start = i3 + i2;
                mentionBlock.end += i2;
            }
            mentionBlock.offset = true;
        }
    }

    void addMentionBlock(MentionBlock mentionBlock) {
        if (this.stack.size() > 0) {
            this.stack.peek().mentionBlocks.add(mentionBlock);
        }
    }

    public void createInstance(Conversation.ConversationType conversationType, String str, EditText editText) {
        RLog.i(TAG, "createInstance");
        String str2 = conversationType.getName() + str;
        if (this.stack.size() <= 0 || !this.stack.peek().key.equals(str2)) {
            MentionInstance mentionInstance = new MentionInstance();
            mentionInstance.key = str2;
            mentionInstance.mentionBlocks = new ArrayList();
            mentionInstance.inputEditText = editText;
            this.stack.add(mentionInstance);
        }
    }

    public void destroyInstance(Conversation.ConversationType conversationType, String str) {
        RLog.i(TAG, "destroyInstance");
        if (this.stack.size() <= 0) {
            RLog.e(TAG, "Invalid MentionInstance.");
            return;
        }
        MentionInstance mentionInstancePeek = this.stack.peek();
        if (mentionInstancePeek.key.equals(conversationType.getName() + str)) {
            this.stack.pop();
            return;
        }
        RLog.e(TAG, "Invalid MentionInstance : " + mentionInstancePeek.key);
    }

    public RongIM.IGroupMembersProvider getGroupMembersProvider() {
        return this.mGroupMembersProvider;
    }

    public String getMentionBlockInfo() {
        MentionInstance mentionInstancePeek;
        List<MentionBlock> list;
        if (this.stack.size() <= 0 || (list = (mentionInstancePeek = this.stack.peek()).mentionBlocks) == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<MentionBlock> it = mentionInstancePeek.mentionBlocks.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray.toString();
    }

    public void mentionMember(Conversation.ConversationType conversationType, String str, String str2) {
        GroupUserInfo groupUserInfo;
        RLog.d(TAG, "mentionMember " + str2);
        if (TextUtils.isEmpty(str2) || conversationType == null || TextUtils.isEmpty(str) || this.stack.size() == 0) {
            RLog.e(TAG, "Illegal argument");
            return;
        }
        String str3 = conversationType.getName() + str;
        MentionInstance mentionInstancePeek = this.stack.peek();
        if (mentionInstancePeek == null || !mentionInstancePeek.key.equals(str3)) {
            RLog.e(TAG, "Invalid mention instance : " + str3);
            return;
        }
        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str2);
        if (userInfo == null || TextUtils.isEmpty(userInfo.getUserId())) {
            RLog.e(TAG, "Invalid userInfo");
            return;
        }
        if (conversationType == Conversation.ConversationType.GROUP && RongContext.getInstance().getGroupUserInfoProvider() != null && (groupUserInfo = RongContext.getInstance().getGroupUserInfoProvider().getGroupUserInfo(str, str2)) != null && groupUserInfo.getNickname() != null && !"".equals(groupUserInfo.getNickname().trim())) {
            userInfo.setName(groupUserInfo.getNickname());
        }
        addMentionedMember(userInfo, 0);
    }

    @Override // io.rong.imkit.mention.ITextInputListener
    public void onDeleteClick(Conversation.ConversationType conversationType, String str, EditText editText, int i) {
        MentionBlock deleteMentionedBlock;
        RLog.d(TAG, "onTextEdit " + i);
        if (this.stack.size() <= 0 || i <= 0) {
            return;
        }
        MentionInstance mentionInstancePeek = this.stack.peek();
        if (!mentionInstancePeek.key.equals(conversationType.getName() + str) || (deleteMentionedBlock = getDeleteMentionedBlock(i, mentionInstancePeek.mentionBlocks)) == null) {
            return;
        }
        mentionInstancePeek.mentionBlocks.remove(deleteMentionedBlock);
        int length = (i - deleteMentionedBlock.name.length()) - 1;
        editText.getEditableText().delete(length, i);
        editText.setSelection(length);
    }

    @Override // io.rong.imkit.mention.ITextInputListener
    public MentionedInfo onSendButtonClick() {
        if (this.stack.size() > 0) {
            ArrayList arrayList = new ArrayList();
            MentionInstance mentionInstancePeek = this.stack.peek();
            for (MentionBlock mentionBlock : mentionInstancePeek.mentionBlocks) {
                if (!arrayList.contains(mentionBlock.userId)) {
                    arrayList.add(mentionBlock.userId);
                }
            }
            if (arrayList.size() > 0) {
                mentionInstancePeek.mentionBlocks.clear();
                return new MentionedInfo(MentionedInfo.MentionedType.PART, arrayList, null);
            }
        }
        return null;
    }

    @Override // io.rong.imkit.mention.ITextInputListener
    public void onTextEdit(Conversation.ConversationType conversationType, String str, int i, int i2, String str2) {
        IMentionedInputListener iMentionedInputListener;
        RLog.d(TAG, "onTextEdit " + i + ", " + str2);
        Stack<MentionInstance> stack = this.stack;
        if (stack == null || stack.size() == 0) {
            RLog.w(TAG, "onTextEdit ignore.");
            return;
        }
        MentionInstance mentionInstancePeek = this.stack.peek();
        if (!mentionInstancePeek.key.equals(conversationType.getName() + str)) {
            RLog.w(TAG, "onTextEdit ignore conversation.");
            return;
        }
        boolean zEquals = true;
        if (i2 == 1 && !TextUtils.isEmpty(str2)) {
            if (i == 0) {
                zEquals = str2.substring(0, 1).equals("@");
            } else {
                String strSubstring = str2.substring(i - 1, i);
                if (!str2.substring(i, i + 1).equals("@") || strSubstring.matches("^[a-zA-Z]*") || strSubstring.matches("^\\d+$")) {
                    zEquals = false;
                }
            }
            if (zEquals && ((iMentionedInputListener = this.mMentionedInputListener) == null || !iMentionedInputListener.onMentionedInput(conversationType, str))) {
                Intent intent = new Intent(RongIM.getInstance().getApplicationContext(), (Class<?>) MemberMentionedActivity.class);
                intent.putExtra("conversationType", conversationType.getValue());
                intent.putExtra("targetId", str);
                intent.setFlags(268435456);
                RongIM.getInstance().getApplicationContext().startActivity(intent);
            }
        }
        MentionBlock brokenMentionedBlock = getBrokenMentionedBlock(i, mentionInstancePeek.mentionBlocks);
        if (brokenMentionedBlock != null) {
            mentionInstancePeek.mentionBlocks.remove(brokenMentionedBlock);
        }
        offsetMentionedBlocks(i, i2, mentionInstancePeek.mentionBlocks);
    }

    public void setAddMentionedMemberListener(IAddMentionedMemberListener iAddMentionedMemberListener) {
        this.mAddMentionedMemberListener = iAddMentionedMemberListener;
    }

    public void setGroupMembersProvider(RongIM.IGroupMembersProvider iGroupMembersProvider) {
        this.mGroupMembersProvider = iGroupMembersProvider;
    }

    public void setMentionedInputListener(IMentionedInputListener iMentionedInputListener) {
        this.mMentionedInputListener = iMentionedInputListener;
    }

    private RongMentionManager() {
        this.stack = new Stack<>();
    }

    public void mentionMember(UserInfo userInfo) {
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getUserId())) {
            addMentionedMember(userInfo, 1);
        } else {
            RLog.e(TAG, "Invalid userInfo");
        }
    }
}
