package me.jiayu.dwapp

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory
import javax.validation.Valid
import javax.validation.constraints.NotNull

class DwConfiguration : Configuration() {

    @NotNull @Valid @JsonProperty("database") var dataSource: DataSourceFactory? = null
}
