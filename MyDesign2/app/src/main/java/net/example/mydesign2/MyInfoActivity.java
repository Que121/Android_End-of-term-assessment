package net.example.mydesign2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfoActivity extends AppCompatActivity {
    TextView input_class,input_name,input_numb,input_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        TextView top_tv=findViewById(R.id.top_tv);
        input_class =findViewById(R.id.input_class);
        input_name =findViewById(R.id.input_name);
        input_numb =findViewById(R.id.input_numb);
        input_address =findViewById(R.id.input_address);
        top_tv.setText("我的信息");
        setTextData();
        findViewById(R.id.back_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.bnt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classname = input_class.getText().toString().trim();
                String name = input_name.getText().toString().trim();
                String numb = input_numb.getText().toString().trim();
                String address = input_address.getText().toString().trim();
                if (TextUtils.isEmpty(classname)||TextUtils.isEmpty(name)||TextUtils.isEmpty(numb)||TextUtils.isEmpty(address)){
                    Toast tosat = Toast.makeText(MyInfoActivity.this, "请填写完信息！", Toast.LENGTH_LONG);
                    tosat.setGravity(Gravity.CENTER,0,0);
                    tosat.show();
                    return;
                }
                UserInfo.getinstance().address=address;
                UserInfo.getinstance().name=name;
                UserInfo.getinstance().num=numb;
                UserInfo.getinstance().classname=classname;
                finish();
            }
        });
        findViewById(R.id.bnt_clean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo.getinstance().address="";
                UserInfo.getinstance().name="";
                UserInfo.getinstance().num="";
                UserInfo.getinstance().classname="";
                setTextData();
            }
        });

    }

    private void setTextData(){
        input_class.setText(UserInfo.getinstance().classname);
        input_name.setText(UserInfo.getinstance().name);
        input_numb.setText(UserInfo.getinstance().num);
        input_address.setText(UserInfo.getinstance().address);
    }
}
