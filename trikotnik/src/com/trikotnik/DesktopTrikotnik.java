package com.trikotnik;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopTrikotnik {
		public static void main(String[] args) {
	        new JoglApplication(new trikotnik(), "3d trikotnik", 
	        		480, 320, false);               
		}
	
	}

