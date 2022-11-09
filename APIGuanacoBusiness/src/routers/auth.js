var { createUser } = require("../functions/user");
var express = require("express");
var jwt = require("jsonwebtoken");
require("dotenv").config();
var UserModel = require("../models/user");
var router = express.Router();

router.post("/register", createUser);
router.post("/login", async (req, res, next) => {
    try {
      let { email, password } = req.body; 
      let user = await UserModel.findOne({ email });
      if (!user)
        return res.status(400).send({
          message: "Incorrect email",
        });
      let validPassword = await user.isValidPassword(password);
      if (!validPassword)
        return res.status(400).send({
          message: "Wrong password",
        });
      let body = { _id: user._id, email: user.email };
      let token = jwt.sign(
        { user: body },
        process.env.JWT_SECRET || "TOP_SECRET"
      );
      return res.json({ token });
    } catch (err) {
      next(err);
    }
  });

  module.exports = router;