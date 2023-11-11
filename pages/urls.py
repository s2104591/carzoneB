# pages url

from django.urls import path
from . import views

app_name="pages"

urlpatterns=[
    path("index/",views.index, name="nm-index"),
    path("blue/",views.blue, name="nm-blue"),
    path("home/",views.home, name="nm-home"),

    
]