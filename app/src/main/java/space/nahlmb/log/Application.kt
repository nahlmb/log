package space.nahlmb.log

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import space.nahlmb.log.core.modules.databaseModule
import space.nahlmb.log.core.modules.noteModule
import space.nahlmb.log.core.modules.toDoModule

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        // Setup Koin
        startKoin {
            androidContext(this@Application)
            modules(
                databaseModule,
                toDoModule,
                noteModule
            )
        }

        // Be Happy
    }
}