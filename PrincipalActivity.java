package mx.edu.hugo4295.itics.almacenamientoexterno;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;

import static android.os.Environment.getExternalStorageDirectory;

public class PrincipalActivity extends AppCompatActivity {

    boolean sdDisponible = false;
    boolean sdAccesoEscritura = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Comprobamos el estado de la memoria externa (tarjeta SD)
        String estado = Environment.getExternalStorageState();

        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
            Toast.makeText(this, "sd montada escritura lectura", Toast.LENGTH_SHORT).show();
            File nuevaCarpeta = new File(getExternalStorageDirectory(), "hugo4295");
            if (!nuevaCarpeta.exists()) {
                // nuevaCarpeta.isFile() si es archivo
                // nuevaCarpeta.isD¿irectory() si es un directorio
                Toast.makeText(this, "no existe la creamos", Toast.LENGTH_SHORT).show();
                nuevaCarpeta.mkdirs();
                Toast.makeText(this, nuevaCarpeta.getPath(), Toast.LENGTH_SHORT).show();
            }
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
            Toast.makeText(this, "sd montada lectura", Toast.LENGTH_SHORT).show();
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
            Toast.makeText(this, "no existe...", Toast.LENGTH_SHORT).show();
        }
    }
}
