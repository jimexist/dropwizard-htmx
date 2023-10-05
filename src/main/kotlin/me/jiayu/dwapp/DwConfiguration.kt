package me.jiayu.dwapp

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.core.Configuration
import io.dropwizard.db.DataSourceFactory
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

class DwConfiguration : Configuration() {

    @NotNull @Valid @JsonProperty("database") var dataSource: DataSourceFactory? = null
}
