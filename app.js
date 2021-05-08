const express = require("express");
const bodyParser = require("body-parser");
const http = require("http");
const app = express();

app.use(express.static(__dirname + "/views/public"));
app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({extended:true}));

app.get("/", function(req, res){
    res.render('loginpage');
});

app.post("/login", function(req, res){
    var str = "";
    if(req.body.username=="mani" && req.body.password=="mani"){
        str = "/home"
    }else{
        str = "/"
    }
    res.redirect(str);
});

app.get("/home", function(req, res){
    res.render('index', {result:"Hello"});
});


app.get("/addstock", function(req, res){
    res.render("addstock", {result:""});
});

app.post("/addStock", function(req, res){

    const data = JSON.stringify({
        size: req.body.size,
        stock: req.body.stock,
        weight: req.body.weight,
        color: req.body.color,
        gpm: req.body.gpm,
    });

    const options = {
        host: "localhost",
        port: 8002,
        path: "/addStock",
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Content-Length": data.length,
        },
        body: data
    };

    let result = "";
    const r = http.request(options, (res2) => {
        
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            console.log("Result is: " + result);
            res.render("addStock", {result:result});
        });
    });
    
    r.on("error", (err) => {
        console.log("Error: " + err.message);
        res.render("addStock", {result:"nt"});
    });
    r.write(data);
    r.end();
});

app.get("/addProduct", function(req, res){
    res.render("addProduct",{result:""});
});

app.post("/addProduct", function(req, res){

    const data = JSON.stringify({
        size: req.body.size,
        color: req.body.color,
        stock: req.body.stock,
        width: req.body.width,
        height: req.body.height,
        createdProduct: req.body.createdProduct
    });

    const options = {
        host: "localhost",
        port: 8002,
        path: "/addProduct",
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Content-Length": data.length,
        },
        body: data
    };

    const r = http.request(options, (res2) => {
        let result = "";
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            console.log("Result is: " + result);
            res.render("addProduct",{result:result});
        });
    });
    
    r.on("error", (err) => {
        console.log("Error: " + err.message);
        res.render("addProduct", {result:"nt"});
    });
    r.write(data);
    r.end();    
});

// searchers the product page and return 
app.get("/searchproduct", function(req, res){
    res.render("product", {product:""});
});

app.post("/searchproduct", function(req, res){

    var color = req.body.color;     
    var height = req.body.height;
    var width = req.body.width;

    if(!height){
        height = 0.0;
    }
    
    if(!width){
        width = 0.0;
    }

    const data = JSON.stringify({
        color: color,
        width: width,
        height: height
    });

    let options;
    
    if(req.body.searchall==''){
        options = {
            host: "localhost",
            port: 8002,
            path:"/searchProductAll",
            method: "GET"
        };

    }else{
        options = {
            host: "localhost",
            port: 8002,
            path:"/searchProduct",
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Content-Length": data.length,
            },
            body: data
        };
    }

    let result = [];
    const r = http.request(options, (res2) => {
        
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            console.log(result);
            var obj = JSON.parse(result);
            console.log(obj[0]);
            res.render("product", {product:obj});
        });
    });

    r.on("error", (err) => {
        console.log("Error: " + err.message);
    });

    r.write(data);
    r.end();

});

// searchers the row material page and return 
app.get("/searchrowmaterial", function(req, res){
    res.render("rowmaterial",{rowmaterial:""});
});

// post request to seac row material 
app.post("/searchrowmaterial", function(req, res){

    var size = req.body.size;
    var color = req.body.color;

    if(!size){
        size = 0.0;
    }

    const data = JSON.stringify({
        size: size,
        color: color,
    });

    let options; 

    if(req.body.searchall==''){
        options = {
            host: "localhost",
            port: 8002,
            path: "/searchRowAll",
            method: "GET"
        };    
    }else{
        options = {
            host: "localhost",
            port: 8002,
            path: "/searchRowMaterial",
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Content-Length": data.length,
            },
            body: req.body
        };
    }

    let result = [];
    const r = http.request(options, (res2) => {
        
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            var obj = JSON.parse(result);
            console.log(obj[0]);
            res.render("rowmaterial", {rowmaterial:obj});
        });

    });

    r.on("error", (err) => {
        console.log("Error: " + err.message);
    });

    r.write(data);
    r.end();
});

// seachstock request is manages and return search stock page and return 
app.get("/searchstock", function(req, res){
    res.render("searchstock");
});

app.get("/sellproduct", function(req, res){
    res.render("sellstock",{result:""});
});

app.post("/sellproduct", function(req, res){
    console.log(req.body);

    const data = JSON.stringify({
        customerName: req.body.customerName,
        mobileNumber: req.body.mobileNumber,
        color: req.body.color,
        width: req.body.width,
        height: req.body.height,
        date: req.body.date,
        price: req.body.price,
        stock: req.body.stock
    });

    const options = {
        host: "localhost",
        port: 8003,
        path: "/sellProduct",
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Content-Length": data.length,
        },
        body: req.body
    };

    let result = "";
    const r = http.request(options, (res2) => {
        
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            res.render("sellstock", {result:result});
        });
    });

    r.on("error", (err) => {
        console.log("Error: " + err.message);
        res.render("sellstock", {result:"nt"});
    });
    r.write(data);
    r.end();

});

app.get("/getinvoice",function(req, res){  

    const options = {
        host: "localhost",
        port: 8003,
        path: "/getInvoices",
        method: "GET",
    };

    let result = "";
    const r = http.request(options, (res2) => {
        
        res2.on("data", (chunk) => {
            result += chunk;
        });
        res2.on("end", () => {
            var obj = JSON.parse(result);
            res.render("invoice", {invoice: obj})
        });
    });

    r.on("error", (err) => {
        console.log("Error: " + err.message);
        res.render("sellstock", {invoice:""});
    });

    // r.write(data);
    r.end();
});

app.listen(3000, function(){
    console.log("Server Started At 3000");
});
