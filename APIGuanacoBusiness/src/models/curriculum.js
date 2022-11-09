const mongoose = require("mongoose");

const Schema = mongoose.Schema;
const curriculumSchema = new Schema(
  {
    email: {
        type: String,
        required: true,
        unique: true,
      },
    fullname: {
        type: String,
        required: true,
    },
    gender: {
        type: String,
        required: true,
    },
    address: {
        type: String,
        nullable: true
    },
    phone: {
        type: String        
    },
    worktype: { 
        type: Schema.Types.ObjectId, 
        ref: "worktypes", 
        required: true 
    },
    experience: {
        type: String, 
        required: true
    },
    education: {
        type: String,
        required: true
    },
    abilities: {
        type: String,
        required: true
    },
    languages: { 
        type: String, 
        required: true 
    },

  },
  { timestamps: true }
);

module.exports = mongoose.model("curriculum",curriculumSchema);
