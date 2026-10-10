package com.sandboxol.blockmango;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.sandboxol.blockmango.GameResUpdater;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import okhttp3.C;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class GameResUpdater extends AsyncTask<String, Integer, Integer> {
    private static String MSG_DOWNLOAD_FAILED = "MSG_GAMERESDOWNLOAD_FAILED";
    private static String MSG_DOWNLOAD_PROGRESS = "MSG_GAMERESDOWNLOAD_PROGRESS";
    private static String MSG_DOWNLOAD_SUCESS = "MSG_GAMERESDWONLOAD_SUCESS";
    public static final int TYPE_CANCELED = 3;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_SUCCESS = 0;
    private int currentVersion;
    private String downLoadGameName;
    private String downloadUrl;
    private int lastProgress;
    private GameResUpdaterListener listener;
    private Context mContext;
    private String updateFileName;
    private String mSignature = null;
    private boolean isCanceled = false;
    private boolean isPaused = false;

    public class DownloadProgress {
        public long currentSize;
        public int progress;
        public long totalSize;

        public DownloadProgress() {
        }
    }

    public interface GameResUpdaterListener {
        void onFailed();

        void onProgress(double d2, double d3, double d4);

        void onSuccess();
    }

    public GameResUpdater(Context context, final GameResUpdaterListener gameResUpdaterListener, String str, int i, String str2) {
        this.currentVersion = -1;
        this.listener = gameResUpdaterListener;
        this.mContext = context;
        this.downloadUrl = str2;
        this.downLoadGameName = str;
        this.currentVersion = i;
        Messenger.getDefault().register(this, MSG_DOWNLOAD_PROGRESS, DownloadProgress.class, new Action1() { // from class: com.sandboxol.blockmango.ib
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GameResUpdater.DownloadProgress downloadProgress = (GameResUpdater.DownloadProgress) obj;
                gameResUpdaterListener.onProgress(downloadProgress.progress, downloadProgress.currentSize, downloadProgress.totalSize);
            }
        });
        Messenger.getDefault().register(this, MSG_DOWNLOAD_FAILED, new Action0() { // from class: com.sandboxol.blockmango.jb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16206a.a(gameResUpdaterListener);
            }
        });
        Messenger.getDefault().register(this, MSG_DOWNLOAD_SUCESS, new Action0() { // from class: com.sandboxol.blockmango.hb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16198a.a();
            }
        });
    }

    private long getContentLength(String str) {
        okhttp3.z zVar = new okhttp3.z();
        C.a aVar = new C.a();
        aVar.b(str);
        try {
            okhttp3.H hExecute = zVar.newCall(aVar.a()).execute();
            if (hExecute == null || !hExecute.q()) {
                return 0L;
            }
            long jContentLength = hExecute.b().contentLength();
            hExecute.b().close();
            return jContentLength;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    private Map<String, String> getGameResFilesMd5Reg(InputStream inputStream) throws Exception {
        HashMap map = new HashMap();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                inputStreamReader.close();
                return map;
            }
            String[] strArrSplit = line.split("\\*");
            map.put(strArrSplit[1], strArrSplit[0].replace(" ", ""));
        }
    }

    private String getStringFromInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private void onDownloadSusses() {
        Observable.create(new Observable.OnSubscribe<Boolean>() { // from class: com.sandboxol.blockmango.GameResUpdater.2
            @Override // rx.functions.Action1
            public void call(Subscriber<? super Boolean> subscriber) {
                boolean zMergeZip;
                File file = new File(EngineEnv.v2().getMapTempRootPath() + GameResUpdater.this.downLoadGameName, GameResUpdater.this.downLoadGameName + ".zip");
                String str = GameResUpdater.this.updateFileName;
                String str2 = EngineEnv.v2().getMapTempRootPath() + GameResUpdater.this.downLoadGameName + "/" + str;
                if (file.exists()) {
                    zMergeZip = GameResUpdater.this.mergeZip(file.getAbsolutePath(), str2);
                } else {
                    CommonHelper.renameFile(EngineEnv.v2().getMapTempRootPath() + GameResUpdater.this.downLoadGameName, str, GameResUpdater.this.downLoadGameName + ".zip");
                    zMergeZip = true;
                }
                new File(str2).delete();
                if (zMergeZip) {
                    GameResUpdater gameResUpdater = GameResUpdater.this;
                    gameResUpdater.writeStringToFile(String.valueOf(gameResUpdater.currentVersion), EngineEnv.v2().getMapTempRootPath() + "/" + GameResUpdater.this.downLoadGameName + "/version");
                    subscriber.onNext(true);
                } else {
                    file.delete();
                    subscriber.onNext(false);
                }
                subscriber.onCompleted();
            }
        }).compose(com.sandboxol.greendao.a.b.a()).subscribe(new Observer<Boolean>() { // from class: com.sandboxol.blockmango.GameResUpdater.1
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            @Override // rx.Observer
            public void onNext(Boolean bool) {
                if (bool.booleanValue()) {
                    GameResUpdater.this.listener.onSuccess();
                } else {
                    GameResUpdater.this.listener.onFailed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeStringToFile(String str, String str2) {
        try {
            new FileOutputStream(str2, false).write(str.getBytes());
        } catch (Exception unused) {
        }
    }

    public void cancelDownload() {
        this.isCanceled = true;
    }

    public void mergeZip(ZipOutputStream zipOutputStream, ZipFile zipFile, ZipFile zipFile2, Map<String, String> map) throws Exception {
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipFile2 == null || zipFile2.getEntry(zipEntryNextElement.getName()) == null) {
                if (map == null || map.get(zipEntryNextElement.getName()) != null) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryNextElement.getName()));
                    if (!zipEntryNextElement.isDirectory()) {
                        byte[] bArr = new byte[1024];
                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        while (true) {
                            int i = inputStream.read(bArr, 0, 1024);
                            if (i == -1) {
                                break;
                            } else {
                                zipOutputStream.write(bArr, 0, i);
                            }
                        }
                    }
                    zipOutputStream.closeEntry();
                }
            }
        }
    }

    public void pauseDownload() {
        this.isPaused = true;
    }

    public /* synthetic */ void a(GameResUpdaterListener gameResUpdaterListener) {
        Messenger.getDefault().unregister(this);
        gameResUpdaterListener.onFailed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0235 A[Catch: all -> 0x0251, TRY_LEAVE, TryCatch #10 {all -> 0x0251, blocks: (B:138:0x022c, B:140:0x0235), top: B:180:0x022c }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x023a A[Catch: Exception -> 0x023e, TRY_ENTER, TryCatch #11 {Exception -> 0x023e, blocks: (B:142:0x023a, B:146:0x0242, B:147:0x0245, B:149:0x0249, B:127:0x0215, B:129:0x021a, B:130:0x021d, B:132:0x0221), top: B:182:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0242 A[Catch: Exception -> 0x023e, TryCatch #11 {Exception -> 0x023e, blocks: (B:142:0x023a, B:146:0x0242, B:147:0x0245, B:149:0x0249, B:127:0x0215, B:129:0x021a, B:130:0x021d, B:132:0x0221), top: B:182:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0249 A[Catch: Exception -> 0x023e, TRY_LEAVE, TryCatch #11 {Exception -> 0x023e, blocks: (B:142:0x023a, B:146:0x0242, B:147:0x0245, B:149:0x0249, B:127:0x0215, B:129:0x021a, B:130:0x021d, B:132:0x0221), top: B:182:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x025d A[Catch: Exception -> 0x0259, TryCatch #14 {Exception -> 0x0259, blocks: (B:156:0x0255, B:160:0x025d, B:161:0x0260, B:163:0x0264), top: B:186:0x0255 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0264 A[Catch: Exception -> 0x0259, TRY_LEAVE, TryCatch #14 {Exception -> 0x0259, blocks: (B:156:0x0255, B:160:0x025d, B:161:0x0260, B:163:0x0264), top: B:186:0x0255 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Integer doInBackground(java.lang.String... r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.blockmango.GameResUpdater.doInBackground(java.lang.String[]):java.lang.Integer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            Messenger.getDefault().sendNoMsg(MSG_DOWNLOAD_SUCESS);
        } else if (iIntValue == 1) {
            Messenger.getDefault().sendNoMsg(MSG_DOWNLOAD_FAILED);
        } else if (iIntValue != 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        int iIntValue = numArr[0].intValue();
        if (iIntValue > this.lastProgress) {
            this.lastProgress = iIntValue;
        }
    }

    public /* synthetic */ void a() {
        Messenger.getDefault().unregister(this);
        onDownloadSusses();
    }

    public boolean mergeZip(String str, String str2) {
        String str3 = str + ".tmp";
        try {
            try {
                new File(str).renameTo(new File(str3));
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
                ZipFile zipFile = new ZipFile(str3);
                ZipFile zipFile2 = new ZipFile(str2);
                mergeZip(zipOutputStream, zipFile, zipFile2, getGameResFilesMd5Reg(zipFile2.getInputStream(zipFile2.getEntry("checksums.md5"))));
                zipFile.close();
                mergeZip(zipOutputStream, zipFile2, null, null);
                zipFile2.close();
                zipOutputStream.close();
                new File(str3).delete();
                return true;
            } catch (Exception e2) {
                Log.i("ZipUtil error ", e2.getMessage());
                new File(str3).delete();
                return false;
            }
        } catch (Throwable th) {
            new File(str3).delete();
            throw th;
        }
    }
}
