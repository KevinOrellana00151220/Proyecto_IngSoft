var {
    getall,
    getuser,
    updateuser,
    updateuserPassword,
    deleteuser

}=require("../functions/user");
const express = require("express");
const router = express.Router();

router.get("/users",getall);
router.get("/users/:id",getuser);
router.put("/users/:id",updateuser);
router.put("/users/:id/password",updateuserPassword);
router.delete("/users/:id",deleteuser);

module.exports = router;