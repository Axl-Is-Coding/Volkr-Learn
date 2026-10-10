package com.getkeepsafe.relinker;

import android.os.Build;
import com.getkeepsafe.relinker.b;

/* JADX INFO: compiled from: SystemLibraryLoader.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements b.InterfaceC0099b {
    f() {
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0099b
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0099b
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0099b
    public String mapLibraryName(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0099b
    public String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        return !g.a(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
    }

    @Override // com.getkeepsafe.relinker.b.InterfaceC0099b
    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }
}
