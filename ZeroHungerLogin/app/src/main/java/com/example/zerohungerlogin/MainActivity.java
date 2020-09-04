package com.example.zerohungerlogin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button login,register;
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInclient;
    FirebaseAuth fauth;
    private int RC_SIGN_IN = 1;
    FirebaseUser firebaseuser;
    ProgressDialog pd;

    //private void signIn() {}

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount accCheck = GoogleSignIn.getLastSignedInAccount(this);
        if(accCheck!=null){
            startActivity(new Intent(MainActivity.this,StartActivity.class));
            Toast.makeText(getApplicationContext(),"Signed in with previous account",Toast.LENGTH_SHORT).show();
        }


        firebaseuser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseuser!= null){
            startActivity(new Intent(MainActivity.this,StartActivity.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        register = findViewById(R.id.button2);
        signInButton = findViewById(R.id.signInButton);
        fauth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInclient = GoogleSignIn.getClient(this,gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
                pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Please Wait...");
                pd.show();
            }
        });
    }
    private void signIn(){
        Intent signInIntent = mGoogleSignInclient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }
    private static JSONObject baseConfigurationJson(){
    return new JSONObject()
        .put("apiVersion",2)
        .put("apiVersionMinor",0)
        .put("allowedPaymentMethods", new JSONArray().put(getCardPaymentMethod()));
    }    
    public void donate(View view){
        
        EditText donatename = (EditText)findViewById(R.id.donatename);
        EditText donatephone = (EditText)findViewById(R.id.donatephone);
        EditText donatepay = (EditText)findViewById(R.id.donatepay);

        Toast.makeText(this,"hi"+ donatename.getText().toString() + "you are on the way to donate rupees :" + donatepay.getText().toString() ,Toast.LENGTH_LONG.show());
        private PaymentsClient paymentsClient;
        
        IsReadyTOPayRequest readyToPayrequest = IsReadyToPayRequest.fromJson(baseConfigurationJson().toString());
        
        Task<Boolean> task = paymentsClient.isReadyToPay(readyToPayRequest);
        
        task.addOnCompleteListener(this, new onCompleteListener<Boolean>(){
            
            public void onComplete(@NonNull Task<Boolean> completeTask){
                
                if(completeTask.isSuccessful()){
                    showGooglePayButton(CompleteTask.getResult());
                    
                }else{
                    
                }
            }
        });
     
        @override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            Wallet.WalletOptions walletoptions =
                new Wallet.WalletOptions.Builder()
                .setEnvironment(WalletConstants.ENVIRONMENT_TEST)
                .build();
            paymentClient = Wallet.getPaymentsClient(
                this. walletOptions);
        }
        
        

        /*int GOOGLE_PAY_REQUEST_CODE = 123;

        Uri uri =
                new Uri.Builder()
                        .scheme("upi")
                        .authority("pay")
                        .appendQueryParameter("pa", "your-merchant-vpa@xxx")
                        .appendQueryParameter("pn", "your-merchant-name")
                        .appendQueryParameter("mc", "your-merchant-code")
                        .appendQueryParameter("tr", "your-transaction-ref-id")
                        .appendQueryParameter("tn", "your-transaction-note")
                        .appendQueryParameter("am", "your-order-amount")
                        .appendQueryParameter("cu", "INR")
                        .appendQueryParameter("url", "your-transaction-url")
                        .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setPackage(GOOGLE_PAY_PACKAGE_NAME);
        activity.startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE);*/
        
    }
    
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try {
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);

            FirebaseGoogleAuth(acc);
        }
        catch (ApiException e){
            Toast.makeText(getApplicationContext(),"Sign in failed",Toast.LENGTH_SHORT).show();
            //FirebaseGoogleAuth(null);
            pd.dismiss();
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acc){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acc.getIdToken(),null);
        fauth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"Signed in Successfully",Toast.LENGTH_SHORT).show();
                    firebaseuser = fauth.getCurrentUser();
                    updateUI(firebaseuser);
                }
            }
        });
    }

    private void updateUI(FirebaseUser user){
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(account!=null){
            startActivity(new Intent(MainActivity.this,StartActivity.class));
        }

    }

}
