package com.oscar.wallpaper_kawaii
import android.app.ProgressDialog
import android.app.WallpaperManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*;
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap
import android.os.Handler
import android.util.Log.w
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity
import java.security.Permission
import java.util.jar.Manifest


class MainActivity : PermissionsActivity() {

    var TAG: String="MAIN_ACTIVITY";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso.with(this).load(R.drawable.first).into(imageViewWallpaper);
        var progressDialog: ProgressDialog= ProgressDialog(this);



        btnWallpaper.setOnClickListener {
            requestPermissions(android.Manifest.permission.SET_WALLPAPER,object:PermissionCallBack{
                override fun permissionDenied() {
                    super.permissionDenied()
                }

                override fun permissionGranted() {
                    w(TAG,"OK")
                    progressDialog.show();
                    progressDialog.setMessage("Espera...");
                    Handler().postDelayed({
                        var wallpaperManager: WallpaperManager = WallpaperManager.getInstance(applicationContext);
                        val bmpImg = (imageViewWallpaper.drawable as BitmapDrawable).bitmap
                        wallpaperManager.setBitmap(bmpImg)
                        progressDialog.dismiss();
                    },500)
                    super.permissionGranted()

                }
            })





        }
    }
}
