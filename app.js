const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const productRoute = require('./routes/productsRounts');

const app = express();
//ket noi mongoose
mongoose.connect('mongodb://localhost:27017/api',{
    useNewUrlParser:true,
    useUnifiedTopology:true
}).then(()=>{
    console.log("Kết nối thành công với server");

}).catch((err)=>{
    console.error(err);
});

app.use(bodyParser.urlencoded({extended:false}));
app.use(express.json());
app.use('/',productRoute);

const PORT = process.env.PORT || 5000;

app.listen(PORT, ()=>{
    console.log("server đang chạy ở cổng 5000");
});
