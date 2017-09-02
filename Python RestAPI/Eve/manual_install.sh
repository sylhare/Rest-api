#!/bin/bash 


# http://python-eve.org/install.html
# Initialized empty Git repository in ~/dev/eve/.git/
git clone http://github.com/pyeve/eve.git

pip install virtualenv

# New python executable in venv/bin/python
cd eve
virtualenv venv

. venv/bin/activate
python setup.py install