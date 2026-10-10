package com.sandboxol.blockmango;

import android.content.Context;
import android.os.RecoverySystem;
import android.util.Log;
import com.sandboxol.blockmango.GameResNewUpdater;
import com.sandboxol.blockmango.ZipUtil;
import com.sandboxol.center.download.client.DownloadClient;
import com.sandboxol.center.download.entity.GameReqParam;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.center.entity.GameResInfo;
import com.sandboxol.center.router.moduleInfo.game.AbstractEngineEnv;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class GameResNewUpdater {
    private static String MSG_DOWNLOAD_FAILED = "MSG_GAMERESDOWNLOAD_FAILED";
    private static String MSG_DOWNLOAD_PROGRESS = "MSG_GAMERESDOWNLOAD_PROGRESS";
    private static String MSG_DOWNLOAD_SUCESS = "MSG_GAMERESDWONLOAD_SUCESS";
    private int currentVersion;
    private GameResInfo data;
    private String downLoadGameName;
    private String downloadUrl;
    private AbstractEngineEnv engineEnv;
    private Game game;
    private GameResUpdaterListener listener;
    private Context mContext;
    private RecoverySystem.ProgressListener progressListener;
    private String updateFileName;

    /* JADX INFO: renamed from: com.sandboxol.blockmango.GameResNewUpdater$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sandboxol$blockmango$ZipUtil$ZipStatus = new int[ZipUtil.ZipStatus.values().length];

        static {
            try {
                $SwitchMap$com$sandboxol$blockmango$ZipUtil$ZipStatus[ZipUtil.ZipStatus.FAILURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sandboxol$blockmango$ZipUtil$ZipStatus[ZipUtil.ZipStatus.MERGE_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sandboxol$blockmango$ZipUtil$ZipStatus[ZipUtil.ZipStatus.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

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

        void onSuccess(boolean z);
    }

    public GameResNewUpdater(Context context, final GameResUpdaterListener gameResUpdaterListener, Game game, GameResInfo gameResInfo, AbstractEngineEnv abstractEngineEnv) {
        this.currentVersion = -1;
        this.listener = gameResUpdaterListener;
        this.mContext = context;
        this.downloadUrl = gameResInfo.getDurl();
        this.downLoadGameName = game.getGameId();
        this.currentVersion = gameResInfo.getResVersion();
        this.engineEnv = abstractEngineEnv;
        this.data = gameResInfo;
        this.game = game;
        Messenger.getDefault().register(this, MSG_DOWNLOAD_PROGRESS, DownloadProgress.class, new Action1() { // from class: com.sandboxol.blockmango.eb
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GameResNewUpdater.DownloadProgress downloadProgress = (GameResNewUpdater.DownloadProgress) obj;
                gameResUpdaterListener.onProgress(downloadProgress.progress, downloadProgress.currentSize, downloadProgress.totalSize);
            }
        });
        Messenger.getDefault().register(this, MSG_DOWNLOAD_FAILED, new Action0() { // from class: com.sandboxol.blockmango.fb
            @Override // rx.functions.Action0
            public final void call() {
                this.f16188a.a(gameResUpdaterListener);
            }
        });
        Messenger.getDefault().register(this, MSG_DOWNLOAD_SUCESS, new Action0() { // from class: com.sandboxol.blockmango.db
            @Override // rx.functions.Action0
            public final void call() {
                this.f16176a.a();
            }
        });
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
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.blockmango.gb
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16194a.a((Subscriber) obj);
            }
        }).compose(com.sandboxol.greendao.a.b.a()).subscribe(new Observer<ZipUtil.ZipStatus>() { // from class: com.sandboxol.blockmango.GameResNewUpdater.2
            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            @Override // rx.Observer
            public void onNext(ZipUtil.ZipStatus zipStatus) {
                int i = AnonymousClass3.$SwitchMap$com$sandboxol$blockmango$ZipUtil$ZipStatus[zipStatus.ordinal()];
                if (i == 1) {
                    GameResNewUpdater.this.listener.onFailed();
                } else if (i == 2) {
                    GameResNewUpdater.this.listener.onSuccess(true);
                } else {
                    if (i != 3) {
                        return;
                    }
                    GameResNewUpdater.this.listener.onSuccess(false);
                }
            }
        });
    }

    private void writeStringToFile(String str, String str2) {
        try {
            new FileOutputStream(str2, false).write(str.getBytes());
        } catch (Exception unused) {
        }
    }

    public void execute() {
        String str = this.downloadUrl;
        this.updateFileName = str.substring(str.lastIndexOf(47) + 1);
        String str2 = this.engineEnv.getMapTempRootPath() + this.downLoadGameName + "/";
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.setSaveName(this.updateFileName).setSavePath(str2).setUrl(this.downloadUrl).setCdns(this.data.getCdns());
        com.sandboxol.file.b.a aVar = new com.sandboxol.file.b.a();
        aVar.a(downloadInfo);
        GameReqParam gameReqParam = new GameReqParam();
        gameReqParam.setGame(this.game);
        DownloadClient downloadClient = DownloadClient.getInstance();
        MergeBuilder reqParam = new MergeBuilder().setReqParam(gameReqParam);
        aVar.a(new com.sandboxol.file.d.c() { // from class: com.sandboxol.blockmango.GameResNewUpdater.1
            @Override // com.sandboxol.file.d.c
            public void onComplete(Progress progress) {
                Messenger.getDefault().sendNoMsg(GameResNewUpdater.MSG_DOWNLOAD_SUCESS);
            }

            @Override // com.sandboxol.file.d.c
            public void onError(Throwable th) {
                Messenger.getDefault().sendNoMsg(GameResNewUpdater.MSG_DOWNLOAD_FAILED);
            }

            @Override // com.sandboxol.file.d.c
            public void onNext(Progress progress) {
                DownloadProgress downloadProgress = GameResNewUpdater.this.new DownloadProgress();
                downloadProgress.progress = progress.percent().intValue();
                downloadProgress.totalSize = progress.getTotalSize().longValue();
                downloadProgress.currentSize = progress.getDownloadSize().longValue();
                Messenger.getDefault().send(downloadProgress, GameResNewUpdater.MSG_DOWNLOAD_PROGRESS);
            }

            @Override // com.sandboxol.file.d.c
            public /* synthetic */ void onSubscribe(Throwable th) {
                com.sandboxol.file.d.b.a(this, th);
            }
        });
        downloadClient.process(5, reqParam.setDownloadBuilder(aVar));
    }

    public void mergeZip(ZipOutputStream zipOutputStream, ZipFile zipFile, ZipFile zipFile2, Map<String, String> map) throws Exception {
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipFile2 == null || zipFile2.getEntry(zipEntryNextElement.getName()) == null) {
                if (map == null || map.get(zipEntryNextElement.getName()) != null) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryNextElement.getName()));
                    if (!zipEntryNextElement.isDirectory()) {
                        byte[] bArr = new byte[8192];
                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        while (true) {
                            int i = inputStream.read(bArr, 0, 8192);
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

    public GameResNewUpdater setProgressListener(RecoverySystem.ProgressListener progressListener) {
        this.progressListener = progressListener;
        return this;
    }

    public /* synthetic */ void a(GameResUpdaterListener gameResUpdaterListener) {
        Messenger.getDefault().unregister(this);
        gameResUpdaterListener.onFailed();
    }

    public /* synthetic */ void a() {
        Messenger.getDefault().unregister(this);
        onDownloadSusses();
    }

    public /* synthetic */ void a(Subscriber subscriber) {
        File file = new File(this.engineEnv.getMapTempRootPath() + this.downLoadGameName, this.downLoadGameName + ".zip");
        String str = this.updateFileName;
        String str2 = this.engineEnv.getMapTempRootPath() + this.downLoadGameName + "/" + str;
        ZipUtil.ZipStatus zipStatusZipMerge = ZipUtil.ZipStatus.MERGE_SUCCESS;
        if (file.exists()) {
            zipStatusZipMerge = new ZipUtil(file.getAbsolutePath(), this.engineEnv.getMapRootPath() + this.downLoadGameName).zipMerge(file.getAbsolutePath(), str2, this.progressListener);
        } else {
            CommonHelper.renameFile(this.engineEnv.getMapTempRootPath() + this.downLoadGameName, str, this.downLoadGameName + ".zip");
        }
        new File(str2).delete();
        if (zipStatusZipMerge == ZipUtil.ZipStatus.FAILURE) {
            file.delete();
        } else {
            writeStringToFile(String.valueOf(this.currentVersion), this.engineEnv.getMapTempRootPath() + "/" + this.downLoadGameName + "/version");
        }
        subscriber.onNext(zipStatusZipMerge);
        subscriber.onCompleted();
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
