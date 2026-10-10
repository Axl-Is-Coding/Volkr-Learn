package io.rong.common.rlog;

import io.rong.common.rlog.Compressor;
import io.rong.common.rlog.LogFileWriter;
import io.rong.common.rlog.RLogConfig;
import io.rong.common.rlog.RLogReporter;
import java.io.File;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
public class RLogFileProcessor {
    private static final String TAG = "RLogFileProcessor";
    private RLogConfig mConfig;
    private LogFileWriter mLogFileWriter;
    private volatile boolean isUploading = false;
    int fileSize = 0;
    private RLogReporter mReporter = new RLogReporter();
    private Compressor mCompressor = new Compressor(new Compressor.ICompressListener() { // from class: io.rong.common.rlog.RLogFileProcessor.2
        @Override // io.rong.common.rlog.Compressor.ICompressListener
        public void onCompressFinish(boolean z, String str, String str2) {
            RLogFileProcessor.this.processCompressFinish(z, str, str2, false);
        }
    });

    private RLogFileProcessor(RLogConfig rLogConfig) {
        this.mConfig = rLogConfig;
        this.mLogFileWriter = new LogFileWriter(rLogConfig.getFilePath(), new LogFileWriter.IWriterListener() { // from class: io.rong.common.rlog.RLogFileProcessor.1
            @Override // io.rong.common.rlog.LogFileWriter.IWriterListener
            public void onFileCreate(long j) {
                if (RLogFileProcessor.this.mConfig != null) {
                    RLogFileProcessor.this.mConfig.setStartTime(j);
                }
            }

            @Override // io.rong.common.rlog.LogFileWriter.IWriterListener
            public void onWriteFinish(long j, String str) {
                if (j > RLogFileProcessor.this.mConfig.getFileMaxSize()) {
                    RLogFileProcessor.this.mLogFileWriter.close();
                    String str2 = RLogFileProcessor.this.mConfig.getStartTime() + "_" + System.currentTimeMillis();
                    String str3 = str2 + RLogConfig.LOG_SUFFIX;
                    File file = new File(str);
                    File file2 = new File(file.getParent(), str3);
                    if (file.renameTo(file2)) {
                        RLogFileProcessor.this.mCompressor.compress(file2.getAbsolutePath(), new File(file.getParent(), str2 + RLogConfig.ZIP_SUFFIX).getAbsolutePath());
                    }
                }
            }
        });
    }

    public static RLogFileProcessor init(RLogConfig rLogConfig) {
        return new RLogFileProcessor(rLogConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCompressFinish(boolean z, String str, String str2, boolean z2) {
        RLogConfig.ZipConfig zipConfig;
        if (z) {
            if (!new File(str).delete()) {
                RLog.i(TAG, "processCompressFinish file is:" + str);
            }
            if (!this.isUploading && (zipConfig = this.mConfig.getZipConfig()) != null) {
                File file = new File(str2);
                zipConfig.setCurrentSize(zipConfig.getCurrentSize() + file.length());
                zipConfig.addFile(file);
                while (zipConfig.getCurrentSize() > this.mConfig.getZipMaxSize()) {
                    File filePollFirst = zipConfig.getZipFiles().pollFirst();
                    zipConfig.setCurrentSize(zipConfig.getCurrentSize() - filePollFirst.length());
                    if (!filePollFirst.delete()) {
                        RLog.i(TAG, "processCompressFinish file is:" + filePollFirst.getAbsolutePath());
                    }
                }
            }
        } else {
            if (!new File(str).delete()) {
                RLog.i(TAG, "processCompressFinish file is:" + str);
            }
            if (!new File(str2).delete()) {
                RLog.i(TAG, "processCompressFinish file is:" + str2);
            }
        }
        if (z2) {
            uploadLog();
        }
    }

    private void uploadLog() {
        RLogConfig.ZipConfig zipConfig;
        if (this.isUploading || (zipConfig = this.mConfig.getZipConfig()) == null) {
            return;
        }
        TreeSet<File> zipFiles = zipConfig.getZipFiles();
        this.fileSize = zipFiles.size();
        this.isUploading = true;
        for (File file : zipFiles) {
            String[] strArrSplit = file.getName().substring(0, r3.length() - 3).split("_");
            this.mReporter.report(new RLogReporter.UploadConfig(this.mConfig.getUploadUrl(), file.getAbsolutePath(), strArrSplit[0], strArrSplit[1], this.mConfig.getSdkVersion(), this.mConfig.getAppKey(), this.mConfig.getUserId()), new RLogReporter.IUploadListener() { // from class: io.rong.common.rlog.RLogFileProcessor.3
                @Override // io.rong.common.rlog.RLogReporter.IUploadListener
                public void onUploadFinish(boolean z, String str) {
                    if (z && !new File(str).delete()) {
                        RLog.i(RLogFileProcessor.TAG, "uploadLog file is:" + str);
                    }
                    RLogFileProcessor rLogFileProcessor = RLogFileProcessor.this;
                    rLogFileProcessor.fileSize--;
                    if (rLogFileProcessor.fileSize == 0) {
                        rLogFileProcessor.mConfig.clearZipConfig();
                        RLogFileProcessor.this.mConfig.initZipConfig();
                        RLogFileProcessor.this.isUploading = false;
                    }
                }
            });
        }
    }

    public void upload() {
        this.mLogFileWriter.stopWrite(new LogFileWriter.IWriterOnStopListener() { // from class: io.rong.common.rlog.RLogFileProcessor.4
            @Override // io.rong.common.rlog.LogFileWriter.IWriterOnStopListener
            public void onStopWrite(String str) {
                RLogFileProcessor.this.mLogFileWriter.close();
                String str2 = RLogFileProcessor.this.mConfig.getStartTime() + "_" + System.currentTimeMillis();
                String str3 = str2 + RLogConfig.LOG_SUFFIX;
                File file = new File(str);
                File file2 = new File(file.getParent(), str3);
                if (file.renameTo(file2)) {
                    RLogFileProcessor.this.mCompressor.compress(file2.getAbsolutePath(), new File(file.getParent(), str2 + RLogConfig.ZIP_SUFFIX).getAbsolutePath(), new Compressor.ICompressListener() { // from class: io.rong.common.rlog.RLogFileProcessor.4.1
                        @Override // io.rong.common.rlog.Compressor.ICompressListener
                        public void onCompressFinish(boolean z, String str4, String str5) {
                            RLogFileProcessor.this.processCompressFinish(z, str4, str5, true);
                        }
                    });
                }
            }
        });
    }

    public void write(String str) {
        this.mLogFileWriter.write(str);
    }
}
