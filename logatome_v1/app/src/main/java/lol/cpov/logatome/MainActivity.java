package lol.cpov.logatome;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import asilupe.Word;

public class MainActivity extends AppCompatActivity implements View.OnDragListener, View.OnTouchListener {
    public TextView textLogatome;
    public LinearLayout textLogatomeView;
    public ImageView imgGood;
    public ImageView imgBad;
    public Button btnUpload;

    public Toast toast;

    public Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgGood = (ImageView) findViewById(R.id.imgGood);
        imgBad = (ImageView) findViewById(R.id.imgBad);
        textLogatome = (TextView) findViewById(R.id.textLogatome);
        textLogatomeView = (LinearLayout) findViewById(R.id.textLogatomeView);
        btnUpload = (Button) findViewById(R.id.btnUpload);

        textLogatomeView.setOnDragListener(this);

        imgGood.setOnTouchListener(this);
        imgBad.setOnTouchListener(this);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new uploadFile().execute();
            }
        });

        genererMot();
    }

    //http://androidsrc.net/android-view-drag-drop-functionality-sample-application/

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        View v = (View) dragEvent.getLocalState();
        if (dragEvent.getAction() == DragEvent.ACTION_DROP) {
            if (view.getId() == R.id.textLogatomeView) {
                word.setMotBien(v.getId() == R.id.imgGood);
                addToFile(exportMot());
                genererMot();
            }
        } else if (dragEvent.getAction() == DragEvent.ACTION_DRAG_ENTERED) {
            int color = v.getId() == R.id.imgGood ? Color.parseColor("#6AC259"): Color.parseColor("#F05228");
            textLogatomeView.setBackgroundColor(color);

        } else if (dragEvent.getAction() == DragEvent.ACTION_DRAG_EXITED) {
            textLogatomeView.setBackgroundColor(Color.TRANSPARENT);

        } else if (dragEvent.getAction() == DragEvent.ACTION_DRAG_ENDED) {
            textLogatomeView.setBackgroundColor(Color.TRANSPARENT);
            v.setVisibility(View.VISIBLE);
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);

            return true;
        }
        return false;
    }

    public void genererMot() {
        word = new Word();
        textLogatome.setText(word.getMotComplet());
    }

    public String exportMot() {
        String contenu = "";
        contenu += word.getMotBien().toString() + ",";
        contenu += word.getMotComplet() + ",";
        for (String phoneme : word.getPhonemes()) {
            contenu += phoneme + ",";
        }
        contenu += word.getSuffixe() + "\r\n";

        return contenu;
    }

    String filename = "mots";
    String extension = ".txt";

    public void addToFile(String contenu) {
        try {
            FileOutputStream fOut = openFileOutput(filename + extension, MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            osw.write(contenu);
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class uploadFile extends AsyncTask {

        @Override
        protected Object doInBackground(Object... objects) {

            MainActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    toast = Toast.makeText(MainActivity.this, "Tentative d'upload...",
                            Toast.LENGTH_LONG);
                    toast.show();
                    btnUpload.setEnabled(false);
                    imgGood.setEnabled(false);
                    imgBad.setEnabled(false);
                }
            });

            String resultat = "";

            FTPClient client = new FTPClient();
            Date date = new Date();
            String filenameUp;
            String[] credentials = getCredentials();

            File dir = getFilesDir();
            File file = new File(dir, filename + extension);
            try {
                client.connect(credentials[0]);
                client.enterLocalPassiveMode();
                client.login(credentials[2], credentials[3]);

                client.changeWorkingDirectory(credentials[1]);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                filenameUp = filename + " " + dateFormat.format(date) + extension;

                FileInputStream inputStream = new FileInputStream(file);
                boolean done = client.storeFile(filenameUp, inputStream);

                if (done) {
                    if(checkFileExists(filenameUp, client)) {
                        file.delete();
                        addToFile("");

                        resultat = "L'upload a fonctionné";
                    }
                }

                client.disconnect();

            } catch (IOException ex) {
                resultat = "L'upload a échoué";
                ex.printStackTrace();
            }

            final String finalResultat = resultat;
            MainActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    btnUpload.setEnabled(true);
                    imgGood.setEnabled(true);
                    imgBad.setEnabled(true);
                    toast.cancel();
                    toast = Toast.makeText(MainActivity.this, finalResultat,
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
            return null;
        }
    }

    public String[] getCredentials(){
        // Retourne les données {url, path, user, password}

        InputStream inputStream;
        BufferedReader reader;

        // Valeurs utilisées si le fichier raw/credsftp n'existe pas
        String[] credentials = {"ftp.exemple.com", "/", "user", "password"};

        // Si le fichier raw/credsftp existe, va chercher les données dedans
        /*  Structure du fichier
                url ftp + port
                ftp path
                user
                password
        */
        int credsftp = getResources().getIdentifier("credsftp", "raw", getPackageName());
        if (credsftp != 0) {
            try {
                inputStream = getResources().openRawResource(credsftp);
                reader = new BufferedReader(new InputStreamReader(inputStream));

                for (int i = 0; i < credentials.length; i++) {
                    credentials[i] = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return credentials;
    }


    public static boolean checkFileExists(String filename, FTPClient client) throws IOException {
        InputStream inputStream = client.retrieveFileStream(filename);
        int returnCode = client.getReplyCode();
        return !(inputStream == null || returnCode == 550);
    }
}