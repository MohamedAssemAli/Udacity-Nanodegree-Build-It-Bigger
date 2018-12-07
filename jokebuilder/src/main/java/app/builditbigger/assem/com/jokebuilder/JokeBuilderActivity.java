package app.builditbigger.assem.com.jokebuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeBuilderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_builder);
        TextView jokeTxt = findViewById(R.id.joke_text);
        jokeTxt.setText(getIntent().getStringExtra("key"));
    }
}
