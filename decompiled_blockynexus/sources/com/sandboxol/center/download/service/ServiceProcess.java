package com.sandboxol.center.download.service;

import com.sandboxol.center.download.interfaces.IServiceProcess;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceProcess {
    public static IServiceProcess getServiceProcess(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new CommonServiceProcess() : new MapServiceProcess() : new CommonServiceProcess() : new AloneGameServiceProcess() : new CommonGameServiceProcess() : new DressServiceProcess();
    }
}
