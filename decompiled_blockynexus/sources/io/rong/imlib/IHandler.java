package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.ConversationStatusListener;
import io.rong.imlib.IChatRoomHistoryMessageCallback;
import io.rong.imlib.IConnectStringCallback;
import io.rong.imlib.IConnectionStatusListener;
import io.rong.imlib.IDataByBatchListener;
import io.rong.imlib.IDownloadMediaCallback;
import io.rong.imlib.IDownloadMediaFileCallback;
import io.rong.imlib.IDownloadMediaMessageCallback;
import io.rong.imlib.IGetConversationListWithProcessCallback;
import io.rong.imlib.IGetNotificationQuietHoursCallback;
import io.rong.imlib.IGetUserStatusCallback;
import io.rong.imlib.IIntegerCallback;
import io.rong.imlib.ILongCallback;
import io.rong.imlib.IMessageExpansionListener;
import io.rong.imlib.INaviContentUpdateCallBack;
import io.rong.imlib.IOperationCallback;
import io.rong.imlib.IRLogOtherProgressCallback;
import io.rong.imlib.IRTCConfigCallback;
import io.rong.imlib.IRTCJoinRoomCallback;
import io.rong.imlib.IResultCallback;
import io.rong.imlib.IRtcIODataListener;
import io.rong.imlib.ISendMediaMessageCallback;
import io.rong.imlib.ISendMessageCallback;
import io.rong.imlib.ISetPushSettingCallback;
import io.rong.imlib.ISetUserStatusCallback;
import io.rong.imlib.ISolveServerHostsCallBack;
import io.rong.imlib.IStringCallback;
import io.rong.imlib.ISubscribeUserStatusCallback;
import io.rong.imlib.IUploadCallback;
import io.rong.imlib.KVStatusDataByBatchListener;
import io.rong.imlib.OnGetHistoryMessagesCallback;
import io.rong.imlib.OnReceiveMessageListener;
import io.rong.imlib.RTCDataListener;
import io.rong.imlib.UserProfileSettingListener;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.RCEncryptedSession;
import io.rong.imlib.model.RTCStatusDate;
import io.rong.imlib.model.RemoteHistoryMsgOption;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.SendMessageOption;
import io.rong.imlib.model.UserData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IHandler extends IInterface {

    public static class Default implements IHandler {
        @Override // io.rong.imlib.IHandler
        public void addMemberToDiscussion(String str, List<String> list, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void addToBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void cancelAllDownloadMediaMessage(IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void cancelDownloadMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void cancelSDKHeartBeat() throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void cancelSendMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean cleanConversationDraft(Conversation conversation) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void cleanHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void cleanRemoteHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearConversations(int[] iArr) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearEncryptedConversations() throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearMessages(Conversation conversation) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearMessagesUnreadStatus(Conversation conversation) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearTextMessageDraft(Conversation conversation) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean clearUnreadByReceipt(int i, String str, long j) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void connect(String str, boolean z, boolean z2, IConnectStringCallback iConnectStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void createDiscussion(String str, List<String> list, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean createEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void deleteChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean deleteConversationMessage(int i, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean deleteMessage(int[] iArr) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void deleteMessages(int i, String str, Message[] messageArr, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void disconnect(boolean z) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void downloadMedia(Conversation conversation, int i, String str, IDownloadMediaCallback iDownloadMediaCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void downloadMediaFile(String str, String str2, String str3, String str4, IDownloadMediaFileCallback iDownloadMediaFileCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void downloadMediaMessage(Message message, IDownloadMediaMessageCallback iDownloadMediaMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void exitRTCRoom(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getAllChatRoomEntries(String str, IDataByBatchListener iDataByBatchListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public List<RCEncryptedSession> getAllEncryptedConversations() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getBlacklist(IStringCallback iStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getBlacklistStatus(String str, IIntegerCallback iIntegerCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public List<Conversation> getBlockedConversationList(int[] iArr) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getChatRoomEntry(String str, String str2, IStringCallback iStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getChatRoomInfo(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getChatroomHistoryMessages(String str, long j, int i, int i2, IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public Conversation getConversation(int i, String str) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public String getConversationDraft(Conversation conversation) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Conversation> getConversationList() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getConversationListByBatch(int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public List<Conversation> getConversationListByPage(int[] iArr, long j, int i) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Conversation> getConversationListByType(int[] iArr) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getConversationListOfTypesByBatch(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getConversationNotificationStatus(int i, String str, ILongCallback iLongCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public int getConversationUnreadCount(Conversation conversation) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public String getCurrentUserId() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public long getDeltaTime() throws RemoteException {
            return 0L;
        }

        @Override // io.rong.imlib.IHandler
        public void getDiscussion(String str, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public RCEncryptedSession getEncryptedConversation(String str) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public boolean getFileDownloadingStatus(String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public int getGIFLimitSize() throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public boolean getJoinMultiChatRoomEnable() throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getMatchedMessages(String str, int i, long j, int i2, int i3) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public Message getMessage(int i) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public Message getMessageByUid(String str) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public int getMessageCount(int i, String str) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public long getNaviCachedTime() throws RemoteException {
            return 0L;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getNewestMessages(Conversation conversation, int i) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getNotificationQuietHours(IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public String getOffLineLogServer() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public String getOfflineMessageDuration() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getOlderMessages(Conversation conversation, long j, int i) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getOlderMessagesByObjectName(Conversation conversation, String str, long j, int i, boolean z) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getOlderMessagesByObjectNames(Conversation conversation, List<String> list, long j, int i, boolean z) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getOlderMessagesOneWay(Conversation conversation, long j, int i, OnGetHistoryMessagesCallback onGetHistoryMessagesCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getPublicServiceList(IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getPublicServiceProfile(String str, int i, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public String getPushSetting(int i) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getRTCConfig(String str, String str2, long j, String str3, IRTCConfigCallback iRTCConfigCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public String getRTCProfile() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getRTCToken(String str, int i, int i2, IStringCallback iStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getRTCUserData(String str, int i, RTCDataListener rTCDataListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getRTCUserDatas(String str, String[] strArr, RTCDataListener rTCDataListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getRTCUsers(String str, int i, RTCDataListener rTCDataListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getRemoteHistoryMessages(Conversation conversation, long j, int i, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getRemoteHistoryMessagesOption(Conversation conversation, RemoteHistoryMsgOption remoteHistoryMsgOption, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public long getSendTimeByMessageId(int i) throws RemoteException {
            return 0L;
        }

        @Override // io.rong.imlib.IHandler
        public String getTextMessageDraft(Conversation conversation) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public Message getTheFirstUnreadMessage(int i, String str) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getTopConversationList(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public int getTotalUnreadCount() throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public int getUnreadCount(int[] iArr) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public int getUnreadCountByConversation(Conversation[] conversationArr) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public int getUnreadCountById(int i, String str) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public int getUnreadCountWithDND(int[] iArr, boolean z) throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> getUnreadMentionedMessages(int i, String str) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public String getUploadLogConfigInfo() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getUserStatus(String str, IGetUserStatusCallback iGetUserStatusCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void getVendorToken(IStringCallback iStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public int getVideoLimitTime() throws RemoteException {
            return 0;
        }

        @Override // io.rong.imlib.IHandler
        public String getVoIPCallInfo() throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void getVoIPKey(int i, String str, String str2, IStringCallback iStringCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void initAppendixModule() throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void initHttpDns() throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void initIPCEnviroment(String str, int i) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public Message insertMessage(Message message) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public Message insertSettingMessage(Message message) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public boolean isDnsEnabled() throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean isPhrasesEnabled() throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void joinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void joinExistChatRoom(String str, int i, IOperationCallback iOperationCallback, boolean z) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void joinGroup(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void joinRTCRoomAndGetData(String str, int i, int i2, IRTCJoinRoomCallback iRTCJoinRoomCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void notifyAppBackgroundChanged(boolean z) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void pauseTransferMediaFile(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void pauseTransferMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void quitChatRoom(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void quitDiscussion(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void quitGroup(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void reJoinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void recallMessage(String str, byte[] bArr, String str2, int i, String str3, int i2, boolean z, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void registerCmdMsgType(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void registerCmdMsgTypes(List<String> list) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void registerDeleteMessageType(List<String> list) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void registerMessageType(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void registerMessageTypes(List<String> list) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean removeConversation(int i, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void removeDiscussionMember(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean removeEncryptedConversation(String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void removeFromBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void removeMessageAllExpansion(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void removeMessageExpansion(List<String> list, String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void removeNotificationQuietHours(IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcDeleteInnerData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcDeleteOuterData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcGetInnerData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcGetOuterData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcPutInnerData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcPutOuterData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void rtcSetUserResource(String str, RTCStatusDate[] rTCStatusDateArr, String str2, RTCStatusDate[] rTCStatusDateArr2, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean saveConversationDraft(Conversation conversation, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean saveTextMessageDraft(Conversation conversation, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public List<SearchConversationResult> searchConversations(String str, int[] iArr, String[] strArr) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> searchMessages(String str, int i, String str2, int i2, long j) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public List<Message> searchMessagesByUser(String str, int i, String str2, int i2, long j) throws RemoteException {
            return null;
        }

        @Override // io.rong.imlib.IHandler
        public void searchPublicService(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendDirectionalMessage(Message message, String str, String str2, String[] strArr, ISendMessageCallback iSendMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendLocationMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendMediaMessage(Message message, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, ISendMessageCallback iSendMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendPing() throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendRTCDirectionalMessage(Message message, String str, String str2, String[] strArr, SendMessageOption sendMessageOption, boolean z, ISendMessageCallback iSendMessageCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void sendRTCPing(String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setConnectionStatusListener(IConnectionStatusListener iConnectionStatusListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setConversationNotificationStatus(int i, String str, int i2, ILongCallback iLongCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setConversationStatusListener(ConversationStatusListener conversationStatusListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean setConversationTopStatus(int i, String str, boolean z, boolean z2) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void setDiscussionInviteStatus(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setDiscussionName(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean setEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void setIpcConnectTimeOut() throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setKvStatusListener(KVStatusDataByBatchListener kVStatusDataByBatchListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean setMessageContent(int i, byte[] bArr, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void setMessageExpansionListener(IMessageExpansionListener iMessageExpansionListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean setMessageExtra(int i, String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean setMessageReadTime(long j, long j2) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean setMessageReceivedStatus(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean setMessageSentStatus(int i, int i2) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void setNaviContentUpdateListener(INaviContentUpdateCallBack iNaviContentUpdateCallBack) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setNotificationQuietHours(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setOfflineMessageDuration(String str, ILongCallback iLongCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setOnReceiveMessageListener(OnReceiveMessageListener onReceiveMessageListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setPushSetting(int i, String str, ISetPushSettingCallback iSetPushSettingCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setRLogOtherProgressCallback(IRLogOtherProgressCallback iRLogOtherProgressCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setRTCUserData(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setRTCUserDatas(String str, int i, Map map, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setReconnectKickEnable(boolean z) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setServerInfo(String str, String str2) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setSubscribeStatusListener(ISubscribeUserStatusCallback iSubscribeUserStatusCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setUserData(UserData userData, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setUserPolicy(boolean z) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setUserProfileListener(UserProfileSettingListener userProfileSettingListener) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void setUserStatus(int i, ISetUserStatusCallback iSetUserStatusCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void solveServerHosts(String str, ISolveServerHostsCallBack iSolveServerHostsCallBack) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void subscribePublicService(String str, int i, boolean z, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void subscribeStatus(List<String> list, IIntegerCallback iIntegerCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean supportResumeBrokenTransfer(String str) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void switchAppKey(String str, String str2) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void syncGroup(List<Group> list, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean updateConversationInfo(int i, String str, String str2, String str3) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void updateMessageExpansion(Map map, String str, IOperationCallback iOperationCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean updateMessageReceiptStatus(String str, int i, long j) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public boolean updateReadReceiptRequestInfo(String str, String str2) throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void updateVoIPCallInfo(String str) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public void uploadMedia(Message message, IUploadCallback iUploadCallback) throws RemoteException {
        }

        @Override // io.rong.imlib.IHandler
        public boolean useRTCOnly() throws RemoteException {
            return false;
        }

        @Override // io.rong.imlib.IHandler
        public void writeFwLog(int i, String str, String str2, String str3, long j) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IHandler {
        private static final String DESCRIPTOR = "io.rong.imlib.IHandler";
        static final int TRANSACTION_addMemberToDiscussion = 80;
        static final int TRANSACTION_addToBlacklist = 109;
        static final int TRANSACTION_cancelAllDownloadMediaMessage = 105;
        static final int TRANSACTION_cancelDownloadMediaMessage = 100;
        static final int TRANSACTION_cancelSDKHeartBeat = 143;
        static final int TRANSACTION_cancelSendMediaMessage = 99;
        static final int TRANSACTION_cleanConversationDraft = 61;
        static final int TRANSACTION_cleanHistoryMessages = 31;
        static final int TRANSACTION_cleanRemoteHistoryMessages = 30;
        static final int TRANSACTION_clearConversations = 66;
        static final int TRANSACTION_clearEncryptedConversations = 75;
        static final int TRANSACTION_clearMessages = 44;
        static final int TRANSACTION_clearMessagesUnreadStatus = 45;
        static final int TRANSACTION_clearTextMessageDraft = 113;
        static final int TRANSACTION_clearUnreadByReceipt = 118;
        static final int TRANSACTION_connect = 2;
        static final int TRANSACTION_createDiscussion = 79;
        static final int TRANSACTION_createEncryptedConversation = 71;
        static final int TRANSACTION_deleteChatRoomEntry = 179;
        static final int TRANSACTION_deleteConversationMessage = 43;
        static final int TRANSACTION_deleteMessage = 41;
        static final int TRANSACTION_deleteMessages = 42;
        static final int TRANSACTION_disconnect = 3;
        static final int TRANSACTION_downloadMedia = 96;
        static final int TRANSACTION_downloadMediaFile = 98;
        static final int TRANSACTION_downloadMediaMessage = 97;
        static final int TRANSACTION_exitRTCRoom = 154;
        static final int TRANSACTION_getAllChatRoomEntries = 178;
        static final int TRANSACTION_getAllEncryptedConversations = 76;
        static final int TRANSACTION_getBlacklist = 114;
        static final int TRANSACTION_getBlacklistStatus = 115;
        static final int TRANSACTION_getBlockedConversationList = 56;
        static final int TRANSACTION_getChatRoomEntry = 177;
        static final int TRANSACTION_getChatRoomInfo = 86;
        static final int TRANSACTION_getChatroomHistoryMessages = 32;
        static final int TRANSACTION_getConversation = 57;
        static final int TRANSACTION_getConversationDraft = 60;
        static final int TRANSACTION_getConversationList = 51;
        static final int TRANSACTION_getConversationListByBatch = 52;
        static final int TRANSACTION_getConversationListByPage = 55;
        static final int TRANSACTION_getConversationListByType = 53;
        static final int TRANSACTION_getConversationListOfTypesByBatch = 54;
        static final int TRANSACTION_getConversationNotificationStatus = 62;
        static final int TRANSACTION_getConversationUnreadCount = 65;
        static final int TRANSACTION_getCurrentUserId = 122;
        static final int TRANSACTION_getDeltaTime = 106;
        static final int TRANSACTION_getDiscussion = 77;
        static final int TRANSACTION_getEncryptedConversation = 72;
        static final int TRANSACTION_getFileDownloadingStatus = 103;
        static final int TRANSACTION_getGIFLimitSize = 148;
        static final int TRANSACTION_getJoinMultiChatRoomEnable = 137;
        static final int TRANSACTION_getMatchedMessages = 133;
        static final int TRANSACTION_getMessage = 16;
        static final int TRANSACTION_getMessageByUid = 49;
        static final int TRANSACTION_getMessageCount = 11;
        static final int TRANSACTION_getNaviCachedTime = 136;
        static final int TRANSACTION_getNewestMessages = 25;
        static final int TRANSACTION_getNotificationQuietHours = 69;
        static final int TRANSACTION_getOffLineLogServer = 182;
        static final int TRANSACTION_getOfflineMessageDuration = 138;
        static final int TRANSACTION_getOlderMessages = 26;
        static final int TRANSACTION_getOlderMessagesByObjectName = 39;
        static final int TRANSACTION_getOlderMessagesByObjectNames = 40;
        static final int TRANSACTION_getOlderMessagesOneWay = 27;
        static final int TRANSACTION_getPublicServiceList = 94;
        static final int TRANSACTION_getPublicServiceProfile = 93;
        static final int TRANSACTION_getPushSetting = 38;
        static final int TRANSACTION_getRTCConfig = 166;
        static final int TRANSACTION_getRTCProfile = 152;
        static final int TRANSACTION_getRTCToken = 167;
        static final int TRANSACTION_getRTCUserData = 156;
        static final int TRANSACTION_getRTCUserDatas = 172;
        static final int TRANSACTION_getRTCUsers = 155;
        static final int TRANSACTION_getRemoteHistoryMessages = 28;
        static final int TRANSACTION_getRemoteHistoryMessagesOption = 29;
        static final int TRANSACTION_getSendTimeByMessageId = 119;
        static final int TRANSACTION_getTextMessageDraft = 111;
        static final int TRANSACTION_getTheFirstUnreadMessage = 141;
        static final int TRANSACTION_getTopConversationList = 50;
        static final int TRANSACTION_getTotalUnreadCount = 6;
        static final int TRANSACTION_getUnreadCount = 8;
        static final int TRANSACTION_getUnreadCountByConversation = 7;
        static final int TRANSACTION_getUnreadCountById = 10;
        static final int TRANSACTION_getUnreadCountWithDND = 9;
        static final int TRANSACTION_getUnreadMentionedMessages = 125;
        static final int TRANSACTION_getUploadLogConfigInfo = 181;
        static final int TRANSACTION_getUserStatus = 33;
        static final int TRANSACTION_getVendorToken = 134;
        static final int TRANSACTION_getVideoLimitTime = 147;
        static final int TRANSACTION_getVoIPCallInfo = 121;
        static final int TRANSACTION_getVoIPKey = 120;
        static final int TRANSACTION_initAppendixModule = 1;
        static final int TRANSACTION_initHttpDns = 151;
        static final int TRANSACTION_initIPCEnviroment = 15;
        static final int TRANSACTION_insertMessage = 17;
        static final int TRANSACTION_insertSettingMessage = 18;
        static final int TRANSACTION_isDnsEnabled = 174;
        static final int TRANSACTION_isPhrasesEnabled = 173;
        static final int TRANSACTION_joinChatRoom = 88;
        static final int TRANSACTION_joinExistChatRoom = 89;
        static final int TRANSACTION_joinGroup = 84;
        static final int TRANSACTION_joinRTCRoomAndGetData = 165;
        static final int TRANSACTION_notifyAppBackgroundChanged = 183;
        static final int TRANSACTION_pauseTransferMediaFile = 102;
        static final int TRANSACTION_pauseTransferMediaMessage = 101;
        static final int TRANSACTION_quitChatRoom = 90;
        static final int TRANSACTION_quitDiscussion = 82;
        static final int TRANSACTION_quitGroup = 85;
        static final int TRANSACTION_reJoinChatRoom = 87;
        static final int TRANSACTION_recallMessage = 108;
        static final int TRANSACTION_registerCmdMsgType = 127;
        static final int TRANSACTION_registerCmdMsgTypes = 128;
        static final int TRANSACTION_registerDeleteMessageType = 129;
        static final int TRANSACTION_registerMessageType = 4;
        static final int TRANSACTION_registerMessageTypes = 5;
        static final int TRANSACTION_removeConversation = 58;
        static final int TRANSACTION_removeDiscussionMember = 81;
        static final int TRANSACTION_removeEncryptedConversation = 74;
        static final int TRANSACTION_removeFromBlacklist = 110;
        static final int TRANSACTION_removeMessageAllExpansion = 188;
        static final int TRANSACTION_removeMessageExpansion = 187;
        static final int TRANSACTION_removeNotificationQuietHours = 68;
        static final int TRANSACTION_rtcDeleteInnerData = 161;
        static final int TRANSACTION_rtcDeleteOuterData = 162;
        static final int TRANSACTION_rtcGetInnerData = 163;
        static final int TRANSACTION_rtcGetOuterData = 164;
        static final int TRANSACTION_rtcPutInnerData = 159;
        static final int TRANSACTION_rtcPutOuterData = 160;
        static final int TRANSACTION_rtcSetUserResource = 184;
        static final int TRANSACTION_saveConversationDraft = 59;
        static final int TRANSACTION_saveTextMessageDraft = 112;
        static final int TRANSACTION_searchConversations = 132;
        static final int TRANSACTION_searchMessages = 130;
        static final int TRANSACTION_searchMessagesByUser = 131;
        static final int TRANSACTION_searchPublicService = 91;
        static final int TRANSACTION_sendDirectionalMediaMessage = 23;
        static final int TRANSACTION_sendDirectionalMessage = 21;
        static final int TRANSACTION_sendLocationMessage = 24;
        static final int TRANSACTION_sendMediaMessage = 22;
        static final int TRANSACTION_sendMessage = 19;
        static final int TRANSACTION_sendMessageOption = 20;
        static final int TRANSACTION_sendPing = 144;
        static final int TRANSACTION_sendRTCDirectionalMessage = 175;
        static final int TRANSACTION_sendRTCPing = 157;
        static final int TRANSACTION_setChatRoomEntry = 176;
        static final int TRANSACTION_setConnectionStatusListener = 13;
        static final int TRANSACTION_setConversationNotificationStatus = 63;
        static final int TRANSACTION_setConversationStatusListener = 150;
        static final int TRANSACTION_setConversationTopStatus = 64;
        static final int TRANSACTION_setDiscussionInviteStatus = 107;
        static final int TRANSACTION_setDiscussionName = 78;
        static final int TRANSACTION_setEncryptedConversation = 73;
        static final int TRANSACTION_setIpcConnectTimeOut = 14;
        static final int TRANSACTION_setKvStatusListener = 185;
        static final int TRANSACTION_setMessageContent = 124;
        static final int TRANSACTION_setMessageExpansionListener = 189;
        static final int TRANSACTION_setMessageExtra = 46;
        static final int TRANSACTION_setMessageReadTime = 142;
        static final int TRANSACTION_setMessageReceivedStatus = 47;
        static final int TRANSACTION_setMessageSentStatus = 48;
        static final int TRANSACTION_setNaviContentUpdateListener = 180;
        static final int TRANSACTION_setNotificationQuietHours = 67;
        static final int TRANSACTION_setOfflineMessageDuration = 139;
        static final int TRANSACTION_setOnReceiveMessageListener = 12;
        static final int TRANSACTION_setPushSetting = 37;
        static final int TRANSACTION_setRLogOtherProgressCallback = 168;
        static final int TRANSACTION_setRTCUserData = 169;
        static final int TRANSACTION_setRTCUserDatas = 171;
        static final int TRANSACTION_setReconnectKickEnable = 146;
        static final int TRANSACTION_setServerInfo = 123;
        static final int TRANSACTION_setSubscribeStatusListener = 36;
        static final int TRANSACTION_setUserData = 116;
        static final int TRANSACTION_setUserPolicy = 145;
        static final int TRANSACTION_setUserProfileListener = 149;
        static final int TRANSACTION_setUserStatus = 34;
        static final int TRANSACTION_solveServerHosts = 170;
        static final int TRANSACTION_subscribePublicService = 92;
        static final int TRANSACTION_subscribeStatus = 35;
        static final int TRANSACTION_supportResumeBrokenTransfer = 104;
        static final int TRANSACTION_switchAppKey = 140;
        static final int TRANSACTION_syncGroup = 83;
        static final int TRANSACTION_updateConversationInfo = 70;
        static final int TRANSACTION_updateMessageExpansion = 186;
        static final int TRANSACTION_updateMessageReceiptStatus = 117;
        static final int TRANSACTION_updateReadReceiptRequestInfo = 126;
        static final int TRANSACTION_updateVoIPCallInfo = 153;
        static final int TRANSACTION_uploadMedia = 95;
        static final int TRANSACTION_useRTCOnly = 158;
        static final int TRANSACTION_writeFwLog = 135;

        private static class Proxy implements IHandler {
            public static IHandler sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // io.rong.imlib.IHandler
            public void addMemberToDiscussion(String str, List<String> list, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(80, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addMemberToDiscussion(str, list, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void addToBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(109, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().addToBlacklist(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // io.rong.imlib.IHandler
            public void cancelAllDownloadMediaMessage(IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(105, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelAllDownloadMediaMessage(iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void cancelDownloadMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(100, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelDownloadMediaMessage(message, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void cancelSDKHeartBeat() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(143, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().cancelSDKHeartBeat();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void cancelSendMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(99, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cancelSendMediaMessage(message, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean cleanConversationDraft(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(61, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().cleanConversationDraft(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void cleanHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(31, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cleanHistoryMessages(conversation, j, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void cleanRemoteHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(30, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().cleanRemoteHistoryMessages(conversation, j, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearConversations(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(66, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearConversations(iArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearEncryptedConversations() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(75, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearEncryptedConversations();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearMessages(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(44, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearMessages(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearMessagesUnreadStatus(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(45, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearMessagesUnreadStatus(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearTextMessageDraft(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(113, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearTextMessageDraft(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean clearUnreadByReceipt(int i, String str, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    if (!this.mRemote.transact(118, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().clearUnreadByReceipt(i, str, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void connect(String str, boolean z, boolean z2, IConnectStringCallback iConnectStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeStrongBinder(iConnectStringCallback != null ? iConnectStringCallback.asBinder() : null);
                    if (this.mRemote.transact(2, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().connect(str, z, z2, iConnectStringCallback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void createDiscussion(String str, List<String> list, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(79, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().createDiscussion(str, list, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean createEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (rCEncryptedSession != null) {
                        parcelObtain.writeInt(1);
                        rCEncryptedSession.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(71, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().createEncryptedConversation(str, rCEncryptedSession);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void deleteChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    int i = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!z3) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(179, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().deleteChatRoomEntry(str, str2, str3, z, str4, z2, z3, iOperationCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean deleteConversationMessage(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(43, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deleteConversationMessage(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean deleteMessage(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(41, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().deleteMessage(iArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void deleteMessages(int i, String str, Message[] messageArr, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedArray(messageArr, 0);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(42, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().deleteMessages(i, str, messageArr, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void disconnect(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().disconnect(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void downloadMedia(Conversation conversation, int i, String str, IDownloadMediaCallback iDownloadMediaCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDownloadMediaCallback != null ? iDownloadMediaCallback.asBinder() : null);
                    if (this.mRemote.transact(96, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().downloadMedia(conversation, i, str, iDownloadMediaCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void downloadMediaFile(String str, String str2, String str3, String str4, IDownloadMediaFileCallback iDownloadMediaFileCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeStrongBinder(iDownloadMediaFileCallback != null ? iDownloadMediaFileCallback.asBinder() : null);
                    if (this.mRemote.transact(98, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().downloadMediaFile(str, str2, str3, str4, iDownloadMediaFileCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void downloadMediaMessage(Message message, IDownloadMediaMessageCallback iDownloadMediaMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iDownloadMediaMessageCallback != null ? iDownloadMediaMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(97, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().downloadMediaMessage(message, iDownloadMediaMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void exitRTCRoom(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(154, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().exitRTCRoom(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getAllChatRoomEntries(String str, IDataByBatchListener iDataByBatchListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iDataByBatchListener != null ? iDataByBatchListener.asBinder() : null);
                    if (this.mRemote.transact(178, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getAllChatRoomEntries(str, iDataByBatchListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<RCEncryptedSession> getAllEncryptedConversations() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(76, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllEncryptedConversations();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(RCEncryptedSession.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getBlacklist(IStringCallback iStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iStringCallback != null ? iStringCallback.asBinder() : null);
                    if (this.mRemote.transact(114, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getBlacklist(iStringCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getBlacklistStatus(String str, IIntegerCallback iIntegerCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iIntegerCallback != null ? iIntegerCallback.asBinder() : null);
                    if (this.mRemote.transact(115, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getBlacklistStatus(str, iIntegerCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Conversation> getBlockedConversationList(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(56, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBlockedConversationList(iArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getChatRoomEntry(String str, String str2, IStringCallback iStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iStringCallback != null ? iStringCallback.asBinder() : null);
                    if (this.mRemote.transact(177, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getChatRoomEntry(str, str2, iStringCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getChatRoomInfo(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(86, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getChatRoomInfo(str, i, i2, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getChatroomHistoryMessages(String str, long j, int i, int i2, IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iChatRoomHistoryMessageCallback != null ? iChatRoomHistoryMessageCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(32, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().getChatroomHistoryMessages(str, j, i, i2, iChatRoomHistoryMessageCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public Conversation getConversation(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(57, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversation(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getConversationDraft(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(60, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversationDraft(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Conversation> getConversationList() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(51, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversationList();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getConversationListByBatch(int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iGetConversationListWithProcessCallback != null ? iGetConversationListWithProcessCallback.asBinder() : null);
                    if (this.mRemote.transact(52, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getConversationListByBatch(i, iGetConversationListWithProcessCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Conversation> getConversationListByPage(int[] iArr, long j, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(55, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversationListByPage(iArr, j, i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Conversation> getConversationListByType(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(53, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversationListByType(iArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getConversationListOfTypesByBatch(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iGetConversationListWithProcessCallback != null ? iGetConversationListWithProcessCallback.asBinder() : null);
                    if (this.mRemote.transact(54, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getConversationListOfTypesByBatch(iArr, i, iGetConversationListWithProcessCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getConversationNotificationStatus(int i, String str, ILongCallback iLongCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLongCallback != null ? iLongCallback.asBinder() : null);
                    if (this.mRemote.transact(62, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getConversationNotificationStatus(i, str, iLongCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getConversationUnreadCount(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(65, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getConversationUnreadCount(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getCurrentUserId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(122, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentUserId();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public long getDeltaTime() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(106, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDeltaTime();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getDiscussion(String str, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(77, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getDiscussion(str, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public RCEncryptedSession getEncryptedConversation(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(72, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEncryptedConversation(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? RCEncryptedSession.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean getFileDownloadingStatus(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(103, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFileDownloadingStatus(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getGIFLimitSize() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(148, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGIFLimitSize();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // io.rong.imlib.IHandler
            public boolean getJoinMultiChatRoomEnable() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(137, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getJoinMultiChatRoomEnable();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getMatchedMessages(String str, int i, long j, int i2, int i3) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    try {
                        if (!this.mRemote.transact(133, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<Message> matchedMessages = Stub.getDefaultImpl().getMatchedMessages(str, i, j, i2, i3);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return matchedMessages;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(Message.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public Message getMessage(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMessage(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Message.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public Message getMessageByUid(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(49, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMessageByUid(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Message.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getMessageCount(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMessageCount(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public long getNaviCachedTime() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(136, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNaviCachedTime();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getNewestMessages(Conversation conversation, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(25, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getNewestMessages(conversation, i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Message.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getNotificationQuietHours(IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iGetNotificationQuietHoursCallback != null ? iGetNotificationQuietHoursCallback.asBinder() : null);
                    if (this.mRemote.transact(69, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getNotificationQuietHours(iGetNotificationQuietHoursCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getOffLineLogServer() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(182, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOffLineLogServer();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getOfflineMessageDuration() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(138, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOfflineMessageDuration();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getOlderMessages(Conversation conversation, long j, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(26, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOlderMessages(conversation, j, i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Message.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getOlderMessagesByObjectName(Conversation conversation, String str, long j, int i, boolean z) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i2 = 1;
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (!z) {
                        i2 = 0;
                    }
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.mRemote.transact(39, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<Message> olderMessagesByObjectName = Stub.getDefaultImpl().getOlderMessagesByObjectName(conversation, str, j, i, z);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return olderMessagesByObjectName;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(Message.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getOlderMessagesByObjectNames(Conversation conversation, List<String> list, long j, int i, boolean z) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i2 = 1;
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (!z) {
                        i2 = 0;
                    }
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.mRemote.transact(40, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<Message> olderMessagesByObjectNames = Stub.getDefaultImpl().getOlderMessagesByObjectNames(conversation, list, j, i, z);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return olderMessagesByObjectNames;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(Message.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getOlderMessagesOneWay(Conversation conversation, long j, int i, OnGetHistoryMessagesCallback onGetHistoryMessagesCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(onGetHistoryMessagesCallback != null ? onGetHistoryMessagesCallback.asBinder() : null);
                    if (this.mRemote.transact(27, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().getOlderMessagesOneWay(conversation, j, i, onGetHistoryMessagesCallback);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getPublicServiceList(IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(94, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getPublicServiceList(iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getPublicServiceProfile(String str, int i, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(93, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getPublicServiceProfile(str, i, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getPushSetting(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(38, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPushSetting(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRTCConfig(String str, String str2, long j, String str3, IRTCConfigCallback iRTCConfigCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iRTCConfigCallback != null ? iRTCConfigCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(166, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().getRTCConfig(str, str2, j, str3, iRTCConfigCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getRTCProfile() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(152, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRTCProfile();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRTCToken(String str, int i, int i2, IStringCallback iStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iStringCallback != null ? iStringCallback.asBinder() : null);
                    if (this.mRemote.transact(167, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRTCToken(str, i, i2, iStringCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRTCUserData(String str, int i, RTCDataListener rTCDataListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(rTCDataListener != null ? rTCDataListener.asBinder() : null);
                    if (this.mRemote.transact(156, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRTCUserData(str, i, rTCDataListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRTCUserDatas(String str, String[] strArr, RTCDataListener rTCDataListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(rTCDataListener != null ? rTCDataListener.asBinder() : null);
                    if (this.mRemote.transact(172, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRTCUserDatas(str, strArr, rTCDataListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRTCUsers(String str, int i, RTCDataListener rTCDataListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(rTCDataListener != null ? rTCDataListener.asBinder() : null);
                    if (this.mRemote.transact(155, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRTCUsers(str, i, rTCDataListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRemoteHistoryMessages(Conversation conversation, long j, int i, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(28, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRemoteHistoryMessages(conversation, j, i, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getRemoteHistoryMessagesOption(Conversation conversation, RemoteHistoryMsgOption remoteHistoryMsgOption, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (remoteHistoryMsgOption != null) {
                        parcelObtain.writeInt(1);
                        remoteHistoryMsgOption.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(29, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getRemoteHistoryMessagesOption(conversation, remoteHistoryMsgOption, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public long getSendTimeByMessageId(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(119, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSendTimeByMessageId(i);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getTextMessageDraft(Conversation conversation) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(111, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTextMessageDraft(conversation);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public Message getTheFirstUnreadMessage(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(141, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTheFirstUnreadMessage(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Message.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getTopConversationList(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iGetConversationListWithProcessCallback != null ? iGetConversationListWithProcessCallback.asBinder() : null);
                    if (this.mRemote.transact(50, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getTopConversationList(iArr, i, iGetConversationListWithProcessCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getTotalUnreadCount() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTotalUnreadCount();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getUnreadCount(int[] iArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnreadCount(iArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getUnreadCountByConversation(Conversation[] conversationArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedArray(conversationArr, 0);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnreadCountByConversation(conversationArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getUnreadCountById(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnreadCountById(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getUnreadCountWithDND(int[] iArr, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnreadCountWithDND(iArr, z);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> getUnreadMentionedMessages(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(125, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUnreadMentionedMessages(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(Message.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getUploadLogConfigInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(181, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUploadLogConfigInfo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getUserStatus(String str, IGetUserStatusCallback iGetUserStatusCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGetUserStatusCallback != null ? iGetUserStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(33, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getUserStatus(str, iGetUserStatusCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getVendorToken(IStringCallback iStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iStringCallback != null ? iStringCallback.asBinder() : null);
                    if (this.mRemote.transact(134, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getVendorToken(iStringCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public int getVideoLimitTime() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(147, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVideoLimitTime();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public String getVoIPCallInfo() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(121, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVoIPCallInfo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void getVoIPKey(int i, String str, String str2, IStringCallback iStringCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iStringCallback != null ? iStringCallback.asBinder() : null);
                    if (this.mRemote.transact(120, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().getVoIPKey(i, str, str2, iStringCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void initAppendixModule() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().initAppendixModule();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void initHttpDns() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(151, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().initHttpDns();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void initIPCEnviroment(String str, int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    if (this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().initIPCEnviroment(str, i);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public Message insertMessage(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insertMessage(message);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Message.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public Message insertSettingMessage(Message message) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().insertSettingMessage(message);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Message.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean isDnsEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(174, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDnsEnabled();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean isPhrasesEnabled() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(173, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPhrasesEnabled();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void joinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(88, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().joinChatRoom(str, i, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void joinExistChatRoom(String str, int i, IOperationCallback iOperationCallback, boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(89, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().joinExistChatRoom(str, i, iOperationCallback, z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void joinGroup(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(84, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().joinGroup(str, str2, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void joinRTCRoomAndGetData(String str, int i, int i2, IRTCJoinRoomCallback iRTCJoinRoomCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iRTCJoinRoomCallback != null ? iRTCJoinRoomCallback.asBinder() : null);
                    if (this.mRemote.transact(165, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().joinRTCRoomAndGetData(str, i, i2, iRTCJoinRoomCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void notifyAppBackgroundChanged(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(183, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().notifyAppBackgroundChanged(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void pauseTransferMediaFile(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(102, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseTransferMediaFile(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void pauseTransferMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(101, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().pauseTransferMediaMessage(message, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void quitChatRoom(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(90, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().quitChatRoom(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void quitDiscussion(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(82, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().quitDiscussion(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void quitGroup(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(85, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().quitGroup(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void reJoinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(87, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().reJoinChatRoom(str, i, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void recallMessage(String str, byte[] bArr, String str2, int i, String str3, int i2, boolean z, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(108, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().recallMessage(str, bArr, str2, i, str3, i2, z, iOperationCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void registerCmdMsgType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(127, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCmdMsgType(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void registerCmdMsgTypes(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(128, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerCmdMsgTypes(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void registerDeleteMessageType(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(129, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerDeleteMessageType(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void registerMessageType(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerMessageType(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void registerMessageTypes(List<String> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    if (this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerMessageTypes(list);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean removeConversation(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(58, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeConversation(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void removeDiscussionMember(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(81, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeDiscussionMember(str, str2, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean removeEncryptedConversation(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(74, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().removeEncryptedConversation(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void removeFromBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(110, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeFromBlacklist(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void removeMessageAllExpansion(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(188, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeMessageAllExpansion(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void removeMessageExpansion(List<String> list, String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(187, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeMessageExpansion(list, str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void removeNotificationQuietHours(IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(68, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().removeNotificationQuietHours(iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcDeleteInnerData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(161, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        Stub.getDefaultImpl().rtcDeleteInnerData(str, i, strArr, str2, str3, iOperationCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcDeleteOuterData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(162, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        Stub.getDefaultImpl().rtcDeleteOuterData(str, i, strArr, str2, str3, iOperationCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcGetInnerData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(iRtcIODataListener != null ? iRtcIODataListener.asBinder() : null);
                    if (this.mRemote.transact(163, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().rtcGetInnerData(str, i, strArr, iRtcIODataListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcGetOuterData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(iRtcIODataListener != null ? iRtcIODataListener.asBinder() : null);
                    if (this.mRemote.transact(164, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().rtcGetOuterData(str, i, strArr, iRtcIODataListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcPutInnerData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(159, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().rtcPutInnerData(str, i, str2, str3, str4, str5, iOperationCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcPutOuterData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeString(str5);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(160, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().rtcPutOuterData(str, i, str2, str3, str4, str5, iOperationCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void rtcSetUserResource(String str, RTCStatusDate[] rTCStatusDateArr, String str2, RTCStatusDate[] rTCStatusDateArr2, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeTypedArray(rTCStatusDateArr, 0);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedArray(rTCStatusDateArr2, 0);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(184, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().rtcSetUserResource(str, rTCStatusDateArr, str2, rTCStatusDateArr2, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean saveConversationDraft(Conversation conversation, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(59, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().saveConversationDraft(conversation, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean saveTextMessageDraft(Conversation conversation, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (conversation != null) {
                        parcelObtain.writeInt(1);
                        conversation.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(112, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().saveTextMessageDraft(conversation, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<SearchConversationResult> searchConversations(String str, int[] iArr, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeStringArray(strArr);
                    if (!this.mRemote.transact(132, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().searchConversations(str, iArr, strArr);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(SearchConversationResult.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> searchMessages(String str, int i, String str2, int i2, long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.mRemote.transact(130, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<Message> listSearchMessages = Stub.getDefaultImpl().searchMessages(str, i, str2, i2, j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return listSearchMessages;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(Message.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public List<Message> searchMessagesByUser(String str, int i, String str2, int i2, long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.mRemote.transact(131, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                            List<Message> listSearchMessagesByUser = Stub.getDefaultImpl().searchMessagesByUser(str, i, str2, i2, j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return listSearchMessagesByUser;
                        }
                        parcelObtain2.readException();
                        ArrayList arrayListCreateTypedArrayList = parcelObtain2.createTypedArrayList(Message.CREATOR);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return arrayListCreateTypedArrayList;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void searchPublicService(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iResultCallback != null ? iResultCallback.asBinder() : null);
                    if (this.mRemote.transact(91, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().searchPublicService(str, i, i2, iResultCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSendMediaMessageCallback != null ? iSendMediaMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(23, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendDirectionalMediaMessage(message, strArr, str, str2, iSendMediaMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendDirectionalMessage(Message message, String str, String str2, String[] strArr, ISendMessageCallback iSendMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeStrongBinder(iSendMessageCallback != null ? iSendMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(21, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendDirectionalMessage(message, str, str2, strArr, iSendMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendLocationMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSendMessageCallback != null ? iSendMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(24, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendLocationMessage(message, str, str2, iSendMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendMediaMessage(Message message, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSendMediaMessageCallback != null ? iSendMediaMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(22, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendMediaMessage(message, str, str2, iSendMediaMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iSendMessageCallback != null ? iSendMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendMessage(message, str, str2, iSendMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, ISendMessageCallback iSendMessageCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (sendMessageOption != null) {
                        parcelObtain.writeInt(1);
                        sendMessageOption.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iSendMessageCallback != null ? iSendMessageCallback.asBinder() : null);
                    if (this.mRemote.transact(20, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendMessageOption(message, str, str2, sendMessageOption, iSendMessageCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendPing() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(144, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().sendPing();
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendRTCDirectionalMessage(Message message, String str, String str2, String[] strArr, SendMessageOption sendMessageOption, boolean z, ISendMessageCallback iSendMessageCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    int i = 1;
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    if (sendMessageOption != null) {
                        parcelObtain.writeInt(1);
                        sendMessageOption.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iSendMessageCallback != null ? iSendMessageCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(175, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().sendRTCDirectionalMessage(message, str, str2, strArr, sendMessageOption, z, iSendMessageCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void sendRTCPing(String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(157, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().sendRTCPing(str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    int i = 1;
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str4);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!z3) {
                        i = 0;
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    try {
                        if (this.mRemote.transact(176, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().setChatRoomEntry(str, str2, str3, z, str4, z2, z3, iOperationCallback);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setConnectionStatusListener(IConnectionStatusListener iConnectionStatusListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iConnectionStatusListener != null ? iConnectionStatusListener.asBinder() : null);
                    if (this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setConnectionStatusListener(iConnectionStatusListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setConversationNotificationStatus(int i, String str, int i2, ILongCallback iLongCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iLongCallback != null ? iLongCallback.asBinder() : null);
                    if (this.mRemote.transact(63, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setConversationNotificationStatus(i, str, i2, iLongCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setConversationStatusListener(ConversationStatusListener conversationStatusListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(conversationStatusListener != null ? conversationStatusListener.asBinder() : null);
                    if (this.mRemote.transact(150, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setConversationStatusListener(conversationStatusListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setConversationTopStatus(int i, String str, boolean z, boolean z2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    if (!this.mRemote.transact(64, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setConversationTopStatus(i, str, z, z2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setDiscussionInviteStatus(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(107, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setDiscussionInviteStatus(str, i, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setDiscussionName(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(78, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setDiscussionName(str, str2, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (rCEncryptedSession != null) {
                        parcelObtain.writeInt(1);
                        rCEncryptedSession.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(73, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setEncryptedConversation(str, rCEncryptedSession);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setIpcConnectTimeOut() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setIpcConnectTimeOut();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setKvStatusListener(KVStatusDataByBatchListener kVStatusDataByBatchListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(kVStatusDataByBatchListener != null ? kVStatusDataByBatchListener.asBinder() : null);
                    if (this.mRemote.transact(185, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setKvStatusListener(kVStatusDataByBatchListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setMessageContent(int i, byte[] bArr, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(124, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMessageContent(i, bArr, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setMessageExpansionListener(IMessageExpansionListener iMessageExpansionListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMessageExpansionListener != null ? iMessageExpansionListener.asBinder() : null);
                    if (this.mRemote.transact(189, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setMessageExpansionListener(iMessageExpansionListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setMessageExtra(int i, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(46, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMessageExtra(i, str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setMessageReadTime(long j, long j2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    if (!this.mRemote.transact(142, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMessageReadTime(j, j2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setMessageReceivedStatus(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(47, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMessageReceivedStatus(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean setMessageSentStatus(int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    if (!this.mRemote.transact(48, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setMessageSentStatus(i, i2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setNaviContentUpdateListener(INaviContentUpdateCallBack iNaviContentUpdateCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iNaviContentUpdateCallBack != null ? iNaviContentUpdateCallBack.asBinder() : null);
                    if (this.mRemote.transact(180, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setNaviContentUpdateListener(iNaviContentUpdateCallBack);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setNotificationQuietHours(String str, int i, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(67, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setNotificationQuietHours(str, i, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setOfflineMessageDuration(String str, ILongCallback iLongCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iLongCallback != null ? iLongCallback.asBinder() : null);
                    if (this.mRemote.transact(139, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setOfflineMessageDuration(str, iLongCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setOnReceiveMessageListener(OnReceiveMessageListener onReceiveMessageListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(onReceiveMessageListener != null ? onReceiveMessageListener.asBinder() : null);
                    if (this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setOnReceiveMessageListener(onReceiveMessageListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setPushSetting(int i, String str, ISetPushSettingCallback iSetPushSettingCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iSetPushSettingCallback != null ? iSetPushSettingCallback.asBinder() : null);
                    if (this.mRemote.transact(37, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setPushSetting(i, str, iSetPushSettingCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setRLogOtherProgressCallback(IRLogOtherProgressCallback iRLogOtherProgressCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iRLogOtherProgressCallback != null ? iRLogOtherProgressCallback.asBinder() : null);
                    if (this.mRemote.transact(168, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setRLogOtherProgressCallback(iRLogOtherProgressCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setRTCUserData(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(169, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setRTCUserData(str, str2, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setRTCUserDatas(String str, int i, Map map, String str2, String str3, IOperationCallback iOperationCallback) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(171, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        Stub.getDefaultImpl().setRTCUserDatas(str, i, map, str2, str3, iOperationCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setReconnectKickEnable(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(146, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setReconnectKickEnable(z);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setServerInfo(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(123, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setServerInfo(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setSubscribeStatusListener(ISubscribeUserStatusCallback iSubscribeUserStatusCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iSubscribeUserStatusCallback != null ? iSubscribeUserStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(36, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setSubscribeStatusListener(iSubscribeUserStatusCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setUserData(UserData userData, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (userData != null) {
                        parcelObtain.writeInt(1);
                        userData.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(116, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setUserData(userData, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setUserPolicy(boolean z) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(145, parcelObtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().setUserPolicy(z);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setUserProfileListener(UserProfileSettingListener userProfileSettingListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(userProfileSettingListener != null ? userProfileSettingListener.asBinder() : null);
                    if (this.mRemote.transact(149, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setUserProfileListener(userProfileSettingListener);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void setUserStatus(int i, ISetUserStatusCallback iSetUserStatusCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iSetUserStatusCallback != null ? iSetUserStatusCallback.asBinder() : null);
                    if (this.mRemote.transact(34, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setUserStatus(i, iSetUserStatusCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void solveServerHosts(String str, ISolveServerHostsCallBack iSolveServerHostsCallBack) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iSolveServerHostsCallBack != null ? iSolveServerHostsCallBack.asBinder() : null);
                    if (this.mRemote.transact(170, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().solveServerHosts(str, iSolveServerHostsCallBack);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void subscribePublicService(String str, int i, boolean z, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(92, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().subscribePublicService(str, i, z, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void subscribeStatus(List<String> list, IIntegerCallback iIntegerCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeStringList(list);
                    parcelObtain.writeStrongBinder(iIntegerCallback != null ? iIntegerCallback.asBinder() : null);
                    if (this.mRemote.transact(35, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().subscribeStatus(list, iIntegerCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean supportResumeBrokenTransfer(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(104, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().supportResumeBrokenTransfer(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void switchAppKey(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (this.mRemote.transact(140, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().switchAppKey(str, str2);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void syncGroup(List<Group> list, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeTypedList(list);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(83, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().syncGroup(list, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean updateConversationInfo(int i, String str, String str2, String str3) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    if (!this.mRemote.transact(70, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateConversationInfo(i, str, str2, str3);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void updateMessageExpansion(Map map, String str, IOperationCallback iOperationCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iOperationCallback != null ? iOperationCallback.asBinder() : null);
                    if (this.mRemote.transact(186, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateMessageExpansion(map, str, iOperationCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean updateMessageReceiptStatus(String str, int i, long j) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    if (!this.mRemote.transact(117, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateMessageReceiptStatus(str, i, j);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean updateReadReceiptRequestInfo(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.mRemote.transact(126, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateReadReceiptRequestInfo(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void updateVoIPCallInfo(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(153, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().updateVoIPCallInfo(str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void uploadMedia(Message message, IUploadCallback iUploadCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (message != null) {
                        parcelObtain.writeInt(1);
                        message.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(iUploadCallback != null ? iUploadCallback.asBinder() : null);
                    if (this.mRemote.transact(95, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        Stub.getDefaultImpl().uploadMedia(message, iUploadCallback);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public boolean useRTCOnly() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(158, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().useRTCOnly();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // io.rong.imlib.IHandler
            public void writeFwLog(int i, String str, String str2, String str3, long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeLong(j);
                    try {
                        if (this.mRemote.transact(135, parcelObtain, parcelObtain2, 0) || Stub.getDefaultImpl() == null) {
                            parcelObtain2.readException();
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        } else {
                            Stub.getDefaultImpl().writeFwLog(i, str, str2, str3, j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                        }
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IHandler)) ? new Proxy(iBinder) : (IHandler) iInterfaceQueryLocalInterface;
        }

        public static IHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IHandler iHandler) {
            if (Proxy.sDefaultImpl != null || iHandler == null) {
                return false;
            }
            Proxy.sDefaultImpl = iHandler;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    initAppendixModule();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    connect(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, IConnectStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    disconnect(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMessageType(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMessageTypes(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int totalUnreadCount = getTotalUnreadCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(totalUnreadCount);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    int unreadCountByConversation = getUnreadCountByConversation((Conversation[]) parcel.createTypedArray(Conversation.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(unreadCountByConversation);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int unreadCount = getUnreadCount(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(unreadCount);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int unreadCountWithDND = getUnreadCountWithDND(parcel.createIntArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(unreadCountWithDND);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int unreadCountById = getUnreadCountById(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(unreadCountById);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int messageCount = getMessageCount(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageCount);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    setOnReceiveMessageListener(OnReceiveMessageListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    setConnectionStatusListener(IConnectionStatusListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIpcConnectTimeOut();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    initIPCEnviroment(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    Message message = getMessage(parcel.readInt());
                    parcel2.writeNoException();
                    if (message != null) {
                        parcel2.writeInt(1);
                        message.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    Message messageInsertMessage = insertMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (messageInsertMessage != null) {
                        parcel2.writeInt(1);
                        messageInsertMessage.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    Message messageInsertSettingMessage = insertSettingMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (messageInsertSettingMessage != null) {
                        parcel2.writeInt(1);
                        messageInsertSettingMessage.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), ISendMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendMessageOption(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? SendMessageOption.CREATOR.createFromParcel(parcel) : null, ISendMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendDirectionalMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.createStringArray(), ISendMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), ISendMediaMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendDirectionalMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.createStringArray(), parcel.readString(), parcel.readString(), ISendMediaMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendLocationMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), ISendMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> newestMessages = getNewestMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(newestMessages);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> olderMessages = getOlderMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(olderMessages);
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    getOlderMessagesOneWay(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readInt(), OnGetHistoryMessagesCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRemoteHistoryMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readInt(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRemoteHistoryMessagesOption(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? RemoteHistoryMsgOption.CREATOR.createFromParcel(parcel) : null, IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    cleanRemoteHistoryMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    cleanHistoryMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    getChatroomHistoryMessages(parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt(), IChatRoomHistoryMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    getUserStatus(parcel.readString(), IGetUserStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserStatus(parcel.readInt(), ISetUserStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    subscribeStatus(parcel.createStringArrayList(), IIntegerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSubscribeStatusListener(ISubscribeUserStatusCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    setPushSetting(parcel.readInt(), parcel.readString(), ISetPushSettingCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    String pushSetting = getPushSetting(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(pushSetting);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> olderMessagesByObjectName = getOlderMessagesByObjectName(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(olderMessagesByObjectName);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> olderMessagesByObjectNames = getOlderMessagesByObjectNames(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.createStringArrayList(), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeTypedList(olderMessagesByObjectNames);
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDeleteMessage = deleteMessage(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDeleteMessage ? 1 : 0);
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    deleteMessages(parcel.readInt(), parcel.readString(), (Message[]) parcel.createTypedArray(Message.CREATOR), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDeleteConversationMessage = deleteConversationMessage(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDeleteConversationMessage ? 1 : 0);
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearMessages = clearMessages(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearMessages ? 1 : 0);
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearMessagesUnreadStatus = clearMessagesUnreadStatus(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearMessagesUnreadStatus ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean messageExtra = setMessageExtra(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageExtra ? 1 : 0);
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean messageReceivedStatus = setMessageReceivedStatus(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageReceivedStatus ? 1 : 0);
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean messageSentStatus = setMessageSentStatus(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageSentStatus ? 1 : 0);
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    Message messageByUid = getMessageByUid(parcel.readString());
                    parcel2.writeNoException();
                    if (messageByUid != null) {
                        parcel2.writeInt(1);
                        messageByUid.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    getTopConversationList(parcel.createIntArray(), parcel.readInt(), IGetConversationListWithProcessCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Conversation> conversationList = getConversationList();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(conversationList);
                    return true;
                case 52:
                    parcel.enforceInterface(DESCRIPTOR);
                    getConversationListByBatch(parcel.readInt(), IGetConversationListWithProcessCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Conversation> conversationListByType = getConversationListByType(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(conversationListByType);
                    return true;
                case 54:
                    parcel.enforceInterface(DESCRIPTOR);
                    getConversationListOfTypesByBatch(parcel.createIntArray(), parcel.readInt(), IGetConversationListWithProcessCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 55:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Conversation> conversationListByPage = getConversationListByPage(parcel.createIntArray(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(conversationListByPage);
                    return true;
                case 56:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Conversation> blockedConversationList = getBlockedConversationList(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(blockedConversationList);
                    return true;
                case 57:
                    parcel.enforceInterface(DESCRIPTOR);
                    Conversation conversation = getConversation(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (conversation != null) {
                        parcel2.writeInt(1);
                        conversation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 58:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRemoveConversation = removeConversation(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRemoveConversation ? 1 : 0);
                    return true;
                case 59:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zSaveConversationDraft = saveConversationDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSaveConversationDraft ? 1 : 0);
                    return true;
                case 60:
                    parcel.enforceInterface(DESCRIPTOR);
                    String conversationDraft = getConversationDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(conversationDraft);
                    return true;
                case 61:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCleanConversationDraft = cleanConversationDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zCleanConversationDraft ? 1 : 0);
                    return true;
                case 62:
                    parcel.enforceInterface(DESCRIPTOR);
                    getConversationNotificationStatus(parcel.readInt(), parcel.readString(), ILongCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 63:
                    parcel.enforceInterface(DESCRIPTOR);
                    setConversationNotificationStatus(parcel.readInt(), parcel.readString(), parcel.readInt(), ILongCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 64:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean conversationTopStatus = setConversationTopStatus(parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(conversationTopStatus ? 1 : 0);
                    return true;
                case 65:
                    parcel.enforceInterface(DESCRIPTOR);
                    int conversationUnreadCount = getConversationUnreadCount(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(conversationUnreadCount);
                    return true;
                case 66:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearConversations = clearConversations(parcel.createIntArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearConversations ? 1 : 0);
                    return true;
                case 67:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNotificationQuietHours(parcel.readString(), parcel.readInt(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 68:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeNotificationQuietHours(IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 69:
                    parcel.enforceInterface(DESCRIPTOR);
                    getNotificationQuietHours(IGetNotificationQuietHoursCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 70:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateConversationInfo = updateConversationInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateConversationInfo ? 1 : 0);
                    return true;
                case 71:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCreateEncryptedConversation = createEncryptedConversation(parcel.readString(), parcel.readInt() != 0 ? RCEncryptedSession.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zCreateEncryptedConversation ? 1 : 0);
                    return true;
                case 72:
                    parcel.enforceInterface(DESCRIPTOR);
                    RCEncryptedSession encryptedConversation = getEncryptedConversation(parcel.readString());
                    parcel2.writeNoException();
                    if (encryptedConversation != null) {
                        parcel2.writeInt(1);
                        encryptedConversation.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 73:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean encryptedConversation2 = setEncryptedConversation(parcel.readString(), parcel.readInt() != 0 ? RCEncryptedSession.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(encryptedConversation2 ? 1 : 0);
                    return true;
                case 74:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zRemoveEncryptedConversation = removeEncryptedConversation(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zRemoveEncryptedConversation ? 1 : 0);
                    return true;
                case 75:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearEncryptedConversations = clearEncryptedConversations();
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearEncryptedConversations ? 1 : 0);
                    return true;
                case 76:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<RCEncryptedSession> allEncryptedConversations = getAllEncryptedConversations();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(allEncryptedConversations);
                    return true;
                case 77:
                    parcel.enforceInterface(DESCRIPTOR);
                    getDiscussion(parcel.readString(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 78:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDiscussionName(parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 79:
                    parcel.enforceInterface(DESCRIPTOR);
                    createDiscussion(parcel.readString(), parcel.createStringArrayList(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 80:
                    parcel.enforceInterface(DESCRIPTOR);
                    addMemberToDiscussion(parcel.readString(), parcel.createStringArrayList(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 81:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeDiscussionMember(parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 82:
                    parcel.enforceInterface(DESCRIPTOR);
                    quitDiscussion(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 83:
                    parcel.enforceInterface(DESCRIPTOR);
                    syncGroup(parcel.createTypedArrayList(Group.CREATOR), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 84:
                    parcel.enforceInterface(DESCRIPTOR);
                    joinGroup(parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 85:
                    parcel.enforceInterface(DESCRIPTOR);
                    quitGroup(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 86:
                    parcel.enforceInterface(DESCRIPTOR);
                    getChatRoomInfo(parcel.readString(), parcel.readInt(), parcel.readInt(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 87:
                    parcel.enforceInterface(DESCRIPTOR);
                    reJoinChatRoom(parcel.readString(), parcel.readInt(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 88:
                    parcel.enforceInterface(DESCRIPTOR);
                    joinChatRoom(parcel.readString(), parcel.readInt(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 89:
                    parcel.enforceInterface(DESCRIPTOR);
                    joinExistChatRoom(parcel.readString(), parcel.readInt(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 90:
                    parcel.enforceInterface(DESCRIPTOR);
                    quitChatRoom(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 91:
                    parcel.enforceInterface(DESCRIPTOR);
                    searchPublicService(parcel.readString(), parcel.readInt(), parcel.readInt(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 92:
                    parcel.enforceInterface(DESCRIPTOR);
                    subscribePublicService(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 93:
                    parcel.enforceInterface(DESCRIPTOR);
                    getPublicServiceProfile(parcel.readString(), parcel.readInt(), IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 94:
                    parcel.enforceInterface(DESCRIPTOR);
                    getPublicServiceList(IResultCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 95:
                    parcel.enforceInterface(DESCRIPTOR);
                    uploadMedia(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, IUploadCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 96:
                    parcel.enforceInterface(DESCRIPTOR);
                    downloadMedia(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readString(), IDownloadMediaCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 97:
                    parcel.enforceInterface(DESCRIPTOR);
                    downloadMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, IDownloadMediaMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 98:
                    parcel.enforceInterface(DESCRIPTOR);
                    downloadMediaFile(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), IDownloadMediaFileCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 99:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelSendMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 100:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownloadMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 101:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseTransferMediaMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 102:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseTransferMediaFile(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 103:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean fileDownloadingStatus = getFileDownloadingStatus(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(fileDownloadingStatus ? 1 : 0);
                    return true;
                case 104:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zSupportResumeBrokenTransfer = supportResumeBrokenTransfer(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSupportResumeBrokenTransfer ? 1 : 0);
                    return true;
                case 105:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelAllDownloadMediaMessage(IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 106:
                    parcel.enforceInterface(DESCRIPTOR);
                    long deltaTime = getDeltaTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(deltaTime);
                    return true;
                case 107:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDiscussionInviteStatus(parcel.readString(), parcel.readInt(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 108:
                    parcel.enforceInterface(DESCRIPTOR);
                    recallMessage(parcel.readString(), parcel.createByteArray(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 109:
                    parcel.enforceInterface(DESCRIPTOR);
                    addToBlacklist(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 110:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeFromBlacklist(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 111:
                    parcel.enforceInterface(DESCRIPTOR);
                    String textMessageDraft = getTextMessageDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeString(textMessageDraft);
                    return true;
                case 112:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zSaveTextMessageDraft = saveTextMessageDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSaveTextMessageDraft ? 1 : 0);
                    return true;
                case 113:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearTextMessageDraft = clearTextMessageDraft(parcel.readInt() != 0 ? Conversation.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearTextMessageDraft ? 1 : 0);
                    return true;
                case 114:
                    parcel.enforceInterface(DESCRIPTOR);
                    getBlacklist(IStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 115:
                    parcel.enforceInterface(DESCRIPTOR);
                    getBlacklistStatus(parcel.readString(), IIntegerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 116:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserData(parcel.readInt() != 0 ? UserData.CREATOR.createFromParcel(parcel) : null, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 117:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateMessageReceiptStatus = updateMessageReceiptStatus(parcel.readString(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateMessageReceiptStatus ? 1 : 0);
                    return true;
                case 118:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zClearUnreadByReceipt = clearUnreadByReceipt(parcel.readInt(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearUnreadByReceipt ? 1 : 0);
                    return true;
                case 119:
                    parcel.enforceInterface(DESCRIPTOR);
                    long sendTimeByMessageId = getSendTimeByMessageId(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(sendTimeByMessageId);
                    return true;
                case 120:
                    parcel.enforceInterface(DESCRIPTOR);
                    getVoIPKey(parcel.readInt(), parcel.readString(), parcel.readString(), IStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 121:
                    parcel.enforceInterface(DESCRIPTOR);
                    String voIPCallInfo = getVoIPCallInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(voIPCallInfo);
                    return true;
                case 122:
                    parcel.enforceInterface(DESCRIPTOR);
                    String currentUserId = getCurrentUserId();
                    parcel2.writeNoException();
                    parcel2.writeString(currentUserId);
                    return true;
                case 123:
                    parcel.enforceInterface(DESCRIPTOR);
                    setServerInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 124:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean messageContent = setMessageContent(parcel.readInt(), parcel.createByteArray(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageContent ? 1 : 0);
                    return true;
                case 125:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> unreadMentionedMessages = getUnreadMentionedMessages(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(unreadMentionedMessages);
                    return true;
                case 126:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUpdateReadReceiptRequestInfo = updateReadReceiptRequestInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zUpdateReadReceiptRequestInfo ? 1 : 0);
                    return true;
                case 127:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCmdMsgType(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 128:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCmdMsgTypes(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 129:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDeleteMessageType(parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 130:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> listSearchMessages = searchMessages(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listSearchMessages);
                    return true;
                case 131:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> listSearchMessagesByUser = searchMessagesByUser(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listSearchMessagesByUser);
                    return true;
                case 132:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<SearchConversationResult> listSearchConversations = searchConversations(parcel.readString(), parcel.createIntArray(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(listSearchConversations);
                    return true;
                case 133:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Message> matchedMessages = getMatchedMessages(parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(matchedMessages);
                    return true;
                case 134:
                    parcel.enforceInterface(DESCRIPTOR);
                    getVendorToken(IStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 135:
                    parcel.enforceInterface(DESCRIPTOR);
                    writeFwLog(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 136:
                    parcel.enforceInterface(DESCRIPTOR);
                    long naviCachedTime = getNaviCachedTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(naviCachedTime);
                    return true;
                case 137:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean joinMultiChatRoomEnable = getJoinMultiChatRoomEnable();
                    parcel2.writeNoException();
                    parcel2.writeInt(joinMultiChatRoomEnable ? 1 : 0);
                    return true;
                case 138:
                    parcel.enforceInterface(DESCRIPTOR);
                    String offlineMessageDuration = getOfflineMessageDuration();
                    parcel2.writeNoException();
                    parcel2.writeString(offlineMessageDuration);
                    return true;
                case 139:
                    parcel.enforceInterface(DESCRIPTOR);
                    setOfflineMessageDuration(parcel.readString(), ILongCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 140:
                    parcel.enforceInterface(DESCRIPTOR);
                    switchAppKey(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 141:
                    parcel.enforceInterface(DESCRIPTOR);
                    Message theFirstUnreadMessage = getTheFirstUnreadMessage(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (theFirstUnreadMessage != null) {
                        parcel2.writeInt(1);
                        theFirstUnreadMessage.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 142:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean messageReadTime = setMessageReadTime(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(messageReadTime ? 1 : 0);
                    return true;
                case 143:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelSDKHeartBeat();
                    return true;
                case 144:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendPing();
                    return true;
                case 145:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserPolicy(parcel.readInt() != 0);
                    return true;
                case 146:
                    parcel.enforceInterface(DESCRIPTOR);
                    setReconnectKickEnable(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 147:
                    parcel.enforceInterface(DESCRIPTOR);
                    int videoLimitTime = getVideoLimitTime();
                    parcel2.writeNoException();
                    parcel2.writeInt(videoLimitTime);
                    return true;
                case 148:
                    parcel.enforceInterface(DESCRIPTOR);
                    int gIFLimitSize = getGIFLimitSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(gIFLimitSize);
                    return true;
                case 149:
                    parcel.enforceInterface(DESCRIPTOR);
                    setUserProfileListener(UserProfileSettingListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 150:
                    parcel.enforceInterface(DESCRIPTOR);
                    setConversationStatusListener(ConversationStatusListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 151:
                    parcel.enforceInterface(DESCRIPTOR);
                    initHttpDns();
                    parcel2.writeNoException();
                    return true;
                case 152:
                    parcel.enforceInterface(DESCRIPTOR);
                    String rTCProfile = getRTCProfile();
                    parcel2.writeNoException();
                    parcel2.writeString(rTCProfile);
                    return true;
                case 153:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateVoIPCallInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 154:
                    parcel.enforceInterface(DESCRIPTOR);
                    exitRTCRoom(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 155:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRTCUsers(parcel.readString(), parcel.readInt(), RTCDataListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 156:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRTCUserData(parcel.readString(), parcel.readInt(), RTCDataListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 157:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendRTCPing(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 158:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zUseRTCOnly = useRTCOnly();
                    parcel2.writeNoException();
                    parcel2.writeInt(zUseRTCOnly ? 1 : 0);
                    return true;
                case 159:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcPutInnerData(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 160:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcPutOuterData(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 161:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcDeleteInnerData(parcel.readString(), parcel.readInt(), parcel.createStringArray(), parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 162:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcDeleteOuterData(parcel.readString(), parcel.readInt(), parcel.createStringArray(), parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 163:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcGetInnerData(parcel.readString(), parcel.readInt(), parcel.createStringArray(), IRtcIODataListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 164:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcGetOuterData(parcel.readString(), parcel.readInt(), parcel.createStringArray(), IRtcIODataListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 165:
                    parcel.enforceInterface(DESCRIPTOR);
                    joinRTCRoomAndGetData(parcel.readString(), parcel.readInt(), parcel.readInt(), IRTCJoinRoomCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 166:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRTCConfig(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), IRTCConfigCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 167:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRTCToken(parcel.readString(), parcel.readInt(), parcel.readInt(), IStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 168:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRLogOtherProgressCallback(IRLogOtherProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 169:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRTCUserData(parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 170:
                    parcel.enforceInterface(DESCRIPTOR);
                    solveServerHosts(parcel.readString(), ISolveServerHostsCallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 171:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRTCUserDatas(parcel.readString(), parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()), parcel.readString(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 172:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRTCUserDatas(parcel.readString(), parcel.createStringArray(), RTCDataListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 173:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsPhrasesEnabled = isPhrasesEnabled();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsPhrasesEnabled ? 1 : 0);
                    return true;
                case 174:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsDnsEnabled = isDnsEnabled();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsDnsEnabled ? 1 : 0);
                    return true;
                case 175:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendRTCDirectionalMessage(parcel.readInt() != 0 ? Message.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0 ? SendMessageOption.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, ISendMessageCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 176:
                    parcel.enforceInterface(DESCRIPTOR);
                    setChatRoomEntry(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 177:
                    parcel.enforceInterface(DESCRIPTOR);
                    getChatRoomEntry(parcel.readString(), parcel.readString(), IStringCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 178:
                    parcel.enforceInterface(DESCRIPTOR);
                    getAllChatRoomEntries(parcel.readString(), IDataByBatchListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 179:
                    parcel.enforceInterface(DESCRIPTOR);
                    deleteChatRoomEntry(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 180:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNaviContentUpdateListener(INaviContentUpdateCallBack.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 181:
                    parcel.enforceInterface(DESCRIPTOR);
                    String uploadLogConfigInfo = getUploadLogConfigInfo();
                    parcel2.writeNoException();
                    parcel2.writeString(uploadLogConfigInfo);
                    return true;
                case 182:
                    parcel.enforceInterface(DESCRIPTOR);
                    String offLineLogServer = getOffLineLogServer();
                    parcel2.writeNoException();
                    parcel2.writeString(offLineLogServer);
                    return true;
                case 183:
                    parcel.enforceInterface(DESCRIPTOR);
                    notifyAppBackgroundChanged(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 184:
                    parcel.enforceInterface(DESCRIPTOR);
                    rtcSetUserResource(parcel.readString(), (RTCStatusDate[]) parcel.createTypedArray(RTCStatusDate.CREATOR), parcel.readString(), (RTCStatusDate[]) parcel.createTypedArray(RTCStatusDate.CREATOR), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 185:
                    parcel.enforceInterface(DESCRIPTOR);
                    setKvStatusListener(KVStatusDataByBatchListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 186:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateMessageExpansion(parcel.readHashMap(getClass().getClassLoader()), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 187:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeMessageExpansion(parcel.createStringArrayList(), parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 188:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeMessageAllExpansion(parcel.readString(), IOperationCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 189:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMessageExpansionListener(IMessageExpansionListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void addMemberToDiscussion(String str, List<String> list, IOperationCallback iOperationCallback) throws RemoteException;

    void addToBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void cancelAllDownloadMediaMessage(IOperationCallback iOperationCallback) throws RemoteException;

    void cancelDownloadMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException;

    void cancelSDKHeartBeat() throws RemoteException;

    void cancelSendMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException;

    boolean cleanConversationDraft(Conversation conversation) throws RemoteException;

    void cleanHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException;

    void cleanRemoteHistoryMessages(Conversation conversation, long j, IOperationCallback iOperationCallback) throws RemoteException;

    boolean clearConversations(int[] iArr) throws RemoteException;

    boolean clearEncryptedConversations() throws RemoteException;

    boolean clearMessages(Conversation conversation) throws RemoteException;

    boolean clearMessagesUnreadStatus(Conversation conversation) throws RemoteException;

    boolean clearTextMessageDraft(Conversation conversation) throws RemoteException;

    boolean clearUnreadByReceipt(int i, String str, long j) throws RemoteException;

    void connect(String str, boolean z, boolean z2, IConnectStringCallback iConnectStringCallback) throws RemoteException;

    void createDiscussion(String str, List<String> list, IResultCallback iResultCallback) throws RemoteException;

    boolean createEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException;

    void deleteChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException;

    boolean deleteConversationMessage(int i, String str) throws RemoteException;

    boolean deleteMessage(int[] iArr) throws RemoteException;

    void deleteMessages(int i, String str, Message[] messageArr, IOperationCallback iOperationCallback) throws RemoteException;

    void disconnect(boolean z) throws RemoteException;

    void downloadMedia(Conversation conversation, int i, String str, IDownloadMediaCallback iDownloadMediaCallback) throws RemoteException;

    void downloadMediaFile(String str, String str2, String str3, String str4, IDownloadMediaFileCallback iDownloadMediaFileCallback) throws RemoteException;

    void downloadMediaMessage(Message message, IDownloadMediaMessageCallback iDownloadMediaMessageCallback) throws RemoteException;

    void exitRTCRoom(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void getAllChatRoomEntries(String str, IDataByBatchListener iDataByBatchListener) throws RemoteException;

    List<RCEncryptedSession> getAllEncryptedConversations() throws RemoteException;

    void getBlacklist(IStringCallback iStringCallback) throws RemoteException;

    void getBlacklistStatus(String str, IIntegerCallback iIntegerCallback) throws RemoteException;

    List<Conversation> getBlockedConversationList(int[] iArr) throws RemoteException;

    void getChatRoomEntry(String str, String str2, IStringCallback iStringCallback) throws RemoteException;

    void getChatRoomInfo(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException;

    void getChatroomHistoryMessages(String str, long j, int i, int i2, IChatRoomHistoryMessageCallback iChatRoomHistoryMessageCallback) throws RemoteException;

    Conversation getConversation(int i, String str) throws RemoteException;

    String getConversationDraft(Conversation conversation) throws RemoteException;

    List<Conversation> getConversationList() throws RemoteException;

    void getConversationListByBatch(int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException;

    List<Conversation> getConversationListByPage(int[] iArr, long j, int i) throws RemoteException;

    List<Conversation> getConversationListByType(int[] iArr) throws RemoteException;

    void getConversationListOfTypesByBatch(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException;

    void getConversationNotificationStatus(int i, String str, ILongCallback iLongCallback) throws RemoteException;

    int getConversationUnreadCount(Conversation conversation) throws RemoteException;

    String getCurrentUserId() throws RemoteException;

    long getDeltaTime() throws RemoteException;

    void getDiscussion(String str, IResultCallback iResultCallback) throws RemoteException;

    RCEncryptedSession getEncryptedConversation(String str) throws RemoteException;

    boolean getFileDownloadingStatus(String str) throws RemoteException;

    int getGIFLimitSize() throws RemoteException;

    boolean getJoinMultiChatRoomEnable() throws RemoteException;

    List<Message> getMatchedMessages(String str, int i, long j, int i2, int i3) throws RemoteException;

    Message getMessage(int i) throws RemoteException;

    Message getMessageByUid(String str) throws RemoteException;

    int getMessageCount(int i, String str) throws RemoteException;

    long getNaviCachedTime() throws RemoteException;

    List<Message> getNewestMessages(Conversation conversation, int i) throws RemoteException;

    void getNotificationQuietHours(IGetNotificationQuietHoursCallback iGetNotificationQuietHoursCallback) throws RemoteException;

    String getOffLineLogServer() throws RemoteException;

    String getOfflineMessageDuration() throws RemoteException;

    List<Message> getOlderMessages(Conversation conversation, long j, int i) throws RemoteException;

    List<Message> getOlderMessagesByObjectName(Conversation conversation, String str, long j, int i, boolean z) throws RemoteException;

    List<Message> getOlderMessagesByObjectNames(Conversation conversation, List<String> list, long j, int i, boolean z) throws RemoteException;

    void getOlderMessagesOneWay(Conversation conversation, long j, int i, OnGetHistoryMessagesCallback onGetHistoryMessagesCallback) throws RemoteException;

    void getPublicServiceList(IResultCallback iResultCallback) throws RemoteException;

    void getPublicServiceProfile(String str, int i, IResultCallback iResultCallback) throws RemoteException;

    String getPushSetting(int i) throws RemoteException;

    void getRTCConfig(String str, String str2, long j, String str3, IRTCConfigCallback iRTCConfigCallback) throws RemoteException;

    String getRTCProfile() throws RemoteException;

    void getRTCToken(String str, int i, int i2, IStringCallback iStringCallback) throws RemoteException;

    void getRTCUserData(String str, int i, RTCDataListener rTCDataListener) throws RemoteException;

    void getRTCUserDatas(String str, String[] strArr, RTCDataListener rTCDataListener) throws RemoteException;

    void getRTCUsers(String str, int i, RTCDataListener rTCDataListener) throws RemoteException;

    void getRemoteHistoryMessages(Conversation conversation, long j, int i, IResultCallback iResultCallback) throws RemoteException;

    void getRemoteHistoryMessagesOption(Conversation conversation, RemoteHistoryMsgOption remoteHistoryMsgOption, IResultCallback iResultCallback) throws RemoteException;

    long getSendTimeByMessageId(int i) throws RemoteException;

    String getTextMessageDraft(Conversation conversation) throws RemoteException;

    Message getTheFirstUnreadMessage(int i, String str) throws RemoteException;

    void getTopConversationList(int[] iArr, int i, IGetConversationListWithProcessCallback iGetConversationListWithProcessCallback) throws RemoteException;

    int getTotalUnreadCount() throws RemoteException;

    int getUnreadCount(int[] iArr) throws RemoteException;

    int getUnreadCountByConversation(Conversation[] conversationArr) throws RemoteException;

    int getUnreadCountById(int i, String str) throws RemoteException;

    int getUnreadCountWithDND(int[] iArr, boolean z) throws RemoteException;

    List<Message> getUnreadMentionedMessages(int i, String str) throws RemoteException;

    String getUploadLogConfigInfo() throws RemoteException;

    void getUserStatus(String str, IGetUserStatusCallback iGetUserStatusCallback) throws RemoteException;

    void getVendorToken(IStringCallback iStringCallback) throws RemoteException;

    int getVideoLimitTime() throws RemoteException;

    String getVoIPCallInfo() throws RemoteException;

    void getVoIPKey(int i, String str, String str2, IStringCallback iStringCallback) throws RemoteException;

    void initAppendixModule() throws RemoteException;

    void initHttpDns() throws RemoteException;

    void initIPCEnviroment(String str, int i) throws RemoteException;

    Message insertMessage(Message message) throws RemoteException;

    Message insertSettingMessage(Message message) throws RemoteException;

    boolean isDnsEnabled() throws RemoteException;

    boolean isPhrasesEnabled() throws RemoteException;

    void joinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException;

    void joinExistChatRoom(String str, int i, IOperationCallback iOperationCallback, boolean z) throws RemoteException;

    void joinGroup(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException;

    void joinRTCRoomAndGetData(String str, int i, int i2, IRTCJoinRoomCallback iRTCJoinRoomCallback) throws RemoteException;

    void notifyAppBackgroundChanged(boolean z) throws RemoteException;

    void pauseTransferMediaFile(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void pauseTransferMediaMessage(Message message, IOperationCallback iOperationCallback) throws RemoteException;

    void quitChatRoom(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void quitDiscussion(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void quitGroup(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void reJoinChatRoom(String str, int i, IOperationCallback iOperationCallback) throws RemoteException;

    void recallMessage(String str, byte[] bArr, String str2, int i, String str3, int i2, boolean z, IOperationCallback iOperationCallback) throws RemoteException;

    void registerCmdMsgType(String str) throws RemoteException;

    void registerCmdMsgTypes(List<String> list) throws RemoteException;

    void registerDeleteMessageType(List<String> list) throws RemoteException;

    void registerMessageType(String str) throws RemoteException;

    void registerMessageTypes(List<String> list) throws RemoteException;

    boolean removeConversation(int i, String str) throws RemoteException;

    void removeDiscussionMember(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException;

    boolean removeEncryptedConversation(String str) throws RemoteException;

    void removeFromBlacklist(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void removeMessageAllExpansion(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void removeMessageExpansion(List<String> list, String str, IOperationCallback iOperationCallback) throws RemoteException;

    void removeNotificationQuietHours(IOperationCallback iOperationCallback) throws RemoteException;

    void rtcDeleteInnerData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException;

    void rtcDeleteOuterData(String str, int i, String[] strArr, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException;

    void rtcGetInnerData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException;

    void rtcGetOuterData(String str, int i, String[] strArr, IRtcIODataListener iRtcIODataListener) throws RemoteException;

    void rtcPutInnerData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws RemoteException;

    void rtcPutOuterData(String str, int i, String str2, String str3, String str4, String str5, IOperationCallback iOperationCallback) throws RemoteException;

    void rtcSetUserResource(String str, RTCStatusDate[] rTCStatusDateArr, String str2, RTCStatusDate[] rTCStatusDateArr2, IOperationCallback iOperationCallback) throws RemoteException;

    boolean saveConversationDraft(Conversation conversation, String str) throws RemoteException;

    boolean saveTextMessageDraft(Conversation conversation, String str) throws RemoteException;

    List<SearchConversationResult> searchConversations(String str, int[] iArr, String[] strArr) throws RemoteException;

    List<Message> searchMessages(String str, int i, String str2, int i2, long j) throws RemoteException;

    List<Message> searchMessagesByUser(String str, int i, String str2, int i2, long j) throws RemoteException;

    void searchPublicService(String str, int i, int i2, IResultCallback iResultCallback) throws RemoteException;

    void sendDirectionalMediaMessage(Message message, String[] strArr, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException;

    void sendDirectionalMessage(Message message, String str, String str2, String[] strArr, ISendMessageCallback iSendMessageCallback) throws RemoteException;

    void sendLocationMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException;

    void sendMediaMessage(Message message, String str, String str2, ISendMediaMessageCallback iSendMediaMessageCallback) throws RemoteException;

    void sendMessage(Message message, String str, String str2, ISendMessageCallback iSendMessageCallback) throws RemoteException;

    void sendMessageOption(Message message, String str, String str2, SendMessageOption sendMessageOption, ISendMessageCallback iSendMessageCallback) throws RemoteException;

    void sendPing() throws RemoteException;

    void sendRTCDirectionalMessage(Message message, String str, String str2, String[] strArr, SendMessageOption sendMessageOption, boolean z, ISendMessageCallback iSendMessageCallback) throws RemoteException;

    void sendRTCPing(String str, IOperationCallback iOperationCallback) throws RemoteException;

    void setChatRoomEntry(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3, IOperationCallback iOperationCallback) throws RemoteException;

    void setConnectionStatusListener(IConnectionStatusListener iConnectionStatusListener) throws RemoteException;

    void setConversationNotificationStatus(int i, String str, int i2, ILongCallback iLongCallback) throws RemoteException;

    void setConversationStatusListener(ConversationStatusListener conversationStatusListener) throws RemoteException;

    boolean setConversationTopStatus(int i, String str, boolean z, boolean z2) throws RemoteException;

    void setDiscussionInviteStatus(String str, int i, IOperationCallback iOperationCallback) throws RemoteException;

    void setDiscussionName(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException;

    boolean setEncryptedConversation(String str, RCEncryptedSession rCEncryptedSession) throws RemoteException;

    void setIpcConnectTimeOut() throws RemoteException;

    void setKvStatusListener(KVStatusDataByBatchListener kVStatusDataByBatchListener) throws RemoteException;

    boolean setMessageContent(int i, byte[] bArr, String str) throws RemoteException;

    void setMessageExpansionListener(IMessageExpansionListener iMessageExpansionListener) throws RemoteException;

    boolean setMessageExtra(int i, String str) throws RemoteException;

    boolean setMessageReadTime(long j, long j2) throws RemoteException;

    boolean setMessageReceivedStatus(int i, int i2) throws RemoteException;

    boolean setMessageSentStatus(int i, int i2) throws RemoteException;

    void setNaviContentUpdateListener(INaviContentUpdateCallBack iNaviContentUpdateCallBack) throws RemoteException;

    void setNotificationQuietHours(String str, int i, IOperationCallback iOperationCallback) throws RemoteException;

    void setOfflineMessageDuration(String str, ILongCallback iLongCallback) throws RemoteException;

    void setOnReceiveMessageListener(OnReceiveMessageListener onReceiveMessageListener) throws RemoteException;

    void setPushSetting(int i, String str, ISetPushSettingCallback iSetPushSettingCallback) throws RemoteException;

    void setRLogOtherProgressCallback(IRLogOtherProgressCallback iRLogOtherProgressCallback) throws RemoteException;

    void setRTCUserData(String str, String str2, IOperationCallback iOperationCallback) throws RemoteException;

    void setRTCUserDatas(String str, int i, Map map, String str2, String str3, IOperationCallback iOperationCallback) throws RemoteException;

    void setReconnectKickEnable(boolean z) throws RemoteException;

    void setServerInfo(String str, String str2) throws RemoteException;

    void setSubscribeStatusListener(ISubscribeUserStatusCallback iSubscribeUserStatusCallback) throws RemoteException;

    void setUserData(UserData userData, IOperationCallback iOperationCallback) throws RemoteException;

    void setUserPolicy(boolean z) throws RemoteException;

    void setUserProfileListener(UserProfileSettingListener userProfileSettingListener) throws RemoteException;

    void setUserStatus(int i, ISetUserStatusCallback iSetUserStatusCallback) throws RemoteException;

    void solveServerHosts(String str, ISolveServerHostsCallBack iSolveServerHostsCallBack) throws RemoteException;

    void subscribePublicService(String str, int i, boolean z, IOperationCallback iOperationCallback) throws RemoteException;

    void subscribeStatus(List<String> list, IIntegerCallback iIntegerCallback) throws RemoteException;

    boolean supportResumeBrokenTransfer(String str) throws RemoteException;

    void switchAppKey(String str, String str2) throws RemoteException;

    void syncGroup(List<Group> list, IOperationCallback iOperationCallback) throws RemoteException;

    boolean updateConversationInfo(int i, String str, String str2, String str3) throws RemoteException;

    void updateMessageExpansion(Map map, String str, IOperationCallback iOperationCallback) throws RemoteException;

    boolean updateMessageReceiptStatus(String str, int i, long j) throws RemoteException;

    boolean updateReadReceiptRequestInfo(String str, String str2) throws RemoteException;

    void updateVoIPCallInfo(String str) throws RemoteException;

    void uploadMedia(Message message, IUploadCallback iUploadCallback) throws RemoteException;

    boolean useRTCOnly() throws RemoteException;

    void writeFwLog(int i, String str, String str2, String str3, long j) throws RemoteException;
}
