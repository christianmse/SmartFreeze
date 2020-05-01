package com.smartfreeze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


import com.smartfreeze.domain.Producto;

import java.util.ArrayList;

public class PagoActivity extends AppCompatActivity {
    ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    Button cerrar;
    NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        int precioTotal1 = getIntent().getIntExtra("precio", 0);
        TextView PrecioTotal2;
        PrecioTotal2 = findViewById(R.id.precioTotal);
        PrecioTotal2.setText(String.valueOf(precioTotal1));



        productosSeleccionados = getIntent().getParcelableArrayListExtra("productosSeleccionados");
        int pagado = getIntent().getIntExtra("precio", 0);
        cerrar = findViewById(R.id.cerrar);
        actualizarDespensa();
        createNotificationChannel();

        final Intent intent = new Intent(this, MainActivity.class);
        notificationManager = NotificationManagerCompat.from(this);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearNotificacion();
                // notificationId is a unique int for each notification that you must define
                startActivity(intent);
            }
        });
    }

    private void crearNotificacion() {
        int id = (int) System.currentTimeMillis();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("PayMarket")
                .setContentText("PayMarket esta preparando su pedido")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("PayMarket esta preparando su pedido"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(id, builder.build());


    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "nombre";
            String description = "descripcion del canal";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void actualizarDespensa() {

    }
}
