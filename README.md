# dropwizard-htmx

[![CI](https://github.com/Jimexist/dropwizard-htmx/actions/workflows/CI.yaml/badge.svg)](https://github.com/Jimexist/dropwizard-htmx/actions/workflows/CI.yaml)

Demo app with dropwizard and HTMX.

```bash
# for building a dist tar (optional)
./gradlew distTar
# migrate db
./gradlew run --args="db migrate config.yml"
# run server
./gradlew run --args="server config.yml"
# open localhost:8080
```
