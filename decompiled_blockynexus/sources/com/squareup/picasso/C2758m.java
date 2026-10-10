package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.squareup.picasso.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContactsPhotoRequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
class C2758m extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UriMatcher f19295a = new UriMatcher(-1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f19296b;

    /* JADX INFO: renamed from: com.squareup.picasso.m$a */
    /* JADX INFO: compiled from: ContactsPhotoRequestHandler.java */
    @TargetApi(14)
    private static class a {
        static InputStream a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f19295a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f19295a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f19295a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f19295a.addURI("com.android.contacts", "contacts/#", 3);
        f19295a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C2758m(Context context) {
        this.f19296b = context;
    }

    private InputStream c(C c2) throws IOException {
        ContentResolver contentResolver = this.f19296b.getContentResolver();
        Uri uriLookupContact = c2.f19213e;
        int iMatch = f19295a.match(uriLookupContact);
        if (iMatch != 1) {
            if (iMatch != 2) {
                if (iMatch != 3) {
                    if (iMatch != 4) {
                        throw new IllegalStateException("Invalid uri: " + uriLookupContact);
                    }
                }
            }
            return contentResolver.openInputStream(uriLookupContact);
        }
        uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
        if (uriLookupContact == null) {
            return null;
        }
        return Build.VERSION.SDK_INT < 14 ? ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact) : a.a(contentResolver, uriLookupContact);
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f19213e;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f19295a.match(c2.f19213e) != -1;
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        InputStream inputStreamC = c(c2);
        if (inputStreamC != null) {
            return new E.a(inputStreamC, Picasso.LoadedFrom.DISK);
        }
        return null;
    }
}
