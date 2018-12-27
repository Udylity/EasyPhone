package com.udylity.easyphone;

import java.util.List;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class Utilities {


    public static List getInstalledApplication(Context c) {

        return c.getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);

    }

    public static boolean launchApp(Context c, PackageManager pm, String pkgName) {
         Intent intent = pm.getLaunchIntentForPackage(pkgName);
         if(intent != null) {

            try {
                c.startActivity(intent);
                return true;

            } catch(ActivityNotFoundException ex) {

                Toast toast = Toast.makeText(c, "Application Not Found", Toast.LENGTH_LONG);
                toast.show();

            }

        }

        return false;

    }

}

