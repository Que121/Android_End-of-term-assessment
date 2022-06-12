    package net.example.mydesign2;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            findViewById(R.id.my_info).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActiviy(MyInfoActivity.class);
                }
            });
            findViewById(R.id.my_volunteer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActiviy(MyVolunteerActivity.class);
                }
            });
            findViewById(R.id.my_style).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActiviy(MyStyleActivty.class);
                }
            });
            findViewById(R.id.my_finish).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        private void startActiviy( Class<?>  cl){
            Intent iten = new Intent(this, cl);
            startActivity(iten);
        }
    }