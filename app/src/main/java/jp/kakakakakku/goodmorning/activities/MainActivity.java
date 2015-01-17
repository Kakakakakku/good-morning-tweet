package jp.kakakakakku.goodmorning.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import jp.kakakakakku.goodmorning.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageButton bWakeup = (ImageButton) findViewById(R.id.ib_tweet);
        bWakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tweet 文字列を付与してインテントを起動する
                String url = "http://twitter.com/share?text=" + getMessage();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    private String getMessage() {
        // 現在時刻を取得して、Tweet するメッセージを生成する
        DateTime dt = new DateTime();
        String date = dt.toString(DateTimeFormat.mediumDate());
        String time = dt.toString(DateTimeFormat.shortTime());
        return Uri.encode(date + " の起床時刻は " + time + " です" + " #おはようTweet");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
