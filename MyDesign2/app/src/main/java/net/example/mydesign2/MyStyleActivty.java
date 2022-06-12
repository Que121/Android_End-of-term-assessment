package net.example.mydesign2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class MyStyleActivty extends AppCompatActivity {
    private TextView input_class,input_name,input_numb,input_address,input_plant,input_plant_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_style);
        writeaPermission();
        TextView top_tv=findViewById(R.id.top_tv);
        input_class=findViewById(R.id.input_class);
        input_name=findViewById(R.id.input_name);
        input_numb=findViewById(R.id.input_numb);
        input_address=findViewById(R.id.input_address);
        input_plant=findViewById(R.id.input_plant);
        input_plant_desc=findViewById(R.id.input_plant_desc);
        top_tv.setText("我的风采");
        findViewById(R.id.back_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.back_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.bnt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo(UserInfo.getinstance().toString());
            }
        });
        findViewById(R.id.bnt_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radePermission();
            }
        });

        setDataTv();
    }

    private void setDataTv() {
        input_class.setText(UserInfo.getinstance().classname);
        input_name.setText(UserInfo.getinstance().name);
        input_numb.setText(UserInfo.getinstance().num);
        input_address.setText(UserInfo.getinstance().address);
        input_plant.setText(UserInfo.getinstance().selectradioText);
        input_plant_desc.setText(UserInfo.getinstance().plant);
    }
    public   boolean saveUserInfo(String data){
        if (data.startsWith("####")&&data.endsWith("##")){
            Toast tosat = Toast.makeText(MyStyleActivty.this, "存储内容不能为空！", Toast.LENGTH_LONG);
            tosat.setGravity(Gravity.CENTER,0,0);
            tosat.show();
            return false;
        }
        writePermission(data);

        return false;
    }

    public static String rateName = "desiguser.txt";//保存设备收费标准
    public static boolean saveRate(String rate) {
        File file = new File(Constant.PATH_RATE + rateName);
        if (file.exists()) {
            FileUtil.delete(Constant.PATH_RATE + rateName);
        }
        return writeTxtToFile(rate, Constant.PATH_RATE, rateName);
    }
    /**
     * 字符串写入本地txt
     *
     * @param strcontent 文件内容
     * @param filePath   文件地址
     * @param fileName   文件名
     * @return 写入结果
     */
    private static boolean writeTxtToFile(String strcontent, String filePath, String fileName) {
        boolean isSavaFile = false;
        makeFilePath(filePath, fileName);
        String strFilePath = filePath + fileName;
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
            isSavaFile = true;
        } catch (Exception e) {
            isSavaFile = false;
            Log.e("TestFile", "Error on write File:" + e);
        }
        return isSavaFile;
    }
    /**
     * 生成文件夹
     */
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }

    /**
     * 生成文件
     *
     * @param filePath 文件地址
     * @param fileName 文件名
     */
    private static File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
    /**
     * 读取本地文件
     */
    public   void readRate() {
        String path = Constant.PATH_RATE + rateName;
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);
        if (!file.exists()) {
            Toast tosat = Toast.makeText(MyStyleActivty.this, "未找到存储信息！", Toast.LENGTH_LONG);
            tosat.setGravity(Gravity.CENTER,0,0);
            tosat.show();
            return  ;
        }
        if (file.isDirectory()) {
            Log.e("TestFile", "The File doesn't not exist.");
            return  ;
        } else {
            try {
                InputStream instream = new FileInputStream(file);
                if (instream != null) {
                    InputStreamReader inputreader = new InputStreamReader(instream);
                    BufferedReader buffreader = new BufferedReader(inputreader);
                    String line;
                    while ((line = buffreader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    instream.close();
                }
            } catch (java.io.FileNotFoundException e) {
                Log.e("TestFile", "The File doesn't not exist.");
                return  ;
            } catch (IOException e) {
                Log.e("TestFile", e.getMessage());
                return  ;
            }
        }

        if(!TextUtils.isEmpty(stringBuilder.toString()))
        {
            String [] datas=stringBuilder.toString().split("#");
            UserInfo.getinstance().name=datas[0];
            UserInfo.getinstance().num=datas[1];
            UserInfo.getinstance().classname=datas[2];
            UserInfo.getinstance().address=datas[3];
            UserInfo.getinstance().selectradioId=datas[4]==""?R.id.radio_kaoyan:Integer.parseInt(datas[4]);
            UserInfo.getinstance().selectradioText=datas[5];
            UserInfo.getinstance().plant=datas[6];
            setDataTv();
            Toast tosat = Toast.makeText(MyStyleActivty.this, "读取成功！", Toast.LENGTH_LONG);
            tosat.setGravity(Gravity.CENTER,0,0);
            tosat.show();
        }

    }
    private String PM_SINGLE= Manifest.permission.WRITE_EXTERNAL_STORAGE;

    //申请单个权限
    public void writeaPermission(){

        try{
            //如果操作系统SDK级别在23之上（android6.0），就进行动态权限申请
            if(Build.VERSION.SDK_INT>=23){
                //判断是否拥有权限
                int nRet= ContextCompat.checkSelfPermission(this,PM_SINGLE);

                if(nRet!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(this,new String[]{PM_SINGLE},10000);
                }
                int nRet2= ContextCompat.checkSelfPermission(this,PM_RADE);

                if(nRet2!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(this,new String[]{PM_RADE},10000);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //申请单个权限
    public void writePermission(String data){

        try{
            //如果操作系统SDK级别在23之上（android6.0），就进行动态权限申请
            if(Build.VERSION.SDK_INT>=23){
                //判断是否拥有权限
                int nRet= ContextCompat.checkSelfPermission(this,PM_SINGLE);

                if(nRet!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(this,new String[]{PM_SINGLE},10000);
                }
                else{
                    saveRate(data);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private String PM_RADE= Manifest.permission.READ_EXTERNAL_STORAGE;
    //申请单个权限
    public void radePermission(){

        try{
            //如果操作系统SDK级别在23之上（android6.0），就进行动态权限申请
            if(Build.VERSION.SDK_INT>=23){
                //判断是否拥有权限
                int nRet= ContextCompat.checkSelfPermission(this,PM_RADE);

                if(nRet!= PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(this,new String[]{PM_RADE},10000);
                }
                else{
                    readRate();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
