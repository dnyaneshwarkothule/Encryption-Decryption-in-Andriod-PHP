package com.thewebcrafts.encryption_decryption_in_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MCrypt mcrypt = new MCrypt();

        final EditText encrypt_decrypt_input = findViewById(R.id.encrypt_decrypt_input);
        Button btn_encrypt = findViewById(R.id.btn_encrypt);
        Button btn_decrypt = findViewById(R.id.btn_decrypt);

        btn_encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    encrypt_decrypt_input.setText( MCrypt.bytesToHex( mcrypt.encrypt(String.valueOf(encrypt_decrypt_input.getText())) ) );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    encrypt_decrypt_input.setText( new String( mcrypt.decrypt( String.valueOf(encrypt_decrypt_input.getText()) ) ) );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
