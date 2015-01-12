package jp.kakakakakku.goodmorning.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import jp.kakakakakku.goodmorning.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bWakeup = (Button) findViewById(R.id.b_wakeup);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
