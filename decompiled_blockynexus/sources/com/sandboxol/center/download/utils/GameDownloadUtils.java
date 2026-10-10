package com.sandboxol.center.download.utils;

import android.app.Activity;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.AppEngineResourceUpdateItem;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.file.entity.CdnConfigDetail;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.greendao.entity.Game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameDownloadUtils {
    private static long commonResVersion;
    private static long gameResVersion;

    public static void gameDownload(Activity activity) {
    }

    public static String getCdnId(DownloadInfo downloadInfo) {
        List<CdnConfigDetail> cdns;
        if (downloadInfo != null && downloadInfo.getCdns() != null && downloadInfo.getCdns().size() > 0 && !TextUtils.isEmpty(downloadInfo.getUrl())) {
            try {
                String host = new URL(downloadInfo.getUrl()).getHost();
                if (TextUtils.isEmpty(host) || (cdns = downloadInfo.getCdns()) == null) {
                    return "-1";
                }
                for (CdnConfigDetail cdnConfigDetail : cdns) {
                    if (host.equals(cdnConfigDetail.getCdnUrl())) {
                        return cdnConfigDetail.getCdnId();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "-1";
    }

    public static List<AppEngineResourceUpdateItem> getCommonGameList(List<AppEngineResourceUpdateResult> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AppEngineResourceUpdateResult appEngineResourceUpdateResult : list) {
            if (appEngineResourceUpdateResult.getUpdates() != null && appEngineResourceUpdateResult.getUpdates().size() != 0) {
                for (AppEngineResourceUpdateItem appEngineResourceUpdateItem : appEngineResourceUpdateResult.getUpdates()) {
                    if ("ENGINE_COMMON_V2".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("COMMON");
                    } else if ("ENGINE_COMMON_V3".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("COMMON");
                    } else if ("GAME".equals(appEngineResourceUpdateResult.getResourceType())) {
                        appEngineResourceUpdateItem.setType("GAME");
                    }
                }
                arrayList.addAll(appEngineResourceUpdateResult.getUpdates());
            }
            if ("ENGINE_COMMON_V2".equals(appEngineResourceUpdateResult.getResourceType())) {
                commonResVersion = appEngineResourceUpdateResult.getResVersion();
            }
            if ("ENGINE_COMMON_V3".equals(appEngineResourceUpdateResult.getResourceType())) {
                commonResVersion = appEngineResourceUpdateResult.getResVersion();
            }
            if ("GAME".equals(appEngineResourceUpdateResult.getResourceType())) {
                gameResVersion = appEngineResourceUpdateResult.getResVersion();
            }
        }
        return arrayList;
    }

    public static long getMapDownloadTime(Game game) {
        if (game == null || TextUtils.isEmpty(game.getGameId())) {
            return 0L;
        }
        try {
            File file = new File(EngineEnv.getEngine(game.getIsNewEngine(), game.getIsUgc()).getMapTempRootPath(), game.getGameId());
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            File file2 = new File(file, "time.txt");
            if (file2.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                long j = Long.parseLong(bufferedReader.readLine());
                bufferedReader.close();
                return j;
            }
            file2.createNewFile();
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(0);
            fileWriter.flush();
            fileWriter.close();
            return 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static List<String> getPathType(Game game, List<AppEngineResourceUpdateResult> list) {
        ArrayList arrayList = new ArrayList();
        for (AppEngineResourceUpdateResult appEngineResourceUpdateResult : list) {
            if (appEngineResourceUpdateResult.getUpdates() != null && appEngineResourceUpdateResult.getUpdates().size() != 0) {
                for (AppEngineResourceUpdateItem appEngineResourceUpdateItem : appEngineResourceUpdateResult.getUpdates()) {
                    if (appEngineResourceUpdateResult.getResourceType() != null) {
                        String resourceType = appEngineResourceUpdateResult.getResourceType();
                        byte b2 = -1;
                        int iHashCode = resourceType.hashCode();
                        if (iHashCode != 2180082) {
                            switch (iHashCode) {
                                case 1134134194:
                                    if (resourceType.equals("ENGINE_COMMON_V1")) {
                                        b2 = 0;
                                    }
                                    break;
                                case 1134134195:
                                    if (resourceType.equals("ENGINE_COMMON_V2")) {
                                        b2 = 1;
                                    }
                                    break;
                                case 1134134196:
                                    if (resourceType.equals("ENGINE_COMMON_V3")) {
                                        b2 = 2;
                                    }
                                    break;
                            }
                        } else if (resourceType.equals("GAME")) {
                            b2 = 3;
                        }
                        if (b2 == 0) {
                            arrayList.add("app_resources");
                        } else if (b2 == 1) {
                            arrayList.add("app_resourcesv2");
                        } else if (b2 == 2) {
                            arrayList.add("app_resourcesv3");
                        } else if (b2 == 3) {
                            arrayList.add(EngineEnv.getGameResDir(game.getIsNewEngine(), game.getIsUgc()));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isNeedUpdate(List<AppEngineResourceUpdateResult> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<AppEngineResourceUpdateResult> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isNeedUpdate()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRetry(Throwable th) {
        String message = th.getMessage() != null ? th.getMessage() : "errorMsg is null";
        return message.toLowerCase().contains("timeout") || message.toLowerCase().contains("timed out") || message.toLowerCase().contains("exceptions occurred") || message.toLowerCase().contains("unable to resolve host") || message.toLowerCase().contains("connection reset") || message.toLowerCase().contains("request failed") || message.toLowerCase().contains("unexpected end of stream") || message.toLowerCase().contains("response body is null") || message.toLowerCase().contains("unable to resolve host") || message.toLowerCase().contains("speed too slow") || (th instanceof SocketTimeoutException);
    }

    private static void setUrl(ObservableField<Integer> observableField, DownloadInfo downloadInfo) {
        try {
            if (downloadInfo.getCdns() != null && downloadInfo.getCdns().size() != 0) {
                ArrayList arrayList = new ArrayList(downloadInfo.getCdns());
                int iIntValue = observableField.get().intValue() % arrayList.size();
                if (TextUtils.isEmpty(((CdnConfigDetail) arrayList.get(iIntValue)).getUrl())) {
                    return;
                }
                downloadInfo.setUrl(((CdnConfigDetail) arrayList.get(iIntValue)).getUrl());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String switchRandomUrl(DownloadInfo downloadInfo) {
        String strReplace = "";
        if (downloadInfo == null || downloadInfo.getCdns() == null || downloadInfo.getCdns().size() <= 0 || TextUtils.isEmpty(downloadInfo.getUrl())) {
            return "";
        }
        try {
            String host = new URL(downloadInfo.getUrl()).getHost();
            if (TextUtils.isEmpty(host)) {
                return "";
            }
            List<CdnConfigDetail> cdns = downloadInfo.getCdns();
            ArrayList arrayList = new ArrayList();
            if (cdns == null) {
                return "";
            }
            for (CdnConfigDetail cdnConfigDetail : cdns) {
                if (cdnConfigDetail != null && !TextUtils.isEmpty(cdnConfigDetail.getCdnUrl()) && !host.equals(cdnConfigDetail.getCdnUrl())) {
                    arrayList.add(cdnConfigDetail);
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return "";
            }
            double dRandom = Math.random() * 10.0d;
            double d2 = size;
            Double.isNaN(d2);
            strReplace = downloadInfo.getUrl().replace(host, ((CdnConfigDetail) arrayList.get(((int) (dRandom * d2)) / 10)).getCdnUrl());
            downloadInfo.setUrl(strReplace);
            return strReplace;
        } catch (Exception e2) {
            e2.printStackTrace();
            return strReplace;
        }
    }

    public static void switchUrl(ObservableField<Integer> observableField, DownloadInfo[] downloadInfoArr) {
        if (downloadInfoArr == null || downloadInfoArr.length <= 0) {
            return;
        }
        for (DownloadInfo downloadInfo : downloadInfoArr) {
            setUrl(observableField, downloadInfo);
        }
    }

    public static void writeMapDownloadTime(Game game, long j) {
        if (game == null || TextUtils.isEmpty(game.getGameId())) {
            return;
        }
        File file = new File(EngineEnv.getEngine(game.getIsNewEngine(), game.getIsUgc()).getMapTempRootPath(), game.getGameId());
        try {
            if (!file.exists() || !file.isDirectory()) {
                file.mkdir();
            }
            File file2 = new File(file, "time.txt");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(String.valueOf(j));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
