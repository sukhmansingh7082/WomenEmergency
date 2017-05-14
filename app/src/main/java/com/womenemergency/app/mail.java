package com.womenemergency.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class mail extends Activity{
	int i=0;
public static final String filename1="mailIDs";
EditText FatherID,MotherID,BrotherID,SisterID,Friend1,Friend2;
Button confirm;
/* (non-Javadoc)
 * @see android.app.Activity#onCreate(android.os.Bundle)
 */
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.mail);
	FatherID=(EditText)findViewById(R.id.fatherID);
	MotherID=(EditText)findViewById(R.id.motherID);
	BrotherID=(EditText)findViewById(R.id.brotherID);
	SisterID=(EditText)findViewById(R.id.sisterID);
	Friend1=(EditText)findViewById(R.id.friend1ID);
	Friend2=(EditText)findViewById(R.id.friend2ID);
	confirm=(Button)findViewById(R.id.button1);
	confirm.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 String filename0="mailIDs";
			 String data0=FatherID.getText().toString();
			 String data1=MotherID.getText().toString();
			 String data2=BrotherID.getText().toString();
			 String data3=SisterID.getText().toString();
			 String data4=Friend1.getText().toString();
			 String data5=Friend2.getText().toString();
                FileOutputStream fos;  
                   try {  
                       File myFile = new File("/sdcard/"+filename1);  
                        myFile.createNewFile();  
                        FileOutputStream fOut = new  FileOutputStream(myFile);  
                        OutputStreamWriter myOutWriter = new   
  
OutputStreamWriter(fOut);  
                        myOutWriter.append(data0+",");  
                       myOutWriter.append(data1+",");
                       myOutWriter.append(data2+",");
                       myOutWriter.append(data3+",");
                       myOutWriter.append(data4+",");
                       myOutWriter.append(data5);
                       myOutWriter.close();  
                        fOut.close();  
                     
            Toast.makeText(getApplicationContext(),"Ready For The Action",Toast.LENGTH_LONG).show();  
                      
                     
                   } catch (FileNotFoundException e) {e.printStackTrace();}  
                   catch (IOException e) {e.printStackTrace();}
                  
			 }
                 		
		
	});
	
	
}

	
}
