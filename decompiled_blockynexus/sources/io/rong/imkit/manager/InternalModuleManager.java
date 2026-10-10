package io.rong.imkit.manager;

import android.content.Context;
import io.rong.common.RLog;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class InternalModuleManager {
    private static final String TAG = "InternalModuleManager";
    private static IExternalModule callModule;
    private static IExternalModule callModule2;

    static class SingletonHolder {
        static InternalModuleManager sInstance = new InternalModuleManager();

        SingletonHolder() {
        }
    }

    public static InternalModuleManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public static void init(Context context) {
        RLog.i(TAG, "init");
        try {
            callModule = (IExternalModule) Class.forName("io.rong.callkit.RongCallModule").getConstructor(new Class[0]).newInstance(new Object[0]);
            callModule.onCreate(context);
        } catch (Exception unused) {
            RLog.i(TAG, "Can not find RongCallModule.");
        }
        try {
            callModule2 = (IExternalModule) Class.forName("io.rong.signalingkit.RCSCallModule").getConstructor(new Class[0]).newInstance(new Object[0]);
            callModule2.onCreate(context);
        } catch (Exception unused2) {
            RLog.i(TAG, "Can not find RCSCallModule.");
        }
    }

    public List<IPluginModule> getInternalPlugins(Conversation.ConversationType conversationType) {
        ArrayList arrayList = new ArrayList();
        if (callModule != null && (conversationType.equals(Conversation.ConversationType.PRIVATE) || conversationType.equals(Conversation.ConversationType.DISCUSSION) || conversationType.equals(Conversation.ConversationType.GROUP))) {
            arrayList.addAll(callModule.getPlugins(conversationType));
        }
        if (callModule2 != null && (conversationType.equals(Conversation.ConversationType.PRIVATE) || conversationType.equals(Conversation.ConversationType.DISCUSSION) || conversationType.equals(Conversation.ConversationType.GROUP))) {
            arrayList.addAll(callModule2.getPlugins(conversationType));
        }
        return arrayList;
    }

    public void onConnected(String str) {
        RLog.i(TAG, "onConnected");
        IExternalModule iExternalModule = callModule;
        if (iExternalModule != null) {
            iExternalModule.onConnected(str);
        }
        IExternalModule iExternalModule2 = callModule2;
        if (iExternalModule2 != null) {
            iExternalModule2.onConnected(str);
        }
    }

    public void onInitialized(String str) {
        RLog.i(TAG, "onInitialized");
        IExternalModule iExternalModule = callModule;
        if (iExternalModule != null) {
            iExternalModule.onInitialized(str);
        }
        IExternalModule iExternalModule2 = callModule2;
        if (iExternalModule2 != null) {
            iExternalModule2.onInitialized(str);
        }
    }

    public void onLoaded() {
        RLog.i(TAG, "onLoaded");
        IExternalModule iExternalModule = callModule;
        if (iExternalModule != null) {
            iExternalModule.onViewCreated();
        }
        IExternalModule iExternalModule2 = callModule2;
        if (iExternalModule2 != null) {
            iExternalModule2.onViewCreated();
        }
    }

    private InternalModuleManager() {
    }
}
