const DepartmentSchema = require("../models/department");
 
 // post a department
exports.createdepartment = async (req, res) => {
  try {
  let { department  }=req.body;
  let newdepartment = await DepartmentSchema.create({ department });
  res.send({message:"Department created successfully",newdepartment});
  } 
  catch (error) {
    res.send({ message: error });
  }  
};

// get all departments
exports.getall = async(req, res) => {
  try {
    let newdepartment= await DepartmentSchema.find({});
    res.send({
      count: newdepartment.length,
      departments: newdepartment ,
    });
  } catch (err) {
    res.send({ message: error });
  }
};

// get a department
exports.getdepartment= async (req, res) => {
  const { id } = req.params;
  DepartmentSchema
    .findById(id)
    .then((data) => res.json(data))
    .catch((error) => res.json({ message: error }));
};

// update a department
exports.updatedepartment = async (req, res) => {
  const { id } = req.params;
  const { department } = req.body;
  DepartmentSchema
    .updateOne({ _id: id }, { $set: { department  } })
    .then((data) => res.json({message: "Department updated", user: data}))
    .catch((error) => res.json({ message: error }));
};

// delete a department
exports.deletedepartment = async(req, res) => {
  const { id } = req.params;
  DepartmentSchema
    .remove({ _id: id })
    .then((data) => res.json({message: "Department deleted", data}))
    .catch((error) => res.json({ message: error }));
};

