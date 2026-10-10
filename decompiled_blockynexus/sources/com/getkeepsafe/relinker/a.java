package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.getkeepsafe.relinker.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ApkLibraryInstaller.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: com.getkeepsafe.relinker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApkLibraryInstaller.java */
    private static class C0097a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f12494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f12495b;

        public C0097a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f12494a = zipFile;
            this.f12495b = zipEntry;
        }
    }

    private String[] a(Context context) {
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

    private C0097a a(Context context, String[] strArr, String str, e eVar) {
        int i;
        String[] strArrA = a(context);
        int length = strArrA.length;
        char c2 = 0;
        ZipFile zipFile = null;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArrA[i2];
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
                    if (i5 >= i) {
                        break;
                    }
                    int length2 = strArr.length;
                    int i7 = 0;
                    while (i7 < length2) {
                        String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                        Object[] objArr = new Object[2];
                        objArr[c2] = str3;
                        objArr[1] = str2;
                        eVar.a("Looking for %s in APK %s...", objArr);
                        ZipEntry entry = zipFile.getEntry(str3);
                        if (entry != null) {
                            return new C0097a(zipFile, entry);
                        }
                        i7++;
                        c2 = 0;
                    }
                    i5 = i6;
                    i = 5;
                }
            }
            i2++;
            c2 = 0;
        }
        return null;
    }

    @Override // com.getkeepsafe.relinker.b.a
    public void a(Context context, String[] strArr, String str, File file, e eVar) throws Throwable {
        C0097a c0097aA;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jA;
        Closeable closeable = null;
        try {
            c0097aA = a(context, strArr, str, eVar);
        } catch (Throwable th) {
            th = th;
            c0097aA = null;
        }
        try {
            if (c0097aA == null) {
                throw new MissingLibraryException(str);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i < 5) {
                    eVar.a("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c0097aA.f12494a.getInputStream(c0097aA.f12495b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                } catch (FileNotFoundException unused) {
                                    fileOutputStream = null;
                                } catch (IOException unused2) {
                                    fileOutputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (FileNotFoundException unused3) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused4) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                            try {
                                jA = a(inputStream, fileOutputStream);
                                fileOutputStream.getFD().sync();
                            } catch (FileNotFoundException unused5) {
                                a(inputStream);
                            } catch (IOException unused6) {
                                a(inputStream);
                            } catch (Throwable th4) {
                                th = th4;
                                closeable = fileOutputStream;
                                a(inputStream);
                                a(closeable);
                                throw th;
                            }
                            if (jA != file.length()) {
                                a(inputStream);
                                a(fileOutputStream);
                            } else {
                                a(inputStream);
                                a(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                if (c0097aA != null) {
                                    try {
                                        if (c0097aA.f12494a != null) {
                                            c0097aA.f12494a.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused7) {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                    } catch (IOException unused8) {
                    }
                    i = i2;
                } else {
                    eVar.a("FATAL! Couldn't extract the library from the APK!");
                    if (c0097aA != null) {
                        try {
                            if (c0097aA.f12494a != null) {
                                c0097aA.f12494a.close();
                                return;
                            }
                            return;
                        } catch (IOException unused9) {
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            if (c0097aA != null) {
                try {
                    if (c0097aA.f12494a != null) {
                        c0097aA.f12494a.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }

    private long a(InputStream inputStream, OutputStream outputStream) throws IOException {
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

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
