package me.jiayu.dwapp.view

import io.dropwizard.views.View

class IndexView(val title: String = "Jiayu") : View("index.mustache")