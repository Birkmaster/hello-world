package org.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

private class GetAndroidPitRssFeedTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        String result = "";
        try {
            result = getAndroidPitRssFeed();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String rssFeed) {
        mRssFeed.setText(rssFeed);
    }
}

public class NewsActivity extends AppCompatActivity {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_news, container, false);
        mRssFeed = (TextView) rootView.findViewById(R.id.activity_news_rss);
        return rootView;
    }
    @Override
    public void onStart() {
        super.onStart();
        InputStream in = null;
        try {
            URL url = new URL("http://rss.orf.at/news.xml");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int count; (count = in.read(buffer)) != -1; ) {
                out.write(buffer, 0, count);
            }
            byte[] response = out.toByteArray();
            String rssFeed = new String(response, "UTF-8");
            mRssFeed.setText(rssFeed);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
