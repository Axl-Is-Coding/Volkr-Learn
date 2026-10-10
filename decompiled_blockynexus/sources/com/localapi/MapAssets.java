package com.localapi;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class MapAssets {
    private static final int PACK_ATTEMPTS = 3;
    private static final int PACK_CONNECT_TIMEOUT_MS = 10000;
    private static final int PACK_READ_TIMEOUT_MS = 120000;
    private static volatile boolean indexed;
    private static boolean packThreadStarted;
    private static final int PACK_MIN_BYTES = Integer.getInteger("localapi.mapPackMinBytes", 1048576).intValue();
    private static final String PACK_URL = System.getProperty("localapi.mapPackUrl", "https://github.com/Disable-OP/Local-Blockman-GO-1.24.4/releases/download/localapi-assets/maps.tar.gz");
    private static final String PACK_SHA256 = System.getProperty("localapi.mapPackSha256", "e86ac824030de9503f7eb2f7b3bc3248d1abfc0f84914b0c27b8976581ba5672");
    private static final Object LOCK = new Object();
    private static volatile Map<String, JSONObject> byGame = new HashMap();
    private static volatile Map<String, File> byKey = new HashMap();

    private MapAssets() {
    }

    static void ensure(StateStore stateStore) {
        loadIndex(stateStore);
        startPackThread(stateStore);
    }

    static JSONObject entryForGame(String str) {
        Map<String, JSONObject> map = byGame;
        if (map == null || str == null) {
            return null;
        }
        return map.get(str);
    }

    static String durlFor(JSONObject jSONObject) {
        return "http://127.0.0.1:18080/sandbox/games/maps/" + jSONObject.optString("zipName");
    }

    static boolean hasIndex() {
        return indexed && !byKey.isEmpty();
    }

    static File resolveUri(StateStore stateStore, String str) {
        File file;
        Map<String, File> map = byKey;
        if (map != null && (file = map.get(str)) != null) {
            return file;
        }
        File file2 = new File(mapsDir(stateStore), str);
        if (file2.exists() && file2.isFile()) {
            return file2;
        }
        return null;
    }

    static byte[] fileBytes(StateStore stateStore, String str) {
        File fileResolveUri = resolveUri(stateStore, str);
        if (fileResolveUri != null && fileResolveUri.exists() && fileResolveUri.length() != 0) {
            try {
                return slurpBin(fileResolveUri);
            } catch (Throwable th) {
                L.e("maps: read failed " + str + ": " + th);
            }
        }
        return null;
    }

    private static void startPackThread(final StateStore stateStore) {
        synchronized (LOCK) {
            if (packThreadStarted) {
                return;
            }
            packThreadStarted = true;
            Thread thread = new Thread(new Runnable() { // from class: com.localapi.MapAssets.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MapAssets.ensurePack(stateStore);
                    } catch (Throwable th) {
                        L.i("maps: pack unavailable: " + th.getClass().getSimpleName());
                    }
                }
            }, "MapAssets");
            thread.setDaemon(true);
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ensurePack(StateStore stateStore) throws Exception {
        synchronized (LOCK) {
            if (!indexed || byGame.isEmpty()) {
                File fileMapsDir = mapsDir(stateStore);
                File filePackFile = packFile(stateStore);
                fileMapsDir.mkdirs();
                if (!filePackFile.exists() || filePackFile.length() < PACK_MIN_BYTES) {
                    downloadPack(filePackFile);
                }
                verifyPack(filePackFile);
                extractPack(stateStore, filePackFile);
                buildIndex(stateStore);
            }
        }
    }

    private static void downloadPack(File file) throws Exception {
        IOException e2 = null;
        for (int i = 1; i <= 3; i++) {
            try {
                L.i("maps: downloading map pack (attempt " + i + ")");
                byte[] bArrHttpGet = httpGet(PACK_URL, 10000, 120000);
                if (bArrHttpGet == null || bArrHttpGet.length < PACK_MIN_BYTES) {
                    throw new IOException("pack too small / empty");
                }
                atomicallyWrite(file, bArrHttpGet);
                L.i("maps: pack stored (" + file.length() + " bytes)");
                return;
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Thread.sleep(((long) i) * 5000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        if (e2 != null) {
            throw e2;
        }
        throw new IOException("pack download failed");
    }

    private static void verifyPack(File file) throws Exception {
        String str = PACK_SHA256;
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        String strSha256 = sha256(file);
        if (strTrim.equalsIgnoreCase(strSha256)) {
            L.i("maps: pack sha256 verified");
        } else {
            file.delete();
            throw new IOException("map pack sha256 mismatch (" + strSha256.substring(0, 12) + "... != " + strTrim.substring(0, 12) + "...) - rejected");
        }
    }

    private static void extractPack(StateStore stateStore, File file) throws Exception {
        File fileMapsDir = mapsDir(stateStore);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file), 65536);
        try {
            byte[] bArr = new byte[512];
            int i = 0;
            loop0: while (readFully(gZIPInputStream, bArr)) {
                for (int i2 = 0; i2 < 512; i2++) {
                    if (bArr[i2] != 0) {
                        String strCstr = cstr(bArr, 0, 100);
                        String strCstr2 = cstr(bArr, 345, 155);
                        if (strCstr2.length() > 0) {
                            strCstr = String.valueOf(strCstr2) + "/" + strCstr;
                        }
                        long jOctal = octal(bArr, 124, 12);
                        byte b2 = bArr[156];
                        int i3 = b2 == 0 ? 48 : b2 & 255;
                        if (i3 == 120 || i3 == 103 || i3 == 76 || i3 == 75) {
                            skipFully(gZIPInputStream, ((jOctal + 511) / 512) * 512);
                        } else {
                            if (i3 == 53) {
                                new File(fileMapsDir, strCstr).mkdirs();
                                skipFully(gZIPInputStream, jOctal);
                            } else if (i3 == 48 || i3 == 0) {
                                File file2 = new File(fileMapsDir, strCstr);
                                if (file2.getParentFile() != null) {
                                    file2.getParentFile().mkdirs();
                                }
                                if (file2.exists() && file2.length() == jOctal) {
                                    skipFully(gZIPInputStream, jOctal);
                                } else {
                                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                    try {
                                        copyExactly(gZIPInputStream, fileOutputStream, jOctal);
                                        fileOutputStream.close();
                                        i++;
                                    } catch (Throwable th) {
                                        fileOutputStream.close();
                                        throw th;
                                    }
                                }
                            } else {
                                skipFully(gZIPInputStream, jOctal);
                            }
                            skipFully(gZIPInputStream, (512 - (jOctal % 512)) % 512);
                        }
                    }
                }
            }
            L.i("maps: pack extracted (" + i + " files written)");
        } finally {
            try {
                gZIPInputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void buildIndex(com.localapi.StateStore r23) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.localapi.MapAssets.buildIndex(com.localapi.StateStore):void");
    }

    private static void loadIndex(StateStore stateStore) {
        if (indexed) {
            return;
        }
        synchronized (LOCK) {
            if (indexed) {
                return;
            }
            File fileIndexFile = indexFile(stateStore);
            if (!fileIndexFile.exists() || fileIndexFile.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(slurp(fileIndexFile));
                HashMap map = new HashMap();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("games");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.optJSONObject(next));
                    }
                }
                HashMap map2 = new HashMap();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("files");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!strOptString.isEmpty()) {
                            File file = new File(mapsDir(stateStore), strOptString);
                            if (file.exists()) {
                                map2.put(strOptString, file);
                            }
                        }
                    }
                }
                byGame = map;
                byKey = map2;
                indexed = true;
                L.i("maps: index loaded (" + map.size() + " games, " + map2.size() + " files)");
            } catch (Throwable th) {
                L.e("maps: index parse failed: " + th);
            }
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

    private static long copyExactly(InputStream inputStream, FileOutputStream fileOutputStream, long j) throws Exception {
        byte[] bArr = new byte[65536];
        long j2 = j;
        while (j2 > 0) {
            int i = inputStream.read(bArr, 0, (int) Math.min(65536L, j2));
            if (i < 0) {
                throw new EOFException("archive truncated");
            }
            fileOutputStream.write(bArr, 0, i);
            j2 -= (long) i;
        }
        return j;
    }

    private static boolean readFully(InputStream inputStream, byte[] bArr) throws Exception {
        int i = 0;
        while (i < bArr.length) {
            int i2 = inputStream.read(bArr, i, bArr.length - i);
            if (i2 < 0) {
                return i > 0 && i == bArr.length;
            }
            i += i2;
        }
        return true;
    }

    private static void skipFully(InputStream inputStream, long j) throws Exception {
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip <= 0) {
                if (inputStream.read() < 0) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j -= jSkip;
        }
    }

    private static String cstr(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        int i4 = i;
        while (i4 < i3 && bArr[i4] != 0) {
            i4++;
        }
        return new String(bArr, i, i4 - i).trim();
    }

    private static long octal(byte[] bArr, int i, int i2) {
        byte b2;
        long j = 0;
        for (int i3 = i; i3 < i + i2 && (b2 = bArr[i3]) != 0 && b2 != 32; i3++) {
            if (b2 >= 48 && b2 <= 55) {
                j = (j << 3) + ((long) (b2 - 48));
            }
        }
        return j;
    }

    private static String sha256(File file) throws Exception {
        int i;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[65536];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest()) {
                sb.append(Character.forDigit((b2 >> 4) & 15, 16));
                sb.append(Character.forDigit(b2 & ci.m, 16));
            }
            return sb.toString();
        } finally {
            fileInputStream.close();
        }
    }

    private static String slurp(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[65536];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }
        } finally {
            fileInputStream.close();
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

    private static long parseLong(String str, long j) {
        try {
            return Long.parseLong(str.trim());
        } catch (Throwable unused) {
            return j;
        }
    }

    private static File mapsDir(StateStore stateStore) {
        return new File(stateStore.baseDir(), "maps");
    }

    private static File packFile(StateStore stateStore) {
        return new File(mapsDir(stateStore), "maps.tar.gz");
    }

    private static File indexFile(StateStore stateStore) {
        return new File(mapsDir(stateStore), "index.json");
    }
}
