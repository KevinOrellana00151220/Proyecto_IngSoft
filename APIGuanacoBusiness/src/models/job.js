const mongoose = require("mongoose");

const Schema = mongoose.Schema;
const jobSchema = new Schema(
  {
    title: {
      type: String,
      required: true,
    },
    logoimag: {
        type: String
    },
    description: {
        type: String,
        required: true  
    },
    schedule: {
        type: String,
        required: true
    },
    salary: {
        type: Number,
        required: true
    },
    worktype: { 
        type: Schema.Types.ObjectId, 
        ref: "worktypes", 
        required: true },

    department:{ 
        type: Schema.Types.ObjectId, 
        ref: "department", 
        required: true },

    workplace: {
        type: String,
        required: true
    },
    employer: { 
        type: Schema.Types.ObjectId, 
        ref: "user" , 
        required: true } ,
    requisites: { 
            type: String, 
            required: true 
        },  
  },
  { timestamps: true }
);

module.exports =  mongoose.model("job", jobSchema);
