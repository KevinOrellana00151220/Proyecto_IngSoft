const mongoose = require("mongoose");

const Schema = mongoose.Schema;
const InscriptionSchema = new Schema(
  {
    job: { 
        type: Schema.Types.ObjectId, 
        ref: "job", 
        required: true },
    applicant : {
        type: Schema.Types.ObjectId,
        ref: "user",
        required: true
    },
    employer : {
        type: Schema.Types.ObjectId,
        ref: "user",
        required: true
    }   
  },
  { timestamps: true }
);

const InscriptionModel = mongoose.model("inscription", InscriptionSchema);

module.exports = InscriptionModel;