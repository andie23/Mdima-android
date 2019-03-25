package mw.forwardplay.mdima.helpers;

import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {
    private FirebaseHelper(){}
    private static FirebaseDatabase firebaseDatabase;
    public static FirebaseDatabase getDbInstance()
    {
        if(firebaseDatabase==null){
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
        return firebaseDatabase;
    }
}
