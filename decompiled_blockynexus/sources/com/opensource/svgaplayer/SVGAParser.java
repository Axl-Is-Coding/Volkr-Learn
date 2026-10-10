package com.opensource.svgaplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.util.Log;
import com.opensource.svgaplayer.proto.MovieEntity;
import io.rong.common.dlog.DLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.json.JSONObject;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SVGAParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f15449d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f15450e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f15448c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f15446a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SVGAParser f15447b = new SVGAParser(null);

    /* JADX INFO: compiled from: SVGAParser.kt */
    public static final class a {
        private a() {
        }

        public final ExecutorService a() {
            return SVGAParser.f15446a;
        }

        public final SVGAParser b() {
            return SVGAParser.f15447b;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SVGAParser.kt */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f15451a;

        public final boolean a() {
            return this.f15451a;
        }

        public kotlin.jvm.a.a<kotlin.l> a(URL url, kotlin.jvm.a.b<? super InputStream, kotlin.l> bVar, kotlin.jvm.a.b<? super Exception, kotlin.l> bVar2) {
            kotlin.jvm.internal.i.b(url, "url");
            kotlin.jvm.internal.i.b(bVar, "complete");
            kotlin.jvm.internal.i.b(bVar2, "failure");
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            kotlin.jvm.a.a<kotlin.l> aVar = new kotlin.jvm.a.a<kotlin.l>() { // from class: com.opensource.svgaplayer.SVGAParser$FileDownloader$resume$cancelBlock$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ kotlin.l invoke() {
                    invoke2();
                    return kotlin.l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ref$BooleanRef.element = true;
                }
            };
            SVGAParser.f15448c.a().execute(new j(this, url, ref$BooleanRef, bVar, bVar2));
            return aVar;
        }
    }

    /* JADX INFO: compiled from: SVGAParser.kt */
    public interface c {
        void a(q qVar);

        void onError();
    }

    public SVGAParser(Context context) {
        this.f15450e = context;
    }

    private final boolean c(String str) {
        return a(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeCompleteCallback(q qVar, c cVar) {
        if (this.f15450e == null) {
            Log.e("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
        }
        Context context = this.f15450e;
        new Handler(context != null ? context.getMainLooper() : null).post(new m(cVar, qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeErrorCallback(Exception exc, c cVar) {
        exc.printStackTrace();
        if (this.f15450e == null) {
            Log.e("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
        }
        Context context = this.f15450e;
        new Handler(context != null ? context.getMainLooper() : null).post(new n(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable, java.io.FileInputStream] */
    public final void c(String str, c cVar) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        File cacheDir;
        if (this.f15450e == null) {
            Log.e("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
        }
        try {
            StringBuilder sb = new StringBuilder();
            Context context = this.f15450e;
            Throwable th3 = null;
            sb.append((context == null || (cacheDir = context.getCacheDir()) == null) ? null : cacheDir.getAbsolutePath());
            sb.append("/");
            sb.append(str);
            sb.append("/");
            File file = new File(sb.toString());
            File file2 = new File(file, "movie.binary");
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 != null) {
                try {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        try {
                            MovieEntity movieEntityDecode = MovieEntity.ADAPTER.decode(fileInputStream);
                            kotlin.jvm.internal.i.a((Object) movieEntityDecode, "MovieEntity.ADAPTER.decode(it)");
                            invokeCompleteCallback(new q(movieEntityDecode, file), cVar);
                            kotlin.l lVar = kotlin.l.f22855a;
                        } catch (Throwable th4) {
                            th3 = th4;
                            throw th3;
                        }
                    } finally {
                        kotlin.io.a.a(fileInputStream, th3);
                    }
                } catch (Exception e2) {
                    file.delete();
                    file2.delete();
                    throw e2;
                }
            }
            File file3 = new File(file, "movie.spec");
            ?? IsFile = file3.isFile();
            if (IsFile == 0) {
                file3 = null;
            }
            if (file3 == null) {
                return;
            }
            try {
                try {
                    fileInputStream = new FileInputStream(file3);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[DLog.CRS];
                        while (true) {
                            int i = fileInputStream.read(bArr, 0, bArr.length);
                            if (i == -1) {
                                invokeCompleteCallback(new q(new JSONObject(byteArrayOutputStream.toString()), file), cVar);
                                kotlin.l lVar2 = kotlin.l.f22855a;
                                kotlin.io.a.a(byteArrayOutputStream, null);
                                kotlin.l lVar3 = kotlin.l.f22855a;
                                return;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (Throwable th5) {
                        try {
                            throw th5;
                        } catch (Throwable th6) {
                            th = th5;
                            th2 = th6;
                            kotlin.io.a.a(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Exception e3) {
                    file.delete();
                    file3.delete();
                    throw e3;
                }
            } catch (Throwable th7) {
                kotlin.io.a.a(IsFile, null);
                throw th7;
            }
        } catch (Exception e4) {
            invokeErrorCallback(e4, cVar);
        }
    }

    public final void b(String str, c cVar) {
        kotlin.jvm.internal.i.b(str, "assetsName");
        a(str, cVar);
    }

    public final void b(URL url, c cVar) {
        kotlin.jvm.internal.i.b(url, "url");
        a(url, cVar);
    }

    private final String b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.i.a((Object) charsetForName, "Charset.forName(charsetName)");
        if (str != null) {
            byte[] bytes = str.getBytes(charsetForName);
            kotlin.jvm.internal.i.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String string = "";
            for (byte b2 : messageDigest.digest()) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f22853a;
                Object[] objArr = {Byte.valueOf(b2)};
                String str2 = String.format("%02x", Arrays.copyOf(objArr, objArr.length));
                kotlin.jvm.internal.i.a((Object) str2, "java.lang.String.format(format, *args)");
                sb.append(str2);
                string = sb.toString();
            }
            return string;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final void a(Context context) {
        kotlin.jvm.internal.i.b(context, com.umeng.analytics.pro.b.Q);
        this.f15450e = context;
    }

    public final void a(String str, c cVar) {
        AssetManager assets;
        InputStream inputStreamOpen;
        kotlin.jvm.internal.i.b(str, "name");
        if (this.f15450e == null) {
            Log.e("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
        }
        try {
            Context context = this.f15450e;
            if (context == null || (assets = context.getAssets()) == null || (inputStreamOpen = assets.open(str)) == null) {
                return;
            }
            a(inputStreamOpen, b("file:///assets/" + str), cVar, true);
        } catch (Exception e2) {
            invokeErrorCallback(e2, cVar);
        }
    }

    public final kotlin.jvm.a.a<kotlin.l> a(final URL url, final c cVar) {
        kotlin.jvm.internal.i.b(url, "url");
        if (c(a(url))) {
            f15446a.execute(new l(this, url, cVar));
            return null;
        }
        return this.f15449d.a(url, new kotlin.jvm.a.b<InputStream, kotlin.l>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ kotlin.l invoke(InputStream inputStream) {
                invoke2(inputStream);
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputStream inputStream) {
                kotlin.jvm.internal.i.b(inputStream, "it");
                SVGAParser sVGAParser = this.this$0;
                SVGAParser.a(sVGAParser, inputStream, sVGAParser.a(url), cVar, false, 8, null);
            }
        }, new kotlin.jvm.a.b<Exception, kotlin.l>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ kotlin.l invoke(Exception exc) {
                invoke2(exc);
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                kotlin.jvm.internal.i.b(exc, "it");
                this.this$0.invokeErrorCallback(exc, cVar);
            }
        });
    }

    public static /* synthetic */ void a(SVGAParser sVGAParser, InputStream inputStream, String str, c cVar, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        sVGAParser.a(inputStream, str, cVar, z);
    }

    public final void a(InputStream inputStream, String str, c cVar, boolean z) {
        kotlin.jvm.internal.i.b(inputStream, "inputStream");
        kotlin.jvm.internal.i.b(str, "cacheKey");
        f15446a.execute(new k(this, inputStream, str, cVar, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(URL url) {
        String string = url.toString();
        kotlin.jvm.internal.i.a((Object) string, "url.toString()");
        return b(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File a(String str) {
        File cacheDir;
        StringBuilder sb = new StringBuilder();
        Context context = this.f15450e;
        sb.append((context == null || (cacheDir = context.getCacheDir()) == null) ? null : cacheDir.getAbsolutePath());
        sb.append("/");
        sb.append(str);
        sb.append("/");
        return new File(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable th = null;
        try {
            try {
                bArr = new byte[DLog.CRS];
            } finally {
            }
        } finally {
            kotlin.io.a.a(byteArrayOutputStream, th);
        }
        while (true) {
            int i = inputStream.read(bArr, 0, DLog.CRS);
            if (i <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
            kotlin.io.a.a(byteArrayOutputStream, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(byte[] bArr) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[DLog.CRS];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int iInflate = inflater.inflate(bArr2, 0, DLog.CRS);
                if (iInflate <= 0) {
                    inflater.end();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, iInflate);
            } finally {
                kotlin.io.a.a(byteArrayOutputStream, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(InputStream inputStream, String str) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        synchronized (Integer.valueOf(o.f15564a)) {
            File fileA = a(str);
            fileA.mkdirs();
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                    while (true) {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                String name = nextEntry.getName();
                                kotlin.jvm.internal.i.a((Object) name, "zipItem.name");
                                if (!kotlin.text.o.a((CharSequence) name, (CharSequence) "/", false, 2, (Object) null)) {
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(fileA, nextEntry.getName()));
                                    try {
                                        byte[] bArr = new byte[DLog.CRS];
                                        while (true) {
                                            int i = zipInputStream.read(bArr);
                                            if (i <= 0) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, i);
                                            }
                                        }
                                        kotlin.l lVar = kotlin.l.f22855a;
                                        kotlin.io.a.a(fileOutputStream, null);
                                        zipInputStream.closeEntry();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        th3 = null;
                                        kotlin.io.a.a(fileOutputStream, th3);
                                        throw th;
                                    }
                                }
                            } else {
                                kotlin.l lVar2 = kotlin.l.f22855a;
                                kotlin.io.a.a(zipInputStream, null);
                                kotlin.l lVar3 = kotlin.l.f22855a;
                                kotlin.l lVar4 = kotlin.l.f22855a;
                            }
                        } catch (Throwable th5) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                th = th5;
                                th2 = th6;
                                kotlin.io.a.a(zipInputStream, th);
                                throw th2;
                            }
                        }
                    }
                } finally {
                    kotlin.io.a.a(bufferedInputStream, null);
                }
            } catch (Exception e2) {
                fileA.delete();
                throw e2;
            }
        }
    }
}
