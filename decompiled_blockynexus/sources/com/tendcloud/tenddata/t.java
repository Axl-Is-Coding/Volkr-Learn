package com.tendcloud.tenddata;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f20057a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: td */
    static class a {
        private FileLock fileLock;
        private RandomAccessFile randomAccessFile;
        private Lock threadLock;

        private a() {
        }
    }

    /* JADX INFO: compiled from: td */
    public enum b {
        Cloud_Control_Lock_File("Cloud_Control_Cache_Param"),
        AntiCheating_Switch_Lock_File("AntiCheating_Switch_Value"),
        App_Lock_File("__App_Synchronous_Lock__"),
        Tracking_Lock_File("__Tracking_Synchronous_Lock__"),
        Env_Lock_File("__Env_Synchronous_Lock__"),
        Game_Lock_File("__Game_Synchronous_Lock__"),
        Push_Lock_File("__Push_Synchronous_Lock__"),
        SMS_Lock_File("__SMS_Synchronous_Lock__"),
        EAuth_Lock_File("__EAuth_Synchronous_Lock__"),
        App_SQL_Lock_File("__AppSQL_Synchronous_Lock__"),
        BG_Lock_File("__BG_Synchronous_Lock__"),
        Fintech_Lock_File("__Fintech_Synchronous_Lock__"),
        CSP_Lock_File("__CSP_Synchronous_Lock__"),
        BIO_Touch_Lock_File("__BIO_Touch_Synchronous_Lock__"),
        BIO_Text_Lock_File("__BIO_Text_Synchronous_Lock__"),
        AntiCheating_Data_Lock_File("AntiCheating_Data_Value"),
        Fintech_Data_Lock_File("_Fintech_Data_Lock"),
        AES_DATA_LOCK("_AES_DATA_LOCK"),
        AES_DATA_ENTRYCP_LOCK("_AES_DATA_ENTCRYPT_LOCK"),
        SMS_Model_Lock_File("__SMS_Model_Lock_File"),
        AES_SALT_LOCK("_AES_SALT_LOCK"),
        AES_IV_LOCK("_AES_IV_LOCK");

        private final String filePath;

        b(String str) {
            this.filePath = new File(ab.g.getFilesDir(), ab.t + str).getAbsolutePath();
        }

        public static String getFeatureLockFileName(int i) {
            switch (i) {
                case 0:
                    return App_Lock_File.toString();
                case 1:
                    return Tracking_Lock_File.toString();
                case 2:
                    return Env_Lock_File.toString();
                case 3:
                    return Game_Lock_File.toString();
                case 4:
                    return Push_Lock_File.toString();
                case 5:
                    return SMS_Lock_File.toString();
                case 6:
                    return EAuth_Lock_File.toString();
                case 7:
                    return App_SQL_Lock_File.toString();
                case 8:
                    return BG_Lock_File.toString();
                case 9:
                    return Fintech_Lock_File.toString();
                case 10:
                    return CSP_Lock_File.toString();
                case 11:
                case 13:
                default:
                    return null;
                case 12:
                    return BIO_Touch_Lock_File.toString();
                case 14:
                    return BIO_Text_Lock_File.toString();
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.filePath;
        }
    }

    public static boolean a(String str) {
        RandomAccessFile randomAccessFile;
        Lock reentrantLock;
        a aVar;
        try {
            if (af.b(str)) {
                throw new RuntimeException("LockManager Error: filePath can not be null!");
            }
            File file = new File(str);
            if (f20057a.containsKey(str)) {
                aVar = f20057a.get(str);
                randomAccessFile = aVar.randomAccessFile;
                reentrantLock = aVar.threadLock;
            } else {
                a aVar2 = new a();
                randomAccessFile = new RandomAccessFile(file, "rw");
                reentrantLock = new ReentrantLock();
                aVar2.randomAccessFile = randomAccessFile;
                aVar2.threadLock = reentrantLock;
                f20057a.put(str, aVar2);
                aVar = aVar2;
            }
            reentrantLock.lock();
            aVar.fileLock = randomAccessFile.getChannel().tryLock();
            return aVar.fileLock != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static RandomAccessFile b(String str) {
        try {
            if (af.b(str)) {
                throw new RuntimeException("LockManager Error: filePath can not be null!");
            }
            File file = new File(str);
            if (f20057a.containsKey(str)) {
                return f20057a.get(str).randomAccessFile;
            }
            a aVar = new a();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            ReentrantLock reentrantLock = new ReentrantLock();
            aVar.randomAccessFile = randomAccessFile;
            aVar.threadLock = reentrantLock;
            f20057a.put(str, aVar);
            return randomAccessFile;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getFileLock(String str) {
        RandomAccessFile randomAccessFile;
        Lock reentrantLock;
        a aVar;
        try {
            if (af.b(str)) {
                throw new RuntimeException("LockManager Error: filePath can not be null!");
            }
            File file = new File(str);
            if (f20057a.containsKey(str)) {
                aVar = f20057a.get(str);
                randomAccessFile = aVar.randomAccessFile;
                reentrantLock = aVar.threadLock;
            } else {
                a aVar2 = new a();
                randomAccessFile = new RandomAccessFile(file, "rw");
                reentrantLock = new ReentrantLock();
                aVar2.randomAccessFile = randomAccessFile;
                aVar2.threadLock = reentrantLock;
                f20057a.put(str, aVar2);
                aVar = aVar2;
            }
            reentrantLock.lock();
            aVar.fileLock = randomAccessFile.getChannel().lock();
        } catch (Throwable unused) {
        }
    }

    public static void releaseFileLock(String str) {
        try {
            if (af.b(str)) {
                throw new RuntimeException("LockManager Error: filePath can not be null!");
            }
            if (!f20057a.containsKey(str)) {
                throw new RuntimeException("LockManager Error: there is no information about this file in the cache!");
            }
            a aVar = f20057a.get(str);
            if (aVar.fileLock != null) {
                aVar.fileLock.release();
            }
            aVar.threadLock.unlock();
        } catch (Throwable unused) {
        }
    }
}
