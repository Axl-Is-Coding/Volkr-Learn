package io.rong.imkit;

import android.content.Context;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imkit.emoticon.AndroidEmoji;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.model.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongExtensionManager {
    private static final String DEFAULT_BQMM = "com.melink.bqmmplugin.rc.BQMMExtensionModule";
    private static final String DEFAULT_RC_STICKER = "io.rong.sticker.StickerExtensionModule";
    private static final String DEFAULT_REDPACKET = "com.jrmf360.rylib.modules.JrmfExtensionModule";
    private static final String TAG = "RongExtensionManager";
    private static IExtensionProxy extensionProxy;
    private static String mAppKey;
    private static List<IExtensionModule> mExtModules = new ArrayList();
    private static List<String> mPhrasesList = new ArrayList();

    private static class SingletonHolder {
        static RongExtensionManager sInstance = new RongExtensionManager();

        private SingletonHolder() {
        }
    }

    private void checkRCBQ() {
        try {
            IExtensionModule iExtensionModule = (IExtensionModule) Class.forName(DEFAULT_RC_STICKER).getConstructor(new Class[0]).newInstance(new Object[0]);
            RLog.i(TAG, "add module " + iExtensionModule.getClass().getSimpleName());
            mExtModules.add(iExtensionModule);
            iExtensionModule.onInit(mAppKey);
        } catch (Exception unused) {
            RLog.i(TAG, "Can't find io.rong.sticker.StickerExtensionModule");
        }
    }

    static IExtensionProxy getExtensionProxy() {
        return extensionProxy;
    }

    public static RongExtensionManager getInstance() {
        return SingletonHolder.sInstance;
    }

    static void init(Context context, String str) {
        RLog.d(TAG, "init");
        AndroidEmoji.init(context);
        RongUtils.init(context);
        mAppKey = str;
    }

    public static void setExtensionProxy(IExtensionProxy iExtensionProxy) {
        extensionProxy = iExtensionProxy;
    }

    public void addExtensionModule(IExtensionModule iExtensionModule) {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            RLog.e(TAG, "Not init in the main process.");
            return;
        }
        if (iExtensionModule == null || list.contains(iExtensionModule)) {
            RLog.e(TAG, "Illegal extensionModule.");
            return;
        }
        RLog.i(TAG, "addExtensionModule " + iExtensionModule.getClass().getSimpleName());
        mExtModules.add(iExtensionModule);
    }

    public void addPhraseList(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        mPhrasesList.clear();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                mPhrasesList.add(str);
            }
        }
    }

    void connect(String str) {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            return;
        }
        Iterator<IExtensionModule> it = list.iterator();
        while (it.hasNext()) {
            it.next().onConnect(str);
        }
    }

    void disconnect() {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            return;
        }
        Iterator<IExtensionModule> it = list.iterator();
        while (it.hasNext()) {
            it.next().onDisconnect();
        }
    }

    public List<IExtensionModule> getExtensionModules() {
        return mExtModules;
    }

    public List<String> getPhrasesList() {
        return mPhrasesList;
    }

    void onReceivedMessage(Message message) {
        Iterator<IExtensionModule> it = mExtModules.iterator();
        while (it.hasNext()) {
            it.next().onReceivedMessage(message);
        }
    }

    public void registerExtensionModule(IExtensionModule iExtensionModule) {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            RLog.e(TAG, "Not init in the main process.");
            return;
        }
        if (iExtensionModule == null || list.contains(iExtensionModule)) {
            RLog.e(TAG, "Illegal extensionModule.");
            return;
        }
        RLog.i(TAG, "registerExtensionModule " + iExtensionModule.getClass().getSimpleName());
        if (mExtModules.size() <= 0 || !(mExtModules.get(0).getClass().getCanonicalName().equals(DEFAULT_REDPACKET) || mExtModules.get(0).getClass().getCanonicalName().equals(DEFAULT_BQMM) || mExtModules.get(0).getClass().getCanonicalName().equals(DEFAULT_RC_STICKER))) {
            mExtModules.add(iExtensionModule);
        } else {
            mExtModules.add(0, iExtensionModule);
        }
        iExtensionModule.onInit(mAppKey);
    }

    public void unregisterExtensionModule(IExtensionModule iExtensionModule) {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            RLog.e(TAG, "Not init in the main process.");
            return;
        }
        if (iExtensionModule == null || !list.contains(iExtensionModule)) {
            RLog.e(TAG, "Illegal extensionModule.");
            return;
        }
        RLog.i(TAG, "unregisterExtensionModule " + iExtensionModule.getClass().getSimpleName());
        Iterator<IExtensionModule> it = mExtModules.iterator();
        while (it.hasNext()) {
            if (it.next().equals(iExtensionModule)) {
                it.remove();
            }
        }
    }

    private RongExtensionManager() {
        if (mExtModules != null) {
            try {
                IExtensionModule iExtensionModule = (IExtensionModule) Class.forName(DEFAULT_REDPACKET).getConstructor(new Class[0]).newInstance(new Object[0]);
                RLog.i(TAG, "add module " + iExtensionModule.getClass().getSimpleName());
                mExtModules.add(iExtensionModule);
                iExtensionModule.onInit(mAppKey);
            } catch (Exception unused) {
            }
            checkRCBQ();
        }
    }

    public void registerExtensionModule(int i, IExtensionModule iExtensionModule) {
        List<IExtensionModule> list = mExtModules;
        if (list == null) {
            RLog.e(TAG, "Not init in the main process.");
            return;
        }
        if (iExtensionModule != null && !list.contains(iExtensionModule)) {
            RLog.i(TAG, "registerExtensionModule " + iExtensionModule.getClass().getSimpleName());
            mExtModules.add(i, iExtensionModule);
            iExtensionModule.onInit(mAppKey);
            return;
        }
        RLog.e(TAG, "Illegal extensionModule.");
    }
}
