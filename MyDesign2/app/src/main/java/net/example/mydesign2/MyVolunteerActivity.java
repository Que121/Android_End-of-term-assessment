package net.example.mydesign2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyVolunteerActivity extends AppCompatActivity {
    private EditText input_plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_volunteer);
        TextView top_tv=findViewById(R.id.top_tv);
          input_plant=findViewById(R.id.input_plant);
        RadioGroup radio_group=findViewById(R.id.radio_group);
        radio_group.check(UserInfo.getinstance().selectradioId);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                UserInfo.getinstance().selectradioId=id;
                switch (id){
                    case R.id.radio_baoyan:

                        UserInfo.getinstance().selectradioText="保研";
                        break;
                    case R.id.radio_kaoyan:
                        UserInfo.getinstance().selectradioText="考研";
                        break;

                    case R.id.radio_out:
                        UserInfo.getinstance().selectradioText="出国";
                        break;
                    case R.id.radio_work:
                        UserInfo.getinstance().selectradioText="工作";
                        break;

                    case R.id.radio_workmyself:
                        UserInfo.getinstance().selectradioText="创业";
                        break;

                    case R.id.radio_study:
                        UserInfo.getinstance().selectradioText="二学位";
                        break;

                    case R.id.radio_other:
                        UserInfo.getinstance().selectradioText="其他";
                        break;
                }
            }
        });
        top_tv.setText("我的志愿");
        findViewById(R.id.back_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.bnt_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputStr = input_plant.getText().toString().trim();
                if (TextUtils.isEmpty(inputStr)){
                    Toast tosat = Toast.makeText(MyVolunteerActivity.this, "请输入目标执行计划！", Toast.LENGTH_LONG);
                    tosat.setGravity(Gravity.CENTER,0,0);
                    tosat.show();
                    return;
                }
                UserInfo.getinstance().plant=inputStr;
                if (TextUtils.isEmpty(UserInfo.getinstance().selectradioText)){
                    UserInfo.getinstance().selectradioText="考研";
                }

                finish();
            }
        });
    }
}
