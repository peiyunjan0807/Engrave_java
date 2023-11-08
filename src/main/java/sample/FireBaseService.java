package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FireBaseService {


    public  static FirebaseDatabase db;

    public FireBaseService() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("key.json").getFile());

        FileInputStream fis = new FileInputStream(file);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(fis))
                .setDatabaseUrl("https://engrave-76611-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        db = FirebaseDatabase.getInstance();
    }

    public static FirebaseDatabase getDb() {
        return db;
    }

}
