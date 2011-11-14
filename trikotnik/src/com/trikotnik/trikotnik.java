package com.trikotnik;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.Color;


public class trikotnik implements ApplicationListener 
{
        //Spremenljivke
        private Mesh[] mesh;
        private OrthographicCamera camera;
        private float rotationSpeed;
        private int skupno = 0;
        private float movementIncrement = 0.0005f; //Moment
        //Github br8394

        @Override
        public void create() 
        {
        	rotationSpeed = 0.6f;

        	if (mesh == null) 
        	{
        	      mesh = new Mesh[6];
        	 
        	      for (int i = 0; i < 6; i++) 
        	      {
        	        mesh[i] = new Mesh(true, 6, 6,
        	            new VertexAttribute(Usage.Position, 3, "pozicija"),
        	            new VertexAttribute(Usage.ColorPacked, 4, "barva"));
        	 
        	        mesh[i].setIndices(new short[] { 0, 1, 2, 3, 4, 5});
        	      }
        	 
        	      mesh[0].setVertices(new float[] {
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 0),
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 0),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 0),
        	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 255, 0, 0) });
        	 
        	      mesh[1].setVertices(new float[] {
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(10, 255, 0, 0),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(10, 255, 0, 0),
        	          0.5f, -0.5f, -0.5f,  Color.toFloatBits(10, 255, 0, 0),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(10, 255, 0, 0) });
        	 
        	      mesh[2].setVertices(new float[] {
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 10, 0, 0),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 10, 0, 0),
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 10, 0),
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 10, 0) });
        	 
        	      mesh[3].setVertices(new float[] {
        	          0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 10, 255, 0),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 10, 255, 0),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 10, 255, 0),
        	          -0.5f, -0.5f, 0.5f,  Color.toFloatBits(0, 10, 255, 0) });
        	 
        	      mesh[4].setVertices(new float[] {
        	          0.5f, 0.5f, 0.5f, Color.toFloatBits(255, 0, 255, 0),
        	          0.5f, -0.5f, 0.5f, Color.toFloatBits(255, 0, 255, 0),
        	          0.5f, 0.5f, -0.5f, Color.toFloatBits(255, 0, 255, 0),
        	          0.5f, -0.5f, -0.5f, Color.toFloatBits(255, 0, 255, 0) });
        	 
        	      mesh[5].setVertices(new float[] {
        	          -0.5f, 0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 0),
        	          -0.5f, -0.5f, 0.5f, Color.toFloatBits(0, 255, 255, 0),
        	          -0.5f, 0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 0),
        	          -0.5f, -0.5f, -0.5f, Color.toFloatBits(0, 255, 255, 0) });
        	    }
        	Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
        }

        @Override
        public void dispose() { }

        @Override
        public void pause() { }

        @Override
        public void render() 
        {
        	handleInput();

            skupno += 1;
            if (skupno > 500) {
                movementIncrement = -movementIncrement;
                skupno = -200;
            }
            
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
            Gdx.gl10.glAlphaFunc(GL10.GL_GREATER, 0);
            camera.update();
            camera.apply(Gdx.gl10);
            
            for (Mesh face : mesh) 
            {
                  face.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
            }
        }
        
private void handleInput() {
            
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                camera.rotate(-rotationSpeed, 0, 0, 1);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
	                camera.rotate(rotationSpeed, 0, 0, 1);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.U)) {
                camera.zoom += 0.02;
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
                camera.zoom-=0.02;
	        }
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            {
                camera.rotate(-rotationSpeed, 0, 0, 1);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
	        {
	                camera.rotate(rotationSpeed, 0, 0, 1);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.W)) 
	        {
                camera.rotate(rotationSpeed, 0, 1, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.S))
	        {
                camera.rotate(rotationSpeed, 0, -1, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.UP)) 
	        {
                camera.rotate(rotationSpeed, 1, 0, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) 
	        {
                camera.rotate(-rotationSpeed, 1, 0, 0);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.A))
	        {
                camera.zoom += 0.02;
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.D))
	        {
                camera.zoom -= 0.02;
	        }
    }

        @Override
        public void resize(int width, int height) 
        {
            float aspectRatio = (float) width / (float) height;
            camera = new OrthographicCamera(2f * aspectRatio, 2f);
        }

        @Override
        public void resume() {}
        
}