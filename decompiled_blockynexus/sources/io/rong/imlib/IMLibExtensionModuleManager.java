package io.rong.imlib;

import android.content.Context;
import android.text.TextUtils;
import io.rong.common.RLog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.HardwareResource;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class IMLibExtensionModuleManager implements IMLibExtensionModule {
    private static final String[] defaultModules = {"io.rong.wrapper.RongRemoteControlExtensionModule", "io.rongcloud.moment.lib.RongMomentExtensionModule", "io.rong.signal.core.RCSignalExtensionModule", "cn.rongcloud.rtc.RongRTCExtensionModule"};
    private List<Class<? extends MessageContent>> cmdMessageContentClazzList;
    private Map<IMLibExtensionModule, List<Class<? extends MessageContent>>> extensionModuleMessageContentMap;
    private List<IMLibExtensionModule> extensionModules;
    private List<Class<? extends MessageContent>> messageContentClazzList;
    private String token;
    private String userId;

    private static class IMLibExtensionModuleManagerHolder {
        private static IMLibExtensionModuleManager instance = new IMLibExtensionModuleManager();

        private IMLibExtensionModuleManagerHolder() {
        }
    }

    public static IMLibExtensionModuleManager getInstance() {
        return IMLibExtensionModuleManagerHolder.instance;
    }

    private void loadDefaultModules() {
        for (String str : defaultModules) {
            loadIMLibModuleByName(str);
        }
    }

    private void loadIMLibModuleByName(String str) {
        try {
            registerInternal((IMLibExtensionModule) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused) {
        }
    }

    private void registerInternal(IMLibExtensionModule iMLibExtensionModule) {
        if (iMLibExtensionModule == null) {
            return;
        }
        this.extensionModules.add(iMLibExtensionModule);
        if (iMLibExtensionModule.getMessageContentList() != null) {
            this.messageContentClazzList.addAll(iMLibExtensionModule.getMessageContentList());
            this.extensionModuleMessageContentMap.put(iMLibExtensionModule, iMLibExtensionModule.getMessageContentList());
        }
        if (iMLibExtensionModule.getCmdMessageContentList() != null) {
            this.cmdMessageContentClazzList.addAll(iMLibExtensionModule.getMessageContentList());
        }
    }

    private void unRegisterInternal(IMLibExtensionModule iMLibExtensionModule) {
        if (iMLibExtensionModule == null) {
            return;
        }
        this.extensionModules.remove(iMLibExtensionModule);
        if (iMLibExtensionModule.getMessageContentList() != null) {
            this.messageContentClazzList.removeAll(iMLibExtensionModule.getMessageContentList());
        }
        if (iMLibExtensionModule.getCmdMessageContentList() != null) {
            this.cmdMessageContentClazzList.removeAll(iMLibExtensionModule.getCmdMessageContentList());
        }
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public List<Class<? extends MessageContent>> getCmdMessageContentList() {
        return this.cmdMessageContentClazzList;
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public List<Class<? extends MessageContent>> getMessageContentList() {
        return this.messageContentClazzList;
    }

    void init() {
        this.extensionModules = new ArrayList();
        this.messageContentClazzList = new ArrayList();
        this.cmdMessageContentClazzList = new ArrayList();
        this.extensionModuleMessageContentMap = new HashMap();
    }

    void loadAllIMLibExtensionModules() {
        loadDefaultModules();
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onConnectStatusChanged(RongIMClient.ConnectionStatusListener.ConnectionStatus connectionStatus) {
        Iterator<IMLibExtensionModule> it = this.extensionModules.iterator();
        while (it.hasNext()) {
            it.next().onConnectStatusChanged(connectionStatus);
        }
    }

    void onConnected(String str, String str2) {
        if (TextUtils.equals(this.userId, str)) {
            return;
        }
        this.userId = str;
        this.token = str2;
        Iterator<IMLibExtensionModule> it = this.extensionModules.iterator();
        while (it.hasNext()) {
            it.next().onLogin(str, str2);
        }
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onCreate(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Iterator<IMLibExtensionModule> it = this.extensionModules.iterator();
        while (it.hasNext()) {
            it.next().onCreate(applicationContext, str);
        }
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onDestroy() {
        Iterator<IMLibExtensionModule> it = this.extensionModules.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onLogin(String str, String str2) {
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public void onLogout() {
        this.userId = null;
        this.token = null;
        Iterator<IMLibExtensionModule> it = this.extensionModules.iterator();
        while (it.hasNext()) {
            it.next().onLogout();
        }
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public boolean onReceiveMessage(Message message, int i, boolean z, int i2) {
        boolean zOnReceiveMessage = false;
        for (Map.Entry<IMLibExtensionModule, List<Class<? extends MessageContent>>> entry : this.extensionModuleMessageContentMap.entrySet()) {
            if (entry.getValue().contains(message.getContent().getClass()) && (zOnReceiveMessage = entry.getKey().onReceiveMessage(message, i, z, i2))) {
                break;
            }
        }
        return zOnReceiveMessage;
    }

    @Override // io.rong.imlib.IMLibExtensionModule
    public boolean onRequestHardwareResource(HardwareResource.ResourceType resourceType) {
        boolean z = false;
        for (IMLibExtensionModule iMLibExtensionModule : this.extensionModules) {
            boolean zOnRequestHardwareResource = iMLibExtensionModule.onRequestHardwareResource(resourceType);
            if (zOnRequestHardwareResource) {
                RLog.i("IMLibExtensionModuleManager", "handledClass:" + iMLibExtensionModule.getClass().getSimpleName());
                return zOnRequestHardwareResource;
            }
            z = zOnRequestHardwareResource;
        }
        return z;
    }

    public void registerModulesByName(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            loadIMLibModuleByName(it.next());
        }
    }

    private IMLibExtensionModuleManager() {
        init();
    }
}
