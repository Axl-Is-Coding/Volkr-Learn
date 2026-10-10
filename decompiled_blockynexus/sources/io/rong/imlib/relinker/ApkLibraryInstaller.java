package io.rong.imlib.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import io.rong.imlib.relinker.ReLinker;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    private static class ZipFileInZipEntry {
        private ZipEntry zipEntry;
        private ZipFile zipFile;

        private ZipFileInZipEntry(ZipFile zipFile, ZipEntry zipEntry) {
            this.zipFile = zipFile;
            this.zipEntry = zipEntry;
        }
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    private ZipFileInZipEntry findAPKWithLibrary(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i;
        String[] strArrSourceDirectories = sourceDirectories(context);
        int length = strArrSourceDirectories.length;
        char c2 = 0;
        ZipFile zipFile = null;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArrSourceDirectories[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                i = 5;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < i) {
                        int length2 = strArr.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c2] = str3;
                            objArr[1] = str2;
                            reLinkerInstance.log("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new ZipFileInZipEntry(zipFile, entry);
                            }
                            i7++;
                            c2 = 0;
                        }
                        i5 = i6;
                        i = 5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c2 = 0;
        }
        return null;
    }

    private String[] sourceDirectories(Context context) {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // io.rong.imlib.relinker.ReLinker.LibraryInstaller
    public void installLibrary(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) throws Throwable {
        ZipFileInZipEntry zipFileInZipEntryFindAPKWithLibrary;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jCopy;
        Closeable closeable = null;
        try {
            zipFileInZipEntryFindAPKWithLibrary = findAPKWithLibrary(context, strArr, str, reLinkerInstance);
            try {
                if (zipFileInZipEntryFindAPKWithLibrary == null) {
                    throw new MissingLibraryException(str);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        reLinkerInstance.log("FATAL! Couldn't extract the library from the APK!");
                        if (zipFileInZipEntryFindAPKWithLibrary != null) {
                            try {
                                if (zipFileInZipEntryFindAPKWithLibrary.zipFile != null) {
                                    zipFileInZipEntryFindAPKWithLibrary.zipFile.close();
                                    return;
                                }
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    reLinkerInstance.log("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = zipFileInZipEntryFindAPKWithLibrary.zipFile.getInputStream(zipFileInZipEntryFindAPKWithLibrary.zipEntry);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                } catch (FileNotFoundException unused2) {
                                    fileOutputStream = null;
                                } catch (IOException unused3) {
                                    fileOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (FileNotFoundException unused4) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused5) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = null;
                            }
                            try {
                                jCopy = copy(inputStream, fileOutputStream);
                                fileOutputStream.getFD().sync();
                            } catch (FileNotFoundException unused6) {
                                closeSilently(inputStream);
                            } catch (IOException unused7) {
                                closeSilently(inputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = fileOutputStream;
                                closeSilently(inputStream);
                                closeSilently(closeable);
                                throw th;
                            }
                            if (jCopy == file.length()) {
                                closeSilently(inputStream);
                                closeSilently(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                if (zipFileInZipEntryFindAPKWithLibrary != null) {
                                    try {
                                        if (zipFileInZipEntryFindAPKWithLibrary.zipFile != null) {
                                            zipFileInZipEntryFindAPKWithLibrary.zipFile.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused8) {
                                        return;
                                    }
                                }
                                return;
                            }
                            closeSilently(inputStream);
                            closeSilently(fileOutputStream);
                        }
                    } catch (IOException unused9) {
                    }
                    i = i2;
                }
            } catch (Throwable th4) {
                th = th4;
                if (zipFileInZipEntryFindAPKWithLibrary != null) {
                    try {
                        if (zipFileInZipEntryFindAPKWithLibrary.zipFile != null) {
                            zipFileInZipEntryFindAPKWithLibrary.zipFile.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFileInZipEntryFindAPKWithLibrary = null;
        }
    }
}
