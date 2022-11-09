var {
    createWorktype,
    getAllWorktypes,
    getworktypes,
    updateWorktype,
    deleteWorktype
}=require("../functions/worktype");
const express = require("express");
const router = express.Router();

router.post("/worktype",createWorktype);
router.get("/worktypes",getAllWorktypes);
router.get("/worktypes/:id",getworktypes);
router.put("/worktypes/:id",updateWorktype);
router.delete("/worktypes/:id",deleteWorktype);

module.exports = router;