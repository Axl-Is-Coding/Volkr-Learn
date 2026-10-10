package io.rong.imlib.statistics;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class OpenUDIDAdapter {
    private static final String OPEN_UDID_MANAGER_CLASS_NAME = "org.openudid.OpenUDID_manager";

    public static String getOpenUDID() {
        try {
            Object objInvoke = Class.forName(OPEN_UDID_MANAGER_CLASS_NAME).getMethod("getOpenUDID", null).invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean isInitialized() {
        try {
            Object objInvoke = Class.forName(OPEN_UDID_MANAGER_CLASS_NAME).getMethod("isInitialized", null).invoke(null, null);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean isOpenUDIDAvailable() {
        try {
            Class.forName(OPEN_UDID_MANAGER_CLASS_NAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void sync(Context context) {
        try {
            Class.forName(OPEN_UDID_MANAGER_CLASS_NAME).getMethod("sync", Context.class).invoke(null, context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }
}
