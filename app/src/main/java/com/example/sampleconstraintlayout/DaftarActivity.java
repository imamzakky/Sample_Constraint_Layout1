package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {

    //deklarasi variabel dengan tipe data edittext
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //deklarasi variabel dengan tipe data flooating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //menghubungkan variabel
        fab=findViewById(R.id.fabSimpan);

        edtNama=findViewById(R.id.edNama);
        edtAlamat=findViewById(R.id.edAlamat);
        edtEmail=findViewById(R.id.EdEmail);
        edtPassword=findViewById(R.id.edPass);
        edtrepass=findViewById(R.id.edrepas);

        //membuat method untuk event ddari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek apakah edittext kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {

                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else{
                    //membuat kondisi untuk mengecek apakah isi dari eduttext password dan edittext repassword salah atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {

                        //menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...", Toast.LENGTH_LONG).show();


                        //method untuk kembali ke activity main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                     {

                        //menampilkan pesan bahwa isi dari edittext password dan edittext password tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}