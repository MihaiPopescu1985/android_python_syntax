package com.wowotraining.python_syntax;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {

    private static GeckoRuntime sRuntime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.showExercises();
    }

    private void showExercises() {
        GeckoView view = this.findViewById(R.id.geckoview);
        GeckoSession session = new GeckoSession();
        //session.setContentDelegate(new GeckoSession.ContentDelegate() {});
        if (sRuntime == null) {
            //GeckoRuntime can only be initialized once per process
            sRuntime = GeckoRuntime.create(this);
        }
        session.open(sRuntime);
        view.setSession(session);
        String TUTORIAL_URL = "https://mihaipopescu1985.github.io/wowotraining.com/python_syntax.html";
        session.loadUri(TUTORIAL_URL);
    }
}
