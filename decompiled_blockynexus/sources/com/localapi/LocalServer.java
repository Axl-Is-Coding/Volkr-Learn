package com.localapi;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes6.dex */
public final class LocalServer {
    public static final int PORT = 18080;
    static final long WATCHDOG_INTERVAL_MS = 5000;
    private static volatile LocalHttpd httpd = null;
    static volatile boolean watchdogEnabled = true;
    private static volatile boolean watchdogRunning = false;

    private LocalServer() {
    }

    public static void startIfNeeded(Context context) {
        Context applicationContext = context.getApplicationContext();
        File filesDir = applicationContext.getFilesDir();
        copySeedAsset(applicationContext, "localapi/skins.json", new File(new File(filesDir, "localapi"), "skins_seed.json"));
        copySeedAsset(applicationContext, "localapi/ScriptSetting.csv", new File(new File(filesDir, "localapi"), "games_seed.csv"));
        start(filesDir, PORT);
    }

    private static void copySeedAsset(Context context, String str, File file) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            long jAvailable = inputStreamOpen.available();
            if (file.exists() && file.length() == jAvailable) {
                inputStreamOpen.close();
                return;
            }
            file.getParentFile().mkdirs();
            File file2 = new File(file.getParentFile(), String.valueOf(file.getName()) + ".tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[65536];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            fileOutputStream.close();
            inputStreamOpen.close();
            if (!file2.renameTo(file)) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                FileInputStream fileInputStream = new FileInputStream(file2);
                byte[] bArr2 = new byte[65536];
                while (true) {
                    int i2 = fileInputStream.read(bArr2);
                    if (i2 <= 0) {
                        break;
                    } else {
                        fileOutputStream2.write(bArr2, 0, i2);
                    }
                }
                fileInputStream.close();
                fileOutputStream2.close();
                file2.delete();
            }
            L.i("seed asset copied: " + str + " -> " + file.getName() + " (" + file.length() + " bytes)");
        } catch (Throwable th) {
            L.e("seed asset " + str + " unavailable: " + th);
        }
    }

    static void start(File file, int i) {
        if (probeServing(i)) {
            L.i("boot: another LocalAPI instance already serving 127.0.0.1:" + i);
            startWatchdog(file, i);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 < 5 && !isUp()) {
                bootOnce(file, i, i2 > 0 ? " (retry " + i2 + ")" : "");
                if (isUp()) {
                    break;
                }
                if (probeServing(i)) {
                    L.i("boot: bind lost but a sibling LocalAPI holder answers — standing by (watchdog supervises)");
                    break;
                }
                try {
                    Thread.sleep(1000L);
                    i2++;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } else {
                break;
            }
        }
        startWatchdog(file, i);
    }

    private static void startWatchdog(final File file, final int i) {
        if (!watchdogEnabled || watchdogRunning) {
            return;
        }
        watchdogRunning = true;
        Thread thread = new Thread(new Runnable() { // from class: com.localapi.LocalServer.1
            @Override // java.lang.Runnable
            public void run() {
                byte b2;
                byte b3 = -1;
                while (LocalServer.watchdogEnabled && !Thread.currentThread().isInterrupted()) {
                    if (LocalServer.isUp()) {
                        b2 = 0;
                    } else {
                        b2 = LocalServer.probeServing(i) ? (byte) 1 : (byte) 2;
                    }
                    if (b2 != b3) {
                        if (b2 == 1) {
                            L.i("watchdog: another LocalAPI instance is serving 127.0.0.1:" + i + " — standing by");
                        } else if (b2 == 2) {
                            L.i("watchdog: no server answering on 127.0.0.1:" + i + " — booting");
                        }
                        b3 = b2;
                    }
                    if (b2 == 2) {
                        LocalServer.bootOnce(file, i, " (watchdog)");
                    }
                    try {
                        Thread.sleep(LocalServer.WATCHDOG_INTERVAL_MS);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
        }, "LocalApiWatchdog");
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bootOnce(File file, int i, String str) {
        try {
            L.i("boot: starting local api on 127.0.0.1:" + i + str);
            StateStore stateStore = new StateStore(file);
            GameCatalog.ensure(stateStore);
            GameCatalog.drift(stateStore);
            Skins.ensure(stateStore);
            MapAssets.ensure(stateStore);
            DressRes.ensure(stateStore);
            LocalHttpd localHttpd = new LocalHttpd(i, stateStore);
            localHttpd.start(15000, true);
            httpd = localHttpd;
            L.i("boot: local api is UP on http://127.0.0.1:" + i + " (users=" + stateStore.userCount() + ")");
        } catch (Throwable th) {
            L.e("boot" + str + " failed: " + th);
        }
    }

    static boolean probeServing(int i) {
        Socket socket = new Socket();
        boolean z = false;
        try {
            try {
                socket.connect(new InetSocketAddress("127.0.0.1", i), 500);
                socket.setSoTimeout(500);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("GET /health HTTP/1.0\r\n\r\n".getBytes("UTF-8"));
                outputStream.flush();
                byte[] bArr = new byte[16];
                int i2 = socket.getInputStream().read(bArr);
                if (i2 > 0) {
                    if (new String(bArr, 0, i2, "UTF-8").startsWith("HTTP/")) {
                        z = true;
                    }
                }
                try {
                    socket.close();
                } catch (Throwable unused) {
                }
                return z;
            } catch (Throwable unused2) {
                socket.close();
                return false;
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    static LocalHttpd currentServer() {
        return httpd;
    }

    public static boolean isRunning() {
        return httpd != null && httpd.isUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isUp() {
        LocalHttpd localHttpd = httpd;
        return localHttpd != null && localHttpd.isUp();
    }
}
