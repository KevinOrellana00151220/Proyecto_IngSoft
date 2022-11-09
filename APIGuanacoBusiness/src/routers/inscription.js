var {
    getAllInscriptions,
    getAllByJobId,
    getAllByUserId,
    createInscription,
    deleteInscription
}=require("../functions/inscription");
const express = require("express");
const router = express.Router();

router.get("/inscriptions",getAllInscriptions);
router.get("/inscriptions/user/:id",getAllByUserId);
router.get("/inscriptions/job/:id",getAllByJobId);
router.post("/inscription",createInscription);
router.delete("/inscriptions/:id",deleteInscription);

module.exports = router;