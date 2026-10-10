package io.rong.imlib.relinker;

import android.os.Build;
import io.rong.imlib.relinker.ReLinker;

/* JADX INFO: loaded from: classes5.dex */
final class SystemLibraryLoader implements ReLinker.LibraryLoader {
    SystemLibraryLoader() {
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryLoader
    public void loadPath(String str) {
        System.load(str);
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryLoader
    public String mapLibraryName(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryLoader
    public String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                return strArr;
            }
        }
        return !TextUtils.isEmpty(Build.CPU_ABI2) ? new String[]{Build.CPU_ABI, Build.CPU_ABI2} : new String[]{Build.CPU_ABI};
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryLoader
    public String unmapLibraryName(String str) {
        return str.substring(3, str.length() - 3);
    }
}
