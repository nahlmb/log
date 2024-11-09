package space.nahlmb.log.core.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

class LogTheme() {

    companion object {
        @Composable
        fun MainTheme(
            darkTheme: Boolean = isSystemInDarkTheme(),
            // Dynamic color is available on Android 12+
            dynamicColor: Boolean = true,
            content: @Composable () -> Unit
        ) {
            val colorScheme = when {
                dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                    val context = LocalContext.current
                    if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
                }

                darkTheme -> DarkColorScheme
                else -> LightColorScheme
            }

            MaterialTheme(
                colorScheme = colorScheme,
                typography = Typography,
                content = content
            )
        }

        const val PADDING_UNO = 1
        const val PADDING_EXTRA_SMALL = 2
        const val PADDING_SMALL = 4
        const val PADDING_MEDIUM = 8
        const val PADDING_LARGE = 16
        const val PADDING_EXTRA_LARGE = 32

        val COLOR_DROP = Color.Black.copy(alpha = 0.05f)
    }
}