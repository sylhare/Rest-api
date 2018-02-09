#!/bin/bash 

# Checking if python is installed
python --version

# Installing virtualenv 
# http://pythoncentral.io/how-to-install-virtualenv-python/
pip install virtualenv
#Starting the virtual environment named flask
virtualenv flask
#Installing flask in the virtual environment
flask/bin/pip install flask

python app.py

# Opening a webbrowser with the right localhost for the API
python -mwebbrowser http://localhost:5000
