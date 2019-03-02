var express    = require('express');        // call express
var app        = express();                 // define our app using express
var bodyParser = require('body-parser');
var jsondata= require('./movies.json');
var _und = require('underscore');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 8080;      

var router = express.Router();      

router.get('/', function(req, res){
res.json(jsondata);

})
router.post('/postdata', function(req,res){
if(req.body.Id && req.body.Title)
{
jsondata.push(req.body);
res.json(jsondata);
}
else
{
    console.log('please put some values to insert');
}

})
router.put('/updateapplied/:id', function(req,res){
if(req.params.id)
{
_und.each(jsondata , function(elem, index){
if(req.params.id === elem.Id){

    elem.Applied = "1";
}

})
res.json(jsondata);
}
else
{
    console.log('Invalid Request');
}

})
router.put('/updateapproved/:id', function(req,res){
if(req.params.id)
{
_und.each(jsondata , function(elem, index){
if(req.params.id === elem.Id){
    elem.Approved = "1";

}

})
res.json(jsondata);
}
else
{
    console.log('Invalid Request');
}

})

router.delete('/deletedata/:id', function(req, res) {
    getindextodelete = -1;
    if(req.params.id){

        _und.each(jsondata, function(elem,index){
if(elem.Id === req.params.id){
    getindextodelete  = index;
  

}

        })
        if(getindextodelete > -1)
        {
            jsondata.splice(getindextodelete ,1);
        }

    res.json(jsondata);   
    }
    else{
        console.log('Please pass body elements with id');
    }
});

app.use('/api', router);
app.listen(port);