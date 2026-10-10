package com.tendcloud.tenddata;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f19962a = 25;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static cq f19963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f19964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<Integer, TreeSet<cp>> f19965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CRC32 f19966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Integer, RandomAccessFile> f19967f;
    private Map<Integer, FileLock> g;
    private Lock h = new ReentrantLock();

    /* JADX INFO: compiled from: td */
    class a implements Runnable {
        private final String mFolderPath;
        private final String mNewFolder;
        private final TreeSet<cp> mQueue;

        private void deleteFile(String str, cp cpVar) {
            File file = new File(str + File.separator + cpVar.b());
            if (file.exists()) {
                file.delete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.mQueue != null) {
                    this.mQueue.isEmpty();
                    while (!this.mQueue.isEmpty()) {
                        cp cpVarPollFirst = this.mQueue.pollFirst();
                        if (cpVarPollFirst != null) {
                            File file = new File(this.mFolderPath);
                            if (file.exists()) {
                                deleteFile(file.getAbsolutePath(), cpVarPollFirst);
                            }
                            File file2 = new File(this.mNewFolder);
                            if (file2.exists()) {
                                deleteFile(file2.getAbsolutePath(), cpVarPollFirst);
                            }
                        }
                    }
                    this.mQueue.clear();
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }

        private a(com.tendcloud.tenddata.a aVar) {
            this.mFolderPath = ab.g.getFilesDir() + File.separator + aVar.getDataFolder();
            this.mNewFolder = ab.g.getFilesDir() + File.separator + aVar.getRootFolder() + File.separator + aVar.getDataFolder();
            this.mQueue = (TreeSet) cq.this.f19965d.get(Integer.valueOf(aVar.index()));
        }
    }

    /* JADX INFO: compiled from: td */
    class b implements Runnable {
        private final String mFolderPath;
        private final cp mOperation;

        @Override // java.lang.Runnable
        public void run() {
            try {
                File file = new File(this.mFolderPath + File.separator + this.mOperation.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }

        private b(cp cpVar, com.tendcloud.tenddata.a aVar, String str) {
            String absolutePath = ab.g.getFilesDir().getAbsolutePath();
            if (!TextUtils.isEmpty(str)) {
                absolutePath = absolutePath + File.separator + str;
            }
            this.mFolderPath = absolutePath + File.separator + aVar.getDataFolder();
            this.mOperation = cpVar;
        }
    }

    /* JADX INFO: compiled from: td */
    class c implements Runnable {
        private cr callback;
        private com.tendcloud.tenddata.a features;
        private String mFolderPath;
        private final cp mOperation;
        private final cq opm;

        /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
        
            if (r3 == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
        
            r3.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
        
            r2.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
        
            if (r7.callback == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d8, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00e1 A[Catch: Throwable -> 0x00ed, TryCatch #1 {Throwable -> 0x00ed, blocks: (B:59:0x00dc, B:61:0x00e1, B:63:0x00e8), top: B:71:0x00dc }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.cq.c.run():void");
        }

        private c(cp cpVar, bx bxVar, cq cqVar) {
            File filesDir = ab.g.getFilesDir();
            this.opm = cqVar;
            this.mFolderPath = filesDir.toString() + File.separator + bxVar.f19905a.getDataFolder();
            this.mFolderPath = filesDir.toString() + File.separator + bxVar.f19905a.getRootFolder() + File.separator + bxVar.f19905a.getDataFolder();
            this.mOperation = cpVar;
            this.callback = bxVar.f19910f;
            this.features = bxVar.f19905a;
        }
    }

    private cq() {
        c();
        this.f19965d = new HashMap<>();
        for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
            this.f19965d.put(Integer.valueOf(aVar.index()), new TreeSet<>());
        }
        this.f19964c = Executors.newSingleThreadExecutor();
        this.f19966e = new CRC32();
    }

    private void c() {
        this.f19967f = new HashMap();
        this.g = new HashMap();
        try {
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(ab.g.getFilesDir(), aVar.getRootFolder());
                File file2 = new File(file, aVar.getDataFolder());
                if (!file2.exists() && !file2.mkdirs()) {
                    return;
                }
                this.f19967f.put(Integer.valueOf(aVar.index()), new RandomAccessFile(new File(file, "Lock" + aVar.index()), "rw"));
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void b() {
        File filesDir = ab.g.getFilesDir();
        try {
            int i = 0;
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(filesDir, aVar.getDataFolder());
                if (file.exists()) {
                    Iterator<File> it = c(file).iterator();
                    while (it.hasNext()) {
                        it.next().delete();
                    }
                }
            }
            com.tendcloud.tenddata.a[] aVarArrValues = com.tendcloud.tenddata.a.values();
            int length = aVarArrValues.length;
            while (i < length) {
                com.tendcloud.tenddata.a aVar2 = aVarArrValues[i];
                File file2 = new File(filesDir, aVar2.getRootFolder());
                File file3 = new File(file2, aVar2.getDataFolder());
                if (file3.exists()) {
                    Iterator<File> it2 = c(file3).iterator();
                    while (it2.hasNext()) {
                        it2.next().delete();
                    }
                }
                i++;
                filesDir = file2;
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void clearDataCache(com.tendcloud.tenddata.a aVar) {
        try {
            this.f19965d.get(Integer.valueOf(aVar.index())).clear();
        } catch (Throwable unused) {
        }
    }

    public void confirmRead(com.tendcloud.tenddata.a aVar) {
        new a(aVar).run();
    }

    public void getFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            this.h.lock();
            this.g.put(Integer.valueOf(aVar.index()), this.f19967f.get(Integer.valueOf(aVar.index())).getChannel().lock());
        } catch (Throwable unused) {
        }
    }

    public void releaseFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            if (this.g.get(Integer.valueOf(aVar.index())) != null) {
                this.g.get(Integer.valueOf(aVar.index())).release();
                this.h.unlock();
            }
        } catch (Throwable unused) {
        }
    }

    public static cq a() {
        synchronized (cq.class) {
            if (f19963b == null) {
                f19963b = new cq();
            }
        }
        return f19963b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, com.tendcloud.tenddata.a aVar) {
        try {
            int fileLimitType = aVar.getFileLimitType();
            if (fileLimitType != 1) {
                if (fileLimitType != 2) {
                    if (fileLimitType == 3) {
                        a(file);
                    }
                } else if (file.listFiles().length >= 10) {
                    a(file);
                }
            } else if (b(file) > 25) {
                a(file);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private List<File> c(File file) {
        List<File> arrayList = new ArrayList<>();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        try {
            arrayList = Arrays.asList(fileArrListFiles);
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.tendcloud.tenddata.cq.1
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return file2.getName().compareTo(file3.getName());
                }
            });
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    private void a(File file) {
        try {
            if (file.isDirectory()) {
                a(c(file).get(0));
            } else {
                file.delete();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private int b(File file) {
        File[] fileArrListFiles;
        if (file == null) {
            return 0;
        }
        try {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                long length = 0;
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        length += file2.length();
                    }
                }
                return (int) (length / 1048576);
            }
            return 0;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return 0;
        }
    }

    public synchronized void a(cp cpVar, bx bxVar) {
        this.f19964c.execute(new c(cpVar, bxVar, this));
    }

    private synchronized void a(cp cpVar, com.tendcloud.tenddata.a aVar) {
        if (aVar != null && cpVar != null) {
            try {
                this.f19965d.get(Integer.valueOf(aVar.index())).add(cpVar);
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: Throwable -> 0x0126, all -> 0x0152, TRY_LEAVE, TryCatch #5 {Throwable -> 0x0126, blocks: (B:21:0x0067, B:23:0x006d), top: B:100:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011d A[PHI: r9
      0x011d: PHI (r9v5 java.nio.channels.FileLock) = (r9v1 java.nio.channels.FileLock), (r9v3 java.nio.channels.FileLock) binds: [B:59:0x0117, B:60:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f A[Catch: Throwable -> 0x0123, all -> 0x0152, TRY_LEAVE, TryCatch #3 {Throwable -> 0x0123, blocks: (B:60:0x0119, B:62:0x011f), top: B:96:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0135 A[Catch: Throwable -> 0x0138, all -> 0x0152, TRY_LEAVE, TryCatch #8 {, blocks: (B:4:0x0005, B:6:0x000d, B:7:0x0013, B:9:0x0023, B:73:0x0139, B:75:0x013d, B:10:0x003e, B:12:0x0044, B:14:0x0047, B:21:0x0067, B:23:0x006d, B:31:0x008e, B:32:0x0092, B:46:0x00ec, B:69:0x0130, B:71:0x0135, B:72:0x0138, B:60:0x0119, B:62:0x011f), top: B:106:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.TreeSet<com.tendcloud.tenddata.cp> a(com.tendcloud.tenddata.a r18, int r19, java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.cq.a(com.tendcloud.tenddata.a, int, java.lang.String):java.util.TreeSet");
    }
}
