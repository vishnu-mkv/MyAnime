package com.example.myanime.providers

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.myanime.R

class FontProvider  {

    companion object {
        val GoogleFontProvider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )

        @RequiresApi(Build.VERSION_CODES.Q)
        val LogoFontFamily = FontFamily(
            Font(googleFont = GoogleFont("Josefin Sans"),
                fontProvider = GoogleFontProvider,
                )
        )

        val MontserratFontFamily = FontFamily(
            Font(googleFont = GoogleFont("Montserrat"),
                fontProvider = GoogleFontProvider,
                )
        )
    }
}

