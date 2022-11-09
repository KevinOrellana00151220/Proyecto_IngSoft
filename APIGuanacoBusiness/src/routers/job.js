var {
    createjob,
    getall,
    getjob,
    updatejob,
    deletejob

}=require("../functions/job");
const express = require("express");
const router = express.Router();

router.post("/job",createjob);
router.get("/jobs",getall);
router.get("/jobs/:id",getjob);
router.put("/jobs/:id",updatejob);
router.delete("/jobs/:id",deletejob);

module.exports = router;