package me.jiayu.dwapp

import io.dropwizard.assets.AssetsBundle
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.core.Application
import io.dropwizard.core.setup.Bootstrap
import io.dropwizard.core.setup.Environment
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.views.common.ViewBundle
import me.jiayu.dwapp.dao.PersonDao
import me.jiayu.dwapp.resource.IndexResource
import me.jiayu.dwapp.resource.PersonResource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlite3.SQLitePlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin

class DwApp : Application<DwConfiguration>() {
    override fun run(configuration: DwConfiguration, environment: Environment) {
        val factory = JdbiFactory()
        val dbi: Jdbi =
            factory.build(environment, configuration.dataSource, "db").apply {
                installPlugin(SQLitePlugin())
                installPlugin(KotlinSqlObjectPlugin())
            }
        val dao = dbi.onDemand(PersonDao::class.java)
        val personRes = PersonResource(dao)
        val indexRes = IndexResource()
        environment.jersey().register(indexRes)
        environment.jersey().register(personRes)
    }

    override fun initialize(bootstrap: Bootstrap<DwConfiguration>) {
        bootstrap.configurationSourceProvider =
            SubstitutingSourceProvider(
                bootstrap.configurationSourceProvider,
                EnvironmentVariableSubstitutor()
            )
        bootstrap.addBundle(ViewBundle())
        bootstrap.addBundle(
            object : MigrationsBundle<DwConfiguration>() {
                override fun getDataSourceFactory(configuration: DwConfiguration) =
                    configuration.dataSource
            }
        )
        bootstrap.addBundle(AssetsBundle())
    }

    override fun getName() = "DwApp"
}

fun main(args: Array<String>) = DwApp().run(*args)
