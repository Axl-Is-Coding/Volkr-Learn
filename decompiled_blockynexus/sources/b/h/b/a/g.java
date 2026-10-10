package b.h.b.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.DateUtils;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: CacheManageUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static boolean a(Context context, int i) {
        String metaDataRootPath = BaseApplication.getApp().getMetaDataRootPath();
        try {
            if (i == 0) {
                a();
                b(metaDataRootPath);
                c(metaDataRootPath);
                a(context);
                return true;
            }
            if (i == 1) {
                b(metaDataRootPath);
                c(metaDataRootPath);
                return true;
            }
            if (i == 2) {
                a();
                return true;
            }
            if (i == 3) {
                a(context);
                return true;
            }
            if (i == 4) {
                b(metaDataRootPath);
                return true;
            }
            if (i != 5) {
                return false;
            }
            d(metaDataRootPath);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void b(String str) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory(), str + "/BlockMan/map");
            if (file.isDirectory() && i.a(file)) {
                file.mkdirs();
                Log.i("clearSdCardMapFileDisk", "clear successful");
            }
        }
        File file2 = new File("/", str + "/BlockMan/map");
        if (file2.isDirectory() && i.a(file2)) {
            file2.mkdirs();
            Log.i("clearMapFileDisk", "clear successful");
        }
    }

    private static void c(String str) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/map");
            if (file.isDirectory() && i.a(file)) {
                file.mkdirs();
                Log.i("clearSdCardMapFileDisk", "clear successful");
            }
        }
        File file2 = new File("/", str + "/BlockManv2/map");
        if (file2.isDirectory() && i.a(file2)) {
            file2.mkdirs();
            Log.i("clearMapFileDisk", "clear successful");
        }
    }

    private static void d(String str) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (a(new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/map"), new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/map_delete"))) {
                return;
            }
        }
        a(new File("/", str + "/BlockManv2/map"), new File("/", str + "/BlockManv2/map_delete"));
    }

    private static void a() throws Exception {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_DIR);
            if (file.isDirectory() && i.a(file)) {
                file.mkdirs();
                Log.i("clearSdCardImageCache", "clear successful");
            }
        }
        File file2 = new File("/", StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_DIR);
        if (file2.isDirectory() && i.a(file2)) {
            file2.mkdirs();
            Log.i("clearImageCache", "clear successful");
        }
    }

    private static long b(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null || !filesDir.isDirectory()) {
            return 0L;
        }
        long j = 0;
        for (File file : filesDir.listFiles()) {
            if (file.isDirectory()) {
                long jB = j;
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory() && ("image".equals(file2.getName()) || "voice".equals(file2.getName()))) {
                        jB += i.b(file);
                    }
                }
                j = jB;
            }
        }
        return j;
    }

    public static String b(Context context, int i, String str) {
        return i.a(context, Long.valueOf(a(context, i, str)));
    }

    private static boolean a(File file, File file2) {
        File[] fileArrListFiles;
        Log.i("clearSdCardMapFileDisk", "start clear successful");
        if ((file.exists() && file.isDirectory() && !file.renameTo(file2)) || (fileArrListFiles = file2.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isDirectory()) {
                File file4 = new File(file3.getAbsolutePath(), "checksums.md5");
                if (file4.exists() && file4.isFile() && file4.length() != 0) {
                    Map<String, String> mapA = i.a(file4.getAbsolutePath());
                    Log.i("clearSdCardMapFileDisk", "mapMD5List clear successful");
                    for (String str : mapA.keySet()) {
                        if (!TextUtils.isEmpty(str)) {
                            File file5 = new File(file3.getAbsolutePath(), str);
                            if (file5.exists()) {
                                file5.delete();
                            }
                        }
                    }
                    Log.i("clearSdCardMapFileDisk", "deleteDir clear successful");
                    i.a(file2);
                }
            }
        }
        Log.i("clearSdCardMapFileDisk", "end clear successful");
        return true;
    }

    public static void a(String str) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/map");
            if (file.isDirectory()) {
                Log.i("clearMapV2Cache", "Rename Start: " + DateUtils.timeStamp2Date(System.currentTimeMillis(), "HH:mm:ss.SSS"));
                File file2 = new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/mapBackup");
                file.renameTo(file2);
                Log.i("clearMapV2Cache", "Rename End: " + DateUtils.timeStamp2Date(System.currentTimeMillis(), "HH:mm:ss.SSS"));
                if (i.a(file2)) {
                    file.mkdirs();
                    Log.i("clearMapV2Cache", "clear successful");
                }
            }
        }
        File file3 = new File("/", str + "/BlockManv2/map");
        if (file3.isDirectory()) {
            File file4 = new File("/", str + "/BlockManv2/mapBackup");
            file3.renameTo(file4);
            if (i.a(file4)) {
                file3.mkdirs();
                Log.i("clearMapFileDisk", "clear successful");
            }
        }
    }

    private static void a(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null || !filesDir.isDirectory()) {
            return;
        }
        for (File file : filesDir.listFiles()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory() && (("image".equals(file2.getName()) || "voice".equals(file2.getName())) && i.a(file2))) {
                        file.mkdir();
                    }
                }
            }
        }
    }

    public static long a(Context context, int i, String str) {
        File file;
        File file2;
        long jB;
        long jB2;
        long jB3;
        long jB4;
        long jB5;
        long jB6;
        File file3 = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file3 = new File(Environment.getExternalStorageDirectory(), StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_DIR);
            file = new File(Environment.getExternalStorageDirectory(), str + "/BlockMan/map");
            file2 = new File(Environment.getExternalStorageDirectory(), str + "/BlockManv2/map");
        } else {
            file = null;
            file2 = null;
        }
        File file4 = new File("/", StringConstant.BLOCKY_MODS_CACHE_PATH_ICON_DIR);
        File file5 = new File("/", str + "/BlockMan/map");
        File file6 = new File("/", str + "/BlockManv2/map");
        if (i == 0) {
            long jB7 = file3 != null ? i.b(file3) : 0L;
            long jB8 = file != null ? i.b(file) : 0L;
            jB = file2 != null ? i.b(file2) : 0L;
            jB = i.b(file4);
            jB2 = i.b(file5);
            jB3 = i.b(file6);
            jB4 = b(context);
            long j = jB8;
            jB5 = jB;
            jB = jB7;
            jB6 = j;
        } else if (i == 1) {
            jB6 = file != null ? i.b(file) : 0L;
            jB5 = file2 != null ? i.b(file2) : 0L;
            jB2 = i.b(file5);
            jB3 = i.b(file6);
            jB = 0;
            jB4 = 0;
        } else if (i == 2) {
            long jB9 = file != null ? i.b(file3) : 0L;
            jB = i.b(file4);
            jB5 = 0;
            jB3 = 0;
            jB2 = 0;
            jB4 = 0;
            jB = jB9;
            jB6 = 0;
        } else if (i != 3) {
            jB6 = 0;
            jB5 = 0;
            jB3 = 0;
            jB = 0;
            jB2 = 0;
            jB4 = 0;
        } else {
            jB4 = b(context);
            jB6 = 0;
            jB5 = 0;
            jB3 = 0;
            jB = 0;
            jB2 = 0;
        }
        return jB + jB6 + jB5 + jB + jB2 + jB3 + jB4;
    }
}
