package com.example.kapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class counselor extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor);

        Button Call = (Button) findViewById(R.id.call);
        Button save_to_contact=(Button)findViewById(R.id.save_to_contact);

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Make_Call_to_Counselor();

            }
        });
        save_to_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_no_to_contact();
            }
        });

    }

    void Make_Call_to_Counselor() {
        String MObile_Number = "tel:9850870341";
        Intent call_intent = new Intent(Intent.ACTION_CALL);
        call_intent.setData(Uri.parse(MObile_Number));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        startActivity(call_intent);
    }
    void save_no_to_contact(){
        String MObile_Number = "tel:8390291933";
        String Name="Kalyani Nandeshwar Counselor";
        String Email="kalyaninandeshwar8@gmail.com";
        Intent save_to_cantact = new Intent(ContactsContract.Intents.Insert.ACTION);
        save_to_cantact.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        save_to_cantact.putExtra(ContactsContract.Intents.Insert.EMAIL,Email)
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE,ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE,MObile_Number)
                .putExtra(ContactsContract.Intents.Insert.NAME,Name) ;

        startActivity(save_to_cantact);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_CALL)
        {
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                 Make_Call_to_Counselor();
            }
            else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT);
            }
        }
    }
}
