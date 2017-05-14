package com.womenemergency.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;



import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
Button police,Alert,Show,audio,protocol2,Vorecc,test;
String PhoneNo;
TextView tv,tv1,testt1;
public static final String filename="Contacts";
public static final String filename1="mailIDs";
private automatimail m;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testt1=(TextView)findViewById(R.id.test1);
		police=(Button)findViewById(R.id.Police);
		Alert=(Button)findViewById(R.id.bAlert);
		audio=(Button)findViewById(R.id.baudio);
		protocol2=(Button)findViewById(R.id.protoco2);
		Vorecc=(Button)findViewById(R.id.vorec);
		//test=(Button)findViewById(R.id.test);
		final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rec);
		m=new automatimail("sukhmansingh18@gmail.com","sukhmansingh18");
		   
       
     
	
		police.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String numer="100";
				Intent i= new Intent(Intent.ACTION_CALL);
				i.setData(Uri.parse("tel:" +numer));
				startActivity(i);
			}
		});
	
		Alert.setOnClickListener(new OnClickListener() {
			
			private String AC;

			@Override
			public void onClick(View arg0) {
				StringBuffer stringBuffer = new StringBuffer(); 
				String filename="Contacts";
		        String aDataRow = "";  
		        String aBuffer = "";
		       try {
		            File myFile = new File("/sdcard/"+filename);  
		            FileInputStream fIn = new FileInputStream(myFile);  
		            BufferedReader myReader = new BufferedReader(  
		                    new InputStreamReader(fIn));  
		              
		            while ((aDataRow = myReader.readLine()) != null) {  
		                aBuffer += aDataRow + "\n";  
		            }  
		            myReader.close();  
		              
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  

//				  try {
				
	//		            SmsManager smsManager = SmsManager.getDefault();
		//	            smsManager.sendTextMessage(aBuffer, null, "In serious problem", null, null);
			//            Toast.makeText(getApplicationContext(), "SMS sent.",
			 //           Toast.LENGTH_LONG).show();
			  //       } catch (Exception e) {
			   //         Toast.makeText(getApplicationContext(),
			     //       "SMS faild, please try again.",
			       //     Toast.LENGTH_LONG).show();
			        //    e.printStackTrace();
			     // }
				
				new Thread(new Runnable() {

					  @Override
					  public void run() {
					    // operations to be performed on a background thread

							StringBuffer stringBuffer= new StringBuffer(); 
							String filename1="mailIDs";
					        String aDataRow = "";  
					        String aBuffer = "";  
					        try {  
					            File myFile = new File("/sdcard/"+filename1);  
					            FileInputStream fIn = new FileInputStream(myFile);  
					            BufferedReader myReader = new BufferedReader(  
					                    new InputStreamReader(fIn));       
					            while ((aDataRow = myReader.readLine()) != null) {  
					                aBuffer += aDataRow + "\n";  
					            }  
					            myReader.close();  
					              
					        } catch (IOException e) {  
					            e.printStackTrace();  
					        }  
					     
					        String[] parts = aBuffer.split(",");
					        String part1 = parts[0]; 
					        String part2 = parts[1];
					        String part3=parts[2];
					        String part4=parts[3];
					        String part5=parts[4];
					        String part6=parts[5];
					    	String[] toArr={part1,part2,part3};
					    	m.setTo(toArr);
							m.setFrom("sukhmansingh18@gmail.com"); // who is sending the email 
							m.setSubject("subject"); 
							m.setBody("In problem, trace my position now...in serious problem"); 
						
					 
							try { 
						  // path to file you want to attach
								m.send();
								if(m.send()) { 
									// success
									//Toast.makeText(MainActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
								} else { 
									// failure
									//Toast.makeText(MainActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
								} 
							} catch(Exception e) { 
								// some other problem
								//Toast.makeText(MainActivity.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show(); 
							} 
					  }

					}).start();
			
			
		        

			}
		});
		audio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mediaPlayer.start();
			}
		});				 
        protocol2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ourIntent=new Intent(MainActivity.this,recc.class);
				startActivity(ourIntent);
			}
		});
        Vorecc.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ourIntent=new Intent(MainActivity.this,voicerec.class);
				startActivity(ourIntent);
			}
		});
        test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				StringBuffer stringBuffer = new StringBuffer(); 
				String filename="Contacts";
		        String aDataRow = "";  
		        String aBuffer = "";  
		        try {  
		            File myFile = new File("/sdcard/"+filename);  
		            FileInputStream fIn = new FileInputStream(myFile);  
		            BufferedReader myReader = new BufferedReader(  
		                    new InputStreamReader(fIn));  
		              
		            while ((aDataRow = myReader.readLine()) != null) {  
		                aBuffer += aDataRow + "\n";  
		            }  
		            myReader.close();  
		              
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		        testt1.setText(aBuffer);			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp= getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i=new Intent("com.womenemergency.app.ABOUT");
			startActivity(i);
			break;

		case R.id.updateinfo:
			Intent p= new Intent("com.womenemergency.app.UPDATEINFO");
			startActivity(p);
			break;
			
		case R.id.mail:
			Intent g = new Intent("com.womenemergency.app.MAIL");
			startActivity(g);
			break;
		}
		return false;
	}


}

	

		
