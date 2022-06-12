package net.example.mydesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View main_ly1,main_ly2,main_ly3,main_ly4;
    private ImageView main_img1,main_img2,main_img3,main_img4;
    private TextView home_tv1,home_tv2,home_tv3,home_tv4;
    private View spell_ly,spell_ly2,spell_line,spell_line2;
    private TextView spell_text,spell_text2,top_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_ly1=findViewById(R.id.main_ly1);
        main_ly2=findViewById(R.id.main_ly2);
        main_ly3=findViewById(R.id.main_ly3);
        main_ly4=findViewById(R.id.main_ly4);
        main_img1=findViewById(R.id.hone_img);
        main_img2=findViewById(R.id.hone_img2);
        main_img3=findViewById(R.id.hone_img3);
        main_img4=findViewById(R.id.hone_img4);
        home_tv1=findViewById(R.id.home_tv);
        home_tv2=findViewById(R.id.home_tv2);
        home_tv3=findViewById(R.id.home_tv3);
        home_tv4=findViewById(R.id.home_tv4);
        spell_ly=findViewById(R.id.spell_ly);
        spell_ly2=findViewById(R.id.spell_ly2);
        spell_text=findViewById(R.id.spell_text);
        spell_text2=findViewById(R.id.spell_text2);
        spell_line=findViewById(R.id.spell_line);
        spell_line2=findViewById(R.id.spell_line2);
        top_tv=findViewById(R.id.top_tv);
        main_ly1.setOnClickListener(this);
        main_ly2.setOnClickListener(this);
        main_ly3.setOnClickListener(this);
        main_ly4.setOnClickListener(this);
        spell_ly.setOnClickListener(this);
        spell_ly2.setOnClickListener(this);
        main_img1.setSelected(true);
        home_tv1.setSelected(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_ly1:
                main_img1.setSelected(true);
                main_img2.setSelected(false);
                main_img3.setSelected(false);
                main_img4.setSelected(false);
                top_tv.setText("首页");
                home_tv1.setSelected(true);
                home_tv2.setSelected(false);
                home_tv3.setSelected(false);
                home_tv4.setSelected(false);
                break;
            case R.id.main_ly2:
                main_img2.setSelected(true);
                main_img1.setSelected(false);
                main_img3.setSelected(false);
                main_img4.setSelected(false);
                top_tv.setText("办事");
                home_tv2.setSelected(true);
                home_tv1.setSelected(false);
                home_tv3.setSelected(false);
                home_tv4.setSelected(false);
                break;
            case R.id.main_ly3:
                main_img3.setSelected(true);
                main_img2.setSelected(false);
                main_img1.setSelected(false);
                main_img4.setSelected(false);
                top_tv.setText("信息");
                home_tv3.setSelected(true);
                home_tv2.setSelected(false);
                home_tv1.setSelected(false);
                home_tv4.setSelected(false);
                break;
            case R.id.main_ly4:
                main_img4.setSelected(true);
                main_img2.setSelected(false);
                main_img3.setSelected(false);
                main_img1.setSelected(false);
                top_tv.setText("我的");
                home_tv4.setSelected(true);
                home_tv2.setSelected(false);
                home_tv3.setSelected(false);
                home_tv1.setSelected(false);
                break;
            case R.id.spell_ly:
                spell_text.setSelected(true);
                spell_text2.setSelected(false);
                spell_line.setVisibility(View.VISIBLE);
                spell_line2.setVisibility(View.GONE);

                break;

            case R.id.spell_ly2:
                spell_text.setSelected(false);
                spell_text2.setSelected(true);
                spell_line.setVisibility(View.GONE);
                spell_line2.setVisibility(View.VISIBLE);


                break;
        }
    }
}