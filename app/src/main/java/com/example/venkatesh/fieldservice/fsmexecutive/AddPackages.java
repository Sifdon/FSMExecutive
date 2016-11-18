package com.example.venkatesh.fieldservice.fsmexecutive;

/**
 * Created by venkatesh on 15-07-2016.
 */
        import android.app.DownloadManager;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.firebase.client.ChildEventListener;
        import com.firebase.client.Firebase;
        import com.firebase.client.FirebaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.firebase.client.ValueEventListener;
        import com.firebase.client.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import android.util.Log;

        import java.util.HashMap;
        import java.util.Map;
        import java.lang.*;
        import android.text.util.*;
        import com.firebase.client.Query;

/**
 * Created by venkatesh on 03-07-2016.
 */
public class AddPackages extends AppCompatActivity {
    private String TAG;
    Firebase ref;
    private DatabaseReference mDatabase;


    protected void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_add_packages);
        final EditText dbEmpId = (EditText) findViewById(R.id.change_status_text1);
        final EditText dbEmail = (EditText) findViewById(R.id.status_email);
        final EditText dbPackageId = (EditText) findViewById(R.id.status_packageId);
        final EditText dbPackageName = (EditText) findViewById(R.id.status_packageName);
        final EditText dbStatus = (EditText) findViewById(R.id.change_status_text);
        Button changeStatus = (Button) findViewById(R.id.btn_change_status);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://planar-cell-122112.firebaseio.com/");
        //mDatabase = FirebaseDatabase.getInstance().getReference().getRoot();
        String packageId=dbPackageId.getText().toString();
        changeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onPost(dbEmpId.getText().toString(), dbEmail.getText().toString(), dbPackageId.getText().toString(), dbPackageName.getText().toString(), dbStatus.getText().toString());
                //Toast.makeText(getApplicationContext(), "content updated", Toast.LENGTH_SHORT).show();
                dbEmail.setText("");
                dbEmpId.setText("");
                dbPackageId.setText("");
                dbPackageName.setText("");
                dbStatus.setText("");
            }
        });
    }



    void onPost(String empId, String email, String pckId, String pckName, String sts) {
        Map<String, String> obj1= new HashMap<String, String>();
        obj1.put("email",email);
        obj1.put("empid",empId);
        obj1.put("packageId",pckId);
        obj1.put("status",sts);

        Map<String, Map<String, String>> users = new HashMap<String, Map<String, String>>();
        users.put(pckName+"executive", obj1);
        Map<String,Map<String,Map<String,String>>> mobj=new HashMap<String,Map<String,Map<String,String>>>();
        mobj.put(pckName, users);
        ref.child(pckName).setValue(users);
        ref = new Firebase("https://planar-cell-122112.firebaseio.com/");
        Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();
    }//end of onPost
}//endof oncreate

