const userSchema = require("../models/user");
const bcrypt = require("bcrypt");
const { mongo } = require("mongoose");
const user = require("../models/user");
 
 // post a user
 exports.createUser = async (req, res) => {
  try {
  let {username, email, fullname, password, imgurl ,profession, curriculum  }=req.body;
  let user = await userSchema.create({username,email, fullname, password, imgurl ,profession, curriculum});
  res.send({message:"User created successfully",user});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

// get all users
exports.getall = async(req, res) => {
  try {
    let users = await userSchema.find({}, "-password").populate("curriculum").populate("profession");
    res.send({
      count: users.length,
      users,
    });
  } catch (err) {
    res.send({ message: error });
  }
};

// get a user
exports.getuser= async (req, res) => {
  const { id } = req.params;
  userSchema
    .findById(id)
    .populate("curriculum")
    .populate("profession")
    .then((data) => res.json(data))
    .catch((error) => res.json({ message: error }));
};

// update a user
exports.updateuser = async (req, res) => {
  try {
    const { id } = req.params;
    let {username,email, fullname,  imgurl ,profession, curriculum  }=req.body;
    let user = await userSchema.updateOne({_id: id}, {$set: {username,fullname, lastName,  imgurl ,profession, curriculum }});
    res.send({message:"User updated successfully",user});
    } 
    catch (error) {
      res.send({ message: error });
    }  
};

// update a password of a user
exports.updateuserPassword = async (req, res) => {
  try {
    const { id } = req.params;
    let {password}=req.body;
    const hash = await bcrypt.hash(password, 10);
    password = hash;
    let user = await userSchema.updateOne({_id: id}, {$set: { password}})
    res.send({message:"User password updated successfully",user});
    } 
    catch (error) {
      res.send({ message: error });
    }  
};

// delete a user
exports.deleteuser = async(req, res) => {
  const { id } = req.params;
  userSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "User deleted", data}))
    .catch((error) => res.json({ message: error }));
};



