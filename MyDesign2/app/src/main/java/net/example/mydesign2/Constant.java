package net.example.mydesign2;

import android.os.Environment;

import java.io.File;

public class Constant {
    public static String PATH_RATE = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "mydesign/";
}
