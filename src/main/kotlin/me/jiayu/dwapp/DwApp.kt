package me.jiayu.dwapp

import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.views.ViewBundle
import me.jiayu.dwapp.dao.PersonDao
import me.jiayu.dwapp.resource.PersonResource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlite3.SQLitePlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin


class DwApp : Application<DwConfiguration>() {
    override fun run(configuration: DwConfiguration, environment: Environment) {
        val factory = JdbiFactory()
        val dbi: Jdbi = factory.build(environment, configuration.dataSource, "db").apply {
            installPlugin(SQLitePlugin())
            installPlugin(KotlinSqlObjectPlugin())
        }
        val dao = dbi.onDemand(PersonDao::class.java)
        val personRes = PersonResource(dao)
        environment.jersey().register(personRes)
    }

    override fun initialize(bootstrap: Bootstrap<DwConfiguration>) {
        bootstrap.configurationSourceProvider =
            SubstitutingSourceProvider(bootstrap.configurationSourceProvider, EnvironmentVariableSubstitutor())
        bootstrap.addBundle(ViewBundle())
    }

    override fun getName() = "DwApp"
}

fun main(args: Array<String>) = DwApp().run(*args)
