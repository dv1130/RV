package dTrikotnik.vaja1.rv;

import java.io.IOException;

import android.media.MediaPlayer;

class Zvok
{
	MediaPlayer mp = new MediaPlayer();
	
	public void IzberiZvok(String direktorij, String ime_datoteke)
	{
        try 
        {
            mp.setDataSource(direktorij + "/" + ime_datoteke);
        } 
        catch (IllegalArgumentException e) 
        {
            e.printStackTrace();
        } 
        catch (IllegalStateException e) 
        {
            e.printStackTrace();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        try 
        {
            mp.prepare();
        } 
        catch (IllegalStateException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	public void Predvajaj()
	{
		mp.start();
	}
	
	public void Pavza()
	{
		mp.pause();
	}
	
	public void Stop()
	{
		mp.stop();
	}

}
