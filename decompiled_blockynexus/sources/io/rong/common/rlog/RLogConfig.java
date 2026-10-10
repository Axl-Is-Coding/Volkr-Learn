package io.rong.common.rlog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import io.rong.imlib.common.SavePathUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
public class RLogConfig {
    public static final long DEFAULT_MAX_SIZE = 1048576;
    private static final String LOG_DIR = "RLog";
    public static final String LOG_SUFFIX = ".log";
    private static final String R_FILE_MAX_SIZE = "r_file_max_size";
    private static final String R_LOG_LEVEL = "r_log_level";
    private static final String R_START_TIME = "r_start_time";
    private static final String R_UPLOAD_URL = "r_upload_url";
    private static final String R_ZIP_CONFIG = "r_zip_config";
    private static final String R_ZIP_MAX_SIZE = "r_zip_max_size";
    private static final String SP_NAME = "FwLog";
    private static final String TAG = "RLogConfig";
    public static final String ZIP_SUFFIX = ".gz";
    private static SharedPreferences mSp;
    private boolean isDebugMode;
    private String mAppKey;
    private String mLogPath;
    private String mSdkVersion;
    private long mStartTime;
    private ZipConfig mZipConfig;
    private String uploadUrl;
    private String userId;
    private String mFileName = "r.log";
    private int mLogLevel = 0;
    private long mFileMaxSize = 1048576;
    private long mZipMaxSize = 1048576;
    private boolean isFirstGetLevel = true;
    private boolean isFirstFileMaxSize = true;
    private boolean isFirstZipMaxSize = true;
    private boolean isFirstStartTime = true;

    public class ZipConfig {
        private long currentSize;
        private TreeSet<File> zipFiles;

        public ZipConfig(long j, TreeSet<File> treeSet) {
            this.currentSize = j;
            this.zipFiles = treeSet;
        }

        public void addFile(File file) {
            this.zipFiles.add(file);
        }

        public void clear() {
            TreeSet<File> treeSet = this.zipFiles;
            if (treeSet != null) {
                treeSet.clear();
                this.zipFiles = null;
            }
        }

        public long getCurrentSize() {
            return this.currentSize;
        }

        public TreeSet<File> getZipFiles() {
            return this.zipFiles;
        }

        public void setCurrentSize(long j) {
            this.currentSize = j;
        }
    }

    public RLogConfig(Context context, String str, String str2) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        this.isDebugMode = (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
        File externalFilesDir = null;
        this.mAppKey = str;
        this.mSdkVersion = str2;
        mSp = context.getSharedPreferences(SP_NAME, 0);
        if (SavePathUtils.isSavePathEmpty()) {
            try {
                externalFilesDir = context.getExternalFilesDir(LOG_DIR);
            } catch (ArrayIndexOutOfBoundsException e2) {
                RLog.e(TAG, TAG, e2);
            }
            if (externalFilesDir != null) {
                this.mLogPath = externalFilesDir.getAbsolutePath();
            } else {
                try {
                    this.mLogPath = context.getFilesDir().getAbsoluteFile() + File.separator + LOG_DIR;
                } catch (Exception e3) {
                    RLog.e(TAG, TAG, e3);
                }
            }
        } else {
            RLog.e(TAG, SavePathUtils.getSavePath());
            this.mLogPath = SavePathUtils.getSavePath() + File.separator + LOG_DIR;
            File file = new File(this.mLogPath);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        initZipConfig();
    }

    private ZipConfig refreshZipConfig() {
        File file = new File(this.mLogPath);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: io.rong.common.rlog.RLogConfig.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isFile()) {
                    return file2.getName().endsWith(RLogConfig.ZIP_SUFFIX);
                }
                return false;
            }
        });
        TreeSet treeSet = new TreeSet(new Comparator<File>() { // from class: io.rong.common.rlog.RLogConfig.2
            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                return file2.lastModified() - file3.lastModified() < 0 ? -1 : 1;
            }
        });
        long length = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                length += file2.length();
                treeSet.add(file2);
            }
        }
        return new ZipConfig(length, treeSet);
    }

    public void clearZipConfig() {
        ZipConfig zipConfig = this.mZipConfig;
        if (zipConfig != null) {
            zipConfig.clear();
            this.mZipConfig = null;
        }
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public long getFileMaxSize() {
        SharedPreferences sharedPreferences;
        if (this.isFirstFileMaxSize && (sharedPreferences = mSp) != null) {
            this.mFileMaxSize = sharedPreferences.getLong(R_FILE_MAX_SIZE, 1048576L);
            this.isFirstFileMaxSize = false;
        }
        return this.mFileMaxSize;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFilePath() {
        return this.mLogPath + File.separator + this.mFileName;
    }

    public int getLogLevel() {
        SharedPreferences sharedPreferences;
        if (this.isFirstGetLevel && (sharedPreferences = mSp) != null) {
            this.mLogLevel = sharedPreferences.getInt(R_LOG_LEVEL, 0);
            this.isFirstGetLevel = false;
        }
        return this.mLogLevel;
    }

    public String getLogPath() {
        return this.mLogPath;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public long getStartTime() {
        SharedPreferences sharedPreferences;
        if (this.isFirstStartTime && (sharedPreferences = mSp) != null) {
            this.mStartTime = sharedPreferences.getLong(R_START_TIME, System.currentTimeMillis());
            this.isFirstStartTime = false;
        }
        return this.mStartTime;
    }

    public String getUploadUrl() {
        SharedPreferences sharedPreferences;
        if (this.uploadUrl == null && (sharedPreferences = mSp) != null) {
            this.uploadUrl = sharedPreferences.getString(R_UPLOAD_URL, "https://feedback.cn.ronghub.com");
        }
        return this.uploadUrl;
    }

    public String getUserId() {
        return this.userId;
    }

    public ZipConfig getZipConfig() {
        return this.mZipConfig;
    }

    public long getZipMaxSize() {
        SharedPreferences sharedPreferences;
        if (this.isFirstZipMaxSize && (sharedPreferences = mSp) != null) {
            this.mZipMaxSize = sharedPreferences.getLong(R_ZIP_MAX_SIZE, 1048576L);
            this.isFirstZipMaxSize = false;
        }
        return this.mZipMaxSize;
    }

    public void initZipConfig() {
        this.mZipConfig = refreshZipConfig();
    }

    public boolean isDebugMode() {
        return this.isDebugMode;
    }

    public void setFileMaxSize(long j) {
        this.mFileMaxSize = j;
        SharedPreferences sharedPreferences = mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(R_FILE_MAX_SIZE, j).apply();
        }
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setLogLevel(int i) {
        this.mLogLevel = i;
        SharedPreferences sharedPreferences = mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(R_LOG_LEVEL, i).apply();
        }
    }

    public void setLogPath(String str) {
        this.mLogPath = str;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
        SharedPreferences sharedPreferences = mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(R_START_TIME, j).apply();
        }
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
        SharedPreferences sharedPreferences = mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(R_UPLOAD_URL, str).apply();
        }
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setZipMaxSize(long j) {
        this.mZipMaxSize = j;
        SharedPreferences sharedPreferences = mSp;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(R_ZIP_MAX_SIZE, j).apply();
        }
    }
}
