const express = require('express');
const router = express.Router();
const product = require('../models/productsModel');

//http://localhost:5000/product
router.get('/product', async (req,res) =>{
    try {
        const products = await product.find();//lay toanf bo san pham
        res.json(products);
        console.log(products);
    } catch (error) {S
        console.error(error);
        res.json({error: error});
    }
});
//post
// http://localhost:5000/product
router.post('/product', async (req,res)=>{
    try {
        const {anhsp,tensp,giasp,khoiluongsp,mota} = req.body;//lay du lieu nguoi dung nhap tu react native
        const productNew = new product({anhsp,tensp,giasp,khoiluongsp,mota});// tao doi tuong moi
        await productNew.save();//luu vao bang du lieu
        res.json(productNew);// tra ve kq
        console.log(productNew);
    } catch (error) {
        console.error(error);
        res.json({error: error});
    }
});
//put
// http://localhost:5000/product/:_id
router.put('/product/:_id', async(req, res)=>{
    try {
        const _id = req.params._id;
        const {anhsp,tensp,giasp,khoiluongsp,mota} = req.body;
        const updateProduct = await product.findByIdAndUpdate(_id,{anhsp,tensp,giasp,khoiluongsp,mota},{new: true});
        res.json(updateProduct);
        console.log(updateProduct);
    } catch (error) {
        console.error(error);
        res.json({error:error});
    }
});
// delete
// http://localhost:5000/product/:_id
router.delete('/product/:_id', async (req,res)=>{
    try {
        const _id = req.params._id;
        const deleteProduct = await product.findByIdAndDelete(_id);
        res.json(deleteProduct);
        console.log(deleteProduct);
    } catch (error) {
        console.error(error);
        res.json({error:error});
    }
});
module.exports = router;