const mongoose = require("mongoose");
const bcrypt = require("bcrypt");

const Schema = mongoose.Schema;
const userSchema = new Schema(
  {
    username: {
      type: String,
      required: true,
      unique: true,
    },
    email: {
      type: String,
      required: true,
      unique: true,
    },
    fullname: {
      type: String,
      required: true,
    },
    password: {
      type: String,
      required: true,
    },
    imgurl:{
        type: String,
      },  
    profession: { 
      type: Schema.Types.ObjectId, 
      ref: "worktypes", 
      required: true },
    curriculum: 
      { type: Schema.Types.ObjectId, 
        ref: "curriculum", 
        nullable: true 
      },       
  },
  { timestamps: true }
);

// Always encrypt the password before save
userSchema.pre("save", async function (next) {
  const user = this;
  // Auto-generate Salt, and 10 salt rounds
  const hash = await bcrypt.hash(user.password, 10);
  user.password = hash;
  next();
});


// Helper method to validate password
userSchema.methods.isValidPassword = async function (password) {
  const user = this;
  const compare = await bcrypt.compare(password, user.password);
  return compare;
};


module.exports =  mongoose.model("user", userSchema);


