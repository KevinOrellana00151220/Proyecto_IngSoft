var {
    createdepartment,
    getall,
    getdepartment,
    updatedepartment,
    deletedepartment

}=require("../functions/department");
const express = require("express");
const router = express.Router();

router.post("/department",createdepartment);
router.get("/departments",getall);
router.get("/departments/:id",getdepartment);
router.put("/departments/:id",updatedepartment);
router.delete("/departments/:id",deletedepartment);

module.exports = router;