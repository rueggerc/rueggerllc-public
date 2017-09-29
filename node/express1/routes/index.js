var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET helloworld page */
router.get('/helloworld', function(req, res, next) {
  res.render('helloworld', { title: 'Hello World Page' });
});

/* GET petlist page. */
router.get('/petlist', function(req, res) {
    var db = req.db;
    var collection = db.get('petcollection');
    collection.find({},{},function(e,docs){
        res.render('petlist', {
            "petlist" : docs
        });
    });
});

/* GET New Pet page. */
router.get('/newpet', function(req, res) {
    res.render('newpet', { title: 'Add New Pet' });
});

/* POST to Add User Service */
router.post('/addpet', function(req, res) {

    // Set our internal DB variable
    var db = req.db;

    // Get our form values. These rely on the "name" attributes
    var petName = req.body.petname;
    var petType = req.body.pettype;

    // Set our collection
    var collection = db.get('petcollection');

    // Submit to the DB
    collection.insert({
        "name" : petName,
        "type" : petType
    }, function (err, doc) {
        if (err) {
            // If it failed, return error
            res.send("There was a problem adding the information to the database.");
        }
        else {
            // And forward to success page
            res.redirect("petlist");
        }
    });
});



module.exports = router;
