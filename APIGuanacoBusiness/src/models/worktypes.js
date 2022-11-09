const mongoose = require("mongoose");

const Schema = mongoose.Schema;
const WorktypesSchema = new Schema(
  {
    worktype: {
      type: String,
      required: true,
      unique: true,
    },
  }
);

const WorktypesModel = mongoose.model("worktypes", WorktypesSchema);

module.exports = WorktypesModel;