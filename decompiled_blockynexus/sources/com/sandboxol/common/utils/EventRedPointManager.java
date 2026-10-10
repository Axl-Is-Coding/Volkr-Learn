package com.sandboxol.common.utils;

import android.content.Context;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableMap;
import com.sandboxol.common.base.app.BaseApplication;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class EventRedPointManager {
    public static final int CLOSE = 2;
    public static final int HIDE = 0;
    public static final int SHOW = 1;
    public Map<String, Integer> eventRedPointNum;
    private List<String> limitedEvent;
    private List<String> receiveEvent;
    public ObservableMap<String, Integer> redPointStatusSet;

    private static class InstanceHolder {
        private static final EventRedPointManager instance = new EventRedPointManager();

        private InstanceHolder() {
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    public static EventRedPointManager getInstance() {
        return InstanceHolder.instance;
    }

    private void recordLimitedEvents(String str) {
        if (this.limitedEvent.contains(str)) {
            return;
        }
        this.limitedEvent.add(str);
    }

    private void recordReceiveEvents(String str) {
        if (this.receiveEvent.contains(str)) {
            return;
        }
        this.receiveEvent.add(str);
    }

    private void updateRedPointStatusByEvent(long j, String str, int i) {
        if (this.receiveEvent.contains(j + str)) {
            if (i == 0) {
                this.receiveEvent.remove(j + str);
            }
        } else if (i == 1) {
            this.receiveEvent.add(j + str);
        }
        this.redPointStatusSet.put(j + str, Integer.valueOf(i));
    }

    public void addOneEventRedPoint(long j, String str) {
        if (this.redPointStatusSet.get(j + str) != null) {
            if (this.redPointStatusSet.get(j + str).intValue() != 2) {
                if (this.eventRedPointNum.get(j + str) == null) {
                    this.eventRedPointNum.put(j + str, 0);
                }
                this.eventRedPointNum.put(j + str, Integer.valueOf(this.eventRedPointNum.get(j + str).intValue() + 1));
                if (this.eventRedPointNum.get(j + str).intValue() > 0) {
                    updateRedPointStatusByEvent(j, str, 1);
                }
            }
        }
    }

    public boolean getRedPointWholeStatus() {
        int iIntValue = 0;
        for (String str : this.redPointStatusSet.keySet()) {
            if (this.redPointStatusSet.get(str).intValue() != 2) {
                iIntValue += this.redPointStatusSet.get(str).intValue();
            }
        }
        return iIntValue > 0;
    }

    public void registerRedPoint(long j, String str, boolean z, int i) {
        if (i == 0) {
            if (z) {
                recordLimitedEvents(j + str);
                long jCurrentTimeMillis = System.currentTimeMillis();
                Context context = BaseApplication.getContext();
                StringBuilder sb = new StringBuilder();
                sb.append(j);
                sb.append(str);
                if (jCurrentTimeMillis - SharedUtils.getLong(context, sb.toString()) > 86400000) {
                    i = 1;
                }
            }
        } else if (i == 1) {
            recordReceiveEvents(j + str);
            if (z) {
                recordLimitedEvents(j + str);
            }
        }
        this.redPointStatusSet.put(j + str, Integer.valueOf(i));
    }

    public void removeOneEventRedPoint(long j, String str) {
        if (this.redPointStatusSet.get(j + str) != null) {
            if (this.redPointStatusSet.get(j + str).intValue() != 2) {
                if (this.eventRedPointNum.get(j + str) == null) {
                    this.eventRedPointNum.put(j + str, 0);
                }
                if (this.eventRedPointNum.get(j + str).intValue() > 0) {
                    Map<String, Integer> map = this.eventRedPointNum;
                    this.eventRedPointNum.put(j + str, Integer.valueOf(map.get(j + str).intValue() - 1));
                }
                if (this.eventRedPointNum.get(j + str).intValue() == 0) {
                    updateRedPointStatusByEvent(j, str, 0);
                }
            }
        }
    }

    public void resetEventRedPointNum(long j, String str) {
        this.eventRedPointNum.put(j + str, 0);
    }

    public void updateRedPointStatusByClickItem(long j, String str) {
        if (this.receiveEvent.contains(j + str)) {
            if (this.limitedEvent.contains(j + str)) {
                SharedUtils.putLong(BaseApplication.getContext(), j + str, System.currentTimeMillis());
                return;
            }
            return;
        }
        if (this.limitedEvent.contains(j + str)) {
            SharedUtils.putLong(BaseApplication.getContext(), j + str, System.currentTimeMillis());
            this.redPointStatusSet.put(j + str, 0);
        }
    }

    private EventRedPointManager() {
        this.redPointStatusSet = new ObservableArrayMap();
        this.eventRedPointNum = new HashMap();
        this.limitedEvent = new ArrayList();
        this.receiveEvent = new ArrayList();
    }
}
