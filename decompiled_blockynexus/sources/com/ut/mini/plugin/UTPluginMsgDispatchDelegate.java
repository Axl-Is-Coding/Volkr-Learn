package com.ut.mini.plugin;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UTPluginMsgDispatchDelegate {
    private Object g;

    public UTPluginMsgDispatchDelegate(Object obj) {
        this.g = null;
        this.g = obj;
    }

    public Object getDispatchObject(UTPlugin uTPlugin) {
        return this.g;
    }

    public final Object getMsgObj() {
        return this.g;
    }

    public boolean isMatchPlugin(UTPlugin uTPlugin) {
        return true;
    }
}
