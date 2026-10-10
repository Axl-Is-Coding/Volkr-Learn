package io.rong.push.pushconfig;

import io.rong.push.PushType;
import io.rong.push.platform.IPush;
import io.rong.push.platform.google.FCMPush;
import io.rong.push.rongpush.RongPush;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class PushFactory {
    private static final String TAG = "PushFactory";
    private HashMap<PushType, IPush> pushProcessorMap = new HashMap<>();

    private static class Holder {
        private static PushFactory instance = new PushFactory();

        private Holder() {
        }
    }

    public PushFactory() {
        this.pushProcessorMap.put(PushType.RONG, new RongPush());
        this.pushProcessorMap.put(PushType.GOOGLE_FCM, new FCMPush());
    }

    public static PushFactory getInstance() {
        return Holder.instance;
    }

    public IPush getPushCenterByType(PushType pushType) {
        return this.pushProcessorMap.get(pushType);
    }

    public void setPushProcessor(PushType pushType, IPush iPush) {
        this.pushProcessorMap.put(pushType, iPush);
    }
}
