const mongoose = require("mongoose");

const Schema = mongoose.Schema;
const DepartmentSchema = new Schema(
  {
    department: {
      type: String,
      required: true,
      unique: true,
    },
  }
);

const DepartmentModel = mongoose.model("department", DepartmentSchema);

module.exports = DepartmentModel;