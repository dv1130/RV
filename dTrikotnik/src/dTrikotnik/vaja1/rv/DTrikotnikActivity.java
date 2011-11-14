package dTrikotnik.vaja1.rv;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.trikotnik.trikotnik;

import android.os.Bundle;
import android.view.KeyEvent;

public class DTrikotnikActivity extends AndroidApplication {
    
	Zvok zvok = new Zvok();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new trikotnik(), false);
        Sound();
        zvok.Predvajaj();
    }
    
    public void Sound()
    {
        zvok.IzberiZvok("data","Applause.mp3");
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
    	super.onKeyDown(keyCode, event);
    	
        if (keyCode == KeyEvent.KEYCODE_P) 
        {
        	zvok.Pavza();
        }
        if (keyCode == KeyEvent.KEYCODE_O) 
        {
        	zvok.Predvajaj();
        }
        if (keyCode == KeyEvent.KEYCODE_I) 
        {
        	zvok.Stop();
        	Sound();
        }
        
        return super.onKeyDown(keyCode, event);
    }
    
    @Override
	public void onResume() 
    { 
		super.onResume();
		zvok.Predvajaj();
	}
    
	@Override
	public void onPause() 
	{ 
		super.onPause();
		zvok.Pavza();
	}
	
	@Override
	public void onDestroy() 
	{
		super.onDestroy();
		zvok.Stop();
	}

}