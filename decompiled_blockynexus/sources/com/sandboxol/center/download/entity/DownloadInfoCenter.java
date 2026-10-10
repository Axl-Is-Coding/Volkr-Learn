package com.sandboxol.center.download.entity;

import androidx.databinding.ObservableField;
import com.sandboxol.center.download.utils.ProgressUtils;
import java.math.BigDecimal;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadInfoCenter {
    private static DownloadInfoCenter downloadInfoCenter;
    public ObservableField<Boolean> isSilentDownload = new ObservableField<>(false);
    public ObservableField<Boolean> isDownload = new ObservableField<>();
    public ObservableField<String> totalProgressPercentStr = new ObservableField<>();
    public ObservableField<Integer> totalProgressValue = new ObservableField<>();
    public ObservableField<String> totalProgressText = new ObservableField<>();
    public ObservableField<Long> downloadSize = new ObservableField<>(0L);
    public ObservableField<Long> totalSize = new ObservableField<>(0L);
    private DressProgressInfo dressProgressInfo = new DressProgressInfo();
    private HashMap<String, GameProgressInfo> gameProgressInfoMap = new HashMap<>();
    private CommonGameProgressInfo commonGameProgressInfo = new CommonGameProgressInfo();
    private CommonProgressInfo commonProgressInfo = new CommonProgressInfo();
    private CommonProgressInfo commonProgressInfoUgc = new CommonProgressInfo();
    private MapProgressInfo mapProgressInfo = new MapProgressInfo();
    private HashMap<String, GameProgressInfo> totalGameProgressInfoMap = new HashMap<>();

    private DownloadInfoCenter() {
    }

    private String formatSize(Long l) {
        double dDoubleValue = l.doubleValue();
        double d2 = dDoubleValue / 1024.0d;
        double d3 = d2 / 1024.0d;
        double d4 = d3 / 1024.0d;
        double d5 = d4 / 1024.0d;
        if (d5 >= 1.0d) {
            return new BigDecimal(d5).setScale(2, 4).doubleValue() + " TB";
        }
        if (d4 >= 1.0d) {
            return new BigDecimal(d4).setScale(2, 4).doubleValue() + " GB";
        }
        if (d3 >= 1.0d) {
            return new BigDecimal(d3).setScale(2, 4).doubleValue() + " MB";
        }
        if (d2 >= 1.0d) {
            return new BigDecimal(d2).setScale(2, 4).doubleValue() + " KB";
        }
        return new BigDecimal(dDoubleValue).setScale(2, 4).doubleValue() + " B";
    }

    public static DownloadInfoCenter getInstance() {
        if (downloadInfoCenter == null) {
            downloadInfoCenter = new DownloadInfoCenter();
        }
        return downloadInfoCenter;
    }

    public String formatString() {
        if (this.downloadSize.get().longValue() > this.totalSize.get().longValue()) {
            this.downloadSize = this.totalSize;
        }
        return formatSize(this.downloadSize.get()) + "/" + formatSize(this.totalSize.get());
    }

    public CommonGameProgressInfo getCommonGameProgressInfo() {
        return this.commonGameProgressInfo;
    }

    public CommonProgressInfo getCommonProgressInfo() {
        return this.commonProgressInfo;
    }

    public CommonProgressInfo getCommonProgressInfoUgc() {
        return this.commonProgressInfoUgc;
    }

    public ObservableField<Long> getDownloadSize() {
        return this.downloadSize;
    }

    public DressProgressInfo getDressProgressInfo() {
        return this.dressProgressInfo;
    }

    public HashMap<String, GameProgressInfo> getGameProgressInfoMap() {
        return this.gameProgressInfoMap;
    }

    public ObservableField<Boolean> getIsDownload() {
        return this.isDownload;
    }

    public ObservableField<Boolean> getIsSilentDownload() {
        return this.isSilentDownload;
    }

    public MapProgressInfo getMapProgressInfo() {
        return this.mapProgressInfo;
    }

    public HashMap<String, GameProgressInfo> getTotalGameProgressInfoMap() {
        return this.totalGameProgressInfoMap;
    }

    public ObservableField<String> getTotalProgressPercentStr() {
        return this.totalProgressPercentStr;
    }

    public ObservableField<String> getTotalProgressText() {
        return this.totalProgressText;
    }

    public ObservableField<Integer> getTotalProgressValue() {
        return this.totalProgressValue;
    }

    public ObservableField<Long> getTotalSize() {
        return this.totalSize;
    }

    public Double percent() {
        if (this.totalSize.get().longValue() <= 0) {
            return Double.valueOf(0.0d);
        }
        if (this.downloadSize.get().longValue() > this.totalSize.get().longValue()) {
            this.downloadSize = this.totalSize;
        }
        double dLongValue = this.downloadSize.get().longValue();
        Double.isNaN(dLongValue);
        BigDecimal bigDecimal = new BigDecimal(dLongValue * 100.0d);
        double dLongValue2 = this.totalSize.get().longValue();
        Double.isNaN(dLongValue2);
        return Double.valueOf(bigDecimal.divide(new BigDecimal(dLongValue2 * 1.0d), 2, 4).doubleValue());
    }

    public String percentStr() {
        return percent() + "%";
    }

    public void setCommonGameProgressInfo(CommonGameProgressInfo commonGameProgressInfo) {
        this.commonGameProgressInfo = commonGameProgressInfo;
    }

    public void setCommonProgressInfo(CommonProgressInfo commonProgressInfo) {
        this.commonProgressInfo = commonProgressInfo;
    }

    public void setCommonProgressInfoUgc(CommonProgressInfo commonProgressInfo) {
        this.commonProgressInfoUgc = commonProgressInfo;
    }

    public void setDownloadSize(long j) {
        this.downloadSize.set(Long.valueOf(j));
    }

    public void setDressProgressInfo(DressProgressInfo dressProgressInfo) {
        this.dressProgressInfo = dressProgressInfo;
    }

    public void setGameProgressInfoMap(HashMap<String, GameProgressInfo> map) {
        this.gameProgressInfoMap = map;
    }

    public void setIsDownload(boolean z) {
        this.isDownload.set(Boolean.valueOf(z));
    }

    public void setIsSilentDownload(boolean z) {
        this.isSilentDownload.set(Boolean.valueOf(z));
    }

    public void setMapProgressInfo(MapProgressInfo mapProgressInfo) {
        this.mapProgressInfo = mapProgressInfo;
    }

    public void setTotalGameProgressInfoMap(HashMap<String, GameProgressInfo> map) {
        this.totalGameProgressInfoMap = map;
    }

    public void setTotalProgressPercentStr(ObservableField<String> observableField) {
        this.totalProgressPercentStr = observableField;
    }

    public void setTotalProgressText(String str) {
        this.totalProgressText.set(str);
    }

    public void setTotalProgressValue(int i) {
        this.totalProgressValue.set(Integer.valueOf(i));
    }

    public void setTotalSize(long j) {
        this.totalSize.set(Long.valueOf(j));
    }

    public void updateDownloadTotalProgress() {
        synchronized (DownloadInfoCenter.class) {
            if (this.totalGameProgressInfoMap.size() > 0) {
                for (String str : this.totalGameProgressInfoMap.keySet()) {
                    ProgressUtils.updateDownloadGameProgressInfo(str, this.totalGameProgressInfoMap.get(str));
                }
            }
        }
    }

    public void updateUnzipTotalProgress() {
        synchronized (DownloadInfoCenter.class) {
            if (this.totalGameProgressInfoMap.keySet().size() > 0) {
                for (String str : this.totalGameProgressInfoMap.keySet()) {
                    if (this.totalGameProgressInfoMap.get(str) != null) {
                        ProgressUtils.updateUnzipGameProgressInfo(str, this.totalGameProgressInfoMap.get(str));
                    }
                }
            }
        }
    }
}
