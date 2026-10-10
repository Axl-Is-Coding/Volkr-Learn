package io.rong.imkit.destruct;

import io.rong.eventbus.EventBus;
import io.rong.imkit.model.Event;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.destruct.DestructionTaskManager;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class DestructManager {
    private Map<String, Map<String, RongIMClient.DestructCountDownTimerListener>> mMap;
    private Map<String, String> mUnFinishTimes;

    private static class DestructManagerHolder {
        private static DestructManager instance = new DestructManager();

        private DestructManagerHolder() {
        }
    }

    public static DestructManager getInstance() {
        return DestructManagerHolder.instance;
    }

    public void addListener(String str, RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener, String str2) {
        if (!this.mMap.containsKey(str)) {
            HashMap map = new HashMap();
            map.put(str2, destructCountDownTimerListener);
            this.mMap.put(str, map);
        } else {
            Map<String, RongIMClient.DestructCountDownTimerListener> map2 = this.mMap.get(str);
            if (map2 != null) {
                map2.put(str2, destructCountDownTimerListener);
            }
        }
    }

    public void deleteMessage(Message message) {
        DestructionTaskManager.getInstance().deleteMessage(message);
    }

    public void deleteMessages(Conversation.ConversationType conversationType, String str, Message[] messageArr) {
        DestructionTaskManager.getInstance().deleteMessages(conversationType, str, messageArr);
    }

    public String getUnFinishTime(String str) {
        return this.mUnFinishTimes.get(str);
    }

    public void startDestruct(final Message message) {
        RongIMClient.getInstance().beginDestructMessage(message, new RongIMClient.DestructCountDownTimerListener() { // from class: io.rong.imkit.destruct.DestructManager.1
            @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
            public void onStop(String str) {
                if (DestructManager.this.mMap.containsKey(str)) {
                    Map map = (Map) DestructManager.this.mMap.get(str);
                    if (map != null) {
                        Iterator it = map.keySet().iterator();
                        while (it.hasNext()) {
                            RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener = (RongIMClient.DestructCountDownTimerListener) map.get((String) it.next());
                            if (destructCountDownTimerListener != null) {
                                destructCountDownTimerListener.onStop(str);
                            }
                        }
                    }
                    DestructManager.this.mUnFinishTimes.remove(str);
                }
            }

            @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
            public void onTick(long j, String str) {
                if (DestructManager.this.mMap.containsKey(str)) {
                    Map map = (Map) DestructManager.this.mMap.get(str);
                    if (map != null) {
                        Iterator it = map.keySet().iterator();
                        while (it.hasNext()) {
                            RongIMClient.DestructCountDownTimerListener destructCountDownTimerListener = (RongIMClient.DestructCountDownTimerListener) map.get((String) it.next());
                            if (destructCountDownTimerListener != null) {
                                destructCountDownTimerListener.onTick(j, str);
                            }
                        }
                    }
                    if (j != 0) {
                        DestructManager.this.mUnFinishTimes.put(str, String.valueOf(j));
                        return;
                    }
                    if (map != null) {
                        map.clear();
                    }
                    DestructManager.this.mMap.remove(str);
                    DestructManager.this.mUnFinishTimes.remove(str);
                    EventBus.getDefault().post(new Event.MessageDeleteEvent(message.getMessageId()));
                }
            }
        });
    }

    public void stopDestruct(Message message) {
        RongIMClient.getInstance().stopDestructMessage(message);
    }

    private DestructManager() {
        this.mMap = new HashMap();
        this.mUnFinishTimes = new HashMap();
    }
}
