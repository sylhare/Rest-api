'use strict';

var mongoose = require('mongoose'),
    Task = mongoose.model('Tasks');

// GET - to read all tasks
exports.list_all_tasks = function (req, res) {
    Task.find({}, function (err, task) {
        if (err)
            res.send(err);
        res.json(task);
    });
};

// POST - to create a task
exports.create_a_task = function (req, res) {
    var new_task = new Task(req.body);
    new_task.save(function (err, task) {
        if (err)
            res.send(err);
        res.json(task);
    });
};

// GET - to read the specific task
exports.read_a_task = function (req, res) {
    Task.findById(req.params.taskId, function (err, task) {
        if (err)
            res.send(err);
        res.json(task);
    });
};

// PUT - to update a task
exports.update_a_task = function (req, res) {
    Task.findOneAndUpdate({
        _id: req.params.taskId
    }, req.body, {
        new: true
    }, function (err, task) {
        if (err)
            res.send(err);
        res.json(task);
    });
};

// DELETE - to delete a task
exports.delete_a_task = function (req, res) {
    Task.remove({
        _id: req.params.taskId
    }, function (err, task) {
        if (err)
            res.send(err);
        res.json({
            message: 'Task successfully deleted'
        });
    });
};
