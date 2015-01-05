package com.example.piano;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button a;
	Button b;
	Button c;
	Button d;
	Button e;
	Button f;
	EditText text;
	Button submit;

	MediaPlayer player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		a = (Button) findViewById(R.id.aButton);
		b = (Button) findViewById(R.id.bButton);
		c = (Button) findViewById(R.id.cButton);
		d = (Button) findViewById(R.id.dButton);
		e = (Button) findViewById(R.id.eButton);
		f = (Button) findViewById(R.id.fButton);
		submit = (Button) findViewById(R.id.submit);
		text = (EditText)findViewById(R.id.editText1);

		
		a.setOnClickListener(this);
		b.setOnClickListener(this);
		c.setOnClickListener(this);
		d.setOnClickListener(this);
		e.setOnClickListener(this);
		f.setOnClickListener(this);
		submit.setOnClickListener(this);
		player = MediaPlayer.create(MainActivity.this,R.raw.a);

		setVolumeControlStream(AudioManager.STREAM_MUSIC);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	


	@Override
	public void onClick(View v) {
		Button buttonClicked = (Button) v;
		int id = buttonClicked.getId();
		
		if(v.getId()==R.id.aButton){
			//player.setAudioSessionId(R.raw.a);
			player = MediaPlayer.create(MainActivity.this,R.raw.a);
			player.start();
		}
		else if(v.getId()==R.id.bButton){
			//player.setAudioSessionId(R.raw.b);
			player = MediaPlayer.create(MainActivity.this,R.raw.b);
			player.start();
		}
		else if(v.getId()==R.id.cButton){
			player = MediaPlayer.create(MainActivity.this,R.raw.c);
			//player.setAudioSessionId(R.raw.c);
			player.start();
		}

		else if(v.getId()==R.id.dButton){
			player = MediaPlayer.create(MainActivity.this,R.raw.d);
			//player.setAudioSessionId(R.raw.d);
			player.start();
		}
		else if(v.getId()==R.id.eButton){
			player = MediaPlayer.create(MainActivity.this,R.raw.e);
			//player.setAudioSessionId(R.raw.e);
			player.start();
		}
		else if(v.getId()==R.id.fButton){
			player = MediaPlayer.create(MainActivity.this,R.raw.f);
			//player.setAudioSessionId(R.raw.f);
			player.start();
		}
		else if(v.getId()==R.id.submit){
			String song= text.getText().toString();
			System.out.println("SHOULD PLAY "+song);
			for(int x=0;x<song.length();x++){
				int sleepTime = 100;
				if(song.charAt(x)!='a'&&song.charAt(x)!='b'&&song.charAt(x)!='c'&&song.charAt(x)!='d'&&song.charAt(x)!='e'&&song.charAt(x)!='f'&&song.charAt(x)!='-'){
					break;
				}
				else{
					switch (song.charAt(x)) {
					case '-':
						sleepTime = 300;
						break;
					case 'a':
						player = MediaPlayer.create(MainActivity.this,R.raw.a);
						player.start();
						break;
					case 'b':
						player = MediaPlayer.create(MainActivity.this,R.raw.b);
						player.start();
						break;
					case 'c':
						player = MediaPlayer.create(MainActivity.this,R.raw.c);
						player.start();
						break;
					case 'd':
						player = MediaPlayer.create(MainActivity.this,R.raw.d);
						player.start();
						break;
					case 'e':
						player = MediaPlayer.create(MainActivity.this,R.raw.e);
						player.start();
						break;						
					case 'f':
						player = MediaPlayer.create(MainActivity.this,R.raw.f);
						player.start();
						break;	
					}
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
