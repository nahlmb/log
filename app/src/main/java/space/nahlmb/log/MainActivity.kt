package space.nahlmb.log
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import space.nahlmb.log.core.base.ActivityBaseImpl
import space.nahlmb.log.core.navigation.AppNavigation
import space.nahlmb.log.core.theme.LogTheme

class MainActivity : ActivityBaseImpl() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Set Content
        setContent {

            LogTheme.MainTheme {
                AppNavigation()
            }
        }

        // Be Happy!
    }
}