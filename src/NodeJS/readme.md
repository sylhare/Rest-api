# NodeJS Todo restful API

This is a simple node js Rest API with no graphical interface, you'll only see JSON.

## Installation

Install the application:
```
npm install
```

Install mongodb (example on MacOS with brew):
```bash
brew install mongodb
```

## Getting started

Once mongodb is install, to make it work and for testing purpose you will need to specify the path for the db.
For that you can:
```bash
#Create a data folder
mkdir data
#Go in the folder and specify it as mongo dbpath
mongod --dbpath data/.
```

Now everything should work properly.
Run the application with:
```
npm run start
```

It will then run on [localhost:3000/tasks](http://localhost:3000/tasks). 

```
curl http://localhost:3000/tasks
```

It should be empty and return `[]`.

##  tasks

In order to add some tasks, you may want to post one using for exemple this cURL command:

```bash
curl -X POST \
  http://localhost:3000/tasks \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d name='this is a task'
```

To update, delete or get a specific task you can send http request to `http://localhost:3000/tasks/task_id`.
Just change the type of request and the url in the above cURL command.


## Sources

- [Olatunde Garuba - Build Node.js RESTful APIs](https://www.codementor.io/olatundegaruba/nodejs-restful-apis-in-10-minutes-q0sgsfhbd)
