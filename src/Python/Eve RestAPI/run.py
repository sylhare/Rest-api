#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
Creates a REST API with Eve
http://python-eve.org/index.html

"""

from eve import Eve
app = Eve()

if __name__ == '__main__':
    app.run()
