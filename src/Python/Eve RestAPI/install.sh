#!/bin/bash 

# Installing Eve
pip install eve || manual_install.sh

# Running the application on http://127.0.0.1:5000/
python run.py

# Test your Api
curl -i http://localhost:5000/

