package fr.wildcodeschool.eateam.knowledgeishere;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import fr.wildcodeschool.eateam.knowledgeishere.DBHandler.DBHandler;
import fr.wildcodeschool.eateam.knowledgeishere.Model.LoginData;

public class SignActivity extends AppCompatActivity {
    EditText loginBox;
    EditText passwordBox;
    DBHandler mDBHandler;
    ArrayList<LoginData> loginList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        mDBHandler = new DBHandler(this);
        this.setTitle("Login");
        // check if database exist
        File database = this.getApplicationContext().getDatabasePath("database.sqlite");
        if (!database.exists()) {
            this.mDBHandler.getReadableDatabase();
            // and copy database with method
            if (!this.copyDatabase(this)) {
                Toast.makeText(this, "error cannot copy Database", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        this.loginBox = (EditText) findViewById(R.id.logintext);
        this.passwordBox = (EditText)findViewById(R.id.passwordText);
        Button signIn = (Button) findViewById(R.id.buttonSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginList = mDBHandler.getLogList();
                for (int i = 0; i< loginList.size(); i++){
                    if (loginBox.getText().toString().equals(loginList.get(i).getUsername())
                            && passwordBox.getText().toString().equals(loginList.get(i).getPassword())){
                        finish();
                        Intent intent = new Intent(SignActivity.this, SetUpActivity.class);
                        startActivity(intent);
                    }
                }
                loginBox.setHint("Wrong login or password");
                loginBox.setHintTextColor(Color.parseColor("#FF0000"));


            }
        });
    }

    //copying database from assets to database folder
    private boolean copyDatabase(Context context) {
        try {
            InputStream inpuStream = context.getAssets().open("database.sqlite");
            // set target of output
            OutputStream outputStream = new FileOutputStream(getDatabasePath("database.sqlite"));
            // buffer
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inpuStream.read(buff)) > 0) {
                //writing
                outputStream.write(buff, 0, length);

            }
            //clear buffer
            outputStream.flush();
            outputStream.close();
            Log.w("SignActivity", "DB copied");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
