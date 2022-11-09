const { default: mongoose } = require("mongoose");
const worktypeSchema = require("../models/worktypes");
 
// post a worktype
exports.createWorktype = async (req, res) => {
  try {
  let { worktype }=req.body;
  let newWorktype = await worktypeSchema.create({worktype});
  res.send({message:"Worktype created successfully",newWorktype});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

// get all worktypes
exports.getAllWorktypes = async(req, res) => {
  try {
    let allWorktypes = await worktypeSchema.find({});
    res.send({
      count: allWorktypes.length,
      allWorktypes,
    });
  } catch (err) {
    res.send({ message: error });
  }
};

// get a user
exports.getworktypes= async (req, res) => {
  const { id } = req.params;
  worktypeSchema
    .findById(id)
    .then((data) => res.json(data))
    .catch((error) => res.json({ message: error }));
};

// update a worktype
exports.updateWorktype = async (req, res) => {
  const { id } = req.params;
  const { worktype } = req.body;
  worktypeSchema
    .updateOne({ _id: id }, { $set: { worktype } })
    .then((data) => res.json({message: "Worktype updated", infoWorktype: data}))
    .catch((error) => res.json({ message: error }));
};

// delete a worktype
exports.deleteWorktype = async(req, res) => {
  const { id } = req.params;
  worktypeSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "Worktype deleted", data}))
    .catch((error) => res.json({ message: error }));
};