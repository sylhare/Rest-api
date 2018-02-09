# -*- coding: utf-8 -*-
"""

Settings for the API

"""

#API endpoints with no options and validation rules
DOMAIN = {
    'people': {},
    'books': {}
}

# Connect to Mongo
MONGO_HOST = 'localhost'
MONGO_PORT = 27017
MONGO_USERNAME = 'user'
MONGO_PASSWORD = 'user'
MONGO_DBNAME = 'apitest'

# Adding fields and validation rules for 'people' endpoint
DOMAIN['people']['schema'] = {
    'name':{
        'type': 'string',
        'maxlength': 50,
        'unique': True},
    'email': {
        'type': 'string',
        'regex': '^\S+@\S+$'},
    'location': {
        'type': 'dict',
        'schema': {
            'address': {'type': 'string'},
            'city': {'type': 'string'}}},        
    'born': {'type': 'datetime'}
}

# enable writes. default is ['GET']
# /people
RESOURCE_METHODS = ['GET', 'POST']

# /people/<id> PATCH is to update and PUT is to replace a document
ITEM_METHODS = ['GET','PATCH', 'PUT', 'DELETE']

# a few additional configuration options
DOMAIN['people'].update({
    'item_title': 'person',
    'cache_control': 'max-age=10,must-revalidate',
    'cache_expires': 10,
    'additional_lookup': {
        'url': 'regex("[\w]+")',
        'field': 'name'
    }      
})
    
