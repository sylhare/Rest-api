# REST API

Here is a repository to experiment on REST API, what they are, how to work with it and how to create them.

### Definition

The REST style emphasizes that interactions between clients and services is enhanced by having a limited number of operations (*verbs*). 
Flexibility is provided by assigning resources (*nouns*) their own unique Universal Resource Identifiers (URIs). 

Because each *verb* has a specific meaning (GET, POST, PUT and DELETE), REST avoids ambiguity.

### REST and HTTP

REST doesn't add any specific functionality to HTTP but it is an architectural style (a common way of structuring a software system) that was developed alongside HTTP and most commonly uses its application layer protocol.

#### HTTP status codes

Status codes indicate the result of the HTTP request.

- 1XX - informational
- 2XX - success
- 3XX - redirection
- 4XX - client error
- 5XX - server error

Here are the HTTP verbs used with REST for the common operations and the status codes associated:

| HTTP Verb | CRUD   | Item (ex: /resource/id)                                                                                                                 |
|-----------|--------|-----------------------------------------------------------------------------------------------------------------------------------------|
| POST      | Create | 201 (Created) 'Location' header with link to /resource/id containing new ID. 404 (Not Found) 409 (Conflict) if resource already exists. |
| GET       | Read   | 200 (OK). 404 (Not Found) if the id not found or invalid.                                                                               |
| PUT       | Update | 200 (OK) 204 (No Content). 404 (Not Found) if the id not found or invalid.                                                              |
| DELETE    | Delete | 200 (OK). 404 (Not Found) if the id not found or invalid.                                                                               |

### RESTful Web Services (API)

RESTful APIs enable you to develop any kind of web application having all possible **CRUD** operations (create, retrieve, update, delete).

A RESTful web service (also called a RESTful web API) is a web service implemented using HTTP and the principles of REST. 
It is a collection of resources, with four defined aspects:

- the base URI for the web service, such as http://example.com/resources/
- the Internet media type of the data supported by the web service. This is often JSON, XML or YAML but can be any other valid Internet media type (MIME type).
- the set of operations supported by the web service using HTTP methods (e.g., POST, GET, PUT or DELETE).
- The API must be hypertext driven.


### Rest Examples

Here are some examples, what a REST API should look like.

If we wanted to view all resources, you should GET them at this adress:

	GET http://example.com/resources

The response can be a JSON file corresponding of the resources called. An optional parameter could be added with this format in the query string.

	GET http://example.com/resources?parameter=param

Create a new resources by posting the data:

    POST http://example.com/resources
    Data:
    	name = pineapple

To view a single resource we *GET* it by specifying that it's id specified via the URL:

	GET http://example.com/resources/id-1

*PUT* some information in that resource to update it:
    
    PUT http://example.com/resources/id-1
    Data:
    	name = banana
    	color = yellow

*DELETE* the `id-1` resource:

	DELETE http://example.com/resources/id-1


### REST Glossary

- REST: **Representational state transfer** which essentially refers to a style of web architecture that has many underlying characteristics and governs the behavior of clients and servers.
- URI: **Uniform Resource Identifier** is a string of characters used to identify a name or a resource on the Internet composed of:
	- URL: **Uniform Resource Locator** that specifies where an identified resource is available and the mechanism for retrieving it (`http://`, `ftp://`, ...)
	- URN: **Uniform Resource Name** uniquely identify what resource but does not says where to locate it. 
- Use of HTTP **HyperText Transfer Protocol** methods used:
	- GET to get the resource
    - POST to create resource
    - PUT to modify resource
    - DELETE to delete the resource.

### Source

- [Node.JS REST API](https://www.codementor.io/olatundegaruba/nodejs-restful-apis-in-10-minutes-q0sgsfhbd)
- [Python REST API](https://www.codementor.io/sagaragarwal94/building-a-basic-restful-api-in-python-58k02xsiq)
- [Java and Spring REST API](https://spring.io/guides/gs/rest-service/)
- [REST explaination](https://spring.io/understanding/REST)
- [Ruby Beginners guide to REST API](http://www.andrewhavens.com/posts/20/beginners-guide-to-creating-a-rest-api/)
- [Rest architecture style](http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
- [HTTP Methods](http://restfulapi.net/http-methods/)