package com.sandboxol.center.router.module_application;

import android.app.Application;
import com.apkfuns.logutils.c;

/* JADX INFO: loaded from: classes.dex */
public class ModuleApplication {

    /* JADX INFO: loaded from: classes3.dex */
    private static class SingletonHolder {
        public static ModuleApplication instance = new ModuleApplication();

        private SingletonHolder() {
        }
    }

    public static ModuleApplication getInstance() {
        return SingletonHolder.instance;
    }

    public void onCreate(Application application) {
        for (String str : ModuleReflexs.initModuleNames) {
            try {
                c.a("组件名称开始=").d(str.toString());
                ((IModuleInit) Class.forName(str).newInstance()).onCreate(application);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onDestroy(Application application) {
        for (String str : ModuleReflexs.initModuleNames) {
            try {
                c.a("组件名称开始=").c(str.toString());
                ((IModuleInit) Class.forName(str).newInstance()).onDestroy(application);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }
}
