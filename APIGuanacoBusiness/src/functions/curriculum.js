const { default: mongoose } = require("mongoose");
const curriculumSchema = require("../models/curriculum");
 
// post a curriculum
exports.createcurriculum = async (req, res) => {
  try {
  let { email, fullname, gender, address, phone, worktype, experience, education, abilities,languages }=req.body;
  let curriculum = await curriculumSchema.create({email, fullname, gender, address, phone, worktype, experience, education, abilities,languages});
  res.send({message:"curriculum created successfully",curriculum});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

exports.getAllcurriculums = async(req, res) => {
    try {
      let curriculums = await curriculumSchema.find({}).populate("worktype");
      res.send({
        count: curriculums.length,
        curriculums
      });
    } catch (err) {
      res.send({ message: error });
    }
};

// get curriculums of a user
exports.getAllByUserId = async (req, res) => {
  try {
    const { id } = req.params;
    let curriculum = await curriculumSchema
    .find({id} )
    .populate("worktype")
    res.send({
      count: curriculum.length,
      curriculum,
    });
  } catch (err) {
    res.send({ message: error });
  } 
};

// update a user
exports.updatecurriculum = async (req, res) => {
    const { id } = req.params;
    const { email, fullname, gender, address, phone, worktype, experience, education, abilities,languages } = req.body;
    curriculumSchema
      .updateOne({ _id: id }, { $set: { email, fullname, gender, address, phone, worktype, experience, education, abilities,languages  } })
      .then((data) => res.json({message: "Curriculum updated", user: data}))
      .catch((error) => res.json({ message: error }));
  };


// delete a curriculum
exports.deletecurriculum = async(req, res) => {
  const { id } = req.params;
  curriculumSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "curriculum deleted", data}))
    .catch((error) => res.json({ message: error }));
};