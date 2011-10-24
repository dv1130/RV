package dTrikotnik.vaja1.rv;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.trikotnik.trikotnik;

import android.os.Bundle;

public class DTrikotnikActivity extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new trikotnik(), false);
    }
}