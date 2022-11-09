const { default: mongoose } = require("mongoose");
const inscriptionSchema = require("../models/inscription");
 
// post a Inscription
exports.createInscription = async (req, res) => {
  try {
  let { job, applicant, employer }=req.body;
  let inscription = await inscriptionSchema.create({job, applicant, employer});
  res.send({message:"Inscription created successfully",inscription});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

exports.getAllInscriptions = async(req, res) => {
    try {
      let inscriptions = await inscriptionSchema.find({})
      .populate("job").populate("applicant","-password").populate("employer","-password");
      res.send({
        count: inscriptions.length,
        inscriptions
      });
    } catch (err) {
      res.send({ message: error });
    }
};

// get all inscriptions of a user
exports.getAllByUserId = async (req, res) => {
  try {
    let inscription = await inscriptionSchema
    .find({applicant: req.params.id } )
    .populate("job")
    .populate("employer","-password")
    .populate("applicant","-password");
    res.send({
      count: inscription.length,
      inscription,
    });
  } catch (err) {
    res.send({ message: error });
  } 
};


// get all inscriptions of a job
exports.getAllByJobId = async (req, res) => {
    try {
      let inscription = await inscriptionSchema
      .find({job: req.params.id})
      .populate("applicant","-password")
      .populate("job")
      .populate("employer","-password");
      res.send({
        count: inscription.length,
        inscription,
      });
    } catch (err) {
      res.send({ message: error });
    } 
};

// delete a inscription
exports.deleteInscription = async(req, res) => {
  const { id } = req.params;
  inscriptionSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "Inscription deleted", data}))
    .catch((error) => res.json({ message: error }));
};