package rs.led_chikachika;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener btn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setSmallIcon(R.drawable.ic_stat_name);
                builder.setContentTitle("LEDが点灯中です");
                builder.setContentText("左右にフリックして終了します");
                builder.setNumber(1);
                EditText et = (EditText)findViewById(R.id.editText1);
                int milsec = Integer.parseInt(et.getText().toString());
                builder.setLights(Color.WHITE,milsec,milsec);

                NotificationManagerCompat nm = NotificationManagerCompat.from(getApplicationContext());
                nm.notify(1,builder.build());
                TextView tv = (TextView)findViewById(R.id.textView);
                tv.setText(milsec*0.001+"秒で開始!");
            }
        };
        findViewById(R.id.button1).setOnClickListener(btn1);
    }

}
