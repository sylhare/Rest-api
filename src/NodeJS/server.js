var express = require('express'),
  app = express(),
  port = process.env.PORT || 3000,
  mongoose = require('mongoose'),
  Task = require('./api/models/apiModel'), //created model loading here
  bodyParser = require('body-parser');
  
// mongoose instance connection url connection
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/mongodb'); 

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var routes = require('./api/routes/apiRoutes'); //importing route
routes(app); //register the route

app.listen(port);

// For 404 pages
app.use(function (req, res) {
    res.status(404).send({
        url: req.originalUrl + ' not found'
    })
});

console.log('todo list RESTful API server started on: ' + port);
console.log('locally at: localhost:' + port + '/tasks');
