var {
    createcurriculum,
    getAllcurriculums,
    getAllByUserId,
    updatecurriculum,
    deletecurriculum
    
}=require("../functions/curriculum");
const express = require("express");
const router = express.Router();

router.post("/curriculum",createcurriculum);
router.get("/curriculums",getAllcurriculums);
router.get("/curriculums/:id",getAllByUserId);
router.put("/curriculums/:id",updatecurriculum);
router.delete("/curriculums/:id",deletecurriculum);


module.exports = router;