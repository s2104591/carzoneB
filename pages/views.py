from django.shortcuts import render, HttpResponse
from django.shortcuts import render

# Create your views here.

def index(request):
    return HttpResponse("Hello Mariano Rico, Udemey course start 10-November 2023 " )

def home(request):
    return render(request, 'pages/home.html')


def blue(request):
    return render(request, 'pages/blue.html')


