const jobSchema = require("../models/job");
 
 // post a job
exports.createjob = async (req, res) => {
  try {
  let {title,logoimag,description,schedule,salary,worktype,department,workplace,employer,requisites }=req.body;
  let job = await jobSchema.create({title,logoimag,description,schedule,salary,worktype,department,workplace,employer,requisites});
  res.send({message:"Job created successfully",job});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

// get all jobs
exports.getall = async(req, res) => {
  try {
    let jobs = await jobSchema.find({}).populate("employer","-password")
    .populate("department").populate("worktype");
    res.send({
      count: jobs.length,
      jobs,
    });
  } catch (err) {
    res.send({ message: error });
  }
};

// get a job
exports.getjob= async (req, res) => {
  const { id } = req.params;
  jobSchema
    .findById(id)
    .then((data) => res.json(data))
    .catch((error) => res.json({ message: error }));
};

// update a job
exports.updatejob = async (req, res) => {
  const { id } = req.params;
  const {title,logoimag,description,schedule,salary,worktype,department,workplace,employer,requisites } = req.body;
  jobSchema
    .updateOne({ _id: id }, { $set: { title,logoimag,description,schedule,salary,worktype,department,workplace,employer,requisites } })
    .then((data) => res.json({message: "Job updated", user: data}))
    .catch((error) => res.json({ message: error }));
};

// delete a job
exports.deletejob = async(req, res) => {
  const { id } = req.params;
  jobSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "Job deleted", data}))
    .catch((error) => res.json({ message: error }));
};



