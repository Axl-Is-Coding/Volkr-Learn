package com.localapi;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class DressRes {
    private static final int DRESS_VERSION = 31;
    private static final int PACK_ATTEMPTS = 3;
    private static final int PACK_CONNECT_TIMEOUT_MS = 10000;
    private static final String PACK_NAME = "decorate_merged_v31.1623125813504.zip";
    private static final int PACK_READ_TIMEOUT_MS = 120000;
    private static volatile Boolean packOk;
    private static boolean packThreadStarted;
    private static final int PACK_MIN_BYTES = Integer.getInteger("localapi.dressPackMinBytes", 1048576).intValue();
    private static final String PACK_URL = System.getProperty("localapi.dressPackUrl", "https://github.com/Disable-OP/Local-Blockman-GO-1.24.4/releases/download/localapi-assets/decorate_merged_v31.1623125813504.zip");
    private static final String PACK_MD5 = System.getProperty("localapi.dressPackMd5", "ae133c31151484813ee4b605a1859c7c");
    private static final Object LOCK = new Object();

    private DressRes() {
    }

    static void ensure(StateStore stateStore) {
        startPackThread(stateStore);
    }

    static String packPath() {
        return "/sandbox/dresses/dress-resources/decorate_merged_v31.1623125813504.zip";
    }

    static byte[] packBytes(StateStore stateStore) {
        File filePackFile = packFile(stateStore);
        if (filePackFile.exists() && filePackFile.length() != 0) {
            try {
                return slurpBin(filePackFile);
            } catch (Throwable th) {
                L.e("dress: pack read failed: " + th);
            }
        }
        return null;
    }

    static JSONObject checkResponse(StateStore stateStore, long j) throws JSONException {
        int i;
        boolean zEnsurePack = ensurePack(stateStore);
        File filePackFile = packFile(stateStore);
        long length = (zEnsurePack && filePackFile.exists()) ? filePackFile.length() : 0L;
        boolean z = false;
        if (zEnsurePack) {
            try {
                ZipFile zipFile = new ZipFile(filePackFile);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    i = 0;
                    while (enumerationEntries.hasMoreElements()) {
                        if (!enumerationEntries.nextElement().isDirectory()) {
                            i++;
                        }
                    }
                } finally {
                    zipFile.close();
                }
            } catch (Throwable th) {
                L.e("dress: zip listing failed: " + th);
                i = 0;
            }
        } else {
            i = 0;
        }
        if (zEnsurePack && j < 31) {
            z = true;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("needUpdate", z);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("base", true);
        jSONObject2.put("cdnId", "local");
        jSONObject2.put("cdnUrl", "http://127.0.0.1:18080");
        jSONObject2.put("ratio", 1);
        jSONObject2.put("url", "http://127.0.0.1:18080" + packPath());
        jSONArray.put(jSONObject2);
        jSONObject.put("cdns", jSONArray);
        jSONObject.put("fileCount", i);
        jSONObject.put("fileSize", length);
        Object obj = "";
        jSONObject.put("hash", zEnsurePack ? PACK_MD5 : "");
        if (zEnsurePack) {
            obj = "http://127.0.0.1:18080" + packPath();
        }
        jSONObject.put("url", obj);
        jSONObject.put("version", zEnsurePack ? 31 : Math.max(1, (int) j));
        return jSONObject;
    }

    private static void startPackThread(final StateStore stateStore) {
        synchronized (LOCK) {
            if (packThreadStarted) {
                return;
            }
            packThreadStarted = true;
            Thread thread = new Thread(new Runnable() { // from class: com.localapi.DressRes.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DressRes.ensurePack(stateStore);
                    } catch (Throwable th) {
                        L.i("dress: pack unavailable: " + th.getClass().getSimpleName());
                    }
                }
            }, "DressAssets");
            thread.setDaemon(true);
            thread.start();
        }
    }

    static boolean ensurePack(StateStore stateStore) {
        Boolean bool = packOk;
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (LOCK) {
            if (packOk != null) {
                return packOk.booleanValue();
            }
            File filePackFile = packFile(stateStore);
            if (filePackFile.exists() && filePackFile.length() >= PACK_MIN_BYTES) {
                packOk = Boolean.TRUE;
                L.i("dress: pack present (" + filePackFile.length() + " bytes)");
                return true;
            }
            IOException e2 = null;
            for (int i = 1; i <= 3 && e2 == null; i++) {
                try {
                    L.i("dress: downloading decorate pack (attempt " + i + ")");
                    byte[] bArrHttpGet = httpGet(PACK_URL, 10000, 120000);
                    if (bArrHttpGet == null || bArrHttpGet.length < PACK_MIN_BYTES) {
                        throw new IOException("pack too small / empty");
                    }
                    atomicallyWrite(filePackFile, bArrHttpGet);
                    packOk = Boolean.TRUE;
                    L.i("dress: decorate pack stored (" + bArrHttpGet.length + " B)");
                    return true;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        Thread.sleep(((long) i) * 5000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } catch (Exception e4) {
                    e2 = new IOException(e4.getMessage());
                }
            }
            packOk = Boolean.FALSE;
            return false;
        }
    }

    private static void atomicallyWrite(File file, byte[] bArr) throws Exception {
        file.getParentFile().mkdirs();
        File file2 = new File(file.getParentFile(), String.valueOf(file.getName()) + ".tmp");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
        if (file2.renameTo(file)) {
            return;
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
        fileOutputStream2.write(bArr);
        fileOutputStream2.close();
        file2.delete();
    }

    private static byte[] httpGet(String str, int i, int i2) throws Exception {
        if (str.startsWith("file://")) {
            return slurpBin(new File(str.substring(7)));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, "LocalAPI/1.0");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new IOException("http " + responseCode);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[65536];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 > 0) {
                        byteArrayOutputStream.write(bArr, 0, i3);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } finally {
                inputStream.close();
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private static byte[] slurpBin(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[65536];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    private static File packFile(StateStore stateStore) {
        return new File(dir(stateStore), PACK_NAME);
    }

    private static File dir(StateStore stateStore) {
        return new File(stateStore.baseDir(), "dress");
    }
}
