package com.localapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class Skins {
    private static final int PACK_ATTEMPTS = 3;
    private static final int PACK_CONNECT_TIMEOUT_MS = 10000;
    private static final int PACK_READ_TIMEOUT_MS = 30000;
    private static final int PROXY_TIMEOUT_MS = 6000;
    private static boolean loaded;
    private static boolean packThreadStarted;
    private static final String ICON_PACK_URL = System.getProperty("localapi.iconPackUrl", "https://github.com/Disable-OP/Local-Blockman-GO-1.24.4/releases/download/localapi-assets/skins.tar.gz");
    private static final Object LOCK = new Object();
    private static Map<Long, JSONObject> byId = new HashMap();
    private static Map<Long, JSONArray> byType = new HashMap();

    private Skins() {
    }

    static void ensure(StateStore stateStore) {
        try {
            loadOrSeed(stateStore);
        } catch (Throwable th) {
            L.e("skins: catalog load failed: " + th);
        }
        startPackThread(stateStore);
    }

    private static void loadOrSeed(StateStore stateStore) throws Exception {
        synchronized (LOCK) {
            if (loaded) {
                return;
            }
            File fileCatalogFile = catalogFile(stateStore);
            File fileSeedFile = seedFile(stateStore);
            String strSeedStamp = seedStamp(fileSeedFile);
            if (fileCatalogFile.exists()) {
                try {
                    JSONObject jSONObject = new JSONObject(slurp(fileCatalogFile));
                    if (strSeedStamp != null && !strSeedStamp.equals(jSONObject.optString("seedStamp"))) {
                        L.i("skins: seed changed (" + jSONObject.optString("seedStamp") + " -> " + strSeedStamp + ") — reseeding");
                    }
                    parseCatalog(jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS));
                    loaded = true;
                    L.i("skins: catalog loaded (" + byId.size() + " skins, " + byType.size() + " type groups)");
                    return;
                } catch (Throwable th) {
                    L.e("skins: catalog parse failed, reseeding: " + th);
                }
            }
            if (strSeedStamp == null) {
                loaded = true;
                L.i("skins: no seed present — catalog empty (legacy fallback)");
            } else {
                seedFromAsset(stateStore, fileSeedFile, strSeedStamp);
                loaded = true;
            }
        }
    }

    private static void seedFromAsset(StateStore stateStore, File file, String str) throws Exception {
        JSONArray jSONArrayOptJSONArray = new JSONObject(slurp(file)).optJSONArray("data");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            L.e("skins: seed has no data array — catalog stays empty");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seedStamp", str);
        jSONObject.put(FirebaseAnalytics.Param.ITEMS, jSONArrayOptJSONArray);
        File fileCatalogFile = catalogFile(stateStore);
        fileCatalogFile.getParentFile().mkdirs();
        atomicallyWrite(fileCatalogFile, jSONObject.toString().getBytes("UTF-8"));
        parseCatalog(jSONArrayOptJSONArray);
        L.i("skins: catalog seeded from asset (" + jSONArrayOptJSONArray.length() + " skins) -> " + fileCatalogFile.getName());
    }

    private static void parseCatalog(JSONArray jSONArray) {
        byId = new HashMap();
        byType = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                long jOptLong = jSONObjectOptJSONObject.optLong("id", -1L);
                if (jOptLong >= 0) {
                    byId.put(Long.valueOf(jOptLong), jSONObjectOptJSONObject);
                    long jOptLong2 = jSONObjectOptJSONObject.optLong("typeId", 0L);
                    JSONArray jSONArray2 = byType.get(Long.valueOf(jOptLong2));
                    if (jSONArray2 == null) {
                        jSONArray2 = new JSONArray();
                        byType.put(Long.valueOf(jOptLong2), jSONArray2);
                    }
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
    }

    static boolean hasCatalog() {
        boolean z;
        synchronized (LOCK) {
            z = loaded && !byId.isEmpty();
        }
        return z;
    }

    static JSONObject byId(long j) {
        JSONObject jSONObject;
        synchronized (LOCK) {
            jSONObject = loaded ? byId.get(Long.valueOf(j)) : null;
        }
        return jSONObject;
    }

    static JSONArray byType(long j) {
        JSONArray jSONArray;
        synchronized (LOCK) {
            jSONArray = loaded ? byType.get(Long.valueOf(j)) : null;
        }
        return jSONArray;
    }

    static String iconUrl(long j) {
        return "http://127.0.0.1:18080/localapi/skins/icons/" + j + ".png";
    }

    static byte[] iconBytes(StateStore stateStore, long j) {
        String strOptString;
        File fileIconFile = iconFile(stateStore, j);
        if (fileIconFile != null && fileIconFile.exists() && fileIconFile.length() > 0) {
            try {
                return slurpBin(fileIconFile);
            } catch (Throwable th) {
                L.e("skins: icon read failed id=" + j + ": " + th);
            }
        }
        JSONObject jSONObjectById = byId(j);
        if (jSONObjectById != null && (strOptString = jSONObjectById.optString("iconUrl", "")) != null && strOptString.startsWith("http")) {
            try {
                byte[] bArrHttpGet = httpGet(strOptString, 6000, 6000);
                if (bArrHttpGet == null || bArrHttpGet.length < 64) {
                    return null;
                }
                if (fileIconFile != null) {
                    try {
                        fileIconFile.getParentFile().mkdirs();
                        atomicallyWrite(fileIconFile, bArrHttpGet);
                    } catch (Throwable th2) {
                        L.e("skins: icon cache write failed id=" + j + ": " + th2);
                    }
                }
                return bArrHttpGet;
            } catch (Throwable th3) {
                L.i("skins: cdn proxy miss id=" + j + ": " + th3.getClass().getSimpleName());
            }
        }
        return null;
    }

    static String sniffMime(byte[] bArr) {
        if (bArr != null && bArr.length >= 12) {
            byte b2 = bArr[0];
            if ((b2 & 255) == 137 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
                return "image/png";
            }
            if ((b2 & 255) == 255 && (bArr[1] & 255) == 216) {
                return "image/jpeg";
            }
            if (b2 == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return "image/gif";
            }
            if (b2 == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
                return "image/webp";
            }
        }
        return "application/octet-stream";
    }

    private static void startPackThread(final StateStore stateStore) {
        synchronized (LOCK) {
            if (packThreadStarted) {
                return;
            }
            packThreadStarted = true;
            Thread thread = new Thread(new Runnable() { // from class: com.localapi.Skins.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Skins.ensurePack(stateStore);
                    } catch (Throwable th) {
                        L.i("skins: icon pack unavailable: " + th.getClass().getSimpleName());
                    }
                }
            }, "SkinsAssets");
            thread.setDaemon(true);
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ensurePack(StateStore stateStore) throws Exception {
        synchronized (LOCK) {
            if (byId.isEmpty()) {
                return;
            }
            File fileImgDir = imgDir(stateStore);
            File filePackFile = packFile(stateStore);
            int size = size();
            if ((fileImgDir.exists() ? fileImgDir.listFiles().length : 0) >= size) {
                return;
            }
            if (!filePackFile.exists() || filePackFile.length() < 1048576) {
                downloadPack(filePackFile);
            }
            if (!filePackFile.exists() || filePackFile.length() < 1048576) {
                return;
            }
            fileImgDir.mkdirs();
            int length = fileImgDir.exists() ? fileImgDir.listFiles().length : 0;
            extractPack(filePackFile, fileImgDir);
            L.i("skins: icon pack extracted (" + length + " -> " + (fileImgDir.exists() ? fileImgDir.listFiles().length : 0) + " / " + size + " icons)");
        }
    }

    private static void downloadPack(File file) throws Exception {
        IOException e2 = null;
        for (int i = 1; i <= 3; i++) {
            try {
                L.i("skins: downloading icon pack (attempt " + i + ")");
                byte[] bArrHttpGet = httpGet(ICON_PACK_URL, 10000, PACK_READ_TIMEOUT_MS);
                if (bArrHttpGet == null || bArrHttpGet.length < 1048576) {
                    throw new IOException("pack too small / empty");
                }
                atomicallyWrite(file, bArrHttpGet);
                L.i("skins: icon pack stored (" + file.length() + " bytes)");
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

    private static void extractPack(File file, File file2) throws Exception {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file), 65536);
        try {
            byte[] bArr = new byte[512];
            while (readFully(gZIPInputStream, bArr)) {
                for (int i = 0; i < 512; i++) {
                    if (bArr[i] != 0) {
                        String strCstr = cstr(bArr, 0, 100);
                        String strCstr2 = cstr(bArr, 345, 155);
                        if (strCstr2.length() > 0) {
                            strCstr = String.valueOf(strCstr2) + "/" + strCstr;
                        }
                        long jOctal = octal(bArr, 124, 12);
                        byte b2 = bArr[156];
                        int i2 = b2 == 0 ? 48 : b2 & 255;
                        if (i2 == 120 || i2 == 103 || i2 == 76 || i2 == 75) {
                            skipFully(gZIPInputStream, ((jOctal + 511) / 512) * 512);
                        } else {
                            File file3 = new File(file2, new File(strCstr).getName());
                            if (("0".equals(String.valueOf((char) i2)) || i2 == 0) && (!file3.exists() || file3.length() != jOctal)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                copyExactly(gZIPInputStream, fileOutputStream, jOctal);
                                fileOutputStream.close();
                            } else {
                                skipFully(gZIPInputStream, jOctal);
                            }
                            skipFully(gZIPInputStream, (512 - (jOctal % 512)) % 512);
                        }
                    }
                }
            }
        } finally {
            try {
                gZIPInputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    static int size() {
        int size;
        synchronized (LOCK) {
            size = byId.size();
        }
        return size;
    }

    private static File baseDir(StateStore stateStore) {
        return stateStore.baseDir();
    }

    private static File catalogFile(StateStore stateStore) {
        return new File(new File(baseDir(stateStore), "skins"), "catalog.json");
    }

    private static File seedFile(StateStore stateStore) {
        return new File(baseDir(stateStore), "skins_seed.json");
    }

    private static File imgDir(StateStore stateStore) {
        return new File(new File(baseDir(stateStore), "skins"), "img");
    }

    private static File packFile(StateStore stateStore) {
        return new File(new File(baseDir(stateStore), "skins"), "skins.tar.gz");
    }

    static File iconFile(StateStore stateStore, long j) {
        return new File(imgDir(stateStore), String.valueOf(j) + ".png");
    }

    private static String seedStamp(File file) {
        if (file == null || !file.exists() || file.length() == 0) {
            return null;
        }
        return String.valueOf(file.length()) + "-" + file.lastModified();
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

    private static void atomicallyWrite(File file, byte[] bArr) throws Exception {
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

    private static void copyExactly(InputStream inputStream, FileOutputStream fileOutputStream, long j) throws Exception {
        byte[] bArr = new byte[65536];
        while (j > 0) {
            int i = inputStream.read(bArr, 0, (int) Math.min(65536, j));
            if (i < 0) {
                throw new EOFException("archive truncated");
            }
            fileOutputStream.write(bArr, 0, i);
            j -= (long) i;
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
}
