const mongoose = require('mongoose');
const productSchema = new mongoose.Schema({
    anhsp:{
        type:String,
        required:true
    },
    tensp:{
        type:String,
        required:true
    },
    giasp:{
        type:String,
        required:true
    },
    khoiluongsp:{
        type:String,
        required:true
    },
    mota:{
        type:String,
        required:true
    },
});
const product = mongoose.model('products', productSchema);
module.exports = product;