package io.rong.imkit.recallEdit;

import io.rong.imlib.model.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class RecallEditManager {
    private Map<String, ConcurrentHashMap<Integer, RecallEditCountDownTimer>> timerMap;

    private static class RecallEditManagerHolder {
        private static RecallEditManager instance = new RecallEditManager();

        private RecallEditManagerHolder() {
        }
    }

    private class RecallEditTimerListener implements RecallEditCountDownTimerListener {
        private RecallEditCountDownCallBack callBack;
        private Message message;

        public RecallEditTimerListener(Message message, RecallEditCountDownCallBack recallEditCountDownCallBack) {
            this.message = message;
            this.callBack = recallEditCountDownCallBack;
        }

        @Override // io.rong.imkit.recallEdit.RecallEditCountDownTimerListener
        public void onFinish(String str) {
            Map map = (Map) RecallEditManager.this.timerMap.get(this.message.getConversationType().getName() + str);
            if (map != null && map.get(Integer.valueOf(this.message.getMessageId())) != null) {
                map.remove(Integer.valueOf(this.message.getMessageId()));
            }
            RecallEditCountDownCallBack recallEditCountDownCallBack = this.callBack;
            if (recallEditCountDownCallBack != null) {
                recallEditCountDownCallBack.onFinish(str);
            }
        }

        @Override // io.rong.imkit.recallEdit.RecallEditCountDownTimerListener
        public void onTick(long j, String str) {
        }
    }

    public static RecallEditManager getInstance() {
        return RecallEditManagerHolder.instance;
    }

    public void cancelCountDown(String str) {
        RecallEditCountDownTimer recallEditCountDownTimer;
        Iterator<Map.Entry<String, ConcurrentHashMap<Integer, RecallEditCountDownTimer>>> it = this.timerMap.entrySet().iterator();
        while (it.hasNext()) {
            ConcurrentHashMap<Integer, RecallEditCountDownTimer> value = it.next().getValue();
            if (value != null && value.size() > 0 && (recallEditCountDownTimer = value.get(Integer.valueOf(str))) != null) {
                recallEditCountDownTimer.cancel();
                value.remove(Integer.valueOf(str));
            }
        }
    }

    public void cancelCountDownInConversation(String str) {
        ConcurrentHashMap<Integer, RecallEditCountDownTimer> concurrentHashMap = this.timerMap.get(str);
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<Integer, RecallEditCountDownTimer>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            RecallEditCountDownTimer value = it.next().getValue();
            if (value != null) {
                value.cancel();
            }
        }
        this.timerMap.remove(str);
    }

    public void startCountDown(Message message, long j, RecallEditCountDownCallBack recallEditCountDownCallBack) {
        RecallEditCountDownTimer recallEditCountDownTimer;
        String str = message.getConversationType().getName() + message.getTargetId();
        ConcurrentHashMap<Integer, RecallEditCountDownTimer> concurrentHashMap = this.timerMap.get(str);
        if (concurrentHashMap != null && (recallEditCountDownTimer = concurrentHashMap.get(Integer.valueOf(message.getMessageId()))) != null) {
            recallEditCountDownTimer.setListener(new RecallEditTimerListener(message, recallEditCountDownCallBack));
            return;
        }
        RecallEditCountDownTimer recallEditCountDownTimer2 = new RecallEditCountDownTimer(String.valueOf(message.getMessageId()), new RecallEditTimerListener(message, recallEditCountDownCallBack), j);
        if (concurrentHashMap == null) {
            ConcurrentHashMap<Integer, RecallEditCountDownTimer> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(Integer.valueOf(message.getMessageId()), recallEditCountDownTimer2);
            this.timerMap.put(str, concurrentHashMap2);
        } else {
            concurrentHashMap.put(Integer.valueOf(message.getMessageId()), recallEditCountDownTimer2);
        }
        recallEditCountDownTimer2.start();
    }

    private RecallEditManager() {
        this.timerMap = new HashMap();
    }
}
